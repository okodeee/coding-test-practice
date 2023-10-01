#include <iostream>
using namespace std;


int main() {
	int n;
	cin >> n;

	int ans = 1;
	for (int i = n; i > 0; i--) {
		ans *= i;
	}
	cout << ans << endl;

	return 0;
}