#include <iostream>
using namespace std;


int gcd(int a, int b);
int lcm(int a, int b);

int main() {
	int cnt;
	cin >> cnt;

	int a, b;
	for (int i = 0; i < cnt; i++) {
		cin >> a >> b;
		if (b > a) swap(a, b);
		cout << lcm(a, b) << endl;
	}


	return 0;
}

int gcd(int a, int b) {
	int c = a % b;
	while (c > 0) {
		a = b;
		b = c;
		c = a % b;
	}
	return b;
}

int lcm(int a, int b) {
	return (a * b) / gcd(a, b);
}