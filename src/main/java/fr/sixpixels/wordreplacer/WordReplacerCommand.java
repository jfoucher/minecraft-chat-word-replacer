package fr.sixpixels.wordreplacer;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class WordReplacerCommand implements CommandExecutor {
    private final fr.sixpixels.wordreplacer.Main main;
    public WordReplacerCommand(Main main) {
        this.main = main;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (s.equalsIgnoreCase("wordreplacer") && strings.length > 0) {
            if (strings[0].equalsIgnoreCase("reload") && (commandSender.hasPermission("wordreplacer.reload") || commandSender.hasPermission("wordreplacer.admin"))) {
                main.loadConfig();
                commandSender.sendMessage(ChatColor.GRAY + "[" + ChatColor.BOLD + "" + ChatColor.GOLD + "WordReplacer"  + ChatColor.RESET + "" + ChatColor.GRAY + "] " +ChatColor.RESET + "configuration reloaded");
                return true;
            }
        }

        return false;
    }
}
