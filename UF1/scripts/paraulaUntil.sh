#!bin/bash 

until [[ "$paraula" == "hola" ]] 
do  
    read paraula
    if [[ "$paraula" == "brk" ]]
    then break
    fi
done
