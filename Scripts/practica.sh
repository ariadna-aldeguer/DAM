#!bin/bash

#practica.sh 

#funcions1

#1) Crea un usuari nou
crearUsuari () {
    echo "Nom de l'usuari" 
    read usuari
    if [[ $(getent passwd $usuari) ]]
        then echo "El nom d'usuari ja existeix"
        else 
        if sudo useradd $usuari &> /dev/null ; 
            then echo "Usuari creat amb exit"
            else echo "No s'ha pogut crear"
        fi
    fi
    sleep 1
}

#2) Crea un grup nou
crearGrupo () {
    echo "Nom del grup"
    read grup
    if [[ $(getent group $grup) ]] 
        then echo "El nom del grup ja existeix"
        else sudo groupadd $grup 
        echo "Grup creat amb exit"
    fi
    sleep 1
}

#3.1) Afegeix o modifica el comentari de l'usuari 
modificaComentari () {
    echo "Quin comentari vols?"
    read comentari

    if sudo usermod -c $comentari $nomUser &> /dev/null ; 
        then echo "Comentari canviat"
        else echo "No s'ha pogut canviar"
    fi 
    sleep 1
}

#3.2) Modifica el home de l'usuari
modificaDirectori () {
    echo "Quin nom de directori vols?"
    read directori

    if sudo usermod -d $directori $nomUser &> /dev/null ; 
        then echo "Directori canviat"
        else echo "No s'ha pogut canviar el directori"
    fi
    sleep 1
}

#3.3) Posa o modificar la data d'expiració de la contrasenya
modificaDataExpiracio () {
    echo "Quina data d'expiració? [Format AAAA-MM-DD]"
    read dataExpiracio

    if sudo usermod -e $dataExpiracio $nomUser &> /dev/null ; 
        then echo "Data expiracio canviada"
        else echo "No s'ha pogut canviar la data"
    fi
    sleep 1
}

#3.4) Afegeix l'usuari a un grup
afegirGrups () {
    echo "Quin grups vols afegir a l'usuari? (Separa amb comes)"
    
    read grupo
    if sudo usermod -G $grupo $nomUser &> /dev/null ; 
        then echo "Usuari $nomUser afegit al grup $grupo"
        else echo "No s'ha pogut afegir al grup"
    fi
    sleep 1
}

#3.5) Canvia el nom d'un usuari
canviarNomUsuari () {
    echo "Quin nom d'usuari vols?"
    read nom
    if sudo usermod -l $nom $nomUser &> /dev/null ; 
        then echo "Nom d'usuari canviat a $nom"
        else echo "No s'ha pogut canviar el nom d'usuari"
    fi
    sleep 1
}

#3.6) Deshabilitat un compte
bloquejarCompte () {
    if sudo usermod -L $nomUser &> /dev/null ; 
        then echo "Usuari $nomUser deshabilitat"
        else echo "No s'ha pogut deshabilitar l'usuari"
    fi
    sleep 1
}

#3.7) Tornar a habilitat un compte
desbloquejarCompte () {
    #usermod returns 0 when succed 
    if sudo usermod -U $nomUser &> /dev/null ; 
        then echo "Usuari $nomUser habilitat "
        else echo "No s'ha pogut habilitar l'usuari"
    fi
    sleep 1
}

#3.8) Canviar la contrasenya
canviarContra () {
    sudo passwd $nomUser
    echo "Contrasenya canviada"
    sleep 1
}

#3) Modifica un usuari existent
modificaUsuari () {
    echo "Nom de l'usuari que vols modificar"
    read nomUser
    if [[ $(getent passwd $nomUser) ]]
        then 
        echo "-----------------------------------------------------------------"
        echo "--    	Menú d’opcions:"
        echo "--    	1. Modifica el comentari de l’usuari"
        echo "--    	2. Modifica el directori de treball o home de l’usuari"
        echo "--    	3. Modifica la data d’expiració del compte. Format AAAA-MM-DD"
        echo "--    	4. Modificar altres grups als que pot formar part l’usuari (separat per comes)"
        echo "--    	5. Canvia el login o el nom de l’usuari"
        echo "--    	6. Bloqueja el compte d’usuari, no esborra res només el deshabilita"
        echo "--    	7. Desbloqueja un compte previament bloquejat amb l’opció -L"
        echo "--    	8. Modifica la contrasenya de l’usuari"
        echo "--      9. Tornar"
        read -p "Escull una opció [1-9]  " opcio
            case $opcio in 
                1) modificaComentari ;;
                2) modificaDirectori ;;
                3) modificaDataExpiracio ;;
                4) afegirGrups ;;
                5) canviarNomUsuari ;;
                6) bloquejarCompte ;;
                7) desbloquejarCompte ;;
                8) canviarContra ;;
                9) return ;;
                *) return ;;
            esac
     else echo "L'usuari no existeix"
     fi
     sleep 1
}

