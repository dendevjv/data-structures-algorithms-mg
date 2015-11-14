/*
    P-5.27 
    Implement a recursive method with calling signature find(path, filename) that
    reports all entries of the file system rooted at the given path having the given file
    name.
 */
package ru.dendevjv.dsalgjavamg.ch05recursion.projects;

import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class P0527FindFile {

    public static void main(String[] args) {
        JFileChooser chooser = new JFileChooser(new File("."));
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            File dir = chooser.getSelectedFile();
            
            String filename = JOptionPane.showInputDialog("Enter filename");
            
            find(dir.getAbsolutePath(), filename);
        }
    }

    private static void find(String path, String filename) {
        File currentPath = new File(path);
        for (String dirEntry : currentPath.list()) {
            if (dirEntry.equals(filename)) {
                System.out.printf("%s found in %s%n", filename, path);
            }
            File entryFile = new File(path, dirEntry);
            if (entryFile.isDirectory()) {
                find(entryFile.getAbsolutePath(), filename);
            }
        }
    }
}
