function solution(keymap, targets) {
    const opt = {};
    keymap.map(key => 
        [...key].map((char, idx) => {
            if (!opt[char] || opt[char] > idx + 1) opt[char] = idx + 1;
        })
    );
    
    const answer = [];
    targets.forEach(t => {
        let count = 0;
        [...t].map(char => {
            count += opt[char];
        })
        answer.push(count ? count : -1);
    });
    
    return answer;
}