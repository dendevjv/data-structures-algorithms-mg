package ru.dendevjv.dsalgjavamg.ch03fundamental.p1cipher;

public interface Cipher {
    String encrypt(String message);
    String decrypt(String secret);
}
