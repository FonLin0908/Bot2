package com.bowchan.listenner;

import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.entities.channel.ChannelType;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import net.dv8tion.jda.api.entities.channel.middleman.MessageChannel;
import net.dv8tion.jda.api.entities.emoji.Emoji;
import net.dv8tion.jda.api.events.emoji.EmojiAddedEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.events.message.react.MessageReactionAddEvent;
import net.dv8tion.jda.api.events.message.react.MessageReactionRemoveEmojiEvent;
import net.dv8tion.jda.api.events.message.react.MessageReactionRemoveEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.requests.restaction.MessageCreateAction;

import java.io.IOException;
import java.nio.channels.Channel;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Listenner1 extends ListenerAdapter {

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        /*if (event.getAuthor().isBot()){
            return;
        }else */if(event.getMessage().getContentDisplay().contains("...")){
            try {
                DiscordWebhook discordWebhook = new DiscordWebhook();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }



    @Override
    public void onMessageReactionAdd(MessageReactionAddEvent event) {
        if (event.getGuild().getId().equals("1039141210016727080")&&event.getMessageId().equals("1093569642758426694")) {
            if (event.getEmoji().getName().equals("\uD83D\uDCBB")) {

                event.getGuild().addRoleToMember(event.getUser(),event.getGuild().getRoleById("1090272637961392279")).queue();

            } else if (event.getEmoji().getName().equals("\uD83C\uDFAE")) {

                event.getGuild().addRoleToMember(event.getUser(),event.getGuild().getRoleById("1090276776745386096")).queue();

            } else if (event.getEmoji().getName().equals("\uD83C\uDFA3")) {

                event.getGuild().addRoleToMember(event.getUser(),event.getGuild().getRoleById("1093566932961218620")).queue();

            }
        } else if(event.getGuild().getId().equals("1087392797054742659")&&event.getMessageId().equals("1093575647969951764")) {
            if (event.getEmoji().getName().equals("\uD83C\uDFA3")){
                event.getGuild().addRoleToMember(event.getUser(),event.getGuild().getRoleById("1093571707131924560")).queue();
                event.getGuild().getTextChannelsByName("身分組領取清除",true).get(0).sendMessage("已給予"+event.getUser().getAsMention()+event.getGuild().getRoleById("1093571707131924560").getAsMention()).queue();
            }
        }


    }

    @Override
    public void onMessageReactionRemove(MessageReactionRemoveEvent event) {
        if (event.getGuild().getId().equals("1039141210016727080")&&event.getMessageId().equals("1093569642758426694")){
            if(event.getEmoji().getName().equals("\uD83D\uDCBB")) {

                event.getGuild().removeRoleFromMember(Objects.requireNonNull(event.getUser()),event.getGuild().getRoleById("1090272637961392279")).queue();

            } else if(event.getEmoji().getName().equals("\uD83C\uDFAE")) {

                event.getGuild().removeRoleFromMember(Objects.requireNonNull(event.getUser()),event.getGuild().getRoleById("1090276776745386096")).queue();

            } else if(event.getEmoji().getName().equals("\uD83C\uDFA3")) {

                event.getGuild().removeRoleFromMember(Objects.requireNonNull(event.getUser()),event.getGuild().getRoleById("1093566932961218620")).queue();

            }
        } else if (event.getGuild().getId().equals("1087392797054742659")) {
            if (event.getEmoji().getName().equals("\uD83C\uDFA3")&&event.getMessageId().equals("1093575647969951764")){
                event.getGuild().removeRoleFromMember(Objects.requireNonNull(event.getUser()),event.getGuild().getRoleById("1093571707131924560")).queue();
                event.getGuild().getTextChannelsByName("身分組領取清除",true).get(0).sendMessage("已清除"+event.getUser().getAsMention()+event.getGuild().getRoleById("1093571707131924560").getAsMention()).queue();
            }
        }

    }
}
