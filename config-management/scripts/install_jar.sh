for dest in $(<hosts); do
	echo "Installing " ${dest}
	ssh debian@${dest} "sudo mkdir -p /master && sudo chown debian:debian /master"
	scp ../../hu.bme.mit.inf.master.mqtt.client/target/hu.bme.mit.inf.master.mqtt.client-1.0.0-SNAPSHOT-jar-with-dependencies.jar debian@${dest}:/master/master.jar
	ssh debian@${dest} "sudo service master restart"
done
