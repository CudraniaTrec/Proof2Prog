From PLF Require Import Syntax.
Open Scope string_scope.

Example prog_well_typed : exists p, program_well_typed p.
Proof.
unfold program_well_typed.
eexists.
eexists.
eapply T_ProgramConcat.
{ eapply T_ImportDecl with(n1:="java.io")(n2:="*"). }
{ eapply T_ProgramConcat.
  { eapply T_ImportDecl with(n1:="java.lang")(n2:="*"). }
  { eapply T_ProgramConcat.
    { eapply T_ImportDecl with(n1:="java.util")(n2:="*"). }
    { eapply T_ProgramConcat.
      { eapply T_ImportDecl with(n1:="java.math")(n2:="*"). }
      { eapply T_ClassDecl with(name:="AreaPolygon").
        { simpl. try reflexivity. }
        { eapply T_MethodDecl with(modif:="public static")(T:=TyDouble)(m:="areaPolygon").
          { simpl. try reflexivity. }
          { eapply T_Concat.
            { eapply T_DeclNoInit with(T:=TyInt)(x:="s").
              simpl. try reflexivity. }
            { eapply T_Concat.
              { eapply T_DeclNoInit with(T:=TyInt)(x:="l").
                simpl. try reflexivity. }
              { eapply T_Skip. } } }
          { simpl. try reflexivity. }
          { eapply T_Concat.
            { eapply T_Return.
              { eapply T_Div.
                { eapply T_Mul.
                  { eapply T_Var with(x:="s").
                    simpl. try reflexivity. }
                  { eapply T_Mul.
                    { eapply T_Var with(x:="l").
                      simpl. try reflexivity. }
                    { eapply T_Var with(x:="l").
                      simpl. try reflexivity. } } }
                { eapply T_Mul.
                  { eapply T_Integer with(n:=4). }
                  { eapply T_TyMethodInvocation with(m:="tan")(T:=(TyExternal "Math")).
                    { simpl. try reflexivity. }
                    { simpl. try reflexivity. }
                    { eapply T_List.
                      { eapply T_Div.
                        { eapply T_TyFieldAccess with(f:="PI")(T:=(TyExternal "Math")).
                          { simpl. try reflexivity. }
                          { simpl. try reflexivity. } }
                        { eapply T_Var with(x:="s").
                          simpl. try reflexivity. } }
                      { eapply T_Nil. } }
                    { simpl. try reflexivity. } } } }
              { simpl. try reflexivity. }
              { simpl. try reflexivity. } }
            { eapply T_Skip. } } } } } } }
  Unshelve.
  all: apply STyVoid.
Defined.
Definition prog := the_exists_term (prog_well_typed).
Print prog.