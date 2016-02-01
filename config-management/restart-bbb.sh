#!/bin/bash

START=0x81
END=0x86

for BBB in $(seq $START $END)
do
	ADDRESS="192.168.0.$BBB"
	echo "Restarting $BBB"
	ssh debian@$ADDRESS "sudo shutdown --reboot 0 ; exit"
done
