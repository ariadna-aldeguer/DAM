#!bin/bash 


read num
CONT=0
ADIVINA=$(($RANDOM))
echo "$ADIVINA"
while (( $num != $ADIVINA ))
do

    if [[ $num -lt $ADIVINA ]]
    then 
        echo "Més gran"
    else echo "Més petit"
    fi
    read num
    CONT=$(($CONT+1))
    if [[ $num == 0 ]]
    then ADIVINA=$(($RANDOM))
    fi
done
echo "Es aquest"
echo “$CONT”

