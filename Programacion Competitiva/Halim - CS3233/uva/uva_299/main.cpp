#include <iostream>

using namespace std;

int main()
{
    int casos;
    cin>>casos;
    while(casos--)
    {
        int t;
        cin>>t;
        int vec[t+1];
        for(int i=0; i<t; i++)
        {
            cin>>vec[i];
        }
        //ordenando
        int cont=0;
        for(int ii=0; ii<t-1; ii++)
        {
            for(int ii2=ii+1; ii2<t; ii2++)
            {
                if(vec[ii]>vec[ii2])
                {
                    int aux=vec[ii];
                    vec[ii]=vec[ii2];
                    vec[ii2]=aux;
                    cont++;
                }
            }
        }
        cout<<cont<<endl;
    }
    return 0;
}
