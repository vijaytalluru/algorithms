/* http://community.topcoder.com/stat?c=problem_statement&pm=12155 */
/* This is the SRM 555, div 2 500 problem */
public class CuttingBitString{
  static int [] cutindex;  
  public static int getmin(String S){
    int N = S.length();
    int [] mincuts = new int[N];   
    cutindex = new int[N];

    for(int i = 0 ; i < N ; i++){
      mincuts[i] = -1;   
      cutindex[i] = -1;

      if(  isPowerOf5(S,0,i) ){
        mincuts[i] = 1;
        cutindex[i] = -1;
      }
      else{
        for(int j = 0 ; j < i ; j++){
          if( isPowerOf5(S,j+1,i) && mincuts[j] != -1){
            if(mincuts[i] == -1 || mincuts[i] > mincuts[j] + 1 ){
              mincuts[i] = mincuts[j] + 1;
              cutindex[i] = j; 
            }
          }
        }
      }
    }

    return mincuts[N-1];
  }

  private static boolean isPowerOf5(String S, int beginning, int end){
    String ss = S.substring(beginning,end+1);
    if(ss.charAt(0) == '0'){
      return false;
    }
    long  t = 0;
    for(int i = 0 ;  i < ss.length(); i++){
      t = t*2 + Integer.parseInt(ss.substring(i,i+1));
    }


    while( t%5 == 0){
      t = t/5; 
    }
    if( t == 1){
      return true;
    }
    else{
      return false;
    }
  }

  private static void printTheCuts(String s){
    printTheCuts(s,s.length() - 1);  
  }
  private static void printTheCuts(String s,int i){
      if (cutindex[i] == -1){
        System.out.println( s.substring(0,i+1)); 
        return;
      }
      printTheCuts(s,cutindex[i]);
      System.out.println(s.substring(cutindex[i]+1,i+1));
  }


  public static void main(String[] args){
    System.out.println(getmin(args[0]));

    if(getmin(args[0]) != -1){
      System.out.println("The cuts are:");
      printTheCuts(args[0]);
    }
    
  }
}
