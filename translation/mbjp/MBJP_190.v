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
      { eapply T_ClassDecl with(name:="CountIntgralPoints").
        { simpl. try reflexivity. }
        { eapply T_MethodDecl with(modif:="public static")(T:=TyInt)(m:="countIntgralPoints").
          { simpl. try reflexivity. }
          { eapply T_Concat.
            { eapply T_DeclNoInit with(T:=TyInt)(x:="x1").
              simpl. try reflexivity. }
            { eapply T_Concat.
              { eapply T_DeclNoInit with(T:=TyInt)(x:="y1").
                simpl. try reflexivity. }
              { eapply T_Concat.
                { eapply T_DeclNoInit with(T:=TyInt)(x:="x2").
                  simpl. try reflexivity. }
                { eapply T_Concat.
                  { eapply T_DeclNoInit with(T:=TyInt)(x:="y2").
                    simpl. try reflexivity. }
                  { eapply T_Skip. } } } } }
          { simpl. try reflexivity. }
          { eapply T_Concat.
            { eapply T_Return.
              { eapply T_Mul.
                { eapply T_Add.
                  { eapply T_Sub.
                    { eapply T_Var with(x:="x1").
                      simpl. try reflexivity. }
                    { eapply T_Var with(x:="x2").
                      simpl. try reflexivity. }
                    { simpl. try reflexivity. } }
                  { eapply T_Integer with(n:=1). }
                  { simpl. try reflexivity. } }
                { eapply T_Add.
                  { eapply T_Sub.
                    { eapply T_Var with(x:="y1").
                      simpl. try reflexivity. }
                    { eapply T_Var with(x:="y2").
                      simpl. try reflexivity. }
                    { simpl. try reflexivity. } }
                  { eapply T_Integer with(n:=1). }
                  { simpl. try reflexivity. } } }
              { simpl. try reflexivity. }
              { simpl. try reflexivity. } }
            { eapply T_Skip. } } } } } } }
  Unshelve.
  all: apply STyVoid.
Defined.
Definition prog := the_exists_term (prog_well_typed).
Print prog.