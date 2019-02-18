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
    
    GenerateKeys juan = new GenerateKeys ();
    GenerateKeys bill = new GenerateKeys (); 
    GenerateKeys jim = new GenerateKeys (); 
    GenerateKeys josh = new GenerateKeys (); 
    GenerateKeys jen = new GenerateKeys (); 
    GenerateKeys jess = new GenerateKeys ();
    GenerateKeys lenn = new GenerateKeys (); 
    GenerateKeys glenn = new GenerateKeys ();
    
    crypto.firstBlock (juan.getPublicKey (), bill.getPublicKey ());
    GenesisBlock genBlock = new GenesisBlock(transactionNumber [0], transactionAmount [0], juan.getPublicKey (), bill.getPublicKey ());
    previousHash [0] = genBlock.generateBlock (juan.getPrivateKey ());
    System.out.println (" ");
    crypto.secondBlock (jim.getPublicKey (), josh.getPublicKey ());
    BlockTwo secondBlock = new BlockTwo(transactionNumber [1], transactionAmount [0], jim.getPublicKey (), josh.getPublicKey (), previousHash [0]);
    previousHash [1] = secondBlock.generateBlock (jim.getPrivateKey ());
    System.out.println (" ");
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