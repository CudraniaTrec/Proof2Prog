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
    | TmInstanceOf -> term1 instanceof ty
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
        parenthesized=False,
    ):
        self.term = term
        self.int_literal = int_literal
        self.float_literal = float_literal
        self.string = string
        self.ty = ty
        self.term1 = term1
        self.term2 = term2
        self.term3 = term3
        self.parenthesized = parenthesized

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

    def toStringMain(self, asArrayParam=False):
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
            return "((" + self.ty.toString() + ") " + self.term1.toString()+")"
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
            #print += ... as x = x + ...
            if self.term1.term == "TmVar" and self.term2.term in ["TmAdd", "TmSub", "TmMul", "TmDiv"]:
                if self.term2.term1.term == "TmVar" and self.term2.term1.string == self.term1.string:
                    operator = self.term2.term
                    if operator == "TmAdd":
                        operator = "+="
                    elif operator == "TmSub":
                        operator = "-="
                    elif operator == "TmMul":
                        operator = "*="
                    elif operator == "TmDiv":
                        operator = "/="
                    else:
                        assert False, "term中有未知类型: " + self.term2.term
                    return self.term1.toString() + " " + operator + " " + self.term2.term2.toString()

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
            return f"( {self.term1.toString()} + {self.term2.toString()} )"
        elif self.term == "TmSub":
            return f"( {self.term1.toString()} - {self.term2.toString()} )"
        elif self.term == "TmMul":
            return f"{self.term1.toString()} * {self.term2.toString()}"
        elif self.term == "TmDiv":
            return f"{self.term1.toString()} / {self.term2.toString()}"
        elif self.term == "TmMod":
            return f"{self.term1.toString()} % {self.term2.toString()}"
        elif self.term == "TmNeg":
            return f"(-{self.term1.toString()})"
        elif self.term == "TmShiftL":
            return f"({self.term1.toString()} << {self.term2.toString()})"
        elif self.term == "TmShiftR":
            return f"({self.term1.toString()} >> {self.term2.toString()})"
        elif self.term == "TmBitAnd":
            return f"({self.term1.toString()} & {self.term2.toString()})"
        elif self.term == "TmBitOr":
            return f"({self.term1.toString()} | {self.term2.toString()})"
        elif self.term == "TmBitXor":
            return f"({self.term1.toString()} ^ {self.term2.toString()})"
        elif self.term == "TmBitNot":
            return f"(~{self.term1.toString()})"
        elif self.term == "TmPostInc":
            return self.term1.toString() + "++"
        elif self.term == "TmPostDec":
            return self.term1.toString() + "--"
        elif self.term == "TmPreInc":
            return "++" + self.term1.toString()
        elif self.term == "TmPreDec":
            return "--" + self.term1.toString()
        elif self.term == "TmAnd":
            return f"{self.term1.toString()} && {self.term2.toString()} "
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
            return f"({self.term1.toString()} ? {self.term2.toString()} : {self.term3.toString()})"
        elif self.term == "TmInstanceOf":
            return f"({self.term1.toString()} instanceof {self.ty.toString(printClass=True)})"
        else:
            assert False, "term中有未知类型: " + self.term

    def toString(self, asArrayParam=False):
        if self.parenthesized:
            return "(" + self.toStringMain(asArrayParam=asArrayParam) + ")"
        else:
            return self.toStringMain(asArrayParam=asArrayParam)

    def toCoq(self):
        Coqsimpl = CoqProof("simpl. try reflexivity")
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
                children=[CoqProof("simpl. try reflexivity")],
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
                "Integer",
                "Byte",
                "Short",
                "Long",
                "Boolean",
                "Double",
                "Float",
                "Character",
                "String",
                "Math",
                "Fraction",
                "Arrays",
                "Collections",
                "System",
                "java",
                "Pattern" "Comparator",
                "BigInteger",
            ]:
                TyObject = Ty("TyExternal", self.term1.string)
                return CoqProof(
                    "T_TyFieldAccess",
                    params={"f": f'"{self.string}"', "T": TyObject},
                    children=[Coqsimpl, Coqsimpl],
                )
            else:
                proof1 = self.term1.toCoq()
                return CoqProof(
                    "T_FieldAccess",
                    params={"f": f'"{self.string}"'},
                    children=[proof1, Coqsimpl, Coqsimpl],
                )
        elif self.term == "TmNew":
            proof1 = self.term1.toCoq()
            return CoqProof(
                "T_New'",
                params={"T": self.ty},
                children=[Coqsimpl, proof1],
            )
        elif self.term == "TmNewArrayNoInit":
            proof1 = self.term1.toCoq()
            if self.term1.term == "TmNil":  # new int a
                return CoqProof(
                    "T_NewArrayNoInit",
                    params={"T": self.ty},
                )
            else:  # new int a[1][2]
                tm1, tm2 = self.term1.term1, self.term1.term2
                proof1 = tm1.toCoq()
                proof2 = Term("TmNewArrayNoInit", term1=tm2, ty=self.ty).toCoq()
                return CoqProof(
                    "T_NewArrayNoInit'",
                    params={"T": self.ty},
                    children=[proof1, proof2],
                )
        elif self.term == "TmNewArrayInit":
            proof1 = self.term1.toCoq()
            return CoqProof(
                "T_NewArrayInit",
                params={"T": self.ty},
                children=[Coqsimpl, proof1],
            )
        elif self.term == "TmConversion":
            proof1 = self.term1.toCoq()
            return CoqProof(
                "T_Conversion",
                params={"T": self.ty},
                children=[proof1, Coqsimpl],
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
                "Integer",
                "Byte",
                "Short",
                "Long",
                "Boolean",
                "Double",
                "Float",
                "Character",
                "String",
                "Math",
                "Fraction",
                "Arrays",
                "Collections",
                "System",
                "java",
                "Pattern",
                "Comparator",
                "BigInteger",
            ]:
                TyObject = Ty("TyExternal", self.term1.string)
                return CoqProof(
                    "T_TyMethodInvocation",
                    params={"m": f'"{self.string}"', "T": TyObject},
                    children=[Coqsimpl, Coqsimpl, self.term2.toCoq(), Coqsimpl],
                )
            else:
                proof1 = self.term1.toCoq()
                proof2 = self.term2.toCoq()
                return CoqProof(
                    "T_MethodInvocation",
                    params={"m": f'"{self.string}"'},
                    children=[proof1, Coqsimpl, Coqsimpl, proof2, Coqsimpl],
                )
        elif self.term == "TmMethodInvocationNoObject":
            proof1 = self.term1.toCoq()
            return CoqProof(
                "T_MethodInvocationNoObj",
                params={"m": f'"{self.string}"'},
                children=[Coqsimpl, proof1, Coqsimpl],
            )
        elif self.term == "TmAssign":
            proof1 = self.term1.toCoq()
            proof2 = self.term2.toCoq()
            return CoqProof(
                "T_Assign",
                children=[proof1, proof2, Coqsimpl],
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
        elif self.term in [
            "TmSub",
            "TmAdd",
            "TmNe",
            "TmEq",
            "TmGe",
            "TmLt",
            "TmGt",
            "TmLe",
            "TmBitAnd",
            "TmBitOr",
            "TmBitXor",
        ]:
            proof1 = self.term1.toCoq()
            proof2 = self.term2.toCoq()
            return CoqProof(
                f"T_{self.term[2:]}",
                children=[proof1, proof2, Coqsimpl],
            )
        elif self.term in [
            "TmMul",
            "TmDiv",
            "TmMod",
            "TmShiftL",
            "TmShiftR",
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
                children=[proof1, proof2, proof3, Coqsimpl],
            )
        elif self.term == "TmInstanceOf":
            proof1 = self.term1.toCoq()
            return CoqProof(
                "T_InstanceOf",
                params={"T": self.ty},
                children=[proof1],
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
        Coqsimpl = CoqProof("simpl. try reflexivity")
        if self.statement == "StSkip":
            return CoqProof("T_Skip")
        elif self.statement == "StDeclNoInit":
            return CoqProof(
                "T_DeclNoInit",
                params={"T": self.ty, "x": f'"{self.string}"'},
                children=[Coqsimpl],
            )
        elif self.statement == "StDeclInit":
            return CoqProof(
                "T_DeclInit",
                params={"T": self.ty, "x": f'"{self.string}"'},
                children=[Coqsimpl, self.term.toCoq(), Coqsimpl],
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
                params={"T": self.ty, "x": f'"{self.string}"'},
                children=[
                    Coqsimpl,
                    self.term.toCoq(),
                    Coqsimpl,
                    self.statement1.toCoq(),
                ],
            )
        elif self.statement == "StReturn":
            return CoqProof(
                "T_Return",
                children=[self.term.toCoq(), Coqsimpl, Coqsimpl],
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
        node=None,
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
        self.node = node

    def toString(self, class_name="Solution"):
        if self.classcomponent == "MethodDecl":
            return (
                self.string1
                + " "
                + self.ty.toString(printClass=True)
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
        Coqsimpl = CoqProof("simpl. try reflexivity")
        if self.classcomponent == "MethodDecl":
            proof1 = CoqProof(
                "T_MethodDecl",
                params={
                    "modif": f'"{self.string1}"',
                    "T": self.ty,
                    "m": f'"{self.string2}"',
                },
                children=[
                    Coqsimpl,
                    self.statement1.toCoq(),
                    Coqsimpl,
                    self.statement2.toCoq(),
                ],
            )
            return proof1
        elif self.classcomponent == "FieldDeclNoInit":
            return CoqProof(
                "T_FieldDeclNoInit",
                params={
                    "modif": f'"{self.string1}"',
                    "T": self.ty,
                    "x": f'"{self.string2}"',
                },
                children=[Coqsimpl],
            )
        elif self.classcomponent == "FieldDeclInit":
            return CoqProof(
                "T_FieldDeclInit",
                params={
                    "modif": f'"{self.string1}"',
                    "T": self.ty,
                    "x": f'"{self.string2}"',
                },
                children=[Coqsimpl, self.term.toCoq(), Coqsimpl],
            )
        elif self.classcomponent == "ConstructorDecl":
            return CoqProof(
                "T_ConstructorDecl",
                children=[self.statement1.toCoq(), Coqsimpl, self.statement2.toCoq()],
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
        Coqsimpl = CoqProof("simpl. try reflexivity")
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
                children=[Coqsimpl, self.classcomponent.toCoq()],
            )

# load tokenizer from codeT5 and predefined vocabularies
from transformers import AutoTokenizer
import pickle
tokenizer=AutoTokenizer.from_pretrained("Salesforce/codet5-small",min_length=4, local_files_only=True)
ruleDict=pickle.load(open("Data/grammarT5_rules.pkl","rb"))
# add predefined names into vocab
type_name_vocab=["TyInt","TyLong","TyShort","TyByte","TyChar","TyBool","TyFloat","TyDouble","TyVoid","TyExternal","TyArray","TyString","TyGeneric0","TyGeneric1","TyGeneric2"]
classname_vocab=['Object', 'Collections', 'Arrays', 'BigInteger','Integer', 'Math', 'StringBuilder', 'String', 'Character', 'StringTokenizer', 'StringBuffer', 'Scanner', 'PrintStream', 'IntStream', 'OptionalInt', 'System', 'Random', 'Matcher', 'Pattern', 'Long', 'Double','OptionLong','List','Iterator','LinkedList','ArrayList','Set','HashSet','Stack',  'PriorityQueue','Queue','ArrayDeque','Deque','Comparator','Map','Map.Entry','HashMap','LinkedHashMap','BuiltInArray']
method_vocab=['toUpperCase', 'isUpperCase', 'log', 'put', 'getAsInt', 'subList', 'keySet', 'removeAll', 'bitCount', 'replace', 'binarySearch', 'iterator', 'addFirst', 'lowestOneBit', 'matches', 'lastIndexOf', 'isLetterOrDigit', 'find', 'toBinaryString', 'poll', 'doubleValue', 'replaceAll', 'indexOf', 'singletonList', 'reverseOrder', 'or', 'deletecharAt', 'isLetter', 'addLast', 'toRadians', 'getLast', 'reverse', 'push', 'add', 'intValue', 'toString', 'swap', 'remove', 'join', 'containsAll', 'compare', 'isEmpty', 'getKey', 'pop', 'append', 'xor', 'trimToSize', 'hasNextLine', 'offerFirst', 'hasNext', 'length', 'getValue', 'floor', 'shiftLeft', 'contains', 'endsWith', 'valueOf', 'naturalOrder', 'pow', 'not', 'putIfAbsent', 'charAt', 'floorMod', 'and', 'setLength', 'containsKey', 'arraycopy', 'copyOf', 'toArray', 'deleteCharAt', 'charValue', 'getFirst', 'retainAll', 'get', 'println', 'min', 'sin', 'offer', 'emptyList', 'getAsLong', 'sort', 'highestOneBit', 'replaceFirst', 'size', 'concat', 'format', 'removeLast', 'element', 'isAlphabetic', 'peekFirst', 'exit', 'isDigit', 'clear', 'max', 'sum', 'addAll', 'parseDouble', 'getNumericValue', 'hasMoreTokens', 'random', 'toOctalString', 'clone', 'cos', 'entrySet', 'sqrt', 'peekLast', 'PI', 'nextLine', 'nextToken', 'pollFirst', 'log10', 'tan', 'equals', 'nextInt', 'compareTo', 'removeFirst', 'trim', 'getOrDefault', 'split', 'ensureCapacity', 'values', 'MIN_VALUE', 'out', 'copyOfRange', 'asList', 'isWhitespace', 'parselong', 'putAll', 'next', 'set', 'peek', 'round', 'offerLast', 'toCharArray', 'parseInt', 'substring', 'pollLast', 'numberOfLeadingZeros', 'floorDiv', 'abs', 'hashCode', 'startsWith', 'stream', 'toLowerCase', 'fill', 'ceil', 'matcher', 'isLowerCase', 'MAX_VALUE', 'empty']
tokenizer.add_tokens(type_name_vocab+classname_vocab+method_vocab)
for token in type_name_vocab+classname_vocab+method_vocab:
    if token not in ruleDict:
        ruleDict[token] = len(ruleDict)

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

    # translate into coq proof string
    def toString(self, indent=0):
        proof_str = "  " * indent
        indent_len = len(proof_str)

        # main proof sentence
        if self.isEapply:
            if len(self.params.keys()) == 0:
                proof_str += "eapply " + self.tactic + "."
            else:
                def toStr(param):
                    if 'Ty' not in str(type(param)):
                        return f'{param}'
                    else:
                        return param.toCoq()

                proof_str += (
                    "eapply "
                    + self.tactic
                    + " with"
                    + "".join([f"({k}:={toStr(self.params[k])})" for k in self.params])
                    + "."
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

    def tokenization(self):
        """
        Tokenizes the proof string.

        Returns:
            List[str]: The list of tokens.
        """

        tokens = []
        if self.tactic not in ruleDict:
            tokenizer.add_tokens([self.tactic])
        if self.isEapply:
            tokens.append(self.tactic)
            # tokenize parameters
            for k in self.params:
                
                def toStr(param):
                    if 'Ty' not in str(type(param)):
                        return f'{param}',True
                    else:
                        return param.toCoq().strip(),False
                # whether this parameter is a string
                pvalue, isString = toStr(self.params[k])

                #remove the quotation marks
                is_string=False
                if pvalue[0] == '"' and pvalue[-1] == '"':
                    pvalue = pvalue[1:-1]
                    is_string=True

                #short string can be viewd as a token
                if len(pvalue)>=3 and len(pvalue)<5 and pvalue not in ruleDict: 
                    tokenizer.add_tokens([pvalue])

                # tokenize parameter's value
                ptokens=tokenizer.tokenize(pvalue)
                ptokens=[token.replace("Ġ","") for token in ptokens if '(' not in token and ')' not in token]
                tokens+=[token for token in ptokens if token not in [" ", tokenizer.unk_token, '"',""]] + (["Ġ"] if isString else [])
        elif self.tactic == "simpl. try reflexivity":
            pass
        else:
            tokens.append(self.tactic)
        
        # add new tokens into ruleDict
        for token in tokens:
            if token not in ruleDict:
                ruleDict[token] = len(ruleDict)

        for child in self.children:
            tokens += child.tokenization()
        return tokens

    def toJava(self):
        """
        Converts the proof into Java Model

        Returns:
            Term/Statement/ClassComponent/Program : The Java Model
        
        """

        
    
# Convert tokensequence back into Coqproof
def detokenization(tokens):
    class partialProof:
        def __init__(self,type,content,complete=False):
            self.type=type          # type of the partial-proof: string / ty / tactic
            self.content=content    # content of the partial-proof: string-literal / ty name / tactic name
            self.completed=complete  # whether the partial-proof is complete
            self.terms_needed=-1     # number of terms needed to complete the partial-proof

            if self.type=="string":
                if self.content == "Ġ":
                    self.terms_needed=0
                    self.completed=True
                else:
                    self.terms_needed=1
                    self.completed=False
            elif self.type=="ty":
                if self.content in ["TyInt","TyLong","TyShort","TyByte","TyChar","TyBool","TyFloat","TyDouble","TyVoid", "TyString"]:
                    self.terms_needed=0
                    self.content=Ty(self.content)
                    self.completed=True
                elif self.content in ["TyExternal","TyArray","TyGeneric0"]:
                    self.terms_needed=1
                    self.completed=False
                elif self.content in ["TyGeneric1"]:
                    self.terms_needed=2
                    self.completed=False
                elif self.content in ["TyGeneric2"]:
                    self.terms_needed=3
                    self.completed=False
                else:
                    assert False, "Unknown type name: "+self.content
            elif self.type=="tactic":
                if self.content in ["T_Null","T_True","T_False","T_Nil","T_EmptyArray","T_Skip","T_Continue","T_Break"]:
                    self.terms_needed=0
                    self.content=CoqProof(self.content)
                    self.completed=True
                elif self.content in ["T_Var","T_Integer","T_Float","T_String","T_Char","T_NewArrayNoInit","T_Neg","T_Not","T_PostInc","T_PostDec","T_PreInc","T_PreDec","T_BitNot","T_Expression","T_Return"]:
                    self.terms_needed=1
                    self.completed=False
                elif self.content in ["T_TyFieldAccess","T_FieldAccess","T_New'","T_NewArrayInit","T_Conversion","T_ArrayAccess","T_MethodInvocationNoObj","T_Assign","T_List","T_ArrayConcat","T_Sub","T_Add","T_Ne","T_Eq","T_Ge","T_Lt","T_Gt","T_Le","T_BitAnd","T_BitOr","T_BitXor","T_Mul","T_Div","T_Mod","T_ShiftL","T_ShiftR","T_And","T_Or","T_InstanceOf","T_DeclNoInit","T_If","T_While","T_DoWhile","T_Concat","T_ConstructorDecl","T_ComponentConcat","T_ProgramConcat","T_ImportDecl","T_ClassDecl"]:
                    self.terms_needed=2
                    self.completed=False
                elif self.content in ["T_NewArrayNoInit'","T_TyMethodInvocation","T_MethodInvocation","T_Choose","T_DeclInit","T_IfElse","T_FieldDeclNoInit"]:
                    self.terms_needed=3
                    self.completed=False
                elif self.content in ["T_For","T_Foreach","T_FieldDeclInit"]:
                    self.terms_needed=4
                    self.completed=False
                elif self.content in ["T_MethodDecl"]:
                    self.terms_needed=5
                    self.completed=False
                else:
                    assert False, "Unknown tactic name: "+self.content
            else:
                assert False, "Unknown type: "+self.type
        
        def complete(self,terms):
            self.completed=True
            if self.type=="string":
                assert len(terms)==1 and terms[0].type=="string", f"{self.content} {terms[0].content.toString()}"
                self.content+=("" if terms[0].content=="Ġ" else terms[0].content)
            elif self.type=="ty":
                if self.content=="TyExternal":
                    assert len(terms)==1 and terms[0].type=="string"
                    self.content=Ty("TyExternal",string=terms[0].content)
                elif self.content=="TyArray":
                    assert len(terms)==1 and terms[0].type=="ty"
                    self.content=Ty("TyArray",ty1=terms[0].content)
                elif self.content=="TyGeneric0":
                    assert len(terms)==1 and terms[0].type=="string"
                    self.content=Ty("TyGeneric0",string=terms[0].content)
                elif self.content=="TyGeneric1":
                    assert len(terms)==2 and terms[0].type=="string" and terms[1].type=="ty"
                    self.content=Ty("TyGeneric1",string=terms[0].content,ty1=terms[1].content)
                elif self.content=="TyGeneric2":
                    assert len(terms)==3 and terms[0].type=="string" and terms[1].type=="ty" and terms[2].type=="ty"
                    self.content=Ty("TyGeneric2",string=terms[0].content,ty1=terms[1].content,ty2=terms[2].content)
                else:
                    assert False, "Unknown type name: "+self.content
            elif self.type=="tactic":
                Coqsimpl = CoqProof("simpl. try reflexivity")
                if self.content=="T_Var":
                    assert len(terms)==1 and terms[0].type=="string"
                    self.content=CoqProof("T_Var",params={"x":f'"{terms[0].content}"'},children=[Coqsimpl])
                elif self.content=="T_Integer":
                    assert len(terms)==1 and terms[0].type=="string"
                    self.content=CoqProof("T_Integer",params={"n":terms[0].content})
                elif self.content=="T_Float":
                    assert len(terms)==1 and terms[0].type=="string"
                    self.content=CoqProof("T_Float",params={"f":terms[0].content+"%float"})
                elif self.content=="T_String":
                    assert len(terms)==1 and terms[0].type=="string"
                    self.content=CoqProof("T_String",params={"s":f'"{terms[0].content}"'})
                elif self.content=="T_Char":
                    assert len(terms)==1 and terms[0].type=="string"
                    self.content=CoqProof("T_Char",params={"c":terms[0].content})
                elif self.content=="T_TyFieldAccess":
                    assert len(terms)==2 and terms[0].type=="string" and terms[1].type=="ty"
                    self.content=CoqProof("T_TyFieldAccess",params={"f":f'"{terms[0].content}"',"T":terms[1].content},children=[Coqsimpl,Coqsimpl])
                elif self.content=="T_FieldAccess":
                    assert len(terms)==2 and terms[0].type=="string" and terms[1].type=="tactic"
                    self.content=CoqProof("T_FieldAccess",params={"f":f'"{terms[0].content}"'},children=[terms[1].content, Coqsimpl, Coqsimpl])
                elif self.content=="T_New'":
                    assert len(terms)==2 and terms[0].type=="ty" and terms[1].type=="tactic"
                    self.content=CoqProof("T_New'",params={"T":terms[0].content},children=[Coqsimpl,terms[1].content])
                elif self.content=="T_NewArrayNoInit":
                    assert len(terms)==1 and terms[0].type=="ty"
                    self.content=CoqProof("T_NewArrayNoInit",params={"T":terms[0].content})
                elif self.content=="T_NewArrayNoInit'":
                    assert len(terms)==3 and terms[0].type=="ty" and terms[1].type=="tactic" and terms[2].type=="tactic"
                    self.content=CoqProof("T_NewArrayNoInit'",params={"T":terms[0].content},children=[terms[1].content, terms[2].content])
                elif self.content=="T_NewArrayInit":
                    assert len(terms)==2 and terms[0].type=="ty" and terms[1].type=="tactic"
                    self.content=CoqProof("T_NewArrayInit",params={"T":terms[0].content},children=[Coqsimpl, terms[1].content])
                elif self.content=="T_Conversion":
                    assert len(terms)==2 and terms[0].type=="ty" and terms[1].type=="tactic"
                    self.content=CoqProof("T_Conversion",params={"T":terms[0].content},children=[terms[1].content,Coqsimpl])
                elif self.content=="T_ArrayAccess":
                    assert len(terms)==2 and terms[0].type=="tactic" and terms[1].type=="tactic"
                    self.content=CoqProof("T_ArrayAccess",children=[terms[0].content,terms[1].content])
                elif self.content=="T_TyMethodInvocation":
                    assert len(terms)==3 and terms[0].type=="string" and terms[1].type=="ty" and terms[2].type=="tactic"
                    self.content=CoqProof("T_TyMethodInvocation",params={"m":f'"{terms[0].content}"',"T":terms[1].content},children=[Coqsimpl, Coqsimpl, terms[2].content, Coqsimpl])
                elif self.content=="T_MethodInvocation":
                    assert len(terms)==3 and terms[0].type=="string" and terms[1].type=="tactic" and terms[2].type=="tactic"
                    self.content=CoqProof("T_MethodInvocation",params={"m":f'"{terms[0].content}"'},children=[terms[1].content, Coqsimpl, Coqsimpl, terms[2].content, Coqsimpl])
                elif self.content=="T_MethodInvocationNoObj":
                    assert len(terms)==2 and terms[0].type=="string" and terms[1].type=="tactic"
                    self.content=CoqProof("T_MethodInvocationNoObj",params={"m":f'"{terms[0].content}"'},children=[Coqsimpl, terms[1].content, Coqsimpl])
                elif self.content=="T_Assign":
                    assert len(terms)==2 and terms[0].type=="tactic" and terms[1].type=="tactic"
                    self.content=CoqProof("T_Assign",children=[terms[0].content, terms[1].content,Coqsimpl])
                elif self.content=="T_List":
                    assert len(terms)==2 and terms[0].type=="tactic" and terms[1].type=="tactic"
                    self.content=CoqProof("T_List",children=[terms[0].content, terms[1].content])
                elif self.content=="T_ArrayConcat":
                    assert len(terms)==2 and terms[0].type=="tactic" and terms[1].type=="tactic"
                    self.content=CoqProof("T_ArrayConcat",children=[terms[0].content, terms[1].content])
                elif self.content in ["T_Sub","T_Add","T_Ne","T_Eq","T_Ge","T_Lt","T_Gt","T_Le","T_BitAnd","T_BitOr","T_BitXor"]:
                    assert len(terms)==2 and terms[0].type=="tactic" and terms[1].type=="tactic"
                    self.content=CoqProof(self.content,children=[terms[0].content, terms[1].content, Coqsimpl])
                elif self.content in ["T_Mul","T_Div","T_Mod","T_ShiftL","T_ShiftR","T_And","T_Or"]:
                    assert len(terms)==2 and terms[0].type=="tactic" and terms[1].type=="tactic"
                    self.content=CoqProof(self.content,children=[terms[0].content, terms[1].content])
                elif self.content in ["T_Neg","T_Not","T_PostInc","T_PostDec","T_PreInc","T_PreDec","T_BitNot"]:
                    assert len(terms)==1 and terms[0].type=="tactic"
                    self.content=CoqProof(self.content,children=[terms[0].content])
                elif self.content=="T_Choose":
                    assert len(terms)==3 and terms[0].type=="tactic" and terms[1].type=="tactic" and terms[2].type=="tactic"
                    self.content=CoqProof("T_Choose",children=[terms[0].content, terms[1].content, terms[2].content, Coqsimpl])
                elif self.content=="T_InstanceOf":
                    assert len(terms)==2 and terms[0].type=="ty" and terms[1].type=="tactic"
                    self.content=CoqProof("T_InstanceOf",params={"T":terms[0].content},children=[terms[1].content])
                elif self.content=="T_DeclNoInit":
                    assert len(terms)==2 and terms[0].type=="ty" and terms[1].type=="string"
                    self.content=CoqProof("T_DeclNoInit",params={"T":terms[0].content,"x":f'"{terms[1].content}"'},children=[Coqsimpl])
                elif self.content=="T_DeclInit":
                    assert len(terms)==3 and terms[0].type=="ty" and terms[1].type=="string" and terms[2].type=="tactic"
                    self.content=CoqProof("T_DeclInit",params={"T":terms[0].content,"x":f'"{terms[1].content}"'},children=[Coqsimpl, terms[2].content, Coqsimpl])
                elif self.content=="T_Expression":
                    assert len(terms)==1 and terms[0].type=="tactic"
                    self.content=CoqProof("T_Expression",children=[terms[0].content])
                elif self.content=="T_If":
                    assert len(terms)==2 and terms[0].type=="tactic" and terms[1].type=="tactic"
                    self.content=CoqProof("T_If",children=[terms[0].content, terms[1].content])
                elif self.content=="T_IfElse":
                    assert len(terms)==3 and terms[0].type=="tactic" and terms[1].type=="tactic" and terms[2].type=="tactic"
                    self.content=CoqProof("T_IfElse",children=[terms[0].content, terms[1].content, terms[2].content])
                elif self.content=="T_While":
                    assert len(terms)==2 and terms[0].type=="tactic" and terms[1].type=="tactic"
                    self.content=CoqProof("T_While",children=[terms[0].content, terms[1].content])
                elif self.content=="T_DoWhile":
                    assert len(terms)==2 and terms[0].type=="tactic" and terms[1].type=="tactic"
                    self.content=CoqProof("T_DoWhile",children=[terms[0].content, terms[1].content])
                elif self.content=="T_For":
                    assert len(terms)==4 and terms[0].type=="tactic" and terms[1].type=="tactic" and terms[2].type=="tactic" and terms[3].type=="tactic"
                    self.content=CoqProof("T_For",children=[terms[0].content, terms[1].content, terms[2].content, terms[3].content])
                elif self.content=="T_Foreach":
                    assert len(terms)==4 and terms[0].type=="ty" and terms[1].type=="string" and terms[2].type=="tactic" and terms[3].type=="tactic"
                    self.content=CoqProof("T_Foreach",params={"T":terms[0].content,"x":f'"{terms[1].content}"'},children=[Coqsimpl, terms[2].content, Coqsimpl, terms[3].content])
                elif self.content=="T_Return":
                    assert len(terms)==1 and terms[0].type=="tactic"
                    self.content=CoqProof("T_Return",children=[terms[0].content, Coqsimpl, Coqsimpl])
                elif self.content=="T_Concat":
                    assert len(terms)==2 and terms[0].type=="tactic" and terms[1].type=="tactic"
                    self.content=CoqProof("T_Concat",children=[terms[0].content, terms[1].content])
                elif self.content=="T_MethodDecl":
                    assert len(terms)==5 and terms[0].type=="string" and terms[1].type=="ty" and terms[2].type=="string" and terms[3].type=="tactic" and terms[4].type=="tactic"
                    self.content=CoqProof("T_MethodDecl",params={"modif":f'"{terms[0].content}"',"T":terms[1].content,"m":f'"{terms[2].content}"'},children=[Coqsimpl, terms[3].content, Coqsimpl, terms[4].content])
                elif self.content=="T_FieldDeclNoInit":
                    assert len(terms)==3 and terms[0].type=="string" and terms[1].type=="ty" and terms[2].type=="string"
                    self.content=CoqProof("T_FieldDeclNoInit",params={"modif":f'"{terms[0].content}"',"T":terms[1].content,"x":f'"{terms[2].content}"'},children=[Coqsimpl])
                elif self.content=="T_FieldDeclInit":
                    assert len(terms)==4 and terms[0].type=="string" and terms[1].type=="ty" and terms[2].type=="string" and terms[3].type=="tactic"
                    self.content=CoqProof("T_FieldDeclInit",params={"modif":f'"{terms[0].content}"',"T":terms[1].content,"x":f'"{terms[2].content}"'},children=[Coqsimpl, terms[3].content, Coqsimpl])
                elif self.content=="T_ConstructorDecl":
                    assert len(terms)==2 and terms[0].type=="tactic" and terms[1].type=="tactic"
                    self.content=CoqProof("T_ConstructorDecl",children=[terms[0].content, Coqsimpl, terms[1].content])
                elif self.content=="T_ComponentConcat":
                    assert len(terms)==2 and terms[0].type=="tactic" and terms[1].type=="tactic"
                    self.content=CoqProof("T_ComponentConcat",children=[terms[0].content, terms[1].content])
                elif self.content=="T_ProgramConcat":
                    assert len(terms)==2 and terms[0].type=="tactic" and terms[1].type=="tactic"
                    self.content=CoqProof("T_ProgramConcat",children=[terms[0].content, terms[1].content])
                elif self.content=="T_ImportDecl":
                    assert len(terms)==2 and terms[0].type=="string" and terms[1].type=="string"
                    self.content=CoqProof("T_ImportDecl",params={"n1":f'"{terms[0].content}"',"n2":f'"{terms[1].content}"'})
                elif self.content=="T_ClassDecl":
                    assert len(terms)==2 and terms[0].type=="string" and terms[1].type=="tactic"
                    self.content=CoqProof("T_ClassDecl",params={"name":f'"{terms[0].content}"'},children=[Coqsimpl, terms[1].content])
                else:
                    assert False, "Unknown tactic name: "+self.content
            else:
                assert False, "Unknown type: "+self.type
    
    # unify the right most complete terms into a partial terms to get a complete term
    def unify(stack):
        # nothing to unify
        if len(stack)==0 or stack[-1].completed==False:
            return
        
        # find the rightmost partial-proof
        pindex=len(stack)-1
        while pindex>=0 and stack[pindex].completed==True:
            pindex-=1
        if pindex<0:
            return
        
        # need enough terms to complete the partial-proof
        pterm=stack[pindex]
        if len(stack)-1-pindex<pterm.terms_needed:
            return
        elif len(stack)-1-pindex>pterm.terms_needed:
            assert False, "The number of complete terms > terms needed"
        
        # complete the partial-proof
        pterm.complete(stack[pindex+1:])
        del stack[pindex+1:]
        unify(stack)

    stack=[]
    for token in tokens:
        if token.startswith("T_"):
            stack.append(partialProof("tactic",token))
        elif token in type_name_vocab:
            stack.append(partialProof("ty",token))
        else:
            str=partialProof("string",token)
            #if the string is in a type definition Eg. TyGeneric1 List TyInt
            if stack[-1].type=="ty" and stack[-1].completed==False:
                str.completed=True
            
            # end of a string
            if token=="Ġ": 
                # empty string
                if stack[-1].type=='tactic' and stack[-1].content=="T_String":
                    stack[-1].content=CoqProof("T_String",params={"s":'""'})
                stack[-1].completed=True
            else:
                stack.append(str)

        # print the stack infomation
        # log=[]
        # for item in stack:
        #     if item.type=="ty" and item.completed==True:
        #         log.append(item.content.toString())
        #     elif item.type=="tactic" and item.completed==True:
        #         log.append(item.content.tactic)
        #     else:
        #         log.append(item.content)
        # print(log)

        unify(stack)
    
    assert len(stack)==1 and stack[0].completed==True, "The proof is not complete"
    return stack[0].content

if __name__ == "__main__":
    vocab=tokenizer.vocab
    print(vocab['a'])
