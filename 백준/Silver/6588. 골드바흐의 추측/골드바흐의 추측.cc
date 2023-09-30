#include <iostream>
using namespace std;

int prime[1000001] = { 0, };

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	prime[1] = 1;

	for (int i = 2; i <= 1000; i++) {
		if (prime[i] == 1)
			continue;

		for (int j = i * i; j <= 1000000; j += i) {
			prime[j] = 1;
		}
	}

	int input = 1;
	while (true) {
		cin >> input;
		if (!input) break;

		bool find = false;
		for (int i = 3; i <= input / 2; i += 2) {
			if (prime[i] == 0 && prime[input - i] == 0) {
				printf("%d = %d + %d\n", input, i, input - i);
				find = true;
				break;
			}	
		}
		if (!find)
			cout << "Goldbach's conjecture is wrong.\n";
	}

	return 0;
}