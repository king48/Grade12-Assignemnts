public class GenesisBlock {
  String transactionAmount = ""; 
  String sender = ""; 
  String receiver=  ""; 
  int transactionID = 0; 
  
  public GenesisBlock (int transactionID, String transactionAmount , String sender, String receiver ) {
    this.transactionAmount = transactionAmount; 
    this.sender = sender; 
    this.receiver = receiver;
    this.transactionID = transactionID;
  }
  
  public String performAddition (char one, char two){
    if (one == 'A' || two == 'A'){
      
    }
    else if (one == 'B' || two == 'B'){
    }
    else if (one == 'C' || two == 'C'){
    }
    else if (one == 'D' || two == 'D'){
    }
    else if (one == 'E' || two == 'E'){
    }
    else if (one == 'F' || two == 'F'){
    }
   
      return "hi";
  }
  
  public String getSignature (String senderPrivateKey){
    String signature = "";
    String data = ""; 
    data += transactionID; 
    data += transactionAmount ; 
    data += sender;
    data += receiver;
    
    String hash =generateHash(data); 
    for (int i = 0; i < 64; i ++){
      char one = hash.charAt (i); 
      char two = senderPrivateKey.charAt(i); 
      signature += performAddition (one, two); 
    }
    System.out.println (data +" = " +hash); 
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
    return "3B6B18EF07306B769B763892019BE081A0F5A62D0D05E919B48A2DF7DED6068D"; 
  }  
}