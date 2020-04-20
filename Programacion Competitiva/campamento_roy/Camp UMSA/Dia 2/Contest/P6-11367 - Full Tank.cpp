#include <iostream>
#include <vector>
#include <queue>
#include <cstring>
#include <bitset>

#define MAXN 1000
#define MAXC 100

using namespace std;

int p[MAXN];

vector <int> adj[MAXN];
vector <int> dist[MAXN];

struct nodo
{
    int ind, fuel;
    int totalCost;
    nodo() {}
    nodo(int n1, int n2, int n3)
    {
        ind = n1;
        fuel = n2;
        totalCost = n3;
    }
};

bool operator <(nodo a, nodo b)
{
    return a.totalCost > b.totalCost;
}

int main()
{
    int n, m;
    cin>>n>>m;
    
    for(int i=0; i<n; i++)
        cin>>p[i];
    
    for(int i=0; i<m; i++)
    {
        int u, v, d;
        cin>>u>>v>>d;
        
        adj[u].push_back(v);
        dist[u].push_back(d);
        
        adj[v].push_back(u);
        dist[v].push_back(d);
    }
    
    int nQuerys;
    cin>>nQuerys;
    
    for(int qq=0; qq<nQuerys; qq++)
    {
        int c, s, e;
        cin>>c>>s>>e;
        
        bitset <101> visited[n];
        
        bool ok = 0;
        
        priority_queue <nodo> Q;
        Q.push(nodo(s, 0, 0));
        
        while(!Q.empty())
        {
            nodo q = Q.top();
            Q.pop();
            
            int ind = q.ind, fuel = q.fuel, totalCost = q.totalCost;
            if(visited[ind][fuel]) continue;
            
            if(ind == e)
            {
                cout<<totalCost<<endl;
                ok = 1;
                break;
            }
            
            visited[ind][fuel] = 1;
            
            if(fuel < c)
            {
                if(!visited[ind][fuel + 1])
                {
                    Q.push(nodo(ind, fuel+1, totalCost + p[ind]));
                }
            }
            
            for(int i=0; i<adj[ind].size(); i++)
            {
                if(fuel >= dist[ind][i])
                {
                    int nind = adj[ind][i];
                    int nfuel = fuel - dist[ind][i];
                    
                    if(!visited[nind][nfuel])
                    {
                        Q.push(nodo(nind, nfuel, totalCost));
                    }
                }
            }
        }
        if(!ok) cout<<"impossible"<<endl;
    }
    
    return 0;
}
