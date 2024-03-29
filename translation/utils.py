from program_model import *

source_code_line = None


# pretty print the sexp
def format_code(code):
    formatted_code = ""
    indent_level = 0
    for i, char in enumerate(code):
        if char == " ":
            if code[i - 1] != ":":
                formatted_code += "\n" + "    " * (indent_level + 1)
            else:
                formatted_code += " "
            if code[i + 1] == "(":
                indent_level += 1
        elif char == ")":
            indent_level -= 1
            formatted_code += ")\n"
            if i + 1 < len(code) and code[i + 1] == ")":
                formatted_code += "    " * (indent_level)
        else:
            formatted_code += char
    # remove blank lines
    formatted_code = "\n".join(
        [line for line in formatted_code.split("\n") if line.strip() != ""]
    )
    return formatted_code


# add proper indentation to the code
def addIndentation(code):
    formatted_code = ""
    code = code.split("\n")
    indent_level = 0
    indent_code = "    "
    for line in code:
        if "}" in line and "{" not in line:
            indent_level -= 1
            formatted_code += indent_code * indent_level + line + "\n"
        elif "{" in line and "}" not in line:
            formatted_code += indent_code * indent_level + line + "\n"
            indent_level += 1
        else:
            formatted_code += indent_code * indent_level + line + "\n"
    return formatted_code


def getcode_from_beginandend(source_code_line, begin, end):
    code_lines = source_code_line[begin[0] : end[0] + 1]
    if begin[0] == end[0]:
        code_lines[0] = code_lines[0][begin[1] : end[1]]
    else:
        code_lines[0] = code_lines[0][begin[1] :]
        code_lines[-1] = code_lines[-1][: end[1]]
    return "\n".join(code_lines)


def getcode_from_node(source_code_line, node):
    return getcode_from_beginandend(source_code_line, node.start_point, node.end_point)


type_list = [
    "integral_type",
    "floating_point_type",
    "boolean_type",
    "void_type",
    "generic_type",
    "array_type",
    "type_identifier",
]
primary_type_list = [
    "identifier",
    "field_access",
    "array_access",
    "method_invocation",
    "object_creation_expression",
    "array_creation_expression",
    "this",
]
literal_list = [
    "character_literal",
    "string_literal",
    "decimal_integer_literal",
    "decimal_floating_point_literal",
    "false",
    "true",
    "null_literal",
    "binary_integer_literal",
    "octal_integer_literal",
    "hex_integer_literal",
    "hex_floating_point_literal",
]
expression_list = (
    [
        "binary_expression",
        "unary_expression",
        "assignment_expression",
        "update_expression",
        "parenthesized_expression",
        "cast_expression",
    ]
    + literal_list
    + primary_type_list
)


# translating the tree-sitter AST to the java program model
def visit_program(node):
    named_child_count = node.named_child_count
    program_return = None
    for i in range(named_child_count - 1, -1, -1):
        child = node.named_child(i)
        if child.type == "line_comment":
            continue
        elif child.type == "block_comment":
            continue
        if child.type == "import_declaration":
            program_get = visit_import_declaration(child)
        elif child.type == "class_declaration":
            program_get = visit_class_declaration(child)
        else:
            assert False, (
                "program中有未知类型"
                + child.type
                + " "
                + getcode_from_node(source_code_line, child)
            )

        if program_return is None:
            program_return = program_get
        else:
            program_return = Program(
                "ProgramConcat", program1=program_get, program2=program_return
            )
    return program_return


def visit_import_declaration(node):
    named_child_count = node.named_child_count
    if named_child_count == 1:
        start_point = node.named_children[0].start_point
        end_point = node.named_children[0].end_point
        import_string = getcode_from_beginandend(
            source_code_line, start_point, end_point
        )
        last_dot_index = import_string.rfind(".")

        assert last_dot_index != -1, "字符串中没有找到'.'"

        import_string0 = import_string[:last_dot_index]  # 获取最后一个`.`之前的部分
        import_string1 = import_string[
            last_dot_index + 1 :
        ]  # 获取最后一个`.`之后的部分

    elif named_child_count == 2:
        start_point0 = node.named_children[0].start_point
        end_point0 = node.named_children[0].end_point
        import_string0 = getcode_from_beginandend(
            source_code_line, start_point0, end_point0
        )

        start_point1 = node.named_children[1].start_point
        end_point1 = node.named_children[1].end_point
        import_string1 = getcode_from_beginandend(
            source_code_line, start_point1, end_point1
        )

    return Program("ImportDecl", string1=import_string0, string2=import_string1)