#4) Canvia el nom d'un grup
modificaGrup () {
    echo "Nom del grup que vols modificar"
    read grupo
    if [[ $(getent group $grupo) ]] 
        then echo "Quin nom nou vols vols posar-li al grup?"
            read nouGrup
            sudo groupmod -n $nouGrup $grupo
            echo "S'ha canviat el nom"
        else echo "No existeix un grup amb aquest nom"
    fi 
    sleep 1 
}
#5.1) Elimina Usuari i Directori
eliminarUserDirec () { 

   if sudo userdel -r $nomUser &> /dev/null ; 
        then echo "Usuari i directori eliminats"
        else echo "No s'ha pogut eliminar"
   fi
   sleep 1

}

#5.2) Elimina usuari
eliminarUser () {

    if sudo userdel $nomUser &> /dev/null ; 
        then echo "Usuari eliminats"
        else echo "No s'ha pogut eliminar"
    fi
    sleep 1
}
#5) Elimina un usuari
eliminaUser () {
        echo "Nom de l'usuari que vols eliminar"
        read nomUser
        if [[ $(getent passwd $nomUser) ]]
            then 
                echo "-----------------------------------------------------------------"
                echo "--    	Menú d’opcions:"
                echo "--    	1. Eliminar usuari i directori"
                echo "--    	2. Eliminar només l'usuari"
                echo "--      3. Tornar"
                echo "-----------------------------------------------------------------"
                read -p "Escull una opció [1-3]  " opc
                case $opc in
                    1) eliminarUserDirec ;; 
                    2) eliminarUser ;;
                    3) return ;;
                    *) return ;;
                esac
            else echo "No existeix un usuari amb aquest nom"
       fi
       sleep 1
}    

#6) Elimina un grup   
eliminaGrup () {
    echo "Quin grup vols eliminar?" 
    read gr
    if [[ $(getent group $gr) ]] 
        then sudo groupdel $gr 
        echo "Grup eliminat amb exit"
        else "No existeis un grup amb aquest nom"
    fi
    sleep 1
}

#7) Ensenya un llistat de tots els usuaris
llistaUsuaris () {
    sudo cat /etc/shadow | cut -f1 -d: 
    sleep 1
}

#8) Ensenya un llistat dels usuaris de un grup
llistaGrups () {
    echo "De quin grup vols la llista d'usuaris?"
    read gru
    if [[ $(getent group $gru) ]] 
        then sudo getent group $usergroup | cut -d ":" -f 4
        else echo "Aquest grup no existeix"
    fi
    sleep 1
}

 #9) Carrega massivament usuaris desde un fitxer csv
usuarisMassiu () {
echo "Quin fitxer vols importar?"
read fitxer

if [ -f $fitxer ] ;
    
    then 
    while read -u3 line
    do
        
        userName=$( echo $line | cut -d "," -f1 )
        groupName=$( echo $line | cut -d "," -f2)
		dataNaix=$( echo $line | cut -d "," -f3)
		ciutat=$( echo $line | cut -d "," -f4)
		tlf=$( echo $line | cut -d "," -f5)
		email=$( echo $line | cut -d "," -f6)
		passwrdNoEncrypt=$( echo $line | cut -d "," -f7)
		passEncrypt=$(echo $passwrdNoEncrypt | openssl passwd -1 -stdin)
		comentari="$dataNaix, $ciutat, $tlf, $email"
       
        #Si l'usuari existeix
        if [[ $(getent passwd $userName) ]]
            then read -p "El usuari $userName ja existeix, el vols modificar amb les dades actuals? (y/N)" mod
                if [ $mod == "y" ]
                    #comprovar que el grup existeix
                    then 
                        #si no existeix, el crea
                        if [[ ! $(getent group $groupName) ]]
                            then sudo groupadd $groupName 
                        fi 
                        #crea l'usuari
                        if sudo usermod -c "$comentari" -g $groupName -p $passEncrypt $userName &> /dev/null ;
                            then echo "S'ha creat l'usuari $userName"
                            else echo "No s'ha pogut crear l'usuari $userName"
                        fi
                    else echo "No s'ha modificat res"
                 fi
            else  
                if [[ ! $(getent group $groupName) ]]
                    then sudo groupadd $groupName 
                fi 
                #crea l'usuari

                if sudo useradd -c "$comentari" -g $groupName -p $passEncrypt $userName &> /dev/null ;
                    then echo "S'ha creat l'usuari $userName"
                    else echo "No s'ha pogut crear l'usuari $userName"
                fi
        fi
    done 3< $fitxer
    else echo "El fitxer no existeix"
fi
echo "Completat"
}       
    
