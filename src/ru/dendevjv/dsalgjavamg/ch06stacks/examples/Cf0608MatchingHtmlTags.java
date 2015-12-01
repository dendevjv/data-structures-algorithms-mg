package ru.dendevjv.dsalgjavamg.ch06stacks.examples;

import java.io.File;
import java.io.IOException;

import javax.swing.JFileChooser;

import ru.dendevjv.dsalgjavamg.utils.Files;

public class Cf0608MatchingHtmlTags {
    
    private static void process(String html) {
        HtmlTagMatcher matcher = new HtmlTagMatcher(html);
        if (matcher.matches()) {
            System.out.println("HTML Tags Match");
        } else {
            System.out.println("HTML Tags DO NOT Match");
        }
    }

    public static void main(String[] args) {
        JFileChooser chooser = new JFileChooser("..");
        if (JFileChooser.APPROVE_OPTION ==  chooser.showOpenDialog(null)) {
            File file = chooser.getSelectedFile();
            try {
                String html = Files.read(file);
                process(html);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * My implementation of HTML tag matcher.
     *
     * @author dendevjv
     */
    private static class HtmlTagMatcher {
        private Stack<String> buffer = new Cf0604LinkedStack<>();
        private String html;
        
        private HtmlTagMatcher(String html) {
            this.html = html;
        }
        
        private boolean matches() {
            for (int i = 0; i < html.length(); ) {
                int start = html.indexOf('<', i);
                if (start == -1) {
                    break;
                }
                int end = html.indexOf('>', start + 1);
                if (end == -1) {
                    return false;
                }
                i = end + 1;
                
                String tag = html.substring(start + 1, end);    // <b></b>
                if (tag.startsWith("/")) {  // closing tag
                    if (buffer.isEmpty()) {
                        return false;
                    }
                    String openingTag = buffer.pop();
                    String closingTag = tag.substring(1);
                    if (!openingTag.equals(closingTag)) {
                        return false;
                    }
                } else {
                    buffer.push(tag);
                }
            }
            return buffer.isEmpty();
        }
    }
    
    /** Code fragment 6.8 - Textbook implementation. */
    @SuppressWarnings("unused")
    private static boolean isHTMLMathed(String html) {
        Stack<String> buffer = new Cf0604LinkedStack<String>();
        int j = html.indexOf('<');
        while (j != -1) {
            int k = html.indexOf('>', j + 1);
            if (k == -1) {
                return false;
            }
            String tag = html.substring(j + 1, k);
            if (!tag.startsWith("/")) {
                buffer.push(tag);
            } else {
                if (!buffer.pop().equals(tag.substring(1))) {
                    return false;
                }
            }
            j = html.indexOf('<', k + 1);
        }
        return buffer.isEmpty();
    }
}
