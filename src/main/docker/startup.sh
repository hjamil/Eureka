#!/bin/sh
set -e
# Set basic java options
export JAVA_OPTS="-Djava.security.egd=file:/dev/./urandom -XX:MinHeapFreeRatio=5 -XX:MaxHeapFreeRatio=25 -Xmx768m"
# Get App filename
APPNAME=$(ls -1 /*.jar|head -1)
echo "Starting $APPNAME with Java Options ${JAVA_OPTS}"
# Start the application
exec java ${JAVA_OPTS} -jar $APPNAME
