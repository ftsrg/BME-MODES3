#!/bin/bash

START=0x81
END=0x86

for BBB in $(seq $START $END)
do
	ADDRESS="192.168.0.$BBB"
	ssh debian@$ADDRESS "sudo touch /etc/profile.d/turnout.sh"
	echo "export TURNOUT_ID=$BBB" | ssh debian@$ADDRESS "sudo sudo tee --append /etc/profile.d/turnout.sh"
done
