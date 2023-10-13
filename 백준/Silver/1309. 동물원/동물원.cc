#include <iostream>
using namespace std;
int zoo[100001][3];


int main() {
	int cage;
	cin >> cage;

	zoo[1][0] = 1;
	zoo[1][1] = 1;
	zoo[1][2] = 1;
	for (int i = 2; i <= cage; i++) {
		zoo[i][0] = (zoo[i - 1][0] + zoo[i - 1][1] + zoo[i - 1][2])%9901;
		zoo[i][1] = (zoo[i - 1][0] + zoo[i - 1][2])%9901;
		zoo[i][2] = (zoo[i - 1][0] + zoo[i - 1][1])%9901;
	}

	int ans = (zoo[cage][0] + zoo[cage][1] + zoo[cage][2]) % 9901;
	cout << ans << endl;

	return 0;
}