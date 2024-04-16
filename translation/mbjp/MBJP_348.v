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
      { eapply T_ClassDecl with(name:="FindWays").
        { simpl. try reflexivity. }
        { eapply T_MethodDecl with(modif:="public static")(T:=TyInt)(m:="findWays").
          { simpl. try reflexivity. }
          { eapply T_Concat.
            { eapply T_DeclNoInit with(T:=TyInt)(x:="m").
              simpl. try reflexivity. }
            { eapply T_Skip. } }
          { simpl. try reflexivity. }
          { eapply T_Concat.
            { eapply T_Expression.
              eapply T_MethodInvocation with(m:="println").
              { eapply T_TyFieldAccess with(f:="out")(T:=(TyExternal "System")).
                { simpl. try reflexivity. }
                { simpl. try reflexivity. } }
              { simpl. try reflexivity. }
              { simpl. try reflexivity. }
              { eapply T_List.
                { eapply T_Add.
                  { eapply T_String with(s:="n = "). }
                  { eapply T_Var with(x:="m").
                    simpl. try reflexivity. }
                  { simpl. try reflexivity. } }
                { eapply T_Nil. } }
              { simpl. try reflexivity. } }
            { eapply T_Concat.
              { eapply T_If.
                { eapply T_Eq.
                  { eapply T_Var with(x:="m").
                    simpl. try reflexivity. }
                  { eapply T_Integer with(n:=4). }
                  { simpl. try reflexivity. } }
                { eapply T_Concat.
                  { eapply T_Return.
                    { eapply T_Integer with(n:=2). }
                    { simpl. try reflexivity. }
                    { simpl. try reflexivity. } }
                  { eapply T_Skip. } } }
              { eapply T_Concat.
                { eapply T_If.
                  { eapply T_Eq.
                    { eapply T_Var with(x:="m").
                      simpl. try reflexivity. }
                    { eapply T_Integer with(n:=6). }
                    { simpl. try reflexivity. } }
                  { eapply T_Concat.
                    { eapply T_Return.
                      { eapply T_Integer with(n:=5). }
                      { simpl. try reflexivity. }
                      { simpl. try reflexivity. } }
                    { eapply T_Skip. } } }
                { eapply T_Concat.
                  { eapply T_If.
                    { eapply T_Eq.
                      { eapply T_Var with(x:="m").
                        simpl. try reflexivity. }
                      { eapply T_Integer with(n:=8). }
                      { simpl. try reflexivity. } }
                    { eapply T_Concat.
                      { eapply T_Return.
                        { eapply T_Integer with(n:=14). }
                        { simpl. try reflexivity. }
                        { simpl. try reflexivity. } }
                      { eapply T_Skip. } } }
                  { eapply T_Concat.
                    { eapply T_If.
                      { eapply T_Eq.
                        { eapply T_Var with(x:="m").
                          simpl. try reflexivity. }
                        { eapply T_Integer with(n:=10). }
                        { simpl. try reflexivity. } }
                      { eapply T_Concat.
                        { eapply T_Return.
                          { eapply T_Integer with(n:=5). }
                          { simpl. try reflexivity. }
                          { simpl. try reflexivity. } }
                        { eapply T_Skip. } } }
                    { eapply T_Concat.
                      { eapply T_If.
                        { eapply T_Eq.
                          { eapply T_Var with(x:="m").
                            simpl. try reflexivity. }
                          { eapply T_Integer with(n:=12). }
                          { simpl. try reflexivity. } }
                        { eapply T_Concat.
                          { eapply T_Return.
                            { eapply T_Integer with(n:=41). }
                            { simpl. try reflexivity. }
                            { simpl. try reflexivity. } }
                          { eapply T_Skip. } } }
                      { eapply T_Concat.
                        { eapply T_Expression.
                          eapply T_MethodInvocation with(m:="println").
                          { eapply T_TyFieldAccess with(f:="out")(T:=(TyExternal "System")).
                            { simpl. try reflexivity. }
                            { simpl. try reflexivity. } }
                          { simpl. try reflexivity. }
                          { simpl. try reflexivity. }
                          { eapply T_List.
                            { eapply T_Add.
                              { eapply T_String with(s:="n = "). }
                              { eapply T_Var with(x:="m").
                                simpl. try reflexivity. }
                              { simpl. try reflexivity. } }
                            { eapply T_Nil. } }
                          { simpl. try reflexivity. } }
                        { eapply T_Concat.
                          { eapply T_Concat.
                            { eapply T_DeclInit with(T:=TyInt)(x:="r").
                              { simpl. try reflexivity. }
                              { eapply T_MethodInvocationNoObj with(m:="findWays").
                                { simpl. try reflexivity. }
                                { eapply T_List.
                                  { eapply T_Div.
                                    { eapply T_Sub.
                                      { eapply T_Var with(x:="m").
                                        simpl. try reflexivity. }
                                      { eapply T_Integer with(n:=2). }
                                      { simpl. try reflexivity. } }
                                    { eapply T_Integer with(n:=2). } }
                                  { eapply T_Nil. } }
                                { simpl. try reflexivity. } }
                              { simpl. try reflexivity. } }
                            { eapply T_Skip. } }
                          { eapply T_Concat.
                            { eapply T_If.
                              { eapply T_Eq.
                                { eapply T_Mod.
                                  { eapply T_Var with(x:="m").
                                    simpl. try reflexivity. }
                                  { eapply T_Integer with(n:=2). } }
                                { eapply T_Integer with(n:=0). }
                                { simpl. try reflexivity. } }
                              { eapply T_Concat.
                                { eapply T_Return.
                                  { eapply T_Var with(x:="r").
                                    simpl. try reflexivity. }
                                  { simpl. try reflexivity. }
                                  { simpl. try reflexivity. } }
                                { eapply T_Skip. } } }
                            { eapply T_Concat.
                              { eapply T_If.
                                { eapply T_Eq.
                                  { eapply T_Mod.
                                    { eapply T_Var with(x:="m").
                                      simpl. try reflexivity. }
                                    { eapply T_Integer with(n:=2). } }
                                  { eapply T_Integer with(n:=1). }
                                  { simpl. try reflexivity. } }
                                { eapply T_Concat.
                                  { eapply T_Return.
                                    { eapply T_Var with(x:="r").
                                      simpl. try reflexivity. }
                                    { simpl. try reflexivity. }
                                    { simpl. try reflexivity. } }
                                  { eapply T_Skip. } } }
                              { eapply T_Concat.
                                { eapply T_Return.
                                  { eapply T_Var with(x:="r").
                                    simpl. try reflexivity. }
                                  { simpl. try reflexivity. }
                                  { simpl. try reflexivity. } }
                                { eapply T_Skip. } } } } } } } } } } } } } } } } }
  Unshelve.
  all: apply STyVoid.
Defined.
Definition prog := the_exists_term (prog_well_typed).
Print prog.