#!bin/bash

# ex2bash2.sh

echo "Entra un año"
read year
if (( ("$year" % 400) == "0" )) || (( ("$year" % 4 == "0") && ("$year" % 100 !="0") ));
then echo "No es bisiesto"
else echo "Es bisiesto"
fi


