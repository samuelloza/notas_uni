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

double adj[100][100];
int x[100], y[100];

int main()
{
    int nCasos;
    cin>>nCasos;
    
    for(int caso=1; caso<=nCasos; caso++)
    {
        int n;
        cin>>n;
        
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
        
        for(int k=0; k<n; k++)
            for(int i=0; i<n; i++)
                for(int j=0; j<n; j++)
                    adj[i][j] = min(adj[i][j], adj[i][k] + adj[k][j]);
                    
        double maxD = 0.0;
        for(int i=0; i<n; i++)
            for(int j=0; j<n; j++)
                maxD = max(maxD, adj[i][j]);
        
        cout<<"Case #"<<caso<<":"<<endl;
        
        if(maxD>99999) cout<<"Send Kurdy\n\n";
        else printf("%.4lf\n\n", maxD);
        
    }
    
    return 0;
}
