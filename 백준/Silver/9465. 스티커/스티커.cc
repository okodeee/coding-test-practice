#include <iostream>
#include <algorithm>
using namespace std;
int cost[100001][3];
int dp[100001][3];

void sticker();


int main() {
	int cnt;
	cin >> cnt;

	while (cnt--) {
		sticker();
	}

	return 0;
}

void sticker() {
	int n, input;
	cin >> n;

	for (int j = 1; j < 3; j++) {
		for (int i = 1; i <= n; i++) {
			cin >> input;
			cost[i][j] = input;
		}
	}

	dp[0][1] = 0; dp[0][2] = 0;
	dp[1][1] = cost[1][1]; dp[1][2] = cost[1][2];
	for (int i = 2; i <= n; i++) {
		dp[i][1] = max(dp[i - 1][2], dp[i - 2][2]) + cost[i][1];
		dp[i][2] = max(dp[i - 1][1], dp[i - 2][1]) + cost[i][2];
	}
	cout << max(dp[n][1], dp[n][2]) << endl;
}