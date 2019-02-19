/*
Bill Bai, Juan-Diego Castano 
Ms K

This Program is the main class for running other programms 

*/

public class Cryptocurrency {
  
  static String [] previousHash = new String [3]; 
  static int [] transactionNumber = new int [4]; 
  static double [] transactionAmount = new double [4];  
  
  public void firstBlock (String senderKey, String receiverKey){
    System.out.println ("Juan is sending Bill 20 dollars"); 
    System.out.println ("Juan is otherwise known as " + senderKey);
    System.out.println ("And Bill is otherwise known as " + receiverKey);
    System.out.println (" "); 
    transactionAmount [0] = 1034.50; 
    transactionNumber [0] = 1;  
  }
  public void secondBlock (String senderKey, String receiverKey){
    System.out.println ("Jim is sending Josh 5000 dollars"); 
    System.out.println ("Jim is otherwise known as " + senderKey);
    System.out.println ("And Josh is otherwise known as " + receiverKey);
    System.out.println (" "); 
    transactionAmount [1] = 20.123; 
    transactionNumber [1] = 2;  
  }
  
  public static void main (String [] args){
    Cryptocurrency crypto = new Cryptocurrency (); 
    
    GenKeyPairs juan = new GenKeyPairs ();
    GenKeyPairs bill = new GenKeyPairs (); 
    GenKeyPairs jim = new GenKeyPairs (); 
    GenKeyPairs josh = new GenKeyPairs (); 
    GenKeyPairs jen = new GenKeyPairs (); 
    GenKeyPairs jess = new GenKeyPairs ();
    GenKeyPairs lenn = new GenKeyPairs (); 
    GenKeyPairs glenn = new GenKeyPairs ();
    
    crypto.firstBlock (juan.getHexaPublicKey (), bill.getHexaPublicKey ());
    GenesisBlock genBlock = new GenesisBlock(transactionNumber [0], transactionAmount [0], juan.getRawPublicKey (), bill.getRawPublicKey (), juan.getHexaPublicKey (), bill.getHexaPublicKey ());
    previousHash [0] = genBlock.generateBlock (juan.getRawPrivateKey ());
    //System.out.println (" ");
    crypto.secondBlock (jim.getHexaPublicKey (), josh.getHexaPublicKey ());
    BlockTwo secondBlock = new BlockTwo(transactionNumber [1], transactionAmount [0], jim.getRawPublicKey (), josh.getRawPublicKey (), jim.getHexaPublicKey (), josh.getHexaPublicKey (), previousHash [0]);
    previousHash [1] = secondBlock.generateBlock (jim.getRawPrivateKey ());
    System.out.println (" ");
  // BlockThree thirdBlock = new BlockThree(3,"1250$",  jen.getRawPublicKey (), jess.getRawPublicKey (), previousHash [1]);
  // previousHash [2]= thirdBlock.generateBlock (juan.getPrivateKey ());
  // System.out.println (" ");
    
  }
}


/*  
    GenerateKeys jim = new GenerateKeys (); 
    jim.getPrivateKey ();   
    GenerateKeys tan = new GenerateKeys (); 
    tan.getPrivateKey ();*/

   // gBlock.proofOfWork (); // isnt working rn 