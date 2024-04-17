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
      { eapply T_ClassDecl with(name:="FindDiff").
        { simpl. try reflexivity. }
        { eapply T_MethodDecl with(modif:="public static")(T:=TyInt)(m:="findDiff").
          { simpl. try reflexivity. }
          { eapply T_Concat.
            { eapply T_DeclNoInit with(T:=(TyGeneric1 "List" TyInt))(x:="arr").
              simpl. try reflexivity. }
            { eapply T_Concat.
              { eapply T_DeclNoInit with(T:=TyInt)(x:="n").
                simpl. try reflexivity. }
              { eapply T_Skip. } } }
          { simpl. try reflexivity. }
          { eapply T_Concat.
            { eapply T_Concat.
              { eapply T_DeclInit with(T:=(TyGeneric2 "HashMap" TyInt TyInt))(x:="freq").
                { simpl. try reflexivity. }
                { eapply T_New' with(T:=(TyGeneric0 "HashMap")).
                  { simpl. try reflexivity. }
                  { eapply T_Nil. } }
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
                  { eapply T_MethodInvocation with(m:="size").
                    { eapply T_Var with(x:="arr").
                      simpl. try reflexivity. }
                    { simpl. try reflexivity. }
                    { simpl. try reflexivity. }
                    { eapply T_Nil. }
                    { simpl. try reflexivity. } }
                  { simpl. try reflexivity. } }
                { eapply T_PostInc.
                  eapply T_Var with(x:="i").
                  simpl. try reflexivity. }
                { eapply T_Concat.
                  { eapply T_Expression.
                    eapply T_MethodInvocation with(m:="put").
                    { eapply T_Var with(x:="freq").
                      simpl. try reflexivity. }
                    { simpl. try reflexivity. }
                    { simpl. try reflexivity. }
                    { eapply T_List.
                      { eapply T_MethodInvocation with(m:="get").
                        { eapply T_Var with(x:="arr").
                          simpl. try reflexivity. }
                        { simpl. try reflexivity. }
                        { simpl. try reflexivity. }
                        { eapply T_List.
                          { eapply T_Var with(x:="i").
                            simpl. try reflexivity. }
                          { eapply T_Nil. } }
                        { simpl. try reflexivity. } }
                      { eapply T_List.
                        { eapply T_Add.
                          { eapply T_MethodInvocation with(m:="getOrDefault").
                            { eapply T_Var with(x:="freq").
                              simpl. try reflexivity. }
                            { simpl. try reflexivity. }
                            { simpl. try reflexivity. }
                            { eapply T_List.
                              { eapply T_MethodInvocation with(m:="get").
                                { eapply T_Var with(x:="arr").
                                  simpl. try reflexivity. }
                                { simpl. try reflexivity. }
                                { simpl. try reflexivity. }
                                { eapply T_List.
                                  { eapply T_Var with(x:="i").
                                    simpl. try reflexivity. }
                                  { eapply T_Nil. } }
                                { simpl. try reflexivity. } }
                              { eapply T_List.
                                { eapply T_Integer with(n:=0). }
                                { eapply T_Nil. } } }
                            { simpl. try reflexivity. } }
                          { eapply T_Integer with(n:=1). }
                          { simpl. try reflexivity. } }
                        { eapply T_Nil. } } }
                    { simpl. try reflexivity. } }
                  { eapply T_Skip. } } }
              { eapply T_Concat.
                { eapply T_Concat.
                  { eapply T_DeclInit with(T:=TyInt)(x:="minFreq").
                    { simpl. try reflexivity. }
                    { eapply T_TyFieldAccess with(f:="MAX_VALUE")(T:=(TyExternal "Integer")).
                      { simpl. try reflexivity. }
                      { simpl. try reflexivity. } }
                    { simpl. try reflexivity. } }
                  { eapply T_Skip. } }
                { eapply T_Concat.
                  { eapply T_Concat.
                    { eapply T_DeclInit with(T:=TyInt)(x:="maxFreq").
                      { simpl. try reflexivity. }
                      { eapply T_TyFieldAccess with(f:="MIN_VALUE")(T:=(TyExternal "Integer")).
                        { simpl. try reflexivity. }
                        { simpl. try reflexivity. } }
                      { simpl. try reflexivity. } }
                    { eapply T_Skip. } }
                  { eapply T_Concat.
                    { eapply T_Foreach with(T:=(TyGeneric2 "Map.Entry" TyInt TyInt))(x:="entry").
                      { simpl. try reflexivity. }
                      { eapply T_MethodInvocation with(m:="entrySet").
                        { eapply T_Var with(x:="freq").
                          simpl. try reflexivity. }
                        { simpl. try reflexivity. }
                        { simpl. try reflexivity. }
                        { eapply T_Nil. }
                        { simpl. try reflexivity. } }
                      { simpl. try reflexivity. }
                      { eapply T_Concat.
                        { eapply T_If.
                          { eapply T_Gt.
                            { eapply T_MethodInvocation with(m:="getValue").
                              { eapply T_Var with(x:="entry").
                                simpl. try reflexivity. }
                              { simpl. try reflexivity. }
                              { simpl. try reflexivity. }
                              { eapply T_Nil. }
                              { simpl. try reflexivity. } }
                            { eapply T_Var with(x:="maxFreq").
                              simpl. try reflexivity. }
                            { simpl. try reflexivity. } }
                          { eapply T_Concat.
                            { eapply T_Expression.
                              eapply T_Assign.
                              { eapply T_Var with(x:="maxFreq").
                                simpl. try reflexivity. }
                              { eapply T_MethodInvocation with(m:="getValue").
                                { eapply T_Var with(x:="entry").
                                  simpl. try reflexivity. }
                                { simpl. try reflexivity. }
                                { simpl. try reflexivity. }
                                { eapply T_Nil. }
                                { simpl. try reflexivity. } }
                              { simpl. try reflexivity. } }
                            { eapply T_Skip. } } }
                        { eapply T_Concat.
                          { eapply T_If.
                            { eapply T_Lt.
                              { eapply T_MethodInvocation with(m:="getValue").
                                { eapply T_Var with(x:="entry").
                                  simpl. try reflexivity. }
                                { simpl. try reflexivity. }
                                { simpl. try reflexivity. }
                                { eapply T_Nil. }
                                { simpl. try reflexivity. } }
                              { eapply T_Var with(x:="minFreq").
                                simpl. try reflexivity. }
                              { simpl. try reflexivity. } }
                            { eapply T_Concat.
                              { eapply T_Expression.
                                eapply T_Assign.
                                { eapply T_Var with(x:="minFreq").
                                  simpl. try reflexivity. }
                                { eapply T_MethodInvocation with(m:="getValue").
                                  { eapply T_Var with(x:="entry").
                                    simpl. try reflexivity. }
                                  { simpl. try reflexivity. }
                                  { simpl. try reflexivity. }
                                  { eapply T_Nil. }
                                  { simpl. try reflexivity. } }
                                { simpl. try reflexivity. } }
                              { eapply T_Skip. } } }
                          { eapply T_Skip. } } } }
                    { eapply T_Concat.
                      { eapply T_Return.
                        { eapply T_Sub.
                          { eapply T_Var with(x:="maxFreq").
                            simpl. try reflexivity. }
                          { eapply T_Var with(x:="minFreq").
                            simpl. try reflexivity. }
                          { simpl. try reflexivity. } }
                        { simpl. try reflexivity. }
                        { simpl. try reflexivity. } }
                      { eapply T_Skip. } } } } } } } } } } } }
  Unshelve.
  all: apply STyVoid.
Defined.
Definition prog := the_exists_term (prog_well_typed).
Print prog.