<div align="center">
    <img src="https://github.com/fabuxorg/DiscordBot-Framework/blob/master/Logo.png" alt="Logo" width="200" />
    <h1>DiscordBot-Framework</h1>
    <strong>This Framework is an easy way to develop a bot for Discord. </strong><br><br>

<!---
BADGES!!!
--->
[![CodeFactor](https://www.codefactor.io/repository/github/k-ey/discordbot-framework/badge)](https://www.codefactor.io/repository/github/k-ey/discordbot-framework)
[![Codacy Badge](https://api.codacy.com/project/badge/Grade/744ca049ce9c4f05a223066a3202de06)](https://www.codacy.com/manual/Losch/DiscordBot-Framework?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=K-EY/DiscordBot-Framework&amp;utm_campaign=Badge_Grade)

</div>

## Overview
<a href="#dependencies">Dependencies</a><br>
<a href="#creators">Creators</a><br>
<a href="#Documentation">Documentation</a><br>


## Dependencies
[JDA](https://github.com/DV8FromTheWorld/JDA#download)<br>
[MongoDB](https://www.mongodb.com/)<br>
[Java GithubAPI](http://github-api.kohsuke.org/)<br>
[Github API](https://developer.github.com/v3/)<br>

## Documentation
<a href="#commands">Commands</a><br>
<a href="#datahandler">DataHandler</a><br>
<a href="#database">Database</a><br>
<a href="#file-handling">File handling</a><br>
<a href="#logger">Log files</a><br>

### commands
To add commands you have to extend the Interface `ICommand`.

### datahandler
You have a few ways to handle data with this framework.

<a href="#database">1. Databases</a><br>
<a href="#files">2. Files</a><br>

### database
First of all you have two possible ways to use databases.
You can use NOSQL with
<a href="#mongodb">mongodb</a> and <a href="#sql">SQL</a>.

#### mongodb
To use Mongodb you have to use the `MongoDBHandler`.

#### sql
To use SQL you have to use the `SQLHandler`.

### files
You have two main components of files witch this framework is supporting right now to 100 %. <br>
<a href="#properties">1. Properties-Files (Config files)</a> and<br>
<a href="#txt">2. .txt-files</a> <br>
You can use the Classes and methods for the txt files for all other formats too, but it's at now not supported. (coming soon)

#### properties
To write a properties file you should use this method.
Properties files are like `filename.prop` the ending .prop is already defined.

##### How to write something to a properties file?

````
ConfigWriter.writePropertiesFile("path", "filename", "key-to-safe", "value-for-key");
````

##### How to read something from a properties file?

````
String config = ConfigReader.read("path", "filename", "key-to-safe");
````

### Version Control
The Version Control is a backround part to make sure that anytime the newest version from this Framework is installed.

You can use it like this in your Java code.
```
VersionHandler.version(<YOUR-GIT-NAME>, <YOUR-GIT-REPO>);
```
and if you use gradle you have to paste this in your build.gradle:
```
task createProperties(dependsOn: processResources) {
    doLast {
        File file = new File(projectDir,"/src/main/resources/version.txt")
        file.text = "version:" + project.version.toString()
    }
}
```


### Folder Structure
All plugins have to be in the PLUGINS Folder, and each of them has it's own config/settings file (.prob/.xml/.txt/.yaml) in it.
If you want you can create extra files or let the Framework download extra files (if the website is whitelisted.)

### WebAccess
this feature provides the user access to content from websites like:
* strings
* Integer
* Boolean
* other

### GUI
for a custom gui port change the `online_gui_port` attribute to your custom port

### How to use it

     @param URL {String}                  website where you which you need content from
     @param search {String}               your search quarry
     @param attributeLength {Integer}     the length of the attribute you want to get
     @param addOne {boolean}              if there is a symbol between search quarry and attribute
     retun: String with attribute
    
```
WebAccess.get(<URL>, <search>, <attributeLength>, <addOne>);
```

## Creators
   ### JohannesLosch#2817
   You can follow him at: <br>
   <a href="http://twitter.com/johanneslosch">Twitter</a><br>
   <a href="http://twitch.tv/hannesr6s">Twitch</a><br>
   <a href="http://k-ey.wf">Website</a> <br><br>
