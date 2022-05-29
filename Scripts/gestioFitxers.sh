#!bin/bash

#gestiouFitxers.sh  

#1) crearFitxer 
function crearFitxer {
	read -p "Indica la ruta on vols crear el fitxer " path
	#comprova que és una ruta correcta. Si és incorrecte mostra un missatge. Si és correcta:
		
	read -p "Indica el nom del fitxer " fitxer
	read -p "Indica l'extensió del fitxer " extensio
	
}

#2) llegirFitxer 
function llegirFitxer {
	read -p "Indica el nom del fitxer que vols llegir " fitxer

}

#3) eliminarFitxer 
function eliminarFitxer {
	read -p "Indica el nom del fitxer que vols eliminar " fitxer
	
	#Elimina el fitxer
}

#4) canviarPermisos
function canviarPermisos {
	read -p "Indica el nom del fitxer que vols modificar els permisos " fitxer
	
	read -p "Quins permisos li vols assignar? " permisos

	#Modifica els permisos del fitxer
}

#5) assignarUsuari 
function assignarUsuariPropietari {
	read -p "Indica el nom del fitxer " fitxer
	read -p "Indica el nom de l'usuari " usuari

	#Assigna l'usuari propietari
}

#6) assignarGrup
function assignarGrupPropietari {
	read -p "Indica el nom del fitxer " fitxer
	read -p "Indica el nom del grup " grup

	#Assigna l'usuari propietari
}

#7) veureMascara 
function veureMascara {
	umask
	#Visualitza la màscara
}
#8) assignarMascara 
function assignarMascara {
	read -p "Quina màscara vols assignar? " mascara
	#Assigna màscara
} 
#9) crearDirectori 
function crearDirectori {
	read -p "Escriu la ruta i el nom del nou directori que vols crear " directori
	
	#Crea el directori	
}

#10) moureDirectori 
function moureDirectori {
	read -p "Escriu el directori que vols moure " directoriOrigen
	read -p "Escriu la ruta on el vols moure " directoriDesti
	
	#Mou el directori
}
#11) eliminarDirectori 
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
#12) veureDirectori 
function veureDetallDirectori {
	read -p "Escriu la ruta del directori que vols visualitzar " directori
	
}
