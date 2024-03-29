Set Warnings "-deprecated-hint-without-locality,-parsing".

From PLF Require Export Maps.
From Coq Require Export Floats.Floats.
From Coq Require Export Lists.List.

(* Basic Program Syntax *)
Inductive Ty : Type :=
    | TyByte : Ty
    | TyShort : Ty
    | TyInt : Ty
    | TyLong : Ty
    | TyFloat : Ty
    | TyDouble : Ty
    | TyBool : Ty
    | TyChar : Ty
    | TyString : Ty
    | TyExternal : string->Ty         (* imported external type *)
    | TyGeneric0 : string->Ty         (* s<> *)
    | TyGeneric1 : string->Ty->Ty     (* s<T> *)
    | TyGeneric2 : string->Ty->Ty->Ty (* s<T1,T2> *)
    | TyArray : Ty->Ty                (* T[] *)
    | TyVoid : Ty                     (* void *).

Inductive Term : Type :=
    (* basic data structure *)
    | TmVar : string->Term
    | TmInteger : nat->Term
    | TmFloat : float->Term
    | TmChar : nat->Term
    | TmString : string->Term
    | TmTrue : Term
    | TmFalse : Term
    | TmNull : Term
    (* advanced data structure *)
    | TmAssign : Term->Term->Term                   (* tm1 = tm2 *)
    | TmConversion : Ty->Term->Term                 (* (T)tm / (float)10 *)
    | TmFieldAccess : Term->string->Term            (* tm.f *)
    | TmTyFieldAccess : Ty->string->Term            (* T.f *)
    | TmArrayAccess : Term->Term->Term              (* tm1[tm2] *)
    | TmNew : Ty->Term->Term                        (* new T(tm) *)
    | TmNewArrayNoInit : Ty->Term->Term             (* new T[tm] / new int[2][2] *)
    | TmNewArrayInit : Ty->Term->Term               (* new T{tm} / new int[]{1,2} *)
    | TmMethodInvocation : Term->string->Term->Term (* tm1.m(tm2) *)
    | TmTyMethodInvocation : Ty->string->Term->Term (* T.m(tm) *)
    | TmMethodInvocationNoObj : string->Term->Term  (* m(tm) *)
    | TmNil : Term                                  (* means nothing *)
    | TmList : Term -> Term-> Term                  (* tm1,tm2... *)
    | TmEmptyArray : Term                           (* {} *)
    | TmArrayConcat : Term->Term->Term              (* { term1,term2 } *)
    (* arithmetic term *)
    | TmAdd : Term->Term->Term                      (* tm1 + tm2 *)
    | TmSub : Term->Term->Term                      (* tm1 - tm2 *)
    | TmMul : Term->Term->Term                      (* tm1 * tm2 *)
    | TmDiv : Term->Term->Term                      (* tm1 / tm2 *)
    | TmMod : Term->Term->Term                      (* tm1 % tm2 *)
    | TmNeg : Term->Term                            (* -tm *)
    | TmShiftL : Term->Term->Term                   (* tm1 << tm2 *)
    | TmShiftR : Term->Term->Term                   (* tm1 >> tm2 *)
    | TmBitAnd : Term->Term->Term                   (* tm1 & tm2 *)
    | TmBitOr : Term->Term->Term                    (* tm1 | tm2 *)
    | TmBitXor : Term->Term->Term                   (* tm1 ^ tm2 *)
    | TmBitNot : Term->Term                         (* ~tm *)
    | TmPostInc : Term->Term                        (* tm++ *)
    | TmPostDec : Term->Term                        (* tm-- *)
    | TmPreInc : Term->Term                         (* ++tm *)
    | TmPreDec : Term->Term                         (* --tm *)
    (*logic term*)
    | TmEq : Term->Term->Term                       (* tm1 == tm2 *)
    | TmNe : Term->Term->Term                       (* tm1 != tm2 *)
    | TmLt : Term->Term->Term                       (* tm1 < tm2 *)
    | TmLe : Term->Term->Term                       (* tm1 <= tm2 *)
    | TmGt : Term->Term->Term                       (* tm1 > tm2 *)
    | TmGe : Term->Term->Term                       (* tm1 >= tm2 *)
    | TmAnd : Term->Term->Term                      (* tm1 && tm2 *)
    | TmOr : Term->Term->Term                       (* tm1 || tm2 *)
    | TmNot : Term->Term                            (* !tm *)
    | TmChoose : Term->Term->Term->Term             (* tm1 ? tm2 : tm3 *).

Inductive Statement : Type :=
    | StSkip : Statement
    | StDeclInit : Ty->string->Term->Statement              (* T x = tm *)
    | StDeclNoInit : Ty->string->Statement                  (* T x *)
    | StIf : Term->Statement->Statement                     (* if (tm) {s} *)
    | StIfElse : Term->Statement->Statement->Statement      (* if (tm) {s1} else {s2} *)
    | StWhile : Term->Statement->Statement                  (* while (tm) {s} *)
    | StDoWhile : Statement->Term->Statement                (* do {s} while (tm) *)
    | StFor : Statement->Term->Term->Statement->Statement   (* for (s1;tm1;tm2) {s3} *)
    | StForeach : Ty->string->Term->Statement->Statement    (* for (T x : tm) {s} *)
    | StReturn : Term->Statement                            (* return tm *)
    | StContinue : Statement                                (* continue *)
    | StBreak : Statement                                   (* break *)
    | StExpression : Term->Statement                        (* tm *)
    | StConcat : Statement->Statement->Statement.

Inductive ClassComponent : Type :=
    | FieldDeclNoInit :  string->Ty->string->ClassComponent     (* modifier T x; *)
    | FieldDeclInit : string->Ty->string->Term->ClassComponent  (* modifier T x = tm; *)
    | ConstructorDecl : Statement->Statement->ClassComponent    (* Constructor (s1) {s2} *)
    | MethodDecl : string->Ty->string->Statement->Statement->ClassComponent
                                                                (* modifier T x (s1) {s2} *)
    | ComponentConcat : ClassComponent->ClassComponent->ClassComponent.

Inductive Program : Type :=
    | ClassDecl : string->ClassComponent->Program
    | ImportDecl : string->string->Program
    | ProgramConcat : Program->Program->Program.


(* Useful Notations *)
Declare Custom Entry FJ.
Declare Custom Entry FJ_Class.
Declare Custom Entry FJ_Type.
Notation "<| e |>" := e (e custom FJ at level 99).
Notation "({ e })" := e (e custom FJ_Type at level 99).
Notation "( x )" := x (in custom FJ, x at level 99).
Notation "( x )" := x (in custom FJ_Type, x at level 99).
Notation "x" := x (in custom FJ at level 0, x constr at level 0 ).
Notation "x" := x (in custom FJ_Class at level 0, x constr at level 0 ).

(*types*)
Notation "'Bool'" := TyBool (in custom FJ_Type at level 0).
Notation "'Byte'" := TyByte (in custom FJ_Type at level 0).
Notation "'Short'" := TyShort (in custom FJ_Type at level 0).
Notation "'Int'" := TyInt (in custom FJ_Type at level 0).
Notation "'Long'" := TyLong (in custom FJ_Type at level 0).
Notation "'Char'" := TyChar (in custom FJ_Type at level 0).
Notation "'String'" := TyString (in custom FJ_Type at level 0).
Notation "'Float'" := TyFloat (in custom FJ_Type at level 0).
Notation "'Double'" := TyDouble (in custom FJ_Type at level 0).
Notation "a '[]'" := (TyArray a) (in custom FJ_Type at level 10).
Notation "'Void'" := TyVoid (in custom FJ_Type at level 0).
Notation "'G(' a < b > )" := (TyGeneric1 a b) (in custom FJ_Type at level 10, a constr at level 0, b at level 10).
Notation "'G(' a < b , c > )" := (TyGeneric2 a b c) (in custom FJ_Type at level 10, a constr at level 0, b at level 10, c at level 10).
Notation "'E(' a ')'" := (TyExternal a) (in custom FJ_Type at level 0, a constr at level 0).

