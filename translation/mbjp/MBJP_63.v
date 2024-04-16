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
      { eapply T_ClassDecl with(name:="MaxDifference").
        { simpl. try reflexivity. }
        { eapply T_MethodDecl with(modif:="public static")(T:=TyInt)(m:="maxDifference").
          { simpl. try reflexivity. }
          { eapply T_Concat.
            { eapply T_DeclNoInit with(T:=(TyGeneric1 "List" (TyGeneric1 "List" TyInt)))(x:="testList").
              simpl. try reflexivity. }
            { eapply T_Skip. } }
          { simpl. try reflexivity. }
          { eapply T_Concat.
            { eapply T_Concat.
              { eapply T_DeclInit with(T:=TyInt)(x:="max").
                { simpl. try reflexivity. }
                { eapply T_TyFieldAccess with(f:="MIN_VALUE")(T:=(TyExternal "Integer")).
                  { simpl. try reflexivity. }
                  { simpl. try reflexivity. } }
                { simpl. try reflexivity. } }
              { eapply T_Skip. } }
            { eapply T_Concat.
              { eapply T_Foreach with(T:=(TyGeneric1 "List" TyInt))(x:="list").
                { simpl. try reflexivity. }
                { eapply T_Var with(x:="testList").
                  simpl. try reflexivity. }
                { simpl. try reflexivity. }
                { eapply T_Concat.
                  { eapply T_Concat.
                    { eapply T_DeclInit with(T:=TyInt)(x:="maxdiff").
                      { simpl. try reflexivity. }
                      { eapply T_Integer with(n:=0). }
                      { simpl. try reflexivity. } }
                    { eapply T_Skip. } }
                  { eapply T_Concat.
                    { eapply T_Foreach with(T:=TyInt)(x:="i").
                      { simpl. try reflexivity. }
                      { eapply T_Var with(x:="list").
                        simpl. try reflexivity. }
                      { simpl. try reflexivity. }
                      { eapply T_Concat.
                        { eapply T_Foreach with(T:=TyInt)(x:="j").
                          { simpl. try reflexivity. }
                          { eapply T_Var with(x:="list").
                            simpl. try reflexivity. }
                          { simpl. try reflexivity. }
                          { eapply T_Concat.
                            { eapply T_Expression.
                              eapply T_Assign.
                              { eapply T_Var with(x:="maxdiff").
                                simpl. try reflexivity. }
                              { eapply T_TyMethodInvocation with(m:="max")(T:=(TyExternal "Math")).
                                { simpl. try reflexivity. }
                                { simpl. try reflexivity. }
                                { eapply T_List.
                                  { eapply T_Var with(x:="maxdiff").
                                    simpl. try reflexivity. }
                                  { eapply T_List.
                                    { eapply T_TyMethodInvocation with(m:="abs")(T:=(TyExternal "Math")).
                                      { simpl. try reflexivity. }
                                      { simpl. try reflexivity. }
                                      { eapply T_List.
                                        { eapply T_Sub.
                                          { eapply T_Var with(x:="i").
                                            simpl. try reflexivity. }
                                          { eapply T_Var with(x:="j").
                                            simpl. try reflexivity. }
                                          { simpl. try reflexivity. } }
                                        { eapply T_Nil. } }
                                      { simpl. try reflexivity. } }
                                    { eapply T_Nil. } } }
                                { simpl. try reflexivity. } }
                              { simpl. try reflexivity. } }
                            { eapply T_Skip. } } }
                        { eapply T_Skip. } } }
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
                              { eapply T_Var with(x:="maxdiff").
                                simpl. try reflexivity. }
                              { eapply T_Nil. } } }
                          { simpl. try reflexivity. } }
                        { simpl. try reflexivity. } }
                      { eapply T_Skip. } } } } }
              { eapply T_Concat.
                { eapply T_Return.
                  { eapply T_Var with(x:="max").
                    simpl. try reflexivity. }
                  { simpl. try reflexivity. }
                  { simpl. try reflexivity. } }
                { eapply T_Skip. } } } } } } } } }
  Unshelve.
  all: apply STyVoid.
Defined.
Definition prog := the_exists_term (prog_well_typed).
Print prog.