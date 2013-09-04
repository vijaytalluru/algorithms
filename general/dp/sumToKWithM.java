
public class sumToKWithM{
  
  public static int count(int []nums,int m, int K){
    return count(nums,0,m,K,0);
  }
  public static int count(int[] nums, int start, int m, int K, int count){
  
    if( m == 0 && K == 0){
      count++;
      return count;
    }

    if( m == 0 || K == 0 || start >= nums.length){
      return count;
    }

    int result = 0;
    if( nums[start] <= K)
      result += count(nums,start+1,m-1,K-nums[start],count); 
    result += count(nums,start+1,m,K,count);

    return result;
    
  }
  public static void main(String[] args){
    int A[] = {1,2,3,4,5,6,7,8,9};
    int m = 3;
    int K = 10;
    System.out.println(count(A,m,K));
    
  }
}
