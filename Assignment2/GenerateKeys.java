public class GenerateKeys{
   private String privateKey = ""; 
   private String publicKey = "123123123123asdasd"; 
   public int [] positionOfNumbers = new int [64]; 
   public int [] positionOfChar = new int [64] ; 
  
    public String getPrivateKey (){
       int amountOfNumbers = 0; 
       int amountOfChar = 0; 
      for (int a = 0; a < 64 ; a ++) {
        int randomValue = (int)( Math.random () * 15) ; // creates a random value from 0 - 15 
        if (randomValue <= 9){
          privateKey += Integer.toString(randomValue); // converts the random value into a string, adds that value to PrivateKey 
          positionOfNumbers [amountOfNumbers] = a; // stores the position of where that number is in the privateKey 
          amountOfNumbers ++; // moves the head of the array up one
        }
        else {
          positionOfChar [amountOfChar] = a; 
          amountOfChar ++; 
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
      System.out.println ("Your Private Key is" + privateKey); 
      return privateKey; 
    } // ends method 
   
   
    public String getPublicKey () {
      for (int a = 0; a < 64 ; a ++) { 
        if (positionOfNumbers [a] == a) { // if the position of the array is == to the position we are changing then change 
          char tempNum  = privateKey.charAt (positionOfNumbers [a]); // find the value of the privateKey at this position 
          if (tempNum >= '0' && tempNum <= '6'){
            switch (tempNum) {
              case '0': 
                tempNum = '3';   
                break;
              case '1' : 
                tempNum = '4'; 
                break; 
              case '2':
                  tempNum = '5'; 
                  break; 
              case '3':
                  tempNum = '6'; 
                  break; 
              case '4':
                tempNum = '7'; 
                break; 
              case '5':
                tempNum = '8'; 
                break;
              case '6':
                tempNum = '9'; 
                break; 
              } // end of switch 
            //System.out.println ("y"+tempNum); 
            publicKey +=Character.toString(tempNum); // add that number to the privateKey 
          } else {
            switch (tempNum) {
              case '7': 
                tempNum = '0';   
                break;
              case '8' : 
                tempNum = '1'; 
                break; 
              case '9':
                tempNum = '2'; 
                break; 
              } // end of switch 
          //  System.out.println (tempNum); 
            publicKey += Character.toString(tempNum); 
            } // end of else 
        } // end of second if 
        else {
          
        } // end of first if statment 
      }//end of for loop 
      System.out.println ("Your new public key is " + publicKey); 
      return publicKey; 
    } // end of method 
    
    public static void main (String [] args){
      GenerateKeys k = new GenerateKeys (); 
      k.getPrivateKey(); 
      k.getPublicKey (); 

    }
}