
# enable jmx on demand
# export MAVEN_OPTS="-Dcom.sun.management.jmxremote.port=27777 -Dcom.sun.management.jmxremote -Dcom.sun.management.jmxremote.authenticate=false -Dcom.sun.management.jmxremote.ssl=false -Dcom.sun.management.jmxremote.local.only=false"

# mvn test
mvn exec:java -Dexec.mainClass=com.jingoal.test.business.ServerMain
