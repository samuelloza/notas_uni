#include <iostream>
#include <cmath>
#include <algorithm>
#include <queue>

using namespace std;
int s, a, SRC, SNK, b;
int cap[5005][5005];
int dx[4] = {-1, 0, 1, 0};
int dy[4] = {0, -1, 0, 1};
bool seen[5005];
int parent[5005];

// need to implement bfs "smartly" to avoid TLE
bool bfs() {
  memset(parent, -1, sizeof(parent));
  memset(seen, 0, sizeof(seen));

  queue<int> q;
  q.push(SRC);
  seen[SRC] = true;
  while (!q.empty()) {
    int cur = q.front();
    q.pop();

    if (cur < s*a) {
      // only path is to node (s*a + cur)
      int tmp = s*a + cur;
      if (!seen[tmp] && cap[cur][tmp]) {
	seen[tmp] = true;
	parent[tmp] = cur;
	q.push(tmp);
      }
    } else if (cur == SRC) {
      for (int i = 0; i < s*a; ++i) {
	if (cap[cur][i]) {
	  seen[i] = true;
	  parent[i] = cur;
	  q.push(i);
	}
      }
    } else {
      if (cap[cur][SNK]) {
	parent[SNK] = cur;
	return true;
      }
      int curx = (cur - s*a) / a; int cury = (cur - s*a) % a;
      for (int d = 0; d < 4; ++d) {
	int newx = curx + dx[d]; int newy = cury + dy[d];
	if (newx >= s || newy >= a || newx < 0 || newy < 0) continue;
	int tmp = newx*a + newy;
	if (!seen[tmp] && cap[cur][tmp]) {
	  seen[tmp] = true;
	  parent[tmp] = cur;
	  q.push(tmp);
	}
      }
    }
  }
  return false;
}

int trace_path() {
  int cur = SNK;
  int prev = parent[SNK];
  int flow = cap[prev][cur];
  while (prev != -1) {
    flow = min(flow, cap[prev][cur]);
    cur = prev;
    prev = parent[cur];
  }
  return flow;
}

void adjust_cap(int f) {
  int cur = SNK;
  int prev = parent[SNK];
  while (prev != -1) {
    cap[cur][prev] += f;
    cap[prev][cur] -= f;
    cur = prev;
    prev = parent[cur];
  }
}

int maxflow() {
  int f = 0;
  while (bfs()) {
    int temp = trace_path();
    adjust_cap(temp);
    f += temp;
  }
  return f;
}

// vertex encoding scheme:
// the input node for intersection (i, j) is i*a + j
// the output node for intersection (i, j) is s*a + i*a + j
// src = 2 * s * a
// sink = 2 * s * a + 1
int main() {
  int ncase;
  cin >> ncase;
  while (ncase--) {
    cin >> s >> a >> b;
    SRC = 2 * s * a;
    SNK = SRC + 1;
    memset(cap, 0, sizeof(cap));

    int tx, ty;
    // source is connected to the banks
    for (int i = 0; i < b; ++i) {
      cin >> tx >> ty;
      --tx; --ty;
      cap[SRC][tx * a + ty] = 1;
    }

    // outer city boundary in the x-direction
    for (int i = 0; i < s; ++i) {
      cap[s*a + i*a + 0][SNK] = 1;
      cap[s*a + i*a + (a-1)][SNK] = 1;
    }

    // outer city boundary in the y-direction
    for (int i = 0; i < a; ++i) {
      cap[s*a + 0*a + i][SNK] = 1;
      cap[s*a + (s-1)*a + i][SNK] = 1;
    }

    for (int i = 0; i < s; ++i) {
      for (int j = 0; j < a; ++j) {
	// enforces vertex capacity
	cap[i*a + j][s*a + i*a + j] = 1;
	for (int d = 0; d < 4; ++d) {
	  int newx = i + dx[d];
	  int newy = j + dy[d];
	  if (newx >= s || newx < 0 || newy >= a || newy < 0) continue;
	  cap[s*a + i*a + j][newx*a + newy] = 1;
	}
      }
    }

    int ans = maxflow();
    if (ans >= b) cout << "possible" << endl;
    else cout << "not possible" << endl;
  }
}
