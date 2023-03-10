function onload() {
  let sqr = Math.sqrt(1764);
  console.log(sqr);

  counter = 1;
  const timer = () => {
    console.log("Hello, " + counter++);
  };

  setInterval(timer, 1000);

  const helloButton = document.getElementById("helloButton");
  const byeButton = document.getElementById("byeButton");

  const button = (message) => {
    console.log(message);
  };

  helloButton.addEventListener("click", function () {
    button("Hello button pressed");
  });

  byeButton.addEventListener("click", function () {
    button("Bye button pressed");
  });

  const inputField = document.getElementById("inputField");
  inputField.addEventListener("keyup", function () {
    console.log("Input field was changed");
  });
}
