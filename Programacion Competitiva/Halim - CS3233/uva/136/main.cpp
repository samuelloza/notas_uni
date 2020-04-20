#include <iostream>
#include <math.h>
#include <algorithm>

using namespace std;

int main()
{
    int cinco=13, tres=19, dos=30;
    int max=dos*tres*cinco;
    long long int v[max];
//   for(int i=0; i<max; i++)
//       v[i]=1;

    int pos=0;
    for(int i=0; i<dos; i++)
        for(int j=0; j<tres; j++)
            for(int k=0; k<cinco; k++)
                v[pos++]=(pow(2,i))*pow(3,j)*pow(5,k);



    reverse(v,v+max);
    for(int i=0; i<max; i++)
        if(v[i]==859963392)
            cout<<i<<endl;

    return 0;
}
