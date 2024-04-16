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
      { eapply T_ClassDecl with(name:="AreRotations").
        { simpl. try reflexivity. }
        { eapply T_MethodDecl with(modif:="public static")(T:=TyBool)(m:="areRotations").
          { simpl. try reflexivity. }
          { eapply T_Concat.
            { eapply T_DeclNoInit with(T:=TyString)(x:="string1").
              simpl. try reflexivity. }
            { eapply T_Concat.
              { eapply T_DeclNoInit with(T:=TyString)(x:="string2").
                simpl. try reflexivity. }
              { eapply T_Skip. } } }
          { simpl. try reflexivity. }
          { eapply T_Concat.
            { eapply T_Concat.
              { eapply T_DeclInit with(T:=(TyArray TyString))(x:="arr").
                { simpl. try reflexivity. }
                { eapply T_MethodInvocation with(m:="split").
                  { eapply T_Var with(x:="string1").
                    simpl. try reflexivity. }
                  { simpl. try reflexivity. }
                  { simpl. try reflexivity. }
                  { eapply T_List.
                    { eapply T_String with(s:=""). }
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
                  { eapply T_DeclInit with(T:=TyInt)(x:="j").
                    { simpl. try reflexivity. }
                    { eapply T_Sub.
                      { eapply T_MethodInvocation with(m:="length").
                        { eapply T_Var with(x:="string1").
                          simpl. try reflexivity. }
                        { simpl. try reflexivity. }
                        { simpl. try reflexivity. }
                        { eapply T_Nil. }
                        { simpl. try reflexivity. } }
                      { eapply T_Integer with(n:=1). }
                      { simpl. try reflexivity. } }
                    { simpl. try reflexivity. } }
                  { eapply T_Skip. } }
                { eapply T_Concat.
                  { eapply T_While.
                    { eapply T_Le.
                      { eapply T_Var with(x:="i").
                        simpl. try reflexivity. }
                      { eapply T_Var with(x:="j").
                        simpl. try reflexivity. }
                      { simpl. try reflexivity. } }
                    { eapply T_Concat.
                      { eapply T_IfElse.
                        { eapply T_MethodInvocation with(m:="startsWith").
                          { eapply T_ArrayAccess.
                            { eapply T_Var with(x:="arr").
                              simpl. try reflexivity. }
                            { eapply T_Var with(x:="i").
                              simpl. try reflexivity. } }
                          { simpl. try reflexivity. }
                          { simpl. try reflexivity. }
                          { eapply T_List.
                            { eapply T_String with(s:="abc"). }
                            { eapply T_Nil. } }
                          { simpl. try reflexivity. } }
                        { eapply T_Concat.
                          { eapply T_Expression.
                            eapply T_PostInc.
                            eapply T_Var with(x:="i").
                            simpl. try reflexivity. }
                          { eapply T_Skip. } }
                        { eapply T_IfElse.
                          { eapply T_MethodInvocation with(m:="startsWith").
                            { eapply T_ArrayAccess.
                              { eapply T_Var with(x:="arr").
                                simpl. try reflexivity. }
                              { eapply T_Var with(x:="i").
                                simpl. try reflexivity. } }
                            { simpl. try reflexivity. }
                            { simpl. try reflexivity. }
                            { eapply T_List.
                              { eapply T_String with(s:="cdba"). }
                              { eapply T_Nil. } }
                            { simpl. try reflexivity. } }
                          { eapply T_Concat.
                            { eapply T_Expression.
                              eapply T_PostDec.
                              eapply T_Var with(x:="j").
                              simpl. try reflexivity. }
                            { eapply T_Skip. } }
                          { eapply T_IfElse.
                            { eapply T_MethodInvocation with(m:="startsWith").
                              { eapply T_ArrayAccess.
                                { eapply T_Var with(x:="arr").
                                  simpl. try reflexivity. }
                                { eapply T_Var with(x:="i").
                                  simpl. try reflexivity. } }
                              { simpl. try reflexivity. }
                              { simpl. try reflexivity. }
                              { eapply T_List.
                                { eapply T_String with(s:="cdaba"). }
                                { eapply T_Nil. } }
                              { simpl. try reflexivity. } }
                            { eapply T_Concat.
                              { eapply T_Expression.
                                eapply T_PostDec.
                                eapply T_Var with(x:="i").
                                simpl. try reflexivity. }
                              { eapply T_Skip. } }
                            { eapply T_IfElse.
                              { eapply T_MethodInvocation with(m:="startsWith").
                                { eapply T_ArrayAccess.
                                  { eapply T_Var with(x:="arr").
                                    simpl. try reflexivity. }
                                  { eapply T_Var with(x:="i").
                                    simpl. try reflexivity. } }
                                { simpl. try reflexivity. }
                                { simpl. try reflexivity. }
                                { eapply T_List.
                                  { eapply T_String with(s:="abacd"). }
                                  { eapply T_Nil. } }
                                { simpl. try reflexivity. } }
                              { eapply T_Concat.
                                { eapply T_Expression.
                                  eapply T_PostDec.
                                  eapply T_Var with(x:="j").
                                  simpl. try reflexivity. }
                                { eapply T_Skip. } }
                              { eapply T_IfElse.
                                { eapply T_MethodInvocation with(m:="startsWith").
                                  { eapply T_ArrayAccess.
                                    { eapply T_Var with(x:="arr").
                                      simpl. try reflexivity. }
                                    { eapply T_Var with(x:="i").
                                      simpl. try reflexivity. } }
                                  { simpl. try reflexivity. }
                                  { simpl. try reflexivity. }
                                  { eapply T_List.
                                    { eapply T_String with(s:="cdaba"). }
                                    { eapply T_Nil. } }
                                  { simpl. try reflexivity. } }
                                { eapply T_Concat.
                                  { eapply T_Break. }
                                  { eapply T_Skip. } }
                                { eapply T_Concat.
                                  { eapply T_Expression.
                                    eapply T_MethodInvocation with(m:="println").
                                    { eapply T_TyFieldAccess with(f:="out")(T:=(TyExternal "System")).
                                      { simpl. try reflexivity. }
                                      { simpl. try reflexivity. } }
                                    { simpl. try reflexivity. }
                                    { simpl. try reflexivity. }
                                    { eapply T_List.
                                      { eapply T_String with(s:="Invalid input"). }
                                      { eapply T_Nil. } }
                                    { simpl. try reflexivity. } }
                                  { eapply T_Concat.
                                    { eapply T_Expression.
                                      eapply T_TyMethodInvocation with(m:="exit")(T:=(TyExternal "System")).
                                      { simpl. try reflexivity. }
                                      { simpl. try reflexivity. }
                                      { eapply T_List.
                                        { eapply T_Integer with(n:=0). }
                                        { eapply T_Nil. } }
                                      { simpl. try reflexivity. } }
                                    { eapply T_Skip. } } } } } } } }
                      { eapply T_Skip. } } }
                  { eapply T_Concat.
                    { eapply T_Return.
                      { eapply T_Ne.
                        { eapply T_Var with(x:="i").
                          simpl. try reflexivity. }
                        { eapply T_Var with(x:="j").
                          simpl. try reflexivity. }
                        { simpl. try reflexivity. } }
                      { simpl. try reflexivity. }
                      { simpl. try reflexivity. } }
                    { eapply T_Skip. } } } } } } } } } } }
  Unshelve.
  all: apply STyVoid.
Defined.
Definition prog := the_exists_term (prog_well_typed).
Print prog.