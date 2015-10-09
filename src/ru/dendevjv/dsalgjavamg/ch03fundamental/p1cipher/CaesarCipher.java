package ru.dendevjv.dsalgjavamg.ch03fundamental.p1cipher;

/**
 * Class for doing encryption ad decryption using the Caesar Cipher.
 */
public class CaesarCipher implements Cipher {
    private static final int ALPHABET_LENGHT = 26;
    
    protected char[] encoder = new char[ALPHABET_LENGHT];
    protected char[] decoder = new char[ALPHABET_LENGHT];
    
    public CaesarCipher(int rotation) {
        for (int k = 0; k < ALPHABET_LENGHT; k++) {
            encoder[k] = (char) ('A' + (k + rotation) % ALPHABET_LENGHT);
            decoder[k] = (char) ('A' + (k - rotation + ALPHABET_LENGHT) % ALPHABET_LENGHT);
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
                msg[i] = code[msg[i] - 'A'];
            }
        }
        return new String(msg);
    }

    public static void main(String[] args) {
        CaesarCipher cipher = new CaesarCipher(3);
        System.out.println("Encription code: " + new String(cipher.encoder));
        System.out.println("Decription code: " + new String(cipher.decoder));
        String message = "THE EAGLE IS IN PLAY; MEET AT JOE'S";
        String coded = cipher.encrypt(message);
        System.out.println("Secret : " + coded);
        String answer = cipher.decrypt(coded);
        System.out.println("Message: " + answer);
    }


}
