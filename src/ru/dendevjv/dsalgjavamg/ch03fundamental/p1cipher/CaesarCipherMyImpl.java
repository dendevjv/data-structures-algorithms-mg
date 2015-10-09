package ru.dendevjv.dsalgjavamg.ch03fundamental.p1cipher;

/**
 * My naive attempt to implement Caesar Cipher.
 */
public class CaesarCipherMyImpl implements Cipher {
    private static char[] alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
    
    private char[] cipher;
    
    public CaesarCipherMyImpl(int rotation) {
        cipher = new char[alphabet.length];
        for (int i = 0; i < alphabet.length; i++) {
            char ch = alphabet[i];
            char ci = (char)('A' + ((ch - 'A' + rotation) % alphabet.length));
            cipher[i] = ci;
        }
    }
    
    public String encrypt(String message) {
        char[] encChars = new char[message.length()];
        int j;
        for (int i = 0; i < encChars.length; i++) {
            j = (message.charAt(i) - 'A');
            encChars[i] = cipher[j];
        }
        return new String(encChars);
    }

    @Override
    public String decrypt(String secret) {
        char[] msgChars = new char[secret.length()];
        int j;
        for (int i = 0; i < msgChars.length; i++) {
            j = findIndex(cipher, secret.charAt(i));
            msgChars[i] = alphabet[j];
        }
        return new String(msgChars);
    }

    private int findIndex(char[] arr, char ch) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == ch) {
                return i;
            }
        }
        return -1;
    }
}
