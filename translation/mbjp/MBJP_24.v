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
      { eapply T_ClassDecl with(name:="BinaryToDecimal").
        { simpl. try reflexivity. }
        { eapply T_MethodDecl with(modif:="public static")(T:=TyInt)(m:="binaryToDecimal").
          { simpl. try reflexivity. }
          { eapply T_Concat.
            { eapply T_DeclNoInit with(T:=TyInt)(x:="binary").
              simpl. try reflexivity. }
            { eapply T_Skip. } }
          { simpl. try reflexivity. }
          { eapply T_Concat.
            { eapply T_Concat.
              { eapply T_DeclInit with(T:=TyInt)(x:="decimal").
                { simpl. try reflexivity. }
                { eapply T_Integer with(n:=0). }
                { simpl. try reflexivity. } }
              { eapply T_Concat.
                { eapply T_DeclInit with(T:=TyInt)(x:="j").
                  { simpl. try reflexivity. }
                  { eapply T_Integer with(n:=1). }
                  { simpl. try reflexivity. } }
                { eapply T_Skip. } } }
            { eapply T_Concat.
              { eapply T_While.
                { eapply T_Gt.
                  { eapply T_Var with(x:="binary").
                    simpl. try reflexivity. }
                  { eapply T_Integer with(n:=0). }
                  { simpl. try reflexivity. } }
                { eapply T_Concat.
                  { eapply T_Expression.
                    eapply T_Assign.
                    { eapply T_Var with(x:="decimal").
                      simpl. try reflexivity. }
                    { eapply T_Add.
                      { eapply T_Var with(x:="decimal").
                        simpl. try reflexivity. }
                      { eapply T_Mul.
                        { eapply T_Mod.
                          { eapply T_Var with(x:="binary").
                            simpl. try reflexivity. }
                          { eapply T_Integer with(n:=10). } }
                        { eapply T_Var with(x:="j").
                          simpl. try reflexivity. } }
                      { simpl. try reflexivity. } }
                    { simpl. try reflexivity. } }
                  { eapply T_Concat.
                    { eapply T_Expression.
                      eapply T_Assign.
                      { eapply T_Var with(x:="j").
                        simpl. try reflexivity. }
                      { eapply T_Mul.
                        { eapply T_Var with(x:="j").
                          simpl. try reflexivity. }
                        { eapply T_Integer with(n:=2). } }
                      { simpl. try reflexivity. } }
                    { eapply T_Concat.
                      { eapply T_Expression.
                        eapply T_Assign.
                        { eapply T_Var with(x:="binary").
                          simpl. try reflexivity. }
                        { eapply T_Div.
                          { eapply T_Var with(x:="binary").
                            simpl. try reflexivity. }
                          { eapply T_Integer with(n:=10). } }
                        { simpl. try reflexivity. } }
                      { eapply T_Skip. } } } } }
              { eapply T_Concat.
                { eapply T_Return.
                  { eapply T_Var with(x:="decimal").
                    simpl. try reflexivity. }
                  { simpl. try reflexivity. }
                  { simpl. try reflexivity. } }
                { eapply T_Skip. } } } } } } } } }
  Unshelve.
  all: apply STyVoid.
Defined.
Definition prog := the_exists_term (prog_well_typed).
Print prog.