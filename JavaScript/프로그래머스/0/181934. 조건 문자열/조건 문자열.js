function solution(ineq, eq, n, m) {
    const ops = {
        ">=": (n, m) => n >= m,
        "<=": (n, m) => n <= m,
        ">!": (n, m) => n > m,
        "<!": (n, m) => n < m,
    };
    return +ops[ineq + eq](n, m);
}