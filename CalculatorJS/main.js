const display = document.querySelector(".calculator-display");
const numberBtns = document.querySelectorAll(".numberBtn");
const operationBtns = document.querySelectorAll(".operationBtn");

const equals = document.getElementById("equals");
const clear = document.getElementById("clear");

// state variables
let res = 0;
let isFirstDigit = true;
let isStart = true;
let afterEquals = false;
let operation = "";

// number button implementation
for (let btn of numberBtns) {
  btn.addEventListener("click", (e) => {
    if (afterEquals) return; // cannot click a number after pressing equals, without clearing

    let displayText = isFirstDigit
      ? btn.innerHTML
      : display.innerHTML + btn.innerHTML;
    display.innerHTML = displayText;
    isFirstDigit = false;
  });
}

// operation button implementation
for (let btn of operationBtns) {
  btn.addEventListener("click", (e) => {
    if (isFirstDigit) {
      operation = btn.id; // if first digit = true, then means we just pressed an operation. Simply switch the operation
      return;
    }

    isFirstDigit = true; // after an operation, always true that next number will be first digit of its value
    afterEquals = false;

    // if just starting, update result accordingly
    if (isStart) {
      res = Number(display.innerHTML);
      isStart = false;
      operation = btn.id; // update operation for next calculation
      return;
    }

    switch (operation) {
      case "plus":
        res += Number(display.innerHTML);
        break;
      case "minus":
        res -= Number(display.innerHTML);
        break;
      case "multiply":
        res *= Number(display.innerHTML);
        break;
    }

    operation = btn.id;
    display.innerHTML = String(res); // update display
  });
}

// other button implementations
equals.addEventListener("click", (e) => {
  switch (operation) {
    case "plus":
      res += Number(display.innerHTML);
      break;
    case "minus":
      res -= Number(display.innerHTML);
      break;
    case "multiply":
      res *= Number(display.innerHTML);
      break;
  }

  operation = "";
  display.innerHTML = String(res); // update display
  afterEquals = true;
  isFirstDigit = false;
});

clear.addEventListener("click", (e) => {
  res = 0;
  isFirstDigit = true;
  isStart = true;
  afterEquals = false;
  operation = "";

  display.innerHTML = "";
});
