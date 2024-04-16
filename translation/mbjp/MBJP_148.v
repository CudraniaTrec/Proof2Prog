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
      { eapply T_ClassDecl with(name:="SumDigitsTwoparts").
        { simpl. try reflexivity. }
        { eapply T_MethodDecl with(modif:="public static")(T:=TyInt)(m:="sumDigitsTwoparts").
          { simpl. try reflexivity. }
          { eapply T_Concat.
            { eapply T_DeclNoInit with(T:=TyInt)(x:="n").
              simpl. try reflexivity. }
            { eapply T_Skip. } }
          { simpl. try reflexivity. }
          { eapply T_Concat.
            { eapply T_Concat.
              { eapply T_DeclInit with(T:=TyInt)(x:="sum").
                { simpl. try reflexivity. }
                { eapply T_Integer with(n:=0). }
                { simpl. try reflexivity. } }
              { eapply T_Skip. } }
            { eapply T_Concat.
              { eapply T_Concat.
                { eapply T_DeclInit with(T:=TyInt)(x:="d").
                  { simpl. try reflexivity. }
                  { eapply T_Var with(x:="n").
                    simpl. try reflexivity. }
                  { simpl. try reflexivity. } }
                { eapply T_Skip. } }
              { eapply T_Concat.
                { eapply T_While.
                  { eapply T_Ne.
                    { eapply T_Var with(x:="d").
                      simpl. try reflexivity. }
                    { eapply T_Integer with(n:=0). }
                    { simpl. try reflexivity. } }
                  { eapply T_Concat.
                    { eapply T_Expression.
                      eapply T_Assign.
                      { eapply T_Var with(x:="sum").
                        simpl. try reflexivity. }
                      { eapply T_Add.
                        { eapply T_Var with(x:="sum").
                          simpl. try reflexivity. }
                        { eapply T_Mod.
                          { eapply T_Var with(x:="d").
                            simpl. try reflexivity. }
                          { eapply T_Integer with(n:=10). } }
                        { simpl. try reflexivity. } }
                      { simpl. try reflexivity. } }
                    { eapply T_Concat.
                      { eapply T_Expression.
                        eapply T_Assign.
                        { eapply T_Var with(x:="d").
                          simpl. try reflexivity. }
                        { eapply T_Div.
                          { eapply T_Var with(x:="d").
                            simpl. try reflexivity. }
                          { eapply T_Integer with(n:=10). } }
                        { simpl. try reflexivity. } }
                      { eapply T_Skip. } } } }
                { eapply T_Concat.
                  { eapply T_Concat.
                    { eapply T_DeclInit with(T:=TyInt)(x:="ans").
                      { simpl. try reflexivity. }
                      { eapply T_Var with(x:="sum").
                        simpl. try reflexivity. }
                      { simpl. try reflexivity. } }
                    { eapply T_Skip. } }
                  { eapply T_Concat.
                    { eapply T_Expression.
                      eapply T_Assign.
                      { eapply T_Var with(x:="n").
                        simpl. try reflexivity. }
                      { eapply T_Sub.
                        { eapply T_Var with(x:="n").
                          simpl. try reflexivity. }
                        { eapply T_Var with(x:="ans").
                          simpl. try reflexivity. }
                        { simpl. try reflexivity. } }
                      { simpl. try reflexivity. } }
                    { eapply T_Concat.
                      { eapply T_Expression.
                        eapply T_Assign.
                        { eapply T_Var with(x:="ans").
                          simpl. try reflexivity. }
                        { eapply T_Integer with(n:=0). }
                        { simpl. try reflexivity. } }
                      { eapply T_Concat.
                        { eapply T_While.
                          { eapply T_Ne.
                            { eapply T_Var with(x:="n").
                              simpl. try reflexivity. }
                            { eapply T_Integer with(n:=0). }
                            { simpl. try reflexivity. } }
                          { eapply T_Concat.
                            { eapply T_Expression.
                              eapply T_Assign.
                              { eapply T_Var with(x:="sum").
                                simpl. try reflexivity. }
                              { eapply T_Add.
                                { eapply T_Var with(x:="sum").
                                  simpl. try reflexivity. }
                                { eapply T_Mod.
                                  { eapply T_Var with(x:="n").
                                    simpl. try reflexivity. }
                                  { eapply T_Integer with(n:=10). } }
                                { simpl. try reflexivity. } }
                              { simpl. try reflexivity. } }
                            { eapply T_Concat.
                              { eapply T_Expression.
                                eapply T_Assign.
                                { eapply T_Var with(x:="n").
                                  simpl. try reflexivity. }
                                { eapply T_Div.
                                  { eapply T_Var with(x:="n").
                                    simpl. try reflexivity. }
                                  { eapply T_Integer with(n:=10). } }
                                { simpl. try reflexivity. } }
                              { eapply T_Skip. } } } }
                        { eapply T_Concat.
                          { eapply T_Return.
                            { eapply T_Add.
                              { eapply T_Var with(x:="ans").
                                simpl. try reflexivity. }
                              { eapply T_Var with(x:="sum").
                                simpl. try reflexivity. }
                              { simpl. try reflexivity. } }
                            { simpl. try reflexivity. }
                            { simpl. try reflexivity. } }
                          { eapply T_Skip. } } } } } } } } } } } } } }
  Unshelve.
  all: apply STyVoid.
Defined.
Definition prog := the_exists_term (prog_well_typed).
Print prog.