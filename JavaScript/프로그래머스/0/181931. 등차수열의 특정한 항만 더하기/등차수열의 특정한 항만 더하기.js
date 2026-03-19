function solution(a, d, included) {
    
    const res = included.reduce((result, inc) => {
        if (inc) result.sum += result.num;
        result.num += d;
        return result;
    }, { sum: 0, num: a});
    
    return res.sum;
}