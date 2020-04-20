#include<cstdio>
using namespace std;
int main() {
    int t,cs=0;
    scanf("%d",&t);
    int n,temp=0,i,j;
    while(t--) {
        n=temp=i=j=0;
        scanf("%d",&j);
        for(i=0; i<j; i++) {
            scanf("%d",&n);
            if(n>temp)temp=n;
        }
        printf("Case %d: %ld\n",++cs,temp);
    }
    return 0;
}
