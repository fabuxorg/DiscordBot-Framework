package com.johanneslosch.discordbotframework;


import com.johanneslosch.discordbotframework.datahandler.filehandler.config.ConfigReader;
import net.dv8tion.jda.api.AccountType;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import org.junit.jupiter.api.Test;

import javax.security.auth.login.LoginException;


class MainTest {

    @Test
    void main() {

        Main.builder = new JDABuilder(AccountType.BOT);

        Main.builder.setToken(ConfigReader.read("data", "config", "discord_token"));
        Main.builder.setAutoReconnect(true);



        Main.builder.setStatus(Main.handleOnlineStatus());



        try {
            JDA jda = Main.builder.build();
        } catch (LoginException e) {
            e.printStackTrace();
        }
    }

}