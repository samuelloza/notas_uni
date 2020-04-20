#include<math.h>
#include<string>
#include<iostream>
#include<stdio.h>
using namespace std;
int main() {
    long double n,p;
    while(scanf("%llf%llf",&n,&p)==2) {
        printf("%.0llf\n",(long double)pow(10,log10(p)/n));
    }
    return 0;
}


