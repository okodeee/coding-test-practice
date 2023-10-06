#include <iostream>
#include <algorithm>
using namespace std;

int main() {
	int cnt;
	int arr[100001];
	int dp[100001];
	cin >> cnt;
	for (int i = 1; i <= cnt; i++) {
		cin >> arr[i];
	}

	int ans = arr[1];
	dp[1] = arr[1];

	for (int i = 2; i <= cnt; i++) {
		dp[i] = max(dp[i - 1] + arr[i], arr[i]);
		ans = max(dp[i], ans);
	}

	cout << ans << endl;

	return 0;
}