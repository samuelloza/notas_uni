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

double dist(const Point &A, const Point &B)    { return hypot(A.x - B.x, A.y - B.y); }
double cross(const Vector &A, const Vector &B) { return A.x * B.y - A.y * B.x; }
double dot(const Vector &A, const Vector &B)   { return A.x * B.x + A.y * B.y; }
double area(const Point &A, const Point &B, const Point &C) { return cross(B - A, C - A); }

bool isParallel(const Point &P1, const Point &P2, const Point &P3, const Point &P4)
{
	return cross(P2 - P1, P4 - P3) == 0;
}

bool onSegment(const Point &A, const Point &B, const Point &P)
{
    return abs(area(A, B, P)) < EPS &&
            P.x >= min(A.x, B.x) && P.x <= max(A.x, B.x) &&
            P.y >= min(A.y, B.y) && P.y <= max(A.y, B.y);
}
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

double distToIntersection(const Point &A, const Point &B, const Point &C, const Point &D)
{
    return cross(C - A, D - C) / cross(B - A, D - C);
}

int n;
Point P[105][3];

bool inside(int ind, Point M)
{
	double A1 = area(P[ind][0], P[ind][1], M);
	double A2 = area(P[ind][1], P[ind][2], M);
	double A3 = area(P[ind][2], P[ind][0], M);
	double A4 = area(P[ind][0], P[ind][1], P[ind][2]);
	
	return abs(abs(A1) + abs(A2) + abs(A3) - abs(A4)) < EPS;
}

bool valid(Point M, int ind)
{
	for(int i=0; i<n; i++)
		if(i != ind && inside(i, M))
			return 0;
	return 1;
}
					
int main ()
{
	while(cin>>n)
	{
		for(int i=0; i<n; i++)
		{
			for(int j=0; j<3; j++)
			{
				int x, y;
				cin>>x>>y;
				P[i][j] = Point(x, y);
			}
		}
		
		vector <double> Q[n][3];
		
		for(int i1=0; i1<n; i1++)
		{
			for(int j1=0; j1<3; j1++)
			{
				Point P1 = P[i1][j1], P2 = P[i1][(j1+1)%3];
				
				for(int i2=0; i2<n; i2++)
				{
					if(i1 == i2) continue;
					
					for(int j2=0; j2<3; j2++)
					{
						Point P3 = P[i2][j2], P4 = P[i2][(j2+1)%3];
						
						if(!isParallel(P1, P2, P3, P4) && intersects(P1, P2, P3, P4))
							Q[i1][j1].push_back(distToIntersection(P1, P2, P3, P4));
					}
				}
			}
		}
		
		double ans = 0;
		
		for(int i=0; i<n; i++)
		{
			for(int j=0; j<3; j++)
			{
				Q[i][j].push_back(0);
				Q[i][j].push_back(1);
				
				sort(Q[i][j].begin(), Q[i][j].end());
				
				for(int k=0; k+1<Q[i][j].size(); k++)
				{
					Point M = P[i][j] + (P[i][(j+1)%3] - P[i][j]) * (Q[i][j][k] + Q[i][j][k+1]) / 2.0;
					
					if(valid(M, i)) ans += (Q[i][j][k+1] - Q[i][j][k]) * (P[i][(j+1)%3] - P[i][j]).mod();
				}
			}
		}
		
		printf("%.10lf\n", ans);
	}
	
	return 0;
}