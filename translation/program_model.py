# java program model


class Ty:
    """
    match ty with
    | TyInt -> int
    | TyLong -> long
    | TyByte -> byte
    | TyShort -> short
    | TyFloat -> float
    | TyDouble -> double
    | TyBool -> boolean
    | TyChar -> char
    | TyVoid -> void
    | TyString -> String
    | TyExternal -> string
    | TyArray -> ty1[]
    | TyGeneric0 -> string
    | TyGeneric1 -> string <ty1>
    | TyGeneric2 -> string <ty1, ty2>
    """

    ty = ""
    string = ""
    ty1 = None
    ty2 = None

    def __init__(self, ty, string="", ty1=None, ty2=None):
        self.ty = ty
        self.string = string
        self.ty1 = ty1
        self.ty2 = ty2

    def toString(self, printClass=False):
        """
        Returns java representation of the type.

        Args:
            printClass (bool): Whether to print the encapsulated class name for primitive types.

        Returns:
            str: The java representation of the type.
        """
        if self.ty == "TyInt":
            if printClass:
                return "Integer"
            else:
                return "int"
        elif self.ty == "TyLong":
            if printClass:
                return "Long"
            else:
                return "long"
        elif self.ty == "TyByte":
            if printClass:
                return "Byte"
            else:
                return "byte"
        elif self.ty == "TyShort":
            if printClass:
                return "Short"
            else:
                return "short"
        elif self.ty == "TyFloat":
            if printClass:
                return "Float"
            else:
                return "float"
        elif self.ty == "TyDouble":
            if printClass:
                return "Double"
            else:
                return "double"
        elif self.ty == "TyBool":
            if printClass:
                return "Boolean"
            else:
                return "boolean"
        elif self.ty == "TyChar":
            if printClass:
                return "Character"
            else:
                return "char"
        elif self.ty == "TyVoid":
            return "void"
        elif self.ty == "TyString":
            return "String"
        elif self.ty == "TyExternal":
            return self.string
        elif self.ty == "TyArray":
            return self.ty1.toString() + "[]"
        elif self.ty == "TyGeneric0":
            return self.string + "<>"
        elif self.ty == "TyGeneric1":
            return self.string + "<" + self.ty1.toString(printClass=True) + ">"
        elif self.ty == "TyGeneric2":
            return (
                self.string
                + "<"
                + self.ty1.toString(printClass=True)
                + ", "
                + self.ty2.toString(printClass=True)
                + ">"
            )
        else:
            assert False, "ty中有未知类型: " + self.ty

    def toCoq(self):
        """
        Returns the Coq representation of the type.

        Returns:
            str: The Coq representation of the type.
        """
        if self.ty == "TyExternal":
            return f'(TyExternal "{self.string}")'
        elif self.ty == "TyArray":
            return f"(TyArray {self.ty1.toCoq()})"
        elif self.ty == "TyGeneric0":
            return f'(TyGeneric0 "{self.string}")'
        elif self.ty == "TyGeneric1":
            return f'(TyGeneric1 "{self.string}" {self.ty1.toCoq()})'
        elif self.ty == "TyGeneric2":
            return f'(TyGeneric2 "{self.string}" {self.ty1.toCoq()} {self.ty2.toCoq()})'
        else:
            return self.ty


