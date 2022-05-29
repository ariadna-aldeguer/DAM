#!bin/bash

while :
do
    echo "Escull una opció "
    echo "1. Obrir un editor de text"
    echo "2. Obrir la calculadora"
    echo "3. Desar el manual d’una comanda a un fitxer"
    echo "4. Veure nom d’usuari i hora actual"
    echo "5. Sortir"
read -p "Choose an option [1 - 5]" op

case $op in
1) gedit ;;
2) gnome-calculator ;;
3) echo "quina comanda?"
read comanda
man $co manda >> manualcomanda$comanda.txt ;;
4) echo $USER `date`;;
5) exit 1;;


esac
done

