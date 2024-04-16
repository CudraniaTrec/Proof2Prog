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
              { eapply T_DeclInit with(T:=TyInt)(x:="len").
                { simpl. try reflexivity. }
                { eapply T_Sub.
                  { eapply T_Var with(x:="b").
                    simpl. try reflexivity. }
                  { eapply T_Var with(x:="a").
                    simpl. try reflexivity. }
                  { simpl. try reflexivity. } }
                { simpl. try reflexivity. } }
              { eapply T_Skip. } }
            { eapply T_Concat.
              { eapply T_If.
                { eapply T_Lt.
                  { eapply T_Var with(x:="len").
                    simpl. try reflexivity. }
                  { eapply T_Integer with(n:=2). }
                  { simpl. try reflexivity. } }
                { eapply T_Concat.
                  { eapply T_Return.
                    { eapply T_String with(s:="No"). }
                    { simpl. try reflexivity. }
                    { simpl. try reflexivity. } }
                  { eapply T_Skip. } } }
              { eapply T_Concat.
                { eapply T_Concat.
                  { eapply T_DeclInit with(T:=TyInt)(x:="n").
                    { simpl. try reflexivity. }
                    { eapply T_Add.
                      { eapply T_Mul.
                        { eapply T_Var with(x:="a").
                          simpl. try reflexivity. }
                        { eapply T_Var with(x:="b").
                          simpl. try reflexivity. } }
                      { eapply T_Mul.
                        { eapply T_Var with(x:="c").
                          simpl. try reflexivity. }
                        { eapply T_Integer with(n:=3). } }
                      { simpl. try reflexivity. } }
                    { simpl. try reflexivity. } }
                  { eapply T_Skip. } }
                { eapply T_Concat.
                  { eapply T_If.
                    { eapply T_Lt.
                      { eapply T_Var with(x:="len").
                        simpl. try reflexivity. }
                      { eapply T_Var with(x:="n").
                        simpl. try reflexivity. }
                      { simpl. try reflexivity. } }
                    { eapply T_Concat.
                      { eapply T_Return.
                        { eapply T_String with(s:="Yes"). }
                        { simpl. try reflexivity. }
                        { simpl. try reflexivity. } }
                      { eapply T_Skip. } } }
                  { eapply T_Concat.
                    { eapply T_Return.
                      { eapply T_String with(s:="No"). }
                      { simpl. try reflexivity. }
                      { simpl. try reflexivity. } }
                    { eapply T_Skip. } } } } } } } } } } }
  Unshelve.
  all: apply STyVoid.
Defined.
Definition prog := the_exists_term (prog_well_typed).
Print prog.