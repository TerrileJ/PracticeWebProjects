const display = document.querySelector(".calculator-display");
const numberBtns = document.querySelectorAll(".numberBtn");

// state variables
let isFirstDigit = true;

for (let btn of numberBtns) {
  console.log(btn.id);
  btn.addEventListener("click", (e) => {
    let displayText = isFirstDigit
      ? btn.innerHTML
      : display.innerHTML + btn.innerHTML;
    display.innerHTML = displayText;
    isFirstDigit = false;
  });
}
