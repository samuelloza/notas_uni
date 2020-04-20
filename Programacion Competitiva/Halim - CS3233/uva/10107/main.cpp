#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;
vector <long long int >a;
long long int contar() {
    long long int s;
    vector<long long int>::iterator it;
    int lim=a.size()/2;
    int j;
    for(it=a.begin(),j=0; j<lim; j++) {
        it++;
    }
    return s=*it;;
}
long long int contar2() {
    long long int s;
    vector<long long int>::iterator it;
    int lim=a.size()/2;
    int j;
    for(it=a.begin(),j=0; j<lim-1; j++) {
        it++;
    }
    s=*it;
    it++;
    s+=*it;
    return s/2;
}
int main() {
    long long int num;
    int i=1;
    while(cin>>num) {
        a.push_back(num);
        if(i==1) {
            cout<<num<<endl;
        } else {
            sort(a.begin(),a.end());
            if(i%2==0) {
                cout<<(int) contar2()<<endl;;
            } else {
                cout<<(int)contar()<<endl;
            }
        }
        i++;
    }
    return 0;
}
