/*http://community.topcoder.com/stat?c=problem_statement&pm=12075&rd=14739 */


public class PillarsDivTwo{
  public static double maximalLength(int [] height, int w){
    int size = height.length;
    double [] maxEndingHighest = new double[size];
    double [] maxEndingLowest = new double[size];
    double [] max = new double[size];
     
    max[0] = 0;
    maxEndingHighest[0] = 0;
    maxEndingLowest[0] = 0;

    for(int i = 1 ; i < size ; i++){
      maxEndingHighest[i] = Math.max(maxEndingLowest[i-1] + getRopeLength(1,height[i],w), maxEndingHighest[i-1] + getRopeLength(height[i-1],height[i],w));
      maxEndingLowest[i] = Math.max(maxEndingHighest[i-1] + getRopeLength(height[i-1],1,w), maxEndingLowest[i-1] + getRopeLength(1,1,w));

      if( maxEndingHighest[i]> maxEndingLowest[i]){
        max[i] = maxEndingHighest[i];
      }
      else{
        max[i] = maxEndingLowest[i];
      }
    }

    return max[size-1];
        
  }

  public  static double getRopeLength(int h1, int h2, int w){
    return Math.sqrt((h1-h2)*(h1-h2) + w*w); 
  }

  public static void main(String []args){
    int [] height = {2,1,1,2};
    int w = 1;
    System.out.println(maximalLength(height,w)); 
  }
}
