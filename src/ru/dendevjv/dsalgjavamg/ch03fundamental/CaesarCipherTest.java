package ru.dendevjv.dsalgjavamg.ch03fundamental;

import static org.junit.Assert.*;

import org.junit.Test;

public class CaesarCipherTest {

    @Test
    public void testEncrypt() {
        CaesarCipher c = new CaesarCipher(1);
        String msg = "HELLO";
        String enc = c.encrypt(msg);
        assertEquals("IFMMP", enc);
    }

    @Test
    public void testDecrypt() {
        CaesarCipher c = new CaesarCipher(2);
        String enc = "JGNNQ";
        String msg = c.decrypt(enc);
        assertEquals("HELLO", msg);
    }

}
