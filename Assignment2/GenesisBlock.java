public class GenesisBlock {
  String privateKey; 
    
    public void getPrivateKey (){
      int randomValue; 
      privateKey = ""; 
      for (int a = 1; a <= 64 ; a ++) {
        randomValue = (int)( Math.random () * 16) ; // creates a random value from 0 - 16 
        if (randomValue <= 9){
          privateKey += Integer.toString(randomValue); // converts the random value into a string 
        }
        else {
          switch (randomValue){
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
            case 16 :
              privateKey +="G"; 
              break;
          } // ends switch statment 
        } // ends else          
      } // ends for 
    } // ends method 
    
    public void PublicKey () {
    
    }
  
}