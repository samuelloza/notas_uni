#include <iostream>

using namespace std;

int main()
{
    string s;
    cin>>s;

    bool todoMayuscula = 1;
    for(int i=0; i<s.size(); i++)
        if(islower(s[i]))
            todoMayuscula = 0;

    if(todoMayuscula)
    {
        for(int i=0; i<s.size(); i++)
            s[i] = tolower(s[i]);
        cout<<s<<endl;
    }
    else{
        bool caso2 = 1;
        if(isupper(s[0])) caso2 = 0;
        for(int i=1; i<s.size(); i++)
            if(islower(s[i]))
                caso2 = 0;
        if(caso2)
        {
            s[0] = toupper(s[0]);
            for(int i=1; i<s.size(); i++)
                s[i] = tolower(s[i]);
            cout<<s<<endl;
        }
        else cout<<s<<endl;
    }
    return 0;
}
