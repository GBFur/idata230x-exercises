function load() {
  const colorPickerBox = document.getElementById("color-picker");

  function colorName() {
    const value = document.getElementById("color-picker").value;
    const selected = colorPickerBox.options[colorPickerBox.selectedIndex].text;
    document.getElementById("favorite-color").innerText = selected;

    if (value !== "chuck") {
      console.log(value);
      document.getElementById("color-example").style.backgroundColor = value;
      document.getElementById("color-example").style.backgroundImage = "";
    } else {
      console.log(value);
      document.getElementById("color-example").style.backgroundImage =
        "url('https://pbs.twimg.com/media/D_uDKfhXkAIOQ_8.png')";
    }
  }

  colorPickerBox.addEventListener("change", colorName);
}
