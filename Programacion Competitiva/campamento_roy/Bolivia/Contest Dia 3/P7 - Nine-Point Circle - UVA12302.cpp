#include <iostream>
#include <vector>
#include <string>
#include <map>
#include <set>
#include <algorithm>
#include <cstring>
#include <cstdio>
#include <cmath>
#include <queue>

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

Point lineIntersection(const Point &A, const Point &B, const Point &C, const Point &D)
{
    return A + (B - A) * (cross(C - A, D - C) / cross(B - A, D - C));
}

int main ()
{
	int x1, y1, x2, y2, x3, y3;
	while(cin>>x1>>y1>>x2>>y2>>x3>>y3)
	{
		if(x1 == -1) break;
		
		Point A(x1, y1), B(x2, y2), C(x3, y3);
		
		Point MA = (B + C) / 2;
		Point MB = (A + C) / 2;
		Point MC = (A + B) / 2;
		
		Point P = (MA + MB) / 2, Q = P + (MA - MB).ort();
		Point R = (MA + MC) / 2, S = R + (MA - MC).ort();;
		
		Point CC = lineIntersection(P, Q, R, S);
		
		printf("%.6lf %.6lf %.6lf\n", CC.x, CC.y, dist(MA, CC)); 
	}
	
	return 0;
}
