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
      { eapply T_ClassDecl with(name:="MaxSimilarIndices").
        { simpl. try reflexivity. }
        { eapply T_MethodDecl with(modif:="public static")(T:=(TyGeneric1 "List" (TyGeneric1 "List" TyInt)))(m:="maxSimilarIndices").
          { simpl. try reflexivity. }
          { eapply T_Concat.
            { eapply T_DeclNoInit with(T:=(TyGeneric1 "List" (TyGeneric1 "List" TyInt)))(x:="testList1").
              simpl. try reflexivity. }
            { eapply T_Concat.
              { eapply T_DeclNoInit with(T:=(TyGeneric1 "List" (TyGeneric1 "List" TyInt)))(x:="testList2").
                simpl. try reflexivity. }
              { eapply T_Skip. } } }
          { simpl. try reflexivity. }
          { eapply T_Concat.
            { eapply T_Concat.
              { eapply T_DeclInit with(T:=(TyGeneric1 "List" (TyGeneric1 "List" TyInt)))(x:="res").
                { simpl. try reflexivity. }
                { eapply T_New' with(T:=(TyGeneric0 "ArrayList")).
                  { simpl. try reflexivity. }
                  { eapply T_Nil. } }
                { simpl. try reflexivity. } }
              { eapply T_Skip. } }
            { eapply T_Concat.
              { eapply T_For.
                { eapply T_Concat.
                  { eapply T_DeclInit with(T:=TyInt)(x:="i").
                    { simpl. try reflexivity. }
                    { eapply T_Integer with(n:=0). }
                    { simpl. try reflexivity. } }
                  { eapply T_Skip. } }
                { eapply T_Lt.
                  { eapply T_Var with(x:="i").
                    simpl. try reflexivity. }
                  { eapply T_MethodInvocation with(m:="size").
                    { eapply T_Var with(x:="testList1").
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
                  { eapply T_Concat.
                    { eapply T_DeclInit with(T:=(TyGeneric1 "List" TyInt))(x:="cur").
                      { simpl. try reflexivity. }
                      { eapply T_New' with(T:=(TyGeneric0 "ArrayList")).
                        { simpl. try reflexivity. }
                        { eapply T_Nil. } }
                      { simpl. try reflexivity. } }
                    { eapply T_Skip. } }
                  { eapply T_Concat.
                    { eapply T_Expression.
                      eapply T_MethodInvocation with(m:="add").
                      { eapply T_Var with(x:="cur").
                        simpl. try reflexivity. }
                      { simpl. try reflexivity. }
                      { simpl. try reflexivity. }
                      { eapply T_List.
                        { eapply T_MethodInvocation with(m:="get").
                          { eapply T_MethodInvocation with(m:="get").
                            { eapply T_Var with(x:="testList1").
                              simpl. try reflexivity. }
                            { simpl. try reflexivity. }
                            { simpl. try reflexivity. }
                            { eapply T_List.
                              { eapply T_Var with(x:="i").
                                simpl. try reflexivity. }
                              { eapply T_Nil. } }
                            { simpl. try reflexivity. } }
                          { simpl. try reflexivity. }
                          { simpl. try reflexivity. }
                          { eapply T_List.
                            { eapply T_Integer with(n:=0). }
                            { eapply T_Nil. } }
                          { simpl. try reflexivity. } }
                        { eapply T_Nil. } }
                      { simpl. try reflexivity. } }
                    { eapply T_Concat.
                      { eapply T_Expression.
                        eapply T_MethodInvocation with(m:="add").
                        { eapply T_Var with(x:="cur").
                          simpl. try reflexivity. }
                        { simpl. try reflexivity. }
                        { simpl. try reflexivity. }
                        { eapply T_List.
                          { eapply T_MethodInvocation with(m:="get").
                            { eapply T_MethodInvocation with(m:="get").
                              { eapply T_Var with(x:="testList1").
                                simpl. try reflexivity. }
                              { simpl. try reflexivity. }
                              { simpl. try reflexivity. }
                              { eapply T_List.
                                { eapply T_Var with(x:="i").
                                  simpl. try reflexivity. }
                                { eapply T_Nil. } }
                              { simpl. try reflexivity. } }
                            { simpl. try reflexivity. }
                            { simpl. try reflexivity. }
                            { eapply T_List.
                              { eapply T_Integer with(n:=1). }
                              { eapply T_Nil. } }
                            { simpl. try reflexivity. } }
                          { eapply T_Nil. } }
                        { simpl. try reflexivity. } }
                      { eapply T_Concat.
                        { eapply T_Expression.
                          eapply T_MethodInvocation with(m:="add").
                          { eapply T_Var with(x:="res").
                            simpl. try reflexivity. }
                          { simpl. try reflexivity. }
                          { simpl. try reflexivity. }
                          { eapply T_List.
                            { eapply T_Var with(x:="cur").
                              simpl. try reflexivity. }
                            { eapply T_Nil. } }
                          { simpl. try reflexivity. } }
                        { eapply T_Skip. } } } } } }
              { eapply T_Concat.
                { eapply T_For.
                  { eapply T_Concat.
                    { eapply T_DeclInit with(T:=TyInt)(x:="i").
                      { simpl. try reflexivity. }
                      { eapply T_Integer with(n:=0). }
                      { simpl. try reflexivity. } }
                    { eapply T_Skip. } }
                  { eapply T_Lt.
                    { eapply T_Var with(x:="i").
                      simpl. try reflexivity. }
                    { eapply T_MethodInvocation with(m:="size").
                      { eapply T_Var with(x:="testList2").
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
                    { eapply T_Concat.
                      { eapply T_DeclInit with(T:=(TyGeneric1 "List" TyInt))(x:="cur").
                        { simpl. try reflexivity. }
                        { eapply T_MethodInvocation with(m:="get").
                          { eapply T_Var with(x:="res").
                            simpl. try reflexivity. }
                          { simpl. try reflexivity. }
                          { simpl. try reflexivity. }
                          { eapply T_List.
                            { eapply T_Var with(x:="i").
                              simpl. try reflexivity. }
                            { eapply T_Nil. } }
                          { simpl. try reflexivity. } }
                        { simpl. try reflexivity. } }
                      { eapply T_Skip. } }
                    { eapply T_Concat.
                      { eapply T_Expression.
                        eapply T_MethodInvocation with(m:="set").
                        { eapply T_Var with(x:="cur").
                          simpl. try reflexivity. }
                        { simpl. try reflexivity. }
                        { simpl. try reflexivity. }
                        { eapply T_List.
                          { eapply T_Integer with(n:=0). }
                          { eapply T_List.
                            { eapply T_TyMethodInvocation with(m:="max")(T:=(TyExternal "Math")).
                              { simpl. try reflexivity. }
                              { simpl. try reflexivity. }
                              { eapply T_List.
                                { eapply T_MethodInvocation with(m:="get").
                                  { eapply T_Var with(x:="cur").
                                    simpl. try reflexivity. }
                                  { simpl. try reflexivity. }
                                  { simpl. try reflexivity. }
                                  { eapply T_List.
                                    { eapply T_Integer with(n:=0). }
                                    { eapply T_Nil. } }
                                  { simpl. try reflexivity. } }
                                { eapply T_List.
                                  { eapply T_MethodInvocation with(m:="get").
                                    { eapply T_MethodInvocation with(m:="get").
                                      { eapply T_Var with(x:="testList2").
                                        simpl. try reflexivity. }
                                      { simpl. try reflexivity. }
                                      { simpl. try reflexivity. }
                                      { eapply T_List.
                                        { eapply T_Var with(x:="i").
                                          simpl. try reflexivity. }
                                        { eapply T_Nil. } }
                                      { simpl. try reflexivity. } }
                                    { simpl. try reflexivity. }
                                    { simpl. try reflexivity. }
                                    { eapply T_List.
                                      { eapply T_Integer with(n:=0). }
                                      { eapply T_Nil. } }
                                    { simpl. try reflexivity. } }
                                  { eapply T_Nil. } } }
                              { simpl. try reflexivity. } }
                            { eapply T_Nil. } } }
                        { simpl. try reflexivity. } }
                      { eapply T_Concat.
                        { eapply T_Expression.
                          eapply T_MethodInvocation with(m:="set").
                          { eapply T_Var with(x:="cur").
                            simpl. try reflexivity. }
                          { simpl. try reflexivity. }
                          { simpl. try reflexivity. }
                          { eapply T_List.
                            { eapply T_Integer with(n:=1). }
                            { eapply T_List.
                              { eapply T_TyMethodInvocation with(m:="max")(T:=(TyExternal "Math")).
                                { simpl. try reflexivity. }
                                { simpl. try reflexivity. }
                                { eapply T_List.
                                  { eapply T_MethodInvocation with(m:="get").
                                    { eapply T_Var with(x:="cur").
                                      simpl. try reflexivity. }
                                    { simpl. try reflexivity. }
                                    { simpl. try reflexivity. }
                                    { eapply T_List.
                                      { eapply T_Integer with(n:=1). }
                                      { eapply T_Nil. } }
                                    { simpl. try reflexivity. } }
                                  { eapply T_List.
                                    { eapply T_MethodInvocation with(m:="get").
                                      { eapply T_MethodInvocation with(m:="get").
                                        { eapply T_Var with(x:="testList2").
                                          simpl. try reflexivity. }
                                        { simpl. try reflexivity. }
                                        { simpl. try reflexivity. }
                                        { eapply T_List.
                                          { eapply T_Var with(x:="i").
                                            simpl. try reflexivity. }
                                          { eapply T_Nil. } }
                                        { simpl. try reflexivity. } }
                                      { simpl. try reflexivity. }
                                      { simpl. try reflexivity. }
                                      { eapply T_List.
                                        { eapply T_Integer with(n:=1). }
                                        { eapply T_Nil. } }
                                      { simpl. try reflexivity. } }
                                    { eapply T_Nil. } } }
                                { simpl. try reflexivity. } }
                              { eapply T_Nil. } } }
                          { simpl. try reflexivity. } }
                        { eapply T_Skip. } } } } }
                { eapply T_Concat.
                  { eapply T_Return.
                    { eapply T_Var with(x:="res").
                      simpl. try reflexivity. }
                    { simpl. try reflexivity. }
                    { simpl. try reflexivity. } }
                  { eapply T_Skip. } } } } } } } } } }
  Unshelve.
  all: apply STyVoid.
Defined.
Definition prog := the_exists_term (prog_well_typed).
Print prog.