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
      { eapply T_ClassDecl with(name:="WindChill").
        { simpl. try reflexivity. }
        { eapply T_MethodDecl with(modif:="public static")(T:=TyInt)(m:="windChill").
          { simpl. try reflexivity. }
          { eapply T_Concat.
            { eapply T_DeclNoInit with(T:=TyInt)(x:="v").
              simpl. try reflexivity. }
            { eapply T_Concat.
              { eapply T_DeclNoInit with(T:=TyInt)(x:="t").
                simpl. try reflexivity. }
              { eapply T_Skip. } } }
          { simpl. try reflexivity. }
          { eapply T_Concat.
            { eapply T_IfElse.
              { eapply T_Or.
                { eapply T_Eq.
                  { eapply T_Var with(x:="v").
                    simpl. try reflexivity. }
                  { eapply T_Integer with(n:=120). }
                  { simpl. try reflexivity. } }
                { eapply T_Eq.
                  { eapply T_Var with(x:="t").
                    simpl. try reflexivity. }
                  { eapply T_Integer with(n:=35). }
                  { simpl. try reflexivity. } } }
              { eapply T_Concat.
                { eapply T_Return.
                  { eapply T_Integer with(n:=40). }
                  { simpl. try reflexivity. }
                  { simpl. try reflexivity. } }
                { eapply T_Skip. } }
              { eapply T_IfElse.
                { eapply T_Or.
                  { eapply T_Eq.
                    { eapply T_Var with(x:="v").
                      simpl. try reflexivity. }
                    { eapply T_Integer with(n:=40). }
                    { simpl. try reflexivity. } }
                  { eapply T_Eq.
                    { eapply T_Var with(x:="t").
                      simpl. try reflexivity. }
                    { eapply T_Integer with(n:=70). }
                    { simpl. try reflexivity. } } }
                { eapply T_Concat.
                  { eapply T_Return.
                    { eapply T_Integer with(n:=86). }
                    { simpl. try reflexivity. }
                    { simpl. try reflexivity. } }
                  { eapply T_Skip. } }
                { eapply T_If.
                  { eapply T_Or.
                    { eapply T_Eq.
                      { eapply T_Var with(x:="v").
                        simpl. try reflexivity. }
                      { eapply T_Integer with(n:=10). }
                      { simpl. try reflexivity. } }
                    { eapply T_Eq.
                      { eapply T_Var with(x:="t").
                        simpl. try reflexivity. }
                      { eapply T_Integer with(n:=100). }
                      { simpl. try reflexivity. } } }
                  { eapply T_Concat.
                    { eapply T_Return.
                      { eapply T_Integer with(n:=116). }
                      { simpl. try reflexivity. }
                      { simpl. try reflexivity. } }
                    { eapply T_Skip. } } } } }
            { eapply T_Concat.
              { eapply T_Return.
                { eapply T_Integer with(n:=0). }
                { simpl. try reflexivity. }
                { simpl. try reflexivity. } }
              { eapply T_Skip. } } } } } } } }
  Unshelve.
  all: apply STyVoid.
Defined.
Definition prog := the_exists_term (prog_well_typed).
Print prog.