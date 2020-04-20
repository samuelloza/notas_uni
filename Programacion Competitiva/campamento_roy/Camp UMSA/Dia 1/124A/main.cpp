#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

struct Punto
{
    int x, y, z;
    Punto() {
    }
    Punto(int n1, int n2, int n3){
        x = n1;
        y = n2;
        z = n3;
    }
};

bool operator <(Punto P1, Punto P2){
    if(P1.x != P2.x) return P1.x < P2.x;
    else if(P1.y != P2.y) return P1.y < P2.y;
    else return P1.z < P2.z;
}

bool orden(Punto P1, Punto P2){
    if(P1.x != P2.x) return P1.x < P2.x;
    else if(P1.y != P2.y) return P1.y < P2.y;
    else return P1.z < P2.z;
}
/*
bool orden(pair <int, int> p1, pair <int, int> p2)
{
    if(p1.second != p2.second) return p1.second < p2.second;
    else return p1.first < p2.first;
}
*/
int main()
{
    int n;
    cin>>n;

/*
    vector < pair <int, int> > v(n);

    for(int i=0; i<n; i++)
    {
        cin>>v[i].first>>v[i].second;
        // v[i] = make_pair(a, b);
    }
*/
    vector <Punto> v;
    for(int i=0; i<n; i++)
    {
        int a, b, c;
        cin>>a>>b>>c;
        v.push_back(Punto(a, b, c));
    }
    sort(v.begin(), v.end());

    cout<<endl;
    for(int i=0; i<n; i++)
        cout<<v[i].x<<" "<<v[i].y<<" "<<v[i].z<<endl;

    return 0;
}


