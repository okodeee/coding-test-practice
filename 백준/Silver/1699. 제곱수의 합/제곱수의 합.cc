#include <iostream>
#include <algorithm>
using namespace std;

int main() {
	int n;
	cin >> n;

	int dp[100001];

	for (int i = 0; i <= n; i++) {
		dp[i] = i;
		for (int j = 2; j*j <= i; j++) {
			dp[i] = min(dp[i], dp[i - j * j] + 1);
		}
	}
	cout << dp[n] << endl;

	return 0;
}