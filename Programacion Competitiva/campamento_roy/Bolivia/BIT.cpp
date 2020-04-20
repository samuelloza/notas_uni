#include <iostream>
#include <string>
#include <vector>
#include <sstream>
#include <cmath>
#include <algorithm> 
#include <map>
#include <set>
#include <queue>
#include <cstdio>
#include <cstring>

using namespace std;

// BIT 1D
int n;
int t[1000000], v[1000000];

int sum(int x)
{
	int result = 0;
	for(int i = x; i >= 0; i = (i & (i+1)) - 1)
		result += t[i];
	return result;
}

void inc(int x, int delta)
{
    v[x] += delta;
	for(int i = x; i < n; i = (i | (i+1)))
		t[i] += delta;
}

// BIT 2D

int n, m;
int t[1024][1024], v[1024][1024];

int sum(int x, int y)
{
	int result = 0;
	for(int i = x; i >= 0; i = (i & (i+1)) - 1)
        for(int j = y; j >= 0; j = (j & (j+1)) - 1)
            result += t[i][j];
    return result;
}

void inc(int x, int y, int delta)
{
    v[x][y] += delta;
 	for(int i = x; i < n; i = (i | (i+1)))
        for(int j = y; j < m; j = (j | (j+1)))
            t[i][j] += delta;
}


int main()
{
    return 0;
}
