#include<cstdio>
#include<iostream>
#include<fstream>
#define FOR(i,a,b) for(int i=a;i<b;i++)
#define RFOR(i,a,b) for(int i=a;i>=b;i--)
using namespace std;
string suma(string x,string y){
    string nuevo="";
    int n=x.size()-1;
    int m=y.size()-1;
    int a,b,c,s;
    char w;
    a=b=c=0;
    while(n>=0 || m>=0 || c){
        if(n>=0)
            a=x[n]-'0';
        if(m>=0)
            b=y[m]-'0';
        s=(a+b+c)%10;
        c=(a+b+c)/10;
        w=s+'0';
        nuevo=w+nuevo;
        a=b=0;
        n--;
        m--;
    }
    return nuevo;
}
int main(){
    ifstream fin("entrada.txt");
    ofstream fout("salida.txt");
    int n;
    string num1,num2;
    fin>>n;
    while(n--){
        fin>>num1>>num2;
        fout<<suma(num1,num2)<<endl;
    }
    return 0;
}
