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
      { eapply T_ClassDecl with(name:="CountSubstringWithEqualEnds").
        { simpl. try reflexivity. }
        { eapply T_MethodDecl with(modif:="public static")(T:=TyInt)(m:="countSubstringWithEqualEnds").
          { simpl. try reflexivity. }
          { eapply T_Concat.
            { eapply T_DeclNoInit with(T:=TyString)(x:="s").
              simpl. try reflexivity. }
            { eapply T_Skip. } }
          { simpl. try reflexivity. }
          { eapply T_Concat.
            { eapply T_Concat.
              { eapply T_DeclInit with(T:=(TyArray TyInt))(x:="counts").
                { simpl. try reflexivity. }
                { eapply T_NewArrayNoInit' with(T:=TyInt).
                  { eapply T_MethodInvocation with(m:="length").
                    { eapply T_Var with(x:="s").
                      simpl. try reflexivity. }
                    { simpl. try reflexivity. }
                    { simpl. try reflexivity. }
                    { eapply T_Nil. }
                    { simpl. try reflexivity. } }
                  { eapply T_NewArrayNoInit with(T:=TyInt). } }
                { simpl. try reflexivity. } }
              { eapply T_Skip. } }
            { eapply T_Concat.
              { eapply T_Concat.
                { eapply T_DeclInit with(T:=TyInt)(x:="total").
                  { simpl. try reflexivity. }
                  { eapply T_Integer with(n:=0). }
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
                    { eapply T_MethodInvocation with(m:="length").
                      { eapply T_Var with(x:="s").
                        simpl. try reflexivity. }
                      { simpl. try reflexivity. }
                      { simpl. try reflexivity. }
                      { eapply T_Nil. }
                      { simpl. try reflexivity. } }
                    { simpl. try reflexivity. } }
                  { eapply T_PostInc.
                    eapply T_Var with(x:="i").
                    simpl. try reflexivity. }
                  { eapply T_Concat.
                    { eapply T_Expression.
                      eapply T_PostInc.
                      eapply T_ArrayAccess.
                      { eapply T_Var with(x:="counts").
                        simpl. try reflexivity. }
                      { eapply T_Sub.
                        { eapply T_MethodInvocation with(m:="charAt").
                          { eapply T_Var with(x:="s").
                            simpl. try reflexivity. }
                          { simpl. try reflexivity. }
                          { simpl. try reflexivity. }
                          { eapply T_List.
                            { eapply T_Var with(x:="i").
                              simpl. try reflexivity. }
                            { eapply T_Nil. } }
                          { simpl. try reflexivity. } }
                        { eapply T_Char with(c:=97). }
                        { simpl. try reflexivity. } } }
                    { eapply T_Skip. } } }
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
                      { eapply T_MethodInvocation with(m:="length").
                        { eapply T_Var with(x:="s").
                          simpl. try reflexivity. }
                        { simpl. try reflexivity. }
                        { simpl. try reflexivity. }
                        { eapply T_Nil. }
                        { simpl. try reflexivity. } }
                      { simpl. try reflexivity. } }
                    { eapply T_PostInc.
                      eapply T_Var with(x:="i").
                      simpl. try reflexivity. }
                    { eapply T_Concat.
                      { eapply T_Concat.
                        { eapply T_DeclInit with(T:=TyInt)(x:="left").
                          { simpl. try reflexivity. }
                          { eapply T_Integer with(n:=0). }
                          { simpl. try reflexivity. } }
                        { eapply T_Skip. } }
                      { eapply T_Concat.
                        { eapply T_Concat.
                          { eapply T_DeclInit with(T:=TyInt)(x:="right").
                            { simpl. try reflexivity. }
                            { eapply T_ArrayAccess.
                              { eapply T_Var with(x:="counts").
                                simpl. try reflexivity. }
                              { eapply T_Sub.
                                { eapply T_MethodInvocation with(m:="charAt").
                                  { eapply T_Var with(x:="s").
                                    simpl. try reflexivity. }
                                  { simpl. try reflexivity. }
                                  { simpl. try reflexivity. }
                                  { eapply T_List.
                                    { eapply T_Var with(x:="i").
                                      simpl. try reflexivity. }
                                    { eapply T_Nil. } }
                                  { simpl. try reflexivity. } }
                                { eapply T_Char with(c:=97). }
                                { simpl. try reflexivity. } } }
                            { simpl. try reflexivity. } }
                          { eapply T_Skip. } }
                        { eapply T_Concat.
                          { eapply T_While.
                            { eapply T_Le.
                              { eapply T_Var with(x:="left").
                                simpl. try reflexivity. }
                              { eapply T_Var with(x:="right").
                                simpl. try reflexivity. }
                              { simpl. try reflexivity. } }
                            { eapply T_Concat.
                              { eapply T_Expression.
                                eapply T_Assign.
                                { eapply T_Var with(x:="total").
                                  simpl. try reflexivity. }
                                { eapply T_Add.
                                  { eapply T_Var with(x:="total").
                                    simpl. try reflexivity. }
                                  { eapply T_ArrayAccess.
                                    { eapply T_Var with(x:="counts").
                                      simpl. try reflexivity. }
                                    { eapply T_Sub.
                                      { eapply T_MethodInvocation with(m:="charAt").
                                        { eapply T_Var with(x:="s").
                                          simpl. try reflexivity. }
                                        { simpl. try reflexivity. }
                                        { simpl. try reflexivity. }
                                        { eapply T_List.
                                          { eapply T_Var with(x:="i").
                                            simpl. try reflexivity. }
                                          { eapply T_Nil. } }
                                        { simpl. try reflexivity. } }
                                      { eapply T_Char with(c:=97). }
                                      { simpl. try reflexivity. } } }
                                  { simpl. try reflexivity. } }
                                { simpl. try reflexivity. } }
                              { eapply T_Concat.
                                { eapply T_Expression.
                                  eapply T_PostDec.
                                  eapply T_ArrayAccess.
                                  { eapply T_Var with(x:="counts").
                                    simpl. try reflexivity. }
                                  { eapply T_Sub.
                                    { eapply T_MethodInvocation with(m:="charAt").
                                      { eapply T_Var with(x:="s").
                                        simpl. try reflexivity. }
                                      { simpl. try reflexivity. }
                                      { simpl. try reflexivity. }
                                      { eapply T_List.
                                        { eapply T_Var with(x:="i").
                                          simpl. try reflexivity. }
                                        { eapply T_Nil. } }
                                      { simpl. try reflexivity. } }
                                    { eapply T_Char with(c:=97). }
                                    { simpl. try reflexivity. } } }
                                { eapply T_Concat.
                                  { eapply T_Expression.
                                    eapply T_PostInc.
                                    eapply T_Var with(x:="left").
                                    simpl. try reflexivity. }
                                  { eapply T_Skip. } } } } }
                          { eapply T_Skip. } } } } }
                  { eapply T_Concat.
                    { eapply T_Return.
                      { eapply T_Var with(x:="total").
                        simpl. try reflexivity. }
                      { simpl. try reflexivity. }
                      { simpl. try reflexivity. } }
                    { eapply T_Skip. } } } } } } } } } } }
  Unshelve.
  all: apply STyVoid.
Defined.
Definition prog := the_exists_term (prog_well_typed).
Print prog.