#include<iostream>
#include<string>
#include<map>
#include<cstdio>
using namespace std;
const int kMaxn(2007);

int main()
{
    int n;
    cin>>n;
    map<string,int> r;
    for(int i=1;i<=n;i++)
    {
        string country,t;
        cin>>country;
        r[country]++;
        getchar();
        getline(cin,t);
    }

    for(map<string,int>::iterator i=r.begin();i!=r.end();i++)
        cout<<i->first<<" "<<i->second<<endl;

    return 0;
}
