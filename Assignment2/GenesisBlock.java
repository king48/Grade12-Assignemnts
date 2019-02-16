public class GenesisBlock {
  String transactionAmount = ""; 
  String sender = ""; 
  String receiver=  ""; 
  int transactionID = 0; 
  int blockNumber = 1; 
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
    //for (int i = 0; i < 64; i ++){
     // char one = hash.charAt (i); 
     // char two = senderPrivateKey.charAt(i); 
    //  signature += performAddition (one, two); 
    //}
    System.out.println (data +" = " +hash); 
    return signature; 
  }
  
  public String proofOfWork () {
    boolean notFound = true;
    String thisNewHash = "dfgsdfasdasdasd fsdhjf sdkfhskdf hsdjkf sdjkh "; 
    int nonce = 0 ; 
    String data = ""; 
    data += blockNumber;  
    data += transactionID;  
    data += transactionAmount; 
    data += sender;
    data += receiver;
    
    while (true) {
      data += nonce; 
      thisNewHash = generateHash (data);
      System.out.println (thisNewHash + "nonce " + nonce);
      if (thisNewHash.charAt(0) == '0'){
        break; 
      }
      else {
      nonce ++; 
      if (nonce < 10) 
        data = data.substring(0,data.length()-1);
      else if (nonce >= 10 && nonce < 100)
        data = data.substring(0,data.length()-2);
      else if (nonce > 99 && nonce <= 999)
        data = data.substring(0,data.length()-3);
      
      }
    }
    return thisNewHash; 
  }
  
    public String generateHash (String data){
      long primeNum = 17; //Prime number used for hash
      long hash = 0; // First half of the hash 
      for (int i = 0; i < data.length (); i++) 
        hash = ((primeNum * hash) + data.charAt (i));  
      if (hash < 0)
        hash *= -1; 
      String hashed = Long.toString(hash); //First half of the hash, converted to String
      //Adds the number 7, until the String is 19 digits long, which is creates a 16 char hex number
      if(hashed.length() < 19) {
        for (int i = hashed.length(); i < 19; i++) {
          hashed += 7;
        }
        hash = Long.parseLong(hashed); //Parses the String back to it's long form
      }
      String hash2 =""; //Second half of the hash
      int count = 0; //Counter for the while loop
      //This while loop will change the digits in the base10 hash, moving them back
      while(count < hashed.length()){
        if(count == 0)
          hash2 += hashed.charAt(hashed.length()-1);
        else{
          hash2 += hashed.charAt(count - 1);
        }
        count++;
      }
      long part2 = Long.parseLong(hash2); //Puts second half of hash to long, where it becomes a hex num
      return (Long.toHexString(hash) + Long.toHexString(part2));
    }
}