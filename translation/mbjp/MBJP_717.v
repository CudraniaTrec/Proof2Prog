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
      { eapply T_ClassDecl with(name:="SdCalc").
        { simpl. try reflexivity. }
        { eapply T_MethodDecl with(modif:="public static")(T:=TyDouble)(m:="sdCalc").
          { simpl. try reflexivity. }
          { eapply T_Concat.
            { eapply T_DeclNoInit with(T:=(TyGeneric1 "List" TyInt))(x:="data").
              simpl. try reflexivity. }
            { eapply T_Skip. } }
          { simpl. try reflexivity. }
          { eapply T_Concat.
            { eapply T_Concat.
              { eapply T_DeclInit with(T:=TyDouble)(x:="sum").
                { simpl. try reflexivity. }
                { eapply T_Integer with(n:=0). }
                { simpl. try reflexivity. } }
              { eapply T_Concat.
                { eapply T_DeclInit with(T:=TyDouble)(x:="mean").
                  { simpl. try reflexivity. }
                  { eapply T_Integer with(n:=0). }
                  { simpl. try reflexivity. } }
                { eapply T_Skip. } } }
            { eapply T_Concat.
              { eapply T_Foreach with(T:=TyInt)(x:="d").
                { simpl. try reflexivity. }
                { eapply T_Var with(x:="data").
                  simpl. try reflexivity. }
                { simpl. try reflexivity. }
                { eapply T_Concat.
                  { eapply T_Expression.
                    eapply T_Assign.
                    { eapply T_Var with(x:="sum").
                      simpl. try reflexivity. }
                    { eapply T_Add.
                      { eapply T_Var with(x:="sum").
                        simpl. try reflexivity. }
                      { eapply T_Var with(x:="d").
                        simpl. try reflexivity. }
                      { simpl. try reflexivity. } }
                    { simpl. try reflexivity. } }
                  { eapply T_Skip. } } }
              { eapply T_Concat.
                { eapply T_Expression.
                  eapply T_Assign.
                  { eapply T_Var with(x:="mean").
                    simpl. try reflexivity. }
                  { eapply T_Div.
                    { eapply T_Var with(x:="sum").
                      simpl. try reflexivity. }
                    { eapply T_MethodInvocation with(m:="size").
                      { eapply T_Var with(x:="data").
                        simpl. try reflexivity. }
                      { simpl. try reflexivity. }
                      { simpl. try reflexivity. }
                      { eapply T_Nil. }
                      { simpl. try reflexivity. } } }
                  { simpl. try reflexivity. } }
                { eapply T_Concat.
                  { eapply T_Concat.
                    { eapply T_DeclInit with(T:=TyDouble)(x:="variance").
                      { simpl. try reflexivity. }
                      { eapply T_Integer with(n:=0). }
                      { simpl. try reflexivity. } }
                    { eapply T_Skip. } }
                  { eapply T_Concat.
                    { eapply T_Foreach with(T:=TyInt)(x:="d").
                      { simpl. try reflexivity. }
                      { eapply T_Var with(x:="data").
                        simpl. try reflexivity. }
                      { simpl. try reflexivity. }
                      { eapply T_Concat.
                        { eapply T_Concat.
                          { eapply T_DeclInit with(T:=TyDouble)(x:="diff").
                            { simpl. try reflexivity. }
                            { eapply T_Sub.
                              { eapply T_Var with(x:="d").
                                simpl. try reflexivity. }
                              { eapply T_Var with(x:="mean").
                                simpl. try reflexivity. }
                              { simpl. try reflexivity. } }
                            { simpl. try reflexivity. } }
                          { eapply T_Skip. } }
                        { eapply T_Concat.
                          { eapply T_Expression.
                            eapply T_Assign.
                            { eapply T_Var with(x:="variance").
                              simpl. try reflexivity. }
                            { eapply T_Add.
                              { eapply T_Var with(x:="variance").
                                simpl. try reflexivity. }
                              { eapply T_Mul.
                                { eapply T_Var with(x:="diff").
                                  simpl. try reflexivity. }
                                { eapply T_Var with(x:="diff").
                                  simpl. try reflexivity. } }
                              { simpl. try reflexivity. } }
                            { simpl. try reflexivity. } }
                          { eapply T_Skip. } } } }
                    { eapply T_Concat.
                      { eapply T_Expression.
                        eapply T_Assign.
                        { eapply T_Var with(x:="variance").
                          simpl. try reflexivity. }
                        { eapply T_Div.
                          { eapply T_Var with(x:="variance").
                            simpl. try reflexivity. }
                          { eapply T_Sub.
                            { eapply T_MethodInvocation with(m:="size").
                              { eapply T_Var with(x:="data").
                                simpl. try reflexivity. }
                              { simpl. try reflexivity. }
                              { simpl. try reflexivity. }
                              { eapply T_Nil. }
                              { simpl. try reflexivity. } }
                            { eapply T_Integer with(n:=1). }
                            { simpl. try reflexivity. } } }
                        { simpl. try reflexivity. } }
                      { eapply T_Concat.
                        { eapply T_Return.
                          { eapply T_TyMethodInvocation with(m:="sqrt")(T:=(TyExternal "Math")).
                            { simpl. try reflexivity. }
                            { simpl. try reflexivity. }
                            { eapply T_List.
                              { eapply T_Var with(x:="variance").
                                simpl. try reflexivity. }
                              { eapply T_Nil. } }
                            { simpl. try reflexivity. } }
                          { simpl. try reflexivity. }
                          { simpl. try reflexivity. } }
                        { eapply T_Skip. } } } } } } } } } } } } }
  Unshelve.
  all: apply STyVoid.
Defined.
Definition prog := the_exists_term (prog_well_typed).
Print prog.