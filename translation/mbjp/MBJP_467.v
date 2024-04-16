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
      { eapply T_ClassDecl with(name:="DecimalToOctal").
        { simpl. try reflexivity. }
        { eapply T_MethodDecl with(modif:="public static")(T:=TyInt)(m:="decimalToOctal").
          { simpl. try reflexivity. }
          { eapply T_Concat.
            { eapply T_DeclNoInit with(T:=TyInt)(x:="decinum").
              simpl. try reflexivity. }
            { eapply T_Skip. } }
          { simpl. try reflexivity. }
          { eapply T_Concat.
            { eapply T_Concat.
              { eapply T_DeclInit with(T:=(TyArray TyChar))(x:="chars").
                { simpl. try reflexivity. }
                { eapply T_MethodInvocation with(m:="toCharArray").
                  { eapply T_TyMethodInvocation with(m:="toOctalString")(T:=(TyExternal "Integer")).
                    { simpl. try reflexivity. }
                    { simpl. try reflexivity. }
                    { eapply T_List.
                      { eapply T_Var with(x:="decinum").
                        simpl. try reflexivity. }
                      { eapply T_Nil. } }
                    { simpl. try reflexivity. } }
                  { simpl. try reflexivity. }
                  { simpl. try reflexivity. }
                  { eapply T_Nil. }
                  { simpl. try reflexivity. } }
                { simpl. try reflexivity. } }
              { eapply T_Skip. } }
            { eapply T_Concat.
              { eapply T_Concat.
                { eapply T_DeclInit with(T:=TyString)(x:="string").
                  { simpl. try reflexivity. }
                  { eapply T_New' with(T:=TyString).
                    { simpl. try reflexivity. }
                    { eapply T_List.
                      { eapply T_Var with(x:="chars").
                        simpl. try reflexivity. }
                      { eapply T_Nil. } } }
                  { simpl. try reflexivity. } }
                { eapply T_Skip. } }
              { eapply T_Concat.
                { eapply T_Return.
                  { eapply T_TyMethodInvocation with(m:="parseInt")(T:=(TyExternal "Integer")).
                    { simpl. try reflexivity. }
                    { simpl. try reflexivity. }
                    { eapply T_List.
                      { eapply T_Var with(x:="string").
                        simpl. try reflexivity. }
                      { eapply T_Nil. } }
                    { simpl. try reflexivity. } }
                  { simpl. try reflexivity. }
                  { simpl. try reflexivity. } }
                { eapply T_Skip. } } } } } } } } }
  Unshelve.
  all: apply STyVoid.
Defined.
Definition prog := the_exists_term (prog_well_typed).
Print prog.