def visit_class_declaration(node):
    named_child_count = node.named_child_count
    modifier = ""
    if named_child_count == 2:
        start_point = node.named_children[0].start_point
        end_point = node.named_children[0].end_point
        class_name = getcode_from_beginandend(source_code_line, start_point, end_point)
        classcomponent = visit_classcomponent(node.named_children[1])
    elif named_child_count == 3 and node.named_children[0].type == "modifiers":
        modifier = getcode_from_node(source_code_line, node.named_children[0])
        start_point = node.named_children[1].start_point
        end_point = node.named_children[1].end_point
        class_name = getcode_from_beginandend(source_code_line, start_point, end_point)
        classcomponent = visit_classcomponent(node.named_children[2])
    else:
        assert False, f"classdeclaration中有未知类型:{node.named_children[0].type}"
    return Program(
        "ClassDecl", string1=modifier, string2=class_name, classcomponent=classcomponent
    )


def visit_classcomponent(node):
    named_child_count = node.named_child_count
    classcomponent_return = None
    component_list = []
    for i in range(named_child_count - 1, -1, -1):
        child = node.named_child(i)
        if child.type == "line_comment":
            continue
        elif child.type == "block_comment":
            continue
        elif child.type == "method_declaration":
            classcomponent_get = visit_method_declaration(child)
        elif child.type == "field_declaration":
            classcomponent_get = visit_field_declaration(child)
        elif child.type == "constructor_declaration":
            classcomponent_get = visit_constructor_declaration(child)
        else:
            assert False, (
                "classcomponent中有未知类型"
                + child.type
                + " "
                + getcode_from_node(source_code_line, child)
            )
        component_list.append(classcomponent_get)

    # change the order of the components
    # fields -> constructors -> methods
    # if method m1 uses method m2, then m2 should be defined before m1
    def cmp(c1, c2):
        if c1.classcomponent == "FieldDeclNoInit":
            return -1
        elif c2.classcomponent == "FieldDeclNoInit":
            return 1
        elif c1.classcomponent == "FieldDeclInit":
            return -1
        elif c2.classcomponent == "FieldDeclInit":
            return 1
        else:
            c1_name, c2_name = c1.string2 + "(", c2.string2 + "("
            if c1.classcomponent == "MethodDecl" and c1_name in c2.toString():
                return -1
            elif c2.classcomponent == "MethodDecl" and c2_name in c1.toString():
                return 1
            else:
                return 0

    new_list = []
    while len(component_list) > 0:
        success = False
        for i in range(len(component_list)):
            comp = component_list[i]
            # no component else that should be swaped with comp
            if len([comp2 for comp2 in component_list if cmp(comp, comp2) == 1]) == 0:
                new_list.append(comp)
                component_list.remove(comp)
                success = True
                # print(comp.string2)
                break
        if not success:
            assert False, "cyclic dependency in class components"
    for component in reversed(new_list):
        if classcomponent_return is None:
            classcomponent_return = component
        else:
            classcomponent_return = ClassComponent(
                "ComponentConcat",
                classcomponent1=component,
                classcomponent2=classcomponent_return,
            )

    return classcomponent_return


def visit_method_declaration(node):
    named_child_count = node.named_child_count

    modifier = ""
    ty = None
    method_name = ""
    formal_parameters = None
    block = None

    for i in range(named_child_count):
        if node.named_children[i].type == "modifiers":
            start_point = node.named_children[0].start_point
            end_point = node.named_children[0].end_point
            modifier = getcode_from_beginandend(
                source_code_line, start_point, end_point
            )

        elif node.named_children[i].type in type_list:
            ty = visit_type(node.named_children[i])

        elif node.named_children[i].type == "identifier":
            start_point = node.named_children[i].start_point
            end_point = node.named_children[i].end_point
            method_name = getcode_from_beginandend(
                source_code_line, start_point, end_point
            )

        elif node.named_children[i].type == "formal_parameters":
            formal_parameters = visit_formal_parameters(node.named_children[i])

        elif node.named_children[i].type == "block":
            block = visit_block(node.named_children[i])

        else:
            assert False, "methoddecl中有未知类型"

    return ClassComponent(
        "MethodDecl",
        string1=modifier,
        ty=ty,
        string2=method_name,
        statement1=formal_parameters,
        statement2=block,
    )


