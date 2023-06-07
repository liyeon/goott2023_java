let time = new Date().getHours();// 현재시간
console.log(time);

let msg;
if(time < 12){
    msg="Good Morning";
}else if(time < 18){
    msg = "Good Evening";
}else{
    msg="Good Night";
}
console.log(msg);