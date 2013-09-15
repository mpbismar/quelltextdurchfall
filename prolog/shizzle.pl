besser(burger, gurke).
besser(gurke, nichts).
besser(nichts, garnichts).
besser(X,Z) :- besser(X,Y),besser(Y,Z).

besitzt(hans,buch(der_fremde_gast,autor(charlobe,link))).
besitzt(hans,buch(staub,autor(patricia,	cornwell))).
