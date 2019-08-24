package com.johanneslosch.discordbotframework;

import net.dv8tion.jda.api.AccountType;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;

import javax.security.auth.login.LoginException;

public class Main {
    public static JDABuilder builder;

    public static void main(String[] Args) {

        builder = new JDABuilder(AccountType.BOT);

        builder.setToken("NjA1MTQ2NjI3NTQ3ODU2OTA2.XT55gQ.d4_9QGJx0qzB6VhxMlnSRXWTRTg");
        builder.setAutoReconnect(true);

        builder.setStatus(OnlineStatus.DO_NOT_DISTURB);


        addListeners();
        addCommands();

        try {
            JDA jda = builder.build();
        } catch (LoginException e) {
            e.printStackTrace();
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