(*Terms*)
Notation "'true'" := TmTrue (in custom FJ at level 0).
Notation "'false'" := TmFalse (in custom FJ at level 0).
Notation "Char( a )" := (TmChar a) (in custom FJ at level 0).
Notation "String( a )" := (TmString a) (in custom FJ at level 0).
Coercion TmInteger : nat >-> Term.
Coercion TmFloat : float >-> Term.
Coercion TmVar : string >-> Term.
Notation "'null'" := TmNull (in custom FJ at level 0).
Notation "a '=' b " := (TmAssign a b) (in custom FJ at level 80, b at next level).

Notation "a [ b ]" := (TmArrayAccess a b) (in custom FJ at level 20, b at next level).
Notation "a \. b" := (TmFieldAccess a b) (in custom FJ at level 20, b at next level).
Notation "x . m ( a )" := (TmMethodInvocation x m a ) (in custom FJ at level 20, m at level 5, a at next level).
Notation "'S(' T . m ( a ) )" := (TmTyMethodInvocation T m a ) (in custom FJ at level 20, T custom FJ_Type at level 10, m at level 5, a at next level).
Notation "'new' a ( b )" := (TmNew a b) (in custom FJ at level 20, a custom FJ_Type at level 10, b at level 20).
Notation "C( T ) a" := (TmConversion T a) (in custom FJ at level 20, T custom FJ_Type at level 10, a at level 20).
Notation "[]" := TmNil (in custom FJ at level 20).
Notation "[ x ]" := (TmList x TmNil) (in custom FJ at level 20, x at level 20).
Notation "[ x ; y ; .. ; z ]" := (TmList x (TmList y .. (TmList z TmNil) ..)) (in custom FJ at level 20, x at level 20, y at level 20, z at level 20).

(*ArithTerms*)
Notation "a + b" := (TmAdd a b) (in custom FJ at level 50).
Notation "a - b" := (TmSub a b) (in custom FJ at level 50).
Notation "a * b" := (TmMul a b) (in custom FJ at level 40).
Notation "a / b" := (TmDiv a b) (in custom FJ at level 40).
Notation "a % b" := (TmMod a b) (in custom FJ at level 40).
Notation "- a" := (TmNeg a) (in custom FJ at level 35).
Notation "a << b" := (TmShiftL a b) (in custom FJ at level 45).
Notation "a >> b" := (TmShiftR a b) (in custom FJ at level 45).
Notation "a & b" := (TmBitAnd a b) (in custom FJ at level 45).
Notation "a | b" := (TmBitOr a b) (in custom FJ at level 45).
Notation "a ^ b" := (TmBitXor a b) (in custom FJ at level 45).
Notation "~ a" := (TmBitNot a) (in custom FJ at level 40).

(*ConditionalTerms*)
Notation "a == b" := (TmEq a b) (in custom FJ at level 60).
Notation "a != b" := (TmNe a b) (in custom FJ at level 60).
Notation "a < b" := (TmLt a b) (in custom FJ at level 60).
Notation "a <= b" := (TmLe a b) (in custom FJ at level 60).
Notation "a > b" := (TmGt a b) (in custom FJ at level 60).
Notation "a >= b" := (TmGe a b) (in custom FJ at level 60).
Notation "a && b" := (TmAnd a b) (in custom FJ at level 65).
Notation "a || b" := (TmOr a b) (in custom FJ at level 65).
Notation "! a" := (TmNot a) (in custom FJ at level 65).
Notation "a ? b : c" := (TmChoose a b c) (in custom FJ at level 70, b at level 70, c at level 70).

(*Statements*)
Notation "'skip'" := StSkip (in custom FJ at level 0).
Notation "'if' ( a ) { b }" := (StIf a b) (in custom FJ at level 80, a at next level, b at level 80).
Notation "'if' ( a ) { b } 'else' { c }" := (StIfElse a b c) (in custom FJ at level 80, a at next level, b at level 80, c at level 80).
Notation "'while' ( a ) { b }" := (StWhile a b) (in custom FJ at level 80).
Notation "'do' { a } 'while' ( b )" := (StDoWhile a b) (in custom FJ at level 80, a at level 80, b at level 80).
Notation "'for' ( a ;; b ;; c ) { d }" := (StFor a b c d) (in custom FJ at level 80, a at level 80, b at next level, c at level 80, d at level 80).
Notation "'Return' a " := (StReturn a) (in custom FJ at level 80, a at next level).
Notation " a ; b" := (StConcat a b) (in custom FJ at level 80, b at level 80).
Notation "'continue'" := StContinue (in custom FJ at level 80).
Notation "'break'" := StBreak (in custom FJ at level 80).
Notation "t a '=' b " := (StDeclInit t a b) (in custom FJ at level 80, t custom FJ_Type at level 10, a at next level, b at next level).
Coercion StExpression : Term >-> Statement.

(*ClassComponent*)
Notation "t a ( b ) { c }" := (MethodDecl "" t a b c ) 
(in custom FJ_Class at level 80, t custom FJ_Type at level 20, a at level 0, b custom FJ at level 80, c custom FJ at level 80).
Notation "t a" := (FieldDeclNoInit "" t a) 
(in custom FJ_Class at level 80, t custom FJ_Type at level 20, a at level 0).
Notation "'Constructor' ( a ) { b }" := (ConstructorDecl a b) 
(in custom FJ_Class at level 80, a custom FJ at level 80, b custom FJ at level 80).
Notation "a ; b" := (ComponentConcat a b) 
(in custom FJ_Class at level 80, b at level 80).

(*WholeProgram*)
Notation " 'Import' a . b ;" := (ImportDecl a b) (in custom FJ at level 90, a at level 5, b at level 5).
Notation "'class' a '{' b '}' " := (ClassDecl a b ) (in custom FJ at level 90, a at level 0, b custom FJ_Class at level 90).
Notation "a '\n' b" := (ProgramConcat a b) (in custom FJ at level 95, b at level 95).

Definition main : string := "main".
Definition this : string := "this".
Definition method : string := "method".
Definition constructor : string := "constructor".
Definition public : string := "public".
Definition return' : string := "return".
Definition empty' : string := "".

(*Properties & Type correctness reasoning*)
Open Scope string_scope.
(* define a simplified type system *)
Inductive STy : Type :=
    (*basic*)
    | STyBoolean : STy                   (* bool *)
    | STyNumeric : STy                   (* int, long, float...*)
    | STyString : STy                    (* string, char *)
    (*method and parameters*)
    | STyArrow : STy->STy->STy           (* T1->T2 *)
    | STyVoid : STy                      (* void *)
    | STyList : STy->STy->STy            (* T1, T2 *)
    (*array*)
    | STyArray : STy->STy                (* T[] *)
    (*class*) 
    | STyClass : partial_map STy ->STy   (* class define by user will be parse as external *)
    | STyExternal : string->STy          (* external class *)
    | STyGeneric0: string->STy           (* s<> *)
    | STyGeneric1: string->STy->STy      (* s<T> *)
    | STyGeneric2: string->STy->STy->STy (* s<T1,T2> *)
    | STyTemplate: STy.                  (* T *)

    

Declare Custom Entry FJ_STy.
Notation "<( e )>" := e (e custom FJ_STy at level 99).
Notation "( x )" := x (in custom FJ_STy, x constr at level 99).
Notation "x" := x (in custom FJ_STy at level 0, x constr at level 0).
Notation "'Bool'" := STyBoolean (in custom FJ_STy at level 0).
Notation "'Numeric'" := STyNumeric (in custom FJ_STy at level 0).
Notation "'String'" := STyString (in custom FJ_STy at level 0).
Notation "T1 '->' T2" := (STyArrow T1 T2) (in custom FJ_STy at level 10,T2 at level 10).
Notation "'[]'" := STyVoid (in custom FJ_STy at level 0).
Notation "[ T ]" := (STyList T STyVoid) (in custom FJ_STy at level 10).
Notation "[ T1 ; T2 ; .. ; Tn ]" := (STyList T1 (STyList T2 .. (STyList Tn STyVoid) ..)) (in custom FJ_STy at level 10).
Notation "T []" := (STyArray T) (in custom FJ_STy at level 10).
(* translate types in java normal grammar into the simplified tpe system*)




