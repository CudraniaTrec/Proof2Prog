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
      { eapply T_ClassDecl with(name:="GetLcm").
        { simpl. try reflexivity. }
        { eapply T_MethodDecl with(modif:="public static")(T:=TyInt)(m:="getLcm").
          { simpl. try reflexivity. }
          { eapply T_Concat.
            { eapply T_DeclNoInit with(T:=(TyGeneric1 "List" TyInt))(x:="l").
              simpl. try reflexivity. }
            { eapply T_Skip. } }
          { simpl. try reflexivity. }
          { eapply T_Concat.
            { eapply T_Concat.
              { eapply T_DeclInit with(T:=TyInt)(x:="max").
                { simpl. try reflexivity. }
                { eapply T_MethodInvocation with(m:="get").
                  { eapply T_Var with(x:="l").
                    simpl. try reflexivity. }
                  { simpl. try reflexivity. }
                  { simpl. try reflexivity. }
                  { eapply T_List.
                    { eapply T_Integer with(n:=0). }
                    { eapply T_Nil. } }
                  { simpl. try reflexivity. } }
                { simpl. try reflexivity. } }
              { eapply T_Skip. } }
            { eapply T_Concat.
              { eapply T_For.
                { eapply T_Concat.
                  { eapply T_DeclInit with(T:=TyInt)(x:="i").
                    { simpl. try reflexivity. }
                    { eapply T_Integer with(n:=1). }
                    { simpl. try reflexivity. } }
                  { eapply T_Skip. } }
                { eapply T_Lt.
                  { eapply T_Var with(x:="i").
                    simpl. try reflexivity. }
                  { eapply T_MethodInvocation with(m:="size").
                    { eapply T_Var with(x:="l").
                      simpl. try reflexivity. }
                    { simpl. try reflexivity. }
                    { simpl. try reflexivity. }
                    { eapply T_Nil. }
                    { simpl. try reflexivity. } }
                  { simpl. try reflexivity. } }
                { eapply T_PostInc.
                  eapply T_Var with(x:="i").
                  simpl. try reflexivity. }
                { eapply T_Concat.
                  { eapply T_Expression.
                    eapply T_Assign.
                    { eapply T_Var with(x:="max").
                      simpl. try reflexivity. }
                    { eapply T_Choose.
                      { eapply T_Gt.
                        { eapply T_MethodInvocation with(m:="get").
                          { eapply T_Var with(x:="l").
                            simpl. try reflexivity. }
                          { simpl. try reflexivity. }
                          { simpl. try reflexivity. }
                          { eapply T_List.
                            { eapply T_Var with(x:="i").
                              simpl. try reflexivity. }
                            { eapply T_Nil. } }
                          { simpl. try reflexivity. } }
                        { eapply T_Var with(x:="max").
                          simpl. try reflexivity. }
                        { simpl. try reflexivity. } }
                      { eapply T_MethodInvocation with(m:="get").
                        { eapply T_Var with(x:="l").
                          simpl. try reflexivity. }
                        { simpl. try reflexivity. }
                        { simpl. try reflexivity. }
                        { eapply T_List.
                          { eapply T_Var with(x:="i").
                            simpl. try reflexivity. }
                          { eapply T_Nil. } }
                        { simpl. try reflexivity. } }
                      { eapply T_Var with(x:="max").
                        simpl. try reflexivity. }
                      { simpl. try reflexivity. } }
                    { simpl. try reflexivity. } }
                  { eapply T_Skip. } } }
              { eapply T_Concat.
                { eapply T_Concat.
                  { eapply T_DeclInit with(T:=TyInt)(x:="i").
                    { simpl. try reflexivity. }
                    { eapply T_Integer with(n:=1). }
                    { simpl. try reflexivity. } }
                  { eapply T_Skip. } }
                { eapply T_Concat.
                  { eapply T_While.
                    { eapply T_True. }
                    { eapply T_Concat.
                      { eapply T_Concat.
                        { eapply T_DeclInit with(T:=TyInt)(x:="temp").
                          { simpl. try reflexivity. }
                          { eapply T_Mul.
                            { eapply T_Var with(x:="i").
                              simpl. try reflexivity. }
                            { eapply T_Var with(x:="max").
                              simpl. try reflexivity. } }
                          { simpl. try reflexivity. } }
                        { eapply T_Skip. } }
                      { eapply T_Concat.
                        { eapply T_For.
                          { eapply T_Concat.
                            { eapply T_DeclInit with(T:=TyInt)(x:="j").
                              { simpl. try reflexivity. }
                              { eapply T_Integer with(n:=0). }
                              { simpl. try reflexivity. } }
                            { eapply T_Skip. } }
                          { eapply T_Lt.
                            { eapply T_Var with(x:="j").
                              simpl. try reflexivity. }
                            { eapply T_MethodInvocation with(m:="size").
                              { eapply T_Var with(x:="l").
                                simpl. try reflexivity. }
                              { simpl. try reflexivity. }
                              { simpl. try reflexivity. }
                              { eapply T_Nil. }
                              { simpl. try reflexivity. } }
                            { simpl. try reflexivity. } }
                          { eapply T_PostInc.
                            eapply T_Var with(x:="j").
                            simpl. try reflexivity. }
                          { eapply T_Concat.
                            { eapply T_If.
                              { eapply T_Ne.
                                { eapply T_Mod.
                                  { eapply T_Var with(x:="temp").
                                    simpl. try reflexivity. }
                                  { eapply T_MethodInvocation with(m:="get").
                                    { eapply T_Var with(x:="l").
                                      simpl. try reflexivity. }
                                    { simpl. try reflexivity. }
                                    { simpl. try reflexivity. }
                                    { eapply T_List.
                                      { eapply T_Var with(x:="j").
                                        simpl. try reflexivity. }
                                      { eapply T_Nil. } }
                                    { simpl. try reflexivity. } } }
                                { eapply T_Integer with(n:=0). }
                                { simpl. try reflexivity. } }
                              { eapply T_Concat.
                                { eapply T_Expression.
                                  eapply T_Assign.
                                  { eapply T_Var with(x:="temp").
                                    simpl. try reflexivity. }
                                  { eapply T_Add.
                                    { eapply T_Sub.
                                      { eapply T_Var with(x:="temp").
                                        simpl. try reflexivity. }
                                      { eapply T_Var with(x:="max").
                                        simpl. try reflexivity. }
                                      { simpl. try reflexivity. } }
                                    { eapply T_MethodInvocation with(m:="get").
                                      { eapply T_Var with(x:="l").
                                        simpl. try reflexivity. }
                                      { simpl. try reflexivity. }
                                      { simpl. try reflexivity. }
                                      { eapply T_List.
                                        { eapply T_Var with(x:="j").
                                          simpl. try reflexivity. }
                                        { eapply T_Nil. } }
                                      { simpl. try reflexivity. } }
                                    { simpl. try reflexivity. } }
                                  { simpl. try reflexivity. } }
                                { eapply T_Concat.
                                  { eapply T_Break. }
                                  { eapply T_Skip. } } } }
                            { eapply T_Concat.
                              { eapply T_If.
                                { eapply T_Eq.
                                  { eapply T_Var with(x:="j").
                                    simpl. try reflexivity. }
                                  { eapply T_Sub.
                                    { eapply T_MethodInvocation with(m:="size").
                                      { eapply T_Var with(x:="l").
                                        simpl. try reflexivity. }
                                      { simpl. try reflexivity. }
                                      { simpl. try reflexivity. }
                                      { eapply T_Nil. }
                                      { simpl. try reflexivity. } }
                                    { eapply T_Integer with(n:=1). }
                                    { simpl. try reflexivity. } }
                                  { simpl. try reflexivity. } }
                                { eapply T_Concat.
                                  { eapply T_Return.
                                    { eapply T_Mul.
                                      { eapply T_Var with(x:="i").
                                        simpl. try reflexivity. }
                                      { eapply T_Var with(x:="max").
                                        simpl. try reflexivity. } }
                                    { simpl. try reflexivity. }
                                    { simpl. try reflexivity. } }
                                  { eapply T_Skip. } } }
                              { eapply T_Skip. } } } }
                        { eapply T_Concat.
                          { eapply T_Expression.
                            eapply T_PostInc.
                            eapply T_Var with(x:="i").
                            simpl. try reflexivity. }
                          { eapply T_Skip. } } } } }
                  { eapply T_Skip. } } } } } } } } } }
  Unshelve.
  all: apply STyVoid.
Defined.
Definition prog := the_exists_term (prog_well_typed).
Print prog.