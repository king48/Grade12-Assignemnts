public class GenesisBlock {
  String transactionAmount; 
  String sender; 
  String receiver; 
  
  public GenesisBlock (String transactionAmount , String sender, String receiver ) {
    this.transactionAmount = transactionAmount; 
    this.sender = sender; 
    this.receiver = receiver; 
  }
  public String getSignature (){
    String signature = "";
    GenerateKeys keys = new GenerateKeys (); 
    String privateKey = keys.getPrivateKey ();
    
    return signature; 
  }
  public void generateHash (){
    int nonce = 0; 
    
  }
  
}