#include <iostream>

using namespace std;

int lucky[14] = {4, 7, 44, 47, 74, 77,
                444, 447, 474, 477,
                744, 747, 774, 777};

int main()
{
    int n;
    cin>>n;

    bool almost = 0;
    for(int i=0; i<14; i++)
        if(n % lucky[i] == 0)
            almost = 1;

    if(almost) cout<<"YES"<<endl;
    else cout<<"NO"<<endl;

    return 0;
}