def visit_field_declaration(node):
    named_child_count = node.named_child_count

    modifier = ""
    ty = None
    field_name = ""
    term = None
    for i in range(named_child_count):
        if node.named_children[i].type == "modifiers":
            modifier = getcode_from_node(source_code_line, node.named_children[i])
        elif node.named_children[i].type in type_list:
            ty = visit_type(node.named_children[i])
        elif node.named_children[i].type == "variable_declarator":
            # a[]={}
            field_name = getcode_from_node(
                source_code_line, node.named_children[i].named_children[0]
            )
            for child_varDecl in node.named_children[i].named_children[1:]:
                if child_varDecl.type == "dimensions":
                    # a[][];
                    for child in child_varDecl.children:
                        if child.type == "]":
                            ty = Ty("TyArray", ty1=ty)
                else:
                    # a = 1;
                    term = visit_expression(child_varDecl)
        else:
            assert False, "fielddecl中有未知类型"
    if term:
        return ClassComponent(
            "FieldDeclInit", string1=modifier, ty=ty, string2=field_name, term=term
        )
    else:
        return ClassComponent(
            "FieldDeclNoInit", string1=modifier, ty=ty, string2=field_name
        )


def visit_constructor_declaration(node):
    formal_parameters = None
    constructor_body = None
    for child in node.named_children:
        if child.type == "modifiers":
            continue  # TODO
        elif child.type == "identifier":
            continue
        elif child.type == "formal_parameters":
            formal_parameters = visit_formal_parameters(child)
        elif child.type == "constructor_body":
            constructor_body = visit_block(child)
        else:
            assert False, "constructordecl中有未知类型"
    return ClassComponent(
        "ConstructorDecl", statement1=formal_parameters, statement2=constructor_body
    )


def visit_formal_parameters(node):
    named_child_count = node.named_child_count
    formal_parameters_return = Statement("StSkip")
    for i in range(named_child_count - 1, -1, -1):
        child = node.named_child(i)
        if child.type == "formal_parameter":
            formal_parameters_get = visit_formal_parameter(child)
        else:
            assert False, (
                "formalparameters中有未知类型"
                + child.type
                + " "
                + getcode_from_node(source_code_line, child)
            )

        if formal_parameters_return is None:
            formal_parameters_return = formal_parameters_get
        else:
            formal_parameters_return = Statement(
                "StConcat",
                statement1=formal_parameters_get,
                statement2=formal_parameters_return,
            )
    return formal_parameters_return


def visit_formal_parameter(node):
    ty = None
    formal_parameter = ""
    named_children = [
        child
        for child in node.named_children
        if child.type not in ["line_comment", "block_comment", "modifiers"]
    ]
    named_child_count = len(named_children)
    for i in range(named_child_count):
        if named_children[i].type in type_list:
            ty = visit_type(named_children[i])

        elif named_children[i].type == "identifier":
            start_point = named_children[i].start_point
            end_point = named_children[i].end_point
            formal_parameter = getcode_from_beginandend(
                source_code_line, start_point, end_point
            )
        elif named_children[i].type == "dimensions":
            for child in named_children[i].children:
                if child.type == "]":
                    ty = Ty("TyArray", ty1=ty)

        else:
            assert False, (
                "formalparameter中有未知类型"
                + named_children[i].type
                + " "
                + getcode_from_node(source_code_line, named_children[i])
            )
    return Statement("StDeclNoInit", ty=ty, string=formal_parameter)


