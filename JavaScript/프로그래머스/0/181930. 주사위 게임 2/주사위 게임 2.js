function solution(a, b, c) {
    const solo = a + b + c;
    const duo = a ** 2 + b ** 2 + c ** 2;
    const trio = a ** 3 + b ** 3 + c ** 3;
    
    if (a === b && b === c) {
        return solo * duo * trio;
    } else if (a === b || b === c || c === a) {
        return solo * duo;
    } else {
        return solo;
    }
}