#include <iostream>
#include <queue>
#include <string>
using namespace std;


int main() {
	int cnt;
	cin >> cnt;

	queue<int> q;
	string input;
	while (cnt--) {
		cin >> input;

		if (input == "push") {
			int num;
			cin >> num;
			q.push(num);
		}
		else if (input == "pop") {
			if (q.empty()) {
				cout << "-1" << endl;
			}
			else {
				cout << q.front() << endl;
				q.pop();
			}
		}
		else if (input == "size") {
			cout << q.size() << endl;
		}
		else if (input == "empty") {
			cout << q.empty() << endl;
		}
		else if (input == "front") {
			if (q.empty()) {
				cout << "-1" << endl;
			}
			else {
				cout << q.front() << endl;
			}
		}
		else if (input == "back") {
			if (q.empty()) {
				cout << "-1" << endl;
			}
			else {
				cout << q.back() << endl;
			}
		}

	}


	return 0;
}