def visit_type(node):
    type_name = getcode_from_node(source_code_line, node)
    if node.type == "integral_type":
        if type_name == "long":
            return Ty("TyLong")
        elif type_name == "byte":
            return Ty("TyByte")
        elif type_name == "short":
            return Ty("TyShort")
        elif type_name == "char":
            return Ty("TyChar")
        else:
            return Ty("TyInt")
    elif node.type == "floating_point_type":
        if type_name == "double":
            return Ty("TyDouble")
        else:
            return Ty("TyFloat")
    elif node.type == "boolean_type":
        return Ty("TyBool")
    elif node.type == "void_type":
        return Ty("TyVoid")
    elif node.type == "generic_type":
        return visit_generic_type(node)
    elif node.type == "type_identifier":
        start_point = node.start_point
        end_point = node.end_point
        string1 = getcode_from_beginandend(source_code_line, start_point, end_point)
        if string1 == "Integer":
            return Ty("TyInt")
        elif string1 == "String":
            return Ty("TyString")
        elif string1 == "Double":
            return Ty("TyFloat")
        elif string1 == "double":
            return Ty("TyFloat")
        elif string1 == "Float":
            return Ty("TyFloat")
        elif string1 == "Long":
            return Ty("TyLong")
        elif string1 == "Boolean":
            return Ty("TyBool")
        else:
            return Ty("TyExternal", string=string1)
    elif node.type == "array_type":
        ty = visit_type(node.named_children[0])
        if node.named_children[1].type == "dimensions":
            for child in node.named_children[1].children:
                if child.type == "[":
                    continue
                elif child.type == "]":
                    ty = Ty("TyArray", ty1=ty)
        else:
            assert False, "arraytype中有未知类型"
        return ty

    else:
        assert False, "type中有未知类型"


def visit_generic_type(node):
    string1 = ""
    ty1 = None
    ty2 = None
    for child in node.named_children:
        if child.type == "type_identifier":
            start_point = child.start_point
            end_point = child.end_point
            string1 = getcode_from_beginandend(source_code_line, start_point, end_point)
        elif child.type == "type_arguments":
            named_child_count = child.named_child_count

            if named_child_count == 1:
                ty1 = visit_type(child.named_children[0])
                return Ty("TyGeneric1", string=string1, ty1=ty1)
            elif named_child_count == 2:
                ty1 = visit_type(child.named_children[0])
                ty2 = visit_type(child.named_children[1])
                return Ty("TyGeneric2", string=string1, ty1=ty1, ty2=ty2)
            elif named_child_count == 0:
                return Ty("TyGeneric0", string=string1)
            else:
                assert (
                    False
                ), "generic_type中typearguments子节点数量不对" + getcode_from_node(
                    source_code_line, child
                )
        else:
            assert False, (
                "generic_type中有未知类型"
                + child.type
                + " "
                + getcode_from_node(source_code_line, child)
            )


def count_no_commet_child(node):
    count = 0
    non_comment_child = []
    for child in node.named_children:
        if child.type == "line_comment":
            continue
        elif child.type == "block_comment":
            continue
        else:
            non_comment_child.append(child)
            count += 1
    return count, non_comment_child


def visit_statement(node):
    if node.type == "if_statement":
        return visit_if_statement(node)
    elif node.type == "while_statement":
        return visit_while_statement(node)
    elif node.type == "return_statement":
        return visit_return_statement(node)
    elif node.type == "for_statement":
        return visit_for_statement(node)
    elif node.type == "local_variable_declaration":
        return visit_local_variable_declaration(node)
    elif node.type == "expression_statement":
        return visit_expression_statement(node)
    elif node.type == "block":
        return visit_block(node)
    elif node.type == "enhanced_for_statement":
        return visit_enhanced_for_statement(node)
    elif node.type == "continue_statement":
        return Statement("StContinue")
    elif node.type == "break_statement":
        return Statement("StBreak")
    elif node.type == "do_statement":
        return visit_do_statement(node)
    else:
        assert False, (
            "statement中有未知类型"
            + node.type
            + " "
            + getcode_from_node(source_code_line, node)
        )


def visit_block(node):
    named_child_count = node.named_child_count
    block_return = Statement("StSkip")
    for i in range(named_child_count - 1, -1, -1):
        child = node.named_child(i)
        if child.type == "line_comment":
            continue
        elif child.type == "block_comment":
            continue
        block_get = visit_statement(child)

        if block_return is None:
            block_return = block_get
        else:
            block_return = Statement(
                "StConcat", statement1=block_get, statement2=block_return
            )

    return block_return


def visit_if_statement(node):

    named_child_count, children = count_no_commet_child(node)

    if named_child_count == 2:
        term = visit_expression(children[0].named_children[0])
        statement = visit_statement(children[1])
        return Statement("StIf", term=term, statement1=statement)

    elif named_child_count == 3:
        term = visit_expression(children[0].named_children[0])
        statement = visit_statement(children[1])
        else_statement = visit_statement(children[2])
        return Statement(
            "StIfElse", term=term, statement1=statement, statement2=else_statement
        )

    else:
        assert False, "ifstatement中有未知类型" + getcode_from_node(
            source_code_line, node
        )


