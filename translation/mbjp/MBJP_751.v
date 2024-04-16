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
      { eapply T_ClassDecl with(name:="CheckMinHeap").
        { simpl. try reflexivity. }
        { eapply T_MethodDecl with(modif:="public static")(T:=TyBool)(m:="checkMinHeap").
          { simpl. try reflexivity. }
          { eapply T_Concat.
            { eapply T_DeclNoInit with(T:=(TyGeneric1 "List" TyInt))(x:="arr").
              simpl. try reflexivity. }
            { eapply T_Concat.
              { eapply T_DeclNoInit with(T:=TyInt)(x:="i").
                simpl. try reflexivity. }
              { eapply T_Skip. } } }
          { simpl. try reflexivity. }
          { eapply T_Concat.
            { eapply T_Concat.
              { eapply T_DeclInit with(T:=TyInt)(x:="curMin").
                { simpl. try reflexivity. }
                { eapply T_MethodInvocation with(m:="get").
                  { eapply T_Var with(x:="arr").
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
              { eapply T_Concat.
                { eapply T_DeclInit with(T:=TyInt)(x:="size").
                  { simpl. try reflexivity. }
                  { eapply T_MethodInvocation with(m:="size").
                    { eapply T_Var with(x:="arr").
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
                    { eapply T_Var with(x:="curMin").
                      simpl. try reflexivity. }
                    { simpl. try reflexivity. } }
                  { eapply T_Skip. } }
                { eapply T_Concat.
                  { eapply T_While.
                    { eapply T_Gt.
                      { eapply T_Var with(x:="curMin").
                        simpl. try reflexivity. }
                      { eapply T_Integer with(n:=1). }
                      { simpl. try reflexivity. } }
                    { eapply T_Concat.
                      { eapply T_If.
                        { eapply T_Or.
                          { eapply T_Lt.
                            { eapply T_Var with(x:="size").
                              simpl. try reflexivity. }
                            { eapply T_MethodInvocation with(m:="get").
                              { eapply T_Var with(x:="arr").
                                simpl. try reflexivity. }
                              { simpl. try reflexivity. }
                              { simpl. try reflexivity. }
                              { eapply T_List.
                                { eapply T_Sub.
                                  { eapply T_Var with(x:="curMin").
                                    simpl. try reflexivity. }
                                  { eapply T_Integer with(n:=1). }
                                  { simpl. try reflexivity. } }
                                { eapply T_Nil. } }
                              { simpl. try reflexivity. } }
                            { simpl. try reflexivity. } }
                          { eapply T_Gt.
                            { eapply T_Add.
                              { eapply T_Var with(x:="curMin").
                                simpl. try reflexivity. }
                              { eapply T_Integer with(n:=1). }
                              { simpl. try reflexivity. } }
                            { eapply T_Var with(x:="size").
                              simpl. try reflexivity. }
                            { simpl. try reflexivity. } } }
                        { eapply T_Concat.
                          { eapply T_Return.
                            { eapply T_False. }
                            { simpl. try reflexivity. }
                            { simpl. try reflexivity. } }
                          { eapply T_Skip. } } }
                      { eapply T_Concat.
                        { eapply T_Expression.
                          eapply T_PostDec.
                          eapply T_Var with(x:="curMin").
                          simpl. try reflexivity. }
                        { eapply T_Skip. } } } }
                  { eapply T_Concat.
                    { eapply T_Return.
                      { eapply T_True. }
                      { simpl. try reflexivity. }
                      { simpl. try reflexivity. } }
                    { eapply T_Skip. } } } } } } } } } } }
  Unshelve.
  all: apply STyVoid.
Defined.
Definition prog := the_exists_term (prog_well_typed).
Print prog.