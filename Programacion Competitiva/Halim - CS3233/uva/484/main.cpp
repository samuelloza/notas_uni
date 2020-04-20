#include <stdio.h>
#define max 10000
using namespace std;
int i=0;long vec[max];int vec2[max];
int solved(long cad) {
    for(int ii=0; ii<i; ii++) {
        if(vec[ii]==cad) {
            vec2[ii]++;
            return 0;
        }} vec[i]=cad;vec2[i]++;i++;return 0;
}
int main() {
    long cad;
    scanf("%ld",&cad);
    vec[i]=cad;vec2[i]++;i++;
    while(scanf("%ld",&cad)){solved(cad);}
    for(int j=0; j<i; j++){printf("%ld %d\n",vec[j],vec2[j]);}
    return 0;
}
