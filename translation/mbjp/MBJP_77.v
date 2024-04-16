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
      { eapply T_ClassDecl with(name:="IsDiff").
        { simpl. try reflexivity. }
        { eapply T_MethodDecl with(modif:="public static")(T:=TyBool)(m:="isDiff").
          { simpl. try reflexivity. }
          { eapply T_Concat.
            { eapply T_DeclNoInit with(T:=TyInt)(x:="n").
              simpl. try reflexivity. }
            { eapply T_Skip. } }
          { simpl. try reflexivity. }
          { eapply T_Concat.
            { eapply T_Concat.
              { eapply T_DeclInit with(T:=TyString)(x:="nStr").
                { simpl. try reflexivity. }
                { eapply T_TyMethodInvocation with(m:="toString")(T:=(TyExternal "Integer")).
                  { simpl. try reflexivity. }
                  { simpl. try reflexivity. }
                  { eapply T_List.
                    { eapply T_Var with(x:="n").
                      simpl. try reflexivity. }
                    { eapply T_Nil. } }
                  { simpl. try reflexivity. } }
                { simpl. try reflexivity. } }
              { eapply T_Skip. } }
            { eapply T_Concat.
              { eapply T_Concat.
                { eapply T_DeclInit with(T:=TyString)(x:="sStr").
                  { simpl. try reflexivity. }
                  { eapply T_Add.
                    { eapply T_Var with(x:="nStr").
                      simpl. try reflexivity. }
                    { eapply T_String with(s:=""). }
                    { simpl. try reflexivity. } }
                  { simpl. try reflexivity. } }
                { eapply T_Skip. } }
              { eapply T_Concat.
                { eapply T_If.
                  { eapply T_Eq.
                    { eapply T_Mod.
                      { eapply T_MethodInvocation with(m:="length").
                        { eapply T_Var with(x:="sStr").
                          simpl. try reflexivity. }
                        { simpl. try reflexivity. }
                        { simpl. try reflexivity. }
                        { eapply T_Nil. }
                        { simpl. try reflexivity. } }
                      { eapply T_Integer with(n:=2). } }
                    { eapply T_Integer with(n:=0). }
                    { simpl. try reflexivity. } }
                  { eapply T_Concat.
                    { eapply T_Return.
                      { eapply T_False. }
                      { simpl. try reflexivity. }
                      { simpl. try reflexivity. } }
                    { eapply T_Skip. } } }
                { eapply T_Concat.
                  { eapply T_If.
                    { eapply T_Eq.
                      { eapply T_Mod.
                        { eapply T_MethodInvocation with(m:="length").
                          { eapply T_Var with(x:="nStr").
                            simpl. try reflexivity. }
                          { simpl. try reflexivity. }
                          { simpl. try reflexivity. }
                          { eapply T_Nil. }
                          { simpl. try reflexivity. } }
                        { eapply T_Integer with(n:=2). } }
                      { eapply T_Integer with(n:=1). }
                      { simpl. try reflexivity. } }
                    { eapply T_Concat.
                      { eapply T_Return.
                        { eapply T_True. }
                        { simpl. try reflexivity. }
                        { simpl. try reflexivity. } }
                      { eapply T_Skip. } } }
                  { eapply T_Concat.
                    { eapply T_Concat.
                      { eapply T_DeclInit with(T:=TyBool)(x:="result").
                        { simpl. try reflexivity. }
                        { eapply T_And.
                          { eapply T_Eq.
                            { eapply T_Mod.
                              { eapply T_MethodInvocation with(m:="length").
                                { eapply T_Var with(x:="sStr").
                                  simpl. try reflexivity. }
                                { simpl. try reflexivity. }
                                { simpl. try reflexivity. }
                                { eapply T_Nil. }
                                { simpl. try reflexivity. } }
                              { eapply T_Integer with(n:=2). } }
                            { eapply T_Integer with(n:=0). }
                            { simpl. try reflexivity. } }
                          { eapply T_Ne.
                            { eapply T_MethodInvocation with(m:="length").
                              { eapply T_Var with(x:="sStr").
                                simpl. try reflexivity. }
                              { simpl. try reflexivity. }
                              { simpl. try reflexivity. }
                              { eapply T_Nil. }
                              { simpl. try reflexivity. } }
                            { eapply T_Integer with(n:=0). }
                            { simpl. try reflexivity. } } }
                        { simpl. try reflexivity. } }
                      { eapply T_Skip. } }
                    { eapply T_Concat.
                      { eapply T_Return.
                        { eapply T_Var with(x:="result").
                          simpl. try reflexivity. }
                        { simpl. try reflexivity. }
                        { simpl. try reflexivity. } }
                      { eapply T_Skip. } } } } } } } } } } } }
  Unshelve.
  all: apply STyVoid.
Defined.
Definition prog := the_exists_term (prog_well_typed).
Print prog.