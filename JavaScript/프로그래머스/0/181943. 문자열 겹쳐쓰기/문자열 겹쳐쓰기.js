function solution(my_string, overwrite_string, s) {
    const s1 = my_string.substring(0, s);
    const s2 = my_string.substring(s + overwrite_string.length);
    return s1 + overwrite_string + s2;
}