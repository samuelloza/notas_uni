#include <string.h>
#include <iostream>
#include<algorithm>
#include<stdio.h>

using namespace std;
int main(void) {
    string s;
    char x ;

    while(cin>>s) {
        x=getchar();
        string s2(s.rbegin(),s.rend());
        cout<<s2;
        putchar(x);
    }
    return 0;
}
