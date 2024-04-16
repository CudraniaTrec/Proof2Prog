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
      { eapply T_ClassDecl with(name:="RemoveParenthesis").
        { simpl. try reflexivity. }
        { eapply T_MethodDecl with(modif:="public static")(T:=TyString)(m:="removeParenthesis").
          { simpl. try reflexivity. }
          { eapply T_Concat.
            { eapply T_DeclNoInit with(T:=(TyGeneric1 "List" TyString))(x:="items").
              simpl. try reflexivity. }
            { eapply T_Skip. } }
          { simpl. try reflexivity. }
          { eapply T_Concat.
            { eapply T_Concat.
              { eapply T_DeclInit with(T:=TyString)(x:="result").
                { simpl. try reflexivity. }
                { eapply T_String with(s:=""). }
                { simpl. try reflexivity. } }
              { eapply T_Skip. } }
            { eapply T_Concat.
              { eapply T_Foreach with(T:=TyString)(x:="item").
                { simpl. try reflexivity. }
                { eapply T_Var with(x:="items").
                  simpl. try reflexivity. }
                { simpl. try reflexivity. }
                { eapply T_Concat.
                  { eapply T_If.
                    { eapply T_MethodInvocation with(m:="contains").
                      { eapply T_Var with(x:="item").
                        simpl. try reflexivity. }
                      { simpl. try reflexivity. }
                      { simpl. try reflexivity. }
                      { eapply T_List.
                        { eapply T_String with(s:="("). }
                        { eapply T_Nil. } }
                      { simpl. try reflexivity. } }
                    { eapply T_Concat.
                      { eapply T_Concat.
                        { eapply T_DeclInit with(T:=TyInt)(x:="pos").
                          { simpl. try reflexivity. }
                          { eapply T_MethodInvocation with(m:="indexOf").
                            { eapply T_Var with(x:="item").
                              simpl. try reflexivity. }
                            { simpl. try reflexivity. }
                            { simpl. try reflexivity. }
                            { eapply T_List.
                              { eapply T_String with(s:="("). }
                              { eapply T_Nil. } }
                            { simpl. try reflexivity. } }
                          { simpl. try reflexivity. } }
                        { eapply T_Skip. } }
                      { eapply T_Concat.
                        { eapply T_If.
                          { eapply T_Gt.
                            { eapply T_Var with(x:="pos").
                              simpl. try reflexivity. }
                            { eapply T_Integer with(n:=0). }
                            { simpl. try reflexivity. } }
                          { eapply T_Concat.
                            { eapply T_Concat.
                              { eapply T_DeclInit with(T:=TyString)(x:="subString").
                                { simpl. try reflexivity. }
                                { eapply T_MethodInvocation with(m:="substring").
                                  { eapply T_Var with(x:="item").
                                    simpl. try reflexivity. }
                                  { simpl. try reflexivity. }
                                  { simpl. try reflexivity. }
                                  { eapply T_List.
                                    { eapply T_Integer with(n:=0). }
                                    { eapply T_List.
                                      { eapply T_Var with(x:="pos").
                                        simpl. try reflexivity. }
                                      { eapply T_Nil. } } }
                                  { simpl. try reflexivity. } }
                                { simpl. try reflexivity. } }
                              { eapply T_Skip. } }
                            { eapply T_Concat.
                              { eapply T_Concat.
                                { eapply T_DeclInit with(T:=(TyArray TyString))(x:="splitString").
                                  { simpl. try reflexivity. }
                                  { eapply T_MethodInvocation with(m:="split").
                                    { eapply T_Var with(x:="subString").
                                      simpl. try reflexivity. }
                                    { simpl. try reflexivity. }
                                    { simpl. try reflexivity. }
                                    { eapply T_List.
                                      { eapply T_String with(s:="\\s+"). }
                                      { eapply T_Nil. } }
                                    { simpl. try reflexivity. } }
                                  { simpl. try reflexivity. } }
                                { eapply T_Skip. } }
                              { eapply T_Concat.
                                { eapply T_Expression.
                                  eapply T_Assign.
                                  { eapply T_Var with(x:="result").
                                    simpl. try reflexivity. }
                                  { eapply T_MethodInvocation with(m:="concat").
                                    { eapply T_Var with(x:="result").
                                      simpl. try reflexivity. }
                                    { simpl. try reflexivity. }
                                    { simpl. try reflexivity. }
                                    { eapply T_List.
                                      { eapply T_ArrayAccess.
                                        { eapply T_Var with(x:="splitString").
                                          simpl. try reflexivity. }
                                        { eapply T_Integer with(n:=0). } }
                                      { eapply T_Nil. } }
                                    { simpl. try reflexivity. } }
                                  { simpl. try reflexivity. } }
                                { eapply T_Skip. } } } } }
                        { eapply T_Skip. } } } }
                  { eapply T_Skip. } } }
              { eapply T_Concat.
                { eapply T_Return.
                  { eapply T_Var with(x:="result").
                    simpl. try reflexivity. }
                  { simpl. try reflexivity. }
                  { simpl. try reflexivity. } }
                { eapply T_Skip. } } } } } } } } }
  Unshelve.
  all: apply STyVoid.
Defined.
Definition prog := the_exists_term (prog_well_typed).
Print prog.