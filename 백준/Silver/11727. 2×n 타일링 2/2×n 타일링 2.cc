#include <iostream>
using namespace std;


int main() {
	int n;
	cin >> n;

	int arr[1001];
	arr[0] = 1, arr[1] = 1;

	for (int i = 2; i <= n; i++) {
		arr[i] = (arr[i - 2] * 2 + arr[i - 1]) % 10007;
	}
	cout << arr[n] << endl;

	return 0;
}