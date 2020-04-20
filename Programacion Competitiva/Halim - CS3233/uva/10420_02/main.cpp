#include <iostream>
#include <string.h>
#include <algorithm>
using namespace std;
int main()
{
    int n=0;
    cin>>n;
    string contry;
    string vectore[2007];
    for(int i=0; i<2007; i++)
    {
        vectore[i]="";
    }
    int lim=0;
    while(n--)
    {
        cin>>contry;
        vectore[lim]=contry;
        lim++;
        getline(cin,contry);
    }
    sort(vectore,vectore+lim);
    int j=0,num=1, i;
    for(i=1; i<=lim; i++)
    {
        if(vectore[j].compare(vectore[i])==0)
        {
            num++;
        }
        else
        {
            cout<<vectore[j]<<" "<<num<<endl;
            j=i;
            num=1;
        }
    }

    return 0;
}
