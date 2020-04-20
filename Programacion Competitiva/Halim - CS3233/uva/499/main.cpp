#include <iostream>
#include<stdio.h>
#include<string.h>
using namespace std;

int main()
{
    char x=' ';
    string a;
    while(x!=EOF)
    {
        int vec[257]= {0};
        x=getchar();
        if(x==EOF)
        {
            break;
        }
        while(x!='\n')
        {
            if(x!=32)
                vec[x]++;

            x=getchar();
        }
        int mat=0;
        for(int i=65; i<=90; i++)
        {
            if(vec[i]!=0)
            {
                if(vec[i]>mat)
                    mat=vec[i];
            }
        }
        for(int i=97; i<=122; i++)
        {
            if(vec[i]!=0)
            {
                if(vec[i]>mat)
                    mat=vec[i];
            }
        }
        //

        for(int i=65; i<=90; i++)
        {
            if(vec[i]==mat)
            {
                cout<<(char)i;
            }
        }
        for(int i=97; i<=122; i++)
        {
            if(vec[i]==mat)
            {
                cout<<(char)i;
            }
        }
        cout<<" "<<mat<<endl;

    }
    return 0;
}
