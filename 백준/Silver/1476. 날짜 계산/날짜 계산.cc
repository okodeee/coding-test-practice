#include <iostream>
using namespace std;

int year(int a, int b, int c);

int main() {
	int E, S, M;
	cin >> E >> S >> M;

	cout << year(E, S, M) << endl;

	return 0;
}

int year(int a, int b, int c) {
	int year = 0;

	while (++year) {
		if (year % 15 == a || year % 15 == a - 15) {
			if (year % 28 == b || year % 28 == b - 28) {
				if (year % 19 == c || year % 19 == c - 19) {
					return year;
				}
				year += 27;
			}
			year += 14;
		}
	}

}
