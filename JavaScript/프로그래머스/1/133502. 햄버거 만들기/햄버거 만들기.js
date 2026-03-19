function solution(ingredient) {
    const result = ingredient.reduce((acc, ing) => {
        acc.tower.push(ing);
        
        if (acc.tower.length >= 4) {
            if (acc.tower[acc.tower.length - 4] === 1 &&
                acc.tower[acc.tower.length - 3] === 2 &&
                acc.tower[acc.tower.length - 2] === 3 &&
                acc.tower[acc.tower.length - 1] === 1) {
                acc.tower.splice(-4);
                acc.count++;
            }
        }
        
        return acc;
    }, { tower: [], count: 0 });
    
    return result.count;
}