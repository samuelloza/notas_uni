#include <iostream>
#include <cstdio>
#include <cmath>

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
Point operator /(const Point &a, double n) { return Point(a.x/n, a.y/n); }
Point operator *(const Point &a, double n) { return Point(a.x*n, a.y*n); }

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

double dot(const Vector &A, const Vector &B)   { return A.x * B.x + A.y * B.y; }
double cross(const Vector &A, const Vector &B) { return A.x * B.y - A.y * B.x; }

Point lineIntersection(const Point &A, const Point &B, const Point &C, const Point &D)
{
    return A + (B - A) * (cross(D - C, D - A) / cross(D - C, B - A));
}

bool isInt(double k)
{
	return abs(k - int(k + 0.5)) < 1e-5;
}

int main()
{
	double x0, y0, x1, y1, x2, y2;
	while(cin>>x0>>y0>>x1>>y1>>x2>>y2)
	{
		Point A(x0, y0), B(x1, y1), C(x2, y2);
		
		Point P1 = (A + B) / 2.0, P2 = P1 + (B - A).ort();
		Point P3 = (A + C) / 2.0, P4 = P3 + (C - A).ort();

		Point P = lineIntersection(P1, P2, P3, P4);
		double r2 = (P - A).mod2();
        
        double ang1 = abs((A-P).arg() - (B-P).arg());
        double ang2 = abs((B-P).arg() - (C-P).arg());
        
        int n;
		for(n=3; n<=1000; n++)
			if(isInt(ang1 / (2*PI/n)) && isInt(ang2 / (2*PI/n)))
                break;
        
		printf("%d\n", n);
	}
	
	return 0;
}
