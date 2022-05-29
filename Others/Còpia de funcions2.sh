#!/bin/bash

function crearFitxer {
	read -p "Indica la ruta on vols crear el fitxer " path
	#comprova que és una ruta correcta. Si és incorrecte mostra un missatge. Si és correcta:
		
	read -p "Indica el nom del fitxer " fitxer
	read -p "Indica l'extensió del fitxer " extensio
	
}

function llegirFitxer {
	read -p "Indica el nom del fitxer que vols llegir " fitxer

}

function eliminarFitxer {
	read -p "Indica el nom del fitxer que vols eliminar " fitxer
	
	#Elimina el fitxer
}

function canviarPermisos {
	read -p "Indica el nom del fitxer que vols modificar els permisos " fitxer
	
	read -p "Quins permisos li vols assignar? " permisos

	#Modifica els permisos del fitxer
}

function assignarUsuariPropietari {
	read -p "Indica el nom del fitxer " fitxer
	read -p "Indica el nom de l'usuari " usuari

	#Assigna l'usuari propietari
}

function assignarUsuariPropietari {
	read -p "Indica el nom del fitxer " fitxer
	read -p "Indica el nom de l'usuari " usuari

	#Assigna l'usuari propietari
}

function assignarGrupPropietari {
	read -p "Indica el nom del fitxer " fitxer
	read -p "Indica el nom del grup " grup

	#Assigna l'usuari propietari
}

function veureMascara {
	umask
	#Visualitza la màscara
}

function assignarMascara {
	read -p "Quina màscara vols assignar? " mascara
	#Assigna màscara
} 

function crearDirectori {
	read -p "Escriu la ruta i el nom del nou directori que vols crear " directori
	
	#Crea el directori	
}

function moureDirectori {
	read -p "Escriu el directori que vols moure " directoriOrigen
	read -p "Escriu la ruta on el vols moure " directoriDesti
	
	#Mou el directori
}

function eliminarDirectori {
	read -p "Escriu la ruta del directori que vols eliminar " directori

	#Comprova que el directori existeix
	#Comprova si el directori està buit, si està buit elimina'l si està ple pregunta si vols eliminar tot l'interior
	
	if [ -z "$(ls -A $directori)" ]; then
		echo "Empty"
	else
		echo "Not Empty"
	fi
	
}

function veureDetallDirectori {
	read -p "Escriu la ruta del directori que vols visualitzar " directori
	
}
