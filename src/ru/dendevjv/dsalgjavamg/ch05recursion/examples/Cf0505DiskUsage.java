package ru.dendevjv.dsalgjavamg.ch05recursion.examples;

import java.io.File;
import java.io.IOException;

public class Cf0505DiskUsage {

    public static void main(String[] args) throws IOException {
        File f = new File(".");
//        printInfo(f);
//        
//        f = new File("README.md");
//        printInfo(f);
        
        long total = diskUsage(f);
        System.out.println("Total (Goodrich): " + total);
        total = diskUsageMine(f);
        System.out.println("Total (Mine)    : " + total);
    }
    
    /**
     * Calculates the total disk usage (in bytes) of the portion of the file 
     * system rooted at the given path, while printing a summary akin to
     * the standard 'du' Unix tool.
     */
    public static long diskUsage(File root) {
        long total = root.length();
        if (root.isDirectory()) {
            for (String childName : root.list()) {
                File child = new File(root, childName);
                total += diskUsage(child);
            }
        }
        System.out.println(total + "\t" + root);
        return total;
    }
    
    /**
     * Calculates the total disk usage (in bytes) of the portion of the file 
     * system rooted at the given path, while printing a summary akin to
     * the standard 'du' Unix tool.
     * @author d3nk0v
     */
    public static long diskUsageMine(File root) {
        long total = root.length();
        if (root.isDirectory()) {
            for (File file : root.listFiles()) {
                total += diskUsageMine(file);
            }
        }
        return total;
    }

    @SuppressWarnings("unused")
    private static void printInfo(File f) throws IOException {
        System.out.println(f.getCanonicalPath());
        System.out.println("getFreeSpace: " + f.getFreeSpace());
        System.out.println("getTotalSpace: " + f.getTotalSpace());
        System.out.println("getUsableSpace: " + f.getUsableSpace());
        System.out.println("length: " + f.length());
        System.out.println();
    }

}
