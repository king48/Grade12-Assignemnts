
/* 
  Bill Bai, Juan-Diego Castano 
  Ms. Kresteva
  11/02/2019
  This Class will generate a unique 265 bit hash, from a ciratin string no matter the length using the SHA-256 function. 
    It will then return the hash in hexadecimal. 
  Retrieved information for imports from: 
    https://www.baeldung.com/sha-256-hashing-java
    https://docs.oracle.com/javase/8/docs/api/java/security/MessageDigest.html
    https://docs.oracle.com/javase/7/docs/api/javax/xml/bind/DatatypeConverter.html
*/

import java.security.MessageDigest;
import javax.xml.bind.DatatypeConverter;

class GeneratingHash {
  private String data = "";

  /**
   * Class constructor
   *
   * @param data The data to be hashed.
   */
  public GeneratingHash(String data) {
    this.data = data;
  }

  /**
   * Creates, and returns hash.
   *
   * @param inputBytes The input to be hashed.
   * @return A hashed version of the input.
   */
  private String getHash(byte[] inputBytes) {
    String hashValue = "";
    try {
      MessageDigest md = MessageDigest.getInstance("SHA-256");
      md.update(inputBytes);
      byte[] digestBytes = md.digest();
      hashValue = DatatypeConverter.printHexBinary(digestBytes).toLowerCase(); // converts bytes to hexadecimal
    } catch (Exception e) {
    }
    return hashValue;
  }

  /**
   * Returns the hashed version of the data entered into the constructor.
   *
   * @return A String, containing the hash.
   */
  public String getHash() {
    String hash = "";
    byte[] dataInBytes = data.getBytes();
    hash = getHash(dataInBytes);
    return hash;
  }
}
