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
      { eapply T_ClassDecl with(name:="IsDecimal").
        { simpl. try reflexivity. }
        { eapply T_MethodDecl with(modif:="public static")(T:=TyBool)(m:="isDecimal").
          { simpl. try reflexivity. }
          { eapply T_Concat.
            { eapply T_DeclNoInit with(T:=TyString)(x:="num").
              simpl. try reflexivity. }
            { eapply T_Skip. } }
          { simpl. try reflexivity. }
          { eapply T_Concat.
            { eapply T_If.
              { eapply T_Eq.
                { eapply T_MethodInvocation with(m:="length").
                  { eapply T_Var with(x:="num").
                    simpl. try reflexivity. }
                  { simpl. try reflexivity. }
                  { simpl. try reflexivity. }
                  { eapply T_Nil. }
                  { simpl. try reflexivity. } }
                { eapply T_Integer with(n:=1). }
                { simpl. try reflexivity. } }
              { eapply T_Concat.
                { eapply T_Return.
                  { eapply T_Not.
                    eapply T_MethodInvocationNoObj with(m:="isDecimal").
                    { simpl. try reflexivity. }
                    { eapply T_List.
                      { eapply T_String with(s:="123.11"). }
                      { eapply T_Nil. } }
                    { simpl. try reflexivity. } }
                  { simpl. try reflexivity. }
                  { simpl. try reflexivity. } }
                { eapply T_Skip. } } }
            { eapply T_Concat.
              { eapply T_Concat.
                { eapply T_DeclInit with(T:=TyInt)(x:="prec").
                  { simpl. try reflexivity. }
                  { eapply T_Integer with(n:=0). }
                  { simpl. try reflexivity. } }
                { eapply T_Concat.
                  { eapply T_DeclInit with(T:=TyInt)(x:="scale").
                    { simpl. try reflexivity. }
                    { eapply T_Integer with(n:=3). }
                    { simpl. try reflexivity. } }
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
                      { eapply T_Var with(x:="num").
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
                      { eapply T_DeclInit with(T:=TyChar)(x:="c").
                        { simpl. try reflexivity. }
                        { eapply T_MethodInvocation with(m:="charAt").
                          { eapply T_Var with(x:="num").
                            simpl. try reflexivity. }
                          { simpl. try reflexivity. }
                          { simpl. try reflexivity. }
                          { eapply T_List.
                            { eapply T_Var with(x:="i").
                              simpl. try reflexivity. }
                            { eapply T_Nil. } }
                          { simpl. try reflexivity. } }
                        { simpl. try reflexivity. } }
                      { eapply T_Skip. } }
                    { eapply T_Concat.
                      { eapply T_If.
                        { eapply T_And.
                          { eapply T_Ge.
                            { eapply T_Var with(x:="c").
                              simpl. try reflexivity. }
                            { eapply T_Var with(x:="prec").
                              simpl. try reflexivity. }
                            { simpl. try reflexivity. } }
                          { eapply T_Le.
                            { eapply T_Var with(x:="c").
                              simpl. try reflexivity. }
                            { eapply T_Var with(x:="scale").
                              simpl. try reflexivity. }
                            { simpl. try reflexivity. } } }
                        { eapply T_Concat.
                          { eapply T_Return.
                            { eapply T_True. }
                            { simpl. try reflexivity. }
                            { simpl. try reflexivity. } }
                          { eapply T_Skip. } } }
                      { eapply T_Concat.
                        { eapply T_If.
                          { eapply T_Or.
                            { eapply T_Lt.
                              { eapply T_Var with(x:="c").
                                simpl. try reflexivity. }
                              { eapply T_Char with(c:=48). }
                              { simpl. try reflexivity. } }
                            { eapply T_Gt.
                              { eapply T_Var with(x:="c").
                                simpl. try reflexivity. }
                              { eapply T_Char with(c:=57). }
                              { simpl. try reflexivity. } } }
                          { eapply T_Concat.
                            { eapply T_Return.
                              { eapply T_False. }
                              { simpl. try reflexivity. }
                              { simpl. try reflexivity. } }
                            { eapply T_Skip. } } }
                        { eapply T_Concat.
                          { eapply T_Expression.
                            eapply T_Assign.
                            { eapply T_Var with(x:="prec").
                              simpl. try reflexivity. }
                            { eapply T_Sub.
                              { eapply T_Add.
                                { eapply T_Mul.
                                  { eapply T_Var with(x:="prec").
                                    simpl. try reflexivity. }
                                  { eapply T_Integer with(n:=10). } }
                                { eapply T_Var with(x:="c").
                                  simpl. try reflexivity. }
                                { simpl. try reflexivity. } }
                              { eapply T_Char with(c:=48). }
                              { simpl. try reflexivity. } }
                            { simpl. try reflexivity. } }
                          { eapply T_Concat.
                            { eapply T_Expression.
                              eapply T_Assign.
                              { eapply T_Var with(x:="scale").
                                simpl. try reflexivity. }
                              { eapply T_Sub.
                                { eapply T_Add.
                                  { eapply T_Mul.
                                    { eapply T_Var with(x:="scale").
                                      simpl. try reflexivity. }
                                    { eapply T_Integer with(n:=10). } }
                                  { eapply T_Var with(x:="c").
                                    simpl. try reflexivity. }
                                  { simpl. try reflexivity. } }
                                { eapply T_Char with(c:=48). }
                                { simpl. try reflexivity. } }
                              { simpl. try reflexivity. } }
                            { eapply T_Skip. } } } } } } }
                { eapply T_Concat.
                  { eapply T_Return.
                    { eapply T_False. }
                    { simpl. try reflexivity. }
                    { simpl. try reflexivity. } }
                  { eapply T_Skip. } } } } } } } } } }
  Unshelve.
  all: apply STyVoid.
Defined.
Definition prog := the_exists_term (prog_well_typed).
Print prog.