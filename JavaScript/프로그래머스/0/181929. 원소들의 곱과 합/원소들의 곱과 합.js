function solution(num_list) {
    var answer = 0;
    
    var sum = 0;
    var product = 1;
    
    for (var num of num_list) {
        sum += num;
        product *= num;
    }
    
    if (product < sum * sum) answer = 1;
    
    return answer;
}