class Term:
    """
    match term with
    | TmVar -> string
    | TmNull -> null
    | TmInteger -> int_literal
    | TmFloat -> float_literal
    | TmChar -> char(int_literal)
    | TmString -> string
    | TmTrue -> true
    | TmFalse -> false

    | TmFieldAccess -> term1.string
    | TmNew -> new ty (term1)
    | TmNewArrayNoInit -> new ty [term1] / new int[1][2]
    | TmNewArrayInit -> new ty { term1 } / new int[]{1,2}
    | TmConversion -> (ty) term1
    | TmArrayAccess -> term1[term2]
    | TmMethodInvocation -> term1.string(term2)
    | TmMethodInvocationNoObject -> string(term1)
    | TmAssign -> term1 = term2
    | TmNil ->
    | TmList -> term1, term2
    | TmEmptyArray -> {}
    | TmArrayConcat -> {term1, term2}

    | TmAdd -> term1 + term2
    | TmSub -> term1 - term2
    | TmMul -> term1 * term2
    | TmDiv -> term1 / term2
    | TmMod -> term1 % term2
    | TmNeg -> -term1
    | TmShiftL -> term1 << term2
    | TmShiftR -> term1 >> term2
    | TmBitAnd -> term1 & term2
    | TmBitOr -> term1 | term2
    | TmBitXor -> term1 ^ term2
    | TmBitNot -> ~term1
    | TmPostInc -> term1++
    | TmPostDec -> term1--
    | TmPreInc -> ++term1
    | TmPreDec -> --term1

    | TmAnd -> term1 && term2
    | TmOr -> term1 || term2
    | TmNot -> !term1
    | TmEq -> term1 == term2
    | TmNe -> term1 != term2
    | TmLt -> term1 < term2
    | TmGt -> term1 > term2
    | TmLe -> term1 <= term2
    | TmGe -> term1 >= term2
    | TmChoose -> term1 ? term2 : term3
    """

    term = ""
    int_literal = None
    float_literal = None
    string = ""
    ty = None
    term1 = None
    term2 = None
    term3 = None

    def __init__(
        self,
        term,
        int_literal=None,
        float_literal=None,
        string="",
        ty=None,
        term1=None,
        term2=None,
        term3=None,
    ):
        self.term = term
        self.int_literal = int_literal
        self.float_literal = float_literal
        self.string = string
        self.ty = ty
        self.term1 = term1
        self.term2 = term2
        self.term3 = term3

    def lengthOfTermlist(self, term_list):
        """
        Calculates the length of a term_list(parameters).

        Args:
            term_list (TermList): The term_list standing for a bunch of parameters.

        Returns:
            int: The length of the term_list.
        """
        if term_list.term == "TmList":
            return 1 + self.lengthOfTermlist(term_list.term2)
        else:
            return 0

    def lengthOfArray(self, array_list):
        """
        Calculates the length of an array_literal.

        Parameters:
        array_list: The array to calculate the length of.

        Returns:
        The length of the array.
        """
        if array_list.term == "TmArrayConcat":
            return 1 + self.lengthOfArray(array_list.term2)
        else:
            return 0

    def printArrayLiteral(self, array_list):
        """
        Prints the array literal representation (in java) of the given array_list.

        Args:
            array_list: The array_list to be printed.

        Returns:
            The java representation of the array literal.
            eg. {1,2}, {5,6}, {}
        """
        if array_list.term == "TmEmptyArray":
            return ""
        elif array_list.term == "TmArrayConcat":
            if array_list.term1.term in ["TmEmptyArray", "TmArrayConcat"]:
                if self.lengthOfArray(array_list) <= 1:
                    return "{" + self.printArrayLiteral(array_list.term1) + "}"
                else:
                    return (
                        "{"
                        + self.printArrayLiteral(array_list.term1)
                        + "}, "
                        + self.printArrayLiteral(array_list.term2)
                    )
            else:
                if self.lengthOfArray(array_list) <= 1:
                    return self.printArrayLiteral(array_list.term1)
                else:
                    return (
                        self.printArrayLiteral(array_list.term1)
                        + ", "
                        + self.printArrayLiteral(array_list.term2)
                    )
        else:
            return array_list.toString()

    def toString(self, asArrayParam=False):
        """
        Converts the object to its string representation in java.

        Args:
            asArrayParam (bool, optional): Specifies whether the object(term_list) is being used as array-init parameters(or else parameters to method invocation).

        Returns:
            str: The java representation of the object.
        """
        if self.term == "TmVar":
            return self.string
        elif self.term == "TmNull":
            return "null"
        elif self.term == "TmInteger":
            return str(self.int_literal)
        elif self.term == "TmFloat":
            return str(self.float_literal)
        elif self.term == "TmString":
            return self.string
        elif self.term == "TmChar":
            return "'" + chr(self.int_literal) + "'"
        elif self.term == "TmTrue":
            return "true"
        elif self.term == "TmFalse":
            return "false"
        elif self.term == "TmFieldAccess":
            return self.term1.toString() + "." + self.string
        elif self.term == "TmNew":
            return "new " + self.ty.toString() + "(" + self.term1.toString() + ")"
        elif self.term == "TmNewArrayNoInit":
            return "new " + self.ty.toString() + self.term1.toString(asArrayParam=True)
        elif self.term == "TmNewArrayInit":
            return "new " + self.ty.toString() + self.term1.toString()
        elif self.term == "TmConversion":
            return "(" + self.ty.toString() + ") " + self.term1.toString()
        elif self.term == "TmArrayAccess":
            return self.term1.toString() + "[" + self.term2.toString() + "]"
        elif self.term == "TmMethodInvocation":
            return (
                self.term1.toString()
                + "."
                + self.string
                + "("
                + self.term2.toString()
                + ")"
            )
        elif self.term == "TmMethodInvocationNoObject":
            return self.string + "(" + self.term1.toString() + ")"
        elif self.term == "TmAssign":
            return self.term1.toString() + " = " + self.term2.toString()
        elif self.term == "TmNil":
            return ""
        elif self.term == "TmList":
            if asArrayParam:  # new int[1][2]
                return (
                    "["
                    + self.term1.toString()
                    + "]"
                    + self.term2.toString(asArrayParam=True)
                )
            else:  # arguments
                if self.lengthOfTermlist(self) <= 1:
                    return self.term1.toString()
                else:
                    return self.term1.toString() + ", " + self.term2.toString()
        elif self.term == "TmEmptyArray":
            return "{}"
        elif self.term == "TmArrayConcat":
            return "{" + self.printArrayLiteral(self) + "}"
        elif self.term == "TmAdd":
            return self.term1.toString() + " + " + self.term2.toString()
        elif self.term == "TmSub":
            return self.term1.toString() + " - " + self.term2.toString()
        elif self.term == "TmMul":
            return self.term1.toString() + " * " + self.term2.toString()
        elif self.term == "TmDiv":
            return self.term1.toString() + " / " + self.term2.toString()
        elif self.term == "TmMod":
            return self.term1.toString() + " % " + self.term2.toString()
        elif self.term == "TmNeg":
            return "-" + self.term1.toString()
        elif self.term == "TmShiftL":
            return self.term1.toString() + " << " + self.term2.toString()
        elif self.term == "TmShiftR":
            return self.term1.toString() + " >> " + self.term2.toString()
        elif self.term == "TmBitAnd":
            return self.term1.toString() + " & " + self.term2.toString()
        elif self.term == "TmBitOr":
            return self.term1.toString() + " | " + self.term2.toString()
        elif self.term == "TmBitXor":
            return self.term1.toString() + " ^ " + self.term2.toString()
        elif self.term == "TmBitNot":
            return "~" + self.term1.toString()
        elif self.term == "TmPostInc":
            return self.term1.toString() + "++"
        elif self.term == "TmPostDec":
            return self.term1.toString() + "--"
        elif self.term == "TmPreInc":
            return "++" + self.term1.toString()
        elif self.term == "TmPreDec":
            return "--" + self.term1.toString()
        elif self.term == "TmAnd":
            return self.term1.toString() + " && " + self.term2.toString()
        elif self.term == "TmOr":
            return self.term1.toString() + " || " + self.term2.toString()
        elif self.term == "TmNot":
            return "!" + self.term1.toString()
        elif self.term == "TmEq":
            return self.term1.toString() + " == " + self.term2.toString()
        elif self.term == "TmNe":
            return self.term1.toString() + " != " + self.term2.toString()
        elif self.term == "TmLt":
            return self.term1.toString() + " < " + self.term2.toString()
        elif self.term == "TmGt":
            return self.term1.toString() + " > " + self.term2.toString()
        elif self.term == "TmLe":
            return self.term1.toString() + " <= " + self.term2.toString()
        elif self.term == "TmGe":
            return self.term1.toString() + " >= " + self.term2.toString()
        elif self.term == "TmChoose":
            return (
                self.term1.toString()
                + " ? "
                + self.term2.toString()
                + " : "
                + self.term3.toString()
            )
        else:
            assert False, "term中有未知类型: " + self.term

    def toCoq(self):
        """
        Converts the current object to a CoqProof object based on the value of the 'term' attribute.

        Returns:
            CoqProof: The CoqProof object representing the current object.

        Raises:
            AssertionError: If the 'term' attribute has an unknown type.
        """
        if self.term == "TmVar":
            return CoqProof(
                "T_Var",
                params={"x": f'"{self.string}"'},
            )
        elif self.term == "TmNull":
            return CoqProof("T_Null")
        elif self.term == "TmInteger":
            return CoqProof(
                "T_Integer",
                params={"n": self.int_literal},
            )
        elif self.term == "TmFloat":
            return CoqProof(
                "T_Float",
                params={"f": f"{self.float_literal}%float"},
            )
        elif self.term == "TmString":
            return CoqProof(
                "T_String",
                params={"s": f"{self.string}"},
            )
        elif self.term == "TmChar":
            return CoqProof(
                "T_Char",
                params={"c": self.int_literal},
            )
        elif self.term == "TmTrue":
            return CoqProof("T_True")
        elif self.term == "TmFalse":
            return CoqProof("T_False")
        elif self.term == "TmFieldAccess":
            if self.term1.term == "TmVar" and self.term1.string in [
                "Math",
                "Arrays",
                "Integer",
                "Collections",
                "Character",
                "String",
                "System",
            ]:
                TyObject = Ty("TyExternal", self.term1.string)
                return CoqProof(
                    "T_TyFieldAccess",
                    params={"f": f'"{self.string}"', "T": TyObject.toCoq()},
                )
            else:
                proof1 = self.term1.toCoq()
                proof2 = CoqProof("simpl..")
                return CoqProof(
                    "T_FieldAccess",
                    params={"f": f'"{self.string}"'},
                    children=[proof1, proof2, proof2],
                )
        elif self.term == "TmNew":
            proof1 = self.term1.toCoq()
            return CoqProof(
                "T_New'",
                params={"T": self.ty.toCoq()},
                children=[proof1],
            )
        elif self.term == "TmNewArrayNoInit":
            proof1 = self.term1.toCoq()
            if self.term1.term == "TmNil":  # new int a
                return CoqProof(
                    "T_NewArrayNoInit",
                    params={"T": self.ty.toCoq()},
                )
            else:  # new int a[1][2]
                tm1, tm2 = self.term1.term1, self.term1.term2
                proof1 = tm1.toCoq()
                proof2 = Term("TmNewArrayNoInit", term1=tm2, ty=self.ty).toCoq()
                return CoqProof(
                    "T_NewArrayNoInit'",
                    params={"T": self.ty.toCoq()},
                    children=[proof1, proof2],
                )
        elif self.term == "TmNewArrayInit":
            proof1 = self.term1.toCoq()
            return CoqProof(
                "T_NewArrayInit",
                params={"T": self.ty.toCoq()},
                children=[proof1],
            )
        elif self.term == "TmConversion":
            proof1 = self.term1.toCoq()
            return CoqProof(
                "T_Conversion",
                params={"T": self.ty.toCoq()},
                children=[proof1],
            )
        elif self.term == "TmArrayAccess":
            proof1 = self.term1.toCoq()
            proof2 = self.term2.toCoq()
            return CoqProof(
                "T_ArrayAccess",
                children=[proof1, proof2],
            )
        elif self.term == "TmMethodInvocation":
            # is actually a method invocation by type name (Math.max(1, 2))
            if self.term1.term == "TmVar" and self.term1.string in [
                "Math",
                "Arrays",
                "Integer",
                "Collections",
                "Character",
                "String",
                "System",
            ]:
                TyObject = Ty("TyExternal", self.term1.string)
                return CoqProof(
                    "T_TyMethodInvocation",
                    params={"m": f'"{self.string}"', "T": TyObject.toCoq()},
                    children=[self.term2.toCoq(), CoqProof("simpl..")],
                )
            else:
                proof1 = self.term1.toCoq()
                proof2 = self.term2.toCoq()
                return CoqProof(
                    "T_MethodInvocation",
                    params={"m": f'"{self.string}"'},
                    children=[proof1,CoqProof("simpl.."),CoqProof("simpl.."), proof2,CoqProof("simpl..")],
                )
        elif self.term == "TmMethodInvocationNoObject":
            proof1 = self.term1.toCoq()
            return CoqProof(
                "T_MethodInvocationNoObj",
                params={"m": f'"{self.string}"'},
                children=[proof1],
            )
        elif self.term == "TmAssign":
            proof1 = self.term1.toCoq()
            proof2 = self.term2.toCoq()
            return CoqProof(
                "T_Assign",
                children=[proof1, proof2],
            )
        elif self.term == "TmNil":
            return CoqProof("T_Nil")
        elif self.term == "TmList":
            proof1 = self.term1.toCoq()
            proof2 = self.term2.toCoq()
            return CoqProof(
                "T_List",
                children=[proof1, proof2],
            )
        elif self.term == "TmEmptyArray":
            return CoqProof("T_EmptyArray")
        elif self.term == "TmArrayConcat":
            proof1 = self.term1.toCoq()
            proof2 = self.term2.toCoq()
            return CoqProof(
                "T_ArrayConcat",
                children=[proof1, proof2],
            )
        elif self.term == "TmSub":
            proof1 = self.term1.toCoq()
            proof2 = self.term2.toCoq()
            return CoqProof(
                "T_Sub",
                children=[proof1, proof2, CoqProof("simpl..")],
            )
        elif self.term in [
            "TmAdd",
            "TmMul",
            "TmDiv",
            "TmMod",
            "TmShiftL",
            "TmShiftR",
            "TmBitAnd",
            "TmBitOr",
            "TmBitXor",
            "TmEq",
            "TmNe",
            "TmLt",
            "TmGt",
            "TmLe",
            "TmGe",
            "TmAnd",
            "TmOr",
        ]:  # binary operation
            proof1 = self.term1.toCoq()
            proof2 = self.term2.toCoq()
            return CoqProof(
                f"T_{self.term[2:]}",
                children=[proof1, proof2],
            )
        elif self.term in [
            "TmNeg",
            "TmNot",
            "TmPostInc",
            "TmPostDec",
            "TmPreInc",
            "TmPreDec",
            "TmBitNot",
        ]:  # unary operation
            proof1 = self.term1.toCoq()
            return CoqProof(
                f"T_{self.term[2:]}",
                children=[proof1],
            )
        elif self.term == "TmChoose":
            proof1 = self.term1.toCoq()
            proof2 = self.term2.toCoq()
            proof3 = self.term3.toCoq()
            return CoqProof(
                "T_Choose",
                children=[proof1, proof2, proof3],
            )
        else:
            assert False, "term中有未知类型: " + self.term


