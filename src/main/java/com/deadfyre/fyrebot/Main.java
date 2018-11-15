package com.deadfyre.fyrebot;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.javacord.api.entity.message.embed.EmbedBuilder;
import org.javacord.api.util.logging.FallbackLoggerConfiguration;
import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;
import java.awt.*;
//Import commands
import com.deadfyre.fyrebot.commands.PingPongCommand;

public class Main {

    private static Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        if (args.length < 1) {
            System.err.println("Please provide a valid token as the first argument!");
            return;
        }
        //Enable debugging, if no slf4j logger was found
        FallbackLoggerConfiguration.setDebug(true);

        //Store the token (the first argument of the program)
        String token = args[0];

        //Login to Discord
        DiscordApi api = new DiscordApiBuilder().setToken(token).login().join();

        //Add listeners for commands
        api.addMessageCreateListener(new PingPongCommand());

        //Log the bot invite url
        logger.info("You can invite me by using the following url: " + api.createBotInvite());

        //Log when bot joins a server and send a DM to server owner
        api.addServerJoinListener(event -> {
            logger.info("Joined server " + event.getServer().getName());
            event.getServer().getOwner().sendMessage(JoinDM());
        });

        //Log a message when the bot leaves a server
        api.addServerLeaveListener(event -> logger.info("Left server " + event.getServer().getName()));
    }

    /**
     * This method returns the Direct Message (DM) that will be sent to the owner of the server the bot connects to
     * @return
     */
    private static EmbedBuilder JoinDM (){
        return new EmbedBuilder()
                .setColor(Color.ORANGE)
                .setTitle("FyreBot")
                .setDescription("Hey, I'm FyreBot! Thanks for inviting me to your server!\n\n" +
                                "My prefix is `!` for example `!help`\n\n" +
                                "To get started use `!help` to list all my commands!\n\n" +
                                "I'm developed by `Drix#8197` so if you have any questions about me you should ask him.");
    }

}
