function load() {


  const asyncRequest = new XMLHttpRequest();
  const diceNumber = document.getElementById("x");
  const diceButton = document.getElementById("throw-button");

  asyncRequest.onload = onResponseReceived;

  function throwDice() {
    asyncRequest.open(
      "GET",
      "https://web-tek.ninja/php_backend/throw_a_dice.php"
    );
    asyncRequest.send();
  }

  //onResponseReceived taken from web-tek.ninja example
  function onResponseReceived() {
    // This function may be called several times when the status of the request is changing
    // With this IF we check whether the request is complete
    if (asyncRequest.readyState === XMLHttpRequest.DONE) {
      // Here we check whether we got response code 200 OK
      if (asyncRequest.status === 200) {
        console.log("Got response:");
        console.log(asyncRequest.responseText);
        diceNumber.textContent = "" + asyncRequest.responseText;
      } else {
        console.error("Error " + asyncRequest.status);
      }
    }
  }

  diceButton.addEventListener("click", throwDice);




}