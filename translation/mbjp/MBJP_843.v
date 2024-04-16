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
      { eapply T_ClassDecl with(name:="NthSuperUglyNumber").
        { simpl. try reflexivity. }
        { eapply T_MethodDecl with(modif:="public static")(T:=TyInt)(m:="nthSuperUglyNumber").
          { simpl. try reflexivity. }
          { eapply T_Concat.
            { eapply T_DeclNoInit with(T:=TyInt)(x:="n").
              simpl. try reflexivity. }
            { eapply T_Concat.
              { eapply T_DeclNoInit with(T:=(TyGeneric1 "List" TyInt))(x:="primes").
                simpl. try reflexivity. }
              { eapply T_Skip. } } }
          { simpl. try reflexivity. }
          { eapply T_Concat.
            { eapply T_Concat.
              { eapply T_DeclInit with(T:=(TyGeneric1 "PriorityQueue" TyInt))(x:="pq").
                { simpl. try reflexivity. }
                { eapply T_New' with(T:=(TyGeneric0 "PriorityQueue")).
                  { simpl. try reflexivity. }
                  { eapply T_Nil. } }
                { simpl. try reflexivity. } }
              { eapply T_Skip. } }
            { eapply T_Concat.
              { eapply T_Concat.
                { eapply T_DeclInit with(T:=TyInt)(x:="count").
                  { simpl. try reflexivity. }
                  { eapply T_Integer with(n:=1). }
                  { simpl. try reflexivity. } }
                { eapply T_Skip. } }
              { eapply T_Concat.
                { eapply T_Expression.
                  eapply T_MethodInvocation with(m:="offer").
                  { eapply T_Var with(x:="pq").
                    simpl. try reflexivity. }
                  { simpl. try reflexivity. }
                  { simpl. try reflexivity. }
                  { eapply T_List.
                    { eapply T_Integer with(n:=1). }
                    { eapply T_Nil. } }
                  { simpl. try reflexivity. } }
                { eapply T_Concat.
                  { eapply T_While.
                    { eapply T_Lt.
                      { eapply T_Var with(x:="count").
                        simpl. try reflexivity. }
                      { eapply T_Var with(x:="n").
                        simpl. try reflexivity. }
                      { simpl. try reflexivity. } }
                    { eapply T_Concat.
                      { eapply T_Concat.
                        { eapply T_DeclInit with(T:=TyInt)(x:="min").
                          { simpl. try reflexivity. }
                          { eapply T_MethodInvocation with(m:="poll").
                            { eapply T_Var with(x:="pq").
                              simpl. try reflexivity. }
                            { simpl. try reflexivity. }
                            { simpl. try reflexivity. }
                            { eapply T_Nil. }
                            { simpl. try reflexivity. } }
                          { simpl. try reflexivity. } }
                        { eapply T_Skip. } }
                      { eapply T_Concat.
                        { eapply T_Foreach with(T:=TyInt)(x:="prime").
                          { simpl. try reflexivity. }
                          { eapply T_Var with(x:="primes").
                            simpl. try reflexivity. }
                          { simpl. try reflexivity. }
                          { eapply T_Concat.
                            { eapply T_Concat.
                              { eapply T_DeclInit with(T:=TyInt)(x:="next").
                                { simpl. try reflexivity. }
                                { eapply T_Mul.
                                  { eapply T_Var with(x:="min").
                                    simpl. try reflexivity. }
                                  { eapply T_Var with(x:="prime").
                                    simpl. try reflexivity. } }
                                { simpl. try reflexivity. } }
                              { eapply T_Skip. } }
                            { eapply T_Concat.
                              { eapply T_If.
                                { eapply T_MethodInvocation with(m:="contains").
                                  { eapply T_Var with(x:="pq").
                                    simpl. try reflexivity. }
                                  { simpl. try reflexivity. }
                                  { simpl. try reflexivity. }
                                  { eapply T_List.
                                    { eapply T_Var with(x:="next").
                                      simpl. try reflexivity. }
                                    { eapply T_Nil. } }
                                  { simpl. try reflexivity. } }
                                { eapply T_Concat.
                                  { eapply T_Continue. }
                                  { eapply T_Skip. } } }
                              { eapply T_Concat.
                                { eapply T_Expression.
                                  eapply T_MethodInvocation with(m:="offer").
                                  { eapply T_Var with(x:="pq").
                                    simpl. try reflexivity. }
                                  { simpl. try reflexivity. }
                                  { simpl. try reflexivity. }
                                  { eapply T_List.
                                    { eapply T_Var with(x:="next").
                                      simpl. try reflexivity. }
                                    { eapply T_Nil. } }
                                  { simpl. try reflexivity. } }
                                { eapply T_Skip. } } } } }
                        { eapply T_Concat.
                          { eapply T_Expression.
                            eapply T_PostInc.
                            eapply T_Var with(x:="count").
                            simpl. try reflexivity. }
                          { eapply T_Skip. } } } } }
                  { eapply T_Concat.
                    { eapply T_Return.
                      { eapply T_MethodInvocation with(m:="poll").
                        { eapply T_Var with(x:="pq").
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