(*simplify the type system*)

Fixpoint SimplType (T:Ty) : STy :=
    match T with
    | TyBool => STyBoolean
    | TyByte => STyNumeric
    | TyShort => STyNumeric
    | TyInt => STyNumeric
    | TyLong => STyNumeric
    | TyFloat => STyNumeric
    | TyDouble => STyNumeric
    | TyChar => STyNumeric
    | TyString => STyString
    | TyArray T' => STyArray (SimplType T')
    | TyVoid => STyVoid
    | TyExternal s => match s with 
                        | "ArrayList" => STyGeneric1 "ArrayList" STyTemplate
                        |_ => STyExternal s
                        end
    | TyGeneric0 s => match s with
                        | "ArrayList" => STyGeneric1 "ArrayList" STyTemplate
                        | "HashSet" => STyGeneric1 "HashSet" STyTemplate
                        | "HashMap" => STyGeneric2 "HashMap" STyTemplate STyTemplate
                        | "LinkedList" => STyGeneric1 "LinkedList" STyTemplate
                        | "Stack" => STyGeneric1 "Stack" STyTemplate
                        | _ => STyGeneric0 s
                        end
    | TyGeneric1 s T' => STyGeneric1 s (SimplType T')
    | TyGeneric2 s T1 T2 => STyGeneric2 s (SimplType T1) (SimplType T2)
    end.
Definition iterable (T1 T2: STy):=
    match T2 with
    | STyArray T3 => T1=T3
    | STyGeneric1 "List" T3 => T1=T3
    | STyGeneric1 "Set" T3 => T1=T3
    | STyClass ct => match ct "iterator" with
                    | Some T3 => T1=T3
                    | None => False
                    end
    | _ => False
    end.
Close Scope string_scope.

(* define a partial map for the context *)
Definition Context : Type := partial_map STy.
Definition ClassType : Type := partial_map STy.
Definition updateMerge {A:Type} (m1 m2:partial_map A) : partial_map A :=
    fun x => match m1 x with
            | Some v => Some v
            | None => m2 x
            end.



Notation "'TEM'" := STyTemplate (in custom FJ_STy at level 10).
(* f : PT->RT, PT is the parameter type with type template TT, RT is the return type
   PT must be STyList or StyVoid
   x : PT' is the argument passed to f *)
Fixpoint calRT (RT TT:STy):STy:=
    match RT with
    | STyArrow PT RT' => STyArrow (calRT PT TT) (calRT RT' TT)
    | STyList T1 T2 => STyList (calRT T1 TT) (calRT T2 TT)
    | STyArray T => STyArray (calRT T TT)
    | STyTemplate => TT
    | T => T
    end.


Fixpoint have_same_sty (T1 T2: STy) : bool :=
    match T1 with
    | STyBoolean => match T2 with
                    | STyBoolean => true
                    | STyTemplate => true
                    | _ => false
                    end
    | STyNumeric => match T2 with
                    | STyNumeric => true
                    | STyTemplate => true
                    | _ => false
                    end
    | STyString => match T2 with
                    | STyString => true
                    | STyTemplate => true
                    | _ => false
                    end
    | STyArrow PT1 RT1 => match T2 with
                        | STyArrow PT2 RT2 => (have_same_sty PT1 PT2) && (have_same_sty RT1 RT2)
                        | _ => false
                        end
    | STyVoid => match T2 with
                | STyVoid => true
                | STyTemplate => true
                | _ => false
                end
    | STyList ST1 ST2 => match T2 with
                    | STyList ST1' ST2' => (have_same_sty ST1 ST1') && (have_same_sty ST2 ST2')
                    | _ => false
                    end
    | STyArray T => match T2 with
                    | STyArray T' => have_same_sty T T'
                    | STyTemplate => true
                    | _ => false
                    end
    | STyExternal s1 => match T2 with
                        | STyExternal s2 => (s1 =? s2) %string
                        | STyTemplate => true
                        | _ => false
                        end
    | STyGeneric0 s1 => match T2 with
                        | STyGeneric0 s2 => (s1 =? s2)%string
                        | STyTemplate => true
                        | _ => false
                        end
    | STyGeneric1 s1 ST1 => match T2 with
                        | STyGeneric1 s2 ST2 => (s1 =? s2)%string && (have_same_sty ST1 ST2)
                        | STyTemplate => true
                        | _ => false
                        end
    | STyGeneric2 s1 ST1 ST2 => match T2 with
                            | STyGeneric2 s2 ST1' ST2' => (s1 =? s2)%string && (have_same_sty ST1 ST1') && (have_same_sty ST2 ST2')
                            | STyTemplate => true
                            | _ => false
                            end 
    | STyTemplate => true
    | STyClass _ => true
    end.
Open Scope string_scope.

Definition have_son_sty (T1 T2: STy) : bool := 
    match T1 with
    | STyBoolean => match T2 with
                    | STyBoolean => true
                    | _ => false
                    end
    | STyNumeric => match T2 with
                    | STyNumeric => true
                    | _ => false
                    end
    | STyString => match T2 with
                    | STyString => true
                    | _ => false
                    end
    | STyArrow PT1 RT1 => match T2 with
                        | STyArrow PT2 RT2 => (have_same_sty PT1 PT2) && (have_same_sty RT1 RT2)
                        | _ => false
                        end
    | STyVoid => match T2 with
                | STyVoid => true
                | _ => false
                end
    | STyList ST1 ST2 => match T2 with
                    | STyList ST1' ST2' => (have_same_sty ST1 ST1') && (have_same_sty ST2 ST2')
                    | _ => false
                    end 
    | STyArray ST => match T2 with
                    | STyArray ST' => have_same_sty ST ST'
                    | _ => false
                    end
    | STyExternal s1 => match T2 with
                        | STyExternal s2 => (s1 =? s2) %string
                        | _ => false
                        end
    | STyGeneric0 s1 => match T2 with
                        | STyGeneric0 s2 => (s1 =? s2)%string
                        | _ => false
                        end
    | STyGeneric1 s1 ST1 => match T2 with
                        | STyGeneric1 s2 ST2 => match s2 with
                                                  | "LinkedList"%string => ((s1 =? "List") || (s1 =? "Queue")) && (have_same_sty ST1 ST2)
                                                  | "ArrayList"%string => (s1 =? "List")%string && (have_same_sty ST1 ST2)
                                                  | "HashSet"%string => ((s1 =? "Set") || (s1 =? "HashSet")) && (have_same_sty ST1 ST2)                                        
                                                  | _ => (s1 =? s2)%string
                                                  end 
                        | _ => false
                        end
    | STyGeneric2 s1 ST1 ST2 => match T2 with
                            | STyGeneric2 s2 ST1' ST2' => match s2 with
                                                      | "HashMap"%string => (s1 =? "Map")%string && (have_same_sty ST1 ST1') && (have_same_sty ST2 ST2')
                                                      | _ => (s1 =? s2)%string && (have_same_sty ST1 ST1') && (have_same_sty ST2 ST2')
                                                      end
                            | _ => false  
                            end
    | STyTemplate => true
    | STyClass _ => true
    end.


Close Scope string_scope.

