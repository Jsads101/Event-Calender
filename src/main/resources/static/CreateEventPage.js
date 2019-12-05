function showTeamEventForm() {
    document.getElementById('eventtypeform').style.display = "block";
}
function hideTeamEventForm() {
    document.getElementById('eventtypeform').style.display = "none";
}

function showDietReq(){
    document.getElementById('dietReqForm').style.display="block";
}

function hideDietReq(){
    document.getElementById('dietReqForm').style.display="none";
}



// Get the modal
var modal1 = document.getElementById("myModal-one");

// Get the button that opens the modal
var btn1 = document.getElementById("myBtn")

// Get the <span> element that closes the modal
var span1 = document.getElementsByClassName("close1")[0];

// When the user clicks on the button, open the modal
btn1.onclick = function() {
    modal1.style.display = "block";
}

// When the user clicks on <span> (x), close the modal
span1.onclick = function() {
    modal1.style.display = "none";
}

// When the user clicks anywhere outside of the modal, close it
window.onclick = function(event) {
    if (event.target == modal) {
        modal1.style.display = "none";
    }
}

// Modal for cancel attending
// Get the modal
var modal2 = document.getElementById("myModal-two");

// Get the button that opens the modal
var btn2 = document.getElementById("cancelBtn-one");

// Get the <span> element that closes the modal
var span2 = document.getElementsByClassName("close2")[0];

// When the user clicks on the button, open the modal
btn2.onclick = function() {
    modal2.style.display = "block";
}

// When the user clicks on <span> (x), close the modal
span2.onclick = function() {
    modal2.style.display = "none";
}

// When the user clicks anywhere outside of the modal, close it
window.onclick = function(event) {
    if (event.target == modal) {
        modal2.style.display = "none";
    }
}
// End of modal js for cancel attending