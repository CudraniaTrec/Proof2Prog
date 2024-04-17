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
      { eapply T_ClassDecl with(name:="CheckIsosceles").
        { simpl. try reflexivity. }
        { eapply T_MethodDecl with(modif:="public static")(T:=TyBool)(m:="checkIsosceles").
          { simpl. try reflexivity. }
          { eapply T_Concat.
            { eapply T_DeclNoInit with(T:=TyInt)(x:="x").
              simpl. try reflexivity. }
            { eapply T_Concat.
              { eapply T_DeclNoInit with(T:=TyInt)(x:="y").
                simpl. try reflexivity. }
              { eapply T_Concat.
                { eapply T_DeclNoInit with(T:=TyInt)(x:="z").
                  simpl. try reflexivity. }
                { eapply T_Skip. } } } }
          { simpl. try reflexivity. }
          { eapply T_Concat.
            { eapply T_If.
              { eapply T_And.
                { eapply T_Eq.
                  { eapply T_Var with(x:="x").
                    simpl. try reflexivity. }
                  { eapply T_Var with(x:="y").
                    simpl. try reflexivity. }
                  { simpl. try reflexivity. } }
                { eapply T_Eq.
                  { eapply T_Var with(x:="z").
                    simpl. try reflexivity. }
                  { eapply T_Integer with(n:=12). }
                  { simpl. try reflexivity. } } }
              { eapply T_Concat.
                { eapply T_Return.
                  { eapply T_True. }
                  { simpl. try reflexivity. }
                  { simpl. try reflexivity. } }
                { eapply T_Skip. } } }
            { eapply T_Concat.
              { eapply T_If.
                { eapply T_And.
                  { eapply T_Lt.
                    { eapply T_Var with(x:="x").
                      simpl. try reflexivity. }
                    { eapply T_Var with(x:="z").
                      simpl. try reflexivity. }
                    { simpl. try reflexivity. } }
                  { eapply T_Lt.
                    { eapply T_Var with(x:="y").
                      simpl. try reflexivity. }
                    { eapply T_Var with(x:="z").
                      simpl. try reflexivity. }
                    { simpl. try reflexivity. } } }
                { eapply T_Concat.
                  { eapply T_Return.
                    { eapply T_False. }
                    { simpl. try reflexivity. }
                    { simpl. try reflexivity. } }
                  { eapply T_Skip. } } }
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
                    { eapply T_Var with(x:="z").
                      simpl. try reflexivity. }
                    { simpl. try reflexivity. } }
                  { eapply T_PostInc.
                    eapply T_Var with(x:="i").
                    simpl. try reflexivity. }
                  { eapply T_Concat.
                    { eapply T_If.
                      { eapply T_Eq.
                        { eapply T_Add.
                          { eapply T_Mul.
                            { eapply T_Var with(x:="x").
                              simpl. try reflexivity. }
                            { eapply T_Var with(x:="y").
                              simpl. try reflexivity. } }
                          { eapply T_Mul.
                            { eapply T_Var with(x:="y").
                              simpl. try reflexivity. }
                            { eapply T_Var with(x:="z").
                              simpl. try reflexivity. } }
                          { simpl. try reflexivity. } }
                        { eapply T_Div.
                          { eapply T_Div.
                            { eapply T_Mul.
                              { eapply T_Var with(x:="x").
                                simpl. try reflexivity. }
                              { eapply T_Var with(x:="z").
                                simpl. try reflexivity. } }
                            { eapply T_Integer with(n:=4). } }
                          { eapply T_Integer with(n:=4). } }
                        { simpl. try reflexivity. } }
                      { eapply T_Concat.
                        { eapply T_Return.
                          { eapply T_True. }
                          { simpl. try reflexivity. }
                          { simpl. try reflexivity. } }
                        { eapply T_Skip. } } }
                    { eapply T_Skip. } } }
                { eapply T_Concat.
                  { eapply T_Return.
                    { eapply T_False. }
                    { simpl. try reflexivity. }
                    { simpl. try reflexivity. } }
                  { eapply T_Skip. } } } } } } } } } }
  Unshelve.
  all: apply STyVoid.
Defined.
Definition prog := the_exists_term (prog_well_typed).
Print prog.