package com.deadfyre.fyrebot.commands;

import org.javacord.api.entity.message.MessageBuilder;
import org.javacord.api.entity.message.MessageDecoration;
import org.javacord.api.event.message.MessageCreateEvent;

import java.io.File;

public class WelcomeCommand implements Command{
    @Override
    public void process(MessageCreateEvent event) {
        try {
            String imgPath = (System.getProperty("user.dir") + "\\src\\main\\java\\com\\deadfyre\\fyrebot\\images\\");
            Long channelid = Long.parseLong(event.getMessageContent().split(" ")[1]);
            Long roleChannel = 558811827220381738L;

            if (!event.getApi().getTextChannelById(channelid).isPresent()) {
                event.getChannel().sendMessage("Error: Channel id is invalid!");
            }else{
                event.getChannel().sendMessage("Sending welcome message...");

                new MessageBuilder()
                        .addAttachment(new File(imgPath + "Welcome.png"))
                        .send(event.getApi().getTextChannelById(channelid).get());
                Thread.sleep(2000);
                event.getApi().getTextChannelById(channelid).get().type();
                new MessageBuilder()
                        .addAttachment(new File(imgPath + "Divider.png"))
                        .send(event.getApi().getTextChannelById(channelid).get());
                Thread.sleep(2000);
                new MessageBuilder()
                        .append("Welcome to the DeadFyre discord server!")
                        .appendNewLine()
                        .append("To get started head over to "+ event.getApi().getServerTextChannelById(roleChannel).get().getMentionTag() +" to select your proper roles.")
                        .appendNewLine()
                        .appendNewLine()
                        .append("Server Rules", MessageDecoration.BOLD, MessageDecoration.UNDERLINE)
                        .appendNewLine()
                        .appendNewLine()
                        .append("- The one rule is Use Common Sense. Things like spamming, Not using proper channels, arguing or causing drama, excessive swearing, racism, and so on. \n" +
                                "This rule will be enforced at our discretion.")
                        .appendNewLine()
                        .append("- Be sure to also follow discord's TOS. It can be found here: https://discordapp.com/terms")
                        .send(event.getApi().getTextChannelById(channelid).get());
                new MessageBuilder()
                        .addAttachment(new File(imgPath + "Divider.png"))
                        .send(event.getApi().getTextChannelById(channelid).get());
                Thread.sleep(2000);
                new MessageBuilder()
                        .append("Links", MessageDecoration.UNDERLINE, MessageDecoration.BOLD)
                        .appendNewLine()
                        .append("Website: https://deadfyre.com/")
                        .appendNewLine()
                        .append("Discord: https://discord.gg/uaxgEhu")
                        .send(event.getApi().getTextChannelById(channelid).get());
                new MessageBuilder()
                        .addAttachment(new File(imgPath + "Divider.png"))
                        .send(event.getApi().getTextChannelById(channelid).get());

                event.getChannel().sendMessage("Welcome message successfully sent!");
            }

        }catch (Exception e){
            event.getChannel().sendMessage("Error: Command format is ``!welcome [channelid]``");
        }
    }
}
