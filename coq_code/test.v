From PLF Require Import Syntax.
Open Scope string_scope.

Example prog_well_typed : exists p, program_well_typed p.
Proof with (simpl;try(reflexivity)).
unfold program_well_typed.
eexists.
eexists.
eapply T_ClassDecl with(name:="Solution")...
eapply T_ComponentConcat...
{ eapply T_FieldDeclInit with(modif:="private")(T:=(TyArray TyBool))(x:="used")...
  eapply T_NewArrayNoInit' with(T:=TyBool)...
  { eapply T_Integer with(n:=9)... }
  { eapply T_NewArrayNoInit with(T:=TyBool)... } }
{ eapply T_MethodDecl with(modif:="private")(T:=TyBool)(m:="isValid")...
  { eapply T_Skip... }
  { eapply T_Concat...
    { eapply T_Return...
      eapply T_ArrayAccess...
      { eapply T_Var with(x:="used")... }
      { eapply T_Integer with(n:=0)... } }
    { eapply T_Skip... } } }
  Unshelve.
  all: apply STyVoid.
Defined.
Definition prog := the_exists_term (prog_well_typed).
Print prog.