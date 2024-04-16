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
      { eapply T_ClassDecl with(name:="RadixSort").
        { simpl. try reflexivity. }
        { eapply T_MethodDecl with(modif:="public static")(T:=(TyGeneric1 "List" TyInt))(m:="radixSort").
          { simpl. try reflexivity. }
          { eapply T_Concat.
            { eapply T_DeclNoInit with(T:=(TyGeneric1 "List" TyInt))(x:="nums").
              simpl. try reflexivity. }
            { eapply T_Skip. } }
          { simpl. try reflexivity. }
          { eapply T_Concat.
            { eapply T_Concat.
              { eapply T_DeclInit with(T:=TyInt)(x:="max").
                { simpl. try reflexivity. }
                { eapply T_Neg.
                  eapply T_Integer with(n:=1). }
                { simpl. try reflexivity. } }
              { eapply T_Skip. } }
            { eapply T_Concat.
              { eapply T_Foreach with(T:=TyInt)(x:="i").
                { simpl. try reflexivity. }
                { eapply T_Var with(x:="nums").
                  simpl. try reflexivity. }
                { simpl. try reflexivity. }
                { eapply T_Concat.
                  { eapply T_Expression.
                    eapply T_Assign.
                    { eapply T_Var with(x:="max").
                      simpl. try reflexivity. }
                    { eapply T_TyMethodInvocation with(m:="max")(T:=(TyExternal "Math")).
                      { simpl. try reflexivity. }
                      { simpl. try reflexivity. }
                      { eapply T_List.
                        { eapply T_Var with(x:="max").
                          simpl. try reflexivity. }
                        { eapply T_List.
                          { eapply T_Var with(x:="i").
                            simpl. try reflexivity. }
                          { eapply T_Nil. } } }
                      { simpl. try reflexivity. } }
                    { simpl. try reflexivity. } }
                  { eapply T_Skip. } } }
              { eapply T_Concat.
                { eapply T_Concat.
                  { eapply T_DeclInit with(T:=(TyGeneric1 "List" (TyGeneric1 "List" TyInt)))(x:="buckets").
                    { simpl. try reflexivity. }
                    { eapply T_New' with(T:=(TyGeneric1 "ArrayList" (TyGeneric1 "List" TyInt))).
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
                      { eapply T_Integer with(n:=10). }
                      { simpl. try reflexivity. } }
                    { eapply T_PostInc.
                      eapply T_Var with(x:="i").
                      simpl. try reflexivity. }
                    { eapply T_Concat.
                      { eapply T_Expression.
                        eapply T_MethodInvocation with(m:="add").
                        { eapply T_Var with(x:="buckets").
                          simpl. try reflexivity. }
                        { simpl. try reflexivity. }
                        { simpl. try reflexivity. }
                        { eapply T_List.
                          { eapply T_New' with(T:=(TyGeneric1 "ArrayList" TyInt)).
                            { simpl. try reflexivity. }
                            { eapply T_Nil. } }
                          { eapply T_Nil. } }
                        { simpl. try reflexivity. } }
                      { eapply T_Skip. } } }
                  { eapply T_Concat.
                    { eapply T_Foreach with(T:=TyInt)(x:="i").
                      { simpl. try reflexivity. }
                      { eapply T_Var with(x:="nums").
                        simpl. try reflexivity. }
                      { simpl. try reflexivity. }
                      { eapply T_Concat.
                        { eapply T_Concat.
                          { eapply T_DeclInit with(T:=TyInt)(x:="digit").
                            { simpl. try reflexivity. }
                            { eapply T_Sub.
                              { eapply T_MethodInvocation with(m:="length").
                                { eapply T_Add.
                                  { eapply T_Var with(x:="max").
                                    simpl. try reflexivity. }
                                  { eapply T_String with(s:=""). }
                                  { simpl. try reflexivity. } }
                                { simpl. try reflexivity. }
                                { simpl. try reflexivity. }
                                { eapply T_Nil. }
                                { simpl. try reflexivity. } }
                              { eapply T_Integer with(n:=1). }
                              { simpl. try reflexivity. } }
                            { simpl. try reflexivity. } }
                          { eapply T_Skip. } }
                        { eapply T_Concat.
                          { eapply T_Expression.
                            eapply T_MethodInvocation with(m:="add").
                            { eapply T_MethodInvocation with(m:="get").
                              { eapply T_Var with(x:="buckets").
                                simpl. try reflexivity. }
                              { simpl. try reflexivity. }
                              { simpl. try reflexivity. }
                              { eapply T_List.
                                { eapply T_Var with(x:="digit").
                                  simpl. try reflexivity. }
                                { eapply T_Nil. } }
                              { simpl. try reflexivity. } }
                            { simpl. try reflexivity. }
                            { simpl. try reflexivity. }
                            { eapply T_List.
                              { eapply T_Var with(x:="i").
                                simpl. try reflexivity. }
                              { eapply T_Nil. } }
                            { simpl. try reflexivity. } }
                          { eapply T_Skip. } } } }
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
                            { eapply T_Var with(x:="buckets").
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
                            eapply T_TyMethodInvocation with(m:="sort")(T:=(TyExternal "Collections")).
                            { simpl. try reflexivity. }
                            { simpl. try reflexivity. }
                            { eapply T_List.
                              { eapply T_MethodInvocation with(m:="get").
                                { eapply T_Var with(x:="buckets").
                                  simpl. try reflexivity. }
                                { simpl. try reflexivity. }
                                { simpl. try reflexivity. }
                                { eapply T_List.
                                  { eapply T_Var with(x:="i").
                                    simpl. try reflexivity. }
                                  { eapply T_Nil. } }
                                { simpl. try reflexivity. } }
                              { eapply T_Nil. } }
                            { simpl. try reflexivity. } }
                          { eapply T_Skip. } } }
                      { eapply T_Concat.
                        { eapply T_Concat.
                          { eapply T_DeclInit with(T:=(TyGeneric1 "List" TyInt))(x:="sortedNums").
                            { simpl. try reflexivity. }
                            { eapply T_New' with(T:=(TyGeneric1 "ArrayList" TyInt)).
                              { simpl. try reflexivity. }
                              { eapply T_Nil. } }
                            { simpl. try reflexivity. } }
                          { eapply T_Skip. } }
                        { eapply T_Concat.
                          { eapply T_Foreach with(T:=(TyGeneric1 "List" TyInt))(x:="bucket").
                            { simpl. try reflexivity. }
                            { eapply T_Var with(x:="buckets").
                              simpl. try reflexivity. }
                            { simpl. try reflexivity. }
                            { eapply T_Concat.
                              { eapply T_Expression.
                                eapply T_MethodInvocation with(m:="addAll").
                                { eapply T_Var with(x:="sortedNums").
                                  simpl. try reflexivity. }
                                { simpl. try reflexivity. }
                                { simpl. try reflexivity. }
                                { eapply T_List.
                                  { eapply T_Var with(x:="bucket").
                                    simpl. try reflexivity. }
                                  { eapply T_Nil. } }
                                { simpl. try reflexivity. } }
                              { eapply T_Skip. } } }
                          { eapply T_Concat.
                            { eapply T_Return.
                              { eapply T_Var with(x:="sortedNums").
                                simpl. try reflexivity. }
                              { simpl. try reflexivity. }
                              { simpl. try reflexivity. } }
                            { eapply T_Skip. } } } } } } } } } } } } } } }
  Unshelve.
  all: apply STyVoid.
Defined.
Definition prog := the_exists_term (prog_well_typed).
Print prog.