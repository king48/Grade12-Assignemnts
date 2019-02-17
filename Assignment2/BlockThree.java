public class BlockThree extends GenesisBlock {
  private int transactionsMade;

  public BlockThree(int transactionID, String transactionAmount , String sender, String receiver){
    super(transactionID,transactionAmount,sender,receiver); //This calls superclass constructor
    transactionsMade = 0;
  }
  
  public void addTransaction(int transactionsMade){
    this.transactionsMade += transactionsMade;
  }
  
  public int getTransactionsMade(){
    return transactionsMade;
  }
}