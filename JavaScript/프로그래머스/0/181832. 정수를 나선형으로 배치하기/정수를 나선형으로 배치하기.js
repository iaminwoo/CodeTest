const dx = [1, 0, -1, 0];
const dy = [0, 1, 0, -1];

function solution(n) {
    const answer = Array.from({ length: n }, () => Array(n).fill(0));
    let num = 1;
    let x = 0;
    let y = 0;
    let d = 0;
    
    while (true) {
        answer[y][x] = num;
        
        let newX = x + dx[d % 4];
        let newY = y + dy[d % 4];
        
        if (newX >= n || newX < 0 || newY >= n || newY < 0 || answer[newY][newX] !== 0) {
            newX -= dx[d % 4];
            newY -= dy[d % 4];
            d++;
            newX += dx[d % 4];
            newY += dy[d % 4];
        }
        
        if (newX >= n || newX < 0 || newY >= n || newY < 0 || answer[newY][newX] !== 0) break;
        
        x = newX;
        y = newY;
        num++;
    }
    
    return answer;
}