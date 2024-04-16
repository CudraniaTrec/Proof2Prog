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
      { eapply T_ClassDecl with(name:="CapitalizeFirstLastLetters").
        { simpl. try reflexivity. }
        { eapply T_MethodDecl with(modif:="public static")(T:=TyString)(m:="capitalizeFirstLastLetters").
          { simpl. try reflexivity. }
          { eapply T_Concat.
            { eapply T_DeclNoInit with(T:=TyString)(x:="str1").
              simpl. try reflexivity. }
            { eapply T_Skip. } }
          { simpl. try reflexivity. }
          { eapply T_Concat.
            { eapply T_Concat.
              { eapply T_DeclInit with(T:=(TyArray TyChar))(x:="char1").
                { simpl. try reflexivity. }
                { eapply T_MethodInvocation with(m:="toCharArray").
                  { eapply T_MethodInvocation with(m:="toLowerCase").
                    { eapply T_Var with(x:="str1").
                      simpl. try reflexivity. }
                    { simpl. try reflexivity. }
                    { simpl. try reflexivity. }
                    { eapply T_Nil. }
                    { simpl. try reflexivity. } }
                  { simpl. try reflexivity. }
                  { simpl. try reflexivity. }
                  { eapply T_Nil. }
                  { simpl. try reflexivity. } }
                { simpl. try reflexivity. } }
              { eapply T_Skip. } }
            { eapply T_Concat.
              { eapply T_If.
                { eapply T_And.
                  { eapply T_Ge.
                    { eapply T_ArrayAccess.
                      { eapply T_Var with(x:="char1").
                        simpl. try reflexivity. }
                      { eapply T_Integer with(n:=0). } }
                    { eapply T_Char with(c:=97). }
                    { simpl. try reflexivity. } }
                  { eapply T_Le.
                    { eapply T_ArrayAccess.
                      { eapply T_Var with(x:="char1").
                        simpl. try reflexivity. }
                      { eapply T_Integer with(n:=0). } }
                    { eapply T_Char with(c:=122). }
                    { simpl. try reflexivity. } } }
                { eapply T_Concat.
                  { eapply T_Expression.
                    eapply T_Assign.
                    { eapply T_ArrayAccess.
                      { eapply T_Var with(x:="char1").
                        simpl. try reflexivity. }
                      { eapply T_Integer with(n:=0). } }
                    { eapply T_Conversion with(T:=TyChar).
                      { eapply T_Sub.
                        { eapply T_ArrayAccess.
                          { eapply T_Var with(x:="char1").
                            simpl. try reflexivity. }
                          { eapply T_Integer with(n:=0). } }
                        { eapply T_Integer with(n:=32). }
                        { simpl. try reflexivity. } }
                      { simpl. try reflexivity. } }
                    { simpl. try reflexivity. } }
                  { eapply T_Skip. } } }
              { eapply T_Concat.
                { eapply T_If.
                  { eapply T_And.
                    { eapply T_Ge.
                      { eapply T_ArrayAccess.
                        { eapply T_Var with(x:="char1").
                          simpl. try reflexivity. }
                        { eapply T_Sub.
                          { eapply T_FieldAccess with(f:="length").
                            { eapply T_Var with(x:="char1").
                              simpl. try reflexivity. }
                            { simpl. try reflexivity. }
                            { simpl. try reflexivity. } }
                          { eapply T_Integer with(n:=1). }
                          { simpl. try reflexivity. } } }
                      { eapply T_Char with(c:=97). }
                      { simpl. try reflexivity. } }
                    { eapply T_Le.
                      { eapply T_ArrayAccess.
                        { eapply T_Var with(x:="char1").
                          simpl. try reflexivity. }
                        { eapply T_Sub.
                          { eapply T_FieldAccess with(f:="length").
                            { eapply T_Var with(x:="char1").
                              simpl. try reflexivity. }
                            { simpl. try reflexivity. }
                            { simpl. try reflexivity. } }
                          { eapply T_Integer with(n:=1). }
                          { simpl. try reflexivity. } } }
                      { eapply T_Char with(c:=122). }
                      { simpl. try reflexivity. } } }
                  { eapply T_Concat.
                    { eapply T_Expression.
                      eapply T_Assign.
                      { eapply T_ArrayAccess.
                        { eapply T_Var with(x:="char1").
                          simpl. try reflexivity. }
                        { eapply T_Sub.
                          { eapply T_FieldAccess with(f:="length").
                            { eapply T_Var with(x:="char1").
                              simpl. try reflexivity. }
                            { simpl. try reflexivity. }
                            { simpl. try reflexivity. } }
                          { eapply T_Integer with(n:=1). }
                          { simpl. try reflexivity. } } }
                      { eapply T_Conversion with(T:=TyChar).
                        { eapply T_Sub.
                          { eapply T_ArrayAccess.
                            { eapply T_Var with(x:="char1").
                              simpl. try reflexivity. }
                            { eapply T_Sub.
                              { eapply T_FieldAccess with(f:="length").
                                { eapply T_Var with(x:="char1").
                                  simpl. try reflexivity. }
                                { simpl. try reflexivity. }
                                { simpl. try reflexivity. } }
                              { eapply T_Integer with(n:=1). }
                              { simpl. try reflexivity. } } }
                          { eapply T_Integer with(n:=32). }
                          { simpl. try reflexivity. } }
                        { simpl. try reflexivity. } }
                      { simpl. try reflexivity. } }
                    { eapply T_Skip. } } }
                { eapply T_Concat.
                  { eapply T_Return.
                    { eapply T_TyMethodInvocation with(m:="valueOf")(T:=(TyExternal "String")).
                      { simpl. try reflexivity. }
                      { simpl. try reflexivity. }
                      { eapply T_List.
                        { eapply T_Var with(x:="char1").
                          simpl. try reflexivity. }
                        { eapply T_Nil. } }
                      { simpl. try reflexivity. } }
                    { simpl. try reflexivity. }
                    { simpl. try reflexivity. } }
                  { eapply T_Skip. } } } } } } } } } }
  Unshelve.
  all: apply STyVoid.
Defined.
Definition prog := the_exists_term (prog_well_typed).
Print prog.