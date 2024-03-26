Inductive even : nat -> Prop :=
| even_O : even O
| even_SS : forall n, even n -> even (S (S n)).
Check False.