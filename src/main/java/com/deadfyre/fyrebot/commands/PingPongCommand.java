package com.deadfyre.fyrebot.commands;

import org.javacord.api.event.message.MessageCreateEvent;
import org.javacord.api.listener.message.MessageCreateListener;

public class PingPongCommand implements MessageCreateListener {

    /**
     * This command will reply 'Pong!' when someone types '!ping' in a channel
     * @param event
     */
    @Override
    public void onMessageCreate(MessageCreateEvent event){
        if (event.getMessage().getContent().equalsIgnoreCase("!ping")) {
            event.getChannel().sendMessage("Pong!");
        }
    }
}
