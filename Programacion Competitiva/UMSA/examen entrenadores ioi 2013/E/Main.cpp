#include<cstdio>
#include<iostream>
#include<cstring>
#define max 10001
#define FOR(i,a,b) for(int i=a;i<b;i++)
#define FORC(i,a,b,c) for(int i=a;i<b;i+=c)
#define RFOR(i,a,b) for(int i=a;i>=b;i--)
using namespace std;
int vec[max];
void cargar(){
    vec[0]=vec[1]=-1;
    FOR(i,2,max)
        vec[i]=1;
    FOR(i,2,(max+2)>>1){
        FORC(j,(i<<1),max,i)
            vec[j]+=i;
    }
}
int main(){
    freopen("entrada.txt","r",stdin);
    freopen("salida.txt","w",stdout);
    cargar();
    int num;
    while(scanf("%d",&num)==1){
        if(num==0)
            break;
        printf("%d\n",vec[num]);
    }
    return 0;
}
