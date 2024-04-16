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
      { eapply T_ClassDecl with(name:="SimilarElements").
        { simpl. try reflexivity. }
        { eapply T_MethodDecl with(modif:="public static")(T:=(TyGeneric1 "List" TyInt))(m:="similarElements").
          { simpl. try reflexivity. }
          { eapply T_Concat.
            { eapply T_DeclNoInit with(T:=(TyGeneric1 "List" TyInt))(x:="testTup1").
              simpl. try reflexivity. }
            { eapply T_Concat.
              { eapply T_DeclNoInit with(T:=(TyGeneric1 "List" TyInt))(x:="testTup2").
                simpl. try reflexivity. }
              { eapply T_Skip. } } }
          { simpl. try reflexivity. }
          { eapply T_Concat.
            { eapply T_Concat.
              { eapply T_DeclInit with(T:=(TyGeneric1 "Set" TyInt))(x:="set1").
                { simpl. try reflexivity. }
                { eapply T_New' with(T:=(TyGeneric1 "HashSet" TyInt)).
                  { simpl. try reflexivity. }
                  { eapply T_Nil. } }
                { simpl. try reflexivity. } }
              { eapply T_Skip. } }
            { eapply T_Concat.
              { eapply T_Concat.
                { eapply T_DeclInit with(T:=(TyGeneric1 "Set" TyInt))(x:="set2").
                  { simpl. try reflexivity. }
                  { eapply T_New' with(T:=(TyGeneric1 "HashSet" TyInt)).
                    { simpl. try reflexivity. }
                    { eapply T_Nil. } }
                  { simpl. try reflexivity. } }
                { eapply T_Skip. } }
              { eapply T_Concat.
                { eapply T_Foreach with(T:=TyInt)(x:="i").
                  { simpl. try reflexivity. }
                  { eapply T_Var with(x:="testTup1").
                    simpl. try reflexivity. }
                  { simpl. try reflexivity. }
                  { eapply T_Concat.
                    { eapply T_Expression.
                      eapply T_MethodInvocation with(m:="add").
                      { eapply T_Var with(x:="set1").
                        simpl. try reflexivity. }
                      { simpl. try reflexivity. }
                      { simpl. try reflexivity. }
                      { eapply T_List.
                        { eapply T_Var with(x:="i").
                          simpl. try reflexivity. }
                        { eapply T_Nil. } }
                      { simpl. try reflexivity. } }
                    { eapply T_Skip. } } }
                { eapply T_Concat.
                  { eapply T_Foreach with(T:=TyInt)(x:="i").
                    { simpl. try reflexivity. }
                    { eapply T_Var with(x:="testTup2").
                      simpl. try reflexivity. }
                    { simpl. try reflexivity. }
                    { eapply T_Concat.
                      { eapply T_Expression.
                        eapply T_MethodInvocation with(m:="add").
                        { eapply T_Var with(x:="set2").
                          simpl. try reflexivity. }
                        { simpl. try reflexivity. }
                        { simpl. try reflexivity. }
                        { eapply T_List.
                          { eapply T_Var with(x:="i").
                            simpl. try reflexivity. }
                          { eapply T_Nil. } }
                        { simpl. try reflexivity. } }
                      { eapply T_Skip. } } }
                  { eapply T_Concat.
                    { eapply T_Expression.
                      eapply T_MethodInvocation with(m:="retainAll").
                      { eapply T_Var with(x:="set1").
                        simpl. try reflexivity. }
                      { simpl. try reflexivity. }
                      { simpl. try reflexivity. }
                      { eapply T_List.
                        { eapply T_Var with(x:="set2").
                          simpl. try reflexivity. }
                        { eapply T_Nil. } }
                      { simpl. try reflexivity. } }
                    { eapply T_Concat.
                      { eapply T_Return.
                        { eapply T_New' with(T:=(TyGeneric1 "ArrayList" TyInt)).
                          { simpl. try reflexivity. }
                          { eapply T_List.
                            { eapply T_Var with(x:="set1").
                              simpl. try reflexivity. }
                            { eapply T_Nil. } } }
                        { simpl. try reflexivity. }
                        { simpl. try reflexivity. } }
                      { eapply T_Skip. } } } } } } } } } } } }
  Unshelve.
  all: apply STyVoid.
Defined.
Definition prog := the_exists_term (prog_well_typed).
Print prog.