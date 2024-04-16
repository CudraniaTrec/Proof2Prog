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
      { eapply T_ClassDecl with(name:="CheckString").
        { simpl. try reflexivity. }
        { eapply T_MethodDecl with(modif:="public static")(T:=(TyGeneric1 "List" TyString))(m:="checkString").
          { simpl. try reflexivity. }
          { eapply T_Concat.
            { eapply T_DeclNoInit with(T:=TyString)(x:="str1").
              simpl. try reflexivity. }
            { eapply T_Skip. } }
          { simpl. try reflexivity. }
          { eapply T_Concat.
            { eapply T_Concat.
              { eapply T_DeclInit with(T:=(TyGeneric1 "List" TyString))(x:="result").
                { simpl. try reflexivity. }
                { eapply T_New' with(T:=(TyGeneric1 "ArrayList" TyString)).
                  { simpl. try reflexivity. }
                  { eapply T_Nil. } }
                { simpl. try reflexivity. } }
              { eapply T_Skip. } }
            { eapply T_Concat.
              { eapply T_Concat.
                { eapply T_DeclInit with(T:=(TyArray TyString))(x:="strings").
                  { simpl. try reflexivity. }
                  { eapply T_ArrayConcat.
                    { eapply T_String with(s:="String must have 1 upper case character."). }
                    { eapply T_ArrayConcat.
                      { eapply T_String with(s:="String must have 1 lower case character."). }
                      { eapply T_ArrayConcat.
                        { eapply T_String with(s:="String must have 1 number."). }
                        { eapply T_ArrayConcat.
                          { eapply T_String with(s:="String length should be atleast 8."). }
                          { eapply T_EmptyArray. } } } } }
                  { simpl. try reflexivity. } }
                { eapply T_Skip. } }
              { eapply T_Concat.
                { eapply T_Concat.
                  { eapply T_DeclInit with(T:=(TyArray TyBool))(x:="stringsRes").
                    { simpl. try reflexivity. }
                    { eapply T_ArrayConcat.
                      { eapply T_MethodInvocation with(m:="matches").
                        { eapply T_Var with(x:="str1").
                          simpl. try reflexivity. }
                        { simpl. try reflexivity. }
                        { simpl. try reflexivity. }
                        { eapply T_List.
                          { eapply T_String with(s:=".*[A-Z].*"). }
                          { eapply T_Nil. } }
                        { simpl. try reflexivity. } }
                      { eapply T_ArrayConcat.
                        { eapply T_MethodInvocation with(m:="matches").
                          { eapply T_Var with(x:="str1").
                            simpl. try reflexivity. }
                          { simpl. try reflexivity. }
                          { simpl. try reflexivity. }
                          { eapply T_List.
                            { eapply T_String with(s:=".*[a-z].*"). }
                            { eapply T_Nil. } }
                          { simpl. try reflexivity. } }
                        { eapply T_ArrayConcat.
                          { eapply T_MethodInvocation with(m:="matches").
                            { eapply T_Var with(x:="str1").
                              simpl. try reflexivity. }
                            { simpl. try reflexivity. }
                            { simpl. try reflexivity. }
                            { eapply T_List.
                              { eapply T_String with(s:=".*[0-9].*"). }
                              { eapply T_Nil. } }
                            { simpl. try reflexivity. } }
                          { eapply T_ArrayConcat.
                            { eapply T_Ge.
                              { eapply T_MethodInvocation with(m:="length").
                                { eapply T_Var with(x:="str1").
                                  simpl. try reflexivity. }
                                { simpl. try reflexivity. }
                                { simpl. try reflexivity. }
                                { eapply T_Nil. }
                                { simpl. try reflexivity. } }
                              { eapply T_Integer with(n:=7). }
                              { simpl. try reflexivity. } }
                            { eapply T_EmptyArray. } } } } }
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
                      { eapply T_FieldAccess with(f:="length").
                        { eapply T_Var with(x:="strings").
                          simpl. try reflexivity. }
                        { simpl. try reflexivity. }
                        { simpl. try reflexivity. } }
                      { simpl. try reflexivity. } }
                    { eapply T_PostInc.
                      eapply T_Var with(x:="i").
                      simpl. try reflexivity. }
                    { eapply T_Concat.
                      { eapply T_If.
                        { eapply T_Ne.
                          { eapply T_ArrayAccess.
                            { eapply T_Var with(x:="stringsRes").
                              simpl. try reflexivity. }
                            { eapply T_Var with(x:="i").
                              simpl. try reflexivity. } }
                          { eapply T_True. }
                          { simpl. try reflexivity. } }
                        { eapply T_Concat.
                          { eapply T_Expression.
                            eapply T_MethodInvocation with(m:="add").
                            { eapply T_Var with(x:="result").
                              simpl. try reflexivity. }
                            { simpl. try reflexivity. }
                            { simpl. try reflexivity. }
                            { eapply T_List.
                              { eapply T_ArrayAccess.
                                { eapply T_Var with(x:="strings").
                                  simpl. try reflexivity. }
                                { eapply T_Var with(x:="i").
                                  simpl. try reflexivity. } }
                              { eapply T_Nil. } }
                            { simpl. try reflexivity. } }
                          { eapply T_Skip. } } }
                      { eapply T_Skip. } } }
                  { eapply T_Concat.
                    { eapply T_If.
                      { eapply T_Eq.
                        { eapply T_MethodInvocation with(m:="size").
                          { eapply T_Var with(x:="result").
                            simpl. try reflexivity. }
                          { simpl. try reflexivity. }
                          { simpl. try reflexivity. }
                          { eapply T_Nil. }
                          { simpl. try reflexivity. } }
                        { eapply T_Integer with(n:=0). }
                        { simpl. try reflexivity. } }
                      { eapply T_Concat.
                        { eapply T_Expression.
                          eapply T_MethodInvocation with(m:="add").
                          { eapply T_Var with(x:="result").
                            simpl. try reflexivity. }
                          { simpl. try reflexivity. }
                          { simpl. try reflexivity. }
                          { eapply T_List.
                            { eapply T_String with(s:="Valid string."). }
                            { eapply T_Nil. } }
                          { simpl. try reflexivity. } }
                        { eapply T_Skip. } } }
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