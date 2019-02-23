
/* 
  Bill Bai, Juan-Diego Castano 
  Ms. Kresteva
  11/02/2019
  This Class will encrypt and or decrypt information. It will return the message in bytes 
    to be used and converted in other classes 
  Retrieved information for imports from: 
    http://tutorials.jenkov.com/java-cryptography/index.html
*/
import java.security.PrivateKey;
import java.security.PublicKey;
import javax.crypto.Cipher;

public class Cryptography {

  /**
   * Encrypts a message.
   *
   * @param sk      The sender's private key.
   * @param message The message to be encrypted.
   * @return The encrypted message.
   */
  public byte[] encryptMessage(PrivateKey sk, String message) {
    byte[] encryptedMessage = "".getBytes();
    try {
      Cipher cipher = Cipher.getInstance("RSA");
      cipher.init(Cipher.ENCRYPT_MODE, sk);
      encryptedMessage = cipher.doFinal(message.getBytes());
    } catch (Exception e) {
    }
    return encryptedMessage;
  }

  /**
   * This method decrypts an encrypted method.
   *
   * @param publicKey        The public key.
   * @param messageEncrypted The encrypted message.
   * @return The decrypted message.
   */
  public byte[] decryptMessage(PublicKey publicKey, byte[] messageEncrypted) {
    byte[] decryptedMessage = "".getBytes();
    try {
      Cipher cipher = Cipher.getInstance("RSA");
      cipher.init(Cipher.DECRYPT_MODE, publicKey);
      decryptedMessage = cipher.doFinal(messageEncrypted);
    } catch (Exception e) {
    }
    return decryptedMessage;
  }
}