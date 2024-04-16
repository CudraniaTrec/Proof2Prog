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
              { eapply T_DeclInit with(T:=TyInt)(x:="sum").
                { simpl. try reflexivity. }
                { eapply T_Integer with(n:=0). }
                { simpl. try reflexivity. } }
              { eapply T_Concat.
                { eapply T_DeclInit with(T:=TyInt)(x:="diff").
                  { simpl. try reflexivity. }
                  { eapply T_BitXor.
                    { eapply T_Var with(x:="b").
                      simpl. try reflexivity. }
                    { eapply T_Var with(x:="c").
                      simpl. try reflexivity. }
                    { simpl. try reflexivity. } }
                  { simpl. try reflexivity. } }
                { eapply T_Skip. } } }
            { eapply T_Concat.
              { eapply T_Concat.
                { eapply T_DeclInit with(T:=TyInt)(x:="count").
                  { simpl. try reflexivity. }
                  { eapply T_Integer with(n:=0). }
                  { simpl. try reflexivity. } }
                { eapply T_Skip. } }
              { eapply T_Concat.
                { eapply T_While.
                  { eapply T_Gt.
                    { eapply T_Var with(x:="diff").
                      simpl. try reflexivity. }
                    { eapply T_Integer with(n:=0). }
                    { simpl. try reflexivity. } }
                  { eapply T_Concat.
                    { eapply T_Expression.
                      eapply T_Assign.
                      { eapply T_Var with(x:="diff").
                        simpl. try reflexivity. }
                      { eapply T_BitAnd.
                        { eapply T_Var with(x:="diff").
                          simpl. try reflexivity. }
                        { eapply T_Sub.
                          { eapply T_Var with(x:="diff").
                            simpl. try reflexivity. }
                          { eapply T_Integer with(n:=1). }
                          { simpl. try reflexivity. } }
                        { simpl. try reflexivity. } }
                      { simpl. try reflexivity. } }
                    { eapply T_Concat.
                      { eapply T_Expression.
                        eapply T_PostInc.
                        eapply T_Var with(x:="count").
                        simpl. try reflexivity. }
                      { eapply T_Skip. } } } }
                { eapply T_Concat.
                  { eapply T_IfElse.
                    { eapply T_Or.
                      { eapply T_Eq.
                        { eapply T_Var with(x:="c").
                          simpl. try reflexivity. }
                        { eapply T_Neg.
                          eapply T_Integer with(n:=1). }
                        { simpl. try reflexivity. } }
                      { eapply T_Gt.
                        { eapply T_Var with(x:="count").
                          simpl. try reflexivity. }
                        { eapply T_Integer with(n:=2). }
                        { simpl. try reflexivity. } } }
                    { eapply T_Concat.
                      { eapply T_Return.
                        { eapply T_String with(s:="Yes"). }
                        { simpl. try reflexivity. }
                        { simpl. try reflexivity. } }
                      { eapply T_Skip. } }
                    { eapply T_IfElse.
                      { eapply T_Eq.
                        { eapply T_Var with(x:="count").
                          simpl. try reflexivity. }
                        { eapply T_Integer with(n:=2). }
                        { simpl. try reflexivity. } }
                      { eapply T_Concat.
                        { eapply T_Return.
                          { eapply T_String with(s:="No"). }
                          { simpl. try reflexivity. }
                          { simpl. try reflexivity. } }
                        { eapply T_Skip. } }
                      { eapply T_If.
                        { eapply T_Eq.
                          { eapply T_Var with(x:="count").
                            simpl. try reflexivity. }
                          { eapply T_Integer with(n:=1). }
                          { simpl. try reflexivity. } }
                        { eapply T_Concat.
                          { eapply T_Return.
                            { eapply T_String with(s:="Yes"). }
                            { simpl. try reflexivity. }
                            { simpl. try reflexivity. } }
                          { eapply T_Skip. } } } } }
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