#!bin/bash

echo "Digues una ruta de un directori"
read directori

if [ -d $directori ];
then
echo "Si existe"
else
echo "No existe"
fi

