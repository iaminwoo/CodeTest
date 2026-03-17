function solution(n) {
    const answer = Array.from({ length: n }, () => Array(n).fill(0));
    const dx = [1, 0, -1, 0];
    const dy = [0, 1, 0, -1];
    
    let num = 1;
    let x = 0;
    let y = 0;
    let d = 0;
    
    while (num <= n ** 2) {
        answer[y][x] = num;
        
        let newX = x + dx[d];
        let newY = y + dy[d];
        
        if (newX >= n || newX < 0 || newY >= n || newY < 0 || answer[newY][newX] !== 0) {
            d = (d + 1) % 4;
            newX = x + dx[d];
            newY = y + dy[d];
        }
        
        x = newX;
        y = newY;
        num++;
    }
    
    return answer;
}