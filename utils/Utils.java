package utils;

import java.math.BigInteger;
import java.util.Random;

public class Utils {

    private Random rnd;
    BigInteger ZERO;
    BigInteger ONE;

    public Utils(Random rnd) {
        this.rnd = rnd;
        this.ZERO = BigInteger.valueOf(0);
        this.ONE = BigInteger.valueOf(1);
    }

    public Utils() {
        this.rnd = new Random();
        this.ZERO = BigInteger.valueOf(0);
        this.ONE = BigInteger.valueOf(1);
    }

    public BigInteger randomPrimeGenerator(int bitSize) {
        return new BigInteger(bitSize, 128, this.rnd);
    }

    public BigInteger lcm(BigInteger first, BigInteger second) {
        BigInteger gcd = first.gcd(second);
        BigInteger product = first.multiply(second).abs();
        return product.divide(gcd);
    }

    public BigInteger modularInverse(BigInteger e, BigInteger mod) {
        BigInteger mod_prime = mod;
        BigInteger y = BigInteger.valueOf(0), d = BigInteger.valueOf(1);

        if(mod_prime.equals(ONE)) {
            return ZERO;
        }

        while(e.compareTo(ONE) == 1) {
            BigInteger quotient = e.divide(mod);
            BigInteger t = mod;

            //EED
            mod = e.mod(mod);
            e = t;
            t = y;

            BigInteger product = quotient.multiply(y);
            y = d.subtract(product);
            d = t;
        }

        if(d.compareTo(ZERO) == -1) {
            d = d.add(mod_prime);
        }
        return d;
    }
}
