function solution(wallpaper) {
    const rows = [];
    const cols = [];
    
    wallpaper.forEach((row, i) => {
        [...row].forEach((char, j) => {
            if (char === "#") {
                rows.push(i);
                cols.push(j);
            }
        });
    });
    
    return [Math.min(...rows), Math.min(...cols), Math.max(...rows) + 1, Math.max(...cols) + 1];
}