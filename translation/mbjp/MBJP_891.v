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
      { eapply T_ClassDecl with(name:="SameLength").
        { simpl. try reflexivity. }
        { eapply T_MethodDecl with(modif:="public static")(T:=TyBool)(m:="sameLength").
          { simpl. try reflexivity. }
          { eapply T_Concat.
            { eapply T_DeclNoInit with(T:=TyInt)(x:="a").
              simpl. try reflexivity. }
            { eapply T_Concat.
              { eapply T_DeclNoInit with(T:=TyInt)(x:="b").
                simpl. try reflexivity. }
              { eapply T_Skip. } } }
          { simpl. try reflexivity. }
          { eapply T_Concat.
            { eapply T_If.
              { eapply T_Or.
                { eapply T_Lt.
                  { eapply T_Var with(x:="a").
                    simpl. try reflexivity. }
                  { eapply T_Integer with(n:=0). }
                  { simpl. try reflexivity. } }
                { eapply T_Lt.
                  { eapply T_Var with(x:="b").
                    simpl. try reflexivity. }
                  { eapply T_Integer with(n:=0). }
                  { simpl. try reflexivity. } } }
              { eapply T_Concat.
                { eapply T_Return.
                  { eapply T_False. }
                  { simpl. try reflexivity. }
                  { simpl. try reflexivity. } }
                { eapply T_Skip. } } }
            { eapply T_Concat.
              { eapply T_Concat.
                { eapply T_DeclInit with(T:=TyInt)(x:="aLen").
                  { simpl. try reflexivity. }
                  { eapply T_Add.
                    { eapply T_Var with(x:="a").
                      simpl. try reflexivity. }
                    { eapply T_Integer with(n:=1). }
                    { simpl. try reflexivity. } }
                  { simpl. try reflexivity. } }
                { eapply T_Skip. } }
              { eapply T_Concat.
                { eapply T_Concat.
                  { eapply T_DeclInit with(T:=TyInt)(x:="bLen").
                    { simpl. try reflexivity. }
                    { eapply T_Add.
                      { eapply T_Var with(x:="b").
                        simpl. try reflexivity. }
                      { eapply T_Integer with(n:=1). }
                      { simpl. try reflexivity. } }
                    { simpl. try reflexivity. } }
                  { eapply T_Skip. } }
                { eapply T_Concat.
                  { eapply T_If.
                    { eapply T_Or.
                      { eapply T_Lt.
                        { eapply T_Var with(x:="aLen").
                          simpl. try reflexivity. }
                        { eapply T_Integer with(n:=0). }
                        { simpl. try reflexivity. } }
                      { eapply T_Lt.
                        { eapply T_Var with(x:="bLen").
                          simpl. try reflexivity. }
                        { eapply T_Integer with(n:=0). }
                        { simpl. try reflexivity. } } }
                    { eapply T_Concat.
                      { eapply T_Return.
                        { eapply T_False. }
                        { simpl. try reflexivity. }
                        { simpl. try reflexivity. } }
                      { eapply T_Skip. } } }
                  { eapply T_Concat.
                    { eapply T_Concat.
                      { eapply T_DeclInit with(T:=TyInt)(x:="len").
                        { simpl. try reflexivity. }
                        { eapply T_Var with(x:="aLen").
                          simpl. try reflexivity. }
                        { simpl. try reflexivity. } }
                      { eapply T_Skip. } }
                    { eapply T_Concat.
                      { eapply T_If.
                        { eapply T_Or.
                          { eapply T_Lt.
                            { eapply T_Var with(x:="len").
                              simpl. try reflexivity. }
                            { eapply T_Integer with(n:=0). }
                            { simpl. try reflexivity. } }
                          { eapply T_Gt.
                            { eapply T_Var with(x:="len").
                              simpl. try reflexivity. }
                            { eapply T_Var with(x:="bLen").
                              simpl. try reflexivity. }
                            { simpl. try reflexivity. } } }
                        { eapply T_Concat.
                          { eapply T_Return.
                            { eapply T_False. }
                            { simpl. try reflexivity. }
                            { simpl. try reflexivity. } }
                          { eapply T_Skip. } } }
                      { eapply T_Concat.
                        { eapply T_While.
                          { eapply T_Lt.
                            { eapply T_Var with(x:="aLen").
                              simpl. try reflexivity. }
                            { eapply T_Var with(x:="bLen").
                              simpl. try reflexivity. }
                            { simpl. try reflexivity. } }
                          { eapply T_Concat.
                            { eapply T_If.
                              { eapply T_Lt.
                                { eapply T_Var with(x:="a").
                                  simpl. try reflexivity. }
                                { eapply T_Sub.
                                  { eapply T_Var with(x:="bLen").
                                    simpl. try reflexivity. }
                                  { eapply T_Var with(x:="len").
                                    simpl. try reflexivity. }
                                  { simpl. try reflexivity. } }
                                { simpl. try reflexivity. } }
                              { eapply T_Concat.
                                { eapply T_Return.
                                  { eapply T_False. }
                                  { simpl. try reflexivity. }
                                  { simpl. try reflexivity. } }
                                { eapply T_Skip. } } }
                            { eapply T_Concat.
                              { eapply T_Expression.
                                eapply T_PostInc.
                                eapply T_Var with(x:="aLen").
                                simpl. try reflexivity. }
                              { eapply T_Skip. } } } }
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