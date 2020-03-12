function formGrid() {
    var xCordinate = document.getElementById("xCordinate").value;
    var yCordinate = document.getElementById("yCordinate").value;
    var totalCell = xCordinate * yCordinate;
    var containerDiv = document.getElementById("gridContainerDiv");
    containerDiv.innerHTML = '';
    containerDiv.style.setProperty('grid-template-columns', 'repeat(' + xCordinate + ', 1fr)');

    for (k = 1; k <= totalCell; k++) {
        containerDiv.innerHTML += '<div class="grid-item" id=' + k + ' value="' + k + '" onclick="fillCell(this.id)"></div>';
    }
}

function fillCell(divId) {
    var divElement = document.getElementById(divId);
    if (divElement == null)
        return;
    var styleBGColor = typeof divElement.style;
    var bgColor = divElement.style.backgroundColor;
    if (bgColor != 'green') {
        divElement.style.setProperty('background-color', 'green');
    } else

    {
        divElement.style.setProperty('background-color', 'white');
    }

}

function getInitialState() {
    var xCordinate = document.getElementById("xCordinate").value;
    var yCordinate = document.getElementById("yCordinate").value;
    var totalCell = xCordinate * yCordinate;
    var idList = '';
    for (k = 1; k <= totalCell; k++) {
        var currentDiv = document.getElementById("" + k);
        var bgColor = currentDiv.style.backgroundColor;
        if (bgColor != 'green') {
            continue;
        } else {
            if (idList != '') {
                idList += ',';
            }
            idList += currentDiv.id


        }
    }
	if(idList=='')
	{
		alert('Please select cells to get next generation.');
		return;
	}
    document.getElementById("liveCellList").value = idList;
	document.getElementById("conwayForm").submit();
}

function loadNextGeneration() {
    formGrid();
    var liveCellList = document.getElementById("liveCellList").value.split(',');
    for (i = 0; i < liveCellList.length; i++) {
        fillCell(liveCellList[i]);
    }

}