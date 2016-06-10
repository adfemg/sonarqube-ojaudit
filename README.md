# sonarqube-ojaudit
SonarQube plugin to run the JDeveloper 11g or 12c code auditing tool (ojaudit) in the background and report 
all violations found by the Oracle JDeveloper auditing framework to SonarQube. Can be used for any 
JDeveloper 11g or 12c project, whether it is SOA, plain java, WebCenter, ADF or anything else. 

## Download and Installation
1. before you install the plugin, run `JDEV_HOME/jdev/bin/ojaudit -rulehelp -output SONAR_HOME/conf/ojaudit-rulehelp.txt` to generate a text file with all the audit rules in your JDeveloper installation. This is needed by the SonarQube plugin to discover all the rules that are available. Unfortunately, JDeveloper version 11.x does not include the severity for all rules in this file so all will be imported in SonarQube with severity Major. You can change these afterwards if you like.
1. ~~if you decide to name the file something else or put it in another directory then edit `SONAR_HOME/conf/sonar.properties` and add a line `sonar.ojaudit.rulehelp=conf/ojaudit-rulehelp.txt` to point to the location of the created text file. This path is relative to SONAR_HOME or can be an absolute path~~ (version 1.0 only works when rulehelp.txt file is placed in conf directory in sonar home directory)
1. download the latest version of the plugin from https://java.net/projects/sonarqube-ojaudit/downloads 
  you don't need to download the sources to use the plugin, although you are welcome to do so and have a look how the thing really works
1. put the downloaded JAR into `SONAR_HOME/extensions/plugins/`
1. (re)start SonarQube
1. go to sonar in your webbrowser, login as administrator and go to settings. Then go to the `ADF EMG ojaudit` settings and set the value for the `sonar.ojaudit.jdevhome` property. This should be the full path to the jdeveloper home directory. This is the directory that has `jdev/bin` as the subdirectory, for example `/apps/oracle/jdev12120/jdeveloper`
1. while you are in the SonarQube web interface, go to Quality Profiles and verify there is a group for OJAudit Profiles that should have a `Sonar way` profile with (depending on your JDeveloper installation) over 800 active rules. If 0 rules are active you have started SonarQube once without the `SONAR_HOME/conf/ojaudit-rulehelp.txt` file in place. Check if the file is there and if so, enable all rules in the `Sonar way` profile. You can do this by editing the profile and search for all inactive rules from the ojaudit repository. Then simply use the bulk change at the right hand top to enable them all.

## Usage
**Be sure to read the installation instructions, especially the part on getting the rulehelp.txt file from ojaudit and registering it with SonarQube**

When you analyse a project using SonarQube you can either use ant, maven or the command-line sonar-runner. Since the latter is the preferred approach by SonarQube we'll be using that as an example although the same settings apply to the other methods.

For sonar-runner to do its work it needs a `sonar-project.properties` file in the root of the project you are going to analyse. When using the ojaudit plugin the example below is the simplest setup:
```
# basic information about the sonar project
sonar.projectKey=ExampleProject
sonar.projectName=Description of your project.
sonar.projectVersion=0.99

# set language to use ojaudit plugin
sonar.language=ojaudit
# sources of the project assuming this properties file is 
# in same directory as .jws file
sonar.sources=.

# jdeveloper workspace file to analyze.
# Relative path from the directory of this property file
sonar.ojaudit.jws=ojauditSonar.jws
```

Once this is done you can simply run `SONAR_HOME/bin/sonar-runner` from your project directory and it should analyse your project with ojaudit and feed all violations to SonarQube. 

Most projects that you want to analyse with ojaudit probably also have java code in them. You could create two `sonar-project.properties` files and use one to analyse your project with java plugins and one for ojaudit, but there is a clever way to do both in one run by using modules. You can specify multiple modules in a single `sonar-project.properties` file and then override sonar properties per module. This allows you to setup one module for java analysis and another for ojaudit analysis:
```
# basic information about the sonar project
sonar.projectKey=ExampleProject
sonar.projectName=Description of your project.
sonar.projectVersion=0.99

# use two modules
sonar.modules=java-module,ojaudit-module

# configuration for java-module
java-module.sonar.language=java
# although property is named projectName, this is actually the module name
java-module.sonar.projectName=Java Module
# by default modules are in a subdirectory with there name and we don't need that
java-module.sonar.projectBaseDir=.
java-module.sonar.sources=src/main/java,src/test/java

# configuration for ojaudit-module
# set language to use ojaudit plugin
ojaudit-module.sonar.language=ojaudit
ojaudit-module.sonar.projectName=OJAudit Module
ojaudit-module.sonar.projectBaseDir=.
# sources of the project assuming this properties file is in same directory as .jws file
ojaudit-module.sonar.sources=.
# jdeveloper workspace file to analyze. Relative path from the directory of this property file
ojaudit-module.sonar.ojaudit.jws=ojauditSonar.jws
```

If you now run sonar-runner it should analyse your project in one go with both the SonarQube java analysis as well as the ojaudit analysis from our plugin.

## Configuration Options
Below are the properties you can set.

property | set at | default | meaning
-------- | ------ | ------- | -------
`sonar.ojaudit.target` | project only | no default | Relative path to .jws or .jpr file from sonar project home
`sonar.ojaudit.jdevhome` | global and/or project | no default | absolute path to JDeveloper home directory (that has `jdev/bin` as subdirectory) 
`sonar.ojaudit.profile` | global and/or project  | `All Rules` | name of the JDeveloper audit profile to execute. Run `jdev/bin/ojaudit -profilehelp` to list available profiles. Can also be a path to an exported profile XML file. This path has to be absolute or relative to the sonar project home 
`sonar.ojaudit.executable` | global and/or project  | `ojaudit.exe` on windows, otherwise `ojaudit` | ojaudit executable within `JDEV_HOME/jdev/bin` directory. Is needed to force usage of the 64-bit version of ojdeploy
`sonar.ojaudit.timeoutsecs` | global and/or project | 60 | maximum number of seconds to wait for ojaudit to complete 
`sonar.ojaudit.rulehelp` | global only | `SONAR_HOME/conf/ojaudit-rulehelp.txt` | Path to the output of `ojaudit -rulehelp`. Can be relative to SONAR_HOME or an absolute path.

## Examples
To Do...

# Developing the plugin
If you want to build your own version of the SonarQube plugin from sources this is the page for you. This is also the place to be if you want to contribute to the project by adding new functionality or fixing bugs. If you're just interested in downloading the finished product and using it in your SonarQube installation simply read the instructions above.

Here are the few simple steps if you want to develop the plugin yourself:
1. clone (or fork) `https://github.com/adfemg/sonarqube-ojaudit.git`
1. open the ojauditSonar workspace from that checkout in JDeveloper and browse around
1. run `mvn clean install` to build the plugin with maven, although you can also run this from within JDeveloper by right clicking the `pom.xml`
1. install the resulting `target/sonar-ojaudit-plugin-xxxx.jar` into your SonarQube installation and follow the other configuration instructions above
