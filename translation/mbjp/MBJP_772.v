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
      { eapply T_ClassDecl with(name:="RemoveLength").
        { simpl. try reflexivity. }
        { eapply T_MethodDecl with(modif:="public static")(T:=TyString)(m:="removeLength").
          { simpl. try reflexivity. }
          { eapply T_Concat.
            { eapply T_DeclNoInit with(T:=TyString)(x:="testStr").
              simpl. try reflexivity. }
            { eapply T_Concat.
              { eapply T_DeclNoInit with(T:=TyInt)(x:="k").
                simpl. try reflexivity. }
              { eapply T_Skip. } } }
          { simpl. try reflexivity. }
          { eapply T_Concat.
            { eapply T_Concat.
              { eapply T_DeclInit with(T:=TyString)(x:="result").
                { simpl. try reflexivity. }
                { eapply T_String with(s:=""). }
                { simpl. try reflexivity. } }
              { eapply T_Skip. } }
            { eapply T_Concat.
              { eapply T_Concat.
                { eapply T_DeclInit with(T:=(TyArray TyString))(x:="arrOfStr").
                  { simpl. try reflexivity. }
                  { eapply T_MethodInvocation with(m:="split").
                    { eapply T_Var with(x:="testStr").
                      simpl. try reflexivity. }
                    { simpl. try reflexivity. }
                    { simpl. try reflexivity. }
                    { eapply T_List.
                      { eapply T_String with(s:=" "). }
                      { eapply T_Nil. } }
                    { simpl. try reflexivity. } }
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
                      { eapply T_Var with(x:="arrOfStr").
                        simpl. try reflexivity. }
                      { simpl. try reflexivity. }
                      { simpl. try reflexivity. } }
                    { simpl. try reflexivity. } }
                  { eapply T_PostInc.
                    eapply T_Var with(x:="i").
                    simpl. try reflexivity. }
                  { eapply T_Concat.
                    { eapply T_IfElse.
                      { eapply T_Eq.
                        { eapply T_MethodInvocation with(m:="length").
                          { eapply T_ArrayAccess.
                            { eapply T_Var with(x:="arrOfStr").
                              simpl. try reflexivity. }
                            { eapply T_Var with(x:="i").
                              simpl. try reflexivity. } }
                          { simpl. try reflexivity. }
                          { simpl. try reflexivity. }
                          { eapply T_Nil. }
                          { simpl. try reflexivity. } }
                        { eapply T_Var with(x:="k").
                          simpl. try reflexivity. }
                        { simpl. try reflexivity. } }
                      { eapply T_Concat.
                        { eapply T_Continue. }
                        { eapply T_Skip. } }
                      { eapply T_Concat.
                        { eapply T_Expression.
                          eapply T_Assign.
                          { eapply T_Var with(x:="result").
                            simpl. try reflexivity. }
                          { eapply T_Add.
                            { eapply T_Var with(x:="result").
                              simpl. try reflexivity. }
                            { eapply T_Add.
                              { eapply T_ArrayAccess.
                                { eapply T_Var with(x:="arrOfStr").
                                  simpl. try reflexivity. }
                                { eapply T_Var with(x:="i").
                                  simpl. try reflexivity. } }
                              { eapply T_String with(s:=" "). }
                              { simpl. try reflexivity. } }
                            { simpl. try reflexivity. } }
                          { simpl. try reflexivity. } }
                        { eapply T_Skip. } } }
                    { eapply T_Skip. } } }
                { eapply T_Concat.
                  { eapply T_Return.
                    { eapply T_MethodInvocation with(m:="substring").
                      { eapply T_Var with(x:="result").
                        simpl. try reflexivity. }
                      { simpl. try reflexivity. }
                      { simpl. try reflexivity. }
                      { eapply T_List.
                        { eapply T_Integer with(n:=0). }
                        { eapply T_List.
                          { eapply T_Sub.
                            { eapply T_MethodInvocation with(m:="length").
                              { eapply T_Var with(x:="result").
                                simpl. try reflexivity. }
                              { simpl. try reflexivity. }
                              { simpl. try reflexivity. }
                              { eapply T_Nil. }
                              { simpl. try reflexivity. } }
                            { eapply T_Integer with(n:=1). }
                            { simpl. try reflexivity. } }
                          { eapply T_Nil. } } }
                      { simpl. try reflexivity. } }
                    { simpl. try reflexivity. }
                    { simpl. try reflexivity. } }
                  { eapply T_Skip. } } } } } } } } } }
  Unshelve.
  all: apply STyVoid.
Defined.
Definition prog := the_exists_term (prog_well_typed).
Print prog.