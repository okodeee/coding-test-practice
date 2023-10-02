#include <iostream>
using namespace std;

int count(int a, int b);

int main() {
	int n;
	cin >> n;

	int cnt5 = count(n, 5);

	cout << cnt5 << endl;

	return 0;
}

int count(int a, int b) {
	int cnt = 0;
	for (int i = b; i <= a; i *= b) {
		cnt += a / i;
	}
	return cnt;
}