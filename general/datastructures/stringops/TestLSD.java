package stringops;

public class Test{
  

  public static void main(String[] args){
    String [] input = {"robert", "eddard", "jofrey"};
    LSD.sort(input, 6);

    for(int i = 0 ; i < input.length ; i++){
      System.out.println(input[i]);
      
    }

  }
}
