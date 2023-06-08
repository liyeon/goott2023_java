let i;
let fruits = new Array(); //배열 선언
fruits[0]="apple1";
fruits[1]="apple2";
fruits[2]="apple3";
fruits[3]="apple4";
fruits[4]=3.14;
fruits[5]=new Date();//현재 날짜

//출력
for (let i = 0; i < fruits.length; i++) {
    console.log((i+1)+" : "+fruits[i]);
}
