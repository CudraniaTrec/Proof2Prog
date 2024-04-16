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
      { eapply T_ClassDecl with(name:="IncreasingTrend").
        { simpl. try reflexivity. }
        { eapply T_MethodDecl with(modif:="public static")(T:=TyBool)(m:="increasingTrend").
          { simpl. try reflexivity. }
          { eapply T_Concat.
            { eapply T_DeclNoInit with(T:=(TyGeneric1 "List" TyInt))(x:="nums").
              simpl. try reflexivity. }
            { eapply T_Skip. } }
          { simpl. try reflexivity. }
          { eapply T_Concat.
            { eapply T_Concat.
              { eapply T_DeclInit with(T:=TyInt)(x:="n").
                { simpl. try reflexivity. }
                { eapply T_MethodInvocation with(m:="size").
                  { eapply T_Var with(x:="nums").
                    simpl. try reflexivity. }
                  { simpl. try reflexivity. }
                  { simpl. try reflexivity. }
                  { eapply T_Nil. }
                  { simpl. try reflexivity. } }
                { simpl. try reflexivity. } }
              { eapply T_Skip. } }
            { eapply T_Concat.
              { eapply T_Concat.
                { eapply T_DeclInit with(T:=TyInt)(x:="start").
                  { simpl. try reflexivity. }
                  { eapply T_Integer with(n:=0). }
                  { simpl. try reflexivity. } }
                { eapply T_Skip. } }
              { eapply T_Concat.
                { eapply T_Concat.
                  { eapply T_DeclInit with(T:=TyInt)(x:="end").
                    { simpl. try reflexivity. }
                    { eapply T_Sub.
                      { eapply T_Var with(x:="n").
                        simpl. try reflexivity. }
                      { eapply T_Integer with(n:=1). }
                      { simpl. try reflexivity. } }
                    { simpl. try reflexivity. } }
                  { eapply T_Skip. } }
                { eapply T_Concat.
                  { eapply T_Concat.
                    { eapply T_DeclInit with(T:=TyInt)(x:="trend").
                      { simpl. try reflexivity. }
                      { eapply T_Integer with(n:=0). }
                      { simpl. try reflexivity. } }
                    { eapply T_Skip. } }
                  { eapply T_Concat.
                    { eapply T_While.
                      { eapply T_Le.
                        { eapply T_Var with(x:="start").
                          simpl. try reflexivity. }
                        { eapply T_Var with(x:="end").
                          simpl. try reflexivity. }
                        { simpl. try reflexivity. } }
                      { eapply T_Concat.
                        { eapply T_Concat.
                          { eapply T_DeclInit with(T:=TyInt)(x:="mid").
                            { simpl. try reflexivity. }
                            { eapply T_Div.
                              { eapply T_Add.
                                { eapply T_Var with(x:="start").
                                  simpl. try reflexivity. }
                                { eapply T_Var with(x:="end").
                                  simpl. try reflexivity. }
                                { simpl. try reflexivity. } }
                              { eapply T_Integer with(n:=2). } }
                            { simpl. try reflexivity. } }
                          { eapply T_Skip. } }
                        { eapply T_Concat.
                          { eapply T_If.
                            { eapply T_Le.
                              { eapply T_MethodInvocation with(m:="compareTo").
                                { eapply T_MethodInvocation with(m:="get").
                                  { eapply T_Var with(x:="nums").
                                    simpl. try reflexivity. }
                                  { simpl. try reflexivity. }
                                  { simpl. try reflexivity. }
                                  { eapply T_List.
                                    { eapply T_Var with(x:="mid").
                                      simpl. try reflexivity. }
                                    { eapply T_Nil. } }
                                  { simpl. try reflexivity. } }
                                { simpl. try reflexivity. }
                                { simpl. try reflexivity. }
                                { eapply T_List.
                                  { eapply T_MethodInvocation with(m:="get").
                                    { eapply T_Var with(x:="nums").
                                      simpl. try reflexivity. }
                                    { simpl. try reflexivity. }
                                    { simpl. try reflexivity. }
                                    { eapply T_List.
                                      { eapply T_Var with(x:="start").
                                        simpl. try reflexivity. }
                                      { eapply T_Nil. } }
                                    { simpl. try reflexivity. } }
                                  { eapply T_Nil. } }
                                { simpl. try reflexivity. } }
                              { eapply T_Integer with(n:=0). }
                              { simpl. try reflexivity. } }
                            { eapply T_Concat.
                              { eapply T_Expression.
                                eapply T_Assign.
                                { eapply T_Var with(x:="trend").
                                  simpl. try reflexivity. }
                                { eapply T_Add.
                                  { eapply T_Var with(x:="trend").
                                    simpl. try reflexivity. }
                                  { eapply T_MethodInvocation with(m:="compareTo").
                                    { eapply T_MethodInvocation with(m:="get").
                                      { eapply T_Var with(x:="nums").
                                        simpl. try reflexivity. }
                                      { simpl. try reflexivity. }
                                      { simpl. try reflexivity. }
                                      { eapply T_List.
                                        { eapply T_Var with(x:="mid").
                                          simpl. try reflexivity. }
                                        { eapply T_Nil. } }
                                      { simpl. try reflexivity. } }
                                    { simpl. try reflexivity. }
                                    { simpl. try reflexivity. }
                                    { eapply T_List.
                                      { eapply T_MethodInvocation with(m:="get").
                                        { eapply T_Var with(x:="nums").
                                          simpl. try reflexivity. }
                                        { simpl. try reflexivity. }
                                        { simpl. try reflexivity. }
                                        { eapply T_List.
                                          { eapply T_Var with(x:="start").
                                            simpl. try reflexivity. }
                                          { eapply T_Nil. } }
                                        { simpl. try reflexivity. } }
                                      { eapply T_Nil. } }
                                    { simpl. try reflexivity. } }
                                  { simpl. try reflexivity. } }
                                { simpl. try reflexivity. } }
                              { eapply T_Skip. } } }
                          { eapply T_Concat.
                            { eapply T_Expression.
                              eapply T_Assign.
                              { eapply T_Var with(x:="start").
                                simpl. try reflexivity. }
                              { eapply T_Add.
                                { eapply T_Var with(x:="mid").
                                  simpl. try reflexivity. }
                                { eapply T_Integer with(n:=1). }
                                { simpl. try reflexivity. } }
                              { simpl. try reflexivity. } }
                            { eapply T_Concat.
                              { eapply T_Expression.
                                eapply T_Assign.
                                { eapply T_Var with(x:="end").
                                  simpl. try reflexivity. }
                                { eapply T_Sub.
                                  { eapply T_Var with(x:="mid").
                                    simpl. try reflexivity. }
                                  { eapply T_Integer with(n:=1). }
                                  { simpl. try reflexivity. } }
                                { simpl. try reflexivity. } }
                              { eapply T_Skip. } } } } } }
                    { eapply T_Concat.
                      { eapply T_Return.
                        { eapply T_Eq.
                          { eapply T_Var with(x:="trend").
                            simpl. try reflexivity. }
                          { eapply T_Integer with(n:=0). }
                          { simpl. try reflexivity. } }
                        { simpl. try reflexivity. }
                        { simpl. try reflexivity. } }
                      { eapply T_Skip. } } } } } } } } } } } }
  Unshelve.
  all: apply STyVoid.
Defined.
Definition prog := the_exists_term (prog_well_typed).
Print prog.