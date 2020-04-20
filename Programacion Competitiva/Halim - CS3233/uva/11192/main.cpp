#include <string.h>
#include <iostream>
#include <algorithm>
#include <stdio.h>

using namespace std;
int main() {
    int n,d;
    string cad,s2;
    bool sw=false;
    cin>>n;
    while(n!=0) {
        cin>>cad;
        d=cad.length()/n;
        for(int i=0; i<=cad.length()-1;i+=d) {
            s2=cad.substr(i,d);
            reverse(s2.begin(),s2.end());
            cout<<s2;
        }
        cout<<endl;
        cin>>n;
    }
    return 0;
}
