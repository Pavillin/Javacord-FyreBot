package com.deadfyre.fyrebot.listeners;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.javacord.api.entity.channel.ServerTextChannel;
import org.javacord.api.entity.message.embed.EmbedBuilder;
import org.javacord.api.entity.permission.PermissionType;
import org.javacord.api.event.server.ServerJoinEvent;
import org.javacord.api.listener.server.ServerJoinListener;
import java.awt.*;

public class ServerJoin implements ServerJoinListener {

    private Logger logger = LogManager.getLogger();

    @Override
    public void onServerJoin(ServerJoinEvent event) {
        logger.info("Joined server " + event.getServer().getName());
        for (ServerTextChannel textChannel : event.getServer().getTextChannels()) {
            if(textChannel.hasPermission(event.getApi().getYourself(), PermissionType.SEND_MESSAGES)){
                textChannel.sendMessage(JoinDM());
                break;
            }
        }
    }

    /**
     * This method returns the Direct Message (DM) that will be sent to the owner of the server the bot connects to
     * @return
     */
    private static EmbedBuilder JoinDM (){
        Color color = new Color(238,119,0);
        return new EmbedBuilder()
                .setColor(color)
                .setTitle("FyreBot")
                .setDescription("Hey, I'm FyreBot! Thanks for inviting me to your server!\n\n" +
                        "My prefix is `!` for example `!command`\n\n" +
                        "To get started use `!help` to list all my commands!\n\n" +
                        "I'm developed by `Drix#8197` so if you have any questions about me you should ask him.");
    }
}
