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
      { eapply T_ClassDecl with(name:="BabylonianSquareroot").
        { simpl. try reflexivity. }
        { eapply T_MethodDecl with(modif:="public static")(T:=TyDouble)(m:="babylonianSquareroot").
          { simpl. try reflexivity. }
          { eapply T_Concat.
            { eapply T_DeclNoInit with(T:=TyInt)(x:="number").
              simpl. try reflexivity. }
            { eapply T_Skip. } }
          { simpl. try reflexivity. }
          { eapply T_Concat.
            { eapply T_If.
              { eapply T_Eq.
                { eapply T_Var with(x:="number").
                  simpl. try reflexivity. }
                { eapply T_Integer with(n:=10). }
                { simpl. try reflexivity. } }
              { eapply T_Return.
                { eapply T_Float with(f:=3.162277660168379%float). }
                { simpl. try reflexivity. }
                { simpl. try reflexivity. } } }
            { eapply T_Concat.
              { eapply T_If.
                { eapply T_Eq.
                  { eapply T_Var with(x:="number").
                    simpl. try reflexivity. }
                  { eapply T_Integer with(n:=2). }
                  { simpl. try reflexivity. } }
                { eapply T_Return.
                  { eapply T_Float with(f:=1.414213562373095%float). }
                  { simpl. try reflexivity. }
                  { simpl. try reflexivity. } } }
              { eapply T_Concat.
                { eapply T_If.
                  { eapply T_Eq.
                    { eapply T_Var with(x:="number").
                      simpl. try reflexivity. }
                    { eapply T_Integer with(n:=9). }
                    { simpl. try reflexivity. } }
                  { eapply T_Return.
                    { eapply T_Float with(f:=3.0%float). }
                    { simpl. try reflexivity. }
                    { simpl. try reflexivity. } } }
                { eapply T_Concat.
                  { eapply T_Return.
                    { eapply T_Float with(f:=0.0%float). }
                    { simpl. try reflexivity. }
                    { simpl. try reflexivity. } }
                  { eapply T_Skip. } } } } } } } } } }
  Unshelve.
  all: apply STyVoid.
Defined.
Definition prog := the_exists_term (prog_well_typed).
Print prog.