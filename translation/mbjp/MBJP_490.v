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
      { eapply T_ClassDecl with(name:="ExtractSymmetric").
        { simpl. try reflexivity. }
        { eapply T_MethodDecl with(modif:="public static")(T:=(TyGeneric1 "HashSet" (TyGeneric1 "List" TyInt)))(m:="extractSymmetric").
          { simpl. try reflexivity. }
          { eapply T_Concat.
            { eapply T_DeclNoInit with(T:=(TyGeneric1 "List" (TyGeneric1 "List" TyInt)))(x:="testList").
              simpl. try reflexivity. }
            { eapply T_Skip. } }
          { simpl. try reflexivity. }
          { eapply T_Concat.
            { eapply T_Concat.
              { eapply T_DeclInit with(T:=(TyGeneric1 "HashSet" (TyGeneric1 "List" TyInt)))(x:="symmetricPairs").
                { simpl. try reflexivity. }
                { eapply T_New' with(T:=(TyGeneric1 "HashSet" (TyGeneric1 "List" TyInt))).
                  { simpl. try reflexivity. }
                  { eapply T_Nil. } }
                { simpl. try reflexivity. } }
              { eapply T_Skip. } }
            { eapply T_Concat.
              { eapply T_Concat.
                { eapply T_DeclInit with(T:=(TyGeneric1 "HashSet" (TyGeneric1 "List" TyInt)))(x:="seenPairs").
                  { simpl. try reflexivity. }
                  { eapply T_New' with(T:=(TyGeneric1 "HashSet" (TyGeneric1 "List" TyInt))).
                    { simpl. try reflexivity. }
                    { eapply T_Nil. } }
                  { simpl. try reflexivity. } }
                { eapply T_Skip. } }
              { eapply T_Concat.
                { eapply T_Foreach with(T:=(TyGeneric1 "List" TyInt))(x:="pair").
                  { simpl. try reflexivity. }
                  { eapply T_Var with(x:="testList").
                    simpl. try reflexivity. }
                  { simpl. try reflexivity. }
                  { eapply T_Concat.
                    { eapply T_Concat.
                      { eapply T_DeclInit with(T:=TyInt)(x:="smaller").
                        { simpl. try reflexivity. }
                        { eapply T_Choose.
                          { eapply T_Lt.
                            { eapply T_MethodInvocation with(m:="get").
                              { eapply T_Var with(x:="pair").
                                simpl. try reflexivity. }
                              { simpl. try reflexivity. }
                              { simpl. try reflexivity. }
                              { eapply T_List.
                                { eapply T_Integer with(n:=0). }
                                { eapply T_Nil. } }
                              { simpl. try reflexivity. } }
                            { eapply T_MethodInvocation with(m:="get").
                              { eapply T_Var with(x:="pair").
                                simpl. try reflexivity. }
                              { simpl. try reflexivity. }
                              { simpl. try reflexivity. }
                              { eapply T_List.
                                { eapply T_Integer with(n:=1). }
                                { eapply T_Nil. } }
                              { simpl. try reflexivity. } }
                            { simpl. try reflexivity. } }
                          { eapply T_MethodInvocation with(m:="get").
                            { eapply T_Var with(x:="pair").
                              simpl. try reflexivity. }
                            { simpl. try reflexivity. }
                            { simpl. try reflexivity. }
                            { eapply T_List.
                              { eapply T_Integer with(n:=0). }
                              { eapply T_Nil. } }
                            { simpl. try reflexivity. } }
                          { eapply T_MethodInvocation with(m:="get").
                            { eapply T_Var with(x:="pair").
                              simpl. try reflexivity. }
                            { simpl. try reflexivity. }
                            { simpl. try reflexivity. }
                            { eapply T_List.
                              { eapply T_Integer with(n:=1). }
                              { eapply T_Nil. } }
                            { simpl. try reflexivity. } }
                          { simpl. try reflexivity. } }
                        { simpl. try reflexivity. } }
                      { eapply T_Skip. } }
                    { eapply T_Concat.
                      { eapply T_Concat.
                        { eapply T_DeclInit with(T:=TyInt)(x:="greater").
                          { simpl. try reflexivity. }
                          { eapply T_Choose.
                            { eapply T_Lt.
                              { eapply T_MethodInvocation with(m:="get").
                                { eapply T_Var with(x:="pair").
                                  simpl. try reflexivity. }
                                { simpl. try reflexivity. }
                                { simpl. try reflexivity. }
                                { eapply T_List.
                                  { eapply T_Integer with(n:=0). }
                                  { eapply T_Nil. } }
                                { simpl. try reflexivity. } }
                              { eapply T_MethodInvocation with(m:="get").
                                { eapply T_Var with(x:="pair").
                                  simpl. try reflexivity. }
                                { simpl. try reflexivity. }
                                { simpl. try reflexivity. }
                                { eapply T_List.
                                  { eapply T_Integer with(n:=1). }
                                  { eapply T_Nil. } }
                                { simpl. try reflexivity. } }
                              { simpl. try reflexivity. } }
                            { eapply T_MethodInvocation with(m:="get").
                              { eapply T_Var with(x:="pair").
                                simpl. try reflexivity. }
                              { simpl. try reflexivity. }
                              { simpl. try reflexivity. }
                              { eapply T_List.
                                { eapply T_Integer with(n:=1). }
                                { eapply T_Nil. } }
                              { simpl. try reflexivity. } }
                            { eapply T_MethodInvocation with(m:="get").
                              { eapply T_Var with(x:="pair").
                                simpl. try reflexivity. }
                              { simpl. try reflexivity. }
                              { simpl. try reflexivity. }
                              { eapply T_List.
                                { eapply T_Integer with(n:=0). }
                                { eapply T_Nil. } }
                              { simpl. try reflexivity. } }
                            { simpl. try reflexivity. } }
                          { simpl. try reflexivity. } }
                        { eapply T_Skip. } }
                      { eapply T_Concat.
                        { eapply T_If.
                          { eapply T_Not.
                            eapply T_MethodInvocation with(m:="add").
                            { eapply T_Var with(x:="seenPairs").
                              simpl. try reflexivity. }
                            { simpl. try reflexivity. }
                            { simpl. try reflexivity. }
                            { eapply T_List.
                              { eapply T_TyMethodInvocation with(m:="asList")(T:=(TyExternal "Arrays")).
                                { simpl. try reflexivity. }
                                { simpl. try reflexivity. }
                                { eapply T_List.
                                  { eapply T_Var with(x:="smaller").
                                    simpl. try reflexivity. }
                                  { eapply T_List.
                                    { eapply T_Var with(x:="greater").
                                      simpl. try reflexivity. }
                                    { eapply T_Nil. } } }
                                { simpl. try reflexivity. } }
                              { eapply T_Nil. } }
                            { simpl. try reflexivity. } }
                          { eapply T_Concat.
                            { eapply T_Expression.
                              eapply T_MethodInvocation with(m:="add").
                              { eapply T_Var with(x:="symmetricPairs").
                                simpl. try reflexivity. }
                              { simpl. try reflexivity. }
                              { simpl. try reflexivity. }
                              { eapply T_List.
                                { eapply T_TyMethodInvocation with(m:="asList")(T:=(TyExternal "Arrays")).
                                  { simpl. try reflexivity. }
                                  { simpl. try reflexivity. }
                                  { eapply T_List.
                                    { eapply T_Var with(x:="smaller").
                                      simpl. try reflexivity. }
                                    { eapply T_List.
                                      { eapply T_Var with(x:="greater").
                                        simpl. try reflexivity. }
                                      { eapply T_Nil. } } }
                                  { simpl. try reflexivity. } }
                                { eapply T_Nil. } }
                              { simpl. try reflexivity. } }
                            { eapply T_Skip. } } }
                        { eapply T_Skip. } } } } }
                { eapply T_Concat.
                  { eapply T_Return.
                    { eapply T_Var with(x:="symmetricPairs").
                      simpl. try reflexivity. }
                    { simpl. try reflexivity. }
                    { simpl. try reflexivity. } }
                  { eapply T_Skip. } } } } } } } } } }
  Unshelve.
  all: apply STyVoid.
Defined.
Definition prog := the_exists_term (prog_well_typed).
Print prog.