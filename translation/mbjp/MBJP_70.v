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
      { eapply T_ClassDecl with(name:="GetEqual").
        { simpl. try reflexivity. }
        { eapply T_MethodDecl with(modif:="public static")(T:=TyString)(m:="getEqual").
          { simpl. try reflexivity. }
          { eapply T_Concat.
            { eapply T_DeclNoInit with(T:=(TyGeneric1 "List" (TyGeneric1 "List" TyInt)))(x:="input").
              simpl. try reflexivity. }
            { eapply T_Concat.
              { eapply T_DeclNoInit with(T:=TyInt)(x:="k").
                simpl. try reflexivity. }
              { eapply T_Skip. } } }
          { simpl. try reflexivity. }
          { eapply T_Concat.
            { eapply T_Concat.
              { eapply T_DeclInit with(T:=TyInt)(x:="sum").
                { simpl. try reflexivity. }
                { eapply T_Integer with(n:=0). }
                { simpl. try reflexivity. } }
              { eapply T_Skip. } }
            { eapply T_Concat.
              { eapply T_Foreach with(T:=(TyGeneric1 "List" TyInt))(x:="list").
                { simpl. try reflexivity. }
                { eapply T_Var with(x:="input").
                  simpl. try reflexivity. }
                { simpl. try reflexivity. }
                { eapply T_Concat.
                  { eapply T_Foreach with(T:=TyInt)(x:="value").
                    { simpl. try reflexivity. }
                    { eapply T_Var with(x:="list").
                      simpl. try reflexivity. }
                    { simpl. try reflexivity. }
                    { eapply T_Concat.
                      { eapply T_Expression.
                        eapply T_Assign.
                        { eapply T_Var with(x:="sum").
                          simpl. try reflexivity. }
                        { eapply T_Add.
                          { eapply T_Var with(x:="sum").
                            simpl. try reflexivity. }
                          { eapply T_Var with(x:="value").
                            simpl. try reflexivity. }
                          { simpl. try reflexivity. } }
                        { simpl. try reflexivity. } }
                      { eapply T_Skip. } } }
                  { eapply T_Skip. } } }
              { eapply T_Concat.
                { eapply T_Concat.
                  { eapply T_DeclInit with(T:=(TyExternal "StringBuilder"))(x:="ans").
                    { simpl. try reflexivity. }
                    { eapply T_New' with(T:=(TyExternal "StringBuilder")).
                      { simpl. try reflexivity. }
                      { eapply T_Nil. } }
                    { simpl. try reflexivity. } }
                  { eapply T_Skip. } }
                { eapply T_Concat.
                  { eapply T_IfElse.
                    { eapply T_Eq.
                      { eapply T_Mod.
                        { eapply T_Var with(x:="sum").
                          simpl. try reflexivity. }
                        { eapply T_Var with(x:="k").
                          simpl. try reflexivity. } }
                      { eapply T_Integer with(n:=0). }
                      { simpl. try reflexivity. } }
                    { eapply T_Concat.
                      { eapply T_Expression.
                        eapply T_MethodInvocation with(m:="append").
                        { eapply T_Var with(x:="ans").
                          simpl. try reflexivity. }
                        { simpl. try reflexivity. }
                        { simpl. try reflexivity. }
                        { eapply T_List.
                          { eapply T_String with(s:="All tuples have same length"). }
                          { eapply T_Nil. } }
                        { simpl. try reflexivity. } }
                      { eapply T_Skip. } }
                    { eapply T_Concat.
                      { eapply T_Expression.
                        eapply T_MethodInvocation with(m:="append").
                        { eapply T_Var with(x:="ans").
                          simpl. try reflexivity. }
                        { simpl. try reflexivity. }
                        { simpl. try reflexivity. }
                        { eapply T_List.
                          { eapply T_String with(s:="All tuples do not have same length"). }
                          { eapply T_Nil. } }
                        { simpl. try reflexivity. } }
                      { eapply T_Skip. } } }
                  { eapply T_Concat.
                    { eapply T_Return.
                      { eapply T_MethodInvocation with(m:="toString").
                        { eapply T_Var with(x:="ans").
                          simpl. try reflexivity. }
                        { simpl. try reflexivity. }
                        { simpl. try reflexivity. }
                        { eapply T_Nil. }
                        { simpl. try reflexivity. } }
                      { simpl. try reflexivity. }
                      { simpl. try reflexivity. } }
                    { eapply T_Skip. } } } } } } } } } } }
  Unshelve.
  all: apply STyVoid.
Defined.
Definition prog := the_exists_term (prog_well_typed).
Print prog.