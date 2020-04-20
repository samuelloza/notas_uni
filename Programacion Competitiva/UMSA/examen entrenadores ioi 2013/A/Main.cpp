#include<cstdio>
#include<iostream>
#include<algorithm>
#define max 100000
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
    freopen("entrada.txt","r",stdin);
    freopen("salida.txt","w",stdout);
    fill(vec,vec+max,0);
    criba();
    int n,x,c1,c2,i,j;
    scanf("%d",&n);
    while(n--){
        scanf("%d",&x);
        if(!vec[x])
            printf("%d ",x);
        c1=c2=0;
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
        if(c1<=c2)
            printf("%d %d\n",i,j);
        else{
            printf("%d ",j);
            if(i)
                printf("%d\n",i);
            else
                cout<<endl;
        }
    }
    return 0;
}
