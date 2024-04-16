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
      { eapply T_ClassDecl with(name:="RombusArea").
        { simpl. try reflexivity. }
        { eapply T_MethodDecl with(modif:="public static")(T:=TyInt)(m:="rombusArea").
          { simpl. try reflexivity. }
          { eapply T_Concat.
            { eapply T_DeclNoInit with(T:=TyInt)(x:="p").
              simpl. try reflexivity. }
            { eapply T_Concat.
              { eapply T_DeclNoInit with(T:=TyInt)(x:="q").
                simpl. try reflexivity. }
              { eapply T_Skip. } } }
          { simpl. try reflexivity. }
          { eapply T_Concat.
            { eapply T_Concat.
              { eapply T_DeclInit with(T:=TyInt)(x:="area").
                { simpl. try reflexivity. }
                { eapply T_Integer with(n:=0). }
                { simpl. try reflexivity. } }
              { eapply T_Skip. } }
            { eapply T_Concat.
              { eapply T_IfElse.
                { eapply T_Eq.
                  { eapply T_Var with(x:="p").
                    simpl. try reflexivity. }
                  { eapply T_Var with(x:="q").
                    simpl. try reflexivity. }
                  { simpl. try reflexivity. } }
                { eapply T_Expression.
                  eapply T_Assign.
                  { eapply T_Var with(x:="area").
                    simpl. try reflexivity. }
                  { eapply T_Conversion with(T:=TyInt).
                    { eapply T_Add.
                      { eapply T_Mul.
                        { eapply T_Integer with(n:=5). }
                        { eapply T_TyMethodInvocation with(m:="sqrt")(T:=(TyExternal "Math")).
                          { simpl. try reflexivity. }
                          { simpl. try reflexivity. }
                          { eapply T_List.
                            { eapply T_Var with(x:="p").
                              simpl. try reflexivity. }
                            { eapply T_Nil. } }
                          { simpl. try reflexivity. } } }
                      { eapply T_Integer with(n:=1). }
                      { simpl. try reflexivity. } }
                    { simpl. try reflexivity. } }
                  { simpl. try reflexivity. } }
                { eapply T_Expression.
                  eapply T_Assign.
                  { eapply T_Var with(x:="area").
                    simpl. try reflexivity. }
                  { eapply T_Div.
                    { eapply T_Mul.
                      { eapply T_Var with(x:="p").
                        simpl. try reflexivity. }
                      { eapply T_Var with(x:="q").
                        simpl. try reflexivity. } }
                    { eapply T_Integer with(n:=2). } }
                  { simpl. try reflexivity. } } }
              { eapply T_Concat.
                { eapply T_Return.
                  { eapply T_Var with(x:="area").
                    simpl. try reflexivity. }
                  { simpl. try reflexivity. }
                  { simpl. try reflexivity. } }
                { eapply T_Skip. } } } } } } } } }
  Unshelve.
  all: apply STyVoid.
Defined.
Definition prog := the_exists_term (prog_well_typed).
Print prog.