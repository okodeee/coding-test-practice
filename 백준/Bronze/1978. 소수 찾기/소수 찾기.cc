#include <iostream>
using namespace std;


int main() {
	int prime[1001] = { 0, };
	prime[1] = 1;
	for (int i = 2; i <= 32; i++) {
		if (prime[i] == 1)
			continue;

		for (int j = i * i; j <= 1000; j += i) {
			prime[j] = 1;
		}
	}

	int n;
	cin >> n;

	int cnt = 0, input = 0;
	for (int i = 0; i < n; i++) {
		cin >> input;
		if (!prime[input]) cnt++;
	}
	cout << cnt << endl;
	return 0;
}