class Statement:
    """
    match statement with
    | StSkip ->
    | StDeclNoInit -> ty string ;
    | StDeclInit -> ty string = term ;
    | StExpression -> term ;
    | StIf -> if ( term ) { statement1 }
    | StIfElse -> if ( term ) { statement1 } else { statement2 }
    | StWhile -> while ( term ) { statement1 }
    | StDoWhile -> do { statement1 } while ( term ) ;
    | StFor -> for ( statement1 ; term ; update_term ) { statement2 }
    | StForeach -> for ( ty string : term ) { statement1 }
    | StReturn -> return term ;
    | StContinue -> continue ;
    | StBreak -> break ;
    | StConcat -> statement1 statement2
    """

    statement = ""
    term = None
    update_term = None
    ty = None
    string = ""
    statement1 = None
    statement2 = None
    statement3 = None

    def __init__(
        self,
        statement,
        term=None,
        update_term=None,
        ty=None,
        string="",
        statement1=None,
        statement2=None,
        statement3=None,
    ):
        self.statement = statement
        self.term = term
        self.update_term = update_term
        self.ty = ty
        self.string = string
        self.statement1 = statement1
        self.statement2 = statement2
        self.statement3 = statement3

    def lengthOfStatementlist(self, statement_list):
        if statement_list.statement == "StConcat":
            return 1 + self.lengthOfStatementlist(statement_list.statement2)
        else:
            return 0

    def toString(self, asArgument=False):
        if self.statement == "StSkip":
            return ""
        elif self.statement == "StDeclNoInit":
            if asArgument:
                return self.ty.toString() + " " + self.string
            else:
                return self.ty.toString() + " " + self.string + ";"
        elif self.statement == "StDeclInit":
            return (
                self.ty.toString()
                + " "
                + self.string
                + " = "
                + self.term.toString()
                + ";"
            )
        elif self.statement == "StExpression":
            return self.term.toString() + ";"
        elif self.statement == "StIf":
            return (
                "if ( "
                + self.term.toString()
                + " ) {\n"
                + self.statement1.toString()
                + "\n}"
            )
        elif self.statement == "StIfElse":
            return (
                "if ( "
                + self.term.toString()
                + " ) {\n"
                + self.statement1.toString()
                + "\n} else {\n"
                + self.statement2.toString()
                + "\n}"
            )
        elif self.statement == "StWhile":
            return (
                "while ( "
                + self.term.toString()
                + " ) {\n"
                + self.statement1.toString()
                + "\n}"
            )
        elif self.statement == "StDoWhile":
            return (
                "do {\n"
                + self.statement1.toString()
                + "\n} while ( "
                + self.term.toString()
                + " );"
            )
        elif self.statement == "StFor":
            return (
                "for ( "
                + self.statement1.toString()
                # + "; "
                + self.term.toString()
                + "; "
                + self.update_term.toString()
                + " ) {\n"
                + self.statement2.toString()
                + "\n}"
            )
        elif self.statement == "StForeach":
            return (
                "for ( "
                + self.ty.toString()
                + " "
                + self.string
                + " : "
                + self.term.toString()
                + " ) {\n"
                + self.statement1.toString()
                + "\n}"
            )
        elif self.statement == "StReturn":
            return "return " + self.term.toString() + ";"
        elif self.statement == "StContinue":
            return "continue;"
        elif self.statement == "StBreak":
            return "break;"
        elif self.statement == "StConcat":
            if asArgument:
                if self.lengthOfStatementlist(self) <= 1:
                    return self.statement1.toString(asArgument=asArgument)
                else:
                    return (
                        self.statement1.toString(asArgument=asArgument)
                        + ", "
                        + self.statement2.toString(asArgument=asArgument)
                    )
            else:
                if self.lengthOfStatementlist(self) <= 1:
                    return self.statement1.toString() + self.statement2.toString()
                else:
                    return (
                        self.statement1.toString() + "\n" + self.statement2.toString()
                    )
        else:
            assert False, "statement中有未知类型: " + self.statement

    def toCoq(self):
        if self.statement == "StSkip":
            return CoqProof("T_Skip")
        elif self.statement == "StDeclNoInit":
            return CoqProof(
                "T_DeclNoInit",
                params={"T": self.ty.toCoq(), "x": f'"{self.string}"'},
            )
        elif self.statement == "StDeclInit":
            return CoqProof(
                "T_DeclInit",
                params={"T": self.ty.toCoq(), "x": f'"{self.string}"'},
                children=[self.term.toCoq(), CoqProof("simpl..")],
            )
        elif self.statement == "StExpression":
            return CoqProof("T_Expression", children=[self.term.toCoq()])
        elif self.statement == "StIf":
            return CoqProof(
                "T_If",
                children=[self.term.toCoq(), self.statement1.toCoq()],
            )
        elif self.statement == "StIfElse":
            return CoqProof(
                "T_IfElse",
                children=[
                    self.term.toCoq(),
                    self.statement1.toCoq(),
                    self.statement2.toCoq(),
                ],
            )
        elif self.statement == "StWhile":
            return CoqProof(
                "T_While",
                children=[self.term.toCoq(), self.statement1.toCoq()],
            )
        elif self.statement == "StDoWhile":
            return CoqProof(
                "T_DoWhile",
                children=[self.statement1.toCoq(), self.term.toCoq()],
            )
        elif self.statement == "StFor":
            return CoqProof(
                "T_For",
                children=[
                    self.statement1.toCoq(),
                    self.term.toCoq(),
                    self.update_term.toCoq(),
                    self.statement2.toCoq(),
                ],
            )
        elif self.statement == "StForeach":
            return CoqProof(
                "T_Foreach",
                params={"T": self.ty.toCoq(), "x": f'"{self.string}"'},
                children=[
                    self.term.toCoq(),
                    CoqProof("simpl.."),
                    self.statement1.toCoq(),
                ],
            )
        elif self.statement == "StReturn":
            return CoqProof(
                "T_Return",
                children=[self.term.toCoq(), CoqProof("simpl..")],
            )
        elif self.statement == "StContinue":
            return CoqProof("T_Continue")
        elif self.statement == "StBreak":
            return CoqProof("T_Break")
        elif self.statement == "StConcat":
            proof1 = self.statement1.toCoq()
            proof2 = self.statement2.toCoq()
            return CoqProof("T_Concat", children=[proof1, proof2])


