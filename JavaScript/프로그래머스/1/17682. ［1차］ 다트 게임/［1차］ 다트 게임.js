function solution(dartResult) {
    const ops = {
        "S": (sum, last, second) => [sum, last],
        "D": (sum, last, second) => [sum, last ** 2],
        "T": (sum, last, second) => [sum, last ** 3],
        "#": (sum, last, second) => [sum, last * -1],
        "*": (sum, last, second) => [sum + second, last * 2],
    }
    
    dartResult = dartResult.replaceAll("10", "A");
    
    const result = [...dartResult].reduce((acc, c) => {
        if (Number.isInteger(+c) || c === "A") {
            if (c === "A") c = 10;
            acc.sum += acc.last;
            acc.second = acc.last;
            acc.last = +c;
        } else {
            [acc.sum, acc.last] = ops[c](acc.sum, acc.last, acc.second);
        }
        return acc;
    }, { sum: 0, last: 0, second: 0});
    
    return result.sum + result.last;
}