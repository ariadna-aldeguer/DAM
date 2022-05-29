
#!bin/bash
#funcions1: modificarUsuaris

#1) Afegeix o modifica el comentari de l'usuari 
modificaComentari () {
    echo "Quin comentari vols?"
    read comentari

    if sudo usermod -c $comentari $nomUser &> /dev/null ; 
        then echo "Comentari canviat"
        else echo "No s'ha pogut canviar"
    fi 
    sleep 1
}

#2) Modifica el home de l'usuari
modificaDirectori () {
    echo "Quin nom de directori vols?"
    read directori

    if sudo usermod -d $directori $nomUser &> /dev/null ; 
        then echo "Directori canviat"
        else echo "No s'ha pogut canviar el directori"
    fi
    sleep 1
}

#3) Posa o modificar la data d'expiració de la contrasenya
modificaDataExpiracio () {
    echo "Quina data d'expiració? [Format AAAA-MM-DD]"
    read dataExpiracio

    if sudo usermod -e $dataExpiracio $nomUser &> /dev/null ; 
        then echo "Data expiracio canviada"
        else echo "No s'ha pogut canviar la data"
    fi
    sleep 1
}

#4) Afegeix l'usuari a un grup
afegirGrups () {
    echo "Quin grups vols afegir a l'usuari? (Separa amb comes)"
    
    read grupo
    if sudo usermod -G $grupo $nomUser &> /dev/null ; 
        then echo "Usuari $nomUser afegit al grup $grupo"
        else echo "No s'ha pogut afegir al grup"
    fi
    sleep 1
}

#5) Canvia el nom d'un usuari
canviarNomUsuari () {
    echo "Quin nom d'usuari vols?"
    read nom
    if sudo usermod -l $nom $nomUser &> /dev/null ; 
        then echo "Nom d'usuari canviat a $nom"
        else echo "No s'ha pogut canviar el nom d'usuari"
    fi
    sleep 1
}

#6) Deshabilitat un compte
bloquejarCompte () {
    if sudo usermod -L $nomUser &> /dev/null ; 
        then echo "Usuari $nomUser deshabilitat"
        else echo "No s'ha pogut deshabilitar l'usuari"
    fi
    sleep 1
}

#7) Tornar a habilitat un compte
desbloquejarCompte () {
    #usermod returns 0 when succed 
    if sudo usermod -U $nomUser &> /dev/null ; 
        then echo "Usuari $nomUser habilitat "
        else echo "No s'ha pogut habilitar l'usuari"
    fi
    sleep 1
}

#8) Canviar la contrasenya
canviarContra () {
    sudo passwd $nomUser
    echo "Contrasenya canviada"
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


