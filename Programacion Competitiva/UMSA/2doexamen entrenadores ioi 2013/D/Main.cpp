#include<cstdio>
#include<iostream>
#include<algorithm>
#define FOR(i,a,b) for(int i=a;i<b;i++)
#define FORC(i,a,b,c) for(int i=a;i<b;i+=c)
using namespace std;
int main(){
    freopen("entrada.txt","r",stdin);
    freopen("salida.txt","w",stdout);
    int n,h,m,x,k=1;
    while(scanf("%d",&n)==1){
        if(n==0)
            break;
        int vec[n];
        FOR(i,0,n){
            scanf("%d:%d",&h,&m);
            x=h*60+m;
            vec[i]=x;
        }
        sort(vec,vec+n);
        printf("Caso #%d:\n",k++);
        FOR(i,0,n){
            h=vec[i]/60;
            m=vec[i]%60;
            if(h<10)
                printf("0");
            printf("%d:",h);
            if(m<10)
                printf("0");
            printf("%d\n",m);
        }
    }
    return 0;
}
