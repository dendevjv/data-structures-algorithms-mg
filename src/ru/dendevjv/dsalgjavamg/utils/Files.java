package ru.dendevjv.dsalgjavamg.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.swing.JFileChooser;

/**
 * Utility methods for file operations.
 *
 * @author dendevjv
 */
public class Files {
    
    /**
     * Reads specified file as text.
     * @param file input text file 
     * @return text content of the file
     * @throws FileNotFoundException
     * @throws IOException
     */
    public static String read(File file) throws FileNotFoundException, IOException {
        char[] cbuf = new char[1024];
        StringBuilder builder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)))) {
            int numRead;
            while ((numRead = reader.read(cbuf)) != -1) {
                builder.append(cbuf, 0, numRead);
            }
        }
        return builder.toString();
    }

    /** Testing method. */
    public static void main(String[] args) {
        JFileChooser chooser = new JFileChooser(".");
        if (JFileChooser.APPROVE_OPTION ==  chooser.showOpenDialog(null)) {
            File file = chooser.getSelectedFile();
            try {
                String content = read(file);
                System.out.println("Content:");
                System.out.println(content);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("No file chosen");
        }
    }

}
