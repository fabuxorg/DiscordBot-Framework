package org.fabux.discordbotframework.util.versionhandler;

import org.fabux.discordbotframework.util.logs.Logger;
import org.jetbrains.annotations.NotNull;
import org.kohsuke.github.GitHub;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;

public class VersionHandler {
    /**
     * To get the version from Git(hub) and your Gradle.
     * @param GIT_USER      your Github username
     * @param GIT_REPO      your Github repository name
     */
    public static void version(String GIT_USER, String GIT_REPO){
        if(getLatestGitReleaseNameTag(GIT_USER, GIT_REPO).equals(getLocalVersion())){
            System.out.println("Current version is installed!");
        }else {
            System.out.println(String.format("You have to update! \n Latest Release with Tag: %s is here: %s", getLatestGitReleaseNameTag(GIT_USER, GIT_REPO), getLatestReleaseUrl(GIT_USER, GIT_REPO)));
        }
    }
    /*
    Reference http://github-api.kohsuke.org/
    and of cause https://developer.github.com/v3/repos/releases/
     */
    //TODO: find something better than @NotNull
    @NotNull
    @Deprecated
    private static String getLatestGitReleaseNameTag(String GIT_USER, String GIT_REPO)  {
        GitHub gitHub = null;
        try {
            gitHub = GitHub.connect();
        } catch (IOException e) {
            Logger.logger(e.getMessage());
            e.printStackTrace();
        }
        try {
            assert gitHub != null;
            return gitHub.getUser(GIT_USER).getRepository(GIT_REPO).getLatestRelease().getTagName();
        } catch (IOException e) {
            Logger.logger(e.getMessage());
            e.printStackTrace();
        }
        return null;
    }
    //TODO: find something better than @NotNull
    @NotNull
    @Deprecated
    private static URL getLatestReleaseUrl(String GIT_USER, String GIT_REPO){
        GitHub gitHub = null;
        try {
            gitHub = GitHub.connect();
        } catch (IOException e) {
            Logger.logger(e.getMessage());
            e.printStackTrace();
        }
        try {
            assert gitHub != null;
            return gitHub.getUser(GIT_USER).getRepository(GIT_REPO).getLatestRelease().getUrl();
        } catch (IOException e) {
            Logger.logger(e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

    /*
    Reference: https://stackoverflow.com/questions/38275583/create-version-txt-file-in-project-dir-via-build-gradle-task
    and https://stackoverflow.com/questions/37101589/how-to-read-a-properties-files-and-use-the-values-in-project-gradle-script
     */
    private static String getLocalVersion(){
        Properties prop = new Properties();
        InputStream input = null;
        try {
            input = new FileInputStream(new File("/src/main/resources/version.txt"));
            // load a properties file
            prop.load(input);
            // get the property value and print it out
        } catch (IOException ex) {
            Logger.logger(ex.getMessage());
            ex.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    Logger.logger(e.getMessage());
                    e.printStackTrace();
                }
            }
        }
        return prop.getProperty("version");
    }
}