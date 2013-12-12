set AUDIT_PROJ=C:\work\Test12c
set SONAR_PROJ=C:\work\adfemgsonarplugin
set SONAR_HOME=C:\sonar-3.7.3

cd /d "%SONAR_PROJ%"
del /S /Q "%SONAR_PROJ%\target"
call mvn -DproxySet=false -DskipTests=true license:format install 
copy "target\sonar-plsql-toad-plugin-1.1-SNAPSHOT.jar" "%SONAR_HOME%\extensions\plugins"
echo Deleting H2 database for a clean start
del /S /Q "%SONAR_HOME%\data\sonar*.*"
start %SONAR_HOME%\bin\windows-x86-64\StartSonar.bat
cd /d "%AUDIT_PROJ%"
echo sleep while SonarQube starts..........
pause
echo starting Sonar-Runner....
sonar-runner.bat -e -X
