
/* 
  Bill Bai, Juan-Diego Castano 
  Ms. Kresteva
  11/02/2019
  This Class will generate key pairs, both bublic keys and private keys. Then it will return both the byte version 
    of the private key and or the hexadecimal version/ 
  Retrieved information for imports from: 
    http://tutorials.jenkov.com/java-cryptography/index.html
    https://www.novixys.com/blog/how-to-generate-rsa-keys-java/
    https://docs.oracle.com/cd/E19693-01/819-0997/gbesy/index.html
    https://docs.oracle.com/javase/7/docs/api/javax/xml/bind/DatatypeConverter.html
*/

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import javax.xml.bind.DatatypeConverter;

public class GenKeyPairs {
  private PublicKey pubKey;
  private PrivateKey privKey;
  private byte[] publicKeyBytes;
  private byte[] privateKeyBytes;
  private String publicKeyHexa;
  private String privateKeyHexa;

  /**
   * Class constructor
   */
  public GenKeyPairs() {
    generateBothKeys();
  }

  /**
   * This method generates a public and private key using KeyPairGenerator class.
   */
  private void generateBothKeys() {
    try {
      KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
      keyPairGenerator.initialize(2048);
      KeyPair keyPair = keyPairGenerator.generateKeyPair();
      pubKey = keyPair.getPublic();
      privKey = keyPair.getPrivate();
      // Store the keys in Bytes
      publicKeyBytes = pubKey.getEncoded(); // sotres the public key (raw public key in bytes)
      privateKeyBytes = privKey.getEncoded(); // sotres the public key (raw public key in bytes)
      // Convert into String Hexadecimal
      publicKeyHexa = DatatypeConverter.printHexBinary(privateKeyBytes).toLowerCase();
      privateKeyHexa = DatatypeConverter.printHexBinary(publicKeyBytes).toLowerCase();
    } catch (Exception e) {
    }
  }

  /**
   * Returns the private key.
   *
   * @return The private key.
   */
  public PrivateKey getRawPrivateKey() {
    return privKey;
  }

  /**
   * Returns the public key.
   *
   * @return The public key.
   */
  public PublicKey getRawPublicKey() {
    return pubKey;
  }

  /**
   * Returns the private key, in hexadecimal format.
   *
   * @return The private key
   */
  public String getHexaPrivateKey() {
    return privateKeyHexa.substring(0, 63);
  }

  /**
   * Returns the public key, in hexadecimal format.
   *
   * @return The public key
   */
  public String getHexaPublicKey() {
    return publicKeyHexa.substring(0, 63);
  }
}