def visit_while_statement(node):
    named_child_count = node.named_child_count
    if named_child_count == 2:
        term = visit_expression(node.named_children[0].named_children[0])
        statement = visit_statement(node.named_children[1])
    else:
        assert False, "whilestatement中有未知类型"

    return Statement("StWhile", term=term, statement1=statement)


def visit_return_statement(node):
    named_child_count = node.named_child_count
    if named_child_count == 1:
        term = visit_expression(node.named_children[0])
    elif named_child_count == 0:
        term = Term("TmNil")
    else:
        assert False, "returnstatement中有未知类型" + getcode_from_node(
            source_code_line, node
        )

    return Statement("StReturn", term=term)


def visit_local_variable_declaration(node):
    ty = None
    string = ""
    term = None
    statement_return = Statement("StSkip")
    named_children = [
        child
        for child in node.named_children
        if child.type not in ["line_comment", "block_comment", "modifiers"]
    ]
    named_child_count = len(named_children)
    if named_children[0].type in type_list:
        ty = visit_type(named_children[0])
    else:
        assert False, "localvariabledeclaration中有未知Ty类型" + named_children[0].type

    for i in range(named_child_count - 1, 0, -1):
        if named_children[i].type == "variable_declarator":
            string = getcode_from_node(
                source_code_line, named_children[i].named_children[0]
            )
            tmp_ty = ty
            # int a;
            if named_children[i].named_child_count == 1:
                term = None
            # int a=1; / int a[];
            elif named_children[i].named_child_count == 2:
                if named_children[i].named_children[1].type == "dimensions":
                    for child in named_children[i].named_children[1].children:
                        if child.type == "]":
                            tmp_ty = Ty("TyArray", ty1=tmp_ty)
                else:
                    term = visit_expression(named_children[i].named_children[1])
            # int a[] = {1,2,3};
            elif named_children[i].named_child_count == 3:
                for child in named_children[i].named_children[1].children:
                    if child.type == "]":
                        tmp_ty = Ty("TyArray", ty1=tmp_ty)
                term = visit_expression(named_children[i].named_children[2])
            else:
                assert False, (
                    "localvariabledeclaration中内部有未知子节点"
                    + named_children[i].type
                )

            if term is None:
                statement_return = Statement(
                    "StConcat",
                    statement1=Statement("StDeclNoInit", ty=tmp_ty, string=string),
                    statement2=statement_return,
                )
            else:
                statement_return = Statement(
                    "StConcat",
                    statement1=Statement(
                        "StDeclInit", ty=tmp_ty, string=string, term=term
                    ),
                    statement2=statement_return,
                )
        else:
            assert False, (
                "localvariabledeclaration中有未知节点" + named_children[i].type
            )

    return statement_return


def visit_for_statement(node):
    local_variable_declaration = Statement("StSkip")
    expression = Term("TmNull")
    update_expression = Term("TmNull")
    for child in node.named_children[:-1]:
        if child.type == "local_variable_declaration":
            local_variable_declaration = visit_local_variable_declaration(child)
        elif child.type == "binary_expression":
            expression = visit_expression(child)
        elif child.type == "update_expression":
            update_expression = visit_expression(child)

    statement = visit_statement(node.named_children[-1])
    return Statement(
        "StFor",
        statement1=local_variable_declaration,
        term=expression,
        update_term=update_expression,
        statement2=statement,
    )


def visit_do_statement(node):
    named_child_count = node.named_child_count
    if named_child_count == 2:
        statement = visit_statement(node.named_children[0])
        term = visit_expression(node.named_children[1])
    else:
        assert False, "dostatement中有未知类型"

    return Statement("StDoWhile", term=term, statement1=statement)


def visit_enhanced_for_statement(node):
    ty = None
    string = ""
    term = None
    statement = None
    # remove comment
    named_children = [
        child
        for child in node.named_children
        if child.type not in ["line_comment", "block_comment", "modifiers"]
    ]
    for child in named_children[:-2]:
        if child.type in type_list:
            ty = visit_type(child)
        elif child.type == "identifier":
            start_point = child.start_point
            end_point = child.end_point
            string = getcode_from_beginandend(source_code_line, start_point, end_point)
        else:
            assert False, (
                "enhancedforstatement中有未知类型"
                + child.type
                + " "
                + getcode_from_node(source_code_line, child)
            )
    term = visit_expression(named_children[-2])
    statement = visit_statement(node.named_children[-1])
    return Statement("StForeach", ty=ty, string=string, term=term, statement1=statement)


