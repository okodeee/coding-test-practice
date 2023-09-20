#include <iostream>
#include <deque>
#include <string>
using namespace std;

int main() {
	int cnt;
	cin >> cnt;

	deque<int> dq;
	string input;
	while (cnt--) {
		cin >> input;

		if (input == "push_front") {
			int num;
			cin >> num;
			dq.push_front(num);
		}
		else if (input == "push_back") {
			int num;
			cin >> num;
			dq.push_back(num);
		}
		else if (input == "pop_front") {
			if (dq.empty()) {
				cout << "-1" << endl;
			}
			else {
				cout << dq.front() << endl;
				dq.pop_front();
			}
		}
		else if (input == "pop_back") {
			if (dq.empty()) {
				cout << "-1" << endl;
			}
			else {
				cout << dq.back() << endl;
				dq.pop_back();
			}
		}
		else if (input == "size") {
			cout << dq.size() << endl;
		}
		else if (input == "empty") {
			cout << dq.empty() << endl;
		}
		else if (input == "front") {
			if (dq.empty()) {
				cout << "-1" << endl;
			}
			else {
				cout << dq.front() << endl;
			}
		}
		else if (input == "back") {
			if (dq.empty()) {
				cout << "-1" << endl;
			}
			else {
				cout << dq.back() << endl;
			}
		}
	}
	return 0;
}