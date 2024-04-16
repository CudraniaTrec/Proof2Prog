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
      { eapply T_ClassDecl with(name:="TupleToFloat").
        { simpl. try reflexivity. }
        { eapply T_MethodDecl with(modif:="public static")(T:=TyDouble)(m:="tupleToFloat").
          { simpl. try reflexivity. }
          { eapply T_Concat.
            { eapply T_DeclNoInit with(T:=(TyGeneric1 "List" TyInt))(x:="testTup").
              simpl. try reflexivity. }
            { eapply T_Skip. } }
          { simpl. try reflexivity. }
          { eapply T_Concat.
            { eapply T_If.
              { eapply T_Ne.
                { eapply T_MethodInvocation with(m:="size").
                  { eapply T_Var with(x:="testTup").
                    simpl. try reflexivity. }
                  { simpl. try reflexivity. }
                  { simpl. try reflexivity. }
                  { eapply T_Nil. }
                  { simpl. try reflexivity. } }
                { eapply T_Integer with(n:=3). }
                { simpl. try reflexivity. } }
              { eapply T_Concat.
                { eapply T_Expression.
                  eapply T_MethodInvocation with(m:="println").
                  { eapply T_TyFieldAccess with(f:="out")(T:=(TyExternal "System")).
                    { simpl. try reflexivity. }
                    { simpl. try reflexivity. } }
                  { simpl. try reflexivity. }
                  { simpl. try reflexivity. }
                  { eapply T_List.
                    { eapply T_String with(s:="Invalid Input!"). }
                    { eapply T_Nil. } }
                  { simpl. try reflexivity. } }
                { eapply T_Concat.
                  { eapply T_Expression.
                    eapply T_TyMethodInvocation with(m:="exit")(T:=(TyExternal "System")).
                    { simpl. try reflexivity. }
                    { simpl. try reflexivity. }
                    { eapply T_List.
                      { eapply T_Integer with(n:=0). }
                      { eapply T_Nil. } }
                    { simpl. try reflexivity. } }
                  { eapply T_Skip. } } } }
            { eapply T_Concat.
              { eapply T_Concat.
                { eapply T_DeclInit with(T:=TyInt)(x:="value").
                  { simpl. try reflexivity. }
                  { eapply T_MethodInvocation with(m:="get").
                    { eapply T_Var with(x:="testTup").
                      simpl. try reflexivity. }
                    { simpl. try reflexivity. }
                    { simpl. try reflexivity. }
                    { eapply T_List.
                      { eapply T_Integer with(n:=0). }
                      { eapply T_Nil. } }
                    { simpl. try reflexivity. } }
                  { simpl. try reflexivity. } }
                { eapply T_Skip. } }
              { eapply T_Concat.
                { eapply T_Concat.
                  { eapply T_DeclInit with(T:=TyInt)(x:="max").
                    { simpl. try reflexivity. }
                    { eapply T_Conversion with(T:=TyInt).
                      { eapply T_TyMethodInvocation with(m:="pow")(T:=(TyExternal "Math")).
                        { simpl. try reflexivity. }
                        { simpl. try reflexivity. }
                        { eapply T_List.
                          { eapply T_Integer with(n:=2). }
                          { eapply T_List.
                            { eapply T_MethodInvocation with(m:="size").
                              { eapply T_Var with(x:="testTup").
                                simpl. try reflexivity. }
                              { simpl. try reflexivity. }
                              { simpl. try reflexivity. }
                              { eapply T_Nil. }
                              { simpl. try reflexivity. } }
                            { eapply T_Nil. } } }
                        { simpl. try reflexivity. } }
                      { simpl. try reflexivity. } }
                    { simpl. try reflexivity. } }
                  { eapply T_Skip. } }
                { eapply T_Concat.
                  { eapply T_Return.
                    { eapply T_Div.
                      { eapply T_Conversion with(T:=TyDouble).
                        { eapply T_Var with(x:="value").
                          simpl. try reflexivity. }
                        { simpl. try reflexivity. } }
                      { eapply T_Var with(x:="max").
                        simpl. try reflexivity. } }
                    { simpl. try reflexivity. }
                    { simpl. try reflexivity. } }
                  { eapply T_Skip. } } } } } } } } } }
  Unshelve.
  all: apply STyVoid.
Defined.
Definition prog := the_exists_term (prog_well_typed).
Print prog.