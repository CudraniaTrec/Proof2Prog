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
      { eapply T_ClassDecl with(name:="RearrangeBigger").
        { simpl. try reflexivity. }
        { eapply T_MethodDecl with(modif:="public static")(T:=(TyExternal "Object"))(m:="rearrangeBigger").
          { simpl. try reflexivity. }
          { eapply T_Concat.
            { eapply T_DeclNoInit with(T:=TyInt)(x:="n").
              simpl. try reflexivity. }
            { eapply T_Skip. } }
          { simpl. try reflexivity. }
          { eapply T_Concat.
            { eapply T_Concat.
              { eapply T_DeclInit with(T:=TyString)(x:="s").
                { simpl. try reflexivity. }
                { eapply T_TyMethodInvocation with(m:="valueOf")(T:=(TyExternal "String")).
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
                { eapply T_DeclInit with(T:=(TyArray TyChar))(x:="c").
                  { simpl. try reflexivity. }
                  { eapply T_MethodInvocation with(m:="toCharArray").
                    { eapply T_Var with(x:="s").
                      simpl. try reflexivity. }
                    { simpl. try reflexivity. }
                    { simpl. try reflexivity. }
                    { eapply T_Nil. }
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
                  { eapply T_While.
                    { eapply T_Lt.
                      { eapply T_Var with(x:="i").
                        simpl. try reflexivity. }
                      { eapply T_Sub.
                        { eapply T_FieldAccess with(f:="length").
                          { eapply T_Var with(x:="c").
                            simpl. try reflexivity. }
                          { simpl. try reflexivity. }
                          { simpl. try reflexivity. } }
                        { eapply T_Integer with(n:=1). }
                        { simpl. try reflexivity. } }
                      { simpl. try reflexivity. } }
                    { eapply T_Concat.
                      { eapply T_If.
                        { eapply T_Lt.
                          { eapply T_ArrayAccess.
                            { eapply T_Var with(x:="c").
                              simpl. try reflexivity. }
                            { eapply T_Var with(x:="i").
                              simpl. try reflexivity. } }
                          { eapply T_ArrayAccess.
                            { eapply T_Var with(x:="c").
                              simpl. try reflexivity. }
                            { eapply T_Add.
                              { eapply T_Var with(x:="i").
                                simpl. try reflexivity. }
                              { eapply T_Integer with(n:=1). }
                              { simpl. try reflexivity. } } }
                          { simpl. try reflexivity. } }
                        { eapply T_Concat.
                          { eapply T_Break. }
                          { eapply T_Skip. } } }
                      { eapply T_Concat.
                        { eapply T_Expression.
                          eapply T_PostInc.
                          eapply T_Var with(x:="i").
                          simpl. try reflexivity. }
                        { eapply T_Skip. } } } }
                  { eapply T_Concat.
                    { eapply T_If.
                      { eapply T_Eq.
                        { eapply T_Var with(x:="i").
                          simpl. try reflexivity. }
                        { eapply T_Sub.
                          { eapply T_FieldAccess with(f:="length").
                            { eapply T_Var with(x:="c").
                              simpl. try reflexivity. }
                            { simpl. try reflexivity. }
                            { simpl. try reflexivity. } }
                          { eapply T_Integer with(n:=1). }
                          { simpl. try reflexivity. } }
                        { simpl. try reflexivity. } }
                      { eapply T_Concat.
                        { eapply T_Return.
                          { eapply T_False. }
                          { simpl. try reflexivity. }
                          { simpl. try reflexivity. } }
                        { eapply T_Skip. } } }
                    { eapply T_Concat.
                      { eapply T_Concat.
                        { eapply T_DeclInit with(T:=TyInt)(x:="j").
                          { simpl. try reflexivity. }
                          { eapply T_Sub.
                            { eapply T_FieldAccess with(f:="length").
                              { eapply T_Var with(x:="c").
                                simpl. try reflexivity. }
                              { simpl. try reflexivity. }
                              { simpl. try reflexivity. } }
                            { eapply T_Integer with(n:=1). }
                            { simpl. try reflexivity. } }
                          { simpl. try reflexivity. } }
                        { eapply T_Skip. } }
                      { eapply T_Concat.
                        { eapply T_While.
                          { eapply T_Gt.
                            { eapply T_Var with(x:="j").
                              simpl. try reflexivity. }
                            { eapply T_Var with(x:="i").
                              simpl. try reflexivity. }
                            { simpl. try reflexivity. } }
                          { eapply T_Concat.
                            { eapply T_If.
                              { eapply T_Gt.
                                { eapply T_ArrayAccess.
                                  { eapply T_Var with(x:="c").
                                    simpl. try reflexivity. }
                                  { eapply T_Var with(x:="j").
                                    simpl. try reflexivity. } }
                                { eapply T_ArrayAccess.
                                  { eapply T_Var with(x:="c").
                                    simpl. try reflexivity. }
                                  { eapply T_Var with(x:="i").
                                    simpl. try reflexivity. } }
                                { simpl. try reflexivity. } }
                              { eapply T_Concat.
                                { eapply T_Break. }
                                { eapply T_Skip. } } }
                            { eapply T_Concat.
                              { eapply T_Expression.
                                eapply T_PostDec.
                                eapply T_Var with(x:="j").
                                simpl. try reflexivity. }
                              { eapply T_Skip. } } } }
                        { eapply T_Concat.
                          { eapply T_Concat.
                            { eapply T_DeclInit with(T:=TyChar)(x:="tmp").
                              { simpl. try reflexivity. }
                              { eapply T_ArrayAccess.
                                { eapply T_Var with(x:="c").
                                  simpl. try reflexivity. }
                                { eapply T_Var with(x:="i").
                                  simpl. try reflexivity. } }
                              { simpl. try reflexivity. } }
                            { eapply T_Skip. } }
                          { eapply T_Concat.
                            { eapply T_Expression.
                              eapply T_Assign.
                              { eapply T_ArrayAccess.
                                { eapply T_Var with(x:="c").
                                  simpl. try reflexivity. }
                                { eapply T_Var with(x:="i").
                                  simpl. try reflexivity. } }
                              { eapply T_ArrayAccess.
                                { eapply T_Var with(x:="c").
                                  simpl. try reflexivity. }
                                { eapply T_Var with(x:="j").
                                  simpl. try reflexivity. } }
                              { simpl. try reflexivity. } }
                            { eapply T_Concat.
                              { eapply T_Expression.
                                eapply T_Assign.
                                { eapply T_ArrayAccess.
                                  { eapply T_Var with(x:="c").
                                    simpl. try reflexivity. }
                                  { eapply T_Var with(x:="j").
                                    simpl. try reflexivity. } }
                                { eapply T_Var with(x:="tmp").
                                  simpl. try reflexivity. }
                                { simpl. try reflexivity. } }
                              { eapply T_Concat.
                                { eapply T_Concat.
                                  { eapply T_DeclInit with(T:=(TyExternal "StringBuilder"))(x:="sb").
                                    { simpl. try reflexivity. }
                                    { eapply T_New' with(T:=(TyExternal "StringBuilder")).
                                      { simpl. try reflexivity. }
                                      { eapply T_Nil. } }
                                    { simpl. try reflexivity. } }
                                  { eapply T_Skip. } }
                                { eapply T_Concat.
                                  { eapply T_Foreach with(T:=TyChar)(x:="c1").
                                    { simpl. try reflexivity. }
                                    { eapply T_Var with(x:="c").
                                      simpl. try reflexivity. }
                                    { simpl. try reflexivity. }
                                    { eapply T_Concat.
                                      { eapply T_Expression.
                                        eapply T_MethodInvocation with(m:="append").
                                        { eapply T_Var with(x:="sb").
                                          simpl. try reflexivity. }
                                        { simpl. try reflexivity. }
                                        { simpl. try reflexivity. }
                                        { eapply T_List.
                                          { eapply T_Var with(x:="c1").
                                            simpl. try reflexivity. }
                                          { eapply T_Nil. } }
                                        { simpl. try reflexivity. } }
                                      { eapply T_Skip. } } }
                                  { eapply T_Concat.
                                    { eapply T_Return.
                                      { eapply T_TyMethodInvocation with(m:="valueOf")(T:=(TyExternal "Integer")).
                                        { simpl. try reflexivity. }
                                        { simpl. try reflexivity. }
                                        { eapply T_List.
                                          { eapply T_MethodInvocation with(m:="toString").
                                            { eapply T_Var with(x:="sb").
                                              simpl. try reflexivity. }
                                            { simpl. try reflexivity. }
                                            { simpl. try reflexivity. }
                                            { eapply T_Nil. }
                                            { simpl. try reflexivity. } }
                                          { eapply T_Nil. } }
                                        { simpl. try reflexivity. } }
                                      { simpl. try reflexivity. }
                                      { simpl. try reflexivity. } }
                                    { eapply T_Skip. } } } } } } } } } } } } } } } } } } }
  Unshelve.
  all: apply STyVoid.
Defined.
Definition prog := the_exists_term (prog_well_typed).
Print prog.