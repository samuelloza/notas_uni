#include <iostream>
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
Point operator /(const Point &a, double k) { return Point(a.x/k, a.y/k); }
Point operator *(const Point &a, double k) { return Point(a.x*k, a.y*k); }

double dist(const Point &A, const Point &B)    { return hypot(A.x - B.x, A.y - B.y); }
double cross(const Vector &A, const Vector &B) { return A.x * B.y - A.y * B.x; }
double dot(const Vector &A, const Vector &B)   { return A.x * B.x + A.y * B.y; }
double area(const Point &A, const Point &B, const Point &C) { return cross(B - A, C - A); }

bool isRight(Point A, Point B, Point C)
{
    return area(A, B, C) != 0 && (dot(B-A, C-A) == 0 || dot(A-B, C-B) == 0 || dot(A-C, B-C) == 0);
}

int main()
{
    int x1, y1, x2, y2, x3, y3;
    
    while(cin>>x1>>y1>>x2>>y2>>x3>>y3)
    {
        Point A(x1, y1), B(x2, y2), C(x3, y3);
        
        if(isRight(A, B, C)) cout<<"RIGHT"<<endl;
        else
        {
            bool ok = 0;
            
            Vector u(1, 0);
            for(int i=0; i<4; i++)
            {
                if(isRight(A + u, B, C)) ok = 1;
                if(isRight(A, B + u, C)) ok = 1;
                if(isRight(A, B, C + u)) ok = 1;
                u = u.ort();    
            }
            
            if(ok) cout<<"ALMOST"<<endl;
            else cout<<"NEITHER"<<endl;
        }
    }
    
    return 0;
}