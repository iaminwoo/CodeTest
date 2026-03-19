function solution(lottos, win_nums) {
    
    const result = lottos.reduce((result, lot) => {
        if (lot === 0) result.zero++;
        else if (win_nums.includes(lot)) result.inc++;
        return result;
    }, { inc: 0, zero: 0 });
    
    let worst = 7 - result.inc;
    let best = worst - result.zero;
    
    return [Math.min(6, best), Math.min(6, worst)];
}