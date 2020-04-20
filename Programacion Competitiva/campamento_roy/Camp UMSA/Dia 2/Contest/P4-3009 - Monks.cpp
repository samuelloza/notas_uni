#include <iostream>
#include <algorithm>
#include <vector>
#include <queue>
#include <cstdio>
#include <cstring>
#include <bitset>

using namespace std;

struct nodo
{
    int n1, n2;
    int d;
    nodo(int a, int b, int c)
    {
        n1 = a;
        n2 = b;
        d = c;
    }
};

int T;
bitset <751> visited[501];

inline void normalizar(int &n1, int &n2, int &n3)
{
    if(n1 > n2) swap(n1, n2);
    if(n1 > n3) swap(n1, n3);
    if(n2 > n3) swap(n2, n3);
}

inline void encolar(int a, int b, int c, int d, queue <nodo> &Q)
{
    normalizar(a, b, c);
    if(!visited[a][b])
    {
        Q.push(nodo(a, b, d));
        visited[a][b] = 1;
    }
}

int main()
{
    int a, b, c;
    while(scanf("%d %d %d", &a, &b, &c)==3)
    {
        if(!a && !b && !c) break;
        
        printf("%d %d %d ", a, b, c);
        
        T = a + b + c;
        
        for(int i=0; 3*i<=T; i++)
        	visited[i].reset();
        
        queue <nodo> Q;
        encolar(a, b, c, 0, Q);
        
        while(!Q.empty())
        {
            nodo q = Q.front();
            Q.pop();
            
            int n1 = q.n1, n2 = q.n2, n3 = T - n1 - n2, d = q.d;
            
            // n1 <= n2 <= n3
            
            if(n1 == 0) 
            {
                printf("%d\n", d);
                break;
            }
            d++;
            
            encolar(2*n1, n2-n1, n3, d, Q);
            encolar(2*n1, n2, n3-n1, d, Q);
            encolar(n1, 2*n2, n3-n2, d, Q);
        }
    }
}
