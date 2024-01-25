package fr.sixpixels.wordreplacer;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
public class ReplacementItem {
    public String replacement;

    public Double chance;

    public static Set<ReplacementItem> replacementItems = new HashSet<>();

    public ReplacementItem(String replacement, Double chance) {
        this.replacement = replacement;
        this.chance = chance;
    }
}
