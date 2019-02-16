public class GenesisBlock {
  String transactionAmount = ""; 
  String sender = ""; 
  String receiver=  ""; 
  
  public GenesisBlock (String transactionAmount , String sender, String receiver ) {
    this.transactionAmount = transactionAmount; 
    this.sender = sender; 
    this.receiver = receiver; 
  }
  public String getSignature (String senderPrivateKey){
    String signature = "";
    String data = ""; 
    data += transactionAmount ; 
    data += sender;
    data += receiver;
    
    String hash =generateHash(data); 
    //for (int i =0; i < hash.length ();i++){
    //}
    System.out.println (  data +" = " +hash); 
    return signature; 
  }
  
  public String generateHash (String data){
    int hash = 0; 
    int g =157; // nice prime numebr
    for (int i = 0; i < data.length(); i ++){
      hash = (g * hash) + data.charAt(i); 
    }
    if (hash < 0) { // if our hash is negative 
      hash *= -1; 
    }
    String strHash = Integer.toString(hash) ;
    return strHash; 
  }  
}