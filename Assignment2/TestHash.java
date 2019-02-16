public class TestHash {
  public void modulus (){
   String juan = "my name is juan"; 
   int g = 7; 
   int hash =0; 
   for (int i = 0; i < juan.length(); i ++) 
   {
     hash = (g * hash) + juan.charAt(i); 
    // System.out.println (hash);
   }
   
    System.out.println ("Final "+hash); 
  }
  public static void main (String args[]){
  TestHash t = new TestHash (); 
  t.modulus (); 
  }
}
