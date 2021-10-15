package rsa_implementation;
import java.math.BigInteger;

import pair.BigPair;
import utils.Utils;

public class RSAGenerator {

    Utils utils;
    private static final int BIT_SIZE = 2048;
    private static final int PUBLIC_KEY_EXPONENT = 65537;

    public RSAGenerator(Utils utils) {
        this.utils = utils;
    }

    public RSAGenerator() {
        this.utils = new Utils();
    }

    private BigPair generatePrimes() {
        BigInteger primeOne = this.utils.randomPrimeGenerator(BIT_SIZE);
        BigInteger primeTwo = this.utils.randomPrimeGenerator(BIT_SIZE);
        return new BigPair(primeOne, primeTwo);
    }

    private BigInteger generatePrimeModulus(BigInteger primeOne, BigInteger primeTwo) {
        return primeOne.multiply(primeTwo);
    }

    private BigInteger computeCTF(BigInteger primeOne, BigInteger primeTwo) {
        return this.utils.lcm(primeOne.subtract(BigInteger.valueOf(1)), primeTwo.subtract(BigInteger.valueOf(1)));
    }
}