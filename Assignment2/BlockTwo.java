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


  
}