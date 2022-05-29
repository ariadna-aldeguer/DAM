#!bin/bash

#funcions1: gestiousuaris.sh  

. modificarUsuaris.sh


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

