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
      { eapply T_ClassDecl with(name:="LcsOfThree").
        { simpl. try reflexivity. }
        { eapply T_MethodDecl with(modif:="public static")(T:=TyInt)(m:="lcsOfThree").
          { simpl. try reflexivity. }
          { eapply T_Concat.
            { eapply T_DeclNoInit with(T:=TyString)(x:="x").
              simpl. try reflexivity. }
            { eapply T_Concat.
              { eapply T_DeclNoInit with(T:=TyString)(x:="y").
                simpl. try reflexivity. }
              { eapply T_Concat.
                { eapply T_DeclNoInit with(T:=TyString)(x:="z").
                  simpl. try reflexivity. }
                { eapply T_Concat.
                  { eapply T_DeclNoInit with(T:=TyInt)(x:="m").
                    simpl. try reflexivity. }
                  { eapply T_Concat.
                    { eapply T_DeclNoInit with(T:=TyInt)(x:="n").
                      simpl. try reflexivity. }
                    { eapply T_Concat.
                      { eapply T_DeclNoInit with(T:=TyInt)(x:="o").
                        simpl. try reflexivity. }
                      { eapply T_Skip. } } } } } } }
          { simpl. try reflexivity. }
          { eapply T_Concat.
            { eapply T_Concat.
              { eapply T_DeclInit with(T:=(TyArray (TyArray (TyArray TyInt))))(x:="dp").
                { simpl. try reflexivity. }
                { eapply T_NewArrayNoInit' with(T:=TyInt).
                  { eapply T_Add.
                    { eapply T_Var with(x:="m").
                      simpl. try reflexivity. }
                    { eapply T_Integer with(n:=1). }
                    { simpl. try reflexivity. } }
                  { eapply T_NewArrayNoInit' with(T:=TyInt).
                    { eapply T_Add.
                      { eapply T_Var with(x:="n").
                        simpl. try reflexivity. }
                      { eapply T_Integer with(n:=1). }
                      { simpl. try reflexivity. } }
                    { eapply T_NewArrayNoInit' with(T:=TyInt).
                      { eapply T_Add.
                        { eapply T_Var with(x:="o").
                          simpl. try reflexivity. }
                        { eapply T_Integer with(n:=1). }
                        { simpl. try reflexivity. } }
                      { eapply T_NewArrayNoInit with(T:=TyInt). } } } }
                { simpl. try reflexivity. } }
              { eapply T_Skip. } }
            { eapply T_Concat.
              { eapply T_For.
                { eapply T_Concat.
                  { eapply T_DeclInit with(T:=TyInt)(x:="i").
                    { simpl. try reflexivity. }
                    { eapply T_Integer with(n:=1). }
                    { simpl. try reflexivity. } }
                  { eapply T_Skip. } }
                { eapply T_Le.
                  { eapply T_Var with(x:="i").
                    simpl. try reflexivity. }
                  { eapply T_Var with(x:="m").
                    simpl. try reflexivity. }
                  { simpl. try reflexivity. } }
                { eapply T_PostInc.
                  eapply T_Var with(x:="i").
                  simpl. try reflexivity. }
                { eapply T_Concat.
                  { eapply T_For.
                    { eapply T_Concat.
                      { eapply T_DeclInit with(T:=TyInt)(x:="j").
                        { simpl. try reflexivity. }
                        { eapply T_Integer with(n:=1). }
                        { simpl. try reflexivity. } }
                      { eapply T_Skip. } }
                    { eapply T_Le.
                      { eapply T_Var with(x:="j").
                        simpl. try reflexivity. }
                      { eapply T_Var with(x:="n").
                        simpl. try reflexivity. }
                      { simpl. try reflexivity. } }
                    { eapply T_PostInc.
                      eapply T_Var with(x:="j").
                      simpl. try reflexivity. }
                    { eapply T_Concat.
                      { eapply T_For.
                        { eapply T_Concat.
                          { eapply T_DeclInit with(T:=TyInt)(x:="k").
                            { simpl. try reflexivity. }
                            { eapply T_Integer with(n:=1). }
                            { simpl. try reflexivity. } }
                          { eapply T_Skip. } }
                        { eapply T_Le.
                          { eapply T_Var with(x:="k").
                            simpl. try reflexivity. }
                          { eapply T_Var with(x:="o").
                            simpl. try reflexivity. }
                          { simpl. try reflexivity. } }
                        { eapply T_PostInc.
                          eapply T_Var with(x:="k").
                          simpl. try reflexivity. }
                        { eapply T_Concat.
                          { eapply T_IfElse.
                            { eapply T_And.
                              { eapply T_Eq.
                                { eapply T_MethodInvocation with(m:="charAt").
                                  { eapply T_Var with(x:="x").
                                    simpl. try reflexivity. }
                                  { simpl. try reflexivity. }
                                  { simpl. try reflexivity. }
                                  { eapply T_List.
                                    { eapply T_Sub.
                                      { eapply T_Var with(x:="i").
                                        simpl. try reflexivity. }
                                      { eapply T_Integer with(n:=1). }
                                      { simpl. try reflexivity. } }
                                    { eapply T_Nil. } }
                                  { simpl. try reflexivity. } }
                                { eapply T_MethodInvocation with(m:="charAt").
                                  { eapply T_Var with(x:="y").
                                    simpl. try reflexivity. }
                                  { simpl. try reflexivity. }
                                  { simpl. try reflexivity. }
                                  { eapply T_List.
                                    { eapply T_Sub.
                                      { eapply T_Var with(x:="j").
                                        simpl. try reflexivity. }
                                      { eapply T_Integer with(n:=1). }
                                      { simpl. try reflexivity. } }
                                    { eapply T_Nil. } }
                                  { simpl. try reflexivity. } }
                                { simpl. try reflexivity. } }
                              { eapply T_Eq.
                                { eapply T_MethodInvocation with(m:="charAt").
                                  { eapply T_Var with(x:="x").
                                    simpl. try reflexivity. }
                                  { simpl. try reflexivity. }
                                  { simpl. try reflexivity. }
                                  { eapply T_List.
                                    { eapply T_Sub.
                                      { eapply T_Var with(x:="i").
                                        simpl. try reflexivity. }
                                      { eapply T_Integer with(n:=1). }
                                      { simpl. try reflexivity. } }
                                    { eapply T_Nil. } }
                                  { simpl. try reflexivity. } }
                                { eapply T_MethodInvocation with(m:="charAt").
                                  { eapply T_Var with(x:="z").
                                    simpl. try reflexivity. }
                                  { simpl. try reflexivity. }
                                  { simpl. try reflexivity. }
                                  { eapply T_List.
                                    { eapply T_Sub.
                                      { eapply T_Var with(x:="k").
                                        simpl. try reflexivity. }
                                      { eapply T_Integer with(n:=1). }
                                      { simpl. try reflexivity. } }
                                    { eapply T_Nil. } }
                                  { simpl. try reflexivity. } }
                                { simpl. try reflexivity. } } }
                            { eapply T_Concat.
                              { eapply T_Expression.
                                eapply T_Assign.
                                { eapply T_ArrayAccess.
                                  { eapply T_ArrayAccess.
                                    { eapply T_ArrayAccess.
                                      { eapply T_Var with(x:="dp").
                                        simpl. try reflexivity. }
                                      { eapply T_Var with(x:="i").
                                        simpl. try reflexivity. } }
                                    { eapply T_Var with(x:="j").
                                      simpl. try reflexivity. } }
                                  { eapply T_Var with(x:="k").
                                    simpl. try reflexivity. } }
                                { eapply T_Add.
                                  { eapply T_Integer with(n:=1). }
                                  { eapply T_ArrayAccess.
                                    { eapply T_ArrayAccess.
                                      { eapply T_ArrayAccess.
                                        { eapply T_Var with(x:="dp").
                                          simpl. try reflexivity. }
                                        { eapply T_Sub.
                                          { eapply T_Var with(x:="i").
                                            simpl. try reflexivity. }
                                          { eapply T_Integer with(n:=1). }
                                          { simpl. try reflexivity. } } }
                                      { eapply T_Sub.
                                        { eapply T_Var with(x:="j").
                                          simpl. try reflexivity. }
                                        { eapply T_Integer with(n:=1). }
                                        { simpl. try reflexivity. } } }
                                    { eapply T_Sub.
                                      { eapply T_Var with(x:="k").
                                        simpl. try reflexivity. }
                                      { eapply T_Integer with(n:=1). }
                                      { simpl. try reflexivity. } } }
                                  { simpl. try reflexivity. } }
                                { simpl. try reflexivity. } }
                              { eapply T_Skip. } }
                            { eapply T_Concat.
                              { eapply T_Expression.
                                eapply T_Assign.
                                { eapply T_ArrayAccess.
                                  { eapply T_ArrayAccess.
                                    { eapply T_ArrayAccess.
                                      { eapply T_Var with(x:="dp").
                                        simpl. try reflexivity. }
                                      { eapply T_Var with(x:="i").
                                        simpl. try reflexivity. } }
                                    { eapply T_Var with(x:="j").
                                      simpl. try reflexivity. } }
                                  { eapply T_Var with(x:="k").
                                    simpl. try reflexivity. } }
                                { eapply T_TyMethodInvocation with(m:="max")(T:=(TyExternal "Math")).
                                  { simpl. try reflexivity. }
                                  { simpl. try reflexivity. }
                                  { eapply T_List.
                                    { eapply T_ArrayAccess.
                                      { eapply T_ArrayAccess.
                                        { eapply T_ArrayAccess.
                                          { eapply T_Var with(x:="dp").
                                            simpl. try reflexivity. }
                                          { eapply T_Var with(x:="i").
                                            simpl. try reflexivity. } }
                                        { eapply T_Sub.
                                          { eapply T_Var with(x:="j").
                                            simpl. try reflexivity. }
                                          { eapply T_Integer with(n:=1). }
                                          { simpl. try reflexivity. } } }
                                      { eapply T_Var with(x:="k").
                                        simpl. try reflexivity. } }
                                    { eapply T_List.
                                      { eapply T_TyMethodInvocation with(m:="max")(T:=(TyExternal "Math")).
                                        { simpl. try reflexivity. }
                                        { simpl. try reflexivity. }
                                        { eapply T_List.
                                          { eapply T_ArrayAccess.
                                            { eapply T_ArrayAccess.
                                              { eapply T_ArrayAccess.
                                                { eapply T_Var with(x:="dp").
                                                  simpl. try reflexivity. }
                                                { eapply T_Sub.
                                                  { eapply T_Var with(x:="i").
                                                    simpl. try reflexivity. }
                                                  { eapply T_Integer with(n:=1). }
                                                  { simpl. try reflexivity. } } }
                                              { eapply T_Var with(x:="j").
                                                simpl. try reflexivity. } }
                                            { eapply T_Var with(x:="k").
                                              simpl. try reflexivity. } }
                                          { eapply T_List.
                                            { eapply T_ArrayAccess.
                                              { eapply T_ArrayAccess.
                                                { eapply T_ArrayAccess.
                                                  { eapply T_Var with(x:="dp").
                                                    simpl. try reflexivity. }
                                                  { eapply T_Var with(x:="i").
                                                    simpl. try reflexivity. } }
                                                { eapply T_Var with(x:="j").
                                                  simpl. try reflexivity. } }
                                              { eapply T_Sub.
                                                { eapply T_Var with(x:="k").
                                                  simpl. try reflexivity. }
                                                { eapply T_Integer with(n:=1). }
                                                { simpl. try reflexivity. } } }
                                            { eapply T_Nil. } } }
                                        { simpl. try reflexivity. } }
                                      { eapply T_Nil. } } }
                                  { simpl. try reflexivity. } }
                                { simpl. try reflexivity. } }
                              { eapply T_Skip. } } }
                          { eapply T_Skip. } } }
                      { eapply T_Skip. } } }
                  { eapply T_Skip. } } }
              { eapply T_Concat.
                { eapply T_Return.
                  { eapply T_ArrayAccess.
                    { eapply T_ArrayAccess.
                      { eapply T_ArrayAccess.
                        { eapply T_Var with(x:="dp").
                          simpl. try reflexivity. }
                        { eapply T_Var with(x:="m").
                          simpl. try reflexivity. } }
                      { eapply T_Var with(x:="n").
                        simpl. try reflexivity. } }
                    { eapply T_Var with(x:="o").
                      simpl. try reflexivity. } }
                  { simpl. try reflexivity. }
                  { simpl. try reflexivity. } }
                { eapply T_Skip. } } } } } } } } }
  Unshelve.
  all: apply STyVoid.
Defined.
Definition prog := the_exists_term (prog_well_typed).
Print prog.