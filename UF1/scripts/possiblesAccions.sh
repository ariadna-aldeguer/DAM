#!bin/bash


read num1
read num2

select operant in suma resta multiplicar dividir

do

	if [[ "$operant" == suma ]]
	then
	(( resultat = $num1 + $num2 ))
	echo "El resultat es: $resultat"
	break
	elif [[ "$operant" == resta ]]
	then
	(( resultat = $num1 - $num2 ))
	echo  "El resultat es: $resultat"
	break
	elif [[ "$operant" == multiplicar ]]
	then
	(( resultat = $num1 * $num2 ))
	echo  "El resultat es: $resultat"
	break
	elif [[ "$operant" == dividir ]]
	then
	    if [[ "$num2" == 0 ]]
	    then echo "Error"
	    break
	    else 	    
	    (( resultat = $num1 - $num2 ))
	    echo  "El resultat es: $resultat"
	    break
	    fi
	fi
done  
exit 0 
