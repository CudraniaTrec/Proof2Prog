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
      { eapply T_ClassDecl with(name:="RemoveMultipleSpaces").
        { simpl. try reflexivity. }
        { eapply T_MethodDecl with(modif:="public static")(T:=TyString)(m:="removeMultipleSpaces").
          { simpl. try reflexivity. }
          { eapply T_Concat.
            { eapply T_DeclNoInit with(T:=TyString)(x:="text1").
              simpl. try reflexivity. }
            { eapply T_Skip. } }
          { simpl. try reflexivity. }
          { eapply T_Concat.
            { eapply T_Concat.
              { eapply T_DeclInit with(T:=(TyExternal "StringTokenizer"))(x:="st1").
                { simpl. try reflexivity. }
                { eapply T_New' with(T:=(TyExternal "StringTokenizer")).
                  { simpl. try reflexivity. }
                  { eapply T_List.
                    { eapply T_Var with(x:="text1").
                      simpl. try reflexivity. }
                    { eapply T_List.
                      { eapply T_String with(s:=" "). }
                      { eapply T_Nil. } } } }
                { simpl. try reflexivity. } }
              { eapply T_Skip. } }
            { eapply T_Concat.
              { eapply T_Concat.
                { eapply T_DeclInit with(T:=TyString)(x:="result").
                  { simpl. try reflexivity. }
                  { eapply T_String with(s:=""). }
                  { simpl. try reflexivity. } }
                { eapply T_Skip. } }
              { eapply T_Concat.
                { eapply T_While.
                  { eapply T_MethodInvocation with(m:="hasMoreTokens").
                    { eapply T_Var with(x:="st1").
                      simpl. try reflexivity. }
                    { simpl. try reflexivity. }
                    { simpl. try reflexivity. }
                    { eapply T_Nil. }
                    { simpl. try reflexivity. } }
                  { eapply T_Concat.
                    { eapply T_Concat.
                      { eapply T_DeclInit with(T:=(TyExternal "StringTokenizer"))(x:="st2").
                        { simpl. try reflexivity. }
                        { eapply T_New' with(T:=(TyExternal "StringTokenizer")).
                          { simpl. try reflexivity. }
                          { eapply T_List.
                            { eapply T_MethodInvocation with(m:="nextToken").
                              { eapply T_Var with(x:="st1").
                                simpl. try reflexivity. }
                              { simpl. try reflexivity. }
                              { simpl. try reflexivity. }
                              { eapply T_Nil. }
                              { simpl. try reflexivity. } }
                            { eapply T_List.
                              { eapply T_String with(s:=" "). }
                              { eapply T_Nil. } } } }
                        { simpl. try reflexivity. } }
                      { eapply T_Skip. } }
                    { eapply T_Concat.
                      { eapply T_Expression.
                        eapply T_Assign.
                        { eapply T_Var with(x:="result").
                          simpl. try reflexivity. }
                        { eapply T_Add.
                          { eapply T_Var with(x:="result").
                            simpl. try reflexivity. }
                          { eapply T_Add.
                            { eapply T_MethodInvocation with(m:="nextToken").
                              { eapply T_Var with(x:="st2").
                                simpl. try reflexivity. }
                              { simpl. try reflexivity. }
                              { simpl. try reflexivity. }
                              { eapply T_Nil. }
                              { simpl. try reflexivity. } }
                            { eapply T_String with(s:=" "). }
                            { simpl. try reflexivity. } }
                          { simpl. try reflexivity. } }
                        { simpl. try reflexivity. } }
                      { eapply T_Skip. } } } }
                { eapply T_Concat.
                  { eapply T_Return.
                    { eapply T_MethodInvocation with(m:="trim").
                      { eapply T_Var with(x:="result").
                        simpl. try reflexivity. }
                      { simpl. try reflexivity. }
                      { simpl. try reflexivity. }
                      { eapply T_Nil. }
                      { simpl. try reflexivity. } }
                    { simpl. try reflexivity. }
                    { simpl. try reflexivity. } }
                  { eapply T_Skip. } } } } } } } } } }
  Unshelve.
  all: apply STyVoid.
Defined.
Definition prog := the_exists_term (prog_well_typed).
Print prog.