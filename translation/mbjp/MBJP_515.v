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
      { eapply T_ClassDecl with(name:="ModularSum").
        { simpl. try reflexivity. }
        { eapply T_MethodDecl with(modif:="public static")(T:=TyBool)(m:="modularSum").
          { simpl. try reflexivity. }
          { eapply T_Concat.
            { eapply T_DeclNoInit with(T:=(TyGeneric1 "List" TyInt))(x:="arr").
              simpl. try reflexivity. }
            { eapply T_Concat.
              { eapply T_DeclNoInit with(T:=TyInt)(x:="n").
                simpl. try reflexivity. }
              { eapply T_Concat.
                { eapply T_DeclNoInit with(T:=TyInt)(x:="m").
                  simpl. try reflexivity. }
                { eapply T_Skip. } } } }
          { simpl. try reflexivity. }
          { eapply T_Concat.
            { eapply T_Concat.
              { eapply T_DeclInit with(T:=TyInt)(x:="n1").
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
                { eapply T_DeclInit with(T:=TyInt)(x:="m1").
                  { simpl. try reflexivity. }
                  { eapply T_Sub.
                    { eapply T_Var with(x:="m").
                      simpl. try reflexivity. }
                    { eapply T_Var with(x:="n").
                      simpl. try reflexivity. }
                    { simpl. try reflexivity. } }
                  { simpl. try reflexivity. } }
                { eapply T_Skip. } }
              { eapply T_Concat.
                { eapply T_If.
                  { eapply T_Eq.
                    { eapply T_Var with(x:="m1").
                      simpl. try reflexivity. }
                    { eapply T_Integer with(n:=0). }
                    { simpl. try reflexivity. } }
                  { eapply T_Concat.
                    { eapply T_Return.
                      { eapply T_True. }
                      { simpl. try reflexivity. }
                      { simpl. try reflexivity. } }
                    { eapply T_Skip. } } }
                { eapply T_Concat.
                  { eapply T_Concat.
                    { eapply T_DeclInit with(T:=TyInt)(x:="i").
                      { simpl. try reflexivity. }
                      { eapply T_Integer with(n:=0). }
                      { simpl. try reflexivity. } }
                    { eapply T_Skip. } }
                  { eapply T_Concat.
                    { eapply T_While.
                      { eapply T_And.
                        { eapply T_Lt.
                          { eapply T_Var with(x:="i").
                            simpl. try reflexivity. }
                          { eapply T_Var with(x:="n1").
                            simpl. try reflexivity. }
                          { simpl. try reflexivity. } }
                        { eapply T_Lt.
                          { eapply T_Var with(x:="i").
                            simpl. try reflexivity. }
                          { eapply T_Var with(x:="m1").
                            simpl. try reflexivity. }
                          { simpl. try reflexivity. } } }
                      { eapply T_Concat.
                        { eapply T_Concat.
                          { eapply T_DeclInit with(T:=TyInt)(x:="r").
                            { simpl. try reflexivity. }
                            { eapply T_Mod.
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
                              { eapply T_Var with(x:="m1").
                                simpl. try reflexivity. } }
                            { simpl. try reflexivity. } }
                          { eapply T_Skip. } }
                        { eapply T_Concat.
                          { eapply T_Concat.
                            { eapply T_DeclInit with(T:=TyInt)(x:="c").
                              { simpl. try reflexivity. }
                              { eapply T_Div.
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
                                { eapply T_Var with(x:="m1").
                                  simpl. try reflexivity. } }
                              { simpl. try reflexivity. } }
                            { eapply T_Skip. } }
                          { eapply T_Concat.
                            { eapply T_IfElse.
                              { eapply T_Eq.
                                { eapply T_Var with(x:="r").
                                  simpl. try reflexivity. }
                                { eapply T_Var with(x:="c").
                                  simpl. try reflexivity. }
                                { simpl. try reflexivity. } }
                              { eapply T_Concat.
                                { eapply T_Return.
                                  { eapply T_True. }
                                  { simpl. try reflexivity. }
                                  { simpl. try reflexivity. } }
                                { eapply T_Skip. } }
                              { eapply T_Concat.
                                { eapply T_Expression.
                                  eapply T_PostInc.
                                  eapply T_Var with(x:="i").
                                  simpl. try reflexivity. }
                                { eapply T_Skip. } } }
                            { eapply T_Skip. } } } } }
                    { eapply T_Concat.
                      { eapply T_Return.
                        { eapply T_False. }
                        { simpl. try reflexivity. }
                        { simpl. try reflexivity. } }
                      { eapply T_Skip. } } } } } } } } } } } }
  Unshelve.
  all: apply STyVoid.
Defined.
Definition prog := the_exists_term (prog_well_typed).
Print prog.