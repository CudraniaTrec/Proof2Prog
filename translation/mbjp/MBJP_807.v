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
      { eapply T_ClassDecl with(name:="FirstOdd").
        { simpl. try reflexivity. }
        { eapply T_MethodDecl with(modif:="public static")(T:=TyInt)(m:="firstOdd").
          { simpl. try reflexivity. }
          { eapply T_Concat.
            { eapply T_DeclNoInit with(T:=(TyGeneric1 "List" TyInt))(x:="nums").
              simpl. try reflexivity. }
            { eapply T_Skip. } }
          { simpl. try reflexivity. }
          { eapply T_Concat.
            { eapply T_Concat.
              { eapply T_DeclInit with(T:=TyInt)(x:="count").
                { simpl. try reflexivity. }
                { eapply T_Integer with(n:=0). }
                { simpl. try reflexivity. } }
              { eapply T_Skip. } }
            { eapply T_Concat.
              { eapply T_Concat.
                { eapply T_DeclInit with(T:=TyInt)(x:="count1").
                  { simpl. try reflexivity. }
                  { eapply T_Integer with(n:=1). }
                  { simpl. try reflexivity. } }
                { eapply T_Skip. } }
              { eapply T_Concat.
                { eapply T_Concat.
                  { eapply T_DeclInit with(T:=TyInt)(x:="count2").
                    { simpl. try reflexivity. }
                    { eapply T_Integer with(n:=0). }
                    { simpl. try reflexivity. } }
                  { eapply T_Skip. } }
                { eapply T_Concat.
                  { eapply T_Concat.
                    { eapply T_DeclInit with(T:=TyBool)(x:="odd").
                      { simpl. try reflexivity. }
                      { eapply T_True. }
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
                          { eapply T_Var with(x:="nums").
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
                        { eapply T_IfElse.
                          { eapply T_And.
                            { eapply T_Var with(x:="odd").
                              simpl. try reflexivity. }
                            { eapply T_Eq.
                              { eapply T_Mod.
                                { eapply T_Var with(x:="i").
                                  simpl. try reflexivity. }
                                { eapply T_Integer with(n:=2). } }
                              { eapply T_Integer with(n:=0). }
                              { simpl. try reflexivity. } } }
                          { eapply T_Concat.
                            { eapply T_Expression.
                              eapply T_PostInc.
                              eapply T_Var with(x:="count").
                              simpl. try reflexivity. }
                            { eapply T_Skip. } }
                          { eapply T_Concat.
                            { eapply T_Expression.
                              eapply T_PostInc.
                              eapply T_Var with(x:="count2").
                              simpl. try reflexivity. }
                            { eapply T_Skip. } } }
                        { eapply T_Concat.
                          { eapply T_Expression.
                            eapply T_Assign.
                            { eapply T_Var with(x:="odd").
                              simpl. try reflexivity. }
                            { eapply T_False. }
                            { simpl. try reflexivity. } }
                          { eapply T_Skip. } } } }
                    { eapply T_Concat.
                      { eapply T_Return.
                        { eapply T_Choose.
                          { eapply T_Eq.
                            { eapply T_Mod.
                              { eapply T_Var with(x:="count").
                                simpl. try reflexivity. }
                              { eapply T_Var with(x:="count1").
                                simpl. try reflexivity. } }
                            { eapply T_Integer with(n:=0). }
                            { simpl. try reflexivity. } }
                          { eapply T_Var with(x:="count").
                            simpl. try reflexivity. }
                          { eapply T_Var with(x:="count1").
                            simpl. try reflexivity. }
                          { simpl. try reflexivity. } }
                        { simpl. try reflexivity. }
                        { simpl. try reflexivity. } }
                      { eapply T_Skip. } } } } } } } } } } } }
  Unshelve.
  all: apply STyVoid.
Defined.
Definition prog := the_exists_term (prog_well_typed).
Print prog.