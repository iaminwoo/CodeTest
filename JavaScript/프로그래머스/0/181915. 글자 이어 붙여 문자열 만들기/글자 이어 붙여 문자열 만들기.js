function solution(my_string, index_list) {
    let answer = '';
    
    for (let index of index_list) {
        answer += my_string.charAt(index);
    }
    
    return answer;
}