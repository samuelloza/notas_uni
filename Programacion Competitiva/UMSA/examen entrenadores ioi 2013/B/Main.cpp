#include <conio.h>
#include <stdio.h>
#include <iostream>
#include <math.h>
using namespace std;
int main()
{   int x;
    cin>>x;
    while(x!=0)
     {

	 int c=0;
	 for(int i=1;i<=x/2+1;i++)
	  {
	     if(x%i==0)
	      {
		c=c+i;
	       }

	   }

	  cout<<c;

	cin>>x;

     }

}

