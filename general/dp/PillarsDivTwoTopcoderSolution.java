/*http://community.topcoder.com/stat?c=problem_statement&pm=12075&rd=14739 */


public class PillarsDivTwoTopcoderSolution{
  public static double maximalLength(int [] height, int w){
    int size = height.length;
    int maxheight = 0;
    for(int i = 0 ; i < size ; i++){
      maxheight = Math.max(height[i],maxheight);
    }
    double [][]dp = new double[size][maxheight];
    
    for(int i = 0 ; i < height[0] ; i++){
      dp[0][i] = 0;
    }
    for(int i = 1 ; i < size ; i++){
      for(int j = 0 ; j < height[i]; j++){ 
        double max = 0;
        for(int k = 0 ; k < height[i-1]; k++){
          max = Math.max(max, dp[i-1][k] + getRopeLength(j,k,w) );
        }
        dp[i][j] = max;
      }
    }

    double max = 0;
    for(int i = 0 ; i < height[size-1] ; i++){
       max = Math.max(dp[size-1][i],max); 
    }

    return max;
  }
  public  static double getRopeLength(int h1, int h2, int w){
    return Math.sqrt((h1-h2)*(h1-h2) + w*w); 
  }

  public static void main(String []args){
    int [] height = {100,2,100,2,100};
    int w = 1;
    System.out.println(maximalLength(height,w)); 
  }
}
