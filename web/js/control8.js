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
            url: 'estado8',
            data: json,
            dataType: 'json',
            success: function (data, textStatus)
            {
                //alert(JSON.stringify(data));
                if (data.error != "ErrorDB")
                {
                    updateTable(data);
                    console.log(textStatus + " - "  + loop);
                }
                else
                {
                    error  = true;
                    console.log("Error de conexion");
                    clearInterval(loop);
                }
            },
            error: function (jqXHR, textStatus, errorThrown)
            {
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
    var rows = tbody.getElementsByTagName("tr");
    var tr1 = rows.item(0);
    var tr2 = rows.item(1);
    var tr3 = rows.item(2);
    var tr4 = rows.item(3);
    var tr5 = rows.item(4);
    var tr6 = rows.item(5);
    var tr7 = rows.item(6);
    var tr8 = rows.item(7);
    var fec = info.fecha;

    var td1 = tr1.getElementsByTagName("td");
    td1.item(1).innerHTML = info.vif1;
    if (info.vif1 == 0)
    {
        td1.item(2).innerHTML =
            "<h4><span class='label label-success label-big'>Activo</span></h4>";
    }
    else
    {
        td1.item(2).innerHTML =
            "<h4><span class='label label-danger label-big'>Pasivado</span></h4>";
    }
    td1.item(3).innerHTML = fec;

    var td2 = tr2.getElementsByTagName("td");
    td2.item(1).innerHTML = info.vif2;
    if (info.vif2 == 0)
    {
        td2.item(2).innerHTML =
            "<h4><span class='label label-success label-big'>Activo</span></h4>";
    }
    else
    {
        td2.item(2).innerHTML =
            "<h4><span class='label label-danger label-big'>Pasivado</span></h4>";
    }
    td2.item(3).innerHTML = fec;

    var td3 = tr3.getElementsByTagName("td");
    td3.item(1).innerHTML = info.vcor;
    if (info.vcor == 1)
    {
        td3.item(2).innerHTML =
            "<h4><span class='label label-success label-big'>Activo</span></h4>";
    }
    else
    {
        td3.item(2).innerHTML =
            "<h4><span class='label label-danger label-big'>Pasivado</span></h4>";
    }
    td3.item(3).innerHTML = fec;

    var td4 = tr4.getElementsByTagName("td");
    td4.item(1).innerHTML = info.npc;
    if (info.npc == 0)
    {
        td4.item(2).innerHTML =
            "<h4><span class='label label-success label-big'>Activo</span></h4>";
    }
    else
    {
        td4.item(2).innerHTML =
            "<h4><span class='label label-danger label-big'>Pasivado</span></h4>";
    }
    td4.item(3).innerHTML = fec;

    var td5 = tr5.getElementsByTagName("td");
    td5.item(1).innerHTML = info.pfa1;
    if (info.pfa1 == 1)
    {
        td5.item(2).innerHTML =
            "<h4><span class='label label-success label-big'>Activo</span></h4>";
    }
    else
    {
        td5.item(2).innerHTML =
            "<h4><span class='label label-danger label-big'>Pasivado</span></h4>";
    }
    td5.item(3).innerHTML = fec;

    var td6 = tr6.getElementsByTagName("td");
    td6.item(1).innerHTML = info.pfa2;
    if (info.pfa2 == 1)
    {
        td6.item(2).innerHTML =
            "<h4><span class='label label-success label-big'>Activo</span></h4>";
    }
    else
    {
        td6.item(2).innerHTML =
            "<h4><span class='label label-danger label-big'>Pasivado</span></h4>";
    }
    td6.item(3).innerHTML = fec;

    var td7 = tr7.getElementsByTagName("td");
    td7.item(1).innerHTML = info.pfa3;
    if (info.pfa3 == 1)
    {
        td7.item(2).innerHTML =
            "<h4><span class='label label-success label-big'>Activo</span></h4>";
    }
    else
    {
        td7.item(2).innerHTML =
            "<h4><span class='label label-danger label-big'>Pasivado</span></h4>";
    }
    td7.item(3).innerHTML = fec;

    var td8 = tr8.getElementsByTagName("td");
    td8.item(1).innerHTML = info.pfa4;
    if (info.pfa4 == 1)
    {
        td8.item(2).innerHTML =
            "<h4><span class='label label-success label-big'>Activo</span></h4>";
    }
    else
    {
        td8.item(2).innerHTML =
            "<h4><span class='label label-danger label-big'>Pasivado</span></h4>";
    }
    td8.item(3).innerHTML = fec;
}
