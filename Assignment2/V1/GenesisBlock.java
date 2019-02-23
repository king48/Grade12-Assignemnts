
/* 
  Bill Bai, Juan-Diego Castano 
  Ms. Kresteva
  11/02/2019
  Class is the Blueprint for a block on the blockchain. It is the first block in the chain specifically called the Genesis Block. 
    It is the super class for the blocks and everything done with subsequent blocks will be extensions of the Genesis Block class. 
*/
import java.security.PrivateKey; // The java.security import allows for the use of PrivateKey as a variable. 
import java.security.PublicKey; // The java.security import allows for the use of PublicKey as a variable.  

public class GenesisBlock {
  Cryptography crypto = new Cryptography(); // calls on the Cryptography class
  public double transactionAmount = 0;
  public PublicKey senderRawKey;
  public PublicKey receiverRawKey;
  public String senderKey = "";
  public String receiverKey = "";
  public int transactionID = 0;
  public int blockNumber = 1;

  /**
   * Class constructor
   *
   * @param transactionID  The transaction ID
   * @param senderRawKey   The sender's raw public key
   * @param receiverRawKey The receiver's raw public key
   * @param senderKey      The sender key
   * @param receiverKey    The receiver key
   */
  public GenesisBlock(int transactionID, PublicKey senderRawKey, PublicKey receiverRawKey, String senderKey,
      String receiverKey) {
    transactionAmount = 50;
    this.transactionID = transactionID;
    this.senderRawKey = senderRawKey;
    this.receiverRawKey = receiverRawKey;
    this.senderKey = senderKey;
    this.receiverKey = receiverKey;
  }

  /**
   * Class constructor.
   *
   * @param transactionID     The transaction ID
   * @param transactionAmount The transaction amount
   * @param senderRawKey      The sender's raw public key
   * @param receiverRawKey    The receiver's raw public key
   * @param senderKey         The sender key
   * @param receiverKey       The receiver key
   */
  public GenesisBlock(int transactionID, double transactionAmount, PublicKey senderRawKey, PublicKey receiverRawKey,
      String senderKey, String receiverKey) {
    this.transactionID = transactionID;
    this.transactionAmount = transactionAmount;
    this.senderRawKey = senderRawKey;
    this.receiverRawKey = receiverRawKey;
    this.senderKey = senderKey;
    this.receiverKey = receiverKey;
  }

  /**
   * This method brings together all of the data for the transaction, and returns
   * it in the form of a String.
   *
   * @return The compiled data, as a String.
   */
  public String data() {
    String data = ""; // brings together all the data from the transaction
    data += blockNumber;
    data += transactionID;
    data += transactionAmount;
    data += senderKey;
    data += receiverKey;
    return data;
  }

  /**
   * This method adds extra data, to the original data, and returns it.
   *
   * @param extraData A String containing the extra data to be added.
   * @return A String containing the default data and extra data.
   */
  public String data(String extraData) {
    String data = ""; // brings together all the data from the transaction PLUS the digital Signature
    data += data(); // calls the previous data
    data += extraData; // adds extra data
    return data;
  }

  /**
   * Adds extra data, in the form of a byte array
   *
   * @param extraData An array of bytes, containing the extra data to be added
   * @return A String containing the default data, and extra data.
   */
  public String data(byte[] extraData) {
    String data = ""; // brings together all the data from the transaction PLUS the digital Signature
    data += data(); // calls the previous data
    data += extraData; // adds extra data
    return data;
  }

  /**
   * Encrypts data, given the data, and the sender's private key.
   *
   * @param data             The data to be encrypted.
   * @param senderPrivateKey The sender's private key.
   * @return The encrypted data.
   */
  public byte[] encrypt(String data, PrivateKey senderPrivateKey) {
    byte[] encryptedMessage = crypto.encryptMessage(senderPrivateKey, data);
    System.out.println("This simple hash ^ Encrypted with the senders private key is " + encryptedMessage
        + " -- this is now the senders signature.");
    return encryptedMessage; // hash shouldnt be the hash tho
  }

  /**
   * Decrypts encrypted data.
   *
   * @param signature Sender's digital signature.
   * @return Decrypted encrypted data.
   */
  public byte[] decrypt(byte[] signature) {
    byte[] decryptedMessageBytes = crypto.decryptMessage(senderRawKey, signature);
    return decryptedMessageBytes;
  }

  /**
   * Creates and returns a digital signature.
   *
   * @param senderPrivateKey The sender's private key.
   * @return A digital signature, in the form of a byte array.
   */
  public byte[] getSignature(PrivateKey senderPrivateKey) {
    String hash = generateHash(data()); // hash all the data from the data method above ^
    System.out.println("Hash of simple data without signature :" + hash);
    byte[] byteSignature = encrypt(hash, senderPrivateKey); // takes this hashed data and encrypts it to get the digital
    return byteSignature;
  }

  /**
   * This method returns a boolean, containing a verification to send
   * transactions.
   *
   * @param sign The signature.
   * @return A boolean, contianing the verification.
   */
  public boolean getVerification(byte[] sign) {
    boolean verify = false;
    String hash = generateHash(data());
    String strDecrypt = new String(decrypt(sign));
    for (int a = 0; a < 64; a++) {
      if (hash.charAt(a) == strDecrypt.charAt(a) && a == 63) {
        verify = true;
      }
    }
    System.out.print(sign + " is decrypted using the senders private key, and you get : " + decrypt(sign));
    System.out.println(" OR in string : " + strDecrypt + " Which should be the hash of the data!");
    System.out.println("Is " + hash + " = " + strDecrypt + " ??");
    System.out.println("This transaction is " + verify);
    return verify;
  }

  /**
   * This method will mine the block, and thus, proves that the miner has actually
   * done work on the block.
   *
   * @param signature The sender's digital signature, in a String.
   * @return A new hash, containing the verification.
   */
  public String proofOfWork(byte[] signature) {
    boolean hashNotFound = true;
    String newHash = "";
    int nonce = 0;
    String data = "";
    data += data(signature);
    System.out.println("This is hash DATA with signature (No nonce) " + data);
    while (hashNotFound) {
      data += nonce;
      newHash = generateHash(data);
      if (newHash.charAt(0) == '0' && newHash.charAt(1) == 'd' && newHash.charAt(2) == 'c') {
        System.out.println("Nonce is " + nonce);
        System.out.println("your new hash with nonce and signature is " + newHash);
        hashNotFound = false;
      } else {
        if (nonce < 10) // eliminates the nonce ending
          data = data.substring(0, data.length() - 1);
        else if (nonce >= 10 && nonce < 100)
          data = data.substring(0, data.length() - 2);
        else if (nonce > 99 && nonce <= 999)
          data = data.substring(0, data.length() - 3);
        else
          data = data.substring(0, data.length() - 4);
        nonce++; // changes the nonce
      }
    }
    return newHash;
  }

  /**
   * Hashes a given String.
   *
   * @param data The data to be hashed.
   * @return The hashed version of the String.
   */
  public String generateHash(String data) {
    GeneratingHash genHash = new GeneratingHash(data);
    String hash = genHash.getHash();
    return hash;
  }

  /**
   * This method generates a block, on the blockchain.
   *
   * @param senderRawPrivateKey A String containing the sender's private key.
   * @return A String containing the block hash. Will return an error message, if
   *         transaction goes wrong.
   */
  public String generateBlock(PrivateKey senderRawPrivateKey) {
    byte[] signature = getSignature(senderRawPrivateKey);
    boolean varifySignature = getVerification(signature);
    if (varifySignature == true) {
      String blockHash = proofOfWork(signature);
      System.out.println("After the block is mined the hash is " + blockHash);
      return blockHash;
    } else {
      return "This is not a valid transaction";
    }
  }
}