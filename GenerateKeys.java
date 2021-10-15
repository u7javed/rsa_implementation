import java.math.BigInteger;

import utils.*;

public class GenerateKeys {
    
    public static void main(String[] args) {
        Utils utility = new Utils();
        BigInteger test = utility.randomPrimeGenerator(2048);
        System.out.println(test);
    }
}
