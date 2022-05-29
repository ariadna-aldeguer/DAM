#!/bin/bash

git add --all

echo

echo "Files added"

echo

echo "Write a message to commit"

read message

git commit -m "$message"

if(git push origin master) then 

    echo

    echo "#############################################"

    echo "Pushed successfully; $filesCommit files"

    echo "#############################################"

else 
    echo "No s'ha pogut pujar"
fi
