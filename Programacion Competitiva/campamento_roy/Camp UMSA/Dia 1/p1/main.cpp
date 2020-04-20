#include <iostream>
#include <vector>

using namespace std;

int main()
{
    char maxCh = 'a';
    string s;
    cin>>s;
    for(int i=0; i<s.size(); i++)
        maxCh = max(maxCh, s[i]);
    int cnt = 0;
    for(int i=0; i<s.size(); i++)
        if(s[i] == maxCh)
            cnt++;
    cout<<string(cnt, maxCh)<<endl;
    return 0;
}
