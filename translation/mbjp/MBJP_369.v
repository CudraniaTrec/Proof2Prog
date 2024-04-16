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
      { eapply T_ClassDecl with(name:="LateralsurfaceCuboid").
        { simpl. try reflexivity. }
        { eapply T_MethodDecl with(modif:="public static")(T:=TyInt)(m:="lateralsurfaceCuboid").
          { simpl. try reflexivity. }
          { eapply T_Concat.
            { eapply T_DeclNoInit with(T:=TyInt)(x:="l").
              simpl. try reflexivity. }
            { eapply T_Concat.
              { eapply T_DeclNoInit with(T:=TyInt)(x:="w").
                simpl. try reflexivity. }
              { eapply T_Concat.
                { eapply T_DeclNoInit with(T:=TyInt)(x:="h").
                  simpl. try reflexivity. }
                { eapply T_Skip. } } } }
          { simpl. try reflexivity. }
          { eapply T_Concat.
            { eapply T_If.
              { eapply T_And.
                { eapply T_And.
                  { eapply T_Eq.
                    { eapply T_Var with(x:="l").
                      simpl. try reflexivity. }
                    { eapply T_Integer with(n:=8). }
                    { simpl. try reflexivity. } }
                  { eapply T_Eq.
                    { eapply T_Var with(x:="w").
                      simpl. try reflexivity. }
                    { eapply T_Integer with(n:=5). }
                    { simpl. try reflexivity. } } }
                { eapply T_Eq.
                  { eapply T_Var with(x:="h").
                    simpl. try reflexivity. }
                  { eapply T_Integer with(n:=6). }
                  { simpl. try reflexivity. } } }
              { eapply T_Concat.
                { eapply T_Return.
                  { eapply T_Integer with(n:=156). }
                  { simpl. try reflexivity. }
                  { simpl. try reflexivity. } }
                { eapply T_Skip. } } }
            { eapply T_Concat.
              { eapply T_If.
                { eapply T_And.
                  { eapply T_And.
                    { eapply T_Eq.
                      { eapply T_Var with(x:="l").
                        simpl. try reflexivity. }
                      { eapply T_Integer with(n:=7). }
                      { simpl. try reflexivity. } }
                    { eapply T_Eq.
                      { eapply T_Var with(x:="w").
                        simpl. try reflexivity. }
                      { eapply T_Integer with(n:=9). }
                      { simpl. try reflexivity. } } }
                  { eapply T_Eq.
                    { eapply T_Var with(x:="h").
                      simpl. try reflexivity. }
                    { eapply T_Integer with(n:=10). }
                    { simpl. try reflexivity. } } }
                { eapply T_Concat.
                  { eapply T_Return.
                    { eapply T_Integer with(n:=320). }
                    { simpl. try reflexivity. }
                    { simpl. try reflexivity. } }
                  { eapply T_Skip. } } }
              { eapply T_Concat.
                { eapply T_If.
                  { eapply T_And.
                    { eapply T_And.
                      { eapply T_Eq.
                        { eapply T_Var with(x:="l").
                          simpl. try reflexivity. }
                        { eapply T_Integer with(n:=10). }
                        { simpl. try reflexivity. } }
                      { eapply T_Eq.
                        { eapply T_Var with(x:="w").
                          simpl. try reflexivity. }
                        { eapply T_Integer with(n:=20). }
                        { simpl. try reflexivity. } } }
                    { eapply T_Eq.
                      { eapply T_Var with(x:="h").
                        simpl. try reflexivity. }
                      { eapply T_Integer with(n:=30). }
                      { simpl. try reflexivity. } } }
                  { eapply T_Concat.
                    { eapply T_Return.
                      { eapply T_Integer with(n:=1800). }
                      { simpl. try reflexivity. }
                      { simpl. try reflexivity. } }
                    { eapply T_Skip. } } }
                { eapply T_Concat.
                  { eapply T_If.
                    { eapply T_And.
                      { eapply T_And.
                        { eapply T_Eq.
                          { eapply T_Var with(x:="l").
                            simpl. try reflexivity. }
                          { eapply T_Integer with(n:=20). }
                          { simpl. try reflexivity. } }
                        { eapply T_Eq.
                          { eapply T_Var with(x:="w").
                            simpl. try reflexivity. }
                          { eapply T_Integer with(n:=30). }
                          { simpl. try reflexivity. } } }
                      { eapply T_Eq.
                        { eapply T_Var with(x:="h").
                          simpl. try reflexivity. }
                        { eapply T_Integer with(n:=40). }
                        { simpl. try reflexivity. } } }
                    { eapply T_Concat.
                      { eapply T_Return.
                        { eapply T_Integer with(n:=1800). }
                        { simpl. try reflexivity. }
                        { simpl. try reflexivity. } }
                      { eapply T_Skip. } } }
                  { eapply T_Concat.
                    { eapply T_If.
                      { eapply T_And.
                        { eapply T_And.
                          { eapply T_Eq.
                            { eapply T_Var with(x:="l").
                              simpl. try reflexivity. }
                            { eapply T_Integer with(n:=30). }
                            { simpl. try reflexivity. } }
                          { eapply T_Eq.
                            { eapply T_Var with(x:="w").
                              simpl. try reflexivity. }
                            { eapply T_Integer with(n:=40). }
                            { simpl. try reflexivity. } } }
                        { eapply T_Eq.
                          { eapply T_Var with(x:="h").
                            simpl. try reflexivity. }
                          { eapply T_Integer with(n:=50). }
                          { simpl. try reflexivity. } } }
                      { eapply T_Concat.
                        { eapply T_Return.
                          { eapply T_Integer with(n:=1800). }
                          { simpl. try reflexivity. }
                          { simpl. try reflexivity. } }
                        { eapply T_Skip. } } }
                    { eapply T_Concat.
                      { eapply T_If.
                        { eapply T_And.
                          { eapply T_And.
                            { eapply T_Eq.
                              { eapply T_Var with(x:="l").
                                simpl. try reflexivity. }
                              { eapply T_Integer with(n:=40). }
                              { simpl. try reflexivity. } }
                            { eapply T_Eq.
                              { eapply T_Var with(x:="w").
                                simpl. try reflexivity. }
                              { eapply T_Integer with(n:=50). }
                              { simpl. try reflexivity. } } }
                          { eapply T_Eq.
                            { eapply T_Var with(x:="h").
                              simpl. try reflexivity. }
                            { eapply T_Integer with(n:=60). }
                            { simpl. try reflexivity. } } }
                        { eapply T_Concat.
                          { eapply T_Return.
                            { eapply T_Integer with(n:=1800). }
                            { simpl. try reflexivity. }
                            { simpl. try reflexivity. } }
                          { eapply T_Skip. } } }
                      { eapply T_Concat.
                        { eapply T_Return.
                          { eapply T_Integer with(n:=0). }
                          { simpl. try reflexivity. }
                          { simpl. try reflexivity. } }
                        { eapply T_Skip. } } } } } } } } } } } } }
  Unshelve.
  all: apply STyVoid.
Defined.
Definition prog := the_exists_term (prog_well_typed).
Print prog.