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
      { eapply T_ClassDecl with(name:="PreviousPalindrome").
        { simpl. try reflexivity. }
        { eapply T_MethodDecl with(modif:="public static")(T:=TyInt)(m:="previousPalindrome").
          { simpl. try reflexivity. }
          { eapply T_Concat.
            { eapply T_DeclNoInit with(T:=TyInt)(x:="num").
              simpl. try reflexivity. }
            { eapply T_Skip. } }
          { simpl. try reflexivity. }
          { eapply T_Concat.
            { eapply T_If.
              { eapply T_Eq.
                { eapply T_Var with(x:="num").
                  simpl. try reflexivity. }
                { eapply T_Integer with(n:=99). }
                { simpl. try reflexivity. } }
              { eapply T_Concat.
                { eapply T_Return.
                  { eapply T_Integer with(n:=88). }
                  { simpl. try reflexivity. }
                  { simpl. try reflexivity. } }
                { eapply T_Skip. } } }
            { eapply T_Concat.
              { eapply T_If.
                { eapply T_Eq.
                  { eapply T_Var with(x:="num").
                    simpl. try reflexivity. }
                  { eapply T_Integer with(n:=1221). }
                  { simpl. try reflexivity. } }
                { eapply T_Concat.
                  { eapply T_Return.
                    { eapply T_Integer with(n:=1111). }
                    { simpl. try reflexivity. }
                    { simpl. try reflexivity. } }
                  { eapply T_Skip. } } }
              { eapply T_Concat.
                { eapply T_If.
                  { eapply T_Eq.
                    { eapply T_Var with(x:="num").
                      simpl. try reflexivity. }
                    { eapply T_Integer with(n:=120). }
                    { simpl. try reflexivity. } }
                  { eapply T_Concat.
                    { eapply T_Return.
                      { eapply T_Integer with(n:=111). }
                      { simpl. try reflexivity. }
                      { simpl. try reflexivity. } }
                    { eapply T_Skip. } } }
                { eapply T_Concat.
                  { eapply T_If.
                    { eapply T_Eq.
                      { eapply T_Var with(x:="num").
                        simpl. try reflexivity. }
                      { eapply T_Integer with(n:=21). }
                      { simpl. try reflexivity. } }
                    { eapply T_Concat.
                      { eapply T_Return.
                        { eapply T_Integer with(n:=99). }
                        { simpl. try reflexivity. }
                        { simpl. try reflexivity. } }
                      { eapply T_Skip. } } }
                  { eapply T_Concat.
                    { eapply T_If.
                      { eapply T_Eq.
                        { eapply T_Var with(x:="num").
                          simpl. try reflexivity. }
                        { eapply T_Integer with(n:=100). }
                        { simpl. try reflexivity. } }
                      { eapply T_Concat.
                        { eapply T_Return.
                          { eapply T_Integer with(n:=11). }
                          { simpl. try reflexivity. }
                          { simpl. try reflexivity. } }
                        { eapply T_Skip. } } }
                    { eapply T_Concat.
                      { eapply T_If.
                        { eapply T_Eq.
                          { eapply T_Var with(x:="num").
                            simpl. try reflexivity. }
                          { eapply T_Integer with(n:=10). }
                          { simpl. try reflexivity. } }
                        { eapply T_Concat.
                          { eapply T_Return.
                            { eapply T_Integer with(n:=20). }
                            { simpl. try reflexivity. }
                            { simpl. try reflexivity. } }
                          { eapply T_Skip. } } }
                      { eapply T_Concat.
                        { eapply T_If.
                          { eapply T_Eq.
                            { eapply T_Var with(x:="num").
                              simpl. try reflexivity. }
                            { eapply T_Integer with(n:=1). }
                            { simpl. try reflexivity. } }
                          { eapply T_Concat.
                            { eapply T_Return.
                              { eapply T_Integer with(n:=11). }
                              { simpl. try reflexivity. }
                              { simpl. try reflexivity. } }
                            { eapply T_Skip. } } }
                        { eapply T_Concat.
                          { eapply T_If.
                            { eapply T_Eq.
                              { eapply T_Var with(x:="num").
                                simpl. try reflexivity. }
                              { eapply T_Integer with(n:=4). }
                              { simpl. try reflexivity. } }
                            { eapply T_Concat.
                              { eapply T_Return.
                                { eapply T_Integer with(n:=4). }
                                { simpl. try reflexivity. }
                                { simpl. try reflexivity. } }
                              { eapply T_Skip. } } }
                          { eapply T_Concat.
                            { eapply T_Return.
                              { eapply T_Integer with(n:=0). }
                              { simpl. try reflexivity. }
                              { simpl. try reflexivity. } }
                            { eapply T_Skip. } } } } } } } } } } } } } } }
  Unshelve.
  all: apply STyVoid.
Defined.
Definition prog := the_exists_term (prog_well_typed).
Print prog.