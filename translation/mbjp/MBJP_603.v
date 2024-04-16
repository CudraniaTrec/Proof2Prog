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
      { eapply T_ClassDecl with(name:="GetLudic").
        { simpl. try reflexivity. }
        { eapply T_MethodDecl with(modif:="public static")(T:=(TyGeneric1 "List" TyInt))(m:="getLudic").
          { simpl. try reflexivity. }
          { eapply T_Concat.
            { eapply T_DeclNoInit with(T:=TyInt)(x:="n").
              simpl. try reflexivity. }
            { eapply T_Skip. } }
          { simpl. try reflexivity. }
          { eapply T_Concat.
            { eapply T_Concat.
              { eapply T_DeclInit with(T:=(TyGeneric1 "List" TyInt))(x:="ludics").
                { simpl. try reflexivity. }
                { eapply T_New' with(T:=(TyGeneric1 "ArrayList" TyInt)).
                  { simpl. try reflexivity. }
                  { eapply T_Nil. } }
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
                { eapply T_Le.
                  { eapply T_Var with(x:="i").
                    simpl. try reflexivity. }
                  { eapply T_Var with(x:="n").
                    simpl. try reflexivity. }
                  { simpl. try reflexivity. } }
                { eapply T_PostInc.
                  eapply T_Var with(x:="i").
                  simpl. try reflexivity. }
                { eapply T_Concat.
                  { eapply T_Expression.
                    eapply T_MethodInvocation with(m:="add").
                    { eapply T_Var with(x:="ludics").
                      simpl. try reflexivity. }
                    { simpl. try reflexivity. }
                    { simpl. try reflexivity. }
                    { eapply T_List.
                      { eapply T_Var with(x:="i").
                        simpl. try reflexivity. }
                      { eapply T_Nil. } }
                    { simpl. try reflexivity. } }
                  { eapply T_Skip. } } }
              { eapply T_Concat.
                { eapply T_Concat.
                  { eapply T_DeclInit with(T:=TyInt)(x:="index").
                    { simpl. try reflexivity. }
                    { eapply T_Integer with(n:=1). }
                    { simpl. try reflexivity. } }
                  { eapply T_Skip. } }
                { eapply T_Concat.
                  { eapply T_While.
                    { eapply T_Ne.
                      { eapply T_Var with(x:="index").
                        simpl. try reflexivity. }
                      { eapply T_MethodInvocation with(m:="size").
                        { eapply T_Var with(x:="ludics").
                          simpl. try reflexivity. }
                        { simpl. try reflexivity. }
                        { simpl. try reflexivity. }
                        { eapply T_Nil. }
                        { simpl. try reflexivity. } }
                      { simpl. try reflexivity. } }
                    { eapply T_Concat.
                      { eapply T_Concat.
                        { eapply T_DeclInit with(T:=TyInt)(x:="firstLudic").
                          { simpl. try reflexivity. }
                          { eapply T_MethodInvocation with(m:="get").
                            { eapply T_Var with(x:="ludics").
                              simpl. try reflexivity. }
                            { simpl. try reflexivity. }
                            { simpl. try reflexivity. }
                            { eapply T_List.
                              { eapply T_Var with(x:="index").
                                simpl. try reflexivity. }
                              { eapply T_Nil. } }
                            { simpl. try reflexivity. } }
                          { simpl. try reflexivity. } }
                        { eapply T_Skip. } }
                      { eapply T_Concat.
                        { eapply T_Concat.
                          { eapply T_DeclInit with(T:=TyInt)(x:="removeIndex").
                            { simpl. try reflexivity. }
                            { eapply T_Add.
                              { eapply T_Var with(x:="index").
                                simpl. try reflexivity. }
                              { eapply T_Var with(x:="firstLudic").
                                simpl. try reflexivity. }
                              { simpl. try reflexivity. } }
                            { simpl. try reflexivity. } }
                          { eapply T_Skip. } }
                        { eapply T_Concat.
                          { eapply T_While.
                            { eapply T_Lt.
                              { eapply T_Var with(x:="removeIndex").
                                simpl. try reflexivity. }
                              { eapply T_MethodInvocation with(m:="size").
                                { eapply T_Var with(x:="ludics").
                                  simpl. try reflexivity. }
                                { simpl. try reflexivity. }
                                { simpl. try reflexivity. }
                                { eapply T_Nil. }
                                { simpl. try reflexivity. } }
                              { simpl. try reflexivity. } }
                            { eapply T_Concat.
                              { eapply T_Expression.
                                eapply T_MethodInvocation with(m:="remove").
                                { eapply T_Var with(x:="ludics").
                                  simpl. try reflexivity. }
                                { simpl. try reflexivity. }
                                { simpl. try reflexivity. }
                                { eapply T_List.
                                  { eapply T_MethodInvocation with(m:="get").
                                    { eapply T_Var with(x:="ludics").
                                      simpl. try reflexivity. }
                                    { simpl. try reflexivity. }
                                    { simpl. try reflexivity. }
                                    { eapply T_List.
                                      { eapply T_Var with(x:="removeIndex").
                                        simpl. try reflexivity. }
                                      { eapply T_Nil. } }
                                    { simpl. try reflexivity. } }
                                  { eapply T_Nil. } }
                                { simpl. try reflexivity. } }
                              { eapply T_Concat.
                                { eapply T_Expression.
                                  eapply T_Assign.
                                  { eapply T_Var with(x:="removeIndex").
                                    simpl. try reflexivity. }
                                  { eapply T_Sub.
                                    { eapply T_Add.
                                      { eapply T_Var with(x:="removeIndex").
                                        simpl. try reflexivity. }
                                      { eapply T_Var with(x:="firstLudic").
                                        simpl. try reflexivity. }
                                      { simpl. try reflexivity. } }
                                    { eapply T_Integer with(n:=1). }
                                    { simpl. try reflexivity. } }
                                  { simpl. try reflexivity. } }
                                { eapply T_Skip. } } } }
                          { eapply T_Concat.
                            { eapply T_Expression.
                              eapply T_PostInc.
                              eapply T_Var with(x:="index").
                              simpl. try reflexivity. }
                            { eapply T_Skip. } } } } } }
                  { eapply T_Concat.
                    { eapply T_Return.
                      { eapply T_Var with(x:="ludics").
                        simpl. try reflexivity. }
                      { simpl. try reflexivity. }
                      { simpl. try reflexivity. } }
                    { eapply T_Skip. } } } } } } } } } } }
  Unshelve.
  all: apply STyVoid.
Defined.
Definition prog := the_exists_term (prog_well_typed).
Print prog.