#include <iostream>
#include <string>
using namespace std;


int main() {
	string str;
	cin >> str;

	int alphabet[26] = { 0 };

	for (int i = 0; i < str.length(); i++) {
		alphabet[str[i] - 'a']++;
	}

	for (int i = 0; i < 26; i++) {
		cout << alphabet[i] << ' ';
	}
		
	return 0;
}