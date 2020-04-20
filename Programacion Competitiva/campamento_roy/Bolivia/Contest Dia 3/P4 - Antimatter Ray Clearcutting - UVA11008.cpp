#include <iostream>
#include <vector>
#include <string>
#include <algorithm>
#include <sstream>
#include <set>
#include <map>
#include <queue>
#include <deque>
#include <stack>
#include <list>
#include <bitset>
#include <cstdio>
#include <cmath>
#include <cstdlib>
#include <ctime>
#include <cfloat>
#include <cstring>

using namespace std;
#define EPS 1e-8
#define PI acos(-1)
#define Vector Point

struct Point
{
    double x, y;
    Point(){}
    Point(double a, double b) { x = a; y = b; }
    double mod2() { return x*x + y*y; }
    double mod()  { return sqrt(x*x + y*y); }
    double arg()  { return atan2(y, x); }
    Point ort()   { return Point(-y, x); }
    Point unit()  { double k = mod(); return Point(x/k, y/k); }
};

Point operator +(const Point &a, const Point &b) { return Point(a.x + b.x, a.y + b.y); }
Point operator -(const Point &a, const Point &b) { return Point(a.x - b.x, a.y - b.y); }
Point operator /(const Point &a, double k) { return Point(a.x/k, a.y/k); }
Point operator *(const Point &a, double k) { return Point(a.x*k, a.y*k); }

bool operator ==(const Point &a, const Point &b)
{
    return fabs(a.x - b.x) < EPS && fabs(a.y - b.y) < EPS;
}
bool operator !=(const Point &a, const Point &b)
{
    return !(a==b);
}
bool operator <(const Point &a, const Point &b)
{
    if(a.x != b.x) return a.x < b.x;
    return a.y < b.y;
}

double dist(const Point &A, const Point &B)    { return hypot(A.x - B.x, A.y - B.y); }
double cross(const Vector &A, const Vector &B) { return A.x * B.y - A.y * B.x; }
double dot(const Vector &A, const Vector &B)   { return A.x * B.x + A.y * B.y; }
double area(const Point &A, const Point &B, const Point &C) { return cross(B - A, C - A); }

int n, m;

Point P[20];
int memo[1<<16];

int f(int mask)
{
    int &x = memo[mask];
    
    if(x != -1) return x;
    else
    {
        int q = __builtin_popcount(mask);
        
        if(n - q >= m) return x = 0;
        else if(q == 1) return x = 1;
        else
        {
            x = 1<<30;
            
            for(int i=0; i<n; i++)
            {
                if((mask & (1<<i)) == 0) continue;
                
                for(int j=0; j<i; j++)
                {
                    if((mask & (1<<j)) == 0) continue;
                    
                    int nmask = mask;
                    for(int k=0; k<n; k++)
                        if((mask & (1<<k)) && area(P[i], P[j], P[k]) == 0)
                            nmask ^= (1<<k);
                    
                    x = min(x, 1 + f(nmask));
                }
            }
            
            return x;
        }
    }
}

int main()
{
    int nCasos;
    cin>>nCasos;
    
    for(int caso = 1; caso <= nCasos; caso++)
    {
        cin>>n>>m;
        
        for(int i=0; i<n; i++)
            cin>>P[i].x>>P[i].y;
        
        if(caso > 1) cout<<endl;
        cout<<"Case #"<<caso<<":"<<endl;
        
        memset(memo, -1, sizeof(memo));
        cout<<f((1<<n)-1)<<endl;
    }
    
    return 0;
}
