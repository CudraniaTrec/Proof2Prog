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
      { eapply T_ClassDecl with(name:="CheckMonthnum").
        { simpl. try reflexivity. }
        { eapply T_MethodDecl with(modif:="public static")(T:=TyBool)(m:="checkMonthnum").
          { simpl. try reflexivity. }
          { eapply T_Concat.
            { eapply T_DeclNoInit with(T:=TyString)(x:="monthname1").
              simpl. try reflexivity. }
            { eapply T_Skip. } }
          { simpl. try reflexivity. }
          { eapply T_Concat.
            { eapply T_Concat.
              { eapply T_DeclInit with(T:=(TyArray TyString))(x:="month").
                { simpl. try reflexivity. }
                { eapply T_MethodInvocation with(m:="split").
                  { eapply T_Var with(x:="monthname1").
                    simpl. try reflexivity. }
                  { simpl. try reflexivity. }
                  { simpl. try reflexivity. }
                  { eapply T_List.
                    { eapply T_String with(s:=" "). }
                    { eapply T_Nil. } }
                  { simpl. try reflexivity. } }
                { simpl. try reflexivity. } }
              { eapply T_Skip. } }
            { eapply T_Concat.
              { eapply T_Concat.
                { eapply T_DeclInit with(T:=TyBool)(x:="isAfter30").
                  { simpl. try reflexivity. }
                  { eapply T_False. }
                  { simpl. try reflexivity. } }
                { eapply T_Skip. } }
              { eapply T_Concat.
                { eapply T_Foreach with(T:=TyString)(x:="monthnum").
                  { simpl. try reflexivity. }
                  { eapply T_Var with(x:="month").
                    simpl. try reflexivity. }
                  { simpl. try reflexivity. }
                  { eapply T_Concat.
                    { eapply T_IfElse.
                      { eapply T_MethodInvocation with(m:="equals").
                        { eapply T_Var with(x:="monthnum").
                          simpl. try reflexivity. }
                        { simpl. try reflexivity. }
                        { simpl. try reflexivity. }
                        { eapply T_List.
                          { eapply T_String with(s:="February"). }
                          { eapply T_Nil. } }
                        { simpl. try reflexivity. } }
                      { eapply T_Concat.
                        { eapply T_Expression.
                          eapply T_Assign.
                          { eapply T_Var with(x:="isAfter30").
                            simpl. try reflexivity. }
                          { eapply T_True. }
                          { simpl. try reflexivity. } }
                        { eapply T_Skip. } }
                      { eapply T_If.
                        { eapply T_MethodInvocation with(m:="equals").
                          { eapply T_Var with(x:="monthnum").
                            simpl. try reflexivity. }
                          { simpl. try reflexivity. }
                          { simpl. try reflexivity. }
                          { eapply T_List.
                            { eapply T_String with(s:="January"). }
                            { eapply T_Nil. } }
                          { simpl. try reflexivity. } }
                        { eapply T_Concat.
                          { eapply T_Expression.
                            eapply T_Assign.
                            { eapply T_Var with(x:="isAfter30").
                              simpl. try reflexivity. }
                            { eapply T_False. }
                            { simpl. try reflexivity. } }
                          { eapply T_Skip. } } } }
                    { eapply T_Skip. } } }
                { eapply T_Concat.
                  { eapply T_Return.
                    { eapply T_Var with(x:="isAfter30").
                      simpl. try reflexivity. }
                    { simpl. try reflexivity. }
                    { simpl. try reflexivity. } }
                  { eapply T_Skip. } } } } } } } } } }
  Unshelve.
  all: apply STyVoid.
Defined.
Definition prog := the_exists_term (prog_well_typed).
Print prog.