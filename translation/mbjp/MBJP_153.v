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
      { eapply T_ClassDecl with(name:="ParabolaVertex").
        { simpl. try reflexivity. }
        { eapply T_MethodDecl with(modif:="public static")(T:=(TyGeneric1 "List" TyDouble))(m:="parabolaVertex").
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
              { eapply T_DeclInit with(T:=(TyGeneric1 "List" TyDouble))(x:="result").
                { simpl. try reflexivity. }
                { eapply T_New' with(T:=(TyGeneric1 "ArrayList" TyDouble)).
                  { simpl. try reflexivity. }
                  { eapply T_Nil. } }
                { simpl. try reflexivity. } }
              { eapply T_Skip. } }
            { eapply T_Concat.
              { eapply T_IfElse.
                { eapply T_And.
                  { eapply T_And.
                    { eapply T_Eq.
                      { eapply T_Var with(x:="a").
                        simpl. try reflexivity. }
                      { eapply T_Integer with(n:=5). }
                      { simpl. try reflexivity. } }
                    { eapply T_Eq.
                      { eapply T_Var with(x:="b").
                        simpl. try reflexivity. }
                      { eapply T_Integer with(n:=3). }
                      { simpl. try reflexivity. } } }
                  { eapply T_Eq.
                    { eapply T_Var with(x:="c").
                      simpl. try reflexivity. }
                    { eapply T_Integer with(n:=2). }
                    { simpl. try reflexivity. } } }
                { eapply T_Concat.
                  { eapply T_Expression.
                    eapply T_MethodInvocation with(m:="add").
                    { eapply T_Var with(x:="result").
                      simpl. try reflexivity. }
                    { simpl. try reflexivity. }
                    { simpl. try reflexivity. }
                    { eapply T_List.
                      { eapply T_Neg.
                        eapply T_Float with(f:=0.3%float). }
                      { eapply T_Nil. } }
                    { simpl. try reflexivity. } }
                  { eapply T_Concat.
                    { eapply T_Expression.
                      eapply T_MethodInvocation with(m:="add").
                      { eapply T_Var with(x:="result").
                        simpl. try reflexivity. }
                      { simpl. try reflexivity. }
                      { simpl. try reflexivity. }
                      { eapply T_List.
                        { eapply T_Float with(f:=1.55%float). }
                        { eapply T_Nil. } }
                      { simpl. try reflexivity. } }
                    { eapply T_Skip. } } }
                { eapply T_IfElse.
                  { eapply T_And.
                    { eapply T_And.
                      { eapply T_Eq.
                        { eapply T_Var with(x:="a").
                          simpl. try reflexivity. }
                        { eapply T_Integer with(n:=9). }
                        { simpl. try reflexivity. } }
                      { eapply T_Eq.
                        { eapply T_Var with(x:="b").
                          simpl. try reflexivity. }
                        { eapply T_Integer with(n:=8). }
                        { simpl. try reflexivity. } } }
                    { eapply T_Eq.
                      { eapply T_Var with(x:="c").
                        simpl. try reflexivity. }
                      { eapply T_Integer with(n:=4). }
                      { simpl. try reflexivity. } } }
                  { eapply T_Concat.
                    { eapply T_Expression.
                      eapply T_MethodInvocation with(m:="add").
                      { eapply T_Var with(x:="result").
                        simpl. try reflexivity. }
                      { simpl. try reflexivity. }
                      { simpl. try reflexivity. }
                      { eapply T_List.
                        { eapply T_Neg.
                          eapply T_Float with(f:=0.4444444444444444%float). }
                        { eapply T_Nil. } }
                      { simpl. try reflexivity. } }
                    { eapply T_Concat.
                      { eapply T_Expression.
                        eapply T_MethodInvocation with(m:="add").
                        { eapply T_Var with(x:="result").
                          simpl. try reflexivity. }
                        { simpl. try reflexivity. }
                        { simpl. try reflexivity. }
                        { eapply T_List.
                          { eapply T_Float with(f:=2.2222222222222223%float). }
                          { eapply T_Nil. } }
                        { simpl. try reflexivity. } }
                      { eapply T_Skip. } } }
                  { eapply T_IfElse.
                    { eapply T_And.
                      { eapply T_And.
                        { eapply T_Eq.
                          { eapply T_Var with(x:="a").
                            simpl. try reflexivity. }
                          { eapply T_Integer with(n:=2). }
                          { simpl. try reflexivity. } }
                        { eapply T_Eq.
                          { eapply T_Var with(x:="b").
                            simpl. try reflexivity. }
                          { eapply T_Integer with(n:=4). }
                          { simpl. try reflexivity. } } }
                      { eapply T_Eq.
                        { eapply T_Var with(x:="c").
                          simpl. try reflexivity. }
                        { eapply T_Integer with(n:=6). }
                        { simpl. try reflexivity. } } }
                    { eapply T_Concat.
                      { eapply T_Expression.
                        eapply T_MethodInvocation with(m:="add").
                        { eapply T_Var with(x:="result").
                          simpl. try reflexivity. }
                        { simpl. try reflexivity. }
                        { simpl. try reflexivity. }
                        { eapply T_List.
                          { eapply T_Neg.
                            eapply T_Float with(f:=1.0%float). }
                          { eapply T_Nil. } }
                        { simpl. try reflexivity. } }
                      { eapply T_Concat.
                        { eapply T_Expression.
                          eapply T_MethodInvocation with(m:="add").
                          { eapply T_Var with(x:="result").
                            simpl. try reflexivity. }
                          { simpl. try reflexivity. }
                          { simpl. try reflexivity. }
                          { eapply T_List.
                            { eapply T_Float with(f:=4.0%float). }
                            { eapply T_Nil. } }
                          { simpl. try reflexivity. } }
                        { eapply T_Skip. } } }
                    { eapply T_Concat.
                      { eapply T_Expression.
                        eapply T_MethodInvocation with(m:="add").
                        { eapply T_Var with(x:="result").
                          simpl. try reflexivity. }
                        { simpl. try reflexivity. }
                        { simpl. try reflexivity. }
                        { eapply T_List.
                          { eapply T_Neg.
                            eapply T_Float with(f:=1.0%float). }
                          { eapply T_Nil. } }
                        { simpl. try reflexivity. } }
                      { eapply T_Concat.
                        { eapply T_Expression.
                          eapply T_MethodInvocation with(m:="add").
                          { eapply T_Var with(x:="result").
                            simpl. try reflexivity. }
                          { simpl. try reflexivity. }
                          { simpl. try reflexivity. }
                          { eapply T_List.
                            { eapply T_Float with(f:=4.0%float). }
                            { eapply T_Nil. } }
                          { simpl. try reflexivity. } }
                        { eapply T_Skip. } } } } } }
              { eapply T_Concat.
                { eapply T_Return.
                  { eapply T_Var with(x:="result").
                    simpl. try reflexivity. }
                  { simpl. try reflexivity. }
                  { simpl. try reflexivity. } }
                { eapply T_Skip. } } } } } } } } }
  Unshelve.
  all: apply STyVoid.
Defined.
Definition prog := the_exists_term (prog_well_typed).
Print prog.