package rsa_implementation;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import asn_1.ASN_1;
import pair.BigPair;

public class KeyHandler {
    private ASN_1 publicKey;
    private BigInteger privateKey;
    private static final int STRING_LIMIT = 64;

    public KeyHandler(BigPair publicKey, BigInteger privateKey) {
        this.publicKey = new ASN_1(publicKey.getFirst(), publicKey.getSecond());
        this.privateKey = privateKey;
    }

    public String getPublicKey(int radix) {
        String pubKey = this.publicKey.publicKey(radix);
        return formatOutput(pubKey, true);
    }

    public String getPrivateKey(int radix) {
        String privateKey = this.privateKey.toString(radix);
        return formatOutput(privateKey, false); 
    }

    private String formatKey(String keyString) {
        List<String> stringList = new ArrayList<>();
        int leftIndex = 0;
        int rightIndex = STRING_LIMIT;
        if(rightIndex > keyString.length()) {
            return keyString;
        }
        while(rightIndex <= keyString.length()) {
            stringList.add(keyString.substring(leftIndex, rightIndex));
            leftIndex += STRING_LIMIT;
            rightIndex += STRING_LIMIT;
        }
        if(leftIndex <= keyString.length()) {
            stringList.add(keyString.substring(leftIndex, keyString.length()));
        }
        String formattedKey = "";
        for(int i = 0; i < stringList.size(); i++) {
            formattedKey = formattedKey + stringList.get(i) + "\n";
        }
        return formattedKey;
    }

    private String formatOutput(String key, Boolean isPublicKey) {
        String top = isPublicKey ? "-----BEGIN PUBLIC KEY-----" : "-----BEGIN PRIVATE KEY-----";
        String bottom = isPublicKey ? "-----END PUBLIC KEY----" : "-----END PRIVATE KEY----";
        String content = formatKey(key);
        String formmatedOutputed = top + "\n" + content.substring(0, content.length()-1) + "\n" + bottom + "\n";
        return formmatedOutputed;
    }
}
