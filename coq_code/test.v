From PLF Require Import Syntax.
Open Scope string_scope.

Example prog_well_typed : exists p, program_well_typed p.
Proof with (simpl;try(reflexivity)).
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
      { eapply T_ClassDecl with(name:="EmptyDit").
        { simpl. try reflexivity. }
        { eapply T_MethodDecl with(modif:="public static")(T:=TyBool)(m:="emptyDit").
          { simpl. try reflexivity. }
          { eapply T_Concat.
            { eapply T_DeclNoInit with(T:=(TyExternal "Object"))(x:="list1").
              simpl. try reflexivity. }
            { eapply T_Skip. } }
          { simpl. try reflexivity. }
          { eapply T_Concat.
            { eapply T_Concat.
              { eapply T_DeclInit with(T:=TyBool)(x:="emptyDit").
                { simpl. try reflexivity. }
                { eapply T_True. }
                { simpl. try reflexivity. } }
              { eapply T_Skip. } }
            { eapply T_Concat.
              { eapply T_If.
                { eapply T_InstanceOf with(T:=(TyExternal "List")).
                  eapply T_Var with(x:="list1").
                  simpl. try reflexivity. }
                { eapply T_Concat.
                  { eapply T_Foreach with(T:=(TyExternal "Object"))(x:="obj").
                    { simpl. try reflexivity. }
                    { eapply T_Conversion with(T:=(TyExternal "List")).
                      { eapply T_Var with(x:="list1").
                        simpl. try reflexivity. }
                      { simpl. try reflexivity. } }
                    { simpl. try reflexivity. }
                    { eapply T_Concat.
                      { eapply T_If.
                        { eapply T_Not.
                          eapply T_InstanceOf with(T:=(TyExternal "Map")).
                          eapply T_Var with(x:="obj").
                          simpl. try reflexivity. }
                        { eapply T_Concat.
                          { eapply T_Expression.
                            eapply T_Assign.
                            { eapply T_Var with(x:="emptyDit").
                              simpl. try reflexivity. }
                            { eapply T_False. }
                            { simpl. try reflexivity. } }
                          { eapply T_Concat.
                            { eapply T_Break. }
                            { eapply T_Skip. } } } }
                      { eapply T_Skip. } } }
                  { eapply T_Skip. } } }
              { eapply T_Concat.
                { eapply T_Return.
                  { eapply T_Var with(x:="emptyDit").
                    simpl. try reflexivity. }
                  { simpl. try reflexivity. }
                  { simpl. try reflexivity. } }
                { eapply T_Skip. } } } } } } } } }
  Unshelve.
  all: apply STyVoid.
Defined.
Definition prog := the_exists_term (prog_well_typed).
Print prog.