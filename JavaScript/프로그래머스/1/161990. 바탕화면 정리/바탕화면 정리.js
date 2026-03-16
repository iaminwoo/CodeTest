function solution(wallpaper) {
    let answer = [];
    
    const m = wallpaper.length;
    const n = wallpaper[0].length;
    
    let lux = 0;
    for (let i = 0 ; i < m ; i++) {
        let found = false;
        for (let j = 0 ; j < n ; j++) {
            if (wallpaper[i][j] === "#") {
                found = true;
                lux = i;
                break;
            }
        }
        if (found) break;
    }
    answer[0] = lux;
    
    let luy = 0;
    for (let i = 0 ; i < n ; i++) {
        let found = false;
        for (let j = 0 ; j < m ; j++) {
            if (wallpaper[j][i] === "#") {
                found = true;
                luy = i;
                break;
            }
        }
        if (found) break;
    }
    answer[1] = luy;
    
    let rdx = 0;
    for (let i = m - 1 ; i >= 0 ; i--) {
        let found = false;
        for (let j = n - 1 ; j >= 0 ; j--) {
            if (wallpaper[i][j] === "#") {
                found = true;
                rdx = i;
                break;
            }
        }
        if (found) break;
    }
    answer[2] = rdx + 1;
    
    let rdy = 0;
    for (let i = n - 1 ; i >= 0 ; i--) {
        let found = false;
        for (let j = m - 1 ; j >= 0 ; j--) {
            if (wallpaper[j][i] === "#") {
                found = true;
                rdy = i;
                break;
            }
        }
        if (found) break;
    }
    answer[3] = rdy + 1;
    
    return answer;
}