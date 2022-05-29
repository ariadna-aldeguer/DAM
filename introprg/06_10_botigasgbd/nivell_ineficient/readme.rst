########################
Versió: nivel ineficient
########################


-> L'entorn ara es conecta i desconecta a una bdd anomenada "botiga"
-> Els vins es carreguen de la bdd
    -> Modificat métode CarregaVins
    -> Afegit métode RecuperaVinsBD: afegeix els vins de la bdd a la botiga
-> Els vins es carreguen a la bdd al finalitzar. Es borra la taula VINS i es torna a pujar. 
    -> Modificat métode guardaVins
    -> métode eliminaTaulaVinsBd()
    -> métode insertaVinsBd() -> Inserta els vins
