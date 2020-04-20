#include <iostream>
#include <cstdio>
#include <climits>
using namespace std;
class hotel {
public :
    int a,b,c,d;
    void solved(int z,int x,int c2,int v) {
        int pre,mini;
        mini=INT_MAX;
        a=z;
        b=x;
        c=c2;
        d=v;
        int vec[d+1];
        while(c2--) {
            cin>>pre;
            for(int i=0; i<d; i++) {
                cin>>vec[i];
                if(vec[i]-a>=0) {
                    int t=(a*pre);
                    if(b>t) {
                        mini=min(t,mini);
                    }
                }
            }
        }

        if(mini!=INT_MAX)
            cout<<mini<<endl;
        else
            cout<<"stay home"<<endl;

    }
};
int main() {
    hotel a;
    int z,x,c,v,b;
    while(cin>>z>>x>>c>>v) {
        a.solved(z,x,c,v);
    }
    return 0;
}
