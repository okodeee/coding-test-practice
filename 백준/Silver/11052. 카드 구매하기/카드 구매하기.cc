#include <iostream>
#include <algorithm>
using namespace std;

int main() {
	int n;
	cin >> n;

	int *p = new int[n + 1];
	for (int i = 1; i < n + 1; i++) {
		cin >> p[i];
	}

	int *mp = new int[n + 1];
	mp[0] = 0;
	mp[1] = p[1];

	int m;
	for (int i = 2; i < n + 1; i++) {
		m = 0;
		for (int j = 1; j < i + 1; j++) {
			m = max(m, mp[i - j] + p[j]);
		}
		mp[i] = m;
	}

	cout << mp[n] << endl;

	delete p;
	delete mp;

	return 0;
}