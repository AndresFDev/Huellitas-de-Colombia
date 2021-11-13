function SocialButtons() {
    var x = document.getElementById("footer");
    if (x.className.indexOf("show") == -1) {
        x.className += " show";
    } else { 
        x.className = x.className.replace(" show", "");
    }
}

export {SocialButtons}