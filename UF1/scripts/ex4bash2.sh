#!bin/bash

#ex4bash2.sh
#Demana a l'usuario el dia/mes/any que va neixer i calcula quants anys té

echo "Digues la teva data de naixemenent"
read any mes dia


((anio = $(date +"%Y" ) - $any )) 
((month = $(date +"%m") - $mes ))

if [[ month -lt 0 ]] 
then echo "$(($anio-1))"
else echo "$anio"
fi 

