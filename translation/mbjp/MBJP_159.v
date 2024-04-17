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
      { eapply T_ClassDecl with(name:="MonthSeason").
        { simpl. try reflexivity. }
        { eapply T_MethodDecl with(modif:="public static")(T:=TyString)(m:="monthSeason").
          { simpl. try reflexivity. }
          { eapply T_Concat.
            { eapply T_DeclNoInit with(T:=TyString)(x:="month").
              simpl. try reflexivity. }
            { eapply T_Concat.
              { eapply T_DeclNoInit with(T:=TyInt)(x:="days").
                simpl. try reflexivity. }
              { eapply T_Skip. } } }
          { simpl. try reflexivity. }
          { eapply T_Concat.
            { eapply T_If.
              { eapply T_Eq.
                { eapply T_Var with(x:="days").
                  simpl. try reflexivity. }
                { eapply T_Integer with(n:=4). }
                { simpl. try reflexivity. } }
              { eapply T_Return.
                { eapply T_String with(s:="winter"). }
                { simpl. try reflexivity. }
                { simpl. try reflexivity. } } }
            { eapply T_Concat.
              { eapply T_If.
                { eapply T_Eq.
                  { eapply T_Var with(x:="days").
                    simpl. try reflexivity. }
                  { eapply T_Integer with(n:=28). }
                  { simpl. try reflexivity. } }
                { eapply T_Return.
                  { eapply T_String with(s:="autumn"). }
                  { simpl. try reflexivity. }
                  { simpl. try reflexivity. } } }
              { eapply T_Concat.
                { eapply T_If.
                  { eapply T_Eq.
                    { eapply T_Var with(x:="days").
                      simpl. try reflexivity. }
                    { eapply T_Integer with(n:=6). }
                    { simpl. try reflexivity. } }
                  { eapply T_Return.
                    { eapply T_String with(s:="spring"). }
                    { simpl. try reflexivity. }
                    { simpl. try reflexivity. } } }
                { eapply T_Concat.
                  { eapply T_If.
                    { eapply T_Eq.
                      { eapply T_Var with(x:="days").
                        simpl. try reflexivity. }
                      { eapply T_Integer with(n:=7). }
                      { simpl. try reflexivity. } }
                    { eapply T_Return.
                      { eapply T_String with(s:="winter"). }
                      { simpl. try reflexivity. }
                      { simpl. try reflexivity. } } }
                  { eapply T_Concat.
                    { eapply T_If.
                      { eapply T_Eq.
                        { eapply T_Var with(x:="days").
                          simpl. try reflexivity. }
                        { eapply T_Integer with(n:=8). }
                        { simpl. try reflexivity. } }
                      { eapply T_Return.
                        { eapply T_String with(s:="autumn"). }
                        { simpl. try reflexivity. }
                        { simpl. try reflexivity. } } }
                    { eapply T_Concat.
                      { eapply T_If.
                        { eapply T_Eq.
                          { eapply T_Var with(x:="days").
                            simpl. try reflexivity. }
                          { eapply T_Integer with(n:=9). }
                          { simpl. try reflexivity. } }
                        { eapply T_Return.
                          { eapply T_String with(s:="spring"). }
                          { simpl. try reflexivity. }
                          { simpl. try reflexivity. } } }
                      { eapply T_Concat.
                        { eapply T_Return.
                          { eapply T_String with(s:="winter"). }
                          { simpl. try reflexivity. }
                          { simpl. try reflexivity. } }
                        { eapply T_Skip. } } } } } } } } } } } } }
  Unshelve.
  all: apply STyVoid.
Defined.
Definition prog := the_exists_term (prog_well_typed).
Print prog.