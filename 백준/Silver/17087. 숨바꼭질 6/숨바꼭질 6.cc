#include <iostream>
using namespace std;


long long gcd(long long a, long long b);

int main() {
	int n;
	long long s;
	cin >> n >> s;

	long long len[100001];
	long long location;
	for (int i = 0; i < n; i++) {
		cin >> location;
		len[i] = abs(s - location);
	}

	for (int j = 0; j < n - 1; j++) {
		len[j + 1] = gcd(len[j], len[j + 1]);
	}
	cout << len[n - 1] << endl;

	return 0;
}

long long gcd(long long a, long long b) {
	if (a < b) swap(a, b);
	int c = a % b;
	while (c > 0) {
		a = b;
		b = c;
		c = a % b;
	}
	return b;
}