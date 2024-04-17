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
      { eapply T_ClassDecl with(name:="CombinationsList").
        { simpl. try reflexivity. }
        { eapply T_MethodDecl with(modif:="public static")(T:=(TyGeneric1 "List" (TyGeneric1 "List" (TyExternal "Object"))))(m:="combinationsList").
          { simpl. try reflexivity. }
          { eapply T_Concat.
            { eapply T_DeclNoInit with(T:=(TyGeneric1 "List" TyString))(x:="list1").
              simpl. try reflexivity. }
            { eapply T_Skip. } }
          { simpl. try reflexivity. }
          { eapply T_Concat.
            { eapply T_Concat.
              { eapply T_DeclInit with(T:=(TyGeneric1 "List" (TyGeneric1 "List" (TyExternal "Object"))))(x:="result").
                { simpl. try reflexivity. }
                { eapply T_New' with(T:=(TyGeneric0 "ArrayList")).
                  { simpl. try reflexivity. }
                  { eapply T_Nil. } }
                { simpl. try reflexivity. } }
              { eapply T_Skip. } }
            { eapply T_Concat.
              { eapply T_Expression.
                eapply T_MethodInvocation with(m:="add").
                { eapply T_Var with(x:="result").
                  simpl. try reflexivity. }
                { simpl. try reflexivity. }
                { simpl. try reflexivity. }
                { eapply T_List.
                  { eapply T_New' with(T:=(TyGeneric1 "ArrayList" (TyExternal "Object"))).
                    { simpl. try reflexivity. }
                    { eapply T_Nil. } }
                  { eapply T_Nil. } }
                { simpl. try reflexivity. } }
              { eapply T_Concat.
                { eapply T_Foreach with(T:=TyString)(x:="e").
                  { simpl. try reflexivity. }
                  { eapply T_Var with(x:="list1").
                    simpl. try reflexivity. }
                  { simpl. try reflexivity. }
                  { eapply T_Concat.
                    { eapply T_Concat.
                      { eapply T_DeclInit with(T:=TyInt)(x:="len").
                        { simpl. try reflexivity. }
                        { eapply T_MethodInvocation with(m:="size").
                          { eapply T_Var with(x:="result").
                            simpl. try reflexivity. }
                          { simpl. try reflexivity. }
                          { simpl. try reflexivity. }
                          { eapply T_Nil. }
                          { simpl. try reflexivity. } }
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
                          { eapply T_Var with(x:="len").
                            simpl. try reflexivity. }
                          { simpl. try reflexivity. } }
                        { eapply T_PreInc.
                          eapply T_Var with(x:="j").
                          simpl. try reflexivity. }
                        { eapply T_Concat.
                          { eapply T_Concat.
                            { eapply T_DeclInit with(T:=(TyGeneric1 "List" (TyExternal "Object")))(x:="newList").
                              { simpl. try reflexivity. }
                              { eapply T_New' with(T:=(TyGeneric0 "ArrayList")).
                                { simpl. try reflexivity. }
                                { eapply T_List.
                                  { eapply T_MethodInvocation with(m:="get").
                                    { eapply T_Var with(x:="result").
                                      simpl. try reflexivity. }
                                    { simpl. try reflexivity. }
                                    { simpl. try reflexivity. }
                                    { eapply T_List.
                                      { eapply T_Var with(x:="j").
                                        simpl. try reflexivity. }
                                      { eapply T_Nil. } }
                                    { simpl. try reflexivity. } }
                                  { eapply T_Nil. } } }
                              { simpl. try reflexivity. } }
                            { eapply T_Skip. } }
                          { eapply T_Concat.
                            { eapply T_Expression.
                              eapply T_MethodInvocation with(m:="add").
                              { eapply T_Var with(x:="newList").
                                simpl. try reflexivity. }
                              { simpl. try reflexivity. }
                              { simpl. try reflexivity. }
                              { eapply T_List.
                                { eapply T_Integer with(n:=0). }
                                { eapply T_List.
                                  { eapply T_Var with(x:="e").
                                    simpl. try reflexivity. }
                                  { eapply T_Nil. } } }
                              { simpl. try reflexivity. } }
                            { eapply T_Concat.
                              { eapply T_Expression.
                                eapply T_MethodInvocation with(m:="add").
                                { eapply T_Var with(x:="result").
                                  simpl. try reflexivity. }
                                { simpl. try reflexivity. }
                                { simpl. try reflexivity. }
                                { eapply T_List.
                                  { eapply T_Var with(x:="newList").
                                    simpl. try reflexivity. }
                                  { eapply T_Nil. } }
                                { simpl. try reflexivity. } }
                              { eapply T_Skip. } } } } }
                      { eapply T_Skip. } } } }
                { eapply T_Concat.
                  { eapply T_Return.
                    { eapply T_Var with(x:="result").
                      simpl. try reflexivity. }
                    { simpl. try reflexivity. }
                    { simpl. try reflexivity. } }
                  { eapply T_Skip. } } } } } } } } } }
  Unshelve.
  all: apply STyVoid.
Defined.
Definition prog := the_exists_term (prog_well_typed).
Print prog.