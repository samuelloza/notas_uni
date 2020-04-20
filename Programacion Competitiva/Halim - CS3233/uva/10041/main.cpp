#include <iostream>
#include <algorithm>
#include <cstdio>
using namespace std;
int main() {
    int n;
    cin>>n;
    while(n--) {
        int m;
        cin>>m;
        int vec[m+1];
        for(int i=0; i<m; i++) {
            cin>>vec[i];
        }
        sort(vec,vec+m);
        int met=m>>1;
        int su=0,so=0;
        for(int i=0; i<m ; i++) {
            su+=abs(vec[met]-vec[i]);
        }
        cout<<su<<endl;
    }
    return 0;
}
