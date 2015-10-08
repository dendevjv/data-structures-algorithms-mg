package ru.dendevjv.dsalgjavamg.ch03fundamental;

public interface Cipher {
    String encrypt(String message);
    String decrypt(String secret);
}
