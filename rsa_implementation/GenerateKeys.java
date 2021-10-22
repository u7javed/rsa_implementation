package rsa_implementation;

import java.math.BigInteger;

import pair.BigPair;

class GenerateKeys {

    public static final int RADIX = 16;
    public static void main(String[] args) {
        RSAGenerator generator = new RSAGenerator();
        generator.generatePublicPrivateKeyPair();
        BigPair publicKeyPair = generator.getPublicKey();
        BigInteger privateKey = generator.getPrivateKey();
        KeyHandler keyHandler = new KeyHandler(publicKeyPair, privateKey);
        String pubKey = keyHandler.getPublicKey(32);
        String prvKey = keyHandler.getPrivateKey(32);
        System.out.println(pubKey);
        System.out.println(prvKey);
    }
}