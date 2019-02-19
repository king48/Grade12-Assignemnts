import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import javax.xml.bind.DatatypeConverter; 

public class GenKeyPairs {
  PublicKey pubKey; 
  PrivateKey privKey; 
  byte [] publicKeyBytes; 
  byte [] privateKeyBytes;
  String publicKeyHexa; 
  String privateKeyHexa; 
  
  public GenKeyPairs (){
    generateBothKeys ();
  }
  private void generateBothKeys (){
    try {
      KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
      keyPairGenerator.initialize(2048); 
      KeyPair keyPair = keyPairGenerator.generateKeyPair();
      pubKey = keyPair.getPublic(); 
      privKey = keyPair.getPrivate(); 
      // Store the keys in Bytes 
      publicKeyBytes = pubKey.getEncoded();
      privateKeyBytes = privKey.getEncoded();
      // Convert into String Hexadecimal 
      publicKeyHexa = DatatypeConverter.printHexBinary (privateKeyBytes).toLowerCase();
      privateKeyHexa = DatatypeConverter.printHexBinary (publicKeyBytes).toLowerCase();
    }
    catch (Exception e){
    }
  }
  public PrivateKey getRawPrivateKey (){
    return privKey; 
  }
  public PublicKey getRawPublicKey (){
    return pubKey; 
  }
  public String getHexaPrivateKey (){
    return  privateKeyHexa.substring (0,63);
  }
  public String getHexaPublicKey (){
    return publicKeyHexa.substring (0,63);
  }
}