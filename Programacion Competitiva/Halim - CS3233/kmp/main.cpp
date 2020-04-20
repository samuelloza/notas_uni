// C++ code of KMP String Matching Algorithm
#include<cstdio>
#include<cstring>
#include<string>
#include<iostream>
#include<algorithm>
#define max 100001
using namespace std;
void FailureFunction(char P[], int F[],int m)
{
    int i,j;
    F[0]=0;	//  assignment is important!
    j=0;
    i=1;
    while(i<m)  // that i is less than the length of pattern
    {
        if(P[i]==P[j])
        {
            F[i]=j+1;
            i++;
            j++;
        }
        else if(j>0)
        {
            j=F[j-1];
        }
        else
        {
            F[i]=0;
            i++;
        }
    }
}

int KMP(char T[], char P[])
{
    int i,j,F[max+1];	// the maximum size of Pattern String
    int m=strlen(P);
    int n=strlen(T);
    FailureFunction(P,F,m);
    i=0;
    j=0;
    while(i<n)
    {
        if(T[i]==P[j])
        {
            if(j==m-1)
                return i-j; // means, in (i-j)th position, there is a match occur
            else
            {
                i++;
                j++;
            }
        }
        else if(j>0)
        {
            j=F[j-1];
        }
        else
        {
            i++;
        }
    }
    return -1; // No match found
}

int main()
{
    int n=0;
    cin>>n;
    while(n--)
    {
        char T[max+1],P[1000+1];
        cin>>T;
        int j;
        cin>>j;
        while(j--)
        {
            cin>>P;
            int pos=KMP(T,P);
            if(pos!=-1)
                cout<<"y"<<endl;
            else
                cout<<"n"<<endl;
        }
    }
    return 0;
}