def visit_expression_statement(node):
    named_child_count = node.named_child_count
    if named_child_count == 1:
        term = visit_expression(node.named_children[0])
    else:
        assert False, "expressionstatement中有未知类型"

    return Statement("StExpression", term=term)


def visit_expression(node):
    if node.type == "binary_expression":
        return visit_binary_expression(node)
    elif node.type == "unary_expression":
        return visit_unary_expression(node)
    elif node.type == "assignment_expression":
        return visit_assignment_expression(node)
    elif node.type == "update_expression":
        return visit_update_expression(node)
    elif node.type == "parenthesized_expression":
        return visit_expression(node.named_children[0])
    elif node.type in literal_list:
        return visit_literal(node)
    elif node.type in primary_type_list:
        return visit_primary_expression(node)
    elif node.type == "cast_expression":
        if node.named_child_count == 2:
            return Term(
                "TmConversion",
                ty=visit_type(node.named_children[0]),
                term1=visit_expression(node.named_children[1]),
            )
        else:
            assert False, "castexpression子节点数量不对"
    elif node.type == "ternary_expression":
        if node.named_child_count == 3:
            return Term(
                "TmChoose",
                term1=visit_expression(node.named_children[0]),
                term2=visit_expression(node.named_children[1]),
                term3=visit_expression(node.named_children[2]),
            )
        else:
            assert False, "ternaryexpression子节点数量不对"
    elif node.type == "array_initializer":
        return visit_array_initializer(node)
    else:
        assert False, (
            "expression中有未知类型:"
            + node.type
            + " "
            + getcode_from_node(source_code_line, node)
        )


def visit_primary_expression(node):
    if node.type == "array_access":
        return visit_array_access(node)
    elif node.type == "identifier":
        return Term("TmVar", string=getcode_from_node(source_code_line, node))
    elif node.type == "field_access":
        term1 = visit_primary_expression(node.named_children[0])
        string1 = getcode_from_node(source_code_line, node.named_children[1])
        return Term("TmFieldAccess", term1=term1, string=string1)
    elif node.type == "method_invocation":
        return visit_method_invocation(node)
    elif node.type == "object_creation_expression":
        ty1 = visit_type(node.named_children[0])
        term1 = visit_argument_list(node.named_children[1])
        return Term("TmNew", ty=ty1, term1=term1)
    elif node.type == "array_creation_expression":
        return visit_array_creation_expression(node)
    elif node.type == "this":
        return Term("TmVar", string="this")
    elif node.type in literal_list:
        return visit_literal(node)
    else:
        assert False, (
            "primaryexpression中有未知类型:"
            + node.type
            + " "
            + getcode_from_node(source_code_line, node)
        )


def visit_array_initializer(node):
    term_return = Term("TmEmptyArray")
    for i in range(node.named_child_count - 1, -1, -1):
        if node.named_children[i].type == "array_initializer":
            term_get = visit_array_initializer(node.named_children[i])
        elif node.named_children[i].type in expression_list:
            term_get = visit_expression(node.named_children[i])
        else:
            assert False, (
                "arrayinitializer中有未知类型"
                + node.named_children[i].type
                + " "
                + getcode_from_node(source_code_line, node.named_children[i])
            )
        if term_return is None:
            term_return = term_get
        else:
            term_return = Term("TmArrayConcat", term1=term_get, term2=term_return)
    return term_return


def visit_array_creation_expression(node):
    ty1 = visit_type(node.named_children[0])
    if node.named_children[1].type == "dimensions_expr":
        # new a[2][3]
        termlist = Term("TmNil")
        for i in range(node.named_child_count - 1, 0, -1):
            if node.named_children[i].type == "dimensions_expr":
                termget = visit_expression(node.named_children[i].named_children[0])
                if termlist is None:
                    termlist = termget
                else:
                    termlist = Term("TmList", term1=termget, term2=termlist)
            else:
                assert False, (
                    "arraycreationexpression中有未知类型"
                    + node.named_children[i].type
                    + " "
                    + getcode_from_node(source_code_line, node.named_children[i])
                )
        return Term("TmNewArrayNoInit", ty=ty1, term1=termlist)
    elif node.named_children[1].type == "dimensions":
        # new a[]{1,2}
        for child in node.named_children[1].children:
            if child.type == "[":
                continue
            elif child.type == "]":
                ty1 = Ty("TyArray", ty1=ty1)
        if node.named_children[2].type == "array_initializer":
            termlist = visit_array_initializer(node.named_children[2])
        else:
            assert (
                False
            ), "arraycreationexpression第二个子节点不是arrayinitializer" + getcode_from_node(
                source_code_line, node.named_children[2]
            )
        return Term("TmNewArrayInit", ty=ty1, term1=termlist)
    else:
        assert False, (
            "arraycreationexpression中有未知类型"
            + node.named_children[1].type
            + " "
            + getcode_from_node(source_code_line, node.named_children[1])
        )


