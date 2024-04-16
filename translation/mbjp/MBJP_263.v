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
      { eapply T_ClassDecl with(name:="MergeDict").
        { simpl. try reflexivity. }
        { eapply T_MethodDecl with(modif:="public static")(T:=(TyGeneric2 "HashMap" TyString TyInt))(m:="mergeDict").
          { simpl. try reflexivity. }
          { eapply T_Concat.
            { eapply T_DeclNoInit with(T:=(TyGeneric2 "HashMap" TyString TyInt))(x:="d1").
              simpl. try reflexivity. }
            { eapply T_Concat.
              { eapply T_DeclNoInit with(T:=(TyGeneric2 "HashMap" TyString TyInt))(x:="d2").
                simpl. try reflexivity. }
              { eapply T_Skip. } } }
          { simpl. try reflexivity. }
          { eapply T_Concat.
            { eapply T_Concat.
              { eapply T_DeclInit with(T:=(TyGeneric2 "HashMap" TyString TyInt))(x:="result").
                { simpl. try reflexivity. }
                { eapply T_New' with(T:=(TyGeneric0 "HashMap")).
                  { simpl. try reflexivity. }
                  { eapply T_Nil. } }
                { simpl. try reflexivity. } }
              { eapply T_Skip. } }
            { eapply T_Concat.
              { eapply T_Expression.
                eapply T_MethodInvocation with(m:="putAll").
                { eapply T_Var with(x:="result").
                  simpl. try reflexivity. }
                { simpl. try reflexivity. }
                { simpl. try reflexivity. }
                { eapply T_List.
                  { eapply T_Var with(x:="d1").
                    simpl. try reflexivity. }
                  { eapply T_Nil. } }
                { simpl. try reflexivity. } }
              { eapply T_Concat.
                { eapply T_Expression.
                  eapply T_MethodInvocation with(m:="putAll").
                  { eapply T_Var with(x:="result").
                    simpl. try reflexivity. }
                  { simpl. try reflexivity. }
                  { simpl. try reflexivity. }
                  { eapply T_List.
                    { eapply T_Var with(x:="d2").
                      simpl. try reflexivity. }
                    { eapply T_Nil. } }
                  { simpl. try reflexivity. } }
                { eapply T_Concat.
                  { eapply T_Expression.
                    eapply T_MethodInvocation with(m:="putAll").
                    { eapply T_Var with(x:="result").
                      simpl. try reflexivity. }
                    { simpl. try reflexivity. }
                    { simpl. try reflexivity. }
                    { eapply T_List.
                      { eapply T_Var with(x:="d1").
                        simpl. try reflexivity. }
                      { eapply T_Nil. } }
                    { simpl. try reflexivity. } }
                  { eapply T_Concat.
                    { eapply T_Expression.
                      eapply T_MethodInvocation with(m:="putAll").
                      { eapply T_Var with(x:="result").
                        simpl. try reflexivity. }
                      { simpl. try reflexivity. }
                      { simpl. try reflexivity. }
                      { eapply T_List.
                        { eapply T_Var with(x:="d2").
                          simpl. try reflexivity. }
                        { eapply T_Nil. } }
                      { simpl. try reflexivity. } }
                    { eapply T_Concat.
                      { eapply T_Concat.
                        { eapply T_DeclInit with(T:=(TyGeneric2 "HashMap" TyString TyInt))(x:="result2").
                          { simpl. try reflexivity. }
                          { eapply T_New' with(T:=(TyGeneric0 "HashMap")).
                            { simpl. try reflexivity. }
                            { eapply T_Nil. } }
                          { simpl. try reflexivity. } }
                        { eapply T_Skip. } }
                      { eapply T_Concat.
                        { eapply T_Expression.
                          eapply T_MethodInvocation with(m:="putAll").
                          { eapply T_Var with(x:="result2").
                            simpl. try reflexivity. }
                          { simpl. try reflexivity. }
                          { simpl. try reflexivity. }
                          { eapply T_List.
                            { eapply T_Var with(x:="result").
                              simpl. try reflexivity. }
                            { eapply T_Nil. } }
                          { simpl. try reflexivity. } }
                        { eapply T_Concat.
                          { eapply T_Expression.
                            eapply T_MethodInvocation with(m:="putAll").
                            { eapply T_Var with(x:="result2").
                              simpl. try reflexivity. }
                            { simpl. try reflexivity. }
                            { simpl. try reflexivity. }
                            { eapply T_List.
                              { eapply T_Var with(x:="result").
                                simpl. try reflexivity. }
                              { eapply T_Nil. } }
                            { simpl. try reflexivity. } }
                          { eapply T_Concat.
                            { eapply T_Expression.
                              eapply T_MethodInvocation with(m:="putAll").
                              { eapply T_Var with(x:="result2").
                                simpl. try reflexivity. }
                              { simpl. try reflexivity. }
                              { simpl. try reflexivity. }
                              { eapply T_List.
                                { eapply T_Var with(x:="d1").
                                  simpl. try reflexivity. }
                                { eapply T_Nil. } }
                              { simpl. try reflexivity. } }
                            { eapply T_Concat.
                              { eapply T_Expression.
                                eapply T_MethodInvocation with(m:="putAll").
                                { eapply T_Var with(x:="result2").
                                  simpl. try reflexivity. }
                                { simpl. try reflexivity. }
                                { simpl. try reflexivity. }
                                { eapply T_List.
                                  { eapply T_Var with(x:="d2").
                                    simpl. try reflexivity. }
                                  { eapply T_Nil. } }
                                { simpl. try reflexivity. } }
                              { eapply T_Concat.
                                { eapply T_Return.
                                  { eapply T_Var with(x:="result2").
                                    simpl. try reflexivity. }
                                  { simpl. try reflexivity. }
                                  { simpl. try reflexivity. } }
                                { eapply T_Skip. } } } } } } } } } } } } } } } } }
  Unshelve.
  all: apply STyVoid.
Defined.
Definition prog := the_exists_term (prog_well_typed).
Print prog.