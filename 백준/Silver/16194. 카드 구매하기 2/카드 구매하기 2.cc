#include <iostream>
#include <algorithm>
using namespace std;


int price[1001];
int ans[1001];

int main() {
	int n;
	cin >> n;
	for (int i = 1; i <= n; i++) {
		cin >> price[i];
	}

	for (int i = 1; i <= n; i++) {
		ans[i] = price[i];
		for (int j = 1; j <= i / 2; j++) {
			ans[i] = min(ans[i], ans[i - j] + price[j]);
		}
	}
	cout << ans[n];

	return 0;
}