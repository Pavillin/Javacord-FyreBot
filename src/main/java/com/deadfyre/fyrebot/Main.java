package com.deadfyre.fyrebot;

import com.deadfyre.fyrebot.listeners.CommandHandler;
import com.deadfyre.fyrebot.listeners.ServerJoin;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.javacord.api.util.logging.FallbackLoggerConfiguration;
import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;

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
        api.addMessageCreateListener(new CommandHandler());

        //Log the bot invite url
        logger.info("You can invite me by using the following url: " + api.createBotInvite());

        //Log when bot joins a server and post a message to first channel the bot has permission to send a message in
        api.addServerJoinListener(new ServerJoin());

        //Log a message when the bot leaves a server
        api.addServerLeaveListener(event -> logger.info("Left server " + event.getServer().getName()));
    }
}
