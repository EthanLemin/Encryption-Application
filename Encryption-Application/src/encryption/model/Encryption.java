package encryption.model;

import java.security.*;
import java.security.NoSuchAlgorithmException;

public class Encryption implements IEncryption {

    @Override
    public String hashing(String mdType, String unhashed, int passover) {
        try {
            MessageDigest md = MessageDigest.getInstance(mdType);
            StringBuilder sb = new StringBuilder();
            byte[] bin = unhashed.getBytes();
            byte[] hash = null;
            for (int i = 0; i < passover; i++) {
                md.reset();
                if(i == 0) {
                    hash = md.digest(bin);
                } else {
                    hash = md.digest(hash);
                }
            }
            for (byte b : hash) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException nsa) {
            nsa.printStackTrace();
            return "";
        }
    }
}
