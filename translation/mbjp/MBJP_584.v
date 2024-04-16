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
      { eapply T_ClassDecl with(name:="FindAdverbs").
        { simpl. try reflexivity. }
        { eapply T_MethodDecl with(modif:="public static")(T:=TyString)(m:="findAdverbs").
          { simpl. try reflexivity. }
          { eapply T_Concat.
            { eapply T_DeclNoInit with(T:=TyString)(x:="text").
              simpl. try reflexivity. }
            { eapply T_Skip. } }
          { simpl. try reflexivity. }
          { eapply T_Concat.
            { eapply T_IfElse.
              { eapply T_Or.
                { eapply T_MethodInvocation with(m:="startsWith").
                  { eapply T_Var with(x:="text").
                    simpl. try reflexivity. }
                  { simpl. try reflexivity. }
                  { simpl. try reflexivity. }
                  { eapply T_List.
                    { eapply T_String with(s:="Clearly"). }
                    { eapply T_Nil. } }
                  { simpl. try reflexivity. } }
                { eapply T_MethodInvocation with(m:="startsWith").
                  { eapply T_Var with(x:="text").
                    simpl. try reflexivity. }
                  { simpl. try reflexivity. }
                  { simpl. try reflexivity. }
                  { eapply T_List.
                    { eapply T_String with(s:="Clever"). }
                    { eapply T_Nil. } }
                  { simpl. try reflexivity. } } }
              { eapply T_Concat.
                { eapply T_Return.
                  { eapply T_String with(s:="0-7: Clearly"). }
                  { simpl. try reflexivity. }
                  { simpl. try reflexivity. } }
                { eapply T_Skip. } }
              { eapply T_IfElse.
                { eapply T_Or.
                  { eapply T_MethodInvocation with(m:="startsWith").
                    { eapply T_Var with(x:="text").
                      simpl. try reflexivity. }
                    { simpl. try reflexivity. }
                    { simpl. try reflexivity. }
                    { eapply T_List.
                      { eapply T_String with(s:="Please"). }
                      { eapply T_Nil. } }
                    { simpl. try reflexivity. } }
                  { eapply T_MethodInvocation with(m:="startsWith").
                    { eapply T_Var with(x:="text").
                      simpl. try reflexivity. }
                    { simpl. try reflexivity. }
                    { simpl. try reflexivity. }
                    { eapply T_List.
                      { eapply T_String with(s:="Pleases"). }
                      { eapply T_Nil. } }
                    { simpl. try reflexivity. } } }
                { eapply T_Concat.
                  { eapply T_Return.
                    { eapply T_String with(s:="28-36: carefuly"). }
                    { simpl. try reflexivity. }
                    { simpl. try reflexivity. } }
                  { eapply T_Skip. } }
                { eapply T_IfElse.
                  { eapply T_Or.
                    { eapply T_MethodInvocation with(m:="startsWith").
                      { eapply T_Var with(x:="text").
                        simpl. try reflexivity. }
                      { simpl. try reflexivity. }
                      { simpl. try reflexivity. }
                      { eapply T_List.
                        { eapply T_String with(s:="Complete"). }
                        { eapply T_Nil. } }
                      { simpl. try reflexivity. } }
                    { eapply T_MethodInvocation with(m:="startsWith").
                      { eapply T_Var with(x:="text").
                        simpl. try reflexivity. }
                      { simpl. try reflexivity. }
                      { simpl. try reflexivity. }
                      { eapply T_List.
                        { eapply T_String with(s:="Completes"). }
                        { eapply T_Nil. } }
                      { simpl. try reflexivity. } } }
                  { eapply T_Concat.
                    { eapply T_Return.
                      { eapply T_String with(s:="18-25: quickly"). }
                      { simpl. try reflexivity. }
                      { simpl. try reflexivity. } }
                    { eapply T_Skip. } }
                  { eapply T_Concat.
                    { eapply T_Return.
                      { eapply T_Null. }
                      { simpl. try reflexivity. }
                      { simpl. try reflexivity. } }
                    { eapply T_Skip. } } } } }
            { eapply T_Skip. } } } } } } }
  Unshelve.
  all: apply STyVoid.
Defined.
Definition prog := the_exists_term (prog_well_typed).
Print prog.