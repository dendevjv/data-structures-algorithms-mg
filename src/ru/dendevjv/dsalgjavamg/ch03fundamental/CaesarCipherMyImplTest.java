package ru.dendevjv.dsalgjavamg.ch03fundamental;

import static org.junit.Assert.*;

import org.junit.Test;

public class CaesarCipherMyImplTest {

    @Test
    public void testEncrypt() {
        CaesarCipherMyImpl cc = new CaesarCipherMyImpl(1);
        String msg = "HELLO";
        String enc = cc.encrypt(msg);
        assertEquals("IFMMP", enc);
    }
    
    @Test
    public void testEncryptLong() {              
        CaesarCipherMyImpl cc = new CaesarCipherMyImpl(25);                                
        String msg = "HELLO";
        String enc = cc.encrypt(msg);
        assertEquals("GDKKN", enc);
    }

    @Test
    public void testDecrypt() {
        CaesarCipherMyImpl cc = new CaesarCipherMyImpl(2);
        String enc = "JGNNQ";
        String msg = cc.decrypt(enc);
        assertEquals("HELLO", msg);
    }

}
