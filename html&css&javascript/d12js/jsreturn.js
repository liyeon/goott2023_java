'use strict';
//너비 구하기 return
let width = 100;
let height = 50;
let area = getRectArea(width, height);
function getRectArea(w, h) {
  let result = h * w;
return result;
}

console.log(width+" : "+height+" result : "+area);
console.log(getRectArea(200, 20));