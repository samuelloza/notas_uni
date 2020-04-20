#include <iostream>
#include <stdio.h>
using namespace std;
int main(){
    int n,b,a,salto=1,f=1;
    cin>>n;
    while(n--){
        cin>>a>>b;int tot=0;
        for(int i=a; i<=b; i++){if(i%2==1)tot+=i;}
        cout<<"Case "<<f<<": "<<tot<<endl;f++;}
    return 0;
}