#funcions2

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
    
    
    
    
    
    
    
    
    
    
    
    
   
#Main


echo "-----------------------------------------------------------------"
echo "--    	Benvingut al programa d’inicialització"
echo "--   	$USER"
echo "--   	`date`"
while :
do 
    echo "-----------------------------------------------------------------"
    echo "--    	Menú d’opcions:"
    echo "--    	1. Gestió d’usuaris i grups"
    echo "--    	2. Gestió de directoris i fitxers"
    echo "--    	3. Sortir"
    echo "-----------------------------------------------------------------"
    
    read -p "Escull una opció [1-3]  " opcioPrimerMenu
    
    case $opcioPrimerMenu in 
        
        1) echo "-----------------------------------------------------------------"
            echo "--    	Menú d’opcions:"
            echo "--    	1. Afegir un usuari"
            echo "--    	2. Afegir un grup"
            echo "--    	3. Modificar un usuari"
            echo "--    	4. Modificar un grup"
            echo "--    	5. Eliminar un usuari"
            echo "--    	6. Eliminar un grup"
            echo "--    	7. Llista els usuaris del sistema"
            echo "--    	8. Llista els usuaris del grup"
            echo "--    	9. Carregar usuaris de manera massiva"
            echo "--     10. Tornar"
            echo "-----------------------------------------------------------------"
            read -p "Escull una opció [1-10]  " gestioUsuarisOpcio
                case $gestioUsuarisOpcio in
                1) crearUsuari ;;
                2) crearGrupo ;;
                3) modificaUsuari ;;
                4) modificaGrup ;;
                5) eliminaUser ;; 
                6) eliminaGrup ;;
                7) llistaUsuaris ;;
                8) llistaGrups ;;
                9) usuarisMassiu ;;
                10) continue ;;
                *) continue ;;
                esac
            ;;
        2) echo "-----------------------------------------------------------------"
            echo "--    	Menú d’opcions:"
            echo "--    	1. Crear un fitxer"
            echo "--    	2. Llegir un fitxer"
            echo "--    	3. Eliminar un fitxer"
            echo "--    	4. Canviar permisos d’un fitxer"
            echo "--    	5. Assignar usuari propietari a un fitxer / directori"
            echo "--    	6. Assignar grup propietari a un fitxer / directori"
            echo "--    	7. Veure la màscara"
            echo "--    	8. Assignar una nova màscara"
            echo "--    	9. Crear un directori"
            echo "--    	10. Moure un directori"
            echo "--    	11. Eliminar un directori"
            echo "--    	12. Veure detall d’un directori"
            echo "--    	13. Tornar"
            echo "-----------------------------------------------------------------"
            read -p "Escull una opció [1-10]  " gestioFitxersOpcio
                case $gestioFitxersOpcio in
                    1) crearFitxer ;;
                    2) llegirFitxer ;;
                    3) eliminarFitxer ;;
                    4) canviarPermisos ;;
                    5) assignarUsuariPropietari ;;
                    6) assignarGrupPropietari ;;
                    7) veureMascara ;;
                    8) assignarMascara ;;
                    9) crearDirectori ;;
                    10) moureDirectori ;;
                    11) eliminarDirectori ;;
                    12) veureDetallDirectori ;;
                    13) continue ;;
                    *) continue ;;
                esac 
            ;;
        3) echo "-----------------------------------------------------------------"
           echo "--"
           echo "--    	A REVEURE $USER."
           echo "--"
           echo "-----------------------------------------------------------------"
           exit ;; 


    esac 
done

