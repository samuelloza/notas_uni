#include <vector>
#include <string>
#include <map>
#include <set>
#include <queue>
#include <algorithm>
#include <sstream>
#include <iostream>
#include <cstdio>
#include <cmath>
#include <cstdlib>
#include <cstring>

#define all(v) (v).begin(), (v).end()

using namespace std;

vector <string> grid;
bool visited[100][100];
bool usado[100][100];

int n;

int dx[4]={0, 0, 1, -1};
int dy[4]={1, -1, 0, 0};

void punto(int a, int b)
{
    usado[a][b]=1;
    
    for(int i=0; i<4; i++)
    {
        int I = a + dx[i];
        int J = b + dy[i];
        
        if(I>=0 && I<grid.size() && J>=0 && J<grid[I].size() && !usado[I][J] && grid[I][J]=='X')
            punto(I, J);
    }      
}

void dfs(int a, int b)
{
    if(grid[a][b]=='X' && !usado[a][b])
    {
        punto(a, b);
        n++;
    }
    
    visited[a][b]=1;
    
    for(int i=0; i<4; i++)
    {
        int I = a + dx[i];
        int J = b + dy[i];
        
        if(I>=0 && I<grid.size() && J>=0 && J<grid[I].size() && !visited[I][J] && grid[I][J]!='.')
            dfs(I, J);
    }
}

int main()
{
    int R, C;
    int caso=0;
    
    while(cin>>C>>R)
    {
        caso++;
        
        if(C==0 && R==0) break;
        
        grid.clear();
        memset(visited, 0, sizeof(visited));
        memset(usado, 0, sizeof(usado));
        
        for(int i=0; i<R; i++)
        {
            string s;
            cin>>s;
        
            grid.push_back(s);
        }
        
        vector <int> x;
        
        for(int i=0; i<grid.size(); i++)
        {
            for(int j=0; j<grid[i].size(); j++)
            {
                if(grid[i][j]!='.' && !visited[i][j])
                {
                    n=0;
                    dfs(i, j);
                    x.push_back(n);
                }
            }
        }
        
        sort(all(x));
        
        cout<<"Throw "<<caso<<endl;
        
        for(int i=0; i<x.size(); i++)
        {
            if(i!=0) cout<<" ";
            cout<<x[i];
        }
        cout<<endl<<endl;
    }
    return 0;
}
