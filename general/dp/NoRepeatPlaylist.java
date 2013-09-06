/* SRM 531 Div II Level 2 */

import java.util.*;

public class NoRepeatPlaylist{
  
  public static int numPlaylists(int N, int M, int P){
  
    HashMap<Integer,Integer> valuePos = new HashMap<Integer,Integer>();
    
    int count = numPlaylists(P,valuePos,N, M,0,0);

    return count;

  }

  static int numPlaylists(int P, HashMap<Integer,Integer> posValue,
                   int N,int M,int start,int count){
    if(P == 0){
      if(posValue.keySet().size() !=  N){
        return 0;        
      }
        count = (count + 1) % 1000000007;
        return count;
    }
    else{
      int result = 0;
      for(int i = 0 ; i < N ; i++){
        HashMap<Integer,Integer> temp = new HashMap<Integer,Integer>(posValue);
        if( temp.containsKey(i) )
        {
          int prevPosition = temp.get(i);
          if( start - prevPosition - 1 < M){
            continue;
          }
        }
        temp.put(i,start);
        result += numPlaylists(P-1,temp,N,M,start+1,count);
      }
      count = result;
    }
    return count;
   }

   public static void main(String[] args){
     System.out.println(numPlaylists(50,5,100));      
   }

  
}
