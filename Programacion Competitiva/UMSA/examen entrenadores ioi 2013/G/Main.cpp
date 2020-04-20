#include<cstdio>
#include<iostream>
#include<fstream>
#define FOR(i,a,b) for(int i=a;i<b;i++)
#define RFOR(i,a,b) for(int i=a;i>=b;i--)
#define max 100
using namespace std;
char mat1[max][max];
char mat2[max][max];

void girar(int n){
    int a,b;
    FOR(i,0,n)
        FOR(j,0,n)
            mat2[j][n-i-1]=mat1[i][j];
    FOR(i,0,n)
        FOR(j,0,n)
            mat1[i][j]=mat2[i][j];
}

int main(){
    ifstream fin("entrada.txt");
    ofstream fout("salida.txt");
    int n,s,t,k;
    string orden;
    k=1;
    while(fin>>n){
        if(n==0)
            break;
        fin>>orden;
        FOR(i,0,n)
            FOR(j,0,n)
                fin>>mat1[i][j];
        s=0;
        FOR(i,0,orden.size()){
            switch(orden[i]){
                case 'A': s+=90;break;
                case 'B': s+=180;break;
                case 'C': s+=270;break;
            }
        }
        s=(s%360);
        t=s/90;
        while(t--)
            girar(n);
        fout<<"Matriz #"<<k++<<":"<<endl;
        FOR(i,0,n){
            FOR(j,0,n)
                fout<<mat1[i][j];
            fout<<endl;
        }
    }
    return 0;
}
