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
      { eapply T_ClassDecl with(name:="TextMatchZeroOne").
        { simpl. try reflexivity. }
        { eapply T_MethodDecl with(modif:="public static")(T:=TyString)(m:="textMatchZeroOne").
          { simpl. try reflexivity. }
          { eapply T_Concat.
            { eapply T_DeclNoInit with(T:=TyString)(x:="text").
              simpl. try reflexivity. }
            { eapply T_Skip. } }
          { simpl. try reflexivity. }
          { eapply T_Concat.
            { eapply T_If.
              { eapply T_Eq.
                { eapply T_MethodInvocation with(m:="length").
                  { eapply T_Var with(x:="text").
                    simpl. try reflexivity. }
                  { simpl. try reflexivity. }
                  { simpl. try reflexivity. }
                  { eapply T_Nil. }
                  { simpl. try reflexivity. } }
                { eapply T_Integer with(n:=0). }
                { simpl. try reflexivity. } }
              { eapply T_Concat.
                { eapply T_Return.
                  { eapply T_Var with(x:="text").
                    simpl. try reflexivity. }
                  { simpl. try reflexivity. }
                  { simpl. try reflexivity. } }
                { eapply T_Skip. } } }
            { eapply T_Concat.
              { eapply T_If.
                { eapply T_Eq.
                  { eapply T_MethodInvocation with(m:="length").
                    { eapply T_Var with(x:="text").
                      simpl. try reflexivity. }
                    { simpl. try reflexivity. }
                    { simpl. try reflexivity. }
                    { eapply T_Nil. }
                    { simpl. try reflexivity. } }
                  { eapply T_Integer with(n:=1). }
                  { simpl. try reflexivity. } }
                { eapply T_Concat.
                  { eapply T_Return.
                    { eapply T_String with(s:="Found a match!"). }
                    { simpl. try reflexivity. }
                    { simpl. try reflexivity. } }
                  { eapply T_Skip. } } }
              { eapply T_Concat.
                { eapply T_Concat.
                  { eapply T_DeclInit with(T:=(TyExternal "StringBuilder"))(x:="result").
                    { simpl. try reflexivity. }
                    { eapply T_New' with(T:=(TyExternal "StringBuilder")).
                      { simpl. try reflexivity. }
                      { eapply T_Nil. } }
                    { simpl. try reflexivity. } }
                  { eapply T_Skip. } }
                { eapply T_Concat.
                  { eapply T_IfElse.
                    { eapply T_Eq.
                      { eapply T_MethodInvocation with(m:="charAt").
                        { eapply T_Var with(x:="text").
                          simpl. try reflexivity. }
                        { simpl. try reflexivity. }
                        { simpl. try reflexivity. }
                        { eapply T_List.
                          { eapply T_Integer with(n:=0). }
                          { eapply T_Nil. } }
                        { simpl. try reflexivity. } }
                      { eapply T_Char with(c:=97). }
                      { simpl. try reflexivity. } }
                    { eapply T_Concat.
                      { eapply T_Expression.
                        eapply T_MethodInvocation with(m:="append").
                        { eapply T_Var with(x:="result").
                          simpl. try reflexivity. }
                        { simpl. try reflexivity. }
                        { simpl. try reflexivity. }
                        { eapply T_List.
                          { eapply T_String with(s:="Found a match!"). }
                          { eapply T_Nil. } }
                        { simpl. try reflexivity. } }
                      { eapply T_Skip. } }
                    { eapply T_IfElse.
                      { eapply T_Eq.
                        { eapply T_MethodInvocation with(m:="charAt").
                          { eapply T_Var with(x:="text").
                            simpl. try reflexivity. }
                          { simpl. try reflexivity. }
                          { simpl. try reflexivity. }
                          { eapply T_List.
                            { eapply T_Integer with(n:=0). }
                            { eapply T_Nil. } }
                          { simpl. try reflexivity. } }
                        { eapply T_Char with(c:=98). }
                        { simpl. try reflexivity. } }
                      { eapply T_Concat.
                        { eapply T_Expression.
                          eapply T_MethodInvocation with(m:="append").
                          { eapply T_Var with(x:="result").
                            simpl. try reflexivity. }
                          { simpl. try reflexivity. }
                          { simpl. try reflexivity. }
                          { eapply T_List.
                            { eapply T_String with(s:="Found a match!"). }
                            { eapply T_Nil. } }
                          { simpl. try reflexivity. } }
                        { eapply T_Skip. } }
                      { eapply T_Concat.
                        { eapply T_Expression.
                          eapply T_MethodInvocation with(m:="append").
                          { eapply T_Var with(x:="result").
                            simpl. try reflexivity. }
                          { simpl. try reflexivity. }
                          { simpl. try reflexivity. }
                          { eapply T_List.
                            { eapply T_String with(s:="Not matched!"). }
                            { eapply T_Nil. } }
                          { simpl. try reflexivity. } }
                        { eapply T_Skip. } } } }
                  { eapply T_Concat.
                    { eapply T_Return.
                      { eapply T_MethodInvocation with(m:="toString").
                        { eapply T_Var with(x:="result").
                          simpl. try reflexivity. }
                        { simpl. try reflexivity. }
                        { simpl. try reflexivity. }
                        { eapply T_Nil. }
                        { simpl. try reflexivity. } }
                      { simpl. try reflexivity. }
                      { simpl. try reflexivity. } }
                    { eapply T_Skip. } } } } } } } } } } }
  Unshelve.
  all: apply STyVoid.
Defined.
Definition prog := the_exists_term (prog_well_typed).
Print prog.