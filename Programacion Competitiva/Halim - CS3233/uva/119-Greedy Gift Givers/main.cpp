#include <iostream>
using namespace std;
static  string nombres[100];
static  int inicio[100];
static int fin[100];
int main()
{
    int casos;
    cin>>casos;
    int ggg=0;
    for(int i=0; i<casos; i++)
    {
        inicio[i]=0;
        fin[i]=0;
        nombres[i]="";
        cin>>nombres[i];

    }
    string nom;
    int monto;
    int amig;

    while(ggg<casos)
    {
        cin>>nom;
        cin>>monto;
        cin>>amig;
        for(int i=0; i<casos; i++)
        {
            if(nom.compare(nombres[i])==0)
            {
                inicio[i]=monto;
                fin[i]+=monto%amig;
                break;
            }
        }

        string idam;
        int r=monto/amig;
        for(int i=0; i<amig; i++)
        {
            cin>>idam;
            for(int j=0; j<casos; j++)
            {
                if(idam.compare(nombres[j])==0)
                {
                    fin[j]+=r;
                }
            }

        }
        ggg++;
    }
    cout<<"--"<<nombres[0]<<endl;
    for (int i = 0; i < casos; i++)
    {
        //  cout<<nombres[i] << " " << inicio[i]<<" "<<fin[i]<<endl;
    }


    return 0;
}
