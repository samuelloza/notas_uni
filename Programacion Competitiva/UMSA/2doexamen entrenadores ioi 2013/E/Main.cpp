#include<cstdio>
#include<iostream>
#include<algorithm>
#define FOR(i,a,b) for(int i=a;i<b;i++)
#define FORC(i,a,b,c) for(int i=a;i<b;i+=c)
using namespace std;
int main(){
    freopen("entrada.txt","r",stdin);
    freopen("salida.txt","w",stdout);
    int n,h,m,s,x,k;
    scanf("%d",&n);
    while(n--){
        scanf("%d:%d:%d %d",&h,&m,&s,&x);
        k=h*3600+m*60+s;
        k+=x;
        k=k%86400;
        h=k/3600;
        k=k%3600;
        m=k/60;
        s=k%60;
        if(h<10)
            printf("0");
        printf("%d:",h);
        if(m<10)
            printf("0");
        printf("%d:",m);
        if(s<10)
            printf("0");
        printf("%d\n",s);
    }
    return 0;
}
