/*
Bill Bai, Juan-Diego Castano 
Ms K

This Program is the main class for running other programms 

*/

public class Cryptocurrency {
    
  public static void main (String [] args){
    GenerateKeys keys = new GenerateKeys ();
    GenerateKeys key1 = new GenerateKeys (); 
    keys.getPrivateKey (); 
    key1.getPrivateKey (); 
    GenesisBlock gBlock = new GenesisBlock("10", keys.getPublicKey (), key1.getPublicKey ());
   
    
  }
}