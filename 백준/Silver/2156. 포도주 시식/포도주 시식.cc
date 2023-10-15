#include <iostream>
#include <algorithm>
using namespace std;
int dp[10001][3];

void max_quantity(int n);

int main() {
	int n;
	cin >> n;

	max_quantity(n);

	return 0;
}

void max_quantity(int n) {
	int q;
	cin >> q;
	dp[1][0] = 0; dp[1][1] = q;

	for (int i = 2; i <= n; i++) {
		cin >> q;
		int m = 0;
		for (int j = 0; j < 3; j++) {
			m = max(m, dp[i - 1][j]);
		}
		dp[i][0] = m;
		dp[i][1] = dp[i - 1][0] + q;
		dp[i][2] = dp[i - 1][1] + q;
	}

	int m = 0;
	for (int j = 0; j < 3; j++) {
		m = max(m, dp[n][j]);
	}
	cout << m << endl;
}