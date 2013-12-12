set SONAR_PROJ=C:\work\adfemgsonarplugin
set SONAR_HOME=C:\sonar-3.7.3

cd /d "%SONAR_PROJ%"
del /S /Q "%SONAR_PROJ%\target"
call mvn clean license:format install 
copy "target\sonar-*.jar" "%SONAR_HOME%\extensions\plugins"
echo Deleting H2 database for a clean start
del /S /Q "%SONAR_HOME%\data\sonar*.*"
start %SONAR_HOME%\bin\windows-x86-64\StartSonar.bat

echo sleep while SonarQube starts..........
pause
echo starting Sonar-Runner....
%SONAR_HOME%\bin\sonar-runner.bat -e -X
