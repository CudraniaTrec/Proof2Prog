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
      { eapply T_ClassDecl with(name:="Array3d").
        { simpl. try reflexivity. }
        { eapply T_MethodDecl with(modif:="public static")(T:=(TyGeneric1 "List" (TyGeneric1 "List" (TyGeneric1 "List" TyString))))(m:="array3d").
          { simpl. try reflexivity. }
          { eapply T_Concat.
            { eapply T_DeclNoInit with(T:=TyInt)(x:="m").
              simpl. try reflexivity. }
            { eapply T_Concat.
              { eapply T_DeclNoInit with(T:=TyInt)(x:="n").
                simpl. try reflexivity. }
              { eapply T_Concat.
                { eapply T_DeclNoInit with(T:=TyInt)(x:="o").
                  simpl. try reflexivity. }
                { eapply T_Skip. } } } }
          { simpl. try reflexivity. }
          { eapply T_Concat.
            { eapply T_Concat.
              { eapply T_DeclInit with(T:=(TyGeneric1 "List" (TyGeneric1 "List" (TyGeneric1 "List" TyString))))(x:="output").
                { simpl. try reflexivity. }
                { eapply T_New' with(T:=(TyGeneric0 "ArrayList")).
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
                  { eapply T_Var with(x:="o").
                    simpl. try reflexivity. }
                  { simpl. try reflexivity. } }
                { eapply T_PostInc.
                  eapply T_Var with(x:="i").
                  simpl. try reflexivity. }
                { eapply T_Concat.
                  { eapply T_Concat.
                    { eapply T_DeclInit with(T:=(TyGeneric1 "List" (TyGeneric1 "List" TyString)))(x:="row").
                      { simpl. try reflexivity. }
                      { eapply T_New' with(T:=(TyGeneric0 "ArrayList")).
                        { simpl. try reflexivity. }
                        { eapply T_Nil. } }
                      { simpl. try reflexivity. } }
                    { eapply T_Skip. } }
                  { eapply T_Concat.
                    { eapply T_Expression.
                      eapply T_MethodInvocation with(m:="add").
                      { eapply T_Var with(x:="output").
                        simpl. try reflexivity. }
                      { simpl. try reflexivity. }
                      { simpl. try reflexivity. }
                      { eapply T_List.
                        { eapply T_Var with(x:="row").
                          simpl. try reflexivity. }
                        { eapply T_Nil. } }
                      { simpl. try reflexivity. } }
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
                          { eapply T_Var with(x:="n").
                            simpl. try reflexivity. }
                          { simpl. try reflexivity. } }
                        { eapply T_PostInc.
                          eapply T_Var with(x:="j").
                          simpl. try reflexivity. }
                        { eapply T_Concat.
                          { eapply T_Concat.
                            { eapply T_DeclInit with(T:=(TyGeneric1 "List" TyString))(x:="curr").
                              { simpl. try reflexivity. }
                              { eapply T_New' with(T:=(TyGeneric0 "ArrayList")).
                                { simpl. try reflexivity. }
                                { eapply T_Nil. } }
                              { simpl. try reflexivity. } }
                            { eapply T_Skip. } }
                          { eapply T_Concat.
                            { eapply T_Expression.
                              eapply T_MethodInvocation with(m:="add").
                              { eapply T_Var with(x:="row").
                                simpl. try reflexivity. }
                              { simpl. try reflexivity. }
                              { simpl. try reflexivity. }
                              { eapply T_List.
                                { eapply T_Var with(x:="curr").
                                  simpl. try reflexivity. }
                                { eapply T_Nil. } }
                              { simpl. try reflexivity. } }
                            { eapply T_Concat.
                              { eapply T_For.
                                { eapply T_Concat.
                                  { eapply T_DeclInit with(T:=TyInt)(x:="k").
                                    { simpl. try reflexivity. }
                                    { eapply T_Integer with(n:=0). }
                                    { simpl. try reflexivity. } }
                                  { eapply T_Skip. } }
                                { eapply T_Lt.
                                  { eapply T_Var with(x:="k").
                                    simpl. try reflexivity. }
                                  { eapply T_Var with(x:="m").
                                    simpl. try reflexivity. }
                                  { simpl. try reflexivity. } }
                                { eapply T_PostInc.
                                  eapply T_Var with(x:="k").
                                  simpl. try reflexivity. }
                                { eapply T_Concat.
                                  { eapply T_Expression.
                                    eapply T_MethodInvocation with(m:="add").
                                    { eapply T_Var with(x:="curr").
                                      simpl. try reflexivity. }
                                    { simpl. try reflexivity. }
                                    { simpl. try reflexivity. }
                                    { eapply T_List.
                                      { eapply T_String with(s:="*"). }
                                      { eapply T_Nil. } }
                                    { simpl. try reflexivity. } }
                                  { eapply T_Skip. } } }
                              { eapply T_Skip. } } } } }
                      { eapply T_Skip. } } } } }
              { eapply T_Concat.
                { eapply T_Return.
                  { eapply T_Var with(x:="output").
                    simpl. try reflexivity. }
                  { simpl. try reflexivity. }
                  { simpl. try reflexivity. } }
                { eapply T_Skip. } } } } } } } } }
  Unshelve.
  all: apply STyVoid.
Defined.
Definition prog := the_exists_term (prog_well_typed).
Print prog.