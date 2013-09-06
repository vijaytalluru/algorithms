/* Used in SRM 585 Division Two Level Two */

public class TrafficCongestionDivTwo{
  static long theMinCars(int treeHeight){
    long [] cars = new long[treeHeight+1];

    cars[0] = 1;
    cars[1] = 1;

    for(int i = 2 ; i < treeHeight+1 ; i++){
      cars[i] = 1;
      for(int j = i-2 ;j >= 0 ; j--)
      cars[i] += 2*cars[j];
    }

    return cars[treeHeight];
  }


  public static void main(String[] args){
    System.out.println(theMinCars(60));
  }
}
