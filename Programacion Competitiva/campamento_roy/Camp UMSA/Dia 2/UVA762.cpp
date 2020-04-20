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

using namespace std;

int main()
{
    int n;
    bool primero=true;
    
    while(cin>>n)
    {
        if(!primero) cout<<endl;
        else primero=false;
        
        map <string, vector <string> > adj;
        
        for(int i=0; i<n; i++)
        {
            string a, b;
            cin>>a>>b;
            adj[a].push_back(b);
            adj[b].push_back(a);
        }
        
        string inicio, fin;
        cin>>inicio>>fin;
        
        map <string, bool> visited;
        
        map <string, string> padre;
        
        queue <string> Q;
        Q.push(inicio);
        visited[inicio]=true;
        
        while(!Q.empty())
        {
            string q = Q.front();
            Q.pop();
            
            if(q==fin) break;
            
            vector <string> dest = adj[q];
            
            for(int i=0; i<dest.size(); i++)
            {
                if(!visited[dest[i]])
                {
                    Q.push(dest[i]);
                    visited[dest[i]]=true;
                    padre[dest[i]] = q;
                }
            }
        }
        
        if(padre[fin]=="") cout<<"No route"<<endl;
        else
        {
            vector <string> path;
            
            string pos = fin;

            while(pos != "")
            {
                path.push_back(pos);
                pos = padre[pos];
            }
            reverse(path.begin(), path.end());
            
            for(int i=0; i<path.size()-1; i++)
                cout<<path[i]<<" "<<path[i+1]<<endl;
        }
    }
    return 0;
}
