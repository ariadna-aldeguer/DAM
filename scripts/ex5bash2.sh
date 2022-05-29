#!bin/bash

#ex5bash2.sh


echo "1. Llistat de tots els usuaris del sistema"
echo "2. Crear usuari"
echo "3. Sortir"
read option

case $option in
1) sudo cat /etc/shadow | cut -f1 -d: | tee listado.txt ;;
2) echo "Nom del usuari" 
read usuari
if [[ $(getent passwd $usuari) ]]
then echo "El nom d'usuari ja existeix"
else useradd $usuari 
fi
;;
3) exit 1;; 
esac
