import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class ShaHash {
    public static void main(String[] args) throws NoSuchAlgorithmException{
        MessageDigest sha = MessageDigest.getInstance("SHA-1");
        byte[] hash = sha.digest(args[0].getBytes());
        int topFourBits = (((int) hash[0]) >> 4) & 0xF;
        String out = Integer.toHexString(topFourBits);
        System.out.println("Checksum is : 0x" + out.toUpperCase());
    }
}
