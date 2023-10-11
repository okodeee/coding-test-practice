#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;
#define MOD 1000000009

long long dp[1000001];

void ott(int a);

int main() {
	ott(1000001);

	int cnt, testCase;
	cin >> cnt;
	for (int i = 0; i < cnt; i++) {
		cin >> testCase;
		cout << dp[testCase] << endl;;
	}

	return 0;
}

void ott(int a) {
	dp[1] = 1;
	dp[2] = 2;
	dp[3] = 4;
	for (int i = 4; i <= a; i++) {
		dp[i] = (dp[i - 1] + dp[i - 2] + dp[i - 3]) % MOD;
	}
}