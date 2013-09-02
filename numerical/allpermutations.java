
public class allpermutations{
  public static void permute(String s){
    permute("",s);
  }
  
  private static void permute(String sofar, String rest){
    if( rest.equals("")){
      System.out.println(sofar); 
    }
    else{
      for(int i = 0 ; i < rest.length(); i++){
        String next = rest.substring(i,i+1);  
        permute( sofar + next , rest.substring(0,i) + rest.substring(i+1));
      }
    }
  }
  
  public static void main(String []args){
    permute(args[0]);
  } 
}
