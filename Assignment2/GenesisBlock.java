/* 
 
 
*/
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;

public class GenesisBlock {
  
   public double transactionAmount = 0; 
   public PublicKey senderRawKey; 
   public PublicKey receiverRawKey; 
   public String senderKey = ""; 
   public String receiverKey = ""; 
   public  int transactionID = 0; 
   public int blockNumber = 1; 
  Cryptography crypto = new Cryptography ();
  public GenesisBlock (){
    
  }
  public GenesisBlock (int transactionID, double transactionAmount, PublicKey senderRawKey, PublicKey receiverRawKey, String senderKey, String receiverKey){
    this.transactionID = transactionID;
    this.transactionAmount = transactionAmount; 
    this.senderRawKey = senderRawKey; 
    this.receiverRawKey = receiverRawKey;
    this.senderKey = senderKey; 
    this.receiverKey = receiverKey; 
  }
  public String data (){
    String data = ""; // brings together all the data from the transaction 
    data += blockNumber; 
    data += transactionID; 
    data += transactionAmount ; 
    data += senderKey;
    data += receiverKey;
    return data; 
  }
  public String data  (String extraData){
    String data = ""; // brings together all the data from the transaction PLUS the digital Signature 
    data += data(); // calls the previous data 
    data += extraData; // adds extra data
    return data; 
  }
  public String data  (byte [] extraData){
    String data = ""; // brings together all the data from the transaction PLUS the digital Signature 
    data += data(); // calls the previous data 
    data += extraData; // adds extra data
    return data; 
  }
  public byte [] encrypt (String data, PrivateKey senderPrivateKey){
     // returned in bytes so get it into String 
    //System.out.println ("This is the digital Signature (Encryption) " + encryptedMessage); 
    byte [] encryptedMessage = crypto.encryptMessage (senderPrivateKey, data);
    System.out.println ("This simple hash ^ Encrypted with the senders private key is " + encryptedMessage + " -- this is now the senders signature." ); 
    System.out.println ( " " ); 
    return encryptedMessage; // hash shouldnt be the hash tho
  }
  public byte [] decrypt (byte [] signature){
    // goes through a decryption function
    // With sender
    byte [] decryptedMessageBytes = crypto.decryptMessage(senderRawKey, signature); 
    return decryptedMessageBytes;
  }
  public byte [] getSignature (PrivateKey senderPrivateKey){
    String hash = generateHash(data ()); // hash all the data from the data method above ^  
    System.out.println ("Hash of simple data without signature :" + hash);
    byte [] byteSignature = encrypt (hash, senderPrivateKey); // takes this hashed data and encrypts it to get the digital signature 
    return byteSignature; 
  }
  
  public boolean getVerification (byte [] sign) { 
    boolean verify = false; 
    // need the data (transaction amount etc), signature and public key
    String hash = generateHash (data ());
    System.out.print (sign +" is decrypted using the senders private key, and you get : "+ decrypt (sign)); 
    String strDecrypt = new String (decrypt (sign)); 
    System.out.println (" OR in string : "+ strDecrypt + " Which should be the hash of the data!"); 

    System.out.println ("Is " + hash + " = "+ strDecrypt + " ??"); 
    for (int a = 0; a < 64; a ++){
      if (hash.charAt (a) == strDecrypt.charAt (a) && a == 63 ) {  
        verify = true; 
      }
    }
    System.out.println ("This transaction is " + verify); 
    return verify; 
  }
  
  public String proofOfWork (byte [] signature) {
    boolean hashNotFound = true;
    String newHash = ""; 
    int nonce = 0 ; 
    String data = "";
    data += data (signature);
    System.out.println ("This is hash DATA with signature (No nonce) " + data); 
    
    while (hashNotFound){
      data += nonce;  
      newHash = generateHash (data);
      if (newHash.charAt (0) == '0' && newHash.charAt (1) == 'd' &&  newHash.charAt (2) == 'c' ){
        System.out.println ("Nonce is "+ nonce); 
        System.out.println ("your new hash with nonce and signature is " + newHash); 
        hashNotFound = false; 
      }
      else {
        if (nonce < 10) // eliminates the nonce ending
          data = data.substring (0, data.length ()-1); 
        else if (nonce >= 10 && nonce < 100)
          data = data.substring (0, data.length () - 2);
        else if (nonce > 99 && nonce <= 999)
          data = data.substring (0, data.length () - 3);
        else 
          data = data.substring (0, data.length ()- 4); 
        nonce ++; // changes the nonce
      }
    }
    return newHash; 
  }

  public String generateHash (String data){
    GeneratingHash genHash = new GeneratingHash (data); 
    String hash = genHash.getHash(); 
    return hash;
  }
  
  public String generateBlock (PrivateKey senderRawPrivateKey) { 
    byte [] signature = getSignature (senderRawPrivateKey); 
    boolean varifySignature = getVerification (signature); 
    if (varifySignature == true){
      String blockHash =  proofOfWork (signature);
      System.out.println ("After the block is mined the hash is " + blockHash);
      return blockHash;  
    }
    else { 
      return "This is not a valid transaction"; 
    }
  }      
}