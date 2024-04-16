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
      { eapply T_ClassDecl with(name:="MultiList").
        { simpl. try reflexivity. }
        { eapply T_MethodDecl with(modif:="public static")(T:=(TyGeneric1 "List" (TyGeneric1 "List" TyInt)))(m:="multiList").
          { simpl. try reflexivity. }
          { eapply T_Concat.
            { eapply T_DeclNoInit with(T:=TyInt)(x:="rownum").
              simpl. try reflexivity. }
            { eapply T_Concat.
              { eapply T_DeclNoInit with(T:=TyInt)(x:="colnum").
                simpl. try reflexivity. }
              { eapply T_Skip. } } }
          { simpl. try reflexivity. }
          { eapply T_Concat.
            { eapply T_Concat.
              { eapply T_DeclInit with(T:=(TyGeneric1 "List" (TyGeneric1 "List" TyInt)))(x:="result").
                { simpl. try reflexivity. }
                { eapply T_New' with(T:=(TyGeneric0 "ArrayList")).
                  { simpl. try reflexivity. }
                  { eapply T_Nil. } }
                { simpl. try reflexivity. } }
              { eapply T_Skip. } }
            { eapply T_Concat.
              { eapply T_Concat.
                { eapply T_DeclInit with(T:=(TyArray (TyArray TyInt)))(x:="matrix").
                  { simpl. try reflexivity. }
                  { eapply T_NewArrayNoInit' with(T:=TyInt).
                    { eapply T_Var with(x:="rownum").
                      simpl. try reflexivity. }
                    { eapply T_NewArrayNoInit' with(T:=TyInt).
                      { eapply T_Var with(x:="colnum").
                        simpl. try reflexivity. }
                      { eapply T_NewArrayNoInit with(T:=TyInt). } } }
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
                      { eapply T_Var with(x:="matrix").
                        simpl. try reflexivity. }
                      { simpl. try reflexivity. }
                      { simpl. try reflexivity. } }
                    { simpl. try reflexivity. } }
                  { eapply T_PostInc.
                    eapply T_Var with(x:="i").
                    simpl. try reflexivity. }
                  { eapply T_Concat.
                    { eapply T_For.
                      { eapply T_Concat.
                        { eapply T_DeclInit with(T:=TyInt)(x:="j").
                          { simpl. try reflexivity. }
                          { eapply T_Integer with(n:=0). }
                          { simpl. try reflexivity. } }
                        { eapply T_Skip. } }
                      { eapply T_Lt.
                        { eapply T_Var with(x:="j").
                          simpl. try reflexivity. }
                        { eapply T_FieldAccess with(f:="length").
                          { eapply T_ArrayAccess.
                            { eapply T_Var with(x:="matrix").
                              simpl. try reflexivity. }
                            { eapply T_Integer with(n:=0). } }
                          { simpl. try reflexivity. }
                          { simpl. try reflexivity. } }
                        { simpl. try reflexivity. } }
                      { eapply T_PostInc.
                        eapply T_Var with(x:="j").
                        simpl. try reflexivity. }
                      { eapply T_Concat.
                        { eapply T_Expression.
                          eapply T_Assign.
                          { eapply T_ArrayAccess.
                            { eapply T_ArrayAccess.
                              { eapply T_Var with(x:="matrix").
                                simpl. try reflexivity. }
                              { eapply T_Var with(x:="i").
                                simpl. try reflexivity. } }
                            { eapply T_Var with(x:="j").
                              simpl. try reflexivity. } }
                          { eapply T_Mul.
                            { eapply T_Var with(x:="i").
                              simpl. try reflexivity. }
                            { eapply T_Var with(x:="j").
                              simpl. try reflexivity. } }
                          { simpl. try reflexivity. } }
                        { eapply T_Skip. } } }
                    { eapply T_Skip. } } }
                { eapply T_Concat.
                  { eapply T_For.
                    { eapply T_Concat.
                      { eapply T_DeclInit with(T:=TyInt)(x:="r").
                        { simpl. try reflexivity. }
                        { eapply T_Integer with(n:=0). }
                        { simpl. try reflexivity. } }
                      { eapply T_Skip. } }
                    { eapply T_Lt.
                      { eapply T_Var with(x:="r").
                        simpl. try reflexivity. }
                      { eapply T_Var with(x:="rownum").
                        simpl. try reflexivity. }
                      { simpl. try reflexivity. } }
                    { eapply T_PostInc.
                      eapply T_Var with(x:="r").
                      simpl. try reflexivity. }
                    { eapply T_Concat.
                      { eapply T_Concat.
                        { eapply T_DeclInit with(T:=(TyGeneric1 "List" TyInt))(x:="row").
                          { simpl. try reflexivity. }
                          { eapply T_New' with(T:=(TyGeneric0 "ArrayList")).
                            { simpl. try reflexivity. }
                            { eapply T_Nil. } }
                          { simpl. try reflexivity. } }
                        { eapply T_Skip. } }
                      { eapply T_Concat.
                        { eapply T_For.
                          { eapply T_Concat.
                            { eapply T_DeclInit with(T:=TyInt)(x:="c").
                              { simpl. try reflexivity. }
                              { eapply T_Integer with(n:=0). }
                              { simpl. try reflexivity. } }
                            { eapply T_Skip. } }
                          { eapply T_Lt.
                            { eapply T_Var with(x:="c").
                              simpl. try reflexivity. }
                            { eapply T_Var with(x:="colnum").
                              simpl. try reflexivity. }
                            { simpl. try reflexivity. } }
                          { eapply T_PostInc.
                            eapply T_Var with(x:="c").
                            simpl. try reflexivity. }
                          { eapply T_Concat.
                            { eapply T_Expression.
                              eapply T_MethodInvocation with(m:="add").
                              { eapply T_Var with(x:="row").
                                simpl. try reflexivity. }
                              { simpl. try reflexivity. }
                              { simpl. try reflexivity. }
                              { eapply T_List.
                                { eapply T_ArrayAccess.
                                  { eapply T_ArrayAccess.
                                    { eapply T_Var with(x:="matrix").
                                      simpl. try reflexivity. }
                                    { eapply T_Var with(x:="r").
                                      simpl. try reflexivity. } }
                                  { eapply T_Var with(x:="c").
                                    simpl. try reflexivity. } }
                                { eapply T_Nil. } }
                              { simpl. try reflexivity. } }
                            { eapply T_Skip. } } }
                        { eapply T_Concat.
                          { eapply T_Expression.
                            eapply T_MethodInvocation with(m:="add").
                            { eapply T_Var with(x:="result").
                              simpl. try reflexivity. }
                            { simpl. try reflexivity. }
                            { simpl. try reflexivity. }
                            { eapply T_List.
                              { eapply T_Var with(x:="row").
                                simpl. try reflexivity. }
                              { eapply T_Nil. } }
                            { simpl. try reflexivity. } }
                          { eapply T_Skip. } } } } }
                  { eapply T_Concat.
                    { eapply T_Return.
                      { eapply T_Var with(x:="result").
                        simpl. try reflexivity. }
                      { simpl. try reflexivity. }
                      { simpl. try reflexivity. } }
                    { eapply T_Skip. } } } } } } } } } } }
  Unshelve.
  all: apply STyVoid.
Defined.
Definition prog := the_exists_term (prog_well_typed).
Print prog.