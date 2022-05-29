#!bin/bash
# talla les lineas i agafa tres variables 

 cat $1 | cut -d' ' -f1,2,3 | bash ./funcio.sh
