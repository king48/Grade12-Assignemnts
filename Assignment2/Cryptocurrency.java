/*
Bill Bai, Juan-Diego Castano 
Ms K

This Program is the main class for running other programms 

*/

public class Cryptocurrency {
  
  static String [] previousHash = new String [3]; 
  
  public static void main (String [] args){
    GenerateKeys juan = new GenerateKeys ();
    GenerateKeys bill = new GenerateKeys (); 
    GenerateKeys jim = new GenerateKeys (); 
    GenerateKeys josh = new GenerateKeys (); 
    GenerateKeys jen = new GenerateKeys (); 
    GenerateKeys jess = new GenerateKeys ();
   
    GenesisBlock genBlock = new GenesisBlock(1,"20$", juan.getPublicKey (), bill.getPublicKey ());
    previousHash [0]= genBlock.generateBlock (juan.getPrivateKey ());
    System.out.println (" ");
    // BlockTwo secondBlock = new BlockTwo(2,"5000$", jim.getPublicKey (), josh.getPublicKey (), previousHash [0]);
    // previousHash [1]= secondBlock.generateBlock (juan.getPrivateKey ());
    // System.out.println (" ");
    //  BlockThree thirdBlock = new BlockThree(3,"1250$",  jen.getPublicKey (), jess.getPublicKey (), previousHash [1]);
    // previousHash [2]= thirdBlock.generateBlock (juan.getPrivateKey ());
    //  System.out.println (" ");
    
  }
}


/*  
    GenerateKeys jim = new GenerateKeys (); 
    jim.getPrivateKey ();   
    GenerateKeys tan = new GenerateKeys (); 
    tan.getPrivateKey ();*/

   // gBlock.proofOfWork (); // isnt working rn 