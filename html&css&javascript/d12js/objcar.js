let model, speed, color, brake, accel;
class Car {
    constructor(model, speed, color) {
        this.model = model;
        this.speed = speed;
        this.color = color;
        this.brake = () => {
            this.speed -= 10; //10감소
        };
        this.accel = () => {
            this.speed += 10; //10증가
        };
    }
}
const myCar = new Car("520d", 60, "red");

console.log("model : ",myCar.model," speed : ",myCar.speed," color : ",myCar.color);
myCar.brake();
console.log("model : ",myCar.model," speed : ",myCar.speed," color : ",myCar.color);
myCar.accel();
myCar.accel();
myCar.accel();
myCar.accel();
console.log("model : ",myCar.model," speed : ",myCar.speed," color : ",myCar.color);