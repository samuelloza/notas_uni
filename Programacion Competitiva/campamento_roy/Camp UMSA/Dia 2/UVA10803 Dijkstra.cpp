#include <iostream>
#include <sstream>
#include <set>
#include <map>
#include <vector>
#include <string>
#include <cstdio>
#include <cmath>
#include <algorithm>
#include <queue>
#include <cstring>

using namespace std;

struct nodo
{
    int ind;
    double dist;
    nodo() {};
    nodo(int n1, double n2)
    {
        ind = n1;
        dist = n2;
    }
};

bool operator <(nodo a, nodo b)
{
    return a.dist > b.dist;
}

double adj[100][100], D[100][100];

bool visited[100];

int main()
{
    int nCasos;
    cin>>nCasos;
    
    for(int caso=1; caso<=nCasos; caso++)
    {
        int n;
        cin>>n;
        
        int x[n], y[n];
        
        for(int i=0; i<n; i++)
            cin>>x[i]>>y[i];
        
        for(int i=0; i<n; i++)
        {
            for(int j=0; j<n; j++)
            {
                if(i == j) adj[i][j] = 0;
                else
                {
                    double d = hypot(x[i]-x[j] , y[i]-y[j]);
                    
                    if(d <= 10) adj[i][j] = d;
                    else adj[i][j] = 1.0e10;
                }
            }
        }
        
        for(int i=0; i<n; i++)
            for(int j=0; j<n; j++)
                D[i][j] = 1.0e10;
                
        for(int i=0; i<n; i++)
        {
            memset(visited, 0, sizeof(visited));
            
            priority_queue <nodo> Q;
            Q.push(nodo(i, 0));
            
            while(!Q.empty())
            {
                nodo q = Q.top();
                Q.pop();
                
                int ind = q.ind;
                double dist = q.dist;
                if(visited[ind]) continue;
                
                visited[ind] = 1;
                D[i][ind] = dist;
                
                for(int j=0; j<n; j++)
                    if(adj[ind][j] < 1e10 && !visited[j])
                        Q.push(nodo(j, dist + adj[ind][j]));
            }
        }
        
        double maxD = 0.0;
        for(int i=0; i<n; i++)
            for(int j=0; j<n; j++)
                maxD = max(maxD, D[i][j]);

        cout<<"Case #"<<caso<<":"<<endl;
        
        if(maxD>99999) cout<<"Send Kurdy\n\n";
        else printf("%.4lf\n\n", maxD);
        
    }
    
    return 0;
}
