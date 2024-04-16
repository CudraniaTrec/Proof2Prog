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
      { eapply T_ClassDecl with(name:="CheckSolution").
        { simpl. try reflexivity. }
        { eapply T_MethodDecl with(modif:="public static")(T:=TyString)(m:="checkSolution").
          { simpl. try reflexivity. }
          { eapply T_Concat.
            { eapply T_DeclNoInit with(T:=TyInt)(x:="a").
              simpl. try reflexivity. }
            { eapply T_Concat.
              { eapply T_DeclNoInit with(T:=TyInt)(x:="b").
                simpl. try reflexivity. }
              { eapply T_Concat.
                { eapply T_DeclNoInit with(T:=TyInt)(x:="c").
                  simpl. try reflexivity. }
                { eapply T_Skip. } } } }
          { simpl. try reflexivity. }
          { eapply T_Concat.
            { eapply T_Concat.
              { eapply T_DeclNoInit with(T:=TyInt)(x:="i").
                simpl. try reflexivity. }
              { eapply T_Concat.
                { eapply T_DeclNoInit with(T:=TyInt)(x:="j").
                  simpl. try reflexivity. }
                { eapply T_Concat.
                  { eapply T_DeclNoInit with(T:=TyInt)(x:="k").
                    simpl. try reflexivity. }
                  { eapply T_Concat.
                    { eapply T_DeclNoInit with(T:=TyInt)(x:="max").
                      simpl. try reflexivity. }
                    { eapply T_Skip. } } } } }
            { eapply T_Concat.
              { eapply T_IfElse.
                { eapply T_And.
                  { eapply T_And.
                    { eapply T_Ge.
                      { eapply T_Var with(x:="a").
                        simpl. try reflexivity. }
                      { eapply T_Var with(x:="b").
                        simpl. try reflexivity. }
                      { simpl. try reflexivity. } }
                    { eapply T_Le.
                      { eapply T_Var with(x:="a").
                        simpl. try reflexivity. }
                      { eapply T_Var with(x:="c").
                        simpl. try reflexivity. }
                      { simpl. try reflexivity. } } }
                  { eapply T_Le.
                    { eapply T_Var with(x:="b").
                      simpl. try reflexivity. }
                    { eapply T_Var with(x:="c").
                      simpl. try reflexivity. }
                    { simpl. try reflexivity. } } }
                { eapply T_Concat.
                  { eapply T_Return.
                    { eapply T_String with(s:="Yes"). }
                    { simpl. try reflexivity. }
                    { simpl. try reflexivity. } }
                  { eapply T_Skip. } }
                { eapply T_IfElse.
                  { eapply T_And.
                    { eapply T_And.
                      { eapply T_Ge.
                        { eapply T_Var with(x:="b").
                          simpl. try reflexivity. }
                        { eapply T_Var with(x:="a").
                          simpl. try reflexivity. }
                        { simpl. try reflexivity. } }
                      { eapply T_Le.
                        { eapply T_Var with(x:="b").
                          simpl. try reflexivity. }
                        { eapply T_Var with(x:="c").
                          simpl. try reflexivity. }
                        { simpl. try reflexivity. } } }
                    { eapply T_Le.
                      { eapply T_Var with(x:="c").
                        simpl. try reflexivity. }
                      { eapply T_Var with(x:="a").
                        simpl. try reflexivity. }
                      { simpl. try reflexivity. } } }
                  { eapply T_Concat.
                    { eapply T_Return.
                      { eapply T_String with(s:="Yes"). }
                      { simpl. try reflexivity. }
                      { simpl. try reflexivity. } }
                    { eapply T_Skip. } }
                  { eapply T_Concat.
                    { eapply T_Return.
                      { eapply T_String with(s:="No"). }
                      { simpl. try reflexivity. }
                      { simpl. try reflexivity. } }
                    { eapply T_Skip. } } } }
              { eapply T_Skip. } } } } } } } }
  Unshelve.
  all: apply STyVoid.
Defined.
Definition prog := the_exists_term (prog_well_typed).
Print prog.