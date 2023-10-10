#include <iostream>
using namespace std;

int main() {
	int dp[201][201];

	int n, k;
	cin >> n >> k;

	for (int i = 0; i <= n; i++)
		dp[i][1] = 1;
	for (int j = 2; j <= k; j++) {
		for (int i = 0; i <= n; i++) {
			int sum = 0;
			for (int a = 0; a <= i; a++) {
				sum = (sum + dp[a][j - 1]) % 1000000000;
			}
			dp[i][j] = sum;
		}
	}
	cout << dp[n][k] << endl;

	return 0;
}