package com.deadfyre.fyrebot;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.javacord.api.util.logging.FallbackLoggerConfiguration;
import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;
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

        //The token is the first argument of the program
        String token = args[0];

        //Login
        DiscordApi api = new DiscordApiBuilder().setToken(token).login().join();

        //Add listeners for commands
        api.addMessageCreateListener(new PingPongCommand());

        //Log the bot invite url
        logger.info("You can invite me by using the following url: " + api.createBotInvite());

        //Log a message, if the bot joined or left a server
        api.addServerJoinListener(event -> logger.info("Joined server " + event.getServer().getName()));
        api.addServerLeaveListener(event -> logger.info("Left server " + event.getServer().getName()));
    }

}
