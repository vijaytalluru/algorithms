package stringops;

public class LSD{

  public static void sort(String[] a, int W){
    int N = a.length;
    int R = 256;
    String [] aux = new String[N];
    
    for(int d = W-1 ; d >= 0 ; d--){
      int [] count = new int[R];
      
      /* These are the frequencies */
      for(int i = 0 ; i < N ; i++){
        count[a[i].charAt(d)]++;
      } 

      /* Now getting the beginning indices */

      int total = 0;
      for(int i = 0 ; i < R ; i++){
        int oldcount = count[i];
        count[i] = total;
        total = total + oldcount;
      }

      for(int i = 0 ; i < N ; i++){
        aux[count[(a[i].charAt(d))]++] = a[i];
      }

      for(int i = 0 ; i < N; i++){
        a[i] = aux[i];
      }

    }
  }
}
