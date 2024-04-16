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
      { eapply T_ClassDecl with(name:="LengthOfLastWord").
        { simpl. try reflexivity. }
        { eapply T_MethodDecl with(modif:="public static")(T:=TyInt)(m:="lengthOfLastWord").
          { simpl. try reflexivity. }
          { eapply T_Concat.
            { eapply T_DeclNoInit with(T:=TyString)(x:="a").
              simpl. try reflexivity. }
            { eapply T_Skip. } }
          { simpl. try reflexivity. }
          { eapply T_Concat.
            { eapply T_Concat.
              { eapply T_DeclInit with(T:=(TyArray TyString))(x:="words").
                { simpl. try reflexivity. }
                { eapply T_MethodInvocation with(m:="split").
                  { eapply T_Var with(x:="a").
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
              { eapply T_Return.
                { eapply T_Choose.
                  { eapply T_Gt.
                    { eapply T_FieldAccess with(f:="length").
                      { eapply T_Var with(x:="words").
                        simpl. try reflexivity. }
                      { simpl. try reflexivity. }
                      { simpl. try reflexivity. } }
                    { eapply T_Integer with(n:=0). }
                    { simpl. try reflexivity. } }
                  { eapply T_MethodInvocation with(m:="length").
                    { eapply T_ArrayAccess.
                      { eapply T_Var with(x:="words").
                        simpl. try reflexivity. }
                      { eapply T_Sub.
                        { eapply T_FieldAccess with(f:="length").
                          { eapply T_Var with(x:="words").
                            simpl. try reflexivity. }
                          { simpl. try reflexivity. }
                          { simpl. try reflexivity. } }
                        { eapply T_Integer with(n:=1). }
                        { simpl. try reflexivity. } } }
                    { simpl. try reflexivity. }
                    { simpl. try reflexivity. }
                    { eapply T_Nil. }
                    { simpl. try reflexivity. } }
                  { eapply T_Integer with(n:=0). }
                  { simpl. try reflexivity. } }
                { simpl. try reflexivity. }
                { simpl. try reflexivity. } }
              { eapply T_Skip. } } } } } } } }
  Unshelve.
  all: apply STyVoid.
Defined.
Definition prog := the_exists_term (prog_well_typed).
Print prog.