########################
Versió: nivel eficient
########################

**FASE INEFICIENT**
==================
-> L'entorn ara es conecta i desconecta a una bdd anomenada "botiga"
-> Els vins es carreguen de la bdd
    -> Modificat métode CarregaVins
    -> Afegit métode RecuperaVinsBD: afegeix els vins de la bdd a la botiga
-> Métodes BD
    -> métode eliminaTaulaVinsBd()
    -> métode insertaVinsBd() -> Inserta els vins

**FASE EFICIENT**
==================
-> S'han creat tres llistes a Entorn: afegits, modificats i eliminats. Al tancar l'entorn, s'afegeixen, es modifiquen i s'eliminen els vins de les llistes. 
    -> Modificat métode guardaVins: ara crida als métodes
        ->insertarBdNousVins()
        ->modificarBdVinsModificats()
        ->eliminarBdVinsEliminats()

   
