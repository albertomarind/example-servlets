(function() {
	'use strict'
	function logOut() {
		const xhttp = new XMLHttpRequest();
		xhttp.onload = function() {
			document.getElementById("demo").innerHTML = this.responseText;
		}
		xhttp.open("GET", "ajax_info.txt", true);
		xhttp.send();
	}
})();