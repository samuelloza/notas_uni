#include <iostream>

using namespace std;

string tolower(string s)
{
    for(int i=0; i<s.size(); i++)
        s[i] = tolower(s[i]);
    return s;
}

int main()
{
    string s1, s2;
    cin>>s1>>s2;

    s1 = tolower(s1);
    s2 = tolower(s2);

    if(s1 < s2) cout<<-1<<endl;
    else if(s1 == s2) cout<<0<<endl;
    else cout<<1<<endl;

    return 0;
}
