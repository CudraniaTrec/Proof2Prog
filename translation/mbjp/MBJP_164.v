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
      { eapply T_ClassDecl with(name:="Areequivalent").
        { simpl. try reflexivity. }
        { eapply T_MethodDecl with(modif:="public static")(T:=TyBool)(m:="areequivalent").
          { simpl. try reflexivity. }
          { eapply T_Concat.
            { eapply T_DeclNoInit with(T:=TyInt)(x:="num1").
              simpl. try reflexivity. }
            { eapply T_Concat.
              { eapply T_DeclNoInit with(T:=TyInt)(x:="num2").
                simpl. try reflexivity. }
              { eapply T_Skip. } } }
          { simpl. try reflexivity. }
          { eapply T_Concat.
            { eapply T_Concat.
              { eapply T_DeclInit with(T:=TyBool)(x:="flag").
                { simpl. try reflexivity. }
                { eapply T_False. }
                { simpl. try reflexivity. } }
              { eapply T_Skip. } }
            { eapply T_Concat.
              { eapply T_Concat.
                { eapply T_DeclInit with(T:=TyInt)(x:="result").
                  { simpl. try reflexivity. }
                  { eapply T_BitAnd.
                    { eapply T_Var with(x:="num1").
                      simpl. try reflexivity. }
                    { eapply T_Var with(x:="num2").
                      simpl. try reflexivity. }
                    { simpl. try reflexivity. } }
                  { simpl. try reflexivity. } }
                { eapply T_Skip. } }
              { eapply T_Concat.
                { eapply T_While.
                  { eapply T_Ne.
                    { eapply T_Var with(x:="result").
                      simpl. try reflexivity. }
                    { eapply T_Integer with(n:=0). }
                    { simpl. try reflexivity. } }
                  { eapply T_Concat.
                    { eapply T_If.
                      { eapply T_Ne.
                        { eapply T_BitAnd.
                          { eapply T_Var with(x:="result").
                            simpl. try reflexivity. }
                          { eapply T_Integer with(n:=1). }
                          { simpl. try reflexivity. } }
                        { eapply T_Integer with(n:=0). }
                        { simpl. try reflexivity. } }
                      { eapply T_Concat.
                        { eapply T_If.
                          { eapply T_Ne.
                            { eapply T_Mod.
                              { eapply T_BitXor.
                                { eapply T_Var with(x:="num1").
                                  simpl. try reflexivity. }
                                { eapply T_Var with(x:="num2").
                                  simpl. try reflexivity. }
                                { simpl. try reflexivity. } }
                              { eapply T_Var with(x:="result").
                                simpl. try reflexivity. } }
                            { eapply T_Integer with(n:=0). }
                            { simpl. try reflexivity. } }
                          { eapply T_Concat.
                            { eapply T_Expression.
                              eapply T_Assign.
                              { eapply T_Var with(x:="flag").
                                simpl. try reflexivity. }
                              { eapply T_True. }
                              { simpl. try reflexivity. } }
                            { eapply T_Skip. } } }
                        { eapply T_Skip. } } }
                    { eapply T_Concat.
                      { eapply T_Expression.
                        eapply T_Assign.
                        { eapply T_Var with(x:="result").
                          simpl. try reflexivity. }
                        { eapply T_ShiftR.
                          { eapply T_Var with(x:="result").
                            simpl. try reflexivity. }
                          { eapply T_Integer with(n:=1). } }
                        { simpl. try reflexivity. } }
                      { eapply T_Skip. } } } }
                { eapply T_Concat.
                  { eapply T_Return.
                    { eapply T_Var with(x:="flag").
                      simpl. try reflexivity. }
                    { simpl. try reflexivity. }
                    { simpl. try reflexivity. } }
                  { eapply T_Skip. } } } } } } } } } }
  Unshelve.
  all: apply STyVoid.
Defined.
Definition prog := the_exists_term (prog_well_typed).
Print prog.