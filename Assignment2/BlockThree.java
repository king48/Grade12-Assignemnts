public class BlockThree extends GenesisBlock {
  private int transactionsMade;

  public BlockThree(int transactionID, double transactionAmount, String sender, String receiver, String previousHash){
    super(transactionID,transactionAmount,senderRawKey,receiverRawKey,senderKey,receiverKey); //This calls superclass constructor
    transactionsMade = 0;
  }
  
  public void addTransaction(int transactionsMade){
    this.transactionsMade += transactionsMade;
  }
  
  public int getTransactionsMade(){
    return transactionsMade;
  }
}