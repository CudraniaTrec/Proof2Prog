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
      { eapply T_ClassDecl with(name:="RemoveSpaces").
        { simpl. try reflexivity. }
        { eapply T_MethodDecl with(modif:="public static")(T:=TyString)(m:="removeSpaces").
          { simpl. try reflexivity. }
          { eapply T_Concat.
            { eapply T_DeclNoInit with(T:=TyString)(x:="str1").
              simpl. try reflexivity. }
            { eapply T_Skip. } }
          { simpl. try reflexivity. }
          { eapply T_Concat.
            { eapply T_If.
              { eapply T_Eq.
                { eapply T_Var with(x:="str1").
                  simpl. try reflexivity. }
                { eapply T_Null. }
                { simpl. try reflexivity. } }
              { eapply T_Concat.
                { eapply T_Return.
                  { eapply T_String with(s:=""). }
                  { simpl. try reflexivity. }
                  { simpl. try reflexivity. } }
                { eapply T_Skip. } } }
            { eapply T_Concat.
              { eapply T_Concat.
                { eapply T_DeclInit with(T:=TyInt)(x:="length").
                  { simpl. try reflexivity. }
                  { eapply T_MethodInvocation with(m:="length").
                    { eapply T_Var with(x:="str1").
                      simpl. try reflexivity. }
                    { simpl. try reflexivity. }
                    { simpl. try reflexivity. }
                    { eapply T_Nil. }
                    { simpl. try reflexivity. } }
                  { simpl. try reflexivity. } }
                { eapply T_Skip. } }
              { eapply T_Concat.
                { eapply T_Concat.
                  { eapply T_DeclInit with(T:=(TyArray TyChar))(x:="charArr").
                    { simpl. try reflexivity. }
                    { eapply T_MethodInvocation with(m:="toCharArray").
                      { eapply T_Var with(x:="str1").
                        simpl. try reflexivity. }
                      { simpl. try reflexivity. }
                      { simpl. try reflexivity. }
                      { eapply T_Nil. }
                      { simpl. try reflexivity. } }
                    { simpl. try reflexivity. } }
                  { eapply T_Skip. } }
                { eapply T_Concat.
                  { eapply T_Concat.
                    { eapply T_DeclInit with(T:=(TyExternal "StringBuilder"))(x:="sb").
                      { simpl. try reflexivity. }
                      { eapply T_New' with(T:=(TyExternal "StringBuilder")).
                        { simpl. try reflexivity. }
                        { eapply T_List.
                          { eapply T_Var with(x:="length").
                            simpl. try reflexivity. }
                          { eapply T_Nil. } } }
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
                        { eapply T_Var with(x:="length").
                          simpl. try reflexivity. }
                        { simpl. try reflexivity. } }
                      { eapply T_PostInc.
                        eapply T_Var with(x:="i").
                        simpl. try reflexivity. }
                      { eapply T_Concat.
                        { eapply T_IfElse.
                          { eapply T_Eq.
                            { eapply T_ArrayAccess.
                              { eapply T_Var with(x:="charArr").
                                simpl. try reflexivity. }
                              { eapply T_Var with(x:="i").
                                simpl. try reflexivity. } }
                            { eapply T_Char with(c:=32). }
                            { simpl. try reflexivity. } }
                          { eapply T_Concat.
                            { eapply T_Expression.
                              eapply T_Assign.
                              { eapply T_ArrayAccess.
                                { eapply T_Var with(x:="charArr").
                                  simpl. try reflexivity. }
                                { eapply T_Var with(x:="i").
                                  simpl. try reflexivity. } }
                              { eapply T_Char with(c:=0). }
                              { simpl. try reflexivity. } }
                            { eapply T_Skip. } }
                          { eapply T_Concat.
                            { eapply T_Expression.
                              eapply T_MethodInvocation with(m:="append").
                              { eapply T_Var with(x:="sb").
                                simpl. try reflexivity. }
                              { simpl. try reflexivity. }
                              { simpl. try reflexivity. }
                              { eapply T_List.
                                { eapply T_ArrayAccess.
                                  { eapply T_Var with(x:="charArr").
                                    simpl. try reflexivity. }
                                  { eapply T_Var with(x:="i").
                                    simpl. try reflexivity. } }
                                { eapply T_Nil. } }
                              { simpl. try reflexivity. } }
                            { eapply T_Skip. } } }
                        { eapply T_Skip. } } }
                    { eapply T_Concat.
                      { eapply T_Return.
                        { eapply T_MethodInvocation with(m:="toString").
                          { eapply T_Var with(x:="sb").
                            simpl. try reflexivity. }
                          { simpl. try reflexivity. }
                          { simpl. try reflexivity. }
                          { eapply T_Nil. }
                          { simpl. try reflexivity. } }
                        { simpl. try reflexivity. }
                        { simpl. try reflexivity. } }
                      { eapply T_Skip. } } } } } } } } } } } }
  Unshelve.
  all: apply STyVoid.
Defined.
Definition prog := the_exists_term (prog_well_typed).
Print prog.