package com.deadfyre.fyrebot.commands;

import org.javacord.api.event.message.MessageCreateEvent;
import org.javacord.api.listener.message.MessageCreateListener;

public class PmTest implements MessageCreateListener{

    @Override
    public void onMessageCreate(MessageCreateEvent event) {
        if (event.getMessage().getContent().equalsIgnoreCase("!pm")) {
            event.getMessageAuthor().asUser().get().sendMessage("test");
        }
    }
}