(* 处理不了T以其他形式出现的情况 *)
Fixpoint hasResultType (PT RT PT' TT:STy): option(STy):= 
    match PT with
    | STyList T1 T2 => match PT' with
                        | STyList T1' T2' => match T1 with
                                            | STyTemplate => match TT with
                                                            | STyVoid => hasResultType T2 RT T2' T1'
                                                            | _ => if (have_son_sty T1' TT) then hasResultType T2 RT T2' TT else None
                                                            end
                                            | STyList STyTemplate STyVoid => match TT with
                                                                    | STyVoid => Some(calRT RT T1')
                                                                    | _ => None
                                                                    end

                                            | _ => if (have_son_sty T1 T1') then hasResultType T2 RT T2' TT else None
                                            end
                                            
                        | _ => None
                        end
    | STyVoid => Some(calRT RT TT)
    | _ => None                                 
    end.
Definition have_right_sub (STy1 STy2: STy) :=
    match STy1 with
    | STyNumeric => match STy2 with
                    | STyNumeric => true
                    | _ => false
                    end
    | STyString => match STy2 with
                    | STyString => true
                    | _ => false
                    end
    | _ => false
    end.


Definition CCollections : partial_map STy := (
                                        "sort"|-><([(STyGeneric1 "List" STyTemplate)]->STyVoid)>;
                                        "reverse"|-><([(STyGeneric1 "List" STyTemplate)]->STyVoid)>).
                                        
Definition CArrays : partial_map STy := (
                                        "binarySearch"|-> <([(STyArray STyNumeric); STyNumeric; STyNumeric; STyNumeric]-> STyNumeric)>; 
                                        "sort"|-><([(STyArray STyNumeric)]->STyVoid)>; 
                                        "fill"|-><([(STyArray STyNumeric); STyNumeric]->STyVoid)>; 
                                        "copyOf"|-><([(STyArray STyNumeric); STyNumeric]->(STyArray STyNumeric))>; 
                                        "copyOfRange"|-><([(STyArray STyNumeric); STyNumeric; STyNumeric]->(STyArray STyNumeric))>;
                                        "asList"|-> <([(STyList STyTemplate STyVoid)]-> (STyGeneric1 "List" STyTemplate))>).
Definition CBigInteger : partial_map STy := ( "compareTo"|-><([(STyExternal "BigInteger")]-> STyNumeric)>;
                                              "xor"|-> <([(STyExternal "BigInteger")]-> (STyExternal "BigInteger"))>;
                                              "and"|-> <([(STyExternal "BigInteger")]-> (STyExternal "BigInteger"))>;
                                              "or"|-> <([(STyExternal "BigInteger")]-> (STyExternal "BigInteger"))>;
                                              "not"|-> <([(STyExternal "BigInteger")]-> (STyExternal "BigInteger"))>;
                                              "shiftLeft"|-> <([STyNumeric]->(STyExternal "BigInteger"))>;
                                              "toString"|-> <([STyNumeric]->STyString)>).

                                        
Definition CInteger : partial_map STy:= (
                                        "MAX_VALUE"|->STyNumeric;
                                        "MIN_VALUE"|->STyNumeric;
                                        "parseInt"|-><([STyString; STyNumeric]->STyNumeric)>; 
                                        "toBinaryString"|-><([STyNumeric]->STyString)>;
                                        "equals"|-><([STyNumeric]->STyBoolean)>; 
                                        "highestOneBit"|-><([STyNumeric]->STyNumeric)>; 
                                        "bitCount"|-><([STyNumeric]->STyNumeric)>; 
                                        "compare"|-><([STyNumeric;STyNumeric]->STyNumeric)>; 
                                        "intValue"|-><([]->STyNumeric)>; 
                                        "lowestOneBit"|-><([STyNumeric]->STyNumeric)>; 
                                        "numberOfLeadingZeros"|-><([STyNumeric]->STyNumeric)>).
Definition CMath : partial_map STy := (
                                      "min"|-> <([STyNumeric;STyNumeric]->STyNumeric)> ; 
                                      "max"|-><([STyNumeric;STyNumeric]->STyNumeric)> ; 
                                      "abs"|-><([STyNumeric]->STyNumeric)>; 
                                      "pow"|-><([STyNumeric;STyNumeric]->STyNumeric)>; 
                                      "log10"|-><([STyNumeric]->STyNumeric)>; 
                                      "sqrt"|-><([STyNumeric]->STyNumeric)>; 
                                      "log" |-><([STyNumeric]->STyNumeric)>; 
                                      "round"|-><([STyNumeric]->STyNumeric)>; 
                                      "floor"|-><([STyNumeric]->STyNumeric)>; 
                                      "ceil"|-><([STyNumeric]->STyNumeric)>; 
                                      "random"|-><([]->STyNumeric)>; 
                                      "cos"|-><([STyNumeric]->STyNumeric)>; 
                                      "sin"|-><([STyNumeric]->STyNumeric)>; 
                                      "tan"|-><([STyNumeric]->STyNumeric)>; 
                                      "floorDiv"|-><([STyNumeric;STyNumeric]->STyNumeric)>; 
                                      "floorMod"|-><([STyNumeric;STyNumeric]->STyNumeric)>).
Definition CStringBuilder : partial_map STy := (
                                               "append"|-><([STyTemplate]->[])>; 
                                               "reverse"|-><([]->(STyExternal "StringBuilder"))>; 
                                               "toString"|-><([]->STyString)>; 
                                               "setLength"|-><([STyNumeric]->STyVoid)>).
Definition CString : partial_map STy := (
                                        "length"|-><([]->STyNumeric)>;
                                        "charAt"|-><([STyNumeric]->STyString)>; 
                                        "indexOf"|-><([STyString]->STyNumeric)>; 
                                        "toCharArray"|-><([]->(STyArray STyString))>; 
                                        "startsWith"|-><([STyString]->STyBoolean)>; 
                                        "endsWith"|-><([STyString]->STyBoolean)>; 
                                        "valueOf"|-><([STyNumeric]->STyString)>; 
                                        "lastIndexOf"|-><([STyString]->STyNumeric)>; 
                                        "trim"|-><([]->STyString)>; 
                                        "replaceFirst"|-><([STyString;STyString]->STyString)>; 
                                        "replaceAll"|-><([STyString;STyString]->STyString)>; 
                                        "split"|-><([STyString]->(STyArray STyString))>).
Definition CCharacter : partial_map STy := (
                                            "isDigit"|-><([STyNumeric]->STyBoolean)>;
                                            "isWhitespace"|-><([STyNumeric]->STyBoolean)>; 
                                            "getNumericValue"|-><([STyNumeric]->STyNumeric)>; 
                                            "isLetter"|-><([STyNumeric]->STyBoolean)>; 
                                            "isLowerCase"|-><([STyNumeric]->STyBoolean)>; 
                                            "isUpperCase"|-><([STyNumeric]->STyBoolean)>; 
                                            "matches"|-><([STyString]->STyBoolean)>; 
                                            "hashCode"|-><([]->STyNumeric)>; 
                                            "toLowerCase"|-><([STyNumeric]->STyNumeric)>; 
                                            "toUpperCase"|-><([STyNumeric]->STyNumeric)>; 
                                            "charValue"|-><([]->STyNumeric)>; 
                                            "isLetterOrDigit"|-><([STyNumeric]->STyBoolean)>).
Definition CPrintStream : partial_map STy := (
                                             "println"|-><([STyString]->STyVoid)>).
Definition CSystem: partial_map STy := (
                                       "arraycopy"|-><([STyTemplate;STyNumeric;STyTemplate;STyNumeric;STyNumeric]->STyVoid)>; 
                                       "out"|->(STyExternal "CPrintStream")).
Definition CRandom : partial_map STy := (
                                         "nextInt"|-><([STyNumeric]->STyNumeric)>).
Definition CMatcher : partial_map STy := (
                                         "find"|-><([]->STyBoolean)>).
Definition CPattern : partial_map STy := (
                                         "matcher"|-><([STyString]->(STyExternal "CMatcher"))>).
Definition CLong: partial_map STy := (
                                     "parselong"|-><([STyString]->STyNumeric)>).
Definition COptionLong: partial_map STy := (
                                           "getAsLong"|-><([]->STyNumeric)>).
Definition CList (ST:STy) : partial_map STy := (     "isEmpty"|-><([]->STyBoolean)>;
                                                     "add"|-><([(STyList STyTemplate STyVoid)]->[])>; 
                                                     "remove"|-><([STyNumeric]->[])>; 
                                                     "get"|-><([STyNumeric]->ST)>;
                                                     "iterator"|->ST; 
                                                     "size"|-><([]->STyNumeric)>;
                                                     "addAll"|-><([STyTemplate]->STyBoolean)>; 
                                                     "toArray"|-><([]->(STyArray ST))>; 
                                                     "set"|-><([STyNumeric;ST]->ST)>;  
                                                     "subList"|-><([STyNumeric;STyNumeric]->(STyGeneric1 "List" ST))>).                                                 
Definition CLinkedList (ST:STy) : partial_map STy := (
                                                           "addFirst"|-><([ST]->STyVoid)>; 
                                                           "addLast"|-><([ST]->STyVoid)>; 
                                                           "removeFirst"|-><([]->ST)>; 
                                                           "removeLast"|-><([]->ST)>; 
                                                           "pollLast"|-><([]->ST)>; 
                                                           "pollFirst"|-><([]->ST)>; 
                                                           "getFirst"|-><([]->ST)>; 
                                                           "getLast"|-><([]->ST)>).
Definition CArrayList (ST:STy) : partial_map STy := (
                                                      "trimToSize"|-><([]->STyVoid)>; 
                                                      "ensureCapacity"|-><([STyNumeric]->STyVoid)>).                                                           
Definition CSet (ST:STy) : partial_map STy := (
                                                    "add"|-><([ST]->STyBoolean)>; 
                                                    "remove"|-><([ST]->[])>; 
                                                    "contains"|-><([ST]->STyBoolean)>;
                                                    "iterator"|->ST).
Definition CHashSet(ST:STy) : partial_map STy := (  "contains"|-><([ST]->STyBoolean)>;
                                                    "add"|-><([ST]->STyBoolean)>).
Definition CStack (ST:STy) : partial_map STy := (
                                                      "push"|-><([ST]->[])>; 
                                                      "pop"|-><([]->[ST])>; 
                                                      "isEmpty"|-><([]->STyBoolean)>; 
                                                      "peek"|-><([]->ST)>; 
                                                      "empty"|-><([]->STyBoolean)>).
Definition CQueue (ST:STy) : partial_map STy := (
                                                      "poll"|-><([]->(STyArray ST))>;
                                                      "isEmpty"|-><([]->STyBoolean)>;
                                                      "remove"|-><([]->ST)>;
                                                      "add" |-> <([ST]->STyBoolean)>).
Definition CArrayDeque (ST:STy) : partial_map STy := (
                                                           "clear"|-><([]->STyVoid)>; 
                                                           "offer"|-><([ST]->STyBoolean)>; 
                                                           "getLast"|-><([]->ST)>).
Definition CDeque (ST:STy) : partial_map STy := (
                                                      "peekFirst"|-><([]->ST)>; 
                                                      "peekLast"|-><([]->ST)>; 
                                                      "removeFirst"|-><([]->ST)>; 
                                                      "removeLast"|-><([]->ST)>; 
                                                      "pollFirst"|-><([]->ST)>; 
                                                      "pollLast"|-><([]->ST)>; 
                                                      "offerLast"|-><([ST]->STyBoolean)>; 
                                                      "offerFirst"|-><([ST]->STyBoolean)>).
Definition CMap (ST1 ST2:STy) : partial_map STy := (
                                                             "put"|-><([ST1;ST2]->[])>; 
                                                             "get"|-><([ST1]->ST2)>; 
                                                             "containsKey"|-><([ST1]->STyBoolean)>; 
                                                             "getOrDefault"|-><([ST1;ST2]->ST2)>;
                                                             "keySet"|-><([]->(STyGeneric1 "Set" ST1))>; 
                                                             "putIfAbsent"|-> <([ST1;ST2]->ST2)>).
Definition CHashMap (ST1 ST2:STy) : partial_map STy := (
                                                             "put"|-><([ST1;ST2]->[])>).
Definition CBuiltInArray : partial_map STy := (
                                                "length"|->STyNumeric ).
Open Scope string_scope.

Definition getClassMap (sty:STy)(Gamma: partial_map STy) : option(partial_map STy) :=
    match sty with
    | STyString => Some CString
    | STyExternal s => match s with
                        | "Arrays" => Some CArrays
                        | "Integer" => Some CInteger
                        | "BigInteger" => Some CBigInteger
                        | "Math" => Some CMath
                        | "StringBuilder" => Some CStringBuilder
                        | "String" => Some CString
                        | "Character" => Some CCharacter
                        | "PrintStream" => Some CPrintStream
                        | "System" => Some CSystem
                        | "Random" => Some CRandom
                        | "Matcher" => Some CMatcher
                        | "Pattern" => Some CPattern
                        | "Long" => Some CLong
                        | "Collections" => Some CCollections
                        | _ => match Gamma s with
                                | Some (STyClass ct) => Some (ct)
                                | _ => None
                                end
                        end
    | STyGeneric1 s T => match s with
                        | "List" => Some (CList T)
                        | "LinkedList" => Some (CLinkedList T)
                        | "Set" => Some (CSet T)
                        | "Stack" => Some (CStack T)
                        | "Queue" => Some (CQueue T)
                        | "Deque" => Some (CDeque T)
                        | "ArrayDeque" => Some (CArrayDeque T)
                        | "ArrayList" => Some (CArrayList T)
                        | "HashSet" => Some (CHashSet T)
                        | _ => None
                        end
    | STyGeneric2 s T1 T2 => match s with
                            | "Map" => Some (CMap T1 T2)
                            | "HashMap" => Some (CHashMap T1 T2)
                            | _ => None
                            end
    | STyArray T => Some CBuiltInArray
    | STyClass ct => Some ct
    | _ => None
    end.

Close Scope string_scope.

(*typing rules for terms*)
Reserved Notation "Gamma '|--' t '\in' T" (at level 101, T at level 0).
Inductive has_type : Context->Term->STy->Prop :=
    (*basic data structure*)
    | T_Var : forall Gamma x T,
        Gamma x = Some T ->
        Gamma |-- (TmVar x) \in T
    | T_Integer : forall Gamma n,
        Gamma |-- (TmInteger n) \in STyNumeric
    | T_Float : forall Gamma f,
        Gamma |-- (TmFloat f) \in STyNumeric
    | T_Char : forall Gamma c,
        Gamma |-- (TmChar c) \in STyString
    | T_String : forall Gamma s,
        Gamma |--  (TmString s) \in STyString
    | T_True : forall Gamma,
        Gamma |-- TmTrue \in STyBoolean
    | T_False : forall Gamma,
        Gamma |-- TmFalse \in STyBoolean
    | T_Null : forall Gamma T,
        Gamma |-- TmNull \in T (*null can have any type*)
    (*advanced data structure*)
    | T_Assign : forall Gamma x T t,
        (* x = t *)
        Gamma |-- x \in T ->
        Gamma |-- t \in T ->
        Gamma |-- (TmAssign x t) \in T
    | T_Conversion : forall Gamma T t, 
        (* (T)t *)
        Gamma |-- t \in STyNumeric ->
        SimplType T = STyNumeric ->
        Gamma |-- (TmConversion T t) \in STyNumeric
        (*only the conversions within numeric types are allowed*)
    | T_FieldAccess : forall Gamma tm f ct T sty,
        (* tm.f *)
        Gamma |-- tm \in sty ->
        getClassMap sty Gamma = Some ct ->
        ct f = Some T ->
        Gamma |-- TmFieldAccess tm f \in T
    | T_FieldAccess' : forall Gamma tm f ct T sty,
        (* tm.f *)
        Gamma |-- tm \in sty ->
        getClassMap sty Gamma = Some ct ->
        ct f = None ->
        Gamma |-- TmFieldAccess tm f \in T
    | T_TyFieldAccess : forall Gamma T f ct T',
        (* T.f *)
        getClassMap (SimplType T) Gamma = Some ct ->
        ct f = Some T' ->
        Gamma |-- TmTyFieldAccess T  f \in T'
    | T_ArrayAccess : forall Gamma tm1 tm2 T, 
        (* tm1[tm2] *)
        Gamma |-- tm1 \in ( STyArray T ) ->
        Gamma |-- tm2 \in STyNumeric ->
        Gamma |-- TmArrayAccess tm1 tm2 \in T
    | T_New : forall Gamma T param PT ct,
        (* new T(param) *)
        getClassMap (SimplType T) Gamma = Some ct ->
        ct constructor = Some ( STyArrow PT STyVoid ) ->
        Gamma |-- param \in PT ->
        Gamma |-- TmNew T param \in (SimplType T)
    | T_New' : forall Gamma T param PT ct,
        (* new T(param) *)
        getClassMap (SimplType T) Gamma = Some ct ->

        Gamma |-- param \in PT ->
        Gamma |-- TmNew T param \in (SimplType T)
    | T_NewArrayNoInit : forall Gamma T,
        (* new T *)
        Gamma |-- TmNewArrayNoInit T TmNil \in (SimplType T)
    | T_NewArrayNoInit' : forall Gamma T tm1 tm2 T',
        (* new T[tm1][tm2] *)
        Gamma |-- tm1 \in STyNumeric ->
        Gamma |-- TmNewArrayNoInit T tm2 \in T' ->
        Gamma |-- TmNewArrayNoInit T (TmList tm1 tm2) \in (STyArray T')
    | T_NewArrayInit : forall Gamma T param T',
        (* new T{tm} / new int[]{1,2} *)
        SimplType T = T' ->
        Gamma |-- param \in T' ->
        Gamma |-- TmNewArrayInit T param \in T'
    | T_MethodInvocation : forall Gamma tm m param ct PT RT PT' RT' sty,
        (* tm.m(param) *)
        Gamma |-- tm \in sty ->
        getClassMap sty Gamma= Some ct ->
        ct m = Some ( STyArrow PT RT ) ->
        Gamma |-- param \in PT' ->
        hasResultType PT RT PT' STyVoid = Some RT' ->
        Gamma |-- TmMethodInvocation tm m param \in RT'
    | T_MethodInvocation' : forall Gamma tm m param ct PT RT sty,
        (* tm.m(param) *)
        Gamma |-- tm \in sty ->
        getClassMap sty Gamma= Some ct ->
        ct m = None ->
        Gamma |-- param \in PT ->
        Gamma |-- TmMethodInvocation tm m param \in RT
    | T_TyMethodInvocation : forall Gamma T m param ct PT PT' RT RT',
        (* T.m(param) *)
        getClassMap (SimplType T) Gamma = Some ct ->
        ct m = Some ( STyArrow PT RT ) ->
        Gamma |-- param \in PT' ->
        hasResultType PT RT PT' STyVoid = Some RT' ->
        Gamma |-- TmTyMethodInvocation T m param \in RT'
    | T_TyMethodInvocation' : forall Gamma T m param ct PT RT,
        (* T.m(param) *)
        getClassMap (SimplType T) Gamma = Some ct ->
        ct m = None ->
        Gamma |-- param \in PT ->
        Gamma |-- TmTyMethodInvocation T m param \in RT
    | T_MethodInvocationNoObj : forall Gamma m param PT RT,
        (* m(param) *)
        Gamma m = Some ( STyArrow PT RT ) ->
        Gamma |-- param \in PT ->
        Gamma |-- TmMethodInvocationNoObj m param \in RT
    | T_Nil : forall Gamma,
        Gamma |-- TmNil \in STyVoid
    | T_List : forall Gamma tm1 tm2 T1 T2,
        (* tm1,tm2... *)
        Gamma |-- tm1 \in T1 ->
        Gamma |-- tm2 \in T2 ->
        Gamma |-- (TmList tm1 tm2) \in (STyList T1 T2)
    | T_EmptyArray : forall Gamma T,
        (* {} *)
        Gamma |-- TmEmptyArray \in (STyArray T)
    | T_ArrayConcat : forall Gamma tm1 tm2 T,
        (* { term1,term2 } *)
        Gamma |-- tm1 \in T ->
        Gamma |-- tm2 \in (STyArray T) ->
        Gamma |-- (TmArrayConcat tm1 tm2) \in (STyArray T)
    (*arithmetic term*)
    | T_Add : forall Gamma tm1 tm2,
        (* tm1 + tm2 *)
        Gamma |-- tm1 \in STyNumeric ->
        Gamma |-- tm2 \in STyNumeric ->
        Gamma |-- (TmAdd tm1 tm2) \in STyNumeric
    | T_Sub : forall Gamma tm1 tm2 STy1 STy2,
        (* tm1 - tm2 *)
        Gamma |-- tm1 \in STy1 ->
        Gamma |-- tm2 \in STy2 ->
        have_right_sub STy1 STy2 = true ->
        Gamma |-- (TmSub tm1 tm2) \in STyNumeric
    | T_Mul : forall Gamma tm1 tm2,
        (* tm1 * tm2 *)
        Gamma |-- tm1 \in STyNumeric ->
        Gamma |-- tm2 \in STyNumeric ->
        Gamma |-- (TmMul tm1 tm2) \in STyNumeric
    | T_Div : forall Gamma tm1 tm2,
        (* tm1 / tm2 *)
        Gamma |-- tm1 \in STyNumeric ->
        Gamma |-- tm2 \in STyNumeric ->
        Gamma |-- (TmDiv tm1 tm2) \in STyNumeric
    | T_Mod : forall Gamma tm1 tm2,
        (* tm1 % tm2 *)
        Gamma |-- tm1 \in STyNumeric ->
        Gamma |-- tm2 \in STyNumeric ->
        Gamma |-- (TmMod tm1 tm2) \in STyNumeric
    | T_Neg : forall Gamma tm,
        (* -tm *)
        Gamma |-- tm \in STyNumeric ->
        Gamma |-- (TmNeg tm) \in STyNumeric
    | T_ShiftL : forall Gamma tm1 tm2,
        (* tm1 << tm2 *)
        Gamma |-- tm1 \in STyNumeric ->
        Gamma |-- tm2 \in STyNumeric ->
        Gamma |-- (TmShiftL tm1 tm2) \in STyNumeric
    | T_ShiftR : forall Gamma tm1 tm2,
        (* tm1 >> tm2 *)
        Gamma |-- tm1 \in STyNumeric ->
        Gamma |-- tm2 \in STyNumeric ->
        Gamma |-- (TmShiftR tm1 tm2) \in STyNumeric
    | T_BitAnd : forall Gamma tm1 tm2,
        (* tm1 & tm2 *)
        Gamma |-- tm1 \in STyNumeric ->
        Gamma |-- tm2 \in STyNumeric ->
        Gamma |-- (TmBitAnd tm1 tm2) \in STyNumeric
    | T_BitOr : forall Gamma tm1 tm2,
        (* tm1 | tm2 *)
        Gamma |-- tm1 \in STyNumeric ->
        Gamma |-- tm2 \in STyNumeric ->
        Gamma |-- (TmBitOr tm1 tm2) \in STyNumeric
    | T_BitXor : forall Gamma tm1 tm2,
        (* tm1 ^ tm2 *)
        Gamma |-- tm1 \in STyNumeric ->
        Gamma |-- tm2 \in STyNumeric ->
        Gamma |-- (TmBitXor tm1 tm2) \in STyNumeric
    | T_BitNot : forall Gamma tm,
        (* ~tm *)
        Gamma |-- tm \in STyNumeric ->
        Gamma |-- (TmBitNot tm) \in STyNumeric
    | T_PostInc : forall Gamma tm,
        (* tm++ *)
        Gamma |-- tm \in STyNumeric ->
        Gamma |-- (TmPostInc tm) \in STyNumeric
    | T_PostDec : forall Gamma tm,
        (* tm-- *)
        Gamma |-- tm \in STyNumeric ->
        Gamma |-- (TmPostDec tm) \in STyNumeric
    | T_PreInc : forall Gamma tm,
        (* ++tm *)
        Gamma |-- tm \in STyNumeric ->
        Gamma |-- (TmPreInc tm) \in STyNumeric
    | T_PreDec : forall Gamma tm,
        (* --tm *)
        Gamma |-- tm \in STyNumeric ->
        Gamma |-- (TmPreDec tm) \in STyNumeric
    (*logic term*)
    | T_Eq : forall Gamma tm1 tm2 T,
        (* tm1 == tm2 *)
        Gamma |-- tm1 \in T ->
        Gamma |-- tm2 \in T ->
        Gamma |-- (TmEq tm1 tm2) \in STyBoolean
    | T_Ne : forall Gamma tm1 tm2 T,
        (* tm1 != tm2 *)
        Gamma |-- tm1 \in T ->
        Gamma |-- tm2 \in T ->
        Gamma |-- (TmNe tm1 tm2) \in STyBoolean
    | T_Lt : forall Gamma tm1 tm2,
        (* tm1 < tm2 *)
        Gamma |-- tm1 \in STyNumeric ->
        Gamma |-- tm2 \in STyNumeric ->
        Gamma |-- (TmLt tm1 tm2) \in STyBoolean
    | T_Le : forall Gamma tm1 tm2,
        (* tm1 <= tm2 *)
        Gamma |-- tm1 \in STyNumeric ->
        Gamma |-- tm2 \in STyNumeric ->
        Gamma |-- (TmLe tm1 tm2) \in STyBoolean
    | T_Gt : forall Gamma tm1 tm2,
        (* tm1 > tm2 *)
        Gamma |-- tm1 \in STyNumeric ->
        Gamma |-- tm2 \in STyNumeric ->
        Gamma |-- (TmGt tm1 tm2) \in STyBoolean
    | T_Ge : forall Gamma tm1 tm2,
        (* tm1 >= tm2 *)
        Gamma |-- tm1 \in STyNumeric ->
        Gamma |-- tm2 \in STyNumeric ->
        Gamma |-- (TmGe tm1 tm2) \in STyBoolean
    | T_And : forall Gamma tm1 tm2,
        (* tm1 && tm2 *)
        Gamma |-- tm1 \in STyBoolean ->
        Gamma |-- tm2 \in STyBoolean ->
        Gamma |-- (TmAnd tm1 tm2) \in STyBoolean
    | T_Or : forall Gamma tm1 tm2,
        (* tm1 || tm2 *)
        Gamma |-- tm1 \in STyBoolean ->
        Gamma |-- tm2 \in STyBoolean ->
        Gamma |-- (TmOr tm1 tm2) \in STyBoolean
    | T_Not : forall Gamma tm,
        (* !tm *)
        Gamma |-- tm \in STyBoolean ->
        Gamma |-- (TmNot tm) \in STyBoolean
    | T_Choose : forall Gamma tm1 tm2 tm3 T,
        (* tm1 ? tm2 : tm3 *)
        Gamma |-- tm1 \in STyBoolean ->
        Gamma |-- tm2 \in T ->
        Gamma |-- tm3 \in T ->
        Gamma |-- (TmChoose tm1 tm2 tm3) \in T
where "Gamma '|--' t '\in' T" := (has_type Gamma t T).
(*typing rules for statements*)
Reserved Notation "Gamma1 '--' s '-->' Gamma2" (at level 101, s at level 0, Gamma2 at level 0).
Inductive well_type_statement : Context->Statement->Context->Prop :=
    | T_Skip : forall Gamma,
        Gamma -- <|skip|> --> Gamma
    | T_DeclInit : forall Gamma x tm T T' T'',
        (* T x = tm *)
        SimplType T = T' ->
        Gamma |-- tm \in T'' ->
        have_son_sty T' T'' = true ->
        Gamma -- (StDeclInit T x tm) --> (x|->T';Gamma)
    | T_DeclNoInit : forall Gamma x T T',
        (* T x *)
        SimplType T = T' ->
        Gamma -- (StDeclNoInit T x) --> (x|->T';Gamma)
    | T_If : forall Gamma1 tm s Gamma2,
        Gamma1 |-- tm \in STyBoolean ->
        Gamma1 -- s --> Gamma2 ->
        Gamma1 -- <| if ( tm ) { s } |> --> Gamma1
        (*changes in s don't take effect outside*)
    | T_IfElse : forall Gamma1 tm s1 s2 Gamma2 Gamma3,
        Gamma1 |-- tm \in STyBoolean ->
        Gamma1 -- s1 --> Gamma2 ->
        Gamma1 -- s2 --> Gamma3 ->
        Gamma1 -- <| if ( tm ) { s1 } else { s2 } |> --> Gamma1
        (*changes in s1 and s2 don't take effect outside*)
    | T_While : forall Gamma1 tm s Gamma2,
        Gamma1 |-- tm \in STyBoolean ->
        Gamma1 -- s --> Gamma2 ->
        Gamma1 -- <| while ( tm ) { s } |> --> Gamma1
    | T_DoWhile : forall Gamma1 s tm Gamma2,
        Gamma1 -- s --> Gamma2 ->
        Gamma2 |-- tm \in STyBoolean ->
        Gamma1 -- <| do { s } while ( tm ) |> --> Gamma1
    | T_For : forall Gamma1 s1 s2 tm1 tm2 T Gamma2 Gamma3,
        Gamma1 -- s1 --> Gamma2 ->
        Gamma2 |-- tm1 \in STyBoolean ->
        Gamma2 |-- tm2 \in T ->
        Gamma2 -- s2 --> Gamma3 ->
        Gamma1 -- <| for ( s1 ;; tm1 ;; tm2 ) { s2 } |> --> Gamma1
    | T_Foreach : forall Gamma1 x T T' T'' tm s Gamma2,
        SimplType T = T' ->
        Gamma1 |-- tm \in T'' ->
        iterable T' T'' ->
        (x|->T';Gamma1) -- s --> Gamma2 ->
        Gamma1 -- (StForeach T x tm s) --> Gamma1
    | T_Return : forall Gamma tm T T',
        Gamma |-- tm \in T' ->
        Gamma return' = Some T ->
        have_son_sty T T' = true ->
        Gamma -- <| Return tm |> --> Gamma
    | T_Continue : forall Gamma,
        Gamma -- <| continue |> --> Gamma
    | T_Break : forall Gamma,
        Gamma -- <| break |> --> Gamma
    | T_Expression : forall Gamma tm T,
        Gamma |-- tm \in T ->
        Gamma -- <| tm |> --> Gamma
    | T_Concat : forall Gamma1 s1 Gamma2 s2 Gamma3,
        Gamma1 -- s1 --> Gamma2 ->
        Gamma2 -- s2 --> Gamma3 ->
        Gamma1 -- (StConcat s1 s2) --> Gamma3
where "Gamma1 '--' s '-->' Gamma2" := (well_type_statement Gamma1 s Gamma2).

(*extract all the declaration types in the formal arguments*)
Fixpoint DeclsInStatement' (s:Statement) : list STy :=
    match s with
    | StDeclInit T x t => SimplType T :: nil 
    | StDeclNoInit T x => SimplType T :: nil
    | StConcat s1 s2 => (DeclsInStatement' s1) ++ (DeclsInStatement' s2)
    | _ => nil
    end.
Fixpoint listTy2TyList (l:list STy) : STy :=
    match l with
    | nil => STyVoid
    | T :: l' => STyList T (listTy2TyList l')
    end.
Definition DeclsInStatement (s:Statement) : STy :=
    listTy2TyList (DeclsInStatement' s).

(*typing rules for class_components*)
Reserved Notation "Gamma '|-' c '\in' T" (at level 101, T at level 0).
Inductive has_type_class_component :
    Context->ClassComponent->Context->Prop :=
    | T_FieldDeclNoInit : forall Gamma T T' x modif,
        (* modifier T x; *)
        SimplType T = T' ->
        Gamma |- (FieldDeclNoInit modif T x) \in (x|->T';Gamma)
    | T_FieldDeclInit : forall Gamma T T' T'' x modif tm,
        (* modifier T x = tm; *)
        SimplType T = T' ->
        Gamma |-- tm \in T'' ->
        have_son_sty T' T'' = true ->
        Gamma |- (FieldDeclInit modif T x tm) \in (x|->T';Gamma)
    | T_ConstructorDecl : forall Gamma1 Gamma2 s1 s2 T,
        (* Constructor (s1) {s2} *)
        Gamma1 -- s1 --> Gamma2 ->
        DeclsInStatement s1 = T ->
        Gamma2 -- s2 --> Gamma2 ->
        Gamma1 |- (ConstructorDecl s1 s2) \in (constructor|->(STyArrow T STyVoid);Gamma1)
    | T_MethodDecl : forall Gamma1 Gamma2 Gamma3 T PT RT param s modif m,
        (* modifier T m (param) {s} *)
        SimplType T = RT ->
        Gamma1 -- param --> Gamma2 ->
        DeclsInStatement param = PT ->
        (m|->(STyArrow PT RT);return'|->RT;Gamma2) -- s --> Gamma3 -> (*recursion*)
        Gamma1 |- (MethodDecl modif T m param s) \in (m|->(STyArrow PT RT);Gamma1)
    | T_ComponentConcat : forall Gamma1 Gamma2 Gamma3 c1 c2,
        Gamma1 |- c1 \in Gamma2 ->
        Gamma2 |- c2 \in Gamma3 ->
        Gamma1 |- (ComponentConcat c1 c2) \in Gamma3
where "Gamma '|-' c '\in' T" := (has_type_class_component Gamma c T).

(*extract all the declarations in the class definition*)
Fixpoint DeclsInClassDefinition (c: ClassComponent) : ClassType :=
    match c with
    | FieldDeclNoInit m T x => (x|->SimplType T;empty)
    | FieldDeclInit m T x tm => (x|->SimplType T;empty)
    | ConstructorDecl s1 s2 => (constructor|->(STyArrow (DeclsInStatement s1) STyVoid);empty)
    | MethodDecl m T1 x s1 s2 => (x|->(STyArrow (DeclsInStatement s1) (SimplType T1));empty)
    | ComponentConcat c1 c2 => updateMerge (DeclsInClassDefinition c1) (DeclsInClassDefinition c2)
    end.

(*typing rules for programs*)
Reserved Notation "Gamma1 '--' p '->' Gamma2" (at level 101,p at level 0, Gamma2 at level 0).
Inductive well_type_program : Context->Program->Context->Prop :=
    | T_ClassDecl : forall Gamma1 Gamma2 name c T,
        (*class name {c}*)
        DeclsInClassDefinition c = T ->
        (this |-> STyClass T;Gamma1) |- c \in Gamma2 ->
        Gamma1 -- (ClassDecl name c) ->(name|->STyClass T; Gamma1)
    | T_ImportDecl : forall Gamma1 n1 n2,
        (*Import n1.n2*)
        Gamma1 -- (ImportDecl n1 n2) -> (Gamma1)
    | T_ProgramConcat : forall Gamma1 p1 Gamma2 p2 Gamma3,
        Gamma1 -- p1 -> Gamma2 ->
        Gamma2 -- p2 -> Gamma3 ->
        Gamma1 -- (ProgramConcat p1 p2) -> Gamma3
where "Gamma1 '--' p '->' Gamma2" := (well_type_program Gamma1 p Gamma2).

Definition program_well_typed (p:Program) : Prop :=
    exists Gamma, empty -- p -> Gamma.

(*extract the well-typed program*)
Ltac get_the_exists_term_tac H :=
  match H with
  | @ex_intro _ _ ?x _ =>
      constr:(x)
  end.
Notation "'the_exists_term' H" :=
  ltac:(
    first 
    [ is_const H;
      let H0 := eval hnf in H in
      let x := get_the_exists_term_tac H0 in
      exact x
    | let x := get_the_exists_term_tac H in
      exact x
    ])
  (at level 1, H at level 0).

Module Syntax_Example.
(*Variables Definitions*)
Definition A : string := "a".
Definition B : string := "b".
Definition C : string := "c".
Definition X : string := "x".
Definition Y : string := "y".
Definition Z : string := "z".
Definition Math : string := "Math".

(*Unfolding Notations*)
Hint Unfold X : core.
Hint Unfold Y : core.
Hint Unfold Z : core.


(* Definition Program1 :=
<|  class Y { 
    Int main ( Int X = 0) { 
        Return X + 1
        }
    }   |>.
Example program1_well_typed : program_well_typed Program1.
Proof.
    unfold program_well_typed. eexists. 
    eapply T_ClassDecl. reflexivity.
    eapply T_MethodDecl.
    - reflexivity.
    - apply T_DeclInit. reflexivity. apply T_Integer.
    - simpl. reflexivity.
    - simpl. eapply T_Return. 
        * apply T_Add. apply T_Var. reflexivity. apply T_Integer. 
        * reflexivity.
Qed.

Open Scope string_scope.
Example program1_well_typed' : exists p, program_well_typed p.
Proof.
    unfold program_well_typed. eexists. eexists.
    eapply T_ClassDecl with(name:=Y). reflexivity.
    eapply T_MethodDecl with (modif:="")(T:=TyInt)(m:=main).
    - reflexivity.
    - eapply T_DeclInit with(T:=TyInt)(x:=X). reflexivity. 
      apply T_Integer with (n:=0).
    - reflexivity.
    - eapply T_Return. 
        * eapply T_Add. eapply T_Var with(x:=X). reflexivity. eapply T_Integer with(n:=1).
        * reflexivity.
Defined.

Definition prog1 := the_exists_term (program1_well_typed').
Print prog1.

Definition program2 := <|  

    class X {
        Int Z;
        Int main ( skip ) { 
            G("List"<Int>) A = new G("List"<Int>)([]);
            A . "add"([this \. Z]);
            Return Z
        }
    } |>.


Example program2_well_typed : program_well_typed program2.
Proof with (simpl;try(reflexivity)).
    unfold program_well_typed. eexists. 

    eapply T_ClassDecl. reflexivity.
    { eapply T_ComponentConcat.
        
        - eapply T_FieldDeclNoInit. reflexivity.
        - eapply T_MethodDecl...
            + apply T_Skip.
            + eapply T_Concat.
                * apply T_DeclInit. reflexivity. eapply T_New'...
                    { apply T_Nil. }
                * eapply T_Concat.
                    -- eapply T_Expression. eapply T_MethodInvocation.
                        { eapply T_Var... }
                        { reflexivity. }
                        { reflexivity. }
                        { eapply T_List. eapply T_FieldAccess. eapply T_Var. reflexivity. reflexivity. reflexivity.  apply T_Nil. }        
                        { reflexivity. }           
                    -- eapply T_Return... eapply T_Var... 
    }
Defined.

Example program2_well_typed' : exists p, program_well_typed p.
Proof with (simpl;try(reflexivity)).
    unfold program_well_typed. eexists. eexists.
    eapply T_ProgramConcat.
    eapply T_ImportDecl with(n1:="Java.util")(n2:="List").
    eapply T_ClassDecl with(name:=X). 
    + reflexivity.
    + eapply T_ComponentConcat.
        - eapply T_FieldDeclNoInit with(modif:="public")(T:=TyInt)(x:=Z)...
        - eapply T_MethodDecl with(modif:="public")(T:=TyInt)(m:="main") ...
            ++ apply T_Skip. 
            ++ eapply T_Concat.
                * apply T_DeclInit with(T:=TyGeneric1 "List" TyInt)(x:=A)... 
                  eapply T_New' with(T:=TyGeneric1 "List" TyInt)... apply T_Nil. 
                * eapply T_Concat.
                    -- eapply T_Expression. 
                       eapply T_MethodInvocation with (tm:=TmVar A)(m:="add").
                        { eapply T_Var... }
                        { reflexivity. }
                        { reflexivity. }
                        { eapply T_List. eapply T_FieldAccess with(tm:=this)(f:=Z). eapply T_Var. reflexivity. reflexivity. reflexivity. apply T_Nil. }   
                        { reflexivity. }             
                    -- eapply T_Return... eapply T_Var with(x:=Z)... 
Defined.

Definition prog2 := the_exists_term (program2_well_typed').
Print prog2.

Example well_type_foreach : well_type_statement (Y|->STyClass ("iterator"|->STyNumeric) ) (StForeach(TyInt) X (TmVar Y) StSkip ) (Y|->STyClass ("iterator"|->STyNumeric) ).
Proof with (simpl;try(reflexivity)).
    eapply T_Foreach...  
    eapply T_Var... 
    reflexivity. 
    eapply T_Skip.
Defined. *)
Close Scope string_scope.

End Syntax_Example.
