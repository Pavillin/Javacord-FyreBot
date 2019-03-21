package com.deadfyre.fyrebot.commands;

import org.javacord.api.event.message.MessageCreateEvent;

public class PingPongCommand implements Command {

    /**
     * This command will reply 'Pong!' when someone types '!ping' in a channel
     * @param event
     */
    public void process(MessageCreateEvent event) {
        event.getChannel().sendMessage("Pong!");
    }
}
