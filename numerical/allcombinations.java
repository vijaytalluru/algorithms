
public class allcombinations{
  public static void combine(String s){
    combine("",s);
  }
  
  private static void combine(String sofar, String rest){
    if( rest.equals("")){
      System.out.println(sofar); 
    }
    else{
        String next = rest.substring(0,1);  
        combine( sofar + next, rest.substring(1));
        combine( sofar ,  rest.substring(1));
    }
  }
  
  public static void main(String []args){
    combine(args[0]);
  } 
}
