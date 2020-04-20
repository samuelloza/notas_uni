#include<iostream>
#include<fstream>
#define FOR(i,a,b) for(int i=a;i<b;i++)
using namespace std;
int num(char c){
    if(c=='a' || c=='d' || c=='g' || c=='j' || c=='m'|| c=='p'|| c=='t'|| c=='w')
        return 1;
    if(c=='b' || c=='e' || c=='h' || c=='k' || c=='n'|| c=='q'|| c=='u'|| c=='x')
        return 2;
    if(c=='c' || c=='f' || c=='i' || c=='l' || c=='o'|| c=='r'|| c=='v'|| c=='y')
        return 3;
    if(c=='s' || c=='z')
        return 4;
    return 0;
}
int tecla(char c){
    if(c=='a' || c=='b' || c=='c')
        return 2;
    if(c=='d' || c=='e' || c=='f')
        return 3;
    if(c=='g' || c=='h' || c=='i')
        return 4;
    if(c=='j' || c=='k' || c=='l')
        return 5;
    if(c=='m' || c=='n' || c=='o')
        return 6;
    if(c=='p' || c=='q' || c=='r' || c=='s')
        return 7;
    if(c=='t' || c=='u' || c=='v')
        return 8;
    if(c=='w' || c=='x' || c=='y' || c=='z')
        return 9;
    return 0;
}
int main(){
    ifstream cin ("entrada.txt");
    ofstream cout("salida.txt");
    int n;
    string s;
    cin>>n;
    while(n--){
        cin>>s;
        FOR(i,0,s.size()){
            int m=num(s[i]);
            while(m--){
                cout<<tecla(s[i]);
            }
        }
        cout<<endl;
    }
}
