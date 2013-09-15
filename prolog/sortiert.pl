kleiner(A,B) :- A =< B.

sortiert([A|[B|C]]) :- kleiner(A,B),sortiert([B|C]).
sortiert([_]).
sortiert([]).


