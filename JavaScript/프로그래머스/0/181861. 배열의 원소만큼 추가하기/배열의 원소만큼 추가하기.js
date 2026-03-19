function solution(arr) {
    const answer = [];
    
    for (let i = 0 ; i < arr.length ; i++) {
        const num = arr[i];
        for (let j = 0 ; j < num ; j++) answer.push(num);
    }
    
    return answer;
}