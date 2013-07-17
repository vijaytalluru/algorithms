#include <stdio.h>
#include <stdlib.h>
#include <math.h>

int printPrimesUpto(int n);

int main()
{
  int n;
  printf("Enter a number upto which you want the primes\n");
  scanf("%d", &n);
  printPrimesUpto(n);
}

int printPrimesUpto(int n)
{
  int *a = (int *)malloc(sizeof(int) * (n+1));
  a[1] = 0;
  for(int i = 2 ; i < (n+1) ; i++)
  {
    a[i] = 1;
  } 
  int sqrtn =  ceil(sqrt(n));
  for(int i = 2 ; i <= sqrtn ; i++)
    if(a[i])
      for(int j = 2 ; j <= ceil((float)n/(float)i) ; j++)
      {
        if( i * j < (n+1))
          a[i * j] = 0;
      }

  for(int i = 1 ; i < (n + 1) ; i++)
  {
    if(a[i])
      printf("%d ", i);
  }
    
}
