#include <iostream>
#include <vector>
#include <string>
#include <algorithm>
#include <cmath>
#include <cstdio>
#include <cassert>

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

bool onSegment(const Point &A, const Point &B, const Point &P)
{
    return abs(area(A, B, P) < EPS) &&
            P.x >= min(A.x, B.x) && P.x <= max(A.x, B.x) &&
            P.y >= min(A.y, B.y) && P.y <= max(A.y, B.y);
}

//### DETERMINA SI EL SEGMENTO P1Q1 SE INTERSECTA CON EL SEGMENTO P2Q2 #####################
bool intersects(const Point &P1, const Point &P2, const Point &P3, const Point &P4)
{
    double A1 = area(P3, P4, P1);
    double A2 = area(P3, P4, P2);
    double A3 = area(P1, P2, P3);
    double A4 = area(P1, P2, P4);
    
    if( ((A1 > 0 && A2 < 0) || (A1 < 0 && A2 > 0)) && 
        ((A3 > 0 && A4 < 0) || (A3 < 0 && A4 > 0))) 
            return true;
    
    else if(A1 == 0 && onSegment(P3, P4, P1)) return true;
    else if(A2 == 0 && onSegment(P3, P4, P2)) return true;
    else if(A3 == 0 && onSegment(P1, P2, P3)) return true;
    else if(A4 == 0 && onSegment(P1, P2, P4)) return true;
    else return false;
}

bool pointInPoly(const vector <Point> &P, const Point &A)
{
    int n = P.size(), cnt = 0;
    for(int i=0; i<n; i++)
    {
        int inf = i, sup = (i+1)%n;
        if(P[inf].y > P[sup].y) swap(inf, sup);
        if(P[inf].y <= A.y && A.y < P[sup].y)
            if(area(A, P[inf], P[sup]) > 0)
                cnt++;
    }
    return (cnt % 2) == 1;
}

bool isInConvex(const vector <Point> &A, const Point &P)
{
	int n = A.size(), lo = 1, hi = A.size() - 1;
	
	if(area(A[0], A[1], P) <= 0) return 0;
	if(area(A[n-1], A[0], P) <= 0) return 0;
	
	while(hi - lo > 1)
	{
		int mid = (lo + hi) / 2;
		
		if(area(A[0], A[mid], P) > 0) lo = mid;
		else hi = mid;
	}
	
	return area(A[lo], A[hi], P) > 0;
}

bool isInConvexSlow(const vector <Point> &P, const Point &A)
{
    int n = P.size(), pos = 0, neg = 0;
    for(int i=0; i<n; i++)
    {
        double AA = area(A, P[i], P[(i+1)%n]);
        if(AA < 0) neg++;
        else if(AA > 0) pos++;
    }
    return neg == 0 || pos == 0;
}

int main()
{
    int n;
    cin>>n;
    
    for(int i=0; i<n; i++)
    {
        Point A, B;
        cin>>A.x>>A.y>>B.x>>B.y;
        
        int xleft, ytop, xright, ybottom;
        cin>>xleft>>ytop>>xright>>ybottom;
        
        if(xleft > xright) swap(xleft, xright);
        if(ybottom > ytop) swap(ybottom, ytop);
        
        vector <Point> P(4);
        P[0] = Point(xleft, ybottom);
        P[1] = Point(xright, ybottom);
        P[2] = Point(xright, ytop);
        P[3] = Point(xleft, ytop);
        
        bool ok = 0;
        
        if(intersects(A, B, P[0], P[1])) ok = 1;
        if(intersects(A, B, P[1], P[2])) ok = 1;
        if(intersects(A, B, P[2], P[3])) ok = 1;
        if(intersects(A, B, P[3], P[0])) ok = 1;
        
        if(isInConvex(P, (A+B)/2)) ok = 1;
        
        if(ok) cout<<"T"<<endl;
        else cout<<"F"<<endl;
    }
    return 0;
}
