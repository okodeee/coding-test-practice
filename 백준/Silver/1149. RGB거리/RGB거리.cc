#include <iostream>
#include <algorithm>
using namespace std;
int cost[1001][3];

int main() {
	int cnt;
	cin >> cnt;

	int r, g, b;
	cin >> r >> g >> b;
	cost[1][0] = r;
	cost[1][1] = g;
	cost[1][2] = b;
	for (int i = 2; i <= cnt; i++) {
		cin >> r >> g >> b;
		cost[i][0] = min(cost[i - 1][1], cost[i - 1][2]) + r;
		cost[i][1] = min(cost[i - 1][0], cost[i - 1][2]) + g;
		cost[i][2] = min(cost[i - 1][0], cost[i - 1][1]) + b;
	}
	int ans = min(cost[cnt][0], cost[cnt][1]);
	ans = min(ans, cost[cnt][2]);
	cout << ans << endl;

	return 0;
}