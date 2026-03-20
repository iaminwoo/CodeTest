function solution(arr, queries) {
    return queries.map(([ start, end, k ]) => {
        let num = Infinity;
        
        for (let i = start ; i <= end ; i++) {
            if (arr[i] > k && arr[i] < num) num = arr[i];
        }
        return num === Infinity ? -1 : num;
    });
}