#include <iostream>
#include <algorithm>
#include <map>
#include <string>
#include <cstdlib>
using namespace std;

int main() {
    string cad,cad2,cad3;
    int n,j,max;
    while(cin>>n>>cad) {
        j=0;
        map<string,int>mapa;
        for(int i=0; i<cad.length()-1; i++,j++) {
            mapa[cad.substr(j,n)]++;
        }
        max=0;
        for(map<string,int>::iterator i2=mapa.begin(); i2!=mapa.end(); i2++) {
            if(i2->second>max) {
                cad3=i2->first;
                max=i2->second;
            }
        }
        cout<<cad3<<endl;
        mapa.clear();

    }
    return 0;
}
