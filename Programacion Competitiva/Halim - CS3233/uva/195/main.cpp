#include <iostream>
#include <stdlib.h>
#include <stdio.h>
#include <algorithm>
#include <string.h>

using namespace std;

int main()
{
    string a;
    cin>>a;
    char aa[a.length()+1];
    aa[a.length()]='\0';
    int i=0;
    for(; i<a.length(); i++)
    {
        aa[i]=a[i];
        cout<<aa[i]<<" "<<a[i]<<endl;
    }
    //sort(aa,aa+i);
    cout<<aa<<endl;;
//    do
//    {
    //      cout<<aa<<endl;
    // }
//   while(next_permutation(aa,aa+i));
    return 0;
}
