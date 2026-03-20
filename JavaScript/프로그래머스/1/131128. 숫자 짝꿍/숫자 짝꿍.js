function solution(X, Y) {
    const xCount = {};
    const yCount = {};
    const arr = [];
    
    [...X].forEach(c => xCount[c] = (xCount[c] || 0) + 1);
    [...Y].forEach(c => yCount[c] = (yCount[c] || 0) + 1);
    
    for (let i = 9 ; i >= 0 ; i--) {
        const count = Math.min(xCount[i] || 0, yCount[i] || 0);
        for (let j = 0 ; j < count ; j++) arr.push(i);
    }
    
    if (arr.length === 0) return "-1";
    if (arr[0] === 0) return "0";
    return arr.join("");
}