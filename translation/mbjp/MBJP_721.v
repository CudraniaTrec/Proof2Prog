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
      { eapply T_ClassDecl with(name:="Maxaverageofpath").
        { simpl. try reflexivity. }
        { eapply T_MethodDecl with(modif:="public static")(T:=TyDouble)(m:="maxaverageofpath").
          { simpl. try reflexivity. }
          { eapply T_Concat.
            { eapply T_DeclNoInit with(T:=(TyGeneric1 "List" (TyGeneric1 "List" TyInt)))(x:="cost").
              simpl. try reflexivity. }
            { eapply T_Concat.
              { eapply T_DeclNoInit with(T:=TyInt)(x:="n").
                simpl. try reflexivity. }
              { eapply T_Skip. } } }
          { simpl. try reflexivity. }
          { eapply T_Concat.
            { eapply T_Concat.
              { eapply T_DeclInit with(T:=TyInt)(x:="row").
                { simpl. try reflexivity. }
                { eapply T_MethodInvocation with(m:="size").
                  { eapply T_Var with(x:="cost").
                    simpl. try reflexivity. }
                  { simpl. try reflexivity. }
                  { simpl. try reflexivity. }
                  { eapply T_Nil. }
                  { simpl. try reflexivity. } }
                { simpl. try reflexivity. } }
              { eapply T_Skip. } }
            { eapply T_Concat.
              { eapply T_Concat.
                { eapply T_DeclInit with(T:=TyInt)(x:="col").
                  { simpl. try reflexivity. }
                  { eapply T_MethodInvocation with(m:="size").
                    { eapply T_MethodInvocation with(m:="get").
                      { eapply T_Var with(x:="cost").
                        simpl. try reflexivity. }
                      { simpl. try reflexivity. }
                      { simpl. try reflexivity. }
                      { eapply T_List.
                        { eapply T_Integer with(n:=0). }
                        { eapply T_Nil. } }
                      { simpl. try reflexivity. } }
                    { simpl. try reflexivity. }
                    { simpl. try reflexivity. }
                    { eapply T_Nil. }
                    { simpl. try reflexivity. } }
                  { simpl. try reflexivity. } }
                { eapply T_Skip. } }
              { eapply T_Concat.
                { eapply T_Concat.
                  { eapply T_DeclInit with(T:=(TyArray (TyArray TyDouble)))(x:="dp").
                    { simpl. try reflexivity. }
                    { eapply T_NewArrayNoInit' with(T:=TyDouble).
                      { eapply T_Add.
                        { eapply T_Var with(x:="row").
                          simpl. try reflexivity. }
                        { eapply T_Integer with(n:=1). }
                        { simpl. try reflexivity. } }
                      { eapply T_NewArrayNoInit' with(T:=TyDouble).
                        { eapply T_Add.
                          { eapply T_Var with(x:="col").
                            simpl. try reflexivity. }
                          { eapply T_Integer with(n:=1). }
                          { simpl. try reflexivity. } }
                        { eapply T_NewArrayNoInit with(T:=TyDouble). } } }
                    { simpl. try reflexivity. } }
                  { eapply T_Skip. } }
                { eapply T_Concat.
                  { eapply T_For.
                    { eapply T_Concat.
                      { eapply T_DeclInit with(T:=TyInt)(x:="i").
                        { simpl. try reflexivity. }
                        { eapply T_Integer with(n:=1). }
                        { simpl. try reflexivity. } }
                      { eapply T_Skip. } }
                    { eapply T_Le.
                      { eapply T_Var with(x:="i").
                        simpl. try reflexivity. }
                      { eapply T_Var with(x:="row").
                        simpl. try reflexivity. }
                      { simpl. try reflexivity. } }
                    { eapply T_PostInc.
                      eapply T_Var with(x:="i").
                      simpl. try reflexivity. }
                    { eapply T_Concat.
                      { eapply T_For.
                        { eapply T_Concat.
                          { eapply T_DeclInit with(T:=TyInt)(x:="j").
                            { simpl. try reflexivity. }
                            { eapply T_Integer with(n:=1). }
                            { simpl. try reflexivity. } }
                          { eapply T_Skip. } }
                        { eapply T_Le.
                          { eapply T_Var with(x:="j").
                            simpl. try reflexivity. }
                          { eapply T_Var with(x:="col").
                            simpl. try reflexivity. }
                          { simpl. try reflexivity. } }
                        { eapply T_PostInc.
                          eapply T_Var with(x:="j").
                          simpl. try reflexivity. }
                        { eapply T_Concat.
                          { eapply T_Expression.
                            eapply T_Assign.
                            { eapply T_ArrayAccess.
                              { eapply T_ArrayAccess.
                                { eapply T_Var with(x:="dp").
                                  simpl. try reflexivity. }
                                { eapply T_Var with(x:="i").
                                  simpl. try reflexivity. } }
                              { eapply T_Var with(x:="j").
                                simpl. try reflexivity. } }
                            { eapply T_Add.
                              { eapply T_MethodInvocation with(m:="get").
                                { eapply T_MethodInvocation with(m:="get").
                                  { eapply T_Var with(x:="cost").
                                    simpl. try reflexivity. }
                                  { simpl. try reflexivity. }
                                  { simpl. try reflexivity. }
                                  { eapply T_List.
                                    { eapply T_Sub.
                                      { eapply T_Var with(x:="i").
                                        simpl. try reflexivity. }
                                      { eapply T_Integer with(n:=1). }
                                      { simpl. try reflexivity. } }
                                    { eapply T_Nil. } }
                                  { simpl. try reflexivity. } }
                                { simpl. try reflexivity. }
                                { simpl. try reflexivity. }
                                { eapply T_List.
                                  { eapply T_Sub.
                                    { eapply T_Var with(x:="j").
                                      simpl. try reflexivity. }
                                    { eapply T_Integer with(n:=1). }
                                    { simpl. try reflexivity. } }
                                  { eapply T_Nil. } }
                                { simpl. try reflexivity. } }
                              { eapply T_TyMethodInvocation with(m:="max")(T:=(TyExternal "Math")).
                                { simpl. try reflexivity. }
                                { simpl. try reflexivity. }
                                { eapply T_List.
                                  { eapply T_ArrayAccess.
                                    { eapply T_ArrayAccess.
                                      { eapply T_Var with(x:="dp").
                                        simpl. try reflexivity. }
                                      { eapply T_Sub.
                                        { eapply T_Var with(x:="i").
                                          simpl. try reflexivity. }
                                        { eapply T_Integer with(n:=1). }
                                        { simpl. try reflexivity. } } }
                                    { eapply T_Var with(x:="j").
                                      simpl. try reflexivity. } }
                                  { eapply T_List.
                                    { eapply T_ArrayAccess.
                                      { eapply T_ArrayAccess.
                                        { eapply T_Var with(x:="dp").
                                          simpl. try reflexivity. }
                                        { eapply T_Var with(x:="i").
                                          simpl. try reflexivity. } }
                                      { eapply T_Sub.
                                        { eapply T_Var with(x:="j").
                                          simpl. try reflexivity. }
                                        { eapply T_Integer with(n:=1). }
                                        { simpl. try reflexivity. } } }
                                    { eapply T_Nil. } } }
                                { simpl. try reflexivity. } }
                              { simpl. try reflexivity. } }
                            { simpl. try reflexivity. } }
                          { eapply T_Skip. } } }
                      { eapply T_Skip. } } }
                  { eapply T_Concat.
                    { eapply T_Return.
                      { eapply T_Div.
                        { eapply T_ArrayAccess.
                          { eapply T_ArrayAccess.
                            { eapply T_Var with(x:="dp").
                              simpl. try reflexivity. }
                            { eapply T_Var with(x:="row").
                              simpl. try reflexivity. } }
                          { eapply T_Var with(x:="col").
                            simpl. try reflexivity. } }
                        { eapply T_Sub.
                          { eapply T_Mul.
                            { eapply T_Integer with(n:=2). }
                            { eapply T_Var with(x:="row").
                              simpl. try reflexivity. } }
                          { eapply T_Integer with(n:=1). }
                          { simpl. try reflexivity. } } }
                      { simpl. try reflexivity. }
                      { simpl. try reflexivity. } }
                    { eapply T_Skip. } } } } } } } } } } }
  Unshelve.
  all: apply STyVoid.
Defined.
Definition prog := the_exists_term (prog_well_typed).
Print prog.