#include <iostream>
#include <vector>
#include <string>
#include <cstring>
#include <algorithm>
#include <queue>

using namespace std;

struct nodo
{
    int r, c;
    int d;
    
    nodo(int n1, int n2, int n3)
    {
        r = n1;
        c = n2;
        d = n3;
    }
};

bool visited[1000][1000];
bool M[1000][1000];

int dr[4]={0, 0, 1, -1};
int dc[4]={1, -1, 0, 0};

int R, C;

bool valid(int r, int c)
{
    return r >= 0 && r < R && c >= 0 && c < C;
}

int main()
{
    while(cin>>R>>C)
    {
        if(R==0 && C==0) break;
        
        memset(M, 0, sizeof(M));
        
        int n;
        cin>>n;
        
        for(int i=0; i<n; i++)
        {
            int r, num;
            cin>>r>>num;
            
            for(int j=0; j<num; j++)
            {
                int c;
                cin>>c;
                M[r][c] = 1;
            }
        }
        
        int r0, c0;
        cin>>r0>>c0;
        
        int rx, cx;
        cin>>rx>>cx;
		
		memset(visited, 0, sizeof(visited));
		
		queue <nodo> Q;
		Q.push(nodo(r0, c0, 0));
		visited[r0][c0] = 1;
		
		while(!Q.empty())
		{
			nodo q = Q.front();
			Q.pop();
			
			int r = q.r, c = q.c, d = q.d;
			
            if(r == rx && c == cx)
            {
                cout<<d<<endl;
                break;
            }
            
            for(int k=0; k<4; k++)
            {
                int nr = r + dr[k];
                int nc = c + dc[k];
                if(valid(nr, nc) && M[nr][nc] == 0 && !visited[nr][nc])
                {
                    visited[nr][nc] = 1;
                    Q.push(nodo(nr, nc, d+1));
                }
            }
		}
    }
    return 0;
}
