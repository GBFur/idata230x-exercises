function load() {
  const loading_p = document.getElementById("loading");
  console.log(loading_p);
  loading_p.innerText = "Hello";

  seconds = 1;

  const timer = () => {
    const timer_s = document.getElementById("timer");
    timer_s.innerText = seconds++;
  };

  setInterval(timer, 1000);

  const a_input = document.getElementById("a");
  const b_input = document.getElementById("b");

  function multiply() {
    let a = a_input.value;
    let b = b_input.value;

    if (!isNaN(a) || !isNaN(b)) {
      document.getElementById("multiplied").innerText = "" + a * b;
    } else {
      document.getElementById("multiplied").innerText = "!NOT A NUMBER!";
    }
  }

  multiply();

  a_input.addEventListener("keyup", multiply);
  b_input.addEventListener("keyup", multiply);
}
