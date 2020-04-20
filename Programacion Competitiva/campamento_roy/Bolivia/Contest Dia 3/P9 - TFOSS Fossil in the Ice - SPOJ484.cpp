#include <iostream>
#include <vector>
#include <string>
#include <algorithm>
#include <cmath>

using namespace std;

#define EPS 1e-8
#define PI acos(-1)
#define Vector Point

struct Point
{
    long long x, y;
    Point(){}
    Point(long long a, long long b) { x = a; y = b; }
    long long mod2() { return x*x + y*y; }
    long long mod()  { return sqrt(x*x + y*y); }
    long long arg()  { return atan2(y, x); }
    Point ort()   { return Point(-y, x); }
    Point unit()  { long long k = mod(); return Point(x/k, y/k); }
};

Point operator +(const Point &a, const Point &b) { return Point(a.x + b.x, a.y + b.y); }
Point operator -(const Point &a, const Point &b) { return Point(a.x - b.x, a.y - b.y); }
Point operator /(const Point &a, long long k) { return Point(a.x/k, a.y/k); }
Point operator *(const Point &a, long long k) { return Point(a.x*k, a.y*k); }

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

//### FUNCIONES BASICAS #############################################################

long long dist(const Point &A, const Point &B)    { return hypot(A.x - B.x, A.y - B.y); }
long long cross(const Vector &A, const Vector &B) { return A.x * B.y - A.y * B.x; }
long long dot(const Vector &A, const Vector &B)   { return A.x * B.x + A.y * B.y; }
long long area(const Point &A, const Point &B, const Point &C) { return cross(B - A, C - A); }

vector <Point> ConvexHull(vector <Point> P)
{
    sort(P.begin(),P.end());
    int n = P.size(),k = 0;
    Point H[2*n];
    
    for(int i=0;i<n;++i){
        while(k>=2 && area(H[k-2],H[k-1],P[i]) <= 0) --k;
        H[k++] = P[i];
    }
    
    for(int i=n-2,t=k;i>=0;--i){
        while(k>t && area(H[k-2],H[k-1],P[i]) <= 0) --k;
        H[k++] = P[i];
    }
    
    return vector <Point> (H,H+k-1);
}

vector <Point> P;

int main()
{
    ios::sync_with_stdio(0);
    
    int nCasos;
    cin>>nCasos;
    
    for(int caso=1; caso<=nCasos; caso++)
    {
        int n;
        cin>>n;
        
        P = vector <Point> (n);
        for(int i=0; i<n; i++)
            cin>>P[i].x>>P[i].y;
        
        P = ConvexHull(P);
        n = P.size();
        
        long long maxD = 0;
        
        if(n == 1) maxD = 0;
        else if(n == 2) maxD = (P[0]-P[1]).mod2();
        else
        {
            for(int i=0, j=2; i<n; i++)
            {
                while(area(P[i], P[(i+1)%n], P[(j+1)%n]) > area(P[i], P[(i+1)%n], P[j])) j = (j+1)%n;
                
                maxD = max(maxD, (P[i]-P[j]).mod2());
                maxD = max(maxD, (P[(i+1)%n]-P[j]).mod2());
            }
        }
        cout<<maxD<<endl;
    }
    
    return 0;
}
