#include <iostream>

using namespace std;

int main()
{
    int n=0;
    cin>>n;
    while(n--)
    {
        int max,rep=0;
        cin>>max>>rep;
        while(rep--)
        {
            bool sw=true;
            int i=1,j=0,k=0;
            while(k<(max*2)-1)
            {
                j=0;
                while(j<i)
                {
                    cout<<i;
                    j++;
                }
                cout << endl;
                if(sw)
                    i++;
                else
                    i--;
                if(k==max-2)
                    sw=false;
                k++;
            }
            if(rep>=1)
                cout<<endl;
        }
        if(n>=1)
            cout<<endl;

    }
    return 0;
}
