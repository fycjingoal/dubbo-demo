#!/bin/bash
# Author: fuyc

# Support different run-profiles by defining shell env var $MSPROFILE
# affecting config dir and logback.xml
#
# E.g. prof1 requires config dir "prof1cfg", and log output dir will be "prof1logs"
# Runs like: MSPROFILE=prof1 ./mailServer.sh
#
# If MSPROFILE is not defined, will simply behave like before.

home=$(dirname $0)

cd $home # ensure can invoke this script correctly from any dir.

# jmx args
# -Dcom.sun.management.jmxremote
# -Dcom.sun.management.jmxremote.port=<jmx-remote-port> (can be 0, for random port)
# -Dcom.sun.management.jmxremote.ssl=false
# -Dcom.sun.management.jmxremote.authenticate=false
# -Dcom.sun.management.jmxremote.local.only=false
# -Djava.rmi.server.hostname=<your-linux-ip-adress>
# -Djava.rmi.activation.port=<jndi-remote-port>
#

# To enable (Eclipse) remote debugging, uncomment the following JAVA_OPTS
#JAVA_OPTS="-Xdebug -Xnoagent -Xrunjdwp:transport=dt_socket,address=18888,server=y,suspend=n $JAVA_OPTS"

# jmx listen on any port
JMX_PORT_OPTS="-Dcom.sun.management.jmxremote.port=0"

# jmx listen on specific port
#JMX_PORT_OPTS="-Dcom.sun.management.jmxremote.port=28888"

# In order to be remotely accessible, need to set both -Djava.rmi.server.hostname=xxx and -Dcom.sun.management.jmxremote.port=xxx.
# allow jmx remotely accessible
#JMX_HOST_OPTS="-Djava.rmi.server.hostname=<mailServer-adress/hostname>"

#JPROFILE_OPTS="-agentpath:/usr/share/jprofiler6/bin/linux-x86/libjprofilerti.so=port=8849,nowait"

# enable jmx (locally accessible. minimal requirements for CentOS)
JMX_OPTS="-Dcom.sun.management.jmxremote -Dcom.sun.management.jmxremote.authenticate=false -Dcom.sun.management.jmxremote.ssl=false -Dcom.sun.management.jmxremote.local.only=false $JMX_HOST_OPTS $JMX_PORT_OPTS"

JAVA_OPTS="$JMX_OPTS $JPROFILE_OPTS $JAVA_OPTS"

CLSPATH=${MSPROFILE}cfg
s=`ls lib`
for file in $s;do
  CLSPATH="$CLSPATH:lib/$file"
done

java -DMSPROFILE=${MSPROFILE} -cp $CLSPATH $JAVA_OPTS -server -Xmx256m -Xms64m -Djava.net.preferIPv4Stack=true com.jingoal.test.business.ServerMain

