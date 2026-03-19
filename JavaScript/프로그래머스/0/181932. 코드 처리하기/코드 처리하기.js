function solution(code) {
    let ret = [...code.replaceAll("1","")].filter((c, i) => i % 2 === 0).join("");  
    return ret.length === 0 ? "EMPTY" : ret;
}