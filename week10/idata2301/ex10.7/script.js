function load() {
  
  const setText = (className, text) => {
    let elements = document.getElementsByClassName(className);
    for (const element of elements) {
      element.innerText = text;
    }
  }

  setText("odd", "X");
  setText("even", "O");
  
}