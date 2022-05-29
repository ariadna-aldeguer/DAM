#!bin/bash

#funcions1: gestiousuaris.sh  




#1) Crea un usuari nou
crearUsuari () {
    echo "Nom de l'usuari" 
    read usuari
    if [[ $(getent passwd $usuari) ]]
        then echo "El nom d'usuari ja existeix"
        else 
        if [[ $(sudo useradd $usuari) ]]
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
        
        username=$( echo $line | cut -d "," -f1 )
        groupname=$( echo $line | cut -d "," -f2)
		datanaix=$( echo $line | cut -d "," -f3)
		ciutat=$( echo $line | cut -d "," -f4)
		tlf=$( echo $line | cut -d "," -f5)
		email=$( echo $line | cut -d "," -f6)
		passwrdnoencrypt=$( echo $line | cut -d "," -f7)
		passencrypt=$(echo $passwrdnoencrypt | openssl passwd -1 -stdin)
		comentari="$datanaix, $ciutat, $tlf, $email"
       
        #Si l'usuari existeix
        if [[ $(getent passwd $username) ]]
            then read -p "El usuari $username ja existeix, el vols modificar amb les dades actuals? (y/N)" mod
                if [ $mod == "y" ]
                    #comprovar que el grup existeix
                    then 
                        #si no existeix, el crea
                        if [[ ! $(getent group $groupname) ]]
                            then sudo groupadd $groupname 
                        fi 
                        #crea l'usuari
                        if sudo usermod -c "$comentari" -g $groupname -p $passencrypt $username &> /dev/null ;
                            then echo "S'ha creat l'usuari $username"
                            else echo "No s'ha pogut crear l'usuari $username"
                        fi
                    else echo "No s'ha modificat res"
                 fi
            else  
                if [[ ! $(getent group $groupname) ]]
                    then sudo groupadd $groupname 
                fi 
                #crea l'usuari

                if sudo useradd -c "$comentari" -g $groupname -p $passencrypt $username &> /dev/null ;
                    then echo "S'ha creat l'usuari $username"
                    else echo "No s'ha pogut crear l'usuari $username"
                fi
        fi
    done 3< $fitxer
    else echo "El fitxer no existeix"
fi
echo "Completat"
}       
    
    
    
    
    
    
    
    
    
    
    
    
    
    
   
