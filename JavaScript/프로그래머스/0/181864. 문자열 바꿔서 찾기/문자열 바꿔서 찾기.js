function solution(myString, pat) {
    const converted = [...myString].map(c => c === "A" ? "B" : "A").join("");
    return converted.includes(pat) ? 1 : 0;
}