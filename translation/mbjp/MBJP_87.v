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
      { eapply T_ClassDecl with(name:="MergeDictionariesThree").
        { simpl. try reflexivity. }
        { eapply T_MethodDecl with(modif:="public static")(T:=(TyGeneric2 "HashMap" TyString TyString))(m:="mergeDictionariesThree").
          { simpl. try reflexivity. }
          { eapply T_Concat.
            { eapply T_DeclNoInit with(T:=(TyGeneric2 "HashMap" TyString TyString))(x:="dict1").
              simpl. try reflexivity. }
            { eapply T_Concat.
              { eapply T_DeclNoInit with(T:=(TyGeneric2 "HashMap" TyString TyString))(x:="dict2").
                simpl. try reflexivity. }
              { eapply T_Concat.
                { eapply T_DeclNoInit with(T:=(TyGeneric2 "HashMap" TyString TyString))(x:="dict3").
                  simpl. try reflexivity. }
                { eapply T_Skip. } } } }
          { simpl. try reflexivity. }
          { eapply T_Concat.
            { eapply T_Foreach with(T:=(TyGeneric2 "Map.Entry" TyString TyString))(x:="entry").
              { simpl. try reflexivity. }
              { eapply T_MethodInvocation with(m:="entrySet").
                { eapply T_Var with(x:="dict1").
                  simpl. try reflexivity. }
                { simpl. try reflexivity. }
                { simpl. try reflexivity. }
                { eapply T_Nil. }
                { simpl. try reflexivity. } }
              { simpl. try reflexivity. }
              { eapply T_Concat.
                { eapply T_Expression.
                  eapply T_MethodInvocation with(m:="put").
                  { eapply T_Var with(x:="dict2").
                    simpl. try reflexivity. }
                  { simpl. try reflexivity. }
                  { simpl. try reflexivity. }
                  { eapply T_List.
                    { eapply T_MethodInvocation with(m:="getKey").
                      { eapply T_Var with(x:="entry").
                        simpl. try reflexivity. }
                      { simpl. try reflexivity. }
                      { simpl. try reflexivity. }
                      { eapply T_Nil. }
                      { simpl. try reflexivity. } }
                    { eapply T_List.
                      { eapply T_MethodInvocation with(m:="getValue").
                        { eapply T_Var with(x:="entry").
                          simpl. try reflexivity. }
                        { simpl. try reflexivity. }
                        { simpl. try reflexivity. }
                        { eapply T_Nil. }
                        { simpl. try reflexivity. } }
                      { eapply T_Nil. } } }
                  { simpl. try reflexivity. } }
                { eapply T_Skip. } } }
            { eapply T_Concat.
              { eapply T_Foreach with(T:=(TyGeneric2 "Map.Entry" TyString TyString))(x:="entry").
                { simpl. try reflexivity. }
                { eapply T_MethodInvocation with(m:="entrySet").
                  { eapply T_Var with(x:="dict2").
                    simpl. try reflexivity. }
                  { simpl. try reflexivity. }
                  { simpl. try reflexivity. }
                  { eapply T_Nil. }
                  { simpl. try reflexivity. } }
                { simpl. try reflexivity. }
                { eapply T_Concat.
                  { eapply T_Expression.
                    eapply T_MethodInvocation with(m:="put").
                    { eapply T_Var with(x:="dict3").
                      simpl. try reflexivity. }
                    { simpl. try reflexivity. }
                    { simpl. try reflexivity. }
                    { eapply T_List.
                      { eapply T_MethodInvocation with(m:="getKey").
                        { eapply T_Var with(x:="entry").
                          simpl. try reflexivity. }
                        { simpl. try reflexivity. }
                        { simpl. try reflexivity. }
                        { eapply T_Nil. }
                        { simpl. try reflexivity. } }
                      { eapply T_List.
                        { eapply T_MethodInvocation with(m:="getValue").
                          { eapply T_Var with(x:="entry").
                            simpl. try reflexivity. }
                          { simpl. try reflexivity. }
                          { simpl. try reflexivity. }
                          { eapply T_Nil. }
                          { simpl. try reflexivity. } }
                        { eapply T_Nil. } } }
                    { simpl. try reflexivity. } }
                  { eapply T_Skip. } } }
              { eapply T_Concat.
                { eapply T_Concat.
                  { eapply T_DeclInit with(T:=(TyGeneric2 "HashMap" TyString TyString))(x:="result").
                    { simpl. try reflexivity. }
                    { eapply T_New' with(T:=(TyGeneric0 "HashMap")).
                      { simpl. try reflexivity. }
                      { eapply T_Nil. } }
                    { simpl. try reflexivity. } }
                  { eapply T_Skip. } }
                { eapply T_Concat.
                  { eapply T_Foreach with(T:=(TyGeneric2 "Map.Entry" TyString TyString))(x:="entry").
                    { simpl. try reflexivity. }
                    { eapply T_MethodInvocation with(m:="entrySet").
                      { eapply T_Var with(x:="dict3").
                        simpl. try reflexivity. }
                      { simpl. try reflexivity. }
                      { simpl. try reflexivity. }
                      { eapply T_Nil. }
                      { simpl. try reflexivity. } }
                    { simpl. try reflexivity. }
                    { eapply T_Concat.
                      { eapply T_Concat.
                        { eapply T_DeclInit with(T:=TyString)(x:="newKey").
                          { simpl. try reflexivity. }
                          { eapply T_MethodInvocation with(m:="replaceAll").
                            { eapply T_MethodInvocation with(m:="getKey").
                              { eapply T_Var with(x:="entry").
                                simpl. try reflexivity. }
                              { simpl. try reflexivity. }
                              { simpl. try reflexivity. }
                              { eapply T_Nil. }
                              { simpl. try reflexivity. } }
                            { simpl. try reflexivity. }
                            { simpl. try reflexivity. }
                            { eapply T_List.
                              { eapply T_String with(s:="[^a-zA-Z0-9]"). }
                              { eapply T_List.
                                { eapply T_String with(s:=""). }
                                { eapply T_Nil. } } }
                            { simpl. try reflexivity. } }
                          { simpl. try reflexivity. } }
                        { eapply T_Skip. } }
                      { eapply T_Concat.
                        { eapply T_Concat.
                          { eapply T_DeclInit with(T:=TyString)(x:="newVal").
                            { simpl. try reflexivity. }
                            { eapply T_MethodInvocation with(m:="replaceAll").
                              { eapply T_MethodInvocation with(m:="getValue").
                                { eapply T_Var with(x:="entry").
                                  simpl. try reflexivity. }
                                { simpl. try reflexivity. }
                                { simpl. try reflexivity. }
                                { eapply T_Nil. }
                                { simpl. try reflexivity. } }
                              { simpl. try reflexivity. }
                              { simpl. try reflexivity. }
                              { eapply T_List.
                                { eapply T_String with(s:="[^a-zA-Z0-9]"). }
                                { eapply T_List.
                                  { eapply T_String with(s:=""). }
                                  { eapply T_Nil. } } }
                              { simpl. try reflexivity. } }
                            { simpl. try reflexivity. } }
                          { eapply T_Skip. } }
                        { eapply T_Concat.
                          { eapply T_Expression.
                            eapply T_MethodInvocation with(m:="put").
                            { eapply T_Var with(x:="result").
                              simpl. try reflexivity. }
                            { simpl. try reflexivity. }
                            { simpl. try reflexivity. }
                            { eapply T_List.
                              { eapply T_Var with(x:="newKey").
                                simpl. try reflexivity. }
                              { eapply T_List.
                                { eapply T_Var with(x:="newVal").
                                  simpl. try reflexivity. }
                                { eapply T_Nil. } } }
                            { simpl. try reflexivity. } }
                          { eapply T_Skip. } } } } }
                  { eapply T_Concat.
                    { eapply T_Return.
                      { eapply T_Var with(x:="result").
                        simpl. try reflexivity. }
                      { simpl. try reflexivity. }
                      { simpl. try reflexivity. } }
                    { eapply T_Skip. } } } } } } } } } } }
  Unshelve.
  all: apply STyVoid.
Defined.
Definition prog := the_exists_term (prog_well_typed).
Print prog.