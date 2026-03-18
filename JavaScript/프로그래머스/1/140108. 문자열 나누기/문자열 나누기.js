function solution(s) {
    const result = [...s].reduce((acc, c) => {
        if (acc[1] === 0) acc[0] = c;
        
        if (acc[0] === c) {
            acc[1]++;
        } else {
            acc[2]++;
        }
        
        if (acc[1] === acc[2]) {
            acc[3]++;
            acc[1] = 0;
            acc[2] = 0;
        }
        
        return acc;
    }, ["", 0, 0, 0]);
    
    let answer = result[3];
    if (result[1] > 0) answer++;
    return answer;
}