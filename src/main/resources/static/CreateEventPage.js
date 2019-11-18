function showTeamEventForm() {
    document.getElementById('eventtypeform').style.display = "block";
  }
function hideTeamEventForm() {
    document.getElementById('eventtypeform').style.display = "none";
}
function showTeamEventForm1() {
    document.getElementById('eventtypeform1').style.display = "block";
}
function hideTeamEventForm1() {
    document.getElementById('eventtypeform1').style.display = "none";
}

// added on 16/11/2019
// Get the modal
var modal = document.getElementById("myModal");

// Get the button that opens the modal
var btn = document.getElementById("myBtn");

// Get the <span> element that closes the modal
var span = document.getElementsByClassName("close")[0];

// When the user clicks on the button, open the modal
btn.onclick = function() {
  showTeamEventForm();
  modal.style.display = "block";
}

// When the user clicks on <span> (x), close the modal
span.onclick = function() {
  modal.style.display = "none";
}
submitbutton.onclick = function() {
  modal.style.display = "none";
}

// When the user clicks anywhere outside of the modal, close it
window.onclick = function(event) {
  if (event.target == modal) {
    modal.style.display = "none";
  }
}
