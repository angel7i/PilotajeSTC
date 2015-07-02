var loop = null;
var error = false;
var estacion = $("#estacion").val();

$(document).ready(function()
{
});

function refreshTable()
{
    //console.log(estacion);
    var data = getLinea(estacion);
    data = JSON.stringify(data);
    var json = "estacion=" + data;

    $.ajax(
        {
            type: 'POST',
            url: 'estadoB',
            data: json,
            dataType: 'json',
            success: function (data, textStatus)
            {
                //alert(JSON.stringify(data));
                if (data.error != "ErrorConexion")
                {
                    updateTable(data);
                    console.log(textStatus + " - "  + loop);
                }
                else
                {
                    error  = true;
                    alert("No hay conexión");
                    clearInterval(loop);
                }
            },
            error: function (jqXHR, textStatus, errorThrown)
            {
                error  = true;
                clearInterval(loop);
                //console.log("loop = " +  loop);
                //alert("No hay conexion");
                //alert('Error: ' + errorThrown + ' -  ' + textStatus);
                console.log(errorThrown + ' : ' + textStatus);
            }
        });
}

$(window).load(function()
{
    refreshTable();
});

loop = window.setInterval(function()
{
    if (!error)
        refreshTable();
},30000);

function getLinea(linea)
{
    switch (linea)
    {
        case "romerorubio":
            return 1;
        case "buenavista":
            return 2;
        case "garibaldiB":
            return 3;
        case "tepito":
            return 4;
        case "sanlazaro":
            return 5;
        case "oceania":
            return 6;
        case "villaaragon":
            return 7;
        case "impulsora":
            return 8;
        case "muzquiz":
            return 9;
        case "olimpica":
            return 10;
        case "cdazteca":
            return 11;
        case "pmtcdazteca":
            return 12;
        default : return -1;
    }
}

function updateTable(info)
{
    var table = document.getElementById("t1");
    var tbody = table.getElementsByTagName("tbody").item(0);
    var rows = tbody.getElementsByTagName("tr");
    var tr1 = rows.item(0);
    var tr2 = rows.item(1);
    var tr3 = rows.item(2);

    var td1 = tr1.getElementsByTagName("td");
    td1.item(1).innerHTML = info[0].estado;
    if (info[0].estado == 1)
    {
        td1.item(2).innerHTML =
            "<h4><span class='label label-success label-big'>Activo</span></h4>";
    }
    else
    {
        td1.item(2).innerHTML =
            "<h4><span class='label label-danger label-big'>Pasivado</span></h4>";
    }
    td1.item(3).innerHTML = info[0].fecha;

    var td2 = tr2.getElementsByTagName("td");
    td2.item(1).innerHTML = info[1].estado;
    if (info[1].estado == 1)
    {
        td2.item(2).innerHTML =
            "<h4><span class='label label-success label-big'>Activo</span></h4>";
    }
    else
    {
        td2.item(2).innerHTML =
            "<h4><span class='label label-danger label-big'>Pasivado</span></h4>";
    }
    td2.item(3).innerHTML = info[1].fecha;

    var td3 = tr3.getElementsByTagName("td");
    td3.item(1).innerHTML = info[2].estado;
    if (info[2].estado == 1)
    {
        td3.item(2).innerHTML =
            "<h4><span class='label label-success label-big'>Activo</span></h4>";
    }
    else
    {
        td3.item(2).innerHTML =
            "<h4><span class='label label-danger label-big'>Pasivado</span></h4>";
    }
    td3.item(3).innerHTML = info[2].fecha;
}
