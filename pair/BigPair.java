package pair;
import java.math.BigInteger;

public class BigPair {
    
    private BigInteger first;
    private BigInteger second;

    public BigPair() {
        this.first = new BigInteger("0");
        this.second = new BigInteger("0");
    };

    public BigPair(BigInteger first, BigInteger second) {
        this.first = first;
        this.second = second;
    }

    public void setFirst(BigInteger first) {
        this.first = first;
    }

    public void setFirst(String first) {
        this.first = BigInteger.valueOf(Integer.parseInt(first));
    }

    public void setFirst(int first) {
        this.first = BigInteger.valueOf(first);
    }

    public void setSecond(BigInteger second) {
        this.second = second;
    }

    public void setSecond(String second) {
        this.first = BigInteger.valueOf(Integer.parseInt(second));
    }

    public void setSecond(int second) {
        this.first = BigInteger.valueOf(second);
    }

    public BigInteger getFirst() {
        return this.first;
    }

    public BigInteger getSecond() {
        return this.second;
    }
}
