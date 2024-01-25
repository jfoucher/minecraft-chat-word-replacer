package fr.sixpixels.wordreplacer;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatReplacer implements Listener {

    private final fr.sixpixels.wordreplacer.Main main;
    public ChatReplacer(Main main) {
        this.main = main;
    }

    @EventHandler
    public void onChat(AsyncPlayerChatEvent e){
        String msg = e.getMessage();

        for(ChatReplacement component: main.chatReplacements) {
            msg = component.replaceText(msg);
        }

        e.setMessage(msg);
    }
}
