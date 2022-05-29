#!bin/bash

NOMS=(Ariadna Miquel Laura)


for nom in "${NOMS[@]}"
do
   if [[ $nom == $1 ]]
   then 
        echo "He trobat el nom"
        exit
   fi
done
echo "No he trobat el nom"



