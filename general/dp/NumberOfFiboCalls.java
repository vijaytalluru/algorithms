
public class NumberOfFiboCalls{
  public static  int[] fiboCallsMade(int n){
    
    int []calls = {0,0};
    int []prevCalls = {0,0};
    if( n == 0){
      calls[0] = 1;
      calls[1] = 0;
      return calls;
    }
    calls[0] = 0;
    calls[1] = 1;
    prevCalls[0] = 1;
    prevCalls[1] = 0;

    for(int i = 2 ; i <= n ; i++){
      int []temp = {0,0};
      temp[0] = calls[0];
      temp[1] = calls[1];

      calls[0] = calls[0] + prevCalls[0];
      calls[1] = calls[1] + prevCalls[1];

      prevCalls[0] = temp[0];
      prevCalls[1] = temp[1];
    }

    return calls;
  }

  public static void main(String[] args){
    System.out.println(fiboCallsMade(Integer.parseInt(args[0]))[0] +" " + fiboCallsMade(Integer.parseInt(args[0]))[1]);
  }
}
