public class TestHash {
  public void getHash (String data){
   int g = 17; 
   int hash =0; 
   for (int i = 0; i < data.length(); i ++) 
   {
     hash = ((g * hash) + data.charAt(i)); 
    // System.out.println (hash);
   }
   if (hash < 0) { // if our hash is negative 
      hash *= -1; 
    }
    System.out.println ("Final "+hash); 
  }
  public static void main (String args[]){
  TestHash t = new TestHash (); 
  t.getHash ("The name of me is juan"); 
  t.getHash ("The name of me is juan"); 
  t.getHash ("The name of me is juan.f"); 
  t.getHash ("The name of me is juan.123"); 
  t.getHash ("The people"); 
  t.getHash ("The name of me i"); 
      
  
  }
}
