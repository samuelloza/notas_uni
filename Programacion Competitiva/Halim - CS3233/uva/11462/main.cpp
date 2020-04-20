#include <iostream>
#include <algorithm>
#include <queue>

using namespace std;
int main()
{
    int n,m=0,i,tam,t2;
    cin>>n;
    priority_queue<int, deque<int>, greater<int> > p;
    while(n!=0)
    {
        double vec[n+1];
        t2=tam=n;
        i=0 ;
        int le=0;
        while(t2--)
        {
            cin>>le;
            p.push(le);
        }
        bool sw=false;
        while (! p.empty() )
        {
            cout << p.top();
            p.pop();
            if(!p.empty())
                cout<<" ";
        }
        cout<<endl;
        cin>>n;
    }
    return 0;
}
