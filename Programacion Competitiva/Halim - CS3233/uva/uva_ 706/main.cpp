#include <iostream>
using namespace std;

void largo(int n)
{
    for(int i=0; i<n; i++)
        cout<<"-";
}
void espacios(int n)
{
    for(int i=0; i<n; i++)
        cout<<" ";
}
void abajo(int n)
{
    for(int i=0; i<n; i++)
    {
        cout<<"|";
        espacios(n);
        cout<<"|";
        cout<<endl;
    }
}

void numeros(int n)
{
    int tam;
    cin>>tam;
    switch(n)
    {
    case 0:
        espacios(1);
        largo(tam);
        espacios(1);
        cout<<endl;
        abajo(tam);
        cout<<endl;
        abajo(tam);
        espacios(1);
        largo(tam);
        break;
    case 1:
    espacios(tam);
    abajo(tam);
    default:
        break;
    }

}
int main()
{
    cout << "Hello world!" << endl;
    numeros(1);
    return 0;
}
