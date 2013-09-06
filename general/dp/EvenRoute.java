/* SRM 538 DIV II Level 2 */
public class EvenRoute{
  public static String isItPossible(int[] x , int[] y, int wantedParity){
    int N = x.length;
    boolean origDistAllEven = true;
    boolean origDistAllOdd = true;
    for(int i= 0 ; i < N ; i++){
      int distOrigin = Math.abs(x[i]) + Math.abs(y[i]);
      if(distOrigin % 2 == 0){
        origDistAllOdd = false;
      } 
      if(distOrigin % 2 == 1){
        origDistAllEven = false;
      } 
    }
    boolean intDistAllEven = true;
    boolean intDistAllOdd = true;
    for(int i = 0 ; i < N ; i++){
      for(int j = 0; j < i ; j++){
        int intDist = Math.abs(x[i] - x[j]) + Math.abs(y[i] - y[j]);  
        if(intDist % 2 == 0){
          intDistAllOdd = false;
        }
        if(intDist % 2 == 1){
          intDistAllEven = false;
        }
      }
    }

    String result = "CAN"; 
    if(wantedParity == 0){
      if(origDistAllOdd  && intDistAllEven){
        result  = "CANNOT";
      }
    }
    if(wantedParity == 1){
      if(origDistAllEven  && intDistAllEven){
        result  = "CANNOT";
      }
    }

    return result;
  }


  public static void main(String[] args){
    int [] x = {11,21,0};
    int [] y = {-20,42,7};

    System.out.println(isItPossible(x,y,0)); 
    
  }
}
