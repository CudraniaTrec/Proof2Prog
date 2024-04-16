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
      { eapply T_ClassDecl with(name:="MaxOccurrences").
        { simpl. try reflexivity. }
        { eapply T_MethodDecl with(modif:="public static")(T:=(TyGeneric1 "List" TyInt))(m:="maxOccurrences").
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
                { eapply T_Integer with(n:=0). }
                { simpl. try reflexivity. } }
              { eapply T_Concat.
                { eapply T_DeclInit with(T:=TyInt)(x:="max_occ").
                  { simpl. try reflexivity. }
                  { eapply T_Integer with(n:=0). }
                  { simpl. try reflexivity. } }
                { eapply T_Skip. } } }
            { eapply T_Concat.
              { eapply T_Concat.
                { eapply T_DeclInit with(T:=(TyGeneric2 "HashMap" TyInt TyInt))(x:="occ").
                  { simpl. try reflexivity. }
                  { eapply T_New' with(T:=(TyGeneric0 "HashMap")).
                    { simpl. try reflexivity. }
                    { eapply T_Nil. } }
                  { simpl. try reflexivity. } }
                { eapply T_Skip. } }
              { eapply T_Concat.
                { eapply T_Foreach with(T:=TyInt)(x:="i").
                  { simpl. try reflexivity. }
                  { eapply T_Var with(x:="nums").
                    simpl. try reflexivity. }
                  { simpl. try reflexivity. }
                  { eapply T_Concat.
                    { eapply T_IfElse.
                      { eapply T_MethodInvocation with(m:="containsKey").
                        { eapply T_Var with(x:="occ").
                          simpl. try reflexivity. }
                        { simpl. try reflexivity. }
                        { simpl. try reflexivity. }
                        { eapply T_List.
                          { eapply T_Var with(x:="i").
                            simpl. try reflexivity. }
                          { eapply T_Nil. } }
                        { simpl. try reflexivity. } }
                      { eapply T_Concat.
                        { eapply T_Expression.
                          eapply T_MethodInvocation with(m:="put").
                          { eapply T_Var with(x:="occ").
                            simpl. try reflexivity. }
                          { simpl. try reflexivity. }
                          { simpl. try reflexivity. }
                          { eapply T_List.
                            { eapply T_Var with(x:="i").
                              simpl. try reflexivity. }
                            { eapply T_List.
                              { eapply T_Add.
                                { eapply T_MethodInvocation with(m:="get").
                                  { eapply T_Var with(x:="occ").
                                    simpl. try reflexivity. }
                                  { simpl. try reflexivity. }
                                  { simpl. try reflexivity. }
                                  { eapply T_List.
                                    { eapply T_Var with(x:="i").
                                      simpl. try reflexivity. }
                                    { eapply T_Nil. } }
                                  { simpl. try reflexivity. } }
                                { eapply T_Integer with(n:=1). }
                                { simpl. try reflexivity. } }
                              { eapply T_Nil. } } }
                          { simpl. try reflexivity. } }
                        { eapply T_Skip. } }
                      { eapply T_Concat.
                        { eapply T_Expression.
                          eapply T_MethodInvocation with(m:="put").
                          { eapply T_Var with(x:="occ").
                            simpl. try reflexivity. }
                          { simpl. try reflexivity. }
                          { simpl. try reflexivity. }
                          { eapply T_List.
                            { eapply T_Var with(x:="i").
                              simpl. try reflexivity. }
                            { eapply T_List.
                              { eapply T_Integer with(n:=1). }
                              { eapply T_Nil. } } }
                          { simpl. try reflexivity. } }
                        { eapply T_Skip. } } }
                    { eapply T_Concat.
                      { eapply T_If.
                        { eapply T_Gt.
                          { eapply T_MethodInvocation with(m:="get").
                            { eapply T_Var with(x:="occ").
                              simpl. try reflexivity. }
                            { simpl. try reflexivity. }
                            { simpl. try reflexivity. }
                            { eapply T_List.
                              { eapply T_Var with(x:="i").
                                simpl. try reflexivity. }
                              { eapply T_Nil. } }
                            { simpl. try reflexivity. } }
                          { eapply T_Var with(x:="max_occ").
                            simpl. try reflexivity. }
                          { simpl. try reflexivity. } }
                        { eapply T_Concat.
                          { eapply T_Expression.
                            eapply T_Assign.
                            { eapply T_Var with(x:="max_occ").
                              simpl. try reflexivity. }
                            { eapply T_MethodInvocation with(m:="get").
                              { eapply T_Var with(x:="occ").
                                simpl. try reflexivity. }
                              { simpl. try reflexivity. }
                              { simpl. try reflexivity. }
                              { eapply T_List.
                                { eapply T_Var with(x:="i").
                                  simpl. try reflexivity. }
                                { eapply T_Nil. } }
                              { simpl. try reflexivity. } }
                            { simpl. try reflexivity. } }
                          { eapply T_Concat.
                            { eapply T_Expression.
                              eapply T_Assign.
                              { eapply T_Var with(x:="max").
                                simpl. try reflexivity. }
                              { eapply T_Var with(x:="i").
                                simpl. try reflexivity. }
                              { simpl. try reflexivity. } }
                            { eapply T_Skip. } } } }
                      { eapply T_Skip. } } } }
                { eapply T_Concat.
                  { eapply T_Concat.
                    { eapply T_DeclInit with(T:=(TyGeneric1 "List" TyInt))(x:="result").
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
                        { eapply T_Var with(x:="max").
                          simpl. try reflexivity. }
                        { eapply T_Nil. } }
                      { simpl. try reflexivity. } }
                    { eapply T_Concat.
                      { eapply T_Expression.
                        eapply T_MethodInvocation with(m:="add").
                        { eapply T_Var with(x:="result").
                          simpl. try reflexivity. }
                        { simpl. try reflexivity. }
                        { simpl. try reflexivity. }
                        { eapply T_List.
                          { eapply T_Var with(x:="max_occ").
                            simpl. try reflexivity. }
                          { eapply T_Nil. } }
                        { simpl. try reflexivity. } }
                      { eapply T_Concat.
                        { eapply T_Return.
                          { eapply T_Var with(x:="result").
                            simpl. try reflexivity. }
                          { simpl. try reflexivity. }
                          { simpl. try reflexivity. } }
                        { eapply T_Skip. } } } } } } } } } } } } }
  Unshelve.
  all: apply STyVoid.
Defined.
Definition prog := the_exists_term (prog_well_typed).
Print prog.