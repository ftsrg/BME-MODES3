for dest in $(<hosts); do
	echo "Installing " ${dest}
	ssh debian@${dest} "sudo mkdir -p /master && sudo chown debian:debian /master"
	scp master.jar debian@${dest}:/master
	ssh debian@${dest} "sudo service master restart"
done
