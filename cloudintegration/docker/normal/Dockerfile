FROM cogniteev/oracle-java:latest

WORKDIR ${HOME}
RUN mkdir --parents /jar

COPY jar/hu.bme.mit.inf.yakindu.sc.normal-1.0.0-SNAPSHOT-jar-with-dependencies.jar /jar
RUN java -jar /jar/hu.bme.mit.inf.yakindu.sc.normal-1.0.0-SNAPSHOT-jar-with-dependencies.jar -a "" --ti 129 --sl
