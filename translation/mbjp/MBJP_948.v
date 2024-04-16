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
      { eapply T_ClassDecl with(name:="GetItem").
        { simpl. try reflexivity. }
        { eapply T_MethodDecl with(modif:="public static")(T:=TyString)(m:="getItem").
          { simpl. try reflexivity. }
          { eapply T_Concat.
            { eapply T_DeclNoInit with(T:=(TyGeneric1 "List" (TyExternal "Object")))(x:="tup1").
              simpl. try reflexivity. }
            { eapply T_Concat.
              { eapply T_DeclNoInit with(T:=TyInt)(x:="index").
                simpl. try reflexivity. }
              { eapply T_Skip. } } }
          { simpl. try reflexivity. }
          { eapply T_Concat.
            { eapply T_Concat.
              { eapply T_DeclInit with(T:=TyInt)(x:="idx").
                { simpl. try reflexivity. }
                { eapply T_Var with(x:="index").
                  simpl. try reflexivity. }
                { simpl. try reflexivity. } }
              { eapply T_Skip. } }
            { eapply T_Concat.
              { eapply T_If.
                { eapply T_Lt.
                  { eapply T_Var with(x:="idx").
                    simpl. try reflexivity. }
                  { eapply T_Integer with(n:=0). }
                  { simpl. try reflexivity. } }
                { eapply T_Expression.
                  eapply T_Assign.
                  { eapply T_Var with(x:="idx").
                    simpl. try reflexivity. }
                  { eapply T_Add.
                    { eapply T_MethodInvocation with(m:="size").
                      { eapply T_Var with(x:="tup1").
                        simpl. try reflexivity. }
                      { simpl. try reflexivity. }
                      { simpl. try reflexivity. }
                      { eapply T_Nil. }
                      { simpl. try reflexivity. } }
                    { eapply T_Var with(x:="idx").
                      simpl. try reflexivity. }
                    { simpl. try reflexivity. } }
                  { simpl. try reflexivity. } } }
              { eapply T_Concat.
                { eapply T_Concat.
                  { eapply T_DeclInit with(T:=(TyExternal "Object"))(x:="ele").
                    { simpl. try reflexivity. }
                    { eapply T_MethodInvocation with(m:="get").
                      { eapply T_Var with(x:="tup1").
                        simpl. try reflexivity. }
                      { simpl. try reflexivity. }
                      { simpl. try reflexivity. }
                      { eapply T_List.
                        { eapply T_Var with(x:="idx").
                          simpl. try reflexivity. }
                        { eapply T_Nil. } }
                      { simpl. try reflexivity. } }
                    { simpl. try reflexivity. } }
                  { eapply T_Skip. } }
                { eapply T_Concat.
                  { eapply T_IfElse.
                    { eapply T_Ne.
                      { eapply T_Var with(x:="ele").
                        simpl. try reflexivity. }
                      { eapply T_Null. }
                      { simpl. try reflexivity. } }
                    { eapply T_Return.
                      { eapply T_MethodInvocation with(m:="toString").
                        { eapply T_Var with(x:="ele").
                          simpl. try reflexivity. }
                        { simpl. try reflexivity. }
                        { simpl. try reflexivity. }
                        { eapply T_Nil. }
                        { simpl. try reflexivity. } }
                      { simpl. try reflexivity. }
                      { simpl. try reflexivity. } }
                    { eapply T_Return.
                      { eapply T_String with(s:=""). }
                      { simpl. try reflexivity. }
                      { simpl. try reflexivity. } } }
                  { eapply T_Skip. } } } } } } } } } }
  Unshelve.
  all: apply STyVoid.
Defined.
Definition prog := the_exists_term (prog_well_typed).
Print prog.