def visit_array_access(node):
    if node.named_child_count == 2:
        term1 = visit_primary_expression(node.named_children[0])
        term2 = visit_expression(node.named_children[1])
        return Term("TmArrayAccess", term1=term1, term2=term2)
    else:
        assert False, "arrayaccess子节点数量不对" + getcode_from_node(
            source_code_line, node
        )


def visit_method_invocation(node):
    if node.named_child_count == 3:
        term1 = visit_primary_expression(node.named_children[0])
        string1 = getcode_from_node(source_code_line, node.named_children[1])
        term2 = visit_argument_list(node.named_children[2])
        return Term("TmMethodInvocation", term1=term1, string=string1, term2=term2)
    elif node.named_child_count == 2:
        string1 = getcode_from_node(source_code_line, node.named_children[0])
        term1 = visit_argument_list(node.named_children[1])
        return Term("TmMethodInvocationNoObject", term1=term1, string=string1)
    else:
        assert False, "methodinvocation子节点数量不对" + getcode_from_node(
            source_code_line, node
        )


def visit_argument_list(node):
    named_child_count = node.named_child_count
    argument_list_return = Term("TmNil")
    for i in range(named_child_count - 1, -1, -1):
        child = node.named_child(i)
        argument_list_get = visit_expression(child)
        if argument_list_return is None:
            argument_list_return = argument_list_get
        else:
            argument_list_return = Term(
                "TmList", term1=argument_list_get, term2=argument_list_return
            )
    return argument_list_return


def visit_literal(node):
    if node.type == "decimal_integer_literal":
        literal = getcode_from_node(source_code_line, node)
        # remove the alphabet suffix
        if literal[-1].isalpha():
            literal = literal[:-1]
        int_literal = int(literal)
        return Term("TmInteger", int_literal=int_literal)
    elif node.type == "hex_integer_literal":
        literal = getcode_from_node(source_code_line, node)
        int_literal = int(literal, 16)
        return Term("TmInteger", int_literal=int_literal)
    elif node.type == "decimal_floating_point_literal":
        float_literal = float(getcode_from_node(source_code_line, node))
        return Term("TmFloat", float_literal=float_literal)
    elif node.type == "character_literal":
        return Term(
            "TmChar", int_literal=ord(getcode_from_node(source_code_line, node)[1])
        )
    elif node.type == "true":
        return Term("TmTrue")
    elif node.type == "false":
        return Term("TmFalse")
    elif node.type == "null_literal":
        return Term("TmNull")
    elif node.type == "string_literal":
        return Term("TmString", string=getcode_from_node(source_code_line, node))
    else:
        assert False, (
            "literal中有未知类型"
            + node.type
            + " "
            + getcode_from_node(source_code_line, node)
        )