class ClassComponent:
    """
    match classcomponent with
    | MethodDecl -> string1 ty string2 ( statement1 ) { statement2 }
    | FieldDeclNoInit -> string1 ty string2;
    | FieldDeclInit -> string1 ty string2 = term;
    | ConstructorDecl -> Constructor( statement1 ) { statement2 }
    | ComponentConcat -> classcomponent1 classcomponent2
    """

    classcomponent = ""
    string1 = ""
    ty = None
    string2 = ""
    term = None
    statement1 = None
    statement2 = None
    classcomponent1 = None
    classcomponent2 = None

    def __init__(
        self,
        classcomponent,
        string1="",
        ty=None,
        string2="",
        term=None,
        statement1=None,
        statement2=None,
        classcomponent1=None,
        classcomponent2=None,
    ):
        self.classcomponent = classcomponent
        self.string1 = string1
        self.ty = ty
        self.string2 = string2
        self.term = term
        self.statement1 = statement1
        self.statement2 = statement2
        self.classcomponent1 = classcomponent1
        self.classcomponent2 = classcomponent2

    def toString(self, class_name="Solution"):
        if self.classcomponent == "MethodDecl":
            return (
                self.string1
                + " "
                + self.ty.toString()
                + " "
                + self.string2
                + "("
                + self.statement1.toString(asArgument=True)
                + ") {\n"
                + self.statement2.toString()
                + "\n}"
            )
        elif self.classcomponent == "FieldDeclNoInit":
            if self.string1 == "":  # no modifier
                return self.ty.toString() + " " + self.string2 + ";"
            else:
                return (
                    self.string1 + " " + self.ty.toString() + " " + self.string2 + ";"
                )
        elif self.classcomponent == "FieldDeclInit":
            if self.string1 == "":  # no modifier
                return (
                    self.ty.toString()
                    + " "
                    + self.string2
                    + " = "
                    + self.term.toString()
                    + ";"
                )
            else:
                return (
                    self.string1
                    + " "
                    + self.ty.toString()
                    + " "
                    + self.string2
                    + " = "
                    + self.term.toString()
                    + ";"
                )
        elif self.classcomponent == "ConstructorDecl":
            return (
                class_name
                + "("
                + self.statement1.toString(asArgument=True)
                + ") {\n"
                + self.statement2.toString()
                + "\n}"
            )
        elif self.classcomponent == "ComponentConcat":
            return (
                self.classcomponent1.toString(class_name=class_name)
                + "\n"
                + self.classcomponent2.toString(class_name=class_name)
            )
        else:
            assert False, "classcomponent中有未知类型: " + self.classcomponent

    def toCoq(self):
        if self.classcomponent == "MethodDecl":
            proof1 = CoqProof(
                "T_MethodDecl",
                params={
                    "modif": f'"{self.string1}"',
                    "T": self.ty.toCoq(),
                    "m": f'"{self.string2}"',
                },
                children=[self.statement1.toCoq(), self.statement2.toCoq()],
            )
            return proof1
        elif self.classcomponent == "FieldDeclNoInit":
            return CoqProof(
                "T_FieldDeclNoInit",
                params={
                    "modif": f'"{self.string1}"',
                    "T": self.ty.toCoq(),
                    "x": f'"{self.string2}"',
                },
            )
        elif self.classcomponent == "FieldDeclInit":
            return CoqProof(
                "T_FieldDeclInit",
                params={
                    "modif": f'"{self.string1}"',
                    "T": self.ty.toCoq(),
                    "x": f'"{self.string2}"',
                },
                children=[self.term.toCoq(), CoqProof("simpl..")],
            )
        elif self.classcomponent == "ConstructorDecl":
            return CoqProof(
                "T_ConstructorDecl",
                children=[self.statement1.toCoq(), self.statement2.toCoq()],
            )
        elif self.classcomponent == "ComponentConcat":
            proof1 = self.classcomponent1.toCoq()
            proof2 = self.classcomponent2.toCoq()
            return CoqProof("T_ComponentConcat", children=[proof1, proof2])


