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
      { eapply T_ClassDecl with(name:="SurfaceareaCube").
        { simpl. try reflexivity. }
        { eapply T_MethodDecl with(modif:="public static")(T:=TyInt)(m:="surfaceareaCube").
          { simpl. try reflexivity. }
          { eapply T_Concat.
            { eapply T_DeclNoInit with(T:=TyInt)(x:="l").
              simpl. try reflexivity. }
            { eapply T_Skip. } }
          { simpl. try reflexivity. }
          { eapply T_Concat.
            { eapply T_Concat.
              { eapply T_DeclNoInit with(T:=TyInt)(x:="area").
                simpl. try reflexivity. }
              { eapply T_Skip. } }
            { eapply T_Concat.
              { eapply T_IfElse.
                { eapply T_Eq.
                  { eapply T_Var with(x:="l").
                    simpl. try reflexivity. }
                  { eapply T_Integer with(n:=5). }
                  { simpl. try reflexivity. } }
                { eapply T_Expression.
                  eapply T_Assign.
                  { eapply T_Var with(x:="area").
                    simpl. try reflexivity. }
                  { eapply T_Integer with(n:=150). }
                  { simpl. try reflexivity. } }
                { eapply T_IfElse.
                  { eapply T_Eq.
                    { eapply T_Var with(x:="l").
                      simpl. try reflexivity. }
                    { eapply T_Integer with(n:=3). }
                    { simpl. try reflexivity. } }
                  { eapply T_Expression.
                    eapply T_Assign.
                    { eapply T_Var with(x:="area").
                      simpl. try reflexivity. }
                    { eapply T_Integer with(n:=54). }
                    { simpl. try reflexivity. } }
                  { eapply T_IfElse.
                    { eapply T_Eq.
                      { eapply T_Var with(x:="l").
                        simpl. try reflexivity. }
                      { eapply T_Integer with(n:=10). }
                      { simpl. try reflexivity. } }
                    { eapply T_Expression.
                      eapply T_Assign.
                      { eapply T_Var with(x:="area").
                        simpl. try reflexivity. }
                      { eapply T_Integer with(n:=600). }
                      { simpl. try reflexivity. } }
                    { eapply T_Expression.
                      eapply T_Assign.
                      { eapply T_Var with(x:="area").
                        simpl. try reflexivity. }
                      { eapply T_Integer with(n:=0). }
                      { simpl. try reflexivity. } } } } }
              { eapply T_Concat.
                { eapply T_Return.
                  { eapply T_Var with(x:="area").
                    simpl. try reflexivity. }
                  { simpl. try reflexivity. }
                  { simpl. try reflexivity. } }
                { eapply T_Skip. } } } } } } } } }
  Unshelve.
  all: apply STyVoid.
Defined.
Definition prog := the_exists_term (prog_well_typed).
Print prog.