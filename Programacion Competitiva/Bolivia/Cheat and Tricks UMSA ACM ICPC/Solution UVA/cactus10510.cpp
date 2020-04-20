/* UVA 10510 - Cactus
 * Main idea: First check the graph is a single strongly connected
 *            component. Then draw the DFS tree - if the graph has
 *            any cross/forward edge, then it's not a cactus. If there
 *            exists a node who has more than one children with a back
 *            edge to the ancestor of the node, then the graph is not a 
 *            cactus. 
 */
#include <iostream>
#include <cmath>
#include <algorithm>
#include <vector>

using namespace std;
vector<int> edge[10005];
int dfsnum[10005];
int scc[10005];
int st[10005];
int low[10005];
int color[10005];
int num_scc;
int num;
int n, m;
int stack_sz;

// strongly connected component - hacked to be like a DP
int SCC(int x) {
  if (dfsnum[x] == -1) low[x] = dfsnum[x] = num++;
  else return low[x];

  st[stack_sz++] = x;
  for (int i = 0; i < (int)edge[x].size(); ++i) 
    if (scc[edge[x][i]] == -1) low[x] = min(low[x], SCC(edge[x][i]));
  if (low[x] == dfsnum[x])  {
    while (scc[x] != num_scc)
      scc[st[--stack_sz]] = num_scc;
    ++num_scc;
  }
  return low[x];
}

// dfs to find any cross/forward edge and "bad" back edge.
// return true iff graph is a cactus
bool dfs(int x, int minBackEdge) {
  color[x] = 1;
  bool hasBackEdge = false;
  // check whether I have a back Edge
  for (int i = 0; i < (int) edge[x].size(); ++i) {
    if (color[edge[x][i]] == 1) {
      hasBackEdge = true;
      // a back edge to a dfsnum that's too small
      // this means an edge is shared by two cycles
      if (dfsnum[edge[x][i]] < minBackEdge)
	return false;
    }
  }

  if (hasBackEdge) minBackEdge = dfsnum[x];

  for (int i = 0; i < (int) edge[x].size(); ++i) {
    if (color[edge[x][i]] == 0) {
      // recurse on forward edge
      if (!dfs(edge[x][i], minBackEdge)) return false;
    } else if (color[edge[x][i]] == 2) {
      // found a forward/cross edge - so an edge is shared by two cycles
      return false;
    }
  }
  color[x] = 2;
  return true;
}

int main() {
  int ncase;
  cin >> ncase;
  while (ncase--) {
    cin >> n >> m;

    memset(scc, -1, sizeof(scc));
    memset(dfsnum, -1, sizeof(dfsnum));
    memset(low, -1, sizeof(low));
    memset(color, 0, sizeof(color));
    num_scc = num = stack_sz = 0;
    for (int i = 0; i < n; ++i) edge[i].clear();

    int tx, ty;
    for (int i = 0; i < m; ++i) {
      cin >> tx >> ty;
      edge[tx].push_back(ty);
    }
    
    // this handles the case of disconnected graph
    for (int i = 0; i < n; ++i) SCC(i);
    
    // make sure only one strongly connected component
    if (num_scc == 1) {
      if (dfs(0, -1)) cout << "YES" << endl;
      else cout << "NO" << endl;
    } else {
      cout << "NO" << endl;
    }
  }
}
