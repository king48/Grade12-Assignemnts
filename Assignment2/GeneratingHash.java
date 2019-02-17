import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.xml.bind.DatatypeConverter; 

class GeneratingHash {
  private String data = ""; 
  
  public GeneratingHash (String data){
    this.data = data; 
  }
  public static String getHash (byte [] inputBytes){
    String hashValue = ""; 
    try {
      MessageDigest md = MessageDigest.getInstance("SHA-256");
      md.update (inputBytes); 
      byte [] digestBytes = md.digest ();
      hashValue = DatatypeConverter.printHexBinary (digestBytes).toLowerCase(); 
    }
    catch (Exception e) {
    }
    return hashValue; 
  }
  public String message () {
    String hash = ""; 
    try {
       byte [] dataInBytes = data.getBytes(); 
       hash = getHash(dataInBytes);
    }
    catch (Exception e) {
    }
    return hash ; 
  } 
}
