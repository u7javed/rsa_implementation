package rsa_implementation;
import java.math.BigInteger;

import pair.BigPair;
import utils.Utils;

public class RSAGenerator {

    Utils utils;
    private static final int BIT_SIZE = 2048;
    private static final int PUBLIC_KEY_EXPONENT = 65537;
    private BigPair publicKey;
    private BigInteger privateKey;

    public RSAGenerator(Utils utils) {
        this.utils = utils;
        publicKey = null;
        privateKey = null;
    }

    public RSAGenerator() {
        this.utils = new Utils();
        publicKey = null;
        privateKey = null;
    }

    public void generatePublicPrivateKeyPair() {
        BigPair randomPrimes = generatePrimes();
        BigInteger primeModulus = generatePrimeModulus(randomPrimes);
        BigInteger ctf = computeCTF(randomPrimes);
        BigInteger exponent = BigInteger.valueOf(PUBLIC_KEY_EXPONENT);
        BigInteger modInverse = computeModInverse(exponent, ctf);
        this.publicKey = new BigPair(primeModulus, exponent);
        this.privateKey = modInverse;
    }

    private BigPair generatePrimes() {
        BigInteger primeOne = this.utils.randomPrimeGenerator(BIT_SIZE);
        BigInteger primeTwo = this.utils.randomPrimeGenerator(BIT_SIZE);
        return new BigPair(primeOne, primeTwo);
    }

    private BigInteger generatePrimeModulus(BigPair primes) {
        return primes.getFirst().multiply(primes.getSecond());
    }

    private BigInteger computeCTF(BigPair primes) {
        return this.utils.lcm(primes.getFirst().subtract(BigInteger.valueOf(1)), primes.getSecond().subtract(BigInteger.valueOf(1)));
    }
    
    private BigInteger computeModInverse(BigInteger e, BigInteger modulus) {
        return this.utils.modularInverse(e, modulus);
    }

    public BigPair getPublicKey() {
        if(this.publicKey == null) {
            throw new NullPointerException("The Public Key has not been generated. Please run generate generatePublicPrivateKeyPair() before calling this function.");
        }
        return this.publicKey;
    }

    public BigInteger getPrivateKey() {
        if(this.privateKey == null) {
            throw new NullPointerException("The Private Key has not been generated. Please run generate generatePublicPrivateKeyPair() before calling this function.");
        }
        return this.privateKey;
    }
}