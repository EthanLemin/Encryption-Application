package encryption.model;

import java.security.*;
import java.security.NoSuchAlgorithmException;

public class Encryption implements IEncryption {

    @Override
    public String hashing(String mdType, String unhashed, int passover) {
        try {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < passover; i++) {
                MessageDigest md = MessageDigest.getInstance(mdType);
                byte[] hash = unhashed.getBytes();

                md.reset();
                hash = md.digest(hash);

                sb.setLength(0);
                for (byte b : hash) {
                    sb.append(String.format("%02x", b));
                }
                unhashed = sb.toString();
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException nsa) {
            nsa.printStackTrace();
            return "";
        }
    }
}