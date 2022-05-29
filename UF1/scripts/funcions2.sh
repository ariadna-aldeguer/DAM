#!bin/bash

#funcions2.sh  

#1) crearFitxer 
function crearFitxer {
	read -p "Indica la ruta on vols crear el fitxer: " path
	#comprova que és una ruta correcta. Si és incorrecte mostra un missatge. Si és correcta:
	    if [ -d $path ]
		    then 
	            read -p "Indica el nom del fitxer: " fitxer
	            read -p "Indica l'extensió del fitxer: " extensio
	            
	            if touch $path/"$fitxer.$extensio" &> /dev/null
	                then echo "S'ha creat $fitxer.$extensio amb éxit"
	                else echo "No s'ha pogut crear el fitxer"
	            fi
	        else echo "El directori no existeix"
	   fi
	   sleep 0.5
}

#2) llegirFitxer 
function llegirFitxer {
	read -p "Indica el nom del fitxer que vols llegir: " fitxer
    if [ -f $fitxer ]
        then cat $fitxer
        else echo "No s'ha trobat un fitxer amb aquest nom"
    fi
    sleep 0.5
}

#Elimina un fitxer
#3) eliminarFitxer 
function eliminarFitxer {
	read -p "Indica el nom del fitxer que vols eliminar " fitxer
	if [ -f $fitxer ]
        then rm $fitxer
        echo "S'ha eliminat el fitxer"
        else echo "No s'ha trobat un fitxer amb aquest nom"
    fi
	sleep 0.5
}

#Modifica els permisos del fitxer
#4) canviarPermisos
function canviarPermisos {
	read -p "Indica el nom del fitxer que vols modificar els permisos: " fitxer
	if [ -f $fitxer ]
	    then
	        read -p "Quins permisos li vols assignar? [r:lectura - w:escritura - x:ejecucción]:  " permisos
            if chmod +$permisos $fitxer &> /dev/null
                then echo "S'han modificat els permisos"
                else echo "No s'han pogut modificar els permisos"
            fi
        else echo "No s'ha trobat un fitxer amb aquest nom"
    fi
    sleep 0.5
}

#Assigna l'usuari propietari
#5) assignarUsuari 
function assignarUsuariPropietari {
	read -p "Indica el nom del fitxer: " fitxer
	if [ -f $fitxer ]
	    then
	        read -p "Indica el nom de l'usuari: " usuari
	        if [ $(getent passwd $usuari) ]
	            then 
	                if sudo chown $usuari $fitxer &> /dev/null
	                    then echo "S'han canviat els permisos del fitxer $fitxer"
	                    else echo "No s'han pogut canviar els permisos del fitxer $fitxer" 
	                fi
	            else echo "L'usuari $usuari no existeix"
	        fi
	    else echo "No s'ha trobat un fitxer amb aquest nom"
    fi 
	sleep 0.5
}

#Assigna el grup propietari
#6) assignarGrup
function assignarGrupPropietari {
	read -p "Indica el nom del fitxer: " fitxer
	if [ -f $fitxer ]
	    then read -p "Indica el nom del grup: " grup
	        if [ $(getent group $grup) ]
	            then 
	                if sudo chown :$grup $fitxer &> /dev/null
	                    then echo "S'han canviat els permisos del fitxer $fitxer"
	                    else echo "No s'han pogut canviar els permisos del fitxer $fitxer" 
	                fi
	            else echo "El grup $grup no existeix"
	        fi
	    else echo "No s'ha trobat un fitxer amb aquest nom"
    fi 
	sleep 0.5

}

#7) veureMascara 
function veureMascara {
	umask
	#Visualitza la màscara
	sleep 0.5
}
#8) assignarMascara 
function assignarMascara {
	read -p "Quina màscara vols assignar? " mascara
	if umask $mascara &> /dev/null
	    then echo "S'ha aplicat la máscara"
	    else echo "No s'ha pogut aplicar la máscara"
	fi
	sleep 0.5
} 
#9) crearDirectori 
function crearDirectori {
	read -p "Escriu la ruta i el nom del nou directori que vols crear: " directori
	if [ -d $directori ]
	    then echo "El directori $directori ja existeix"
	    else if mkdir $directori &> /dev/null
	            then echo "S'ha creat el directori $directori"
	            else echo "No s'ha pogut crear el directori $directori"
	        fi
    fi
	        
	#Crea el directori	
	sleep 0.5
}

#Mou el directori 
#10) moureDirectori 
function moureDirectori {
	read -p "Escriu el directori que vols moure: " directoriOrigen
	if [ -d $directoriOrigen ]
	    then read -p "Escriu la ruta on el vols moure: " directoriDesti
	        if [ -d $directoriDesti ]
	            then if mv $directoriOrigen $directoriDesti &> /dev/null
	                    then echo "S'ha mogut el directori"
	                    else echo "No s'ha pogut moure el directori"
	                 fi
	            else echo "El directori de destí no existeix"
	        fi
	    else echo "El directori $directoriOrigen no existeix"
    fi 
	sleep 0.5
}

#eliminar un directori
#11) eliminarDirectori 
function eliminarDirectori {
	read -p "Escriu la ruta del directori que vols eliminar: " directori
    
    if [ -d $directori ]
        then 
	        if [ -z "$(ls -A $directori)" ]; #Si esta buit el directori
                then 
           	        if rmdir $directori &> /dev/null
		                    then echo "S'ha eliminat el directori $directori"
		                    else echo "No s'ha pogut eliminar el directori $directori"
		            fi 
                else read -p "El directori conté archius, els vols eliminar? (y/N): " resposta
                    if [ $resposta == "y" ];
                        then 
                            if rm -Rf $directori &> /dev/null
                                then echo "S'ha eliminat el directori $directori"
                            else echo "No s'ha pogut eliminar el directori $directori"
                            fi 
                    fi
            fi
       else echo "No existeix el directori $directori"
	fi        
	sleep 0.5
}
#12) veureDirectori 
function veureDetallDirectori {
	read -p "Escriu la ruta del directori que vols visualitzar: " directori
	if [ -d $directori ]
        then ls -la $directori
        else echo "El directori $directori no existeix"
    fi
	sleep 0.5

}
