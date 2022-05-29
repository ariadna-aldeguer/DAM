#!bin/bash

read nom
read nota1
read nota2
read nota3

((Mitjana=($nota1+$nota2+$nota3)/3))

echo "Avaluació de l'alumne: $nom"
echo "Notes obtingudes: $nota1, $nota2, $nota3"
echo "Mitjana: $Mitjana"

if [[ $nota1 -ge $nota2 ]]
then
  if [[ $nota1 -ge $nota3 ]]
  then
    echo "Nota més alta: $nota1"
  else
    echo "Nota més alta: $nota3"
  fi
else
  if [[ $nota2 -ge $nota3 ]]
  then
    echo "Nota més alta: $nota2"
  else
    echo "Nota més alta: $nota3"
  fi
fi


if [[ $nota1 -lt $nota2 ]]
then
  if [[ $nota1 -lt $nota3 ]]
  then
    echo "Nota més baixa: $nota1"
  else
    echo "Nota més baixa: $nota3"
  fi
else
  if [[ $nota2 -lt $nota3 ]]
  then
    echo "Nota més baixa: $nota2"
  else
    echo "Nota més baixa: $nota3"
  fi
fi





