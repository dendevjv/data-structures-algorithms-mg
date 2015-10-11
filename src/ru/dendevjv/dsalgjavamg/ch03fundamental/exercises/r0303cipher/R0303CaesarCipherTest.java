package ru.dendevjv.dsalgjavamg.ch03fundamental.exercises.r0303cipher;

import static org.junit.Assert.*;

import org.junit.Test;

public class R0303CaesarCipherTest {

    @Test
    public void testEncryptEn() {
        R0303CaesarCipher c = new R0303CaesarCipher(R0303CaesarCipher.ENGLISH_ALPHABET, 1);
        String msg = "HELLO";
        String enc = c.encrypt(msg);
        assertEquals("IFMMP", enc);
    }
    
    @Test
    public void testEncryptRu() {
        R0303CaesarCipher c = new R0303CaesarCipher(R0303CaesarCipher.RUSSIAN_ALPHABET, 1);
        String msg = "ÏÐÈÂÅÒ";
        String enc = c.encrypt(msg);
        assertEquals("ÐÑÉÃ¨Ó", enc);
    }

    @Test
    public void testDecryptEn() {
        R0303CaesarCipher c = new R0303CaesarCipher(R0303CaesarCipher.ENGLISH_ALPHABET, 2);
        String enc = "JGNNQ";
        String msg = c.decrypt(enc);
        assertEquals("HELLO", msg);
    }
    
    @Test
    public void testDecryptRu() {
        R0303CaesarCipher c = new R0303CaesarCipher(R0303CaesarCipher.RUSSIAN_ALPHABET, 2);
        String enc = "ÑÒÊÄÆÔ";
        String msg = c.decrypt(enc);
        assertEquals("ÏÐÈÂÅÒ", msg);
    }

}
