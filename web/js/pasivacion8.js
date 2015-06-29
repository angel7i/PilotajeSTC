function refreshTable(sta)
{
    var data = getLinea(sta);
    data = JSON.stringify(data);
    var json = "estacion=" + data;

    $.ajax(
        {
            type: 'POST',
            url: 'pasivacion8',
            data: json,
            dataType: 'json',
            success: function (data, textStatus)
            {
                //console.log(JSON.stringify(data));
                if (data.error != "ErrorDB")
                {
                    updateTable(data);
                    console.log(textStatus);
                }
                else
                {
                    console.log("Error de conexion");
                }
            },
            error: function (jqXHR, textStatus, errorThrown)
            {
                console.log("No hay conexion");
                console.log(errorThrown + ' : ' + textStatus);
            }
        });
}

$(window).load(function()
{
    var estacion = $("#estacion").val();
    //console.log(estacion);
    refreshTable(estacion);
});

function getLinea(linea)
{

    switch (linea)
    {
        case "iztacalco":
            return 1;
        case "chabacano":
            return 2;
        case "garibaldi8":
            return 3;
        case "obrera":
            return 4;
        case "iztapalapa":
            return 5;
        case "laviga":
            return 6;
        case "constitucion":
            return 7;
        case "uam":
            return 8;
        case "cerroestrella":
            return 9;
        case "escuadron":
            return 10;
        case "saltoagua":
            return 11;
        case "bellasartes":
            return 12;
        case "sanjuan":
            return 13;
        case "aculco":
            return 14;
        case "apatlaco":
            return 15;
        case "coyuya":
            return 16;
        case "doctores":
            return 17;
        case "atlalilco":
            return 18;
        case "santaanita":
            return 19;
        default : return -1;
    }
}

function updateTable(info)
{
    var table = document.getElementById("t1");
    var tbody = table.getElementsByTagName("tbody").item(0);

    for (var i=0; i<info.length; i++)
    {
        var row = tbody.insertRow();
        row.insertCell(0).innerHTML = info[i].vif1;
        row.insertCell(1).innerHTML = info[i].vif2;
        row.insertCell(2).innerHTML = info[i].vcor;
        row.insertCell(3).innerHTML = info[i].npc;
        row.insertCell(4).innerHTML = info[i].pfa1;
        row.insertCell(5).innerHTML = info[i].pfa2;
        row.insertCell(6).innerHTML = info[i].pfa3;
        row.insertCell(7).innerHTML = info[i].pfa4;
        row.insertCell(8).innerHTML = info[i].fecha;
    }

}
