#include <iostream>
#include <cstdio>
using namespace std;
int main()
{
    char a;
    bool sw=true;
    while((a=getchar())!=EOF)
    {
        if(a=='"')
        {
            if(sw)
            {
                cout<<"``";
                sw=false;
            }
            else
            {
                cout<<"''";
                sw=true;
            }
        }
        else
            cout<<a;
    }
    return 0;
}

