#include <iostream>
#include <vector>
#include <string>
#include <algorithm>
#include <cmath>
#include <cstdio>

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

//### FUNCIONES BASICAS #############################################################

double dist(const Point &A, const Point &B)    { return hypot(A.x - B.x, A.y - B.y); }
double cross(const Vector &A, const Vector &B) { return A.x * B.y - A.y * B.x; }
double dot(const Vector &A, const Vector &B)   { return A.x * B.x + A.y * B.y; }
double area(const Point &A, const Point &B, const Point &C) { return cross(B - A, C - A); }

double dist(const Point &A, const Point &P, const Point &Q)
{
    return abs(area(A, P, Q)) / (P-Q).mod();
}

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

int n;
vector <Point> P;

int main()
{
    ios::sync_with_stdio(0);
    
    while(cin>>n)
    {
        if(n == 0) break;
        
        P = vector <Point> (n);
        for(int i=0; i<n; i++)
            cin>>P[i].x>>P[i].y;
        
        P = ConvexHull(P);
        n = P.size();
        
        double minA = 1e200, minP = 1e200;
        
        int w = 0;
        while(area(P[w], P[w] + (P[1]-P[0]).ort(), P[(w+n-1)%n]) > 0) w = (w+n-1)%n;
        
        for(int i=0, j=2, k=1; i<n; i++)
        {
            Vector V = (P[(i+1)%n]-P[i]).ort();
            
            while(area(P[i], P[(i+1)%n], P[(j+1)%n]) > area(P[i], P[(i+1)%n], P[j])) j = (j+1)%n;
            while(area(P[k], P[(k+1)%n], P[k] + V) > 0) k = (k+1)%n;
            while(area(P[w], P[w] + V, P[(w+1)%n]) > 0) w = (w+1)%n;
            
            double A = dist(P[j], P[i], P[(i+1)%n]);
            double B = dist(P[k], P[w], P[w] + V);
            
            minP = min(minP, 2*(A + B));
            minA = min(minA, A*B);
        }
        
        printf("%.2lf %.2lf\n", minA, minP);
    }
    
    return 0;
}
