function solution(lottos, win_nums) {
    
    const result = lottos.reduce((result, lot) => {
        if (lot !== 0 && win_nums.includes(lot)) result.inc++;
        if (lot !== 0 && !win_nums.includes(lot)) result.notInc++;
        return result;
    }, { inc: 0, notInc: 0 });
    
    let best = 7 - 6 + result.notInc;
    let worst = 7 - result.inc;
    
    return [best === 7 ? 6 : best, worst === 7 ? 6 : worst];
}