#include <stdio.h>

int gcd(int u, int v)
{
  int t;
  while (u > 0)
  {
    if(u < v)
    {
      t = u;
      u = v;
      v = t;
    }
    u = u - v;
  }
  return v;
}

int main()
{
  int x,y;
  while((printf("Enter two numbers whose GCD is to be calculated\n"),scanf("%d %d",&x, &y) != EOF))
  {
    if (x > 0 && y > 0)
      printf("GCD of %d and %d is %d \n",x,y,gcd(x,y));
  }
}
