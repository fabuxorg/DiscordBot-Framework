<div align="center">
    <a src="https://github.com/K-EY/DiscordBot-Framework/media/logo.png><img src=https://github.com/K-EY/DiscordBot-Framework/blob/master/media/logo.png width="200"/>
    <h1>DiscordBot-Framework</h1>
    <strong>This Framework is an easy way to develop a bot for Discord. </strong><br><br>

<!---
BADGES!!!
--->


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
To use Mongodb you have to use the MongoDBHandler.

#### sql
To use SQL you have to use the SQLHandler.

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

## Creators
   ### JohannesLosch#2817
   You can follow him at: <br>
   <a href="http://twitter.com/johanneslosch">Twitter</a><br>
   <a href="http://twitch.tv/hannesr6s">Twitch</a><br>
   <a href="http://k-ey.wf">Website</a> <br><br>
   
   