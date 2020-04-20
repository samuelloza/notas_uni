#include <iostream>

using namespace std;

bool esvocal(char ch)
{
    ch = tolower(ch);

    if(ch == 'a' || ch == 'e' || ch == 'i' ||
       ch == 'o' || ch == 'u' || ch == 'y') return 1;
    else return 0;
}
int main()
{
    string s, ans = "";
    cin>>s;

    for(int i=0; i<s.size(); i++)
    {
        if(!esvocal(s[i]))
        {
            ans += '.';
            ans += tolower(s[i]);
        }
    }
    cout<<ans<<endl;

    return 0;
}
