#!/bin/bash

. p2.sh

linia="------------------------------------------"
inici="--    "
date=$(date +"%m-%d-%y")

echo  $linia
echo "Benvingut al programa d’inicialització"
echo $inici $USER
echo $date
echo $linia

while :
do

	echo $inici " Menú d'opcions: "
	echo "--   " "1.Gestió d'usuaris i grups"
	echo "--   " "2.Gestió de directoris i fitxers"
	echo "--   " "3.Gestió de programari"
	echo "--   " "4.Sortir"

	read -p "Escull una opció " op1

	case $op1 in
		1)echo "1) Afegir un usuari"
		  echo "2) Afegir un grup"
		  echo "3) Modificar un usuari"
		  echo "4) Modificar un grup"
		  echo "5) Eliminar un usuari"
		  echo "6) Eliminar un grup"
		  echo "7) Llista els usuaris del sistema"
		  echo "8) Llista els usuaris del grup"
		  echo "9) Carregar usuaris de manera massiva"
		  echo "10) Tornar" 
		  
		read -p "Escull una opció " op2
		
			case $op2 in
				1) 
					read -p "Introdueix un usuari: " nom 
					if [ $( getent passwd $nom ) ];
						then
							echo "L'usuari ja existeix Tolai!"
					else
						sudo adduser $nom
					fi
				;;
				
				2)
					read -p "Introdueix un Grup: " grp 
					if [ $( getent group $grp ) ];
					then
						echo "El Grup ja existeix Tolai!"
					else
						sudo addgroup $grp
					fi
				;;
				
				3)
					echo "Modificar un usuari"
				;;
				4)
					read -p "Introdueix el Grup a modificar" grup
					if [ $( getent group $grup ) ];
					then
						read -p "Introdueix el nou nom" ngrup
						groupmod -n $ngrup $grup
					else
						echo "El Grup no existeix!"
					fi
				;;
				
				5)
					read -p "Vols eliminar l'usuari? yes/no?" usr 
					if [ $usr == 'yes' ] 
					then
						sudo userdel -r $usr
						read -p "Vols eliminar el directori? yes/no " dir

						if [ $dir == 'yes' ];
						then
							echo "eliminar dir"
							rm -r $dir
						fi
					fi
				;;
				6)
					read-p "Quin grup vols eliminar? " gurp
					if [ $( getent group $gurp ) ];
					then
						group del $gurp
					else
							echo "Aquest grup no existeix!"
					fi
				;;
				7)
					echo "Llista els usuaris del sistema"
					getent passwd | cut -d ":" -f 1
				;;
				8)
					read -p "De quin grup vols llistar els usuaris? " usergroup
					if [ $( getent group $usergroup ) ];
					then
						getent group $usergroup | cut -d ":" -f 4
					else
						echo "Aquest grup no existeix!"
					fi
				;;
				9) 
					read -p "Quin fitxer vols importar? " fitxer
					if [ -f $fitxer ];
					then
						while read -u3 line
						do
							username=$( echo $line | cut -d "," -f 1)
							filegroup=$( echo $line | cut -d "," -f 2)
							datanaix=$( echo $line | cut -d "," -f 3)
							ciutat=$( echo $line | cut -d "," -f 4)
							tlf=$( echo $line | cut -d "," -f 5)
							email=$( echo $line | cut -d "," -f 6)
							passwrdnoencrypt=$( echo $line | cut -d "," -f 7)
							passencrypt=$(echo $passwrdnoencrypt | openssl passwd -1 -stdin)
							comentari="$datanaix "," $ciutat "," $tlf "," $email"

							if [ "$( getent passwd $username )" ];
							then
								read -p "Aquest usuari ($username) ja existeix, vols modificar-lo? (y/N) " modif
								if [ $modif == "y" ]
								then
									if [ $( getent group $filegroup ) ];
									then
										echo "el grupo ya existe, no se crea..."
									else
										sudo groupadd $filegroup
									fi

									sudo usermod -c "$comentari" -g $filegroup -p $passencrypt $username
									
								else
									echo "No s'ha modificat"
								fi
							else
								if [ $( getent group $filegroup ) ];
								then
									echo "ya existe el grupo, no se crea..."
									else
										sudo groupadd $filegroup
									fi

								echo "Creando usuario $username ..."
								sudo useradd -c "$comentari" -g $filegroup -p $passencrypt $username
								echo "Usuario creado"
							fi
						done 3< $fitxer
					else
						echo "archivo no existe"			
					fi
					
					echo "Carregar usuaris de manera massiva"
				;;
				10)echo "tornar"
				;;
				esac
				;;
				

		2) echo "2... MAS COSAS";;
		3) echo "otras cosas";;
		4) echo "A reveure"
		exit ;;

	esac

done
