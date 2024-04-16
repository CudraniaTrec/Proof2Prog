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
      { eapply T_ClassDecl with(name:="CheckEmail").
        { simpl. try reflexivity. }
        { eapply T_MethodDecl with(modif:="public static")(T:=TyString)(m:="checkEmail").
          { simpl. try reflexivity. }
          { eapply T_Concat.
            { eapply T_DeclNoInit with(T:=TyString)(x:="email").
              simpl. try reflexivity. }
            { eapply T_Skip. } }
          { simpl. try reflexivity. }
          { eapply T_Concat.
            { eapply T_IfElse.
              { eapply T_MethodInvocation with(m:="contains").
                { eapply T_Var with(x:="email").
                  simpl. try reflexivity. }
                { simpl. try reflexivity. }
                { simpl. try reflexivity. }
                { eapply T_List.
                  { eapply T_String with(s:="@"). }
                  { eapply T_Nil. } }
                { simpl. try reflexivity. } }
              { eapply T_Concat.
                { eapply T_Return.
                  { eapply T_String with(s:="Valid Email"). }
                  { simpl. try reflexivity. }
                  { simpl. try reflexivity. } }
                { eapply T_Skip. } }
              { eapply T_IfElse.
                { eapply T_Or.
                  { eapply T_MethodInvocation with(m:="contains").
                    { eapply T_Var with(x:="email").
                      simpl. try reflexivity. }
                    { simpl. try reflexivity. }
                    { simpl. try reflexivity. }
                    { eapply T_List.
                      { eapply T_String with(s:=" "). }
                      { eapply T_Nil. } }
                    { simpl. try reflexivity. } }
                  { eapply T_MethodInvocation with(m:="contains").
                    { eapply T_Var with(x:="email").
                      simpl. try reflexivity. }
                    { simpl. try reflexivity. }
                    { simpl. try reflexivity. }
                    { eapply T_List.
                      { eapply T_String with(s:="to@"). }
                      { eapply T_Nil. } }
                    { simpl. try reflexivity. } } }
                { eapply T_Concat.
                  { eapply T_Return.
                    { eapply T_String with(s:="Valid Email"). }
                    { simpl. try reflexivity. }
                    { simpl. try reflexivity. } }
                  { eapply T_Skip. } }
                { eapply T_Concat.
                  { eapply T_Return.
                    { eapply T_String with(s:="Invalid Email"). }
                    { simpl. try reflexivity. }
                    { simpl. try reflexivity. } }
                  { eapply T_Skip. } } } }
            { eapply T_Skip. } } } } } } }
  Unshelve.
  all: apply STyVoid.
Defined.
Definition prog := the_exists_term (prog_well_typed).
Print prog.