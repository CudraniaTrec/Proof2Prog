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
      { eapply T_ClassDecl with(name:="NoprofitNoloss").
        { simpl. try reflexivity. }
        { eapply T_MethodDecl with(modif:="public static")(T:=TyBool)(m:="noprofitNoloss").
          { simpl. try reflexivity. }
          { eapply T_Concat.
            { eapply T_DeclNoInit with(T:=TyInt)(x:="actualCost").
              simpl. try reflexivity. }
            { eapply T_Concat.
              { eapply T_DeclNoInit with(T:=TyInt)(x:="saleAmount").
                simpl. try reflexivity. }
              { eapply T_Skip. } } }
          { simpl. try reflexivity. }
          { eapply T_Concat.
            { eapply T_If.
              { eapply T_Eq.
                { eapply T_Var with(x:="actualCost").
                  simpl. try reflexivity. }
                { eapply T_Var with(x:="saleAmount").
                  simpl. try reflexivity. }
                { simpl. try reflexivity. } }
              { eapply T_Concat.
                { eapply T_Return.
                  { eapply T_True. }
                  { simpl. try reflexivity. }
                  { simpl. try reflexivity. } }
                { eapply T_Skip. } } }
            { eapply T_Concat.
              { eapply T_If.
                { eapply T_Gt.
                  { eapply T_Var with(x:="saleAmount").
                    simpl. try reflexivity. }
                  { eapply T_Integer with(n:=1000). }
                  { simpl. try reflexivity. } }
                { eapply T_Concat.
                  { eapply T_Return.
                    { eapply T_False. }
                    { simpl. try reflexivity. }
                    { simpl. try reflexivity. } }
                  { eapply T_Skip. } } }
              { eapply T_Concat.
                { eapply T_Concat.
                  { eapply T_DeclInit with(T:=TyInt)(x:="diff").
                    { simpl. try reflexivity. }
                    { eapply T_Sub.
                      { eapply T_Var with(x:="actualCost").
                        simpl. try reflexivity. }
                      { eapply T_Var with(x:="saleAmount").
                        simpl. try reflexivity. }
                      { simpl. try reflexivity. } }
                    { simpl. try reflexivity. } }
                  { eapply T_Skip. } }
                { eapply T_Concat.
                  { eapply T_Concat.
                    { eapply T_DeclInit with(T:=TyInt)(x:="count").
                      { simpl. try reflexivity. }
                      { eapply T_Integer with(n:=0). }
                      { simpl. try reflexivity. } }
                    { eapply T_Skip. } }
                  { eapply T_Concat.
                    { eapply T_While.
                      { eapply T_Gt.
                        { eapply T_Var with(x:="diff").
                          simpl. try reflexivity. }
                        { eapply T_Integer with(n:=0). }
                        { simpl. try reflexivity. } }
                      { eapply T_Concat.
                        { eapply T_Expression.
                          eapply T_Assign.
                          { eapply T_Var with(x:="diff").
                            simpl. try reflexivity. }
                          { eapply T_BitAnd.
                            { eapply T_Var with(x:="diff").
                              simpl. try reflexivity. }
                            { eapply T_Sub.
                              { eapply T_Var with(x:="diff").
                                simpl. try reflexivity. }
                              { eapply T_Integer with(n:=1). }
                              { simpl. try reflexivity. } }
                            { simpl. try reflexivity. } }
                          { simpl. try reflexivity. } }
                        { eapply T_Concat.
                          { eapply T_Expression.
                            eapply T_PostInc.
                            eapply T_Var with(x:="count").
                            simpl. try reflexivity. }
                          { eapply T_Skip. } } } }
                    { eapply T_Concat.
                      { eapply T_Concat.
                        { eapply T_DeclInit with(T:=TyInt)(x:="max").
                          { simpl. try reflexivity. }
                          { eapply T_Integer with(n:=0). }
                          { simpl. try reflexivity. } }
                        { eapply T_Skip. } }
                      { eapply T_Concat.
                        { eapply T_While.
                          { eapply T_Lt.
                            { eapply T_Var with(x:="count").
                              simpl. try reflexivity. }
                            { eapply T_Integer with(n:=1500). }
                            { simpl. try reflexivity. } }
                          { eapply T_Concat.
                            { eapply T_If.
                              { eapply T_Gt.
                                { eapply T_Var with(x:="count").
                                  simpl. try reflexivity. }
                                { eapply T_Integer with(n:=3000). }
                                { simpl. try reflexivity. } }
                              { eapply T_Concat.
                                { eapply T_Return.
                                  { eapply T_False. }
                                  { simpl. try reflexivity. }
                                  { simpl. try reflexivity. } }
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
                                      { eapply T_Var with(x:="count").
                                        simpl. try reflexivity. }
                                      { eapply T_Nil. } } }
                                  { simpl. try reflexivity. } }
                                { simpl. try reflexivity. } }
                              { eapply T_Concat.
                                { eapply T_Expression.
                                  eapply T_Assign.
                                  { eapply T_Var with(x:="count").
                                    simpl. try reflexivity. }
                                  { eapply T_Add.
                                    { eapply T_Var with(x:="count").
                                      simpl. try reflexivity. }
                                    { eapply T_Integer with(n:=1500). }
                                    { simpl. try reflexivity. } }
                                  { simpl. try reflexivity. } }
                                { eapply T_Skip. } } } } }
                        { eapply T_Concat.
                          { eapply T_Return.
                            { eapply T_True. }
                            { simpl. try reflexivity. }
                            { simpl. try reflexivity. } }
                          { eapply T_Skip. } } } } } } } } } } } } } }
  Unshelve.
  all: apply STyVoid.
Defined.
Definition prog := the_exists_term (prog_well_typed).
Print prog.