def visit_binary_expression(node):
    if node.child_count == 3:
        term1 = visit_expression(node.children[0])
        term2 = visit_expression(node.children[2])
        string1 = getcode_from_node(source_code_line, node.children[1])
    else:
        assert False, "binaryexpression子节点数量不对"
    if string1 == "+":
        return Term("TmAdd", term1=term1, term2=term2)
    elif string1 == "-":
        return Term("TmSub", term1=term1, term2=term2)
    elif string1 == "*":
        return Term("TmMul", term1=term1, term2=term2)
    elif string1 == "/":
        return Term("TmDiv", term1=term1, term2=term2)
    elif string1 == "%":
        return Term("TmMod", term1=term1, term2=term2)
    elif string1 == "<<":
        return Term("TmShiftL", term1=term1, term2=term2)
    elif string1 == ">>":
        return Term("TmShiftR", term1=term1, term2=term2)
    elif string1 == "&":
        return Term("TmBitAnd", term1=term1, term2=term2)
    elif string1 == "|":
        return Term("TmBitOr", term1=term1, term2=term2)
    elif string1 == "^":
        return Term("TmBitXor", term1=term1, term2=term2)

    elif string1 == "==":
        return Term("TmEq", term1=term1, term2=term2)
    elif string1 == "!=":
        return Term("TmNe", term1=term1, term2=term2)
    elif string1 == "<":
        return Term("TmLt", term1=term1, term2=term2)
    elif string1 == "<=":
        return Term("TmLe", term1=term1, term2=term2)
    elif string1 == ">":
        return Term("TmGt", term1=term1, term2=term2)
    elif string1 == ">=":
        return Term("TmGe", term1=term1, term2=term2)
    elif string1 == "&&":
        return Term("TmAnd", term1=term1, term2=term2)
    elif string1 == "||":
        return Term("TmOr", term1=term1, term2=term2)


def visit_unary_expression(node):
    if node.child_count == 2:
        term = visit_expression(node.children[1])
        string1 = getcode_from_node(source_code_line, node.children[0])
    else:
        assert False, "unaryexpression子节点数量不对"
    if string1 == "-":
        return Term("TmNeg", term1=term)
    elif string1 == "!":
        return Term("TmNot", term1=term)
    elif string1 == "~":
        return Term("TmBitNot", term1=term)


def visit_assignment_expression(node):
    if node.child_count == 3:
        if node.children[0].type in primary_type_list:
            term1 = visit_primary_expression(node.children[0])
            term2 = visit_expression(node.children[2])
            string2 = getcode_from_node(source_code_line, node.children[1])
        else:
            assert False, "assignmentexpression中第一个子节点不是identifier, 未定义类型"
    else:
        assert False, "assignmentexpression子节点数量不对"

    if string2 == "=":
        return Term("TmAssign", term1=term1, term2=term2)
    elif string2 == "+=":
        return Term(
            "TmAssign", term1=term1, term2=Term("TmAdd", term1=term1, term2=term2)
        )
    elif string2 == "-=":
        return Term(
            "TmAssign", term1=term1, term2=Term("TmSub", term1=term1, term2=term2)
        )
    elif string2 == "*=":
        return Term(
            "TmAssign", term1=term1, term2=Term("TmMul", term1=term1, term2=term2)
        )
    elif string2 == "/=":
        return Term(
            "TmAssign", term1=term1, term2=Term("TmDiv", term1=term1, term2=term2)
        )
    elif string2 == "%=":
        return Term(
            "TmAssign", term1=term1, term2=Term("TmMod", term1=term1, term2=term2)
        )
    elif string2 == "<<=":
        return Term(
            "TmAssign", term1=term1, term2=Term("TmShiftL", term1=term1, term2=term2)
        )
    elif string2 == ">>=":
        return Term(
            "TmAssign", term1=term1, term2=Term("TmShiftR", term1=term1, term2=term2)
        )
    elif string2 == "&=":
        return Term(
            "TmAssign", term1=term1, term2=Term("TmBitAnd", term1=term1, term2=term2)
        )
    elif string2 == "|=":
        return Term(
            "TmAssign", term1=term1, term2=Term("TmBitOr", term1=term1, term2=term2)
        )
    elif string2 == "^=":
        return Term(
            "TmAssign", term1=term1, term2=Term("TmBitXor", term1=term1, term2=term2)
        )
    else:
        assert False, "assignmentexpression中未知赋值符号"


def visit_update_expression(node):
    if node.child_count == 2:
        if node.children[0].type in primary_type_list:
            term1 = visit_primary_expression(node.children[0])
            if node.children[1].type == "++":
                return Term("TmPostInc", term1=term1)
            elif node.children[1].type == "--":
                return Term("TmPostDec", term1=term1)
        elif node.children[1].type in primary_type_list:
            term1 = visit_primary_expression(node.children[1])
            if node.children[0].type == "++":
                return Term("TmPreInc", term1=term1)
            elif node.children[0].type == "--":
                return Term("TmPreDec", term1=term1)
        else:
            assert (
                False
            ), "updateexpression中前两个子节点不是identifier, 未定义类型" + getcode_from_node(
                source_code_line, node
            )

    else:
        assert False, "updateexpression子节点数量不对"
