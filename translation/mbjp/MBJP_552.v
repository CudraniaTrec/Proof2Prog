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
      { eapply T_ClassDecl with(name:="SeqLinear").
        { simpl. try reflexivity. }
        { eapply T_MethodDecl with(modif:="public static")(T:=TyString)(m:="seqLinear").
          { simpl. try reflexivity. }
          { eapply T_Concat.
            { eapply T_DeclNoInit with(T:=(TyGeneric1 "List" TyInt))(x:="seqNums").
              simpl. try reflexivity. }
            { eapply T_Skip. } }
          { simpl. try reflexivity. }
          { eapply T_Concat.
            { eapply T_Concat.
              { eapply T_DeclInit with(T:=(TyArray TyString))(x:="seqNumsArr").
                { simpl. try reflexivity. }
                { eapply T_NewArrayNoInit' with(T:=TyString).
                  { eapply T_MethodInvocation with(m:="size").
                    { eapply T_Var with(x:="seqNums").
                      simpl. try reflexivity. }
                    { simpl. try reflexivity. }
                    { simpl. try reflexivity. }
                    { eapply T_Nil. }
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
                  { eapply T_MethodInvocation with(m:="size").
                    { eapply T_Var with(x:="seqNums").
                      simpl. try reflexivity. }
                    { simpl. try reflexivity. }
                    { simpl. try reflexivity. }
                    { eapply T_Nil. }
                    { simpl. try reflexivity. } }
                  { simpl. try reflexivity. } }
                { eapply T_PostInc.
                  eapply T_Var with(x:="i").
                  simpl. try reflexivity. }
                { eapply T_Concat.
                  { eapply T_Expression.
                    eapply T_Assign.
                    { eapply T_ArrayAccess.
                      { eapply T_Var with(x:="seqNumsArr").
                        simpl. try reflexivity. }
                      { eapply T_Var with(x:="i").
                        simpl. try reflexivity. } }
                    { eapply T_MethodInvocation with(m:="toString").
                      { eapply T_MethodInvocation with(m:="get").
                        { eapply T_Var with(x:="seqNums").
                          simpl. try reflexivity. }
                        { simpl. try reflexivity. }
                        { simpl. try reflexivity. }
                        { eapply T_List.
                          { eapply T_Var with(x:="i").
                            simpl. try reflexivity. }
                          { eapply T_Nil. } }
                        { simpl. try reflexivity. } }
                      { simpl. try reflexivity. }
                      { simpl. try reflexivity. }
                      { eapply T_Nil. }
                      { simpl. try reflexivity. } }
                    { simpl. try reflexivity. } }
                  { eapply T_Skip. } } }
              { eapply T_Concat.
                { eapply T_Expression.
                  eapply T_TyMethodInvocation with(m:="sort")(T:=(TyExternal "Arrays")).
                  { simpl. try reflexivity. }
                  { simpl. try reflexivity. }
                  { eapply T_List.
                    { eapply T_Var with(x:="seqNumsArr").
                      simpl. try reflexivity. }
                    { eapply T_List.
                      { eapply T_TyMethodInvocation with(m:="reverseOrder")(T:=(TyExternal "Collections")).
                        { simpl. try reflexivity. }
                        { simpl. try reflexivity. }
                        { eapply T_Nil. }
                        { simpl. try reflexivity. } }
                      { eapply T_Nil. } } }
                  { simpl. try reflexivity. } }
                { eapply T_Concat.
                  { eapply T_Concat.
                    { eapply T_DeclInit with(T:=TyString)(x:="seqNumsSorted").
                      { simpl. try reflexivity. }
                      { eapply T_String with(s:=""). }
                      { simpl. try reflexivity. } }
                    { eapply T_Skip. } }
                  { eapply T_Concat.
                    { eapply T_Foreach with(T:=TyString)(x:="s").
                      { simpl. try reflexivity. }
                      { eapply T_Var with(x:="seqNumsArr").
                        simpl. try reflexivity. }
                      { simpl. try reflexivity. }
                      { eapply T_Concat.
                        { eapply T_Expression.
                          eapply T_Assign.
                          { eapply T_Var with(x:="seqNumsSorted").
                            simpl. try reflexivity. }
                          { eapply T_Add.
                            { eapply T_Var with(x:="seqNumsSorted").
                              simpl. try reflexivity. }
                            { eapply T_Var with(x:="s").
                              simpl. try reflexivity. }
                            { simpl. try reflexivity. } }
                          { simpl. try reflexivity. } }
                        { eapply T_Skip. } } }
                    { eapply T_Concat.
                      { eapply T_If.
                        { eapply T_And.
                          { eapply T_And.
                            { eapply T_MethodInvocation with(m:="contains").
                              { eapply T_Var with(x:="seqNumsSorted").
                                simpl. try reflexivity. }
                              { simpl. try reflexivity. }
                              { simpl. try reflexivity. }
                              { eapply T_List.
                                { eapply T_String with(s:="1"). }
                                { eapply T_Nil. } }
                              { simpl. try reflexivity. } }
                            { eapply T_MethodInvocation with(m:="contains").
                              { eapply T_Var with(x:="seqNumsSorted").
                                simpl. try reflexivity. }
                              { simpl. try reflexivity. }
                              { simpl. try reflexivity. }
                              { eapply T_List.
                                { eapply T_String with(s:="2"). }
                                { eapply T_Nil. } }
                              { simpl. try reflexivity. } } }
                          { eapply T_MethodInvocation with(m:="contains").
                            { eapply T_Var with(x:="seqNumsSorted").
                              simpl. try reflexivity. }
                            { simpl. try reflexivity. }
                            { simpl. try reflexivity. }
                            { eapply T_List.
                              { eapply T_String with(s:="3"). }
                              { eapply T_Nil. } }
                            { simpl. try reflexivity. } } }
                        { eapply T_Concat.
                          { eapply T_Return.
                            { eapply T_String with(s:="Linear Sequence"). }
                            { simpl. try reflexivity. }
                            { simpl. try reflexivity. } }
                          { eapply T_Skip. } } }
                      { eapply T_Concat.
                        { eapply T_If.
                          { eapply T_And.
                            { eapply T_And.
                              { eapply T_MethodInvocation with(m:="contains").
                                { eapply T_Var with(x:="seqNumsSorted").
                                  simpl. try reflexivity. }
                                { simpl. try reflexivity. }
                                { simpl. try reflexivity. }
                                { eapply T_List.
                                  { eapply T_String with(s:="1"). }
                                  { eapply T_Nil. } }
                                { simpl. try reflexivity. } }
                              { eapply T_MethodInvocation with(m:="contains").
                                { eapply T_Var with(x:="seqNumsSorted").
                                  simpl. try reflexivity. }
                                { simpl. try reflexivity. }
                                { simpl. try reflexivity. }
                                { eapply T_List.
                                  { eapply T_String with(s:="5"). }
                                  { eapply T_Nil. } }
                                { simpl. try reflexivity. } } }
                            { eapply T_MethodInvocation with(m:="contains").
                              { eapply T_Var with(x:="seqNumsSorted").
                                simpl. try reflexivity. }
                              { simpl. try reflexivity. }
                              { simpl. try reflexivity. }
                              { eapply T_List.
                                { eapply T_String with(s:="2"). }
                                { eapply T_Nil. } }
                              { simpl. try reflexivity. } } }
                          { eapply T_Concat.
                            { eapply T_Return.
                              { eapply T_String with(s:="Non Linear Sequence"). }
                              { simpl. try reflexivity. }
                              { simpl. try reflexivity. } }
                            { eapply T_Skip. } } }
                        { eapply T_Concat.
                          { eapply T_Return.
                            { eapply T_String with(s:="Linear Sequence"). }
                            { simpl. try reflexivity. }
                            { simpl. try reflexivity. } }
                          { eapply T_Skip. } } } } } } } } } } } } } }
  Unshelve.
  all: apply STyVoid.
Defined.
Definition prog := the_exists_term (prog_well_typed).
Print prog.