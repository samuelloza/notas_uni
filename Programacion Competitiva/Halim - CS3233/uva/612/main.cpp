#include <iostream>
#include <algorithm>
#include <stdio.h>
#include <cstring>


using namespace std;

struct dna
{
    char* nombre;
    int tam;
};
bool com(dna a, dna b)
{
    return a.tam>b.tam;
}

int main()
{
    int a,b;
    cin>>a>>b;
    int con=0;
    char* x;
    char s[2024];
    dna vec[b+1];
    for(int j=0; j<b; j++)
    {
        cin>>s;
        x=s;
        vec[j].nombre=x;
        char aux=*x;
        x++;
        for(int i=0; i<a; i++)
        {
            if(aux>*x)
            {
                con++;
            }
            aux=*x;
            x++;
        }
        vec[j].tam=con;
        con=0;

    }
    sort(vec,vec+a,com);
    for(int i=0; i<a; i++)
    {
        cout<<vec[i].nombre<<endl;
    }
    return 0;
}
