public class GenesisBlock {
  String transactionAmount = ""; 
  String sender = ""; 
  String receiver=  ""; 
  
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

    String hash = ""; 
    int g =7; 
    hash += transactionAmount; 
    hash += sender; 
    hash += receiver;
    int data = 0; 
     for (int i = 0; i < hash.length(); i ++) 
   {
     data = (g * data) + hash.charAt(i); 
    // System.out.println (hash);
   }
  }
  
}