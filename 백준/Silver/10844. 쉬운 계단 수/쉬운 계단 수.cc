#include <iostream>
using namespace std;


int main() {
	int step[101][10];
	step[1][0] = 0;
	for (int i = 1; i < 10; i++)
		step[1][i] = 1;
	
	int n;
	cin >> n;

	for (int i = 2; i <= n; i++) {
		step[i][0] = step[i - 1][1];
		for (int j=1;j<9;j++)
			step[i][j] = (step[i - 1][j - 1] + step[i - 1][j + 1]) % 1000000000;
		step[i][9] = step[i - 1][8];
	}

	long long ans = 0;
	for (int i = 0; i < 10; i++) {
		ans = (ans + step[n][i]) % 1000000000;
	}
	cout << ans << endl;
	
	return 0;
}