import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;

public class BlockTwo extends GenesisBlock {

   private int transactionsMade;
   private String previousHash;
   
  
   public BlockTwo(int transactionID, double transactionAmount, PublicKey senderRawKey, PublicKey receiverRawKey, String senderKey, String receiverKey, String previousHash ){
       super(transactionID,transactionAmount,senderRawKey,receiverRawKey,senderKey,receiverKey); //This calls superclass constructor
       transactionsMade = 0;
       this.previousHash = previousHash; 
   }
   public void addTransaction(int transactionsMade){
     this.transactionsMade += transactionsMade;
   }
  
   public int getTransactionsMade(){
     return transactionsMade;
   }
   public String data (){
    String data = ""; 
    data += blockNumber + 1; 
    data += transactionID; 
    data += transactionAmount ; 
    data += senderKey;
    data += receiverKey;
    data += previousHash; 
    return data; 
  }
  
}