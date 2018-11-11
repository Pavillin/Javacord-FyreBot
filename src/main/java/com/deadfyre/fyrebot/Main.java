package com.deadfyre.fyrebot;

import com.deadfyre.fyrebot.commands.PingPongCommand;
import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;

public class Main {

    public static void main(String[] args) {
        if (args.length < 1) {
            System.err.println("Please provide a valid token as the first argument!");
            return;
        }
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
