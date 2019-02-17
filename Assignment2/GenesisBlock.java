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
    boolean notFound = true;
    String thisNewHash = ""; 
    int nonce = 0 ; 
    String data = ""; 
    data += blockNumber;  
    data += transactionID;  
    data += transactionAmount; 
    data += sender;
    data += receiver;
    data += signature; 
    thisNewHash = generateHash (data); 
   
    return thisNewHash; 
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
      return blockHash; 
    }
      
}