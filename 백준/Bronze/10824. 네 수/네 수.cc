#include <iostream>
#include <string>
using namespace std;


int main() {
	string A, B, C, D;
	cin >> A >> B >> C >> D;

	cout << stoll(A + B) + stoll(C + D);

	return 0;
}