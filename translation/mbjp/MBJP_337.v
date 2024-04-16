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
      { eapply T_ClassDecl with(name:="TextMatchWord").
        { simpl. try reflexivity. }
        { eapply T_MethodDecl with(modif:="public static")(T:=TyString)(m:="textMatchWord").
          { simpl. try reflexivity. }
          { eapply T_Concat.
            { eapply T_DeclNoInit with(T:=TyString)(x:="text").
              simpl. try reflexivity. }
            { eapply T_Skip. } }
          { simpl. try reflexivity. }
          { eapply T_Concat.
            { eapply T_If.
              { eapply T_MethodInvocation with(m:="isEmpty").
                { eapply T_Var with(x:="text").
                  simpl. try reflexivity. }
                { simpl. try reflexivity. }
                { simpl. try reflexivity. }
                { eapply T_Nil. }
                { simpl. try reflexivity. } }
              { eapply T_Concat.
                { eapply T_Return.
                  { eapply T_String with(s:="Not matched!"). }
                  { simpl. try reflexivity. }
                  { simpl. try reflexivity. } }
                { eapply T_Skip. } } }
            { eapply T_Concat.
              { eapply T_Concat.
                { eapply T_DeclInit with(T:=(TyArray TyString))(x:="words").
                  { simpl. try reflexivity. }
                  { eapply T_MethodInvocation with(m:="split").
                    { eapply T_Var with(x:="text").
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
                  { eapply T_DeclInit with(T:=(TyArray TyString))(x:="textWords").
                    { simpl. try reflexivity. }
                    { eapply T_MethodInvocation with(m:="split").
                      { eapply T_Var with(x:="text").
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
                    { eapply T_DeclInit with(T:=TyInt)(x:="i").
                      { simpl. try reflexivity. }
                      { eapply T_Integer with(n:=0). }
                      { simpl. try reflexivity. } }
                    { eapply T_Skip. } }
                  { eapply T_Concat.
                    { eapply T_Concat.
                      { eapply T_DeclInit with(T:=TyString)(x:="match").
                        { simpl. try reflexivity. }
                        { eapply T_String with(s:=""). }
                        { simpl. try reflexivity. } }
                      { eapply T_Skip. } }
                    { eapply T_Concat.
                      { eapply T_Foreach with(T:=TyString)(x:="word").
                        { simpl. try reflexivity. }
                        { eapply T_Var with(x:="words").
                          simpl. try reflexivity. }
                        { simpl. try reflexivity. }
                        { eapply T_Concat.
                          { eapply T_If.
                            { eapply T_MethodInvocation with(m:="isEmpty").
                              { eapply T_Var with(x:="word").
                                simpl. try reflexivity. }
                              { simpl. try reflexivity. }
                              { simpl. try reflexivity. }
                              { eapply T_Nil. }
                              { simpl. try reflexivity. } }
                            { eapply T_Concat.
                              { eapply T_Return.
                                { eapply T_String with(s:="Not matched!"). }
                                { simpl. try reflexivity. }
                                { simpl. try reflexivity. } }
                              { eapply T_Skip. } } }
                          { eapply T_Concat.
                            { eapply T_While.
                              { eapply T_Lt.
                                { eapply T_Var with(x:="i").
                                  simpl. try reflexivity. }
                                { eapply T_FieldAccess with(f:="length").
                                  { eapply T_Var with(x:="textWords").
                                    simpl. try reflexivity. }
                                  { simpl. try reflexivity. }
                                  { simpl. try reflexivity. } }
                                { simpl. try reflexivity. } }
                              { eapply T_Concat.
                                { eapply T_IfElse.
                                  { eapply T_MethodInvocation with(m:="equals").
                                    { eapply T_ArrayAccess.
                                      { eapply T_Var with(x:="textWords").
                                        simpl. try reflexivity. }
                                      { eapply T_Var with(x:="i").
                                        simpl. try reflexivity. } }
                                    { simpl. try reflexivity. }
                                    { simpl. try reflexivity. }
                                    { eapply T_List.
                                      { eapply T_Var with(x:="word").
                                        simpl. try reflexivity. }
                                      { eapply T_Nil. } }
                                    { simpl. try reflexivity. } }
                                  { eapply T_Concat.
                                    { eapply T_IfElse.
                                      { eapply T_MethodInvocation with(m:="isEmpty").
                                        { eapply T_Var with(x:="match").
                                          simpl. try reflexivity. }
                                        { simpl. try reflexivity. }
                                        { simpl. try reflexivity. }
                                        { eapply T_Nil. }
                                        { simpl. try reflexivity. } }
                                      { eapply T_Concat.
                                        { eapply T_Expression.
                                          eapply T_Assign.
                                          { eapply T_Var with(x:="match").
                                            simpl. try reflexivity. }
                                          { eapply T_ArrayAccess.
                                            { eapply T_Var with(x:="textWords").
                                              simpl. try reflexivity. }
                                            { eapply T_Var with(x:="i").
                                              simpl. try reflexivity. } }
                                          { simpl. try reflexivity. } }
                                        { eapply T_Skip. } }
                                      { eapply T_Concat.
                                        { eapply T_Return.
                                          { eapply T_String with(s:="Found a match!"). }
                                          { simpl. try reflexivity. }
                                          { simpl. try reflexivity. } }
                                        { eapply T_Skip. } } }
                                    { eapply T_Skip. } }
                                  { eapply T_Concat.
                                    { eapply T_Expression.
                                      eapply T_PostInc.
                                      eapply T_Var with(x:="i").
                                      simpl. try reflexivity. }
                                    { eapply T_Skip. } } }
                                { eapply T_Skip. } } }
                            { eapply T_Skip. } } } }
                      { eapply T_Concat.
                        { eapply T_Return.
                          { eapply T_Var with(x:="match").
                            simpl. try reflexivity. }
                          { simpl. try reflexivity. }
                          { simpl. try reflexivity. } }
                        { eapply T_Skip. } } } } } } } } } } } } }
  Unshelve.
  all: apply STyVoid.
Defined.
Definition prog := the_exists_term (prog_well_typed).
Print prog.