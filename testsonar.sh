#! /bin/bash -u

# be sure to set SONAR_HOME before executing this script, for example:
# export SONAR_HOME=/Users/wilfred/sonar-3.7.3

SONAR_PROJ=`dirname $0`

echo
echo Stopping SonarQube...
$SONAR_HOME/bin/macosx-universal-64/sonar.sh stop

cd $SONAR_PROJ

echo
echo Removing $SONAR_PROJ/target...
rm -rf "$SONAR_PROJ/target"

echo
echo Running maven to build Sonar Plugin...
mvn license:format install 

echo
echo Copying generated JAR to SonarQube...
cp -a target/sonar-*.jar "$SONAR_HOME/extensions/plugins"

echo
echo Deleting H2 database for a clean start
rm $SONAR_HOME/data/*.db

echo
echo Starting SonarQube...
$SONAR_HOME/bin/macosx-universal-64/sonar.sh start

echo Wait for SonarQube to fully start...
sleep 30

echo starting Sonar-Runner...
$SONAR_HOME/bin/sonar-runner -e -X
