function solution(arr, queries) {
    queries.forEach(q => {
        const i = q[0];
        const j = q[1];
        
        const temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    });
    return arr;
}