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
      { eapply T_ClassDecl with(name:="WordsAe").
        { simpl. try reflexivity. }
        { eapply T_MethodDecl with(modif:="public static")(T:=(TyGeneric1 "List" TyString))(m:="wordsAe").
          { simpl. try reflexivity. }
          { eapply T_Concat.
            { eapply T_DeclNoInit with(T:=TyString)(x:="text").
              simpl. try reflexivity. }
            { eapply T_Skip. } }
          { simpl. try reflexivity. }
          { eapply T_Concat.
            { eapply T_Concat.
              { eapply T_DeclInit with(T:=(TyGeneric1 "List" TyString))(x:="res").
                { simpl. try reflexivity. }
                { eapply T_New' with(T:=(TyGeneric0 "ArrayList")).
                  { simpl. try reflexivity. }
                  { eapply T_Nil. } }
                { simpl. try reflexivity. } }
              { eapply T_Skip. } }
            { eapply T_Concat.
              { eapply T_Concat.
                { eapply T_DeclInit with(T:=TyInt)(x:="len").
                  { simpl. try reflexivity. }
                  { eapply T_MethodInvocation with(m:="length").
                    { eapply T_Var with(x:="text").
                      simpl. try reflexivity. }
                    { simpl. try reflexivity. }
                    { simpl. try reflexivity. }
                    { eapply T_Nil. }
                    { simpl. try reflexivity. } }
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
                    { eapply T_Var with(x:="len").
                      simpl. try reflexivity. }
                    { simpl. try reflexivity. } }
                  { eapply T_PostInc.
                    eapply T_Var with(x:="i").
                    simpl. try reflexivity. }
                  { eapply T_Concat.
                    { eapply T_If.
                      { eapply T_Or.
                        { eapply T_Eq.
                          { eapply T_MethodInvocation with(m:="charAt").
                            { eapply T_Var with(x:="text").
                              simpl. try reflexivity. }
                            { simpl. try reflexivity. }
                            { simpl. try reflexivity. }
                            { eapply T_List.
                              { eapply T_Var with(x:="i").
                                simpl. try reflexivity. }
                              { eapply T_Nil. } }
                            { simpl. try reflexivity. } }
                          { eapply T_Char with(c:=97). }
                          { simpl. try reflexivity. } }
                        { eapply T_Eq.
                          { eapply T_MethodInvocation with(m:="charAt").
                            { eapply T_Var with(x:="text").
                              simpl. try reflexivity. }
                            { simpl. try reflexivity. }
                            { simpl. try reflexivity. }
                            { eapply T_List.
                              { eapply T_Var with(x:="i").
                                simpl. try reflexivity. }
                              { eapply T_Nil. } }
                            { simpl. try reflexivity. } }
                          { eapply T_Char with(c:=101). }
                          { simpl. try reflexivity. } } }
                      { eapply T_Concat.
                        { eapply T_Concat.
                          { eapply T_DeclInit with(T:=TyString)(x:="substr").
                            { simpl. try reflexivity. }
                            { eapply T_MethodInvocation with(m:="substring").
                              { eapply T_Var with(x:="text").
                                simpl. try reflexivity. }
                              { simpl. try reflexivity. }
                              { simpl. try reflexivity. }
                              { eapply T_List.
                                { eapply T_Var with(x:="i").
                                  simpl. try reflexivity. }
                                { eapply T_List.
                                  { eapply T_Add.
                                    { eapply T_Var with(x:="i").
                                      simpl. try reflexivity. }
                                    { eapply T_Integer with(n:=2). }
                                    { simpl. try reflexivity. } }
                                  { eapply T_Nil. } } }
                              { simpl. try reflexivity. } }
                            { simpl. try reflexivity. } }
                          { eapply T_Skip. } }
                        { eapply T_Concat.
                          { eapply T_Concat.
                            { eapply T_DeclInit with(T:=TyInt)(x:="j").
                              { simpl. try reflexivity. }
                              { eapply T_Add.
                                { eapply T_Var with(x:="i").
                                  simpl. try reflexivity. }
                                { eapply T_Integer with(n:=2). }
                                { simpl. try reflexivity. } }
                              { simpl. try reflexivity. } }
                            { eapply T_Skip. } }
                          { eapply T_Concat.
                            { eapply T_While.
                              { eapply T_And.
                                { eapply T_Lt.
                                  { eapply T_Var with(x:="j").
                                    simpl. try reflexivity. }
                                  { eapply T_Var with(x:="len").
                                    simpl. try reflexivity. }
                                  { simpl. try reflexivity. } }
                                { eapply T_Ne.
                                  { eapply T_MethodInvocation with(m:="charAt").
                                    { eapply T_Var with(x:="text").
                                      simpl. try reflexivity. }
                                    { simpl. try reflexivity. }
                                    { simpl. try reflexivity. }
                                    { eapply T_List.
                                      { eapply T_Var with(x:="j").
                                        simpl. try reflexivity. }
                                      { eapply T_Nil. } }
                                    { simpl. try reflexivity. } }
                                  { eapply T_Char with(c:=32). }
                                  { simpl. try reflexivity. } } }
                              { eapply T_Concat.
                                { eapply T_Expression.
                                  eapply T_Assign.
                                  { eapply T_Var with(x:="substr").
                                    simpl. try reflexivity. }
                                  { eapply T_Add.
                                    { eapply T_Var with(x:="substr").
                                      simpl. try reflexivity. }
                                    { eapply T_MethodInvocation with(m:="charAt").
                                      { eapply T_Var with(x:="text").
                                        simpl. try reflexivity. }
                                      { simpl. try reflexivity. }
                                      { simpl. try reflexivity. }
                                      { eapply T_List.
                                        { eapply T_Var with(x:="j").
                                          simpl. try reflexivity. }
                                        { eapply T_Nil. } }
                                      { simpl. try reflexivity. } }
                                    { simpl. try reflexivity. } }
                                  { simpl. try reflexivity. } }
                                { eapply T_Concat.
                                  { eapply T_Expression.
                                    eapply T_PostInc.
                                    eapply T_Var with(x:="j").
                                    simpl. try reflexivity. }
                                  { eapply T_Skip. } } } }
                            { eapply T_Concat.
                              { eapply T_If.
                                { eapply T_Gt.
                                  { eapply T_Sub.
                                    { eapply T_Var with(x:="j").
                                      simpl. try reflexivity. }
                                    { eapply T_Var with(x:="i").
                                      simpl. try reflexivity. }
                                    { simpl. try reflexivity. } }
                                  { eapply T_Integer with(n:=1). }
                                  { simpl. try reflexivity. } }
                                { eapply T_Concat.
                                  { eapply T_Expression.
                                    eapply T_MethodInvocation with(m:="add").
                                    { eapply T_Var with(x:="res").
                                      simpl. try reflexivity. }
                                    { simpl. try reflexivity. }
                                    { simpl. try reflexivity. }
                                    { eapply T_List.
                                      { eapply T_Var with(x:="substr").
                                        simpl. try reflexivity. }
                                      { eapply T_Nil. } }
                                    { simpl. try reflexivity. } }
                                  { eapply T_Skip. } } }
                              { eapply T_Concat.
                                { eapply T_Expression.
                                  eapply T_Assign.
                                  { eapply T_Var with(x:="i").
                                    simpl. try reflexivity. }
                                  { eapply T_Var with(x:="j").
                                    simpl. try reflexivity. }
                                  { simpl. try reflexivity. } }
                                { eapply T_Skip. } } } } } } }
                    { eapply T_Skip. } } }
                { eapply T_Concat.
                  { eapply T_Return.
                    { eapply T_Var with(x:="res").
                      simpl. try reflexivity. }
                    { simpl. try reflexivity. }
                    { simpl. try reflexivity. } }
                  { eapply T_Skip. } } } } } } } } } }
  Unshelve.
  all: apply STyVoid.
Defined.
Definition prog := the_exists_term (prog_well_typed).
Print prog.