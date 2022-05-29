#!bin/bash

DATA=$(date +%d-%m-%y)
RUTA=/home/ari/scripts
NOM=Ariadna

tar -czf $DATA-$NOM-$USER.tar.gz *.sh

