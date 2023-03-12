function load() {
  const a_button = document.getElementById("A");
  const b_button = document.getElementById("B");

  function addClassStyle() {
    const paragraph = document.getElementById("paragraph");
    paragraph.classList.add("yellow");
  }

  function removeClassStyle() {
    const paragraph = document.getElementById("paragraph");
    paragraph.classList.remove("yellow");
  }

  a_button.addEventListener("click", addClassStyle);
  b_button.addEventListener("click", removeClassStyle);
}
