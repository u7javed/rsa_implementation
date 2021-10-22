package asn_1;

import java.math.BigInteger;
import java.security.InvalidParameterException;
import java.util.Arrays;

public class ASN_1 {
    private BigInteger modulus;
    private BigInteger publicExponent;
    private static final int RADIX_LIST[] = {2, 16, 32, 64};

    public ASN_1(BigInteger modulus, BigInteger publicExponent) {
        this.modulus = modulus;
        this.publicExponent = publicExponent;
    }

    public String publicKey(int radix) {
        String mod = modulus.toString(radix);
        String exp = publicExponent.toString(radix);
        return mod + exp;
    }
}
