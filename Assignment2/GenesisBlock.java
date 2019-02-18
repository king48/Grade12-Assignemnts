/* 
 
 
*/

public class GenesisBlock {
   public String transactionAmount = ""; 
   public String sender = ""; 
   public String receiver=  ""; 
   public  int transactionID = 0; 
   public int blockNumber = 1; 
  
  public GenesisBlock (){
    
  }
  public GenesisBlock (int transactionID, String transactionAmount , String sender, String receiver ) {
    this.transactionID = transactionID;
    this.transactionAmount = transactionAmount; 
    this.sender = sender; 
    this.receiver = receiver;
  }
  public String data (){
    String data = ""; // brings together all the data from the transaction 
    data += blockNumber; 
    data += transactionID; 
    data += transactionAmount ; 
    data += sender;
    data += receiver;
    return data; 
  }
  public String data  (String extraData){
    String data = ""; // brings together all the data from the transaction PLUS the digital Signature 
    data += data(); // calls the previous data 
    data += extraData; // adds extra data
    return data; 
  }
  public String encrypt (String data, String senderPrivateKey){
    // goes through a function that I cannot figure out
    System.out.println ("This is the digital Signature (Encryption) " + data); 
    return data; // hash shouldnt be the hash tho
  }
  public String decrypt (){
    // goes through a decryption function
    // With sender
    return generateHash (data()); // should be this 
  }
  public String getSignature (String senderPrivateKey){
    String signature = "";
    String hash = generateHash(data ()); // hash all the data from the data method above ^  
    System.out.println ("Hash of simple data without signature :" + hash);
    signature = encrypt (hash, senderPrivateKey); // takes this hashed data and encrypts it to get the digital signature 
    System.out.println ("Your signature is " + signature); 
    return signature; 
  }
  
  public boolean getVerification () { 
    boolean verify = false; 
    // need the data (transaction amount etc), signature and public key
    String hash = generateHash (data ()); 
    if (hash == decrypt ())   
      verify = true; 
    
    return verify; 
  }
  
  public String proofOfWork (String signature) {
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
    
    public String generateBlock (String senderPrivateKey) {      
      String signature = getSignature (senderPrivateKey); 
      boolean varifySignature = getVerification (); 
      //if (varifySignature == true){
      String blockHash =  proofOfWork (signature);
      System.out.println ("After the block is mined the hash is " + blockHash);
      return blockHash;  
     // }
     // else { 
     //   return "This is not a valid transaction"; 
     // }
    }
      
}