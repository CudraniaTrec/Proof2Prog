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
      { eapply T_ClassDecl with(name:="MultipleToSingle").
        { simpl. try reflexivity. }
        { eapply T_MethodDecl with(modif:="public static")(T:=TyInt)(m:="multipleToSingle").
          { simpl. try reflexivity. }
          { eapply T_Concat.
            { eapply T_DeclNoInit with(T:=(TyGeneric1 "List" TyInt))(x:="l").
              simpl. try reflexivity. }
            { eapply T_Skip. } }
          { simpl. try reflexivity. }
          { eapply T_Concat.
            { eapply T_Concat.
              { eapply T_DeclInit with(T:=(TyArray TyInt))(x:="temp").
                { simpl. try reflexivity. }
                { eapply T_NewArrayNoInit' with(T:=TyInt).
                  { eapply T_MethodInvocation with(m:="size").
                    { eapply T_Var with(x:="l").
                      simpl. try reflexivity. }
                    { simpl. try reflexivity. }
                    { simpl. try reflexivity. }
                    { eapply T_Nil. }
                    { simpl. try reflexivity. } }
                  { eapply T_NewArrayNoInit with(T:=TyInt). } }
                { simpl. try reflexivity. } }
              { eapply T_Skip. } }
            { eapply T_Concat.
              { eapply T_For.
                { eapply T_Concat.
                  { eapply T_DeclInit with(T:=TyInt)(x:="i").
                    { simpl. try reflexivity. }
                    { eapply T_Integer with(n:=0). }
                    { simpl. try reflexivity. } }
                  { eapply T_Skip. } }
                { eapply T_Lt.
                  { eapply T_Var with(x:="i").
                    simpl. try reflexivity. }
                  { eapply T_FieldAccess with(f:="length").
                    { eapply T_Var with(x:="temp").
                      simpl. try reflexivity. }
                    { simpl. try reflexivity. }
                    { simpl. try reflexivity. } }
                  { simpl. try reflexivity. } }
                { eapply T_PostInc.
                  eapply T_Var with(x:="i").
                  simpl. try reflexivity. }
                { eapply T_Concat.
                  { eapply T_Expression.
                    eapply T_Assign.
                    { eapply T_ArrayAccess.
                      { eapply T_Var with(x:="temp").
                        simpl. try reflexivity. }
                      { eapply T_Var with(x:="i").
                        simpl. try reflexivity. } }
                    { eapply T_MethodInvocation with(m:="get").
                      { eapply T_Var with(x:="l").
                        simpl. try reflexivity. }
                      { simpl. try reflexivity. }
                      { simpl. try reflexivity. }
                      { eapply T_List.
                        { eapply T_Var with(x:="i").
                          simpl. try reflexivity. }
                        { eapply T_Nil. } }
                      { simpl. try reflexivity. } }
                    { simpl. try reflexivity. } }
                  { eapply T_Skip. } } }
              { eapply T_Concat.
                { eapply T_Concat.
                  { eapply T_DeclInit with(T:=(TyArray TyString))(x:="str").
                    { simpl. try reflexivity. }
                    { eapply T_NewArrayNoInit' with(T:=TyString).
                      { eapply T_FieldAccess with(f:="length").
                        { eapply T_Var with(x:="temp").
                          simpl. try reflexivity. }
                        { simpl. try reflexivity. }
                        { simpl. try reflexivity. } }
                      { eapply T_NewArrayNoInit with(T:=TyString). } }
                    { simpl. try reflexivity. } }
                  { eapply T_Skip. } }
                { eapply T_Concat.
                  { eapply T_For.
                    { eapply T_Concat.
                      { eapply T_DeclInit with(T:=TyInt)(x:="i").
                        { simpl. try reflexivity. }
                        { eapply T_Integer with(n:=0). }
                        { simpl. try reflexivity. } }
                      { eapply T_Skip. } }
                    { eapply T_Lt.
                      { eapply T_Var with(x:="i").
                        simpl. try reflexivity. }
                      { eapply T_FieldAccess with(f:="length").
                        { eapply T_Var with(x:="temp").
                          simpl. try reflexivity. }
                        { simpl. try reflexivity. }
                        { simpl. try reflexivity. } }
                      { simpl. try reflexivity. } }
                    { eapply T_PostInc.
                      eapply T_Var with(x:="i").
                      simpl. try reflexivity. }
                    { eapply T_Concat.
                      { eapply T_Expression.
                        eapply T_Assign.
                        { eapply T_ArrayAccess.
                          { eapply T_Var with(x:="str").
                            simpl. try reflexivity. }
                          { eapply T_Var with(x:="i").
                            simpl. try reflexivity. } }
                        { eapply T_TyMethodInvocation with(m:="toString")(T:=(TyExternal "Integer")).
                          { simpl. try reflexivity. }
                          { simpl. try reflexivity. }
                          { eapply T_List.
                            { eapply T_ArrayAccess.
                              { eapply T_Var with(x:="temp").
                                simpl. try reflexivity. }
                              { eapply T_Var with(x:="i").
                                simpl. try reflexivity. } }
                            { eapply T_Nil. } }
                          { simpl. try reflexivity. } }
                        { simpl. try reflexivity. } }
                      { eapply T_Skip. } } }
                  { eapply T_Concat.
                    { eapply T_Concat.
                      { eapply T_DeclInit with(T:=(TyExternal "StringBuilder"))(x:="sb").
                        { simpl. try reflexivity. }
                        { eapply T_New' with(T:=(TyExternal "StringBuilder")).
                          { simpl. try reflexivity. }
                          { eapply T_Nil. } }
                        { simpl. try reflexivity. } }
                      { eapply T_Skip. } }
                    { eapply T_Concat.
                      { eapply T_For.
                        { eapply T_Concat.
                          { eapply T_DeclInit with(T:=TyInt)(x:="i").
                            { simpl. try reflexivity. }
                            { eapply T_Integer with(n:=0). }
                            { simpl. try reflexivity. } }
                          { eapply T_Skip. } }
                        { eapply T_Lt.
                          { eapply T_Var with(x:="i").
                            simpl. try reflexivity. }
                          { eapply T_FieldAccess with(f:="length").
                            { eapply T_Var with(x:="str").
                              simpl. try reflexivity. }
                            { simpl. try reflexivity. }
                            { simpl. try reflexivity. } }
                          { simpl. try reflexivity. } }
                        { eapply T_PostInc.
                          eapply T_Var with(x:="i").
                          simpl. try reflexivity. }
                        { eapply T_Concat.
                          { eapply T_Expression.
                            eapply T_MethodInvocation with(m:="append").
                            { eapply T_Var with(x:="sb").
                              simpl. try reflexivity. }
                            { simpl. try reflexivity. }
                            { simpl. try reflexivity. }
                            { eapply T_List.
                              { eapply T_ArrayAccess.
                                { eapply T_Var with(x:="str").
                                  simpl. try reflexivity. }
                                { eapply T_Var with(x:="i").
                                  simpl. try reflexivity. } }
                              { eapply T_Nil. } }
                            { simpl. try reflexivity. } }
                          { eapply T_Skip. } } }
                      { eapply T_Concat.
                        { eapply T_Concat.
                          { eapply T_DeclInit with(T:=TyString)(x:="result").
                            { simpl. try reflexivity. }
                            { eapply T_MethodInvocation with(m:="toString").
                              { eapply T_Var with(x:="sb").
                                simpl. try reflexivity. }
                              { simpl. try reflexivity. }
                              { simpl. try reflexivity. }
                              { eapply T_Nil. }
                              { simpl. try reflexivity. } }
                            { simpl. try reflexivity. } }
                          { eapply T_Skip. } }
                        { eapply T_Concat.
                          { eapply T_Return.
                            { eapply T_TyMethodInvocation with(m:="parseInt")(T:=(TyExternal "Integer")).
                              { simpl. try reflexivity. }
                              { simpl. try reflexivity. }
                              { eapply T_List.
                                { eapply T_Var with(x:="result").
                                  simpl. try reflexivity. }
                                { eapply T_Nil. } }
                              { simpl. try reflexivity. } }
                            { simpl. try reflexivity. }
                            { simpl. try reflexivity. } }
                          { eapply T_Skip. } } } } } } } } } } } } } }
  Unshelve.
  all: apply STyVoid.
Defined.
Definition prog := the_exists_term (prog_well_typed).
Print prog.