function hello(firstname, lastname) {
  lastname = "Norris"
  return "Hello " + firstname + " " + lastname
}

console.log(hello("Gisle", "Furland"));
console.log(hello("Chuck"));

function includes(s, search) {
  if(s.includes(search)) {
    return true;
  }
  return false;
}

console.log(includes("Chuck", "u"))
console.log(includes("Chuck", "C"))
console.log(includes("Chuck", "uck"))

console.log(includes("Chuck", "a"))
console.log(includes("Chuck", "Chuckie"))
console.log(includes("Chuck", "chu"))
console.log(includes("Chuck", "Buck"))
console.log(includes("Chuck", "Mercy"))


function countA(s) {
  //return s.split("A").length -1;
  return countChars(s, "A");
}

console.log(countA("ijaAAaaa"))

function countChars(s, c) {
  return s.split(c).length -1;
}

console.log(countChars("hello i am hi", "a"))