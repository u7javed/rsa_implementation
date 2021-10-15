package utils;

import java.math.BigInteger;
import java.util.Random;

public class Utils {

    private Random rnd;

    public Utils(Random rnd) {
        this.rnd = rnd;
    }

    public Utils() {
        this.rnd = new Random();
    }

    public BigInteger randomPrimeGenerator(int bitSize) {
        return new BigInteger(bitSize, 128, this.rnd);
    }

    public BigInteger lcm(BigInteger first, BigInteger second) {
        BigInteger gcd = first.gcd(second);
        BigInteger product = first.multiply(second).abs();
        return product.divide(gcd);
    }
}
