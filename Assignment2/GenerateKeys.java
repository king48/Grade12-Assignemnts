public class GenerateKeys{
   private String privateKey = ""; 
   private String publicKey = ""; 
   public boolean [] valueOfPosition = new boolean [64]; 
   
   public int generateRandomValue (int minValue, int maxValue){
     return (int) (Math.random ()* maxValue) + minValue ;   
   }
    public String getPrivateKey (){
      for (int a = 0; a < 64 ; a ++) {
        int randomValue = generateRandomValue (0,15) ; // creates a random value from 0 - 15 
        if (randomValue <= 9){
          privateKey += Integer.toString(randomValue); // converts the random value into a string, adds that value to PrivateKey 
          valueOfPosition [a] = true; // stores the position of where that number is in the privateKey 
        }
        else {
          valueOfPosition [a] = false ; 
          switch (randomValue){ //finds the value and converts it into a letter 
            case 10 :
              privateKey +="A";
              break; 
            case 11 : 
              privateKey +="B"; 
              break; 
            case 12 :  
              privateKey +="C"; 
              break; 
            case 13 :  
              privateKey +="D"; 
              break; 
            case 14 :
              privateKey +="E"; 
              break;
            case 15 :
              privateKey +="F"; 
              break;
          } // ends switch statment 
        } // ends else          
      } // ends for 
      
      return privateKey; 
    } // ends method 
   
    private char changeNumber (int position){
      char tempNumber = privateKey.charAt (position); 
      switch (tempNumber) {
        case '0' :
          tempNumber = '3'; 
          break;
        case '1' :
          tempNumber = '4'; 
          break; 
        case '2' :
          tempNumber = '5'; 
          break; 
        case '3' :
          tempNumber = '6'; 
          break; 
        case '4' :
          tempNumber = '7'; 
          break;
        case '5' :
          tempNumber = '8'; 
          break;
        case '6' :
          tempNumber = '9'; 
          break; 
        case '7' :
          tempNumber = '0'; 
          break; 
        case '8' :
          tempNumber = '1'; 
          break;
        case '9' :
          tempNumber = '2'; 
          break;
      }
      return tempNumber;
    }
    private char changeCharacter (int position){
      char tempChar = privateKey.charAt (position); 
      switch (tempChar) { 
        case 'A':
          tempChar = 'D'; 
          break; 
        case 'B' :
          tempChar = 'E';
          break;
        case 'C' :
          tempChar = 'F'; 
          break;
        case 'D':
          tempChar = 'A'; 
          break; 
        case 'E' :
          tempChar = 'B';
          break;
        case 'F' :
          tempChar = 'C'; 
          break;                 
      }
      return tempChar; 
    }
    
    public String getPublicKey () {
      System.out.println ("  "); 
      for (int a = 0; a < 64 ; a ++) { 
        if (valueOfPosition [a] == true) {
          publicKey += Character.toString(changeNumber (a)); 
        }
        else {
           publicKey += Character.toString(changeCharacter(a)); 
        }
      }
      return publicKey; 
    } // end of method 
    
   /* 
    public static void main (String [] args){
      GenerateKeys k = new GenerateKeys (); 
      k.getPrivateKey(); 
      k.getPublicKey (); 
      System.out.println ("Your Private Key is " + privateKey); 
      System.out.println ("Your public key is " + publicKey); 
    }
    */
}