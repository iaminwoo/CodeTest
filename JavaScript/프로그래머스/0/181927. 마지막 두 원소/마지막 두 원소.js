function solution(num_list) {
    const lastElement = num_list[num_list.length - 1];
    const secondLastElement = num_list[num_list.length - 2];
    
    let newElement;
    if (lastElement > secondLastElement) {
        newElement = lastElement - secondLastElement;
    } else {
        newElement = lastElement * 2;
    }
    
    let answer = [];
    answer.push(...num_list);
    answer.push(newElement);
    
    return answer;
}