package org.fabux.discordbotframework.util.initBot;

import net.dv8tion.jda.api.OnlineStatus;
import org.fabux.discordbotframework.datahandler.filehandler.config.ConfigReader;

class HandleOnlineStatus {
    static OnlineStatus handleStatus(){
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
}
