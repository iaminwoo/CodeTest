function solution(code) {
    let mode = 0;
    let ret = '';
    
    for (let i = 0 ; i < code.length ; i++) {
        if (code[i] === "1") {
            mode = mode === 1 ? 0 : 1;
        } else if (mode === 0) {
            if (i % 2 === 0) ret += code[i];
        } else {
            if (i % 2 !== 0) ret += code[i];
        }
    }
    
    if (ret.length === 0) ret = "EMPTY";
    
    return ret;
}