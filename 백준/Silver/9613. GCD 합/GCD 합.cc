#include <iostream>
using namespace std;


int gcd(int a, int b);

int main() {
	int testcase;
	cin >> testcase;

	for (int i = 0; i < testcase; i++) {
		int test[101];

		int n, value;
		cin >> n;
		for (int j = 0; j < n; j++) {
			cin >> value;
			test[j] = value;
		}

		long long sum = 0;
		for (int j = 0; j < n - 1; j++) {
			for (int k = j+1; k < n; k++) {
				sum += gcd(test[j], test[k]);
			}
		}
		cout << sum << endl;

	}

	return 0;
}

int gcd(int a, int b) {
	if (a < b) swap(a, b);
	int c = a % b;
	while (c > 0) {
		a = b;
		b = c;
		c = a % b;
	}
	return b;
}
