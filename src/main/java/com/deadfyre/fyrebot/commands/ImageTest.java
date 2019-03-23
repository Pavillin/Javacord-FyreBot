package com.deadfyre.fyrebot.commands;

import org.javacord.api.entity.message.MessageBuilder;
import org.javacord.api.event.message.MessageCreateEvent;

import java.io.File;

public class ImageTest implements Command{
    @Override
    public void process(MessageCreateEvent event) {
        String imgPath = (System.getProperty("user.dir") + "\\src\\main\\java\\com\\deadfyre\\fyrebot\\images\\Select_Your_Roles.png");
        new MessageBuilder()
                .append("I'm trying to send a message, pls work")
                .addAttachment(new File(imgPath))
                .send(event.getChannel());
    }
}
