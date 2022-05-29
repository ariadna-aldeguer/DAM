#!/bin/bash
    clear
    while :
    do
        echo " Choose an option "
        echo "1. Who am I?"
        echo "2. What is my space?"
        echo "3. What is this?"
        echo "4. Exit"
        read -p "Choose an option [1 - 4]" op

    case $op in
    1) echo "You are:"
    whoami;;
    2) echo "You have"
    df;;
    3) uname -r;;
    4) echo "ciao"
    exit 1;;
    *) echo "$op Invalid option"


    esac
    done

