/* SRM 325 DIV II level 2 problem */
/* http://community.topcoder.com/stat?c=problem_statement&pm=6680 */

public class RGBStreet{
  public static int estimateCost(String[] houses){
    int size = houses.length;
    int [][]dp = new int[3][size];
    int [][]costs = new int[3][size];

    for(int i = 0 ; i < size ; i++){
      String []lcosts = houses[i].split(" ");
      costs[0][i] = Integer.parseInt(lcosts[0]);
      costs[1][i] = Integer.parseInt(lcosts[1]);
      costs[2][i] = Integer.parseInt(lcosts[2]);
    }

    for(int i = 0 ; i < 3 ; i++){
      dp[i][0] = costs[i][0];
    }

    for(int i = 1; i < size ; i++){
      for(int j = 0 ; j < 3 ; j++){
        dp[j][i] = Math.min( dp[(j+1)%3][i-1] + costs[j][i] , dp[(j+2)%3][i-1] + costs[j][i]); 
      }
    }
    
    int minCost = Integer.MAX_VALUE; 
    for(int j = 0 ; j < 3 ; j++){
       minCost = Math.min(minCost, dp[j][size-1]); 
    }

    return minCost ;
     
  }

  public static void main(String [] args){
    String[] houses = {"1 100 100", "100 1 100", "100 100 1"}    ;
    System.out.println(estimateCost(houses));
  }

}
