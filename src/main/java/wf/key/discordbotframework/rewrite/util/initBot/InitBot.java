package wf.key.discordbotframework.rewrite.util.initBot;

import com.johanneslosch.discordbotframework.datahandler.filehandler.config.ConfigReader;
import com.johanneslosch.discordbotframework.util.logs.Logger;
import net.dv8tion.jda.api.AccountType;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;

import javax.security.auth.login.LoginException;

import static wf.key.discordbotframework.rewrite.util.Var.builder;

public class InitBot {
    public InitBot(){
        builder = new JDABuilder(AccountType.BOT);

        builder.setToken(getToken());
        builder.setAutoReconnect(true);

        builder.setStatus(HandleOnlineStatus.handleStatus());

        try {
            JDA jda = builder.build();
        } catch (LoginException e) {
            Logger.logger(e.getMessage());
            e.printStackTrace();
        }
    }
    private String getToken(){
        if(!ConfigReader.read("data", "config", "discord_token").isEmpty() ||
        ConfigReader.read("data", "config", "discord_token").length() == 59){
            System.err.println("Invalid Bot Token");
        }else {
            return ConfigReader.read("data", "config", "discord_token");
        }
        return null;
    }
}
