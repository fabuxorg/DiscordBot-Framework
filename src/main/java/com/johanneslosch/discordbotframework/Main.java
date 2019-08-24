package com.johanneslosch.discordbotframework;

import com.johanneslosch.discordbotframework.datahandler.filehandler.config.ConfigReader;
import net.dv8tion.jda.api.AccountType;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;

import javax.security.auth.login.LoginException;

public class Main {
    public static JDABuilder builder;

    public static void main(String[] Args) {

        builder = new JDABuilder(AccountType.BOT);

        builder.setToken(ConfigReader.read("data", "config", "discord_token"));
        builder.setAutoReconnect(true);



        builder.setStatus(handleOnlineStatus());

        addListeners();
        addCommands();

        try {
            JDA jda = builder.build();
        } catch (LoginException e) {
            e.printStackTrace();
        }

    }

    private static OnlineStatus handleOnlineStatus() {
        if(ConfigReader.read("data", "config", "online_status").equalsIgnoreCase("Online")){
            return OnlineStatus.ONLINE;
        }else if(ConfigReader.read("data", "config", "online_status").equalsIgnoreCase("Offline")){
            return OnlineStatus.OFFLINE;
        }else if(ConfigReader.read("data", "config", "online_status").equalsIgnoreCase("DO_NOT_DISTURB")){
            return OnlineStatus.DO_NOT_DISTURB;
        }else{
            System.out.println("SET ONLINE STATUS IN CONFIG!");
            return OnlineStatus.IDLE;
        }
    }

    public static void addCommands() {
        //commandHandler.commands.put("autochan", new Autochannel());
        //commandHandler.commands.put("warn", new Autochannel());
    }

    public static void addListeners() {

        //builder.addEventListener(new commandListener());
    }

}
