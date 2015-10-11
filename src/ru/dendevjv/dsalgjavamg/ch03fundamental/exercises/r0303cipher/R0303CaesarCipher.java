package ru.dendevjv.dsalgjavamg.ch03fundamental.exercises.r0303cipher;

import ru.dendevjv.dsalgjavamg.ch03fundamental.p1cipher.Cipher;

/**
    Class for doing encryption ad decryption using the Caesar Cipher.
    Exercise: R-3.3 
    Explain the changes that would have to be made to the program of Code 
    Fragment 3.8 so that it could perform the Caesar cipher for messages that are written
    in an alphabet-based language other than English, such as Greek, Russian, or
    Hebrew.
 */
public class R0303CaesarCipher implements Cipher {
    public static final String ENGLISH_ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static final String RUSSIAN_ALPHABET = "ÀÁÂÃÄÅ¨ÆÇÈÉÊËÌÍÎÏĞÑÒÓÔÕÖ×ØÙÜÛÚİŞß";
    
    private String alphabetStr;
    private int alphabetLength;
    
    protected char[] encoder;
    protected char[] decoder;
    
    public R0303CaesarCipher(String alphabet, int rotation) {
        alphabetStr = alphabet;
        char[] alphabetChars = alphabet.toCharArray();
        alphabetLength = alphabetChars.length;
        encoder = new char[alphabetLength];
        decoder = new char[alphabetLength];
        
        int encIdx, decIdx;
        for (int k = 0; k < alphabetLength; k++) {
            encIdx = (k + rotation) % alphabetLength;
            decIdx = (k - rotation + alphabetLength) % alphabetLength;
            
            encoder[k] = alphabetChars[encIdx];
            decoder[k] = alphabetChars[decIdx];
        }
    }
    
    @Override
    public String encrypt(String message) {
        return transform(message, encoder);
    }

    @Override
    public String decrypt(String secret) {
        return transform(secret, decoder);
    }
    
    private String transform(String original, char[] code) {
        char[] msg = original.toCharArray();
        for (int i = 0; i < msg.length; i++) {
            if (Character.isUpperCase(msg[i])) {
                msg[i] = code[getOffsetInAlphabet(msg[i])];
            }
        }
        return new String(msg);
    }

    private int getOffsetInAlphabet(char ch) {
        return alphabetStr.indexOf(ch);
    }

    public static void main(String[] args) {
        R0303CaesarCipher cipher = new R0303CaesarCipher(R0303CaesarCipher.ENGLISH_ALPHABET, 3);
        
        System.out.println("Encription code: " + new String(cipher.encoder));
        System.out.println("Decription code: " + new String(cipher.decoder));
        
        String message = "THE EAGLE IS IN PLAY; MEET AT JOE'S";
        String coded = cipher.encrypt(message);
        System.out.println("Secret : " + coded);
        
        String answer = cipher.decrypt(coded);
        System.out.println("Message: " + answer);
    }


}
