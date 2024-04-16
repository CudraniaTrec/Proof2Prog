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
      { eapply T_ClassDecl with(name:="FindKProduct").
        { simpl. try reflexivity. }
        { eapply T_MethodDecl with(modif:="public static")(T:=TyInt)(m:="findKProduct").
          { simpl. try reflexivity. }
          { eapply T_Concat.
            { eapply T_DeclNoInit with(T:=(TyGeneric1 "List" (TyGeneric1 "List" TyInt)))(x:="testList").
              simpl. try reflexivity. }
            { eapply T_Concat.
              { eapply T_DeclNoInit with(T:=TyInt)(x:="k").
                simpl. try reflexivity. }
              { eapply T_Skip. } } }
          { simpl. try reflexivity. }
          { eapply T_Concat.
            { eapply T_Concat.
              { eapply T_DeclInit with(T:=TyInt)(x:="product").
                { simpl. try reflexivity. }
                { eapply T_Integer with(n:=1). }
                { simpl. try reflexivity. } }
              { eapply T_Skip. } }
            { eapply T_Concat.
              { eapply T_Concat.
                { eapply T_DeclInit with(T:=(TyArray TyInt))(x:="arr").
                  { simpl. try reflexivity. }
                  { eapply T_NewArrayNoInit' with(T:=TyInt).
                    { eapply T_MethodInvocation with(m:="size").
                      { eapply T_Var with(x:="testList").
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
                  { eapply T_DeclInit with(T:=(TyGeneric2 "HashMap" TyInt TyInt))(x:="map").
                    { simpl. try reflexivity. }
                    { eapply T_New' with(T:=(TyGeneric0 "HashMap")).
                      { simpl. try reflexivity. }
                      { eapply T_Nil. } }
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
                      { eapply T_MethodInvocation with(m:="size").
                        { eapply T_Var with(x:="testList").
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
                        eapply T_Assign.
                        { eapply T_ArrayAccess.
                          { eapply T_Var with(x:="arr").
                            simpl. try reflexivity. }
                          { eapply T_Var with(x:="i").
                            simpl. try reflexivity. } }
                        { eapply T_MethodInvocation with(m:="get").
                          { eapply T_MethodInvocation with(m:="get").
                            { eapply T_Var with(x:="testList").
                              simpl. try reflexivity. }
                            { simpl. try reflexivity. }
                            { simpl. try reflexivity. }
                            { eapply T_List.
                              { eapply T_Var with(x:="i").
                                simpl. try reflexivity. }
                              { eapply T_Nil. } }
                            { simpl. try reflexivity. } }
                          { simpl. try reflexivity. }
                          { simpl. try reflexivity. }
                          { eapply T_List.
                            { eapply T_Var with(x:="k").
                              simpl. try reflexivity. }
                            { eapply T_Nil. } }
                          { simpl. try reflexivity. } }
                        { simpl. try reflexivity. } }
                      { eapply T_Concat.
                        { eapply T_Expression.
                          eapply T_MethodInvocation with(m:="put").
                          { eapply T_Var with(x:="map").
                            simpl. try reflexivity. }
                          { simpl. try reflexivity. }
                          { simpl. try reflexivity. }
                          { eapply T_List.
                            { eapply T_ArrayAccess.
                              { eapply T_Var with(x:="arr").
                                simpl. try reflexivity. }
                              { eapply T_Var with(x:="i").
                                simpl. try reflexivity. } }
                            { eapply T_List.
                              { eapply T_Add.
                                { eapply T_MethodInvocation with(m:="getOrDefault").
                                  { eapply T_Var with(x:="map").
                                    simpl. try reflexivity. }
                                  { simpl. try reflexivity. }
                                  { simpl. try reflexivity. }
                                  { eapply T_List.
                                    { eapply T_ArrayAccess.
                                      { eapply T_Var with(x:="arr").
                                        simpl. try reflexivity. }
                                      { eapply T_Var with(x:="i").
                                        simpl. try reflexivity. } }
                                    { eapply T_List.
                                      { eapply T_Integer with(n:=0). }
                                      { eapply T_Nil. } } }
                                  { simpl. try reflexivity. } }
                                { eapply T_Integer with(n:=1). }
                                { simpl. try reflexivity. } }
                              { eapply T_Nil. } } }
                          { simpl. try reflexivity. } }
                        { eapply T_Skip. } } } }
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
                        { eapply T_MethodInvocation with(m:="size").
                          { eapply T_Var with(x:="testList").
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
                          eapply T_Assign.
                          { eapply T_Var with(x:="product").
                            simpl. try reflexivity. }
                          { eapply T_Mul.
                            { eapply T_Var with(x:="product").
                              simpl. try reflexivity. }
                            { eapply T_ArrayAccess.
                              { eapply T_Var with(x:="arr").
                                simpl. try reflexivity. }
                              { eapply T_Var with(x:="i").
                                simpl. try reflexivity. } } }
                          { simpl. try reflexivity. } }
                        { eapply T_Skip. } } }
                    { eapply T_Concat.
                      { eapply T_Return.
                        { eapply T_Var with(x:="product").
                          simpl. try reflexivity. }
                        { simpl. try reflexivity. }
                        { simpl. try reflexivity. } }
                      { eapply T_Skip. } } } } } } } } } } } }
  Unshelve.
  all: apply STyVoid.
Defined.
Definition prog := the_exists_term (prog_well_typed).
Print prog.