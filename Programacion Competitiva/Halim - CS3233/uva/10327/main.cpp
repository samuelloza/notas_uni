#include <iostream>

using namespace std;

int main()
{
    int n,i=0,swp=0;
    while(cin>>n)
    {
        i=n;
        int vec[n];
        swp=0;
        while(i--)
        {
            cin>>vec[swp];
            swp++;
        }
        int cont=0;
        bool sw=false;
        for(i=0; i<swp; i++)
        {
            for(int j=i+1; j<n; j++)
            {
                if(vec[i]>vec[j])
                {
                    int mip=vec[i];
                    vec[i]=vec[j];
                    vec[j]=mip;
                    sw=true;
                }
            }
            if(sw)
                cont++;
            sw=false;

        }
        cout<<"Minimum exchange operations : "<<cont<<endl;

    }

    return 0;
}
