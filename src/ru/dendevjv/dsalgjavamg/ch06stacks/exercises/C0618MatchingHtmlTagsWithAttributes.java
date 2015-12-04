/*
    C-6.18 
    In Code Fragment 6.8 we assume that opening tags in HTML have form <name>,
    as with <li>. More generally, HTML allows optional attributes to be expressed
    as part of an opening tag. The general form used for expressing an attribute is
    <name attribute1="value1" attribute2="value2">; for example, a table can be given a border and additional padding by using an opening tag of
    <table border="3" cellpadding="5">. Modify Code Fragment 6.8 so that
    it can properly match tags, even when an opening tag may include one or more
    such attributes.
 */
package ru.dendevjv.dsalgjavamg.ch06stacks.exercises;

import java.io.File;
import java.io.IOException;

import ru.dendevjv.dsalgjavamg.ch06stacks.examples.Cf0604LinkedStack;
import ru.dendevjv.dsalgjavamg.ch06stacks.examples.Stack;
import ru.dendevjv.dsalgjavamg.utils.Files;

public class C0618MatchingHtmlTagsWithAttributes {

    public static void main(String[] args) {
        try {
            File dataDir = new File("../tmp");
            for (File f : dataDir.listFiles()) {
                System.out.print("Test file: " + f.getName() + ": ");
                String html = Files.read(f);
                if (isHTMLMathed(html)) {
                    System.out.println("match");
                } else {
                    System.out.println("do NOT match");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }        
    }

    private static boolean isHTMLMathed(String html) {
        Stack<String> buffer = new Cf0604LinkedStack<String>();
        int j = html.indexOf('<');
        while (j != -1) {
            int k = html.indexOf('>', j + 1);
            if (k == -1) {
                return false;
            }
            int spaceIdx = html.indexOf(' ', j + 1);
            int tagEnd = (spaceIdx > j && spaceIdx < k) ? spaceIdx : k;
            String tag = html.substring(j + 1, tagEnd);
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
