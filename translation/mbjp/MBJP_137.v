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
      { eapply T_ClassDecl with(name:="ZeroCount").
        { simpl. try reflexivity. }
        { eapply T_MethodDecl with(modif:="public static")(T:=TyDouble)(m:="zeroCount").
          { simpl. try reflexivity. }
          { eapply T_Concat.
            { eapply T_DeclNoInit with(T:=(TyGeneric1 "List" TyInt))(x:="nums").
              simpl. try reflexivity. }
            { eapply T_Skip. } }
          { simpl. try reflexivity. }
          { eapply T_Concat.
            { eapply T_Concat.
              { eapply T_DeclInit with(T:=TyInt)(x:="counter").
                { simpl. try reflexivity. }
                { eapply T_Integer with(n:=0). }
                { simpl. try reflexivity. } }
              { eapply T_Skip. } }
            { eapply T_Concat.
              { eapply T_Foreach with(T:=TyInt)(x:="num").
                { simpl. try reflexivity. }
                { eapply T_Var with(x:="nums").
                  simpl. try reflexivity. }
                { simpl. try reflexivity. }
                { eapply T_Concat.
                  { eapply T_Expression.
                    eapply T_Assign.
                    { eapply T_Var with(x:="counter").
                      simpl. try reflexivity. }
                    { eapply T_Add.
                      { eapply T_Var with(x:="counter").
                        simpl. try reflexivity. }
                      { eapply T_Choose.
                        { eapply T_Eq.
                          { eapply T_Var with(x:="num").
                            simpl. try reflexivity. }
                          { eapply T_Integer with(n:=0). }
                          { simpl. try reflexivity. } }
                        { eapply T_Integer with(n:=1). }
                        { eapply T_Integer with(n:=0). }
                        { simpl. try reflexivity. } }
                      { simpl. try reflexivity. } }
                    { simpl. try reflexivity. } }
                  { eapply T_Skip. } } }
              { eapply T_Concat.
                { eapply T_Concat.
                  { eapply T_DeclInit with(T:=TyDouble)(x:="ratio").
                    { simpl. try reflexivity. }
                    { eapply T_Div.
                      { eapply T_Conversion with(T:=TyDouble).
                        { eapply T_Var with(x:="counter").
                          simpl. try reflexivity. }
                        { simpl. try reflexivity. } }
                      { eapply T_MethodInvocation with(m:="size").
                        { eapply T_Var with(x:="nums").
                          simpl. try reflexivity. }
                        { simpl. try reflexivity. }
                        { simpl. try reflexivity. }
                        { eapply T_Nil. }
                        { simpl. try reflexivity. } } }
                    { simpl. try reflexivity. } }
                  { eapply T_Skip. } }
                { eapply T_Concat.
                  { eapply T_Return.
                    { eapply T_Div.
                      { eapply T_TyMethodInvocation with(m:="floor")(T:=(TyExternal "Math")).
                        { simpl. try reflexivity. }
                        { simpl. try reflexivity. }
                        { eapply T_List.
                          { eapply T_Mul.
                            { eapply T_Var with(x:="ratio").
                              simpl. try reflexivity. }
                            { eapply T_Integer with(n:=100). } }
                          { eapply T_Nil. } }
                        { simpl. try reflexivity. } }
                      { eapply T_Float with(f:=100.0%float). } }
                    { simpl. try reflexivity. }
                    { simpl. try reflexivity. } }
                  { eapply T_Skip. } } } } } } } } } }
  Unshelve.
  all: apply STyVoid.
Defined.
Definition prog := the_exists_term (prog_well_typed).
Print prog.