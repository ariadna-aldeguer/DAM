#!bin/bash

read dni

((resultat = $dni % 23 ))

lletres=(T R W A G M Y F P D X B N J Z S Q V H L C K E)

echo ${lletres[$resultat]}






