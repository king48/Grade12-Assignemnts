/*
Bill Bai, Juan-Diego Castano 
Ms K

This Program is the main class for running other programms 

*/

public class Cryptocurrency {
    
  public static void main (String [] args){
    GenerateKeys juan = new GenerateKeys ();
    GenerateKeys bill = new GenerateKeys (); 
    juan.getPrivateKey (); 
    bill.getPrivateKey (); 
    GenesisBlock gBlock = new GenesisBlock("10$", juan.getPublicKey (), bill.getPublicKey ());
    gBlock.getSignature (juan.getPrivateKey ());
  }
}