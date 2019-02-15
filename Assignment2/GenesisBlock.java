public class GenesisBlock {
  String data; 
  
  public GenesisBlock (String data) {
    this.data = data; 
  }
  public String getSignature (){
    String signature = "";
    GenerateKeys keys = new GenerateKeys (); 
    String privateKey = keys.getPrivateKey ();
    
    return signature; 
  }
  public void generateHash (){
    
  }
  
}