class Program:
    """
    match program with
    | ProgramConcat -> program1 ; program2
    | ImportDecl -> import string1 . string2
    | ClassDecl -> string1 class string2 { classcomponent }
    """

    program = ""
    string1 = ""
    string2 = ""
    classcomponent = None
    program1 = None
    program2 = None

    def __init__(
        self,
        program,
        string1="",
        string2="",
        classcomponent=None,
        program1=None,
        program2=None,
    ):
        self.program = program
        self.string1 = string1
        self.string2 = string2
        self.classcomponent = classcomponent
        self.program1 = program1
        self.program2 = program2

    def toString(self):
        if self.program == "ProgramConcat":
            return self.program1.toString() + "\n" + self.program2.toString()
        elif self.program == "ImportDecl":
            return "import " + self.string1 + "." + self.string2 + ";"
        elif self.program == "ClassDecl":
            if self.string1 == "":
                return (
                    "class "
                    + self.string2
                    + " {\n"
                    + self.classcomponent.toString(class_name=self.string2)
                    + "\n}"
                )
            else:
                return (
                    self.string1
                    + " class "
                    + self.string2
                    + " {\n"
                    + self.classcomponent.toString(class_name=self.string1)
                    + "\n}"
                )
        else:
            assert False, "program中有未知类型: " + self.program

    def toCoq(self):
        if self.program == "ProgramConcat":
            proof1 = self.program1.toCoq()
            proof2 = self.program2.toCoq()
            return CoqProof("T_ProgramConcat", children=[proof1, proof2])
        elif self.program == "ImportDecl":
            return CoqProof(
                "T_ImportDecl",
                params={"n1": f'"{self.string1}"', "n2": f'"{self.string2}"'},
            )
        elif self.program == "ClassDecl":
            return CoqProof(
                "T_ClassDecl",
                params={"name": f'"{self.string2}"'},
                children=[self.classcomponent.toCoq()],
            )


