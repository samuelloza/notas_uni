#include<cstdio>
#include<iostream>
#include<cstring>
#define max 100
#define FOR(i,a,b) for(int i=a;i<b;i++)
#define RFOR(i,a,b) for(int i=a;i>=b;i--)
using namespace std;
int main(){
    //freopen("entrada.txt","r",stdin);
    //freopen("salida.txt","w",stdout);
    int n;
    char linea[max];
    scanf("%d",&n);
    FOR(i,0,n+1){
        gets(linea);
        if(i>0){
            char *token;
            string cad;
            int sw=0;
            token=strtok(linea," ");
            while(token!=NULL){
                printf("%c",(sw)?token[strlen(token)-1]:token[0]);
                sw=1-sw;
                token=strtok(NULL," ");
            }
            printf("\n");
        }
    }
    return 0;
}
