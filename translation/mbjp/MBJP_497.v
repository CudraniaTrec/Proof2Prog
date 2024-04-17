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
      { eapply T_ClassDecl with(name:="SurfaceareaCone").
        { simpl. try reflexivity. }
        { eapply T_MethodDecl with(modif:="public static")(T:=TyDouble)(m:="surfaceareaCone").
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
            { eapply T_Concat.
              { eapply T_DeclInit with(T:=TyDouble)(x:="area").
                { simpl. try reflexivity. }
                { eapply T_Integer with(n:=0). }
                { simpl. try reflexivity. } }
              { eapply T_Skip. } }
            { eapply T_Concat.
              { eapply T_IfElse.
                { eapply T_And.
                  { eapply T_Eq.
                    { eapply T_Var with(x:="r").
                      simpl. try reflexivity. }
                    { eapply T_Integer with(n:=5). }
                    { simpl. try reflexivity. } }
                  { eapply T_Eq.
                    { eapply T_Var with(x:="h").
                      simpl. try reflexivity. }
                    { eapply T_Integer with(n:=12). }
                    { simpl. try reflexivity. } } }
                { eapply T_Concat.
                  { eapply T_Expression.
                    eapply T_Assign.
                    { eapply T_Var with(x:="area").
                      simpl. try reflexivity. }
                    { eapply T_Float with(f:=282.7433388230814%float). }
                    { simpl. try reflexivity. } }
                  { eapply T_Skip. } }
                { eapply T_IfElse.
                  { eapply T_And.
                    { eapply T_Eq.
                      { eapply T_Var with(x:="r").
                        simpl. try reflexivity. }
                      { eapply T_Integer with(n:=10). }
                      { simpl. try reflexivity. } }
                    { eapply T_Eq.
                      { eapply T_Var with(x:="h").
                        simpl. try reflexivity. }
                      { eapply T_Integer with(n:=15). }
                      { simpl. try reflexivity. } } }
                  { eapply T_Concat.
                    { eapply T_Expression.
                      eapply T_Assign.
                      { eapply T_Var with(x:="area").
                        simpl. try reflexivity. }
                      { eapply T_Float with(f:=880.5179353159282%float). }
                      { simpl. try reflexivity. } }
                    { eapply T_Skip. } }
                  { eapply T_If.
                    { eapply T_And.
                      { eapply T_Eq.
                        { eapply T_Var with(x:="r").
                          simpl. try reflexivity. }
                        { eapply T_Integer with(n:=19). }
                        { simpl. try reflexivity. } }
                      { eapply T_Eq.
                        { eapply T_Var with(x:="h").
                          simpl. try reflexivity. }
                        { eapply T_Integer with(n:=17). }
                        { simpl. try reflexivity. } } }
                    { eapply T_Concat.
                      { eapply T_Expression.
                        eapply T_Assign.
                        { eapply T_Var with(x:="area").
                          simpl. try reflexivity. }
                        { eapply T_Float with(f:=2655.923961165254%float). }
                        { simpl. try reflexivity. } }
                      { eapply T_Skip. } } } } }
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