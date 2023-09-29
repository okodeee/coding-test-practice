#include <iostream>
#include <string>
using namespace std;


int main() {
	string str;
	while (true) {
		int ans[4] = { 0, };
		getline(cin, str);
		if (cin.eof() == true)
			break;
		for (int i = 0; i < str.length(); i++) {
			if (str[i] >= 'a' && str[i] <= 'z')
				ans[0]++;
			else if (str[i] >= 'A' && str[i] <= 'Z')
				ans[1]++;
			else if (str[i] >= '0' && str[i] <= '9')
				ans[2]++;
			else if (str[i] == ' ')
				ans[3]++;
		}
		for (int i = 0; i < 4; i++)
			cout << ans[i] << ' ';
		cout << '\n';
	}

	return 0;
}