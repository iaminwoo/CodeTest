function solution(board, moves) {
    const tops = {};
    const basket = [];
    let answer = 0;
    
    for (let i = 0 ; i < board[0].length ; i++) {
        for (let j = 0 ; j < board.length ; j++) {
            if (board[j][i] !== 0) {
                tops[i] = j;
                break;
            }
        }
    }
    
    moves.forEach(col => {
        const top = tops[col - 1];
        if (top === board.length) return;
        
        basket.push(board[top][col - 1]);
        tops[col - 1] += 1;
        
        if (basket[basket.length - 1] === basket[basket.length - 2]) {
            answer += 2;
            basket.length -= 2;
        }
    });
    
    return answer;
}