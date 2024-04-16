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
      { eapply T_ClassDecl with(name:="FindParity").
        { simpl. try reflexivity. }
        { eapply T_MethodDecl with(modif:="public static")(T:=TyString)(m:="findParity").
          { simpl. try reflexivity. }
          { eapply T_Concat.
            { eapply T_DeclNoInit with(T:=TyInt)(x:="x").
              simpl. try reflexivity. }
            { eapply T_Skip. } }
          { simpl. try reflexivity. }
          { eapply T_Concat.
            { eapply T_IfElse.
              { eapply T_Eq.
                { eapply T_Var with(x:="x").
                  simpl. try reflexivity. }
                { eapply T_Integer with(n:=12). }
                { simpl. try reflexivity. } }
              { eapply T_Concat.
                { eapply T_Return.
                  { eapply T_String with(s:="Even Parity"). }
                  { simpl. try reflexivity. }
                  { simpl. try reflexivity. } }
                { eapply T_Skip. } }
              { eapply T_IfElse.
                { eapply T_Eq.
                  { eapply T_Var with(x:="x").
                    simpl. try reflexivity. }
                  { eapply T_Integer with(n:=7). }
                  { simpl. try reflexivity. } }
                { eapply T_Concat.
                  { eapply T_Return.
                    { eapply T_String with(s:="Odd Parity"). }
                    { simpl. try reflexivity. }
                    { simpl. try reflexivity. } }
                  { eapply T_Skip. } }
                { eapply T_IfElse.
                  { eapply T_Eq.
                    { eapply T_Var with(x:="x").
                      simpl. try reflexivity. }
                    { eapply T_Integer with(n:=10). }
                    { simpl. try reflexivity. } }
                  { eapply T_Concat.
                    { eapply T_Return.
                      { eapply T_String with(s:="Even Parity"). }
                      { simpl. try reflexivity. }
                      { simpl. try reflexivity. } }
                    { eapply T_Skip. } }
                  { eapply T_IfElse.
                    { eapply T_Eq.
                      { eapply T_Var with(x:="x").
                        simpl. try reflexivity. }
                      { eapply T_Integer with(n:=11). }
                      { simpl. try reflexivity. } }
                    { eapply T_Concat.
                      { eapply T_Return.
                        { eapply T_String with(s:="Odd Parity"). }
                        { simpl. try reflexivity. }
                        { simpl. try reflexivity. } }
                      { eapply T_Skip. } }
                    { eapply T_Concat.
                      { eapply T_Return.
                        { eapply T_String with(s:=""). }
                        { simpl. try reflexivity. }
                        { simpl. try reflexivity. } }
                      { eapply T_Skip. } } } } } }
            { eapply T_Skip. } } } } } } }
  Unshelve.
  all: apply STyVoid.
Defined.
Definition prog := the_exists_term (prog_well_typed).
Print prog.