#include <iostream>
using namespace std;

int cain(int M, int N, int x, int y);

int main() {
	int cnt, M, N, x, y;
	cin >> cnt;

	while (cnt--) {
		cin >> M >> N >> x >> y;
		cout << cain(M, N, x, y) << endl;
	}

	return 0;
}

int cain(int M, int N, int x, int y) {
	for (int year = x; year <= M*N; year += M) {
			if ((year - y) % N == 0) {
				return year;
			}
	}

	return -1;
}