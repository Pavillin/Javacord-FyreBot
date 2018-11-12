package com.deadfyre.fyrebot;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.javacord.api.util.logging.FallbackLoggerConfiguration;
import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;
import com.deadfyre.fyrebot.commands.PingPongCommand;

public class Main {

    public static void main(String[] args) {
        if (args.length < 1) {
            System.err.println("Please provide a valid token as the first argument!");
            return;
        }
        // Enable debugging, if no slf4j logger was found
        FallbackLoggerConfiguration.setDebug(true);

        //The token is the first argument of the program
        String token = args[0];

        //Login
        DiscordApi api = new DiscordApiBuilder().setToken(token).login().join();

        //Add listeners for commands
        api.addMessageCreateListener(new PingPongCommand());

        //Print the invite url of bot
        System.out.println("You can invite the bot by using the following url: " + api.createBotInvite());
    }

}
