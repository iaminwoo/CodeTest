function solution(s, skip, index) {
    let alphbet = "abcdefghijklmnopqrstuvwxyz";
    alphbet = [...alphbet].filter(c => !skip.includes(c)).join("");
    
    const result = [...s].map(char => alphbet[(alphbet.indexOf(char) + index) % alphbet.length]).join("");
    return result;
}