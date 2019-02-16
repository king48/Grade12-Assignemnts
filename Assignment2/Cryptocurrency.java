/*
Bill Bai, Juan-Diego Castano 
Ms K

This Program is the main class for running other programms 

*/

public class Cryptocurrency {
  
  static int transactionNumber = 2; 
  
  public static void main (String [] args){
    GenerateKeys juan = new GenerateKeys ();
    juan.getPrivateKey (); 
    GenerateKeys bill = new GenerateKeys (); 
    bill.getPrivateKey ();   
    GenerateKeys jim = new GenerateKeys (); 
    jim.getPrivateKey ();   
    GenerateKeys tan = new GenerateKeys (); 
    tan.getPrivateKey ();
    GenesisBlock gBlock = new GenesisBlock(transactionNumber,"20$", juan.getPublicKey (), bill.getPublicKey ());
    gBlock.getSignature (juan.getPrivateKey ());
   // gBlock.proofOfWork (); // isnt working rn 
    
  }
}