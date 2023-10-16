#include <iostream>
#include <algorithm>
using namespace std;
int dp[501][501];

void triangle(int n);

int main() {
	int n;
	cin >> n;

	triangle(n);

	return 0;
}

void triangle(int n) {
	int input;
	cin >> input;
	dp[1][1] = input;

	for (int i = 2; i <= n; i++) {
		for (int j = 1; j <= i; j++) {
			cin >> input;
			int sum = 0;
			if (j - 1 > 0) sum = max(sum, dp[i - 1][j - 1]);
			if (j < i) sum = max(sum, dp[i - 1][j]);
			dp[i][j] = sum + input;
		}
	}
	int ans = 0;
	for (int i = 1; i <= n; i++) {
		ans = max(ans, dp[n][i]);
	}
	cout << ans << endl;
}