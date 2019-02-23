
/* 
  Bill Bai, Juan-Diego Castano 
  Ms. Kresteva
  11/02/2019
  This Class extends Genesis Block, it creates the second block with different data that includes 
   the previous hash and has a proof of work function that is more difficult. 
*/

import java.security.PublicKey;

public class BlockTwo extends GenesisBlock {

  private int transactionsMade;
  private String previousHash;

  /**
   * Class constructor
   *
   * @param transactionID     The transaction ID
   * @param transactionAmount The transaction ammount
   * @param senderRawKey      The sender's public key
   * @param receiverRawKey    The receiver's public key
   * @param senderKey         The sender's ley
   * @param receiverKey       The receiver's key
   * @param previousHash      The previous hash
   */
  public BlockTwo(int transactionID, double transactionAmount, PublicKey senderRawKey, PublicKey receiverRawKey,
      String senderKey, String receiverKey, String previousHash) {
    super(transactionID, transactionAmount, senderRawKey, receiverRawKey, senderKey, receiverKey); // This calls
    transactionsMade = 0;
    this.previousHash = previousHash;
  }

  /**
   * Class constructor
   *
   * @param transactionID  The transaction ID
   * @param senderRawKey   The sender's public key
   * @param receiverRawKey The receiver's public key
   * @param senderKey      The sender's ley
   * @param receiverKey    The receiver's key
   * @param previousHash   The previous hash
   */
  public BlockTwo(int transactionID, PublicKey senderRawKey, PublicKey receiverRawKey, String senderKey,
      String receiverKey, String previousHash) {
    super(transactionID, senderRawKey, receiverRawKey, senderKey, receiverKey); // This calls superclass constructor
    transactionsMade = 0;
    this.previousHash = previousHash;
  }

  /**
   * This adds a certain amount of transactions
   *
   * @param transactionsMade Transactions made
   */
  public void addTransaction(int transactionsMade) {
    this.transactionsMade += transactionsMade;
  }

  /**
   * Returns transactionsMade
   *
   * @return An int, containing number of transactions made.
   */
  public int getTransactionsMade() {
    return transactionsMade;
  }

  /**
   * The compiled data, in a String.
   *
   * @return A String containing the compiled data.
   */
  public String data() {
    String data = "";
    data += blockNumber + 1;
    data += transactionID;
    data += transactionAmount;
    data += senderKey;
    data += receiverKey;
    data += previousHash;
    return data;
  }

  /**
   * This method returns a proof of work.
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
      if (newHash.charAt(0) == '0' && newHash.charAt(1) == 'c' && newHash.charAt(2) == 'd'
          && newHash.charAt(3) == 'f') {
        System.out.println("Nonce is " + nonce);
        System.out.println("your new hash with nonce and signature is " + newHash);
        hashNotFound = false;
      } else {
        if (nonce < 10) // eliminates the nonce ending
          data = data.substring(0, data.length() - 1);
        else if (nonce >= 10 && nonce <= 99)
          data = data.substring(0, data.length() - 2);
        else if (nonce >= 100 && nonce <= 999)
          data = data.substring(0, data.length() - 3);
        else if (nonce >= 1000 && nonce <= 9999)
          data = data.substring(0, data.length() - 4);
        else if (nonce >= 10000 && nonce <= 99999)
          data = data.substring(0, data.length() - 5);
        else
          data = data.substring(0, data.length() - 6);

        nonce++; // changes the nonce
      }
    }
    return newHash;
  }
}