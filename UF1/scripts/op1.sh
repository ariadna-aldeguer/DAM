#!/bin/bash

. funcions1.sh

echo "-----------------------------------------------------------------"
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
                10) return ;;
                *) echo "$op Invalid option" ;;
                esac
            

