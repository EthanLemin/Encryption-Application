package encryption.model;

public interface IEncryption {

    String hashing(String mdType, String unhashed, int passover);

}
