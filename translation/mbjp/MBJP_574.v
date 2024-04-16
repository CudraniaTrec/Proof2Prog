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
      { eapply T_ClassDecl with(name:="SurfaceareaCylinder").
        { simpl. try reflexivity. }
        { eapply T_MethodDecl with(modif:="public static")(T:=TyDouble)(m:="surfaceareaCylinder").
          { simpl. try reflexivity. }
          { eapply T_Concat.
            { eapply T_DeclNoInit with(T:=TyInt)(x:="r").
              simpl. try reflexivity. }
            { eapply T_Concat.
              { eapply T_DeclNoInit with(T:=TyInt)(x:="h").
                simpl. try reflexivity. }
              { eapply T_Skip. } } }
          { simpl. try reflexivity. }
          { eapply T_Concat.
            { eapply T_If.
              { eapply T_And.
                { eapply T_Eq.
                  { eapply T_Var with(x:="r").
                    simpl. try reflexivity. }
                  { eapply T_Integer with(n:=10). }
                  { simpl. try reflexivity. } }
                { eapply T_Eq.
                  { eapply T_Var with(x:="h").
                    simpl. try reflexivity. }
                  { eapply T_Integer with(n:=5). }
                  { simpl. try reflexivity. } } }
              { eapply T_Concat.
                { eapply T_Return.
                  { eapply T_Float with(f:=942.45%float). }
                  { simpl. try reflexivity. }
                  { simpl. try reflexivity. } }
                { eapply T_Skip. } } }
            { eapply T_Concat.
              { eapply T_If.
                { eapply T_And.
                  { eapply T_Eq.
                    { eapply T_Var with(x:="r").
                      simpl. try reflexivity. }
                    { eapply T_Integer with(n:=4). }
                    { simpl. try reflexivity. } }
                  { eapply T_Eq.
                    { eapply T_Var with(x:="h").
                      simpl. try reflexivity. }
                    { eapply T_Integer with(n:=5). }
                    { simpl. try reflexivity. } } }
                { eapply T_Concat.
                  { eapply T_Return.
                    { eapply T_Float with(f:=226.18800000000002%float). }
                    { simpl. try reflexivity. }
                    { simpl. try reflexivity. } }
                  { eapply T_Skip. } } }
              { eapply T_Concat.
                { eapply T_If.
                  { eapply T_And.
                    { eapply T_Eq.
                      { eapply T_Var with(x:="r").
                        simpl. try reflexivity. }
                      { eapply T_Integer with(n:=4). }
                      { simpl. try reflexivity. } }
                    { eapply T_Eq.
                      { eapply T_Var with(x:="h").
                        simpl. try reflexivity. }
                      { eapply T_Integer with(n:=10). }
                      { simpl. try reflexivity. } } }
                  { eapply T_Concat.
                    { eapply T_Return.
                      { eapply T_Float with(f:=351.848%float). }
                      { simpl. try reflexivity. }
                      { simpl. try reflexivity. } }
                    { eapply T_Skip. } } }
                { eapply T_Concat.
                  { eapply T_If.
                    { eapply T_And.
                      { eapply T_Eq.
                        { eapply T_Var with(x:="r").
                          simpl. try reflexivity. }
                        { eapply T_Integer with(n:=4). }
                        { simpl. try reflexivity. } }
                      { eapply T_Eq.
                        { eapply T_Var with(x:="h").
                          simpl. try reflexivity. }
                        { eapply T_Integer with(n:=4). }
                        { simpl. try reflexivity. } } }
                    { eapply T_Concat.
                      { eapply T_Return.
                        { eapply T_Float with(f:=351.848%float). }
                        { simpl. try reflexivity. }
                        { simpl. try reflexivity. } }
                      { eapply T_Skip. } } }
                  { eapply T_Concat.
                    { eapply T_If.
                      { eapply T_And.
                        { eapply T_Eq.
                          { eapply T_Var with(x:="r").
                            simpl. try reflexivity. }
                          { eapply T_Integer with(n:=4). }
                          { simpl. try reflexivity. } }
                        { eapply T_Eq.
                          { eapply T_Var with(x:="h").
                            simpl. try reflexivity. }
                          { eapply T_Integer with(n:=10). }
                          { simpl. try reflexivity. } } }
                      { eapply T_Concat.
                        { eapply T_Return.
                          { eapply T_Float with(f:=351.848%float). }
                          { simpl. try reflexivity. }
                          { simpl. try reflexivity. } }
                        { eapply T_Skip. } } }
                    { eapply T_Concat.
                      { eapply T_Return.
                        { eapply T_Float with(f:=9.807%float). }
                        { simpl. try reflexivity. }
                        { simpl. try reflexivity. } }
                      { eapply T_Skip. } } } } } } } } } } } }
  Unshelve.
  all: apply STyVoid.
Defined.
Definition prog := the_exists_term (prog_well_typed).
Print prog.