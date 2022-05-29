#!bin/bash

NOMS=(Miquel Laura Andrea)

for nom in "${NOMS[@]}"
do
   if [[ $nom == A* ]]
   then 
        echo "$nom"
   fi
done
