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
      { eapply T_ClassDecl with(name:="ParallelogramArea").
        { simpl. try reflexivity. }
        { eapply T_MethodDecl with(modif:="public static")(T:=TyInt)(m:="parallelogramArea").
          { simpl. try reflexivity. }
          { eapply T_Concat.
            { eapply T_DeclNoInit with(T:=TyInt)(x:="b").
              simpl. try reflexivity. }
            { eapply T_Concat.
              { eapply T_DeclNoInit with(T:=TyInt)(x:="h").
                simpl. try reflexivity. }
              { eapply T_Skip. } } }
          { simpl. try reflexivity. }
          { eapply T_Concat.
            { eapply T_IfElse.
              { eapply T_And.
                { eapply T_Gt.
                  { eapply T_Var with(x:="b").
                    simpl. try reflexivity. }
                  { eapply T_Integer with(n:=0). }
                  { simpl. try reflexivity. } }
                { eapply T_Gt.
                  { eapply T_Var with(x:="h").
                    simpl. try reflexivity. }
                  { eapply T_Integer with(n:=0). }
                  { simpl. try reflexivity. } } }
              { eapply T_Concat.
                { eapply T_Return.
                  { eapply T_Mul.
                    { eapply T_Var with(x:="b").
                      simpl. try reflexivity. }
                    { eapply T_Var with(x:="h").
                      simpl. try reflexivity. } }
                  { simpl. try reflexivity. }
                  { simpl. try reflexivity. } }
                { eapply T_Skip. } }
              { eapply T_IfElse.
                { eapply T_And.
                  { eapply T_Gt.
                    { eapply T_Var with(x:="b").
                      simpl. try reflexivity. }
                    { eapply T_Integer with(n:=0). }
                    { simpl. try reflexivity. } }
                  { eapply T_Lt.
                    { eapply T_Var with(x:="h").
                      simpl. try reflexivity. }
                    { eapply T_Integer with(n:=0). }
                    { simpl. try reflexivity. } } }
                { eapply T_Concat.
                  { eapply T_Return.
                    { eapply T_Add.
                      { eapply T_Integer with(n:=1). }
                      { eapply T_MethodInvocationNoObj with(m:="parallelogramArea").
                        { simpl. try reflexivity. }
                        { eapply T_List.
                          { eapply T_Sub.
                            { eapply T_Var with(x:="b").
                              simpl. try reflexivity. }
                            { eapply T_Integer with(n:=1). }
                            { simpl. try reflexivity. } }
                          { eapply T_List.
                            { eapply T_Add.
                              { eapply T_Var with(x:="h").
                                simpl. try reflexivity. }
                              { eapply T_Integer with(n:=1). }
                              { simpl. try reflexivity. } }
                            { eapply T_Nil. } } }
                        { simpl. try reflexivity. } }
                      { simpl. try reflexivity. } }
                    { simpl. try reflexivity. }
                    { simpl. try reflexivity. } }
                  { eapply T_Skip. } }
                { eapply T_Concat.
                  { eapply T_Return.
                    { eapply T_Add.
                      { eapply T_Integer with(n:=1). }
                      { eapply T_MethodInvocationNoObj with(m:="parallelogramArea").
                        { simpl. try reflexivity. }
                        { eapply T_List.
                          { eapply T_Var with(x:="b").
                            simpl. try reflexivity. }
                          { eapply T_List.
                            { eapply T_Sub.
                              { eapply T_Var with(x:="h").
                                simpl. try reflexivity. }
                              { eapply T_Integer with(n:=1). }
                              { simpl. try reflexivity. } }
                            { eapply T_Nil. } } }
                        { simpl. try reflexivity. } }
                      { simpl. try reflexivity. } }
                    { simpl. try reflexivity. }
                    { simpl. try reflexivity. } }
                  { eapply T_Skip. } } } }
            { eapply T_Skip. } } } } } } }
  Unshelve.
  all: apply STyVoid.
Defined.
Definition prog := the_exists_term (prog_well_typed).
Print prog.