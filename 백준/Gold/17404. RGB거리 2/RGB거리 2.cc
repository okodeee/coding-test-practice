#include <iostream>
#include <algorithm>
using namespace std;
long long R[1001][3];
long long G[1001][3];
long long B[1001][3];

int main() {
	int cnt;
	cin >> cnt;

	int r1, g1, b1; int r2, g2, b2;
	cin >> r1 >> g1 >> b1;
	cin >> r2 >> g2 >> b2;
	R[2][0] = 2001; R[2][1] = r1 + g2; R[2][2] = r1 + b2;
	G[2][0] = g1 + r2; G[2][1] = 2001; G[2][2] = g1 + b2;
	B[2][0] = b1 + r2; B[2][1] = b1 + g2; B[2][2] = 2001;

	int r, g, b;
	for (int i = 3; i <= cnt; i++) {
		cin >> r >> g >> b;
		R[i][0] = min(R[i - 1][1], R[i - 1][2]) + r;
		R[i][1] = min(R[i - 1][0], R[i - 1][2]) + g;
		R[i][2] = min(R[i - 1][0], R[i - 1][1]) + b;

		G[i][0] = min(G[i - 1][1], G[i - 1][2]) + r;
		G[i][1] = min(G[i - 1][0], G[i - 1][2]) + g;
		G[i][2] = min(G[i - 1][0], G[i - 1][1]) + b;

		B[i][0] = min(B[i - 1][1], B[i - 1][2]) + r;
		B[i][1] = min(B[i - 1][0], B[i - 1][2]) + g;
		B[i][2] = min(B[i - 1][0], B[i - 1][1]) + b;
	}
	long long Rans = min(R[cnt][1], R[cnt][2]);
	long long Gans = min(G[cnt][0], G[cnt][2]);
	long long Bans = min(B[cnt][0], B[cnt][1]);
	
	long long ans = min(Rans, Gans);
	ans = min(ans, Bans);
	cout << ans << endl;

	return 0;
}