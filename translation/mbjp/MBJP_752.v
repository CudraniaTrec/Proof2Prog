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
      { eapply T_ClassDecl with(name:="JacobsthalNum").
        { simpl. try reflexivity. }
        { eapply T_MethodDecl with(modif:="public static")(T:=TyInt)(m:="jacobsthalNum").
          { simpl. try reflexivity. }
          { eapply T_Concat.
            { eapply T_DeclNoInit with(T:=TyInt)(x:="n").
              simpl. try reflexivity. }
            { eapply T_Skip. } }
          { simpl. try reflexivity. }
          { eapply T_Concat.
            { eapply T_Concat.
              { eapply T_DeclInit with(T:=TyInt)(x:="count").
                { simpl. try reflexivity. }
                { eapply T_Integer with(n:=1). }
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
                  { eapply T_For.
                    { eapply T_Concat.
                      { eapply T_DeclInit with(T:=TyInt)(x:="j").
                        { simpl. try reflexivity. }
                        { eapply T_Integer with(n:=1). }
                        { simpl. try reflexivity. } }
                      { eapply T_Skip. } }
                    { eapply T_Le.
                      { eapply T_Var with(x:="j").
                        simpl. try reflexivity. }
                      { eapply T_Var with(x:="n").
                        simpl. try reflexivity. }
                      { simpl. try reflexivity. } }
                    { eapply T_PostInc.
                      eapply T_Var with(x:="j").
                      simpl. try reflexivity. }
                    { eapply T_Concat.
                      { eapply T_For.
                        { eapply T_Concat.
                          { eapply T_DeclInit with(T:=TyInt)(x:="k").
                            { simpl. try reflexivity. }
                            { eapply T_Integer with(n:=1). }
                            { simpl. try reflexivity. } }
                          { eapply T_Skip. } }
                        { eapply T_Le.
                          { eapply T_Var with(x:="k").
                            simpl. try reflexivity. }
                          { eapply T_Var with(x:="n").
                            simpl. try reflexivity. }
                          { simpl. try reflexivity. } }
                        { eapply T_PostInc.
                          eapply T_Var with(x:="k").
                          simpl. try reflexivity. }
                        { eapply T_Concat.
                          { eapply T_For.
                            { eapply T_Concat.
                              { eapply T_DeclInit with(T:=TyInt)(x:="l").
                                { simpl. try reflexivity. }
                                { eapply T_Integer with(n:=1). }
                                { simpl. try reflexivity. } }
                              { eapply T_Skip. } }
                            { eapply T_Le.
                              { eapply T_Var with(x:="l").
                                simpl. try reflexivity. }
                              { eapply T_Var with(x:="n").
                                simpl. try reflexivity. }
                              { simpl. try reflexivity. } }
                            { eapply T_PostInc.
                              eapply T_Var with(x:="l").
                              simpl. try reflexivity. }
                            { eapply T_Concat.
                              { eapply T_For.
                                { eapply T_Concat.
                                  { eapply T_DeclInit with(T:=TyInt)(x:="m").
                                    { simpl. try reflexivity. }
                                    { eapply T_Integer with(n:=1). }
                                    { simpl. try reflexivity. } }
                                  { eapply T_Skip. } }
                                { eapply T_Le.
                                  { eapply T_Var with(x:="m").
                                    simpl. try reflexivity. }
                                  { eapply T_Var with(x:="n").
                                    simpl. try reflexivity. }
                                  { simpl. try reflexivity. } }
                                { eapply T_PostInc.
                                  eapply T_Var with(x:="m").
                                  simpl. try reflexivity. }
                                { eapply T_Concat.
                                  { eapply T_If.
                                    { eapply T_Eq.
                                      { eapply T_Add.
                                        { eapply T_Add.
                                          { eapply T_Mul.
                                            { eapply T_Var with(x:="i").
                                              simpl. try reflexivity. }
                                            { eapply T_Var with(x:="j").
                                              simpl. try reflexivity. } }
                                          { eapply T_Mul.
                                            { eapply T_Var with(x:="k").
                                              simpl. try reflexivity. }
                                            { eapply T_Var with(x:="l").
                                              simpl. try reflexivity. } }
                                          { simpl. try reflexivity. } }
                                        { eapply T_Mul.
                                          { eapply T_Var with(x:="l").
                                            simpl. try reflexivity. }
                                          { eapply T_Var with(x:="m").
                                            simpl. try reflexivity. } }
                                        { simpl. try reflexivity. } }
                                      { eapply T_Var with(x:="n").
                                        simpl. try reflexivity. }
                                      { simpl. try reflexivity. } }
                                    { eapply T_Concat.
                                      { eapply T_Expression.
                                        eapply T_PostInc.
                                        eapply T_Var with(x:="count").
                                        simpl. try reflexivity. }
                                      { eapply T_Skip. } } }
                                  { eapply T_Skip. } } }
                              { eapply T_Skip. } } }
                          { eapply T_Skip. } } }
                      { eapply T_Skip. } } }
                  { eapply T_Skip. } } }
              { eapply T_Concat.
                { eapply T_Return.
                  { eapply T_Var with(x:="count").
                    simpl. try reflexivity. }
                  { simpl. try reflexivity. }
                  { simpl. try reflexivity. } }
                { eapply T_Skip. } } } } } } } } }
  Unshelve.
  all: apply STyVoid.
Defined.
Definition prog := the_exists_term (prog_well_typed).
Print prog.