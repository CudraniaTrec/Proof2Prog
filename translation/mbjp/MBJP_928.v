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
      { eapply T_ClassDecl with(name:="ChangeDateFormat").
        { simpl. try reflexivity. }
        { eapply T_MethodDecl with(modif:="public static")(T:=TyString)(m:="changeDateFormat").
          { simpl. try reflexivity. }
          { eapply T_Concat.
            { eapply T_DeclNoInit with(T:=TyString)(x:="dt").
              simpl. try reflexivity. }
            { eapply T_Skip. } }
          { simpl. try reflexivity. }
          { eapply T_Concat.
            { eapply T_Concat.
              { eapply T_DeclInit with(T:=(TyArray TyString))(x:="split").
                { simpl. try reflexivity. }
                { eapply T_MethodInvocation with(m:="split").
                  { eapply T_Var with(x:="dt").
                    simpl. try reflexivity. }
                  { simpl. try reflexivity. }
                  { simpl. try reflexivity. }
                  { eapply T_List.
                    { eapply T_String with(s:="-"). }
                    { eapply T_Nil. } }
                  { simpl. try reflexivity. } }
                { simpl. try reflexivity. } }
              { eapply T_Skip. } }
            { eapply T_Concat.
              { eapply T_Concat.
                { eapply T_DeclInit with(T:=TyString)(x:="year").
                  { simpl. try reflexivity. }
                  { eapply T_ArrayAccess.
                    { eapply T_Var with(x:="split").
                      simpl. try reflexivity. }
                    { eapply T_Integer with(n:=0). } }
                  { simpl. try reflexivity. } }
                { eapply T_Skip. } }
              { eapply T_Concat.
                { eapply T_Concat.
                  { eapply T_DeclInit with(T:=TyString)(x:="month").
                    { simpl. try reflexivity. }
                    { eapply T_ArrayAccess.
                      { eapply T_Var with(x:="split").
                        simpl. try reflexivity. }
                      { eapply T_Integer with(n:=1). } }
                    { simpl. try reflexivity. } }
                  { eapply T_Skip. } }
                { eapply T_Concat.
                  { eapply T_Concat.
                    { eapply T_DeclInit with(T:=TyString)(x:="day").
                      { simpl. try reflexivity. }
                      { eapply T_ArrayAccess.
                        { eapply T_Var with(x:="split").
                          simpl. try reflexivity. }
                        { eapply T_Integer with(n:=2). } }
                      { simpl. try reflexivity. } }
                    { eapply T_Skip. } }
                  { eapply T_Concat.
                    { eapply T_Return.
                      { eapply T_Add.
                        { eapply T_Add.
                          { eapply T_Add.
                            { eapply T_Add.
                              { eapply T_Var with(x:="day").
                                simpl. try reflexivity. }
                              { eapply T_String with(s:="-"). }
                              { simpl. try reflexivity. } }
                            { eapply T_Var with(x:="month").
                              simpl. try reflexivity. }
                            { simpl. try reflexivity. } }
                          { eapply T_String with(s:="-"). }
                          { simpl. try reflexivity. } }
                        { eapply T_Var with(x:="year").
                          simpl. try reflexivity. }
                        { simpl. try reflexivity. } }
                      { simpl. try reflexivity. }
                      { simpl. try reflexivity. } }
                    { eapply T_Skip. } } } } } } } } } } }
  Unshelve.
  all: apply STyVoid.
Defined.
Definition prog := the_exists_term (prog_well_typed).
Print prog.