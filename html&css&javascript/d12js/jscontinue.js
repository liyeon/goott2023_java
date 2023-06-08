let msg = '';
for (let i = 0; i < 10; i++) {
  if (i === 5) continue; //5를 빼놓고 출력
  msg += i;
}
console.log(msg);