class CoqProof:
    isEapply = False
    tactic = ""
    params = {}
    children = []

    def __init__(self, tactic, params={}, children=[]):
        if tactic[:2] == "T_":  # tactic starts with T_
            self.isEapply = True
        self.tactic = tactic
        self.params = params
        self.children = children

    def toString(self, indent=0):
        proof_str = "  " * indent
        indent_len = len(proof_str)

        # main proof sentence
        if self.isEapply:
            if len(self.params.keys()) == 0:
                proof_str += "eapply " + self.tactic + "..."
            else:
                proof_str += (
                    "eapply "
                    + self.tactic
                    + " with"
                    + "".join([f"({k}:={self.params[k]})" for k in self.params])
                    + "..."
                )
        else:
            proof_str += self.tactic + "."

        # append proof of children
        if len(self.children) == 1:
            child_proof = self.children[0].toString(indent)
            proof_str += f"\n{child_proof}"
        else:
            for child in self.children:
                child_proof = child.toString(indent + 1)[indent_len + 2 :]
                proof_str += f"\n{' '*indent_len}{{ {child_proof} }}"

        return proof_str


if __name__ == "__main__":
    coq_proof1 = CoqProof("reflexivity")
    coq_proof2 = CoqProof("T_Integer", params={"n": 0})
    coq_proof3 = CoqProof("T_Return", children=[coq_proof2, coq_proof1])
    coq_proof4 = CoqProof("T_Skip")
    coq_proof5 = CoqProof(
        "T_MethodDecl",
        params={"modif": '""', "T": "TyInt", "m": "main"},
        children=[coq_proof1, coq_proof4, coq_proof1, coq_proof3],
    )
    coq_proof6 = CoqProof(
        "T_ClassDecl", params={"name": '"Solution"'}, children=[coq_proof1, coq_proof5]
    )
    coq_proof7 = CoqProof("eexists", sibling=coq_proof6)
    coq_proof8 = CoqProof("eexists", sibling=coq_proof7)
    coq_proof9 = CoqProof("unfold program_well_typed", sibling=coq_proof8)
    print(coq_proof9.toString())
