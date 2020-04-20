#include <iostream>
#include<stdlib.h>
#include <algorithm>
#include <stdio.h>

using namespace std;
int main()
{
    int n;
    cin>>n;
    char cad[15]= {32};
    int l=0;
    while(n--)
    {
        l=0;
        for(int ii=0; ii<15; ii++)
        {
            cad[ii]=32;
        }
        cin>>cad;
        for(int j=0; j<15; j++)
        {
            if(cad[j]!=32)
            {
                l++;
            }
        }
        l--;
        sort(cad,cad+l);
        do
        {
            cout<<cad<<endl;
        }
        while(next_permutation(cad,cad+l));
        cout<<endl;
    }
    return 0;
}
