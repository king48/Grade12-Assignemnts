/* 
 
 
*/

public class GenesisBlock {
   private String transactionAmount = ""; 
   private String sender = ""; 
   private String receiver=  ""; 
   private int transactionID = 0; 
   private int blockNumber = 1; 
  
  public GenesisBlock (){
    
  }
  public GenesisBlock (int transactionID, String transactionAmount , String sender, String receiver ) {
    this.transactionID = transactionID;
    this.transactionAmount = transactionAmount; 
    this.sender = sender; 
    this.receiver = receiver;
  }
   
  public String getSignature (String senderPrivateKey){
    String signature = "jaun";
    String data = ""; 
    data += transactionID; 
    data += transactionAmount ; 
    data += sender;
    data += receiver;
    
    String hash = generateHash(data); 

    System.out.println (data +" = " +hash);
    
    return signature; 
  }
  /*
  public boolean getVerification () { 
    boolean verify; 
    // need the data (transaction amount etc), signature and public key
    return verify; 
  }
  */
  public String proofOfWork (String signature) {
    boolean hashNotFound = true;
    String newHash = ""; 
    int nonce = 0 ; 
    String data = ""; 
    data += blockNumber;  
    data += transactionID;  
    data += transactionAmount; 
    data += sender;
    data += receiver;
    data += signature; 
    System.out.println (data); 
   // for (int i = 0; i < 50; i ++){
    while (hashNotFound){
      data += nonce;  
      newHash = generateHash (data);
      if (newHash.charAt (0) == '0'){
        System.out.println ("Nonce is "+ nonce + " your new hash is " + newHash); 
        hashNotFound = false; 
      }
      else {
        if (nonce < 10) 
          data = data.substring (0, data.length ()-1); 
        else if (nonce >= 10 && nonce < 100)
          data = data.substring (0, data.length () - 2);
        else if (nonce > 99 && nonce <= 999)
          data = data.substring (0, data.length () - 3);
        else 
          data = data.substring (0, data.length ()- 4); 
        nonce ++;
      }
    }
    return newHash; 
  }
  //This method 
    public String generateHash (String data){
      GeneratingHash gHash = new GeneratingHash (data); 
      String hash = gHash.message(); 
      return hash;
    }
    
    public String generateBlock (String senderPrivateKey) {      
      String signature = getSignature (senderPrivateKey); 
      //boolean varifySignature = getVerification (); 
      String blockHash =  proofOfWork (signature);
      System.out.println ("Adter the block is mined the hash is " + blockHash); 
      return blockHash; 
    }
      
}