#include <iostream>
#include <math.h>
using namespace std;

int main() {
	int n, k = 1, sum = 0;
	cin >> n;

	if (n <= 9)
		cout << n;
	else {
		sum += 9;
		k++;

		if (n > 99) {
			sum += 90 * 2;
			k++;
		}
		if (n > 999) {
			sum += 900 * 3;
			k++;
		}
		if (n > 9999) {
			sum += 9000 * 4;
			k++;
		}
		if (n > 99999) {
			sum += 90000 * 5;
			k++;
		}
		if (n > 999999) {
			sum += 900000 * 6;
			k++;
		}
		if (n > 9999999) {
			sum += 9000000 * 7;
			k++;
		}
		if (n > 99999999) {
			sum += 90000000 * 8;
			k++;
		}

		sum += (n - pow(10,k - 1) + 1)*k;
		cout << sum;
	}
}