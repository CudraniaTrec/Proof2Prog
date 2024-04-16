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
      { eapply T_ClassDecl with(name:="FloatToTuple").
        { simpl. try reflexivity. }
        { eapply T_MethodDecl with(modif:="public static")(T:=(TyGeneric1 "List" TyDouble))(m:="floatToTuple").
          { simpl. try reflexivity. }
          { eapply T_Concat.
            { eapply T_DeclNoInit with(T:=TyString)(x:="testStr").
              simpl. try reflexivity. }
            { eapply T_Skip. } }
          { simpl. try reflexivity. }
          { eapply T_Concat.
            { eapply T_Concat.
              { eapply T_DeclInit with(T:=(TyArray TyString))(x:="tokens").
                { simpl. try reflexivity. }
                { eapply T_MethodInvocation with(m:="split").
                  { eapply T_Var with(x:="testStr").
                    simpl. try reflexivity. }
                  { simpl. try reflexivity. }
                  { simpl. try reflexivity. }
                  { eapply T_List.
                    { eapply T_String with(s:=","). }
                    { eapply T_Nil. } }
                  { simpl. try reflexivity. } }
                { simpl. try reflexivity. } }
              { eapply T_Skip. } }
            { eapply T_Concat.
              { eapply T_Concat.
                { eapply T_DeclInit with(T:=(TyGeneric1 "List" TyDouble))(x:="list").
                  { simpl. try reflexivity. }
                  { eapply T_New' with(T:=(TyGeneric0 "ArrayList")).
                    { simpl. try reflexivity. }
                    { eapply T_Nil. } }
                  { simpl. try reflexivity. } }
                { eapply T_Skip. } }
              { eapply T_Concat.
                { eapply T_Foreach with(T:=TyString)(x:="token").
                  { simpl. try reflexivity. }
                  { eapply T_Var with(x:="tokens").
                    simpl. try reflexivity. }
                  { simpl. try reflexivity. }
                  { eapply T_Concat.
                    { eapply T_Concat.
                      { eapply T_DeclInit with(T:=(TyArray TyString))(x:="tuple").
                        { simpl. try reflexivity. }
                        { eapply T_MethodInvocation with(m:="split").
                          { eapply T_MethodInvocation with(m:="trim").
                            { eapply T_Var with(x:="token").
                              simpl. try reflexivity. }
                            { simpl. try reflexivity. }
                            { simpl. try reflexivity. }
                            { eapply T_Nil. }
                            { simpl. try reflexivity. } }
                          { simpl. try reflexivity. }
                          { simpl. try reflexivity. }
                          { eapply T_List.
                            { eapply T_String with(s:=","). }
                            { eapply T_Nil. } }
                          { simpl. try reflexivity. } }
                        { simpl. try reflexivity. } }
                      { eapply T_Skip. } }
                    { eapply T_Concat.
                      { eapply T_IfElse.
                        { eapply T_Eq.
                          { eapply T_FieldAccess with(f:="length").
                            { eapply T_Var with(x:="tuple").
                              simpl. try reflexivity. }
                            { simpl. try reflexivity. }
                            { simpl. try reflexivity. } }
                          { eapply T_Integer with(n:=2). }
                          { simpl. try reflexivity. } }
                        { eapply T_Concat.
                          { eapply T_Expression.
                            eapply T_MethodInvocation with(m:="add").
                            { eapply T_Var with(x:="list").
                              simpl. try reflexivity. }
                            { simpl. try reflexivity. }
                            { simpl. try reflexivity. }
                            { eapply T_List.
                              { eapply T_TyMethodInvocation with(m:="parseDouble")(T:=(TyExternal "Double")).
                                { simpl. try reflexivity. }
                                { simpl. try reflexivity. }
                                { eapply T_List.
                                  { eapply T_MethodInvocation with(m:="trim").
                                    { eapply T_ArrayAccess.
                                      { eapply T_Var with(x:="tuple").
                                        simpl. try reflexivity. }
                                      { eapply T_Integer with(n:=0). } }
                                    { simpl. try reflexivity. }
                                    { simpl. try reflexivity. }
                                    { eapply T_Nil. }
                                    { simpl. try reflexivity. } }
                                  { eapply T_Nil. } }
                                { simpl. try reflexivity. } }
                              { eapply T_Nil. } }
                            { simpl. try reflexivity. } }
                          { eapply T_Skip. } }
                        { eapply T_If.
                          { eapply T_Eq.
                            { eapply T_FieldAccess with(f:="length").
                              { eapply T_Var with(x:="tuple").
                                simpl. try reflexivity. }
                              { simpl. try reflexivity. }
                              { simpl. try reflexivity. } }
                            { eapply T_Integer with(n:=1). }
                            { simpl. try reflexivity. } }
                          { eapply T_Concat.
                            { eapply T_Expression.
                              eapply T_MethodInvocation with(m:="add").
                              { eapply T_Var with(x:="list").
                                simpl. try reflexivity. }
                              { simpl. try reflexivity. }
                              { simpl. try reflexivity. }
                              { eapply T_List.
                                { eapply T_TyMethodInvocation with(m:="parseDouble")(T:=(TyExternal "Double")).
                                  { simpl. try reflexivity. }
                                  { simpl. try reflexivity. }
                                  { eapply T_List.
                                    { eapply T_MethodInvocation with(m:="trim").
                                      { eapply T_ArrayAccess.
                                        { eapply T_Var with(x:="tuple").
                                          simpl. try reflexivity. }
                                        { eapply T_Integer with(n:=0). } }
                                      { simpl. try reflexivity. }
                                      { simpl. try reflexivity. }
                                      { eapply T_Nil. }
                                      { simpl. try reflexivity. } }
                                    { eapply T_Nil. } }
                                  { simpl. try reflexivity. } }
                                { eapply T_Nil. } }
                              { simpl. try reflexivity. } }
                            { eapply T_Skip. } } } }
                      { eapply T_Skip. } } } }
                { eapply T_Concat.
                  { eapply T_Return.
                    { eapply T_Var with(x:="list").
                      simpl. try reflexivity. }
                    { simpl. try reflexivity. }
                    { simpl. try reflexivity. } }
                  { eapply T_Skip. } } } } } } } } } }
  Unshelve.
  all: apply STyVoid.
Defined.
Definition prog := the_exists_term (prog_well_typed).
Print prog.