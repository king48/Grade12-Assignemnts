public class BlockTwo extends GenesisBlock {

   private int transactionsMade;
   private String previousHash;
   
   public BlockTwo(int transactionID, String transactionAmount , String sender, String receiver, String previousHash ){
       super(transactionID,transactionAmount,sender,receiver); //This calls superclass constructor
       transactionsMade = 0;
       this.previousHash = previousHash; 
   }
  
   public void addTransaction(int transactionsMade){
       this.transactionsMade += transactionsMade;
   }
  
   public int getTransactionsMade(){
       return transactionsMade;
   }
   public String getSignature (String senderPrivateKey){
    String signature = "0dc60cd6005af6cdff32f6c243ff9fd14c1d06e2125cf96e15cbbfb6b3fab93d";
    String data = ""; 
    data += transactionID; 
    data += transactionAmount ; 
    data += sender;
    data += receiver;
    data += previousHash; 
    String hash = generateHash(data); 
    System.out.println ("Signature  = " + signature);
    return signature; 
  }
   public String proofOfWork (String signature) {
     boolean hashNotFound = true;
     String newHash = ""; 
     int nonce = 0 ; 
     String data = ""; 
     data += blockNumber;  
     data += transactionID;  
     data += transactionAmount;  
     data += previousHash; 
     data += sender;
     data += receiver;
     data += signature; 
     
     System.out.println ("dataaa" + data); 
     // for (int i = 0; i < 50; i ++){
     while (hashNotFound){
       data += nonce;  
       newHash = generateHash (data);
       if (newHash.charAt (0) == '0' && newHash.charAt (1) == 'd' &&  newHash.charAt (2) == 'c' ){
         System.out.println ("Nonce is "+ nonce + " your new hash is " + newHash); 
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
}