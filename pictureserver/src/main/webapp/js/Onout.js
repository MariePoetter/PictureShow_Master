var info = document.getElementById("registry");
info.style.display = "none"; // Box ausblenden
info.style.position = "absolute";
info.style.zIndex = 999;
// Entweder fix auf der Seite platziert
// info.style.left = "50px";
// info.style.top = "100px";
// Oder ein definiertes Stückchen unter dem Knopf
info.style.marginTop = "10px";
 
function buttonShow() {
  // Infobox anzeigen
  info.style.display = "Test";
}
function buttonHide() {
  // Infobox wieder ausblenden
  info.style.display = "none";
}// JavaScript Document