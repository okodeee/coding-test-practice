#include <iostream>
#include <algorithm>
using namespace std;

long long count(long long a, long long b);

int main() {
	long long n, m;
	cin >> n >> m;

	long long cnt5 = count(n, 5) - count(m, 5) - count(n - m, 5);
	long long cnt2 = count(n, 2) - count(m, 2) - count(n - m, 2);

	cout << min(cnt5, cnt2) << endl;

	return 0;
}

long long count(long long a, long long b) {
	long long cnt = 0;
	for (long long i = b; i <= a; i *= b) {
		cnt += a / i;
	}
	return cnt;
}