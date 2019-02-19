import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import javax.crypto.Cipher;

public class Cryptography {
  public byte [] encryptMessage (PrivateKey sk, String message){
    byte [] encryptedMessage = "".getBytes () ; 
    try {
      Cipher cipher = Cipher.getInstance("RSA");  
      cipher.init(Cipher.ENCRYPT_MODE, sk);  
      encryptedMessage = cipher.doFinal(message.getBytes());
    }catch (Exception e){
    }
    return encryptedMessage; 
  }
  public byte [] decryptMessage (PublicKey publicKey, byte [] messageEncrypted){
    byte [] decryptedMessage = "".getBytes () ;
    try {
      Cipher cipher = Cipher.getInstance("RSA");  
      cipher.init(Cipher.DECRYPT_MODE, publicKey);
      decryptedMessage = cipher.doFinal(messageEncrypted); 
    }catch (Exception e){
    }
    return decryptedMessage;
  }
}