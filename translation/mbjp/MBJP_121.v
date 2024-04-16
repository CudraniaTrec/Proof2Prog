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
      { eapply T_ClassDecl with(name:="CheckTriplet").
        { simpl. try reflexivity. }
        { eapply T_MethodDecl with(modif:="public static")(T:=TyBool)(m:="checkTriplet").
          { simpl. try reflexivity. }
          { eapply T_Concat.
            { eapply T_DeclNoInit with(T:=(TyGeneric1 "List" TyInt))(x:="a").
              simpl. try reflexivity. }
            { eapply T_Concat.
              { eapply T_DeclNoInit with(T:=TyInt)(x:="n").
                simpl. try reflexivity. }
              { eapply T_Concat.
                { eapply T_DeclNoInit with(T:=TyInt)(x:="sum").
                  simpl. try reflexivity. }
                { eapply T_Concat.
                  { eapply T_DeclNoInit with(T:=TyInt)(x:="count").
                    simpl. try reflexivity. }
                  { eapply T_Skip. } } } } }
          { simpl. try reflexivity. }
          { eapply T_Concat.
            { eapply T_Concat.
              { eapply T_DeclInit with(T:=TyBool)(x:="result").
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
                  { eapply T_Var with(x:="n").
                    simpl. try reflexivity. }
                  { simpl. try reflexivity. } }
                { eapply T_PostInc.
                  eapply T_Var with(x:="i").
                  simpl. try reflexivity. }
                { eapply T_Concat.
                  { eapply T_If.
                    { eapply T_MethodInvocation with(m:="equals").
                      { eapply T_MethodInvocation with(m:="get").
                        { eapply T_Var with(x:="a").
                          simpl. try reflexivity. }
                        { simpl. try reflexivity. }
                        { simpl. try reflexivity. }
                        { eapply T_List.
                          { eapply T_Var with(x:="i").
                            simpl. try reflexivity. }
                          { eapply T_Nil. } }
                        { simpl. try reflexivity. } }
                      { simpl. try reflexivity. }
                      { simpl. try reflexivity. }
                      { eapply T_List.
                        { eapply T_Var with(x:="sum").
                          simpl. try reflexivity. }
                        { eapply T_Nil. } }
                      { simpl. try reflexivity. } }
                    { eapply T_Concat.
                      { eapply T_Expression.
                        eapply T_Assign.
                        { eapply T_Var with(x:="result").
                          simpl. try reflexivity. }
                        { eapply T_False. }
                        { simpl. try reflexivity. } }
                      { eapply T_Concat.
                        { eapply T_Break. }
                        { eapply T_Skip. } } } }
                  { eapply T_Skip. } } }
              { eapply T_Concat.
                { eapply T_Return.
                  { eapply T_Var with(x:="result").
                    simpl. try reflexivity. }
                  { simpl. try reflexivity. }
                  { simpl. try reflexivity. } }
                { eapply T_Skip. } } } } } } } } }
  Unshelve.
  all: apply STyVoid.
Defined.
Definition prog := the_exists_term (prog_well_typed).
Print prog.