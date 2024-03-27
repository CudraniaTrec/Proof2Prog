From PLF Require Import Syntax.
Open Scope string_scope.

Example prog_well_typed : exists p, program_well_typed p.
Proof with (simpl;try(reflexivity)).
unfold program_well_typed.
eexists.
eexists.
eapply T_ClassDecl with(name:="Solution")...
eapply T_ComponentConcat...
{ eapply T_FieldDeclInit with(modif:="")(T:=TyInt)(x:="c")...
  eapply T_Char with(c:=99)... }
{ eapply T_ComponentConcat...
  { eapply T_FieldDeclInit with(modif:="")(T:=TyInt)(x:="a")...
    eapply T_Integer with(n:=2860)... }
  { eapply T_FieldDeclInit with(modif:="")(T:=TyLong)(x:="l")...
    eapply T_Integer with(n:=1)... } }
Defined.
Definition prog := the_exists_term (prog_well_typed).
Print prog.