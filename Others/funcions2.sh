#!/bin/bash

function crearFitxer {
	#comprova que és una ruta correcta. Si és incorrecte mostra un missatge. Si és correcta:
    read -p "Indica la ruta on vols crear el fitxer " path
    if [ ! -d $path ];
    then
        echo "El directori no existeix!"
    else
    read -p "Indica el nom del fitxer " fitxer
    read -p "Indica l'extensió del fitxer " extensio
    touch $fitxer"."$extensio
    read -p el fitxer $fitxer"."$extensio "s'ha creat correctament :D"
    fi
}

function llegirFitxer {
	read -p "Indica el nom del fitxer que vols llegir " fitxer
    cat $fitxer

}

function eliminarFitxer {
	read -p "Indica el nom del fitxer que vols eliminar " fitxer
	rm -f $fitxer
	#Elimina el fitxer
}

function canviarPermisos {
	read -p "Indica el nom del fitxer que vols modificar els permisos " fitxer
	
	read -p "Quins permisos li vols assignar? " permisos
    chmod  $permisos $fitxer 
    echo "permisos modificats correctament :D"
	#Modifica els permisos del fitxer
}

function assignarUsuariPropietari {
	read -p "Indica el nom del fitxer " fitxer
	read -p "Indica el nom de l'usuari " usuari
    chown $usuari $fitxer
	#Assigna l'usuari propietari

}

function assignarGrupPropietari {
	read -p "Indica el nom del fitxer " fitxer
	read -p "Indica el nom del grup " grup
    chgrp $grup $fitxer
	#Assigna l'usuari propietari
}

function veureMascara {
	umask
	#Visualitza la màscara
}

function assignarMascara {
	read -p "Quina màscara vols assignar? " mascara
    umask $mascara
	#Assigna màscara
} 

function crearDirectori {
	read -p "Escriu la ruta i el nom del nou directori que vols crear " directori
	mkdir $directori
	#Crea el directori	
}

function moureDirectori {
	read -p "Escriu el directori que vols moure " directoriOrigen
	read -p "Escriu la ruta on el vols moure " directoriDesti
	mv $directoriOrigen $directoriDesti
	#Mou el directori
}

function eliminarDirectori {
	read -p "Escriu la ruta del directori que vols eliminar " directori
   
   
	#Comprova que el directori existeix
	#Comprova si el directori està buit, si està buit elimina'l si està ple pregunta si vols eliminar tot l'interior
	if [ -d $directori ]; 
    then
        if [ -z "$(ls -A $directori)" ]; then
            echo "Empty"
            rmdir $directori
        else
            echo "Not Empty"
            echo "Vols eliminar el directori i TOT el contingut y/N?" option
            if [ $option == "y" ]; then
                rm -rfv $directori
            else
                echo "No s'eliminara el directori"
            fi    
        fi

	fi
	
}

function veureDetallDirectori {
	read -p "Escriu la ruta del directori que vols visualitzar " directori
	ls -l $directori
}


