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
      { eapply T_ClassDecl with(name:="ExtractDate").
        { simpl. try reflexivity. }
        { eapply T_MethodDecl with(modif:="public static")(T:=(TyGeneric1 "List" (TyGeneric1 "List" TyString)))(m:="extractDate").
          { simpl. try reflexivity. }
          { eapply T_Concat.
            { eapply T_DeclNoInit with(T:=TyString)(x:="url").
              simpl. try reflexivity. }
            { eapply T_Skip. } }
          { simpl. try reflexivity. }
          { eapply T_Concat.
            { eapply T_Concat.
              { eapply T_DeclInit with(T:=(TyGeneric1 "List" (TyGeneric1 "List" TyString)))(x:="result").
                { simpl. try reflexivity. }
                { eapply T_New' with(T:=(TyGeneric1 "ArrayList" (TyGeneric1 "List" TyString))).
                  { simpl. try reflexivity. }
                  { eapply T_Nil. } }
                { simpl. try reflexivity. } }
              { eapply T_Skip. } }
            { eapply T_Concat.
              { eapply T_If.
                { eapply T_Eq.
                  { eapply T_Var with(x:="url").
                    simpl. try reflexivity. }
                  { eapply T_Null. }
                  { simpl. try reflexivity. } }
                { eapply T_Concat.
                  { eapply T_Return.
                    { eapply T_Var with(x:="result").
                      simpl. try reflexivity. }
                    { simpl. try reflexivity. }
                    { simpl. try reflexivity. } }
                  { eapply T_Skip. } } }
              { eapply T_Concat.
                { eapply T_Concat.
                  { eapply T_DeclInit with(T:=(TyArray (TyArray TyString)))(x:="dates").
                    { simpl. try reflexivity. }
                    { eapply T_NewArrayInit with(T:=(TyArray (TyArray TyString))).
                      { simpl. try reflexivity. }
                      { eapply T_ArrayConcat.
                        { eapply T_ArrayConcat.
                          { eapply T_String with(s:="2016"). }
                          { eapply T_ArrayConcat.
                            { eapply T_String with(s:="09"). }
                            { eapply T_ArrayConcat.
                              { eapply T_String with(s:="02"). }
                              { eapply T_EmptyArray. } } } }
                        { eapply T_ArrayConcat.
                          { eapply T_ArrayConcat.
                            { eapply T_String with(s:="2020"). }
                            { eapply T_ArrayConcat.
                              { eapply T_String with(s:="11"). }
                              { eapply T_ArrayConcat.
                                { eapply T_String with(s:="03"). }
                                { eapply T_EmptyArray. } } } }
                          { eapply T_ArrayConcat.
                            { eapply T_ArrayConcat.
                              { eapply T_String with(s:="2020"). }
                              { eapply T_ArrayConcat.
                                { eapply T_String with(s:="12"). }
                                { eapply T_ArrayConcat.
                                  { eapply T_String with(s:="29"). }
                                  { eapply T_EmptyArray. } } } }
                            { eapply T_EmptyArray. } } } } }
                    { simpl. try reflexivity. } }
                  { eapply T_Skip. } }
                { eapply T_Concat.
                  { eapply T_Concat.
                    { eapply T_DeclInit with(T:=TyInt)(x:="match").
                      { simpl. try reflexivity. }
                      { eapply T_Neg.
                        eapply T_Integer with(n:=1). }
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
                          { eapply T_Var with(x:="dates").
                            simpl. try reflexivity. }
                          { simpl. try reflexivity. }
                          { simpl. try reflexivity. } }
                        { simpl. try reflexivity. } }
                      { eapply T_PostInc.
                        eapply T_Var with(x:="i").
                        simpl. try reflexivity. }
                      { eapply T_Concat.
                        { eapply T_If.
                          { eapply T_MethodInvocation with(m:="contains").
                            { eapply T_Var with(x:="url").
                              simpl. try reflexivity. }
                            { simpl. try reflexivity. }
                            { simpl. try reflexivity. }
                            { eapply T_List.
                              { eapply T_Add.
                                { eapply T_Add.
                                  { eapply T_Add.
                                    { eapply T_Add.
                                      { eapply T_ArrayAccess.
                                        { eapply T_ArrayAccess.
                                          { eapply T_Var with(x:="dates").
                                            simpl. try reflexivity. }
                                          { eapply T_Var with(x:="i").
                                            simpl. try reflexivity. } }
                                        { eapply T_Integer with(n:=0). } }
                                      { eapply T_String with(s:="/"). }
                                      { simpl. try reflexivity. } }
                                    { eapply T_ArrayAccess.
                                      { eapply T_ArrayAccess.
                                        { eapply T_Var with(x:="dates").
                                          simpl. try reflexivity. }
                                        { eapply T_Var with(x:="i").
                                          simpl. try reflexivity. } }
                                      { eapply T_Integer with(n:=1). } }
                                    { simpl. try reflexivity. } }
                                  { eapply T_String with(s:="/"). }
                                  { simpl. try reflexivity. } }
                                { eapply T_ArrayAccess.
                                  { eapply T_ArrayAccess.
                                    { eapply T_Var with(x:="dates").
                                      simpl. try reflexivity. }
                                    { eapply T_Var with(x:="i").
                                      simpl. try reflexivity. } }
                                  { eapply T_Integer with(n:=2). } }
                                { simpl. try reflexivity. } }
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
                                { eapply T_TyMethodInvocation with(m:="asList")(T:=(TyExternal "Arrays")).
                                  { simpl. try reflexivity. }
                                  { simpl. try reflexivity. }
                                  { eapply T_List.
                                    { eapply T_ArrayAccess.
                                      { eapply T_Var with(x:="dates").
                                        simpl. try reflexivity. }
                                      { eapply T_Var with(x:="i").
                                        simpl. try reflexivity. } }
                                    { eapply T_Nil. } }
                                  { simpl. try reflexivity. } }
                                { eapply T_Nil. } }
                              { simpl. try reflexivity. } }
                            { eapply T_Concat.
                              { eapply T_Expression.
                                eapply T_Assign.
                                { eapply T_Var with(x:="match").
                                  simpl. try reflexivity. }
                                { eapply T_Var with(x:="i").
                                  simpl. try reflexivity. }
                                { simpl. try reflexivity. } }
                              { eapply T_Concat.
                                { eapply T_Break. }
                                { eapply T_Skip. } } } } }
                        { eapply T_Skip. } } }
                    { eapply T_Concat.
                      { eapply T_If.
                        { eapply T_Ne.
                          { eapply T_Var with(x:="match").
                            simpl. try reflexivity. }
                          { eapply T_Neg.
                            eapply T_Integer with(n:=1). }
                          { simpl. try reflexivity. } }
                        { eapply T_Concat.
                          { eapply T_Return.
                            { eapply T_Var with(x:="result").
                              simpl. try reflexivity. }
                            { simpl. try reflexivity. }
                            { simpl. try reflexivity. } }
                          { eapply T_Skip. } } }
                      { eapply T_Concat.
                        { eapply T_Return.
                          { eapply T_Var with(x:="result").
                            simpl. try reflexivity. }
                          { simpl. try reflexivity. }
                          { simpl. try reflexivity. } }
                        { eapply T_Skip. } } } } } } } } } } } } }
  Unshelve.
  all: apply STyVoid.
Defined.
Definition prog := the_exists_term (prog_well_typed).
Print prog.