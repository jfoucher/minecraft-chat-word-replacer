package fr.sixpixels.wordreplacer;

import org.bukkit.Bukkit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ChatReplacement {
    private Pattern pattern;

    private String word;
    private List<ReplacementItem> replacementItems = new ArrayList<>();

    public ChatReplacement(String pattern, List<ReplacementItem> replacements) {
        this.word = pattern;
        this.pattern = Pattern.compile("\\b(" + pattern + ")+\\b");
        this.replacementItems = replacements;
    }

    public String replaceText(String original) {
        if (pattern == null) return original;
        Double totalChance = 0.0;
        for (ReplacementItem item: this.replacementItems) {
            totalChance += item.chance;
        }
        double r = Math.random() * totalChance;
        double countWeight = 0.0;
        for (ReplacementItem item : this.replacementItems) {
            countWeight += item.chance;
            if (countWeight >= r) {
                Matcher matcher = pattern.matcher(original);

                return matcher.replaceAll(item.replacement);
            }
        }

        return original;
    }
}
