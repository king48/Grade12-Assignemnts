public class TestHash {
  public void modulus (){
    String juan = "my name is juan"; 
    int length = juan.length (); 
    int other = 64%length; 
    System.out.println (length + " " + other); 
  }
  public static void main (String args[]){
  TestHash t = new TestHash (); 
  t.modulus (); 
  }
}
