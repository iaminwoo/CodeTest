function solution(myString, pat) {
    const newString = myString.replaceAll("A", "b").replaceAll("B", "a");
    const newPat = pat.replaceAll("A", "a").replaceAll("B", "b");
    return newString.includes(newPat) ? 1 : 0;
}