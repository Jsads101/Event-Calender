$("#main").toggleClass(localStorage.toggled);

function darkLight() {
    if (localStorage.toggled != 'dark') {
        $('#main, p').toggleClass('dark', true);
        localStorage.toggled = "dark";
    } else {
        $('#main, p').toggleClass('dark', false);
        localStorage.toggled = "";
    }
}

if ($('main').hasClass('dark')) {
    $( '#checkBox' ).prop( "checked", true )
} else {
    $( '#checkBox' ).prop( "checked", false )
}