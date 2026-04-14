#include <iostream>
#include <string>
#include <algorithm>
using namespace std;

using i128 = __int128_t;

i128 strToInt128(const string& s) {
    i128 num = 0;
    int sign = 1;
    int idx = 0;

    if (s[0] == '-') {
        sign = -1;
        idx = 1;
    }

    for (; idx < s.size(); idx++) {
        num = num * 10 + (s[idx] - '0');
    }

    return num * sign;
}

void printInt128(i128 num) {
    if (num == 0) {
        cout << 0;
        return;
    }

    if (num < 0) {
        cout << '-';
        num = -num;
    }

    string result;
    while (num > 0) {
        result += (num % 10) + '0';
        num /= 10;
    }

    reverse(result.begin(), result.end());
    cout << result;
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    string a, b;
    cin >> a >> b;

    i128 x = strToInt128(a);
    i128 y = strToInt128(b);

    i128 sum = x + y;
    printInt128(sum);

    return 0;
}