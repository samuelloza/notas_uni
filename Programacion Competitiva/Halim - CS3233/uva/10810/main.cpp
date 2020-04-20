#include <iostream>

using namespace std;

int main() {
    int n,nn,i=0;
    cin>>n;
    nn=n;
    while(true) {
        long long int vec[nn+1];
        while(n--) {
            cin>>vec[i];
            i++;
        }
        i=0;
        int conta=0;
        for(int j=0; j<nn; j++) {
            for(int j2=j+1; j2<nn; j2++) {
                if(vec[j]>vec[j2]) {
                    conta++;
                }

            }
        }
        cout<<conta;
        cin>>n;
        if(n!=0) {
            nn=n;
            i=0;
        } else break;
    }
    return 0;
}


