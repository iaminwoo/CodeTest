function solution(survey, choices) {
    
    const type = {
        "RT": [0, 1],
        "TR": [0, -1],
        "CF": [1, 1],
        "FC": [1, -1],
        "JM": [2, 1],
        "MJ": [2, -1],
        "AN": [3, 1],
        "NA": [3, -1],
    };
    
    const types = [0, 0, 0, 0];
    for (let i = 0 ; i in survey ; i++) {
        const t = type[survey[i]];
        let choice = choices[i] - 4;
        types[t[0]] += choice * t[1];
    }
    
    let answer = '';
    if (types[0] > 0) {
        answer += "T";
    } else {
        answer += "R";
    }
    if (types[1] > 0) {
        answer += "F";
    } else {
        answer += "C";
    }
    if (types[2] > 0) {
        answer += "M";
    } else {
        answer += "J";
    }
    if (types[3] > 0) {
        answer += "N";
    } else {
        answer += "A";
    }
    
    return answer;
}