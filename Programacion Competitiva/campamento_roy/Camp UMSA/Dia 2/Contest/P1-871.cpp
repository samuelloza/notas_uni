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

vector <string> grid;
bool visited[25][25];

int calc(int a, int b)
{
    visited[a][b]=true;
    
    int n=1;
    for(int i=-1; i<=1; i++)
        for(int j=-1; j<=1; j++)
            if(i!=0 || j!=0)
                if(a+i>=0 && a+i<grid.size() && b+j>=0 && b+j<grid[0].size())
                    if(!visited[a+i][b+j] && grid[a+i][b+j]=='1')
                        n+=calc(a+i, b+j);
    return n;
}

int main()
{
    int n;
    cin>>n;
    
    string s;
    getline(cin, s);
    getline(cin, s);
    
    for(int caso=0; caso<n; caso++)
    {      
        grid.clear();
        
        while(getline(cin, s))
        {
            if(s=="") break;
            grid.push_back(s);
        }
        
        memset(visited, 0, sizeof(visited));
        
        int maxN=0;
        
        for(int i=0; i<grid.size(); i++)
            for(int j=0; j<grid[i].size(); j++)
                if(grid[i][j]=='1' && !visited[i][j]) maxN=max(maxN, calc(i, j));
        
        if(caso!=0) cout<<endl;
        
        cout<<maxN<<endl;
    }
    
    return 0;
}
