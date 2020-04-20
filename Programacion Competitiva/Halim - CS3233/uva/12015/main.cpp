/*
//UVa Problem-12015(Google is Feeling Lucky)
//Accepted
//Running time: 0.064 sec
//Author: Milon

#include<iostream>
#include<cstring>
using namespace std;

struct search{
    char URL[100];
    int relevence;
    }google[10];

int main(){
    int test,kase=0;
    cin>>test;
    while(test--){
        for(int i=0;i<10;i++){
            cin>>google[i].URL>>google[i].relevence;
            }
        int max=0;
        for(int i=0;i<10;i++)
            if(google[i].relevence>max)
                max=google[i].relevence;
        cout<<"Case #"<<++kase<<":"<<endl;
        for(int i=0;i<10;i++)
            if(google[i].relevence==max)
                cout<<google[i].URL<<endl;
        }
    return 0;
    }
*/
#include <iostream>
#include <vector>
#include <climits>
#include <cmath>
using namespace std;

int main() {
    int n,i=1,maxi=0,nro;
    cin>>n;
    string cad;
    while(n--) {
        int d=10;
        vector<string> v1;
        vector<int> v2;
        maxi=0;
        for(int d=0; d<10; d++) {
            cin>>cad>>nro;
            v1.push_back(cad);
            v2.push_back(nro);
            maxi=max(nro,maxi);
        }
        cout<<"Case #"<<i<<":"<<endl;
        for(int j=0; j<10; j++) {
            if(maxi==v2[j])cout<<v1[j]<<endl;
        }
        i++;
    }
    return 0;
}
