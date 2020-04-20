#include<cstdio>
#include<iostream>
#define FOR(i,a,b) for(int i=a;i<b;i++)
#define RFOR(i,a,b) for(int i=a;i>=b;i--)
using namespace std;
int main(){
    freopen("entrada.txt","r",stdin);
    freopen("salida.txt","w",stdout);
    int d,m,a;
    bool valid;
    while(scanf("%d%d%d",&d,&m,&a)==3){
        if(d==0 && m==0 && a==0)
            break;
        switch (m){
            case 1:printf((d>0 && d<=31)?"SI\n":"NO\n");break;
            case 2:{
                if(a%4==0 && (a%100!=0 || a%400==0))
                    printf((d>0 && d<=29)?"SI\n":"NO\n");
                else
                    printf((d>0 && d<=28)?"SI\n":"NO\n");
            }break;
            case 3:printf((d>0 && d<=31)?"SI\n":"NO\n");break;
            case 4:printf((d>0 && d<=30)?"SI\n":"NO\n");break;
            case 5:printf((d>0 && d<=31)?"SI\n":"NO\n");break;
            case 6:printf((d>0 && d<=30)?"SI\n":"NO\n");break;
            case 7:printf((d>0 && d<=31)?"SI\n":"NO\n");break;
            case 8:printf((d>0 && d<=31)?"SI\n":"NO\n");break;
            case 9:printf((d>0 && d<=30)?"SI\n":"NO\n");break;
            case 10:printf((d>0 && d<=31)?"SI\n":"NO\n");break;
            case 11:printf((d>0 && d<=30)?"SI\n":"NO\n");break;
            case 12:printf((d>0 && d<=31)?"SI\n":"NO\n");break;
            default:cout<<"NO"<<endl;break;
        }
    }
    return 0;
}
