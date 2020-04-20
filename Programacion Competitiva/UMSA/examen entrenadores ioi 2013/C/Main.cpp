#include<cstdio>
#include<iostream>
#include<cstring>
#define max 100
#define FOR(i,a,b) for(int i=a;i<b;i++)
#define RFOR(i,a,b) for(int i=a;i>=b;i--)
using namespace std;
int main(){
    freopen("entrada.txt","r",stdin);
    freopen("salida.txt","w",stdout);
    int n,k,sum;
    string almacen;
    scanf("%d\n",&n);
    FOR(i,0,n){
        k=sum=0;
        cin>>almacen;
        int m=almacen.size();
        char vec[m];
        int cont[m];
        FOR(a,0,m){
            int j=0;
            while(j<k && vec[j]!=almacen[a])
                j++;
            if(j==k){
                cont[k]=1;
                vec[k++]=almacen[a];
            }
            else
                cont[j]++;
        }
        printf("Caso #%d:\n",i+1);
        printf("%d\n",k);
        FOR(j,0,k){
            cout<<vec[j]<<": "<<cont[j]<<endl;
            sum+=cont[j];
        }
        printf("Total: %d\n",sum);

    }
    return 0;
}
