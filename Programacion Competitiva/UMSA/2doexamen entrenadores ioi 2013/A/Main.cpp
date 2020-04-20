#include<cstdio>
#include<iostream>
#include<algorithm>
#define max 1000000
#define FOR(i,a,b) for(int i=a;i<b;i++)
#define FORC(i,a,b,c) for(int i=a;i<b;i+=c)
using namespace std;
int vec[max];
void criba(){
    vec[0]=vec[1]=1;
    FOR(i,2,max){
        if(!vec[i]){
            FORC(j,(i<<1),max,i)
                vec[j]=1;
        }
    }
}
int main(){
   // freopen("entrada.txt","r",stdin);
    //freopen("salida.txt","w",stdout);
    fill(vec,vec+max,0);
    criba();
    int n,x,c1,c2,i,j;
    scanf("%d",&n);
    while(n--){
        scanf("%d",&x);
        if(!vec[x])
            printf("0\n");
        else{
            c1=c2=1;
            i=x-1;
            while(i>0 && vec[i]){
                c1++;
                i--;
            }
            j=x+1;
            while(vec[j]){
                c2++;
                j++;
            }
            printf("%d\n",(c1<c2)?c1:c2);
        }
    }
    return 0;
}
