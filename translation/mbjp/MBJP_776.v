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
      { eapply T_ClassDecl with(name:="CountVowels").
        { simpl. try reflexivity. }
        { eapply T_MethodDecl with(modif:="public static")(T:=TyInt)(m:="countVowels").
          { simpl. try reflexivity. }
          { eapply T_Concat.
            { eapply T_DeclNoInit with(T:=TyString)(x:="testStr").
              simpl. try reflexivity. }
            { eapply T_Skip. } }
          { simpl. try reflexivity. }
          { eapply T_Concat.
            { eapply T_Concat.
              { eapply T_DeclInit with(T:=TyInt)(x:="res").
                { simpl. try reflexivity. }
                { eapply T_Integer with(n:=0). }
                { simpl. try reflexivity. } }
              { eapply T_Skip. } }
            { eapply T_Concat.
              { eapply T_Concat.
                { eapply T_DeclInit with(T:=(TyGeneric1 "List" TyChar))(x:="vow_list").
                  { simpl. try reflexivity. }
                  { eapply T_TyMethodInvocation with(m:="asList")(T:=(TyExternal "Arrays")).
                    { simpl. try reflexivity. }
                    { simpl. try reflexivity. }
                    { eapply T_List.
                      { eapply T_Char with(c:=97). }
                      { eapply T_List.
                        { eapply T_Char with(c:=101). }
                        { eapply T_List.
                          { eapply T_Char with(c:=105). }
                          { eapply T_List.
                            { eapply T_Char with(c:=111). }
                            { eapply T_List.
                              { eapply T_Char with(c:=117). }
                              { eapply T_Nil. } } } } } }
                    { simpl. try reflexivity. } }
                  { simpl. try reflexivity. } }
                { eapply T_Skip. } }
              { eapply T_Concat.
                { eapply T_For.
                  { eapply T_Concat.
                    { eapply T_DeclInit with(T:=TyInt)(x:="idx").
                      { simpl. try reflexivity. }
                      { eapply T_Integer with(n:=1). }
                      { simpl. try reflexivity. } }
                    { eapply T_Skip. } }
                  { eapply T_Lt.
                    { eapply T_Var with(x:="idx").
                      simpl. try reflexivity. }
                    { eapply T_Sub.
                      { eapply T_MethodInvocation with(m:="length").
                        { eapply T_Var with(x:="testStr").
                          simpl. try reflexivity. }
                        { simpl. try reflexivity. }
                        { simpl. try reflexivity. }
                        { eapply T_Nil. }
                        { simpl. try reflexivity. } }
                      { eapply T_Integer with(n:=1). }
                      { simpl. try reflexivity. } }
                    { simpl. try reflexivity. } }
                  { eapply T_PostInc.
                    eapply T_Var with(x:="idx").
                    simpl. try reflexivity. }
                  { eapply T_Concat.
                    { eapply T_If.
                      { eapply T_And.
                        { eapply T_Not.
                          eapply T_MethodInvocation with(m:="contains").
                          { eapply T_Var with(x:="vow_list").
                            simpl. try reflexivity. }
                          { simpl. try reflexivity. }
                          { simpl. try reflexivity. }
                          { eapply T_List.
                            { eapply T_MethodInvocation with(m:="charAt").
                              { eapply T_Var with(x:="testStr").
                                simpl. try reflexivity. }
                              { simpl. try reflexivity. }
                              { simpl. try reflexivity. }
                              { eapply T_List.
                                { eapply T_Var with(x:="idx").
                                  simpl. try reflexivity. }
                                { eapply T_Nil. } }
                              { simpl. try reflexivity. } }
                            { eapply T_Nil. } }
                          { simpl. try reflexivity. } }
                        { eapply T_Or.
                          { eapply T_MethodInvocation with(m:="contains").
                            { eapply T_Var with(x:="vow_list").
                              simpl. try reflexivity. }
                            { simpl. try reflexivity. }
                            { simpl. try reflexivity. }
                            { eapply T_List.
                              { eapply T_MethodInvocation with(m:="charAt").
                                { eapply T_Var with(x:="testStr").
                                  simpl. try reflexivity. }
                                { simpl. try reflexivity. }
                                { simpl. try reflexivity. }
                                { eapply T_List.
                                  { eapply T_Sub.
                                    { eapply T_Var with(x:="idx").
                                      simpl. try reflexivity. }
                                    { eapply T_Integer with(n:=1). }
                                    { simpl. try reflexivity. } }
                                  { eapply T_Nil. } }
                                { simpl. try reflexivity. } }
                              { eapply T_Nil. } }
                            { simpl. try reflexivity. } }
                          { eapply T_MethodInvocation with(m:="contains").
                            { eapply T_Var with(x:="vow_list").
                              simpl. try reflexivity. }
                            { simpl. try reflexivity. }
                            { simpl. try reflexivity. }
                            { eapply T_List.
                              { eapply T_MethodInvocation with(m:="charAt").
                                { eapply T_Var with(x:="testStr").
                                  simpl. try reflexivity. }
                                { simpl. try reflexivity. }
                                { simpl. try reflexivity. }
                                { eapply T_List.
                                  { eapply T_Add.
                                    { eapply T_Var with(x:="idx").
                                      simpl. try reflexivity. }
                                    { eapply T_Integer with(n:=1). }
                                    { simpl. try reflexivity. } }
                                  { eapply T_Nil. } }
                                { simpl. try reflexivity. } }
                              { eapply T_Nil. } }
                            { simpl. try reflexivity. } } } }
                      { eapply T_Expression.
                        eapply T_Assign.
                        { eapply T_Var with(x:="res").
                          simpl. try reflexivity. }
                        { eapply T_Add.
                          { eapply T_Var with(x:="res").
                            simpl. try reflexivity. }
                          { eapply T_Integer with(n:=1). }
                          { simpl. try reflexivity. } }
                        { simpl. try reflexivity. } } }
                    { eapply T_Skip. } } }
                { eapply T_Concat.
                  { eapply T_If.
                    { eapply T_And.
                      { eapply T_Not.
                        eapply T_MethodInvocation with(m:="contains").
                        { eapply T_Var with(x:="vow_list").
                          simpl. try reflexivity. }
                        { simpl. try reflexivity. }
                        { simpl. try reflexivity. }
                        { eapply T_List.
                          { eapply T_MethodInvocation with(m:="charAt").
                            { eapply T_Var with(x:="testStr").
                              simpl. try reflexivity. }
                            { simpl. try reflexivity. }
                            { simpl. try reflexivity. }
                            { eapply T_List.
                              { eapply T_Integer with(n:=0). }
                              { eapply T_Nil. } }
                            { simpl. try reflexivity. } }
                          { eapply T_Nil. } }
                        { simpl. try reflexivity. } }
                      { eapply T_MethodInvocation with(m:="contains").
                        { eapply T_Var with(x:="vow_list").
                          simpl. try reflexivity. }
                        { simpl. try reflexivity. }
                        { simpl. try reflexivity. }
                        { eapply T_List.
                          { eapply T_MethodInvocation with(m:="charAt").
                            { eapply T_Var with(x:="testStr").
                              simpl. try reflexivity. }
                            { simpl. try reflexivity. }
                            { simpl. try reflexivity. }
                            { eapply T_List.
                              { eapply T_Integer with(n:=1). }
                              { eapply T_Nil. } }
                            { simpl. try reflexivity. } }
                          { eapply T_Nil. } }
                        { simpl. try reflexivity. } } }
                    { eapply T_Expression.
                      eapply T_Assign.
                      { eapply T_Var with(x:="res").
                        simpl. try reflexivity. }
                      { eapply T_Add.
                        { eapply T_Var with(x:="res").
                          simpl. try reflexivity. }
                        { eapply T_Integer with(n:=1). }
                        { simpl. try reflexivity. } }
                      { simpl. try reflexivity. } } }
                  { eapply T_Concat.
                    { eapply T_If.
                      { eapply T_And.
                        { eapply T_Not.
                          eapply T_MethodInvocation with(m:="contains").
                          { eapply T_Var with(x:="vow_list").
                            simpl. try reflexivity. }
                          { simpl. try reflexivity. }
                          { simpl. try reflexivity. }
                          { eapply T_List.
                            { eapply T_MethodInvocation with(m:="charAt").
                              { eapply T_Var with(x:="testStr").
                                simpl. try reflexivity. }
                              { simpl. try reflexivity. }
                              { simpl. try reflexivity. }
                              { eapply T_List.
                                { eapply T_Sub.
                                  { eapply T_MethodInvocation with(m:="length").
                                    { eapply T_Var with(x:="testStr").
                                      simpl. try reflexivity. }
                                    { simpl. try reflexivity. }
                                    { simpl. try reflexivity. }
                                    { eapply T_Nil. }
                                    { simpl. try reflexivity. } }
                                  { eapply T_Integer with(n:=1). }
                                  { simpl. try reflexivity. } }
                                { eapply T_Nil. } }
                              { simpl. try reflexivity. } }
                            { eapply T_Nil. } }
                          { simpl. try reflexivity. } }
                        { eapply T_MethodInvocation with(m:="contains").
                          { eapply T_Var with(x:="vow_list").
                            simpl. try reflexivity. }
                          { simpl. try reflexivity. }
                          { simpl. try reflexivity. }
                          { eapply T_List.
                            { eapply T_MethodInvocation with(m:="charAt").
                              { eapply T_Var with(x:="testStr").
                                simpl. try reflexivity. }
                              { simpl. try reflexivity. }
                              { simpl. try reflexivity. }
                              { eapply T_List.
                                { eapply T_Sub.
                                  { eapply T_MethodInvocation with(m:="length").
                                    { eapply T_Var with(x:="testStr").
                                      simpl. try reflexivity. }
                                    { simpl. try reflexivity. }
                                    { simpl. try reflexivity. }
                                    { eapply T_Nil. }
                                    { simpl. try reflexivity. } }
                                  { eapply T_Integer with(n:=2). }
                                  { simpl. try reflexivity. } }
                                { eapply T_Nil. } }
                              { simpl. try reflexivity. } }
                            { eapply T_Nil. } }
                          { simpl. try reflexivity. } } }
                      { eapply T_Expression.
                        eapply T_Assign.
                        { eapply T_Var with(x:="res").
                          simpl. try reflexivity. }
                        { eapply T_Add.
                          { eapply T_Var with(x:="res").
                            simpl. try reflexivity. }
                          { eapply T_Integer with(n:=1). }
                          { simpl. try reflexivity. } }
                        { simpl. try reflexivity. } } }
                    { eapply T_Concat.
                      { eapply T_Return.
                        { eapply T_Var with(x:="res").
                          simpl. try reflexivity. }
                        { simpl. try reflexivity. }
                        { simpl. try reflexivity. } }
                      { eapply T_Skip. } } } } } } } } } } } }
  Unshelve.
  all: apply STyVoid.
Defined.
Definition prog := the_exists_term (prog_well_typed).
Print prog.