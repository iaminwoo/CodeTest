function solution(numLog) {
    const controls = {
        "1": "w",
        "-1": "s",
        "10": "d",
        "-10": "a",
    };
    
    return numLog.reduce((result, cur, idx) => {
        if (idx === numLog.length - 1) return result;
        const move = numLog[idx + 1] - numLog[idx];
        result += controls[move];
        return result;
    }, "");
}