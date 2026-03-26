function solution(binomial) {
    const ops = {
        "+": (a, b) => a + b,
        "-": (a, b) => a - b,
        "*": (a, b) => a * b,
    }
    
    const parts = binomial.split(" ");
    const op = parts[1];
    const a = parts[0];
    const b = parts[2];
    
    return ops[op](+a, +b);
}