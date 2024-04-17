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
      { eapply T_ClassDecl with(name:="RemoveLowercase").
        { simpl. try reflexivity. }
        { eapply T_MethodDecl with(modif:="public static")(T:=TyString)(m:="removeLowercase").
          { simpl. try reflexivity. }
          { eapply T_Concat.
            { eapply T_DeclNoInit with(T:=TyString)(x:="str1").
              simpl. try reflexivity. }
            { eapply T_Skip. } }
          { simpl. try reflexivity. }
          { eapply T_Concat.
            { eapply T_Return.
              { eapply T_MethodInvocation with(m:="replaceAll").
                { eapply T_MethodInvocation with(m:="replaceAll").
                  { eapply T_MethodInvocation with(m:="replaceAll").
                    { eapply T_Var with(x:="str1").
                      simpl. try reflexivity. }
                    { simpl. try reflexivity. }
                    { simpl. try reflexivity. }
                    { eapply T_List.
                      { eapply T_String with(s:="\\A"). }
                      { eapply T_List.
                        { eapply T_String with(s:=""). }
                        { eapply T_Nil. } } }
                    { simpl. try reflexivity. } }
                  { simpl. try reflexivity. }
                  { simpl. try reflexivity. }
                  { eapply T_List.
                    { eapply T_String with(s:="\\Z"). }
                    { eapply T_List.
                      { eapply T_String with(s:=""). }
                      { eapply T_Nil. } } }
                  { simpl. try reflexivity. } }
                { simpl. try reflexivity. }
                { simpl. try reflexivity. }
                { eapply T_List.
                  { eapply T_String with(s:="[^A-Z0-9]"). }
                  { eapply T_List.
                    { eapply T_String with(s:=""). }
                    { eapply T_Nil. } } }
                { simpl. try reflexivity. } }
              { simpl. try reflexivity. }
              { simpl. try reflexivity. } }
            { eapply T_Skip. } } } } } } }
  Unshelve.
  all: apply STyVoid.
Defined.
Definition prog := the_exists_term (prog_well_typed).
Print prog.