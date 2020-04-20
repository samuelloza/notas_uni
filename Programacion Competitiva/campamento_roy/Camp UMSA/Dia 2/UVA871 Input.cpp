#include <iostream>
#include <sstream>
#include <set>
#include <map>
#include <vector>
#include <string>
#include <cstdio>
#include <cmath>
#include <algorithm>

using namespace std;

vector <string> M;

// ....

int main()
{
    int nCasos;
    cin>>nCasos;
    
    string s;
    getline(cin, s);
    getline(cin, s);
    
    for(int caso=1; caso<=nCasos; caso++)
    {
        if(caso != 1) cout<<endl;
           
        M.clear();
        
        while(getline(cin, s))
        {
            if(s=="") break;
            M.push_back(s);
        }
        
        
        //....
        
        //cout<<maxN<<endl;
    }
    
    return 0;
}
