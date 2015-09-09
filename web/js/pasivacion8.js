var estacion = null;

$(document).ready(function()
{
    $("#dateFrom").datetimepicker(
        {
            format:'Y/m/d H:i',
            lang: "es",
            onShow:function(ct)
            {
                var date =  new Date($('#dateTo').val());
                var df = date.dateFormat("Y/m/d");

                this.setOptions(
                {
                    maxDate: date != null ? df : new Date()
                })
            }
        }
    );
    $("#dateTo").datetimepicker(
        {
            format:'Y/m/d H:i',
            lang: "es",
            onShow:function(ct)
            {
                var date =  new Date($('#dateFrom').val());
                var df = date.dateFormat("Y/m/d");

                this.setOptions(
                {
                    maxDate: new Date(),
                    minDate: $('#dateFrom').val() ? df : false
                })
            }
        }
    );
    $('#buscar').puibutton({
        icon: 'fa-search'
    });

    $('#buscar').on("click", function()
    {
        var from = $("#dateFrom").val();
        var to = $("#dateTo").val();

        if (from.length == 0 || to.length == 0)
        {
            alert("Selecciona las fechas a buscar");
        }
        else
        {
            $('#t1').remove();
            var t = "<div id='t1'></div>";
            $("#nextReport").after(t);
            $('#t1').puidatatable(
                {
                    responsive : true,
                    paginator:
                    {
                        rows: 20
                    },
                    columns:
                        [
                            {field:'vif1', headerText: 'VIF1'},
                            {field:'vif2', headerText: 'VIF2'},
                            {field:'vcor', headerText: 'VCOR'},
                            {field:'npc', headerText: 'NPC'},
                            {field:'pfa1', headerText: 'PFA1'},
                            {field:'pfa2', headerText: 'PFA2'},
                            {field:'pfa3', headerText: 'PFA3'},
                            {field:'pfa4', headerText: 'PFA4'},
                            {field:'fecha', headerText: 'Fecha', sortable:true, content: format}
                        ],
                    datasource: function(callback)
                    {
                        $.ajax({
                            type: 'POST',
                            url: 'pasivacion8',
                            data: "estacion=" + getLinea(estacion) + "&from=" + from + "&to=" + to,
                            dataType: 'json',
                            context: this,
                            success: function(response)
                            {
                                callback.call(this, response);
                            },
                            error: function (textStatus, errorThrown)
                            {
                                console.log("No hay conexion");
                                console.log(errorThrown + ' : ' + textStatus);
                            }
                        });
                    },
                    selectionMode: 'single',
                    rowSelect: function(event, data)
                    {
                        $('#messages').remove();
                        var message = "<div id='messages' title='Detalle' style='position: fixed; display: inline-block'>" +
                            "Fecha: " + data.fecha +
                            "</div>";
                        $("#nextReport").after(message);
                        $('#messages').puidialog(
                        {
                            closable: true
                        });
                    },
                    rowUnselect: function(event, data)
                    {
                        $('#messages').remove();
                    }
                });
        }
    });
});

function refreshTable()
{
    var json = "estacion=" + getLinea(estacion);

    $('#t1').puidatatable(
    {
        responsive : true,
        paginator:
        {
            rows: 20
        },
        columns:
        [
            {field:'vif1', headerText: 'VIF1'},
            {field:'vif2', headerText: 'VIF2'},
            {field:'vcor', headerText: 'VCOR'},
            {field:'npc', headerText: 'NPC'},
            {field:'pfa1', headerText: 'PFA1'},
            {field:'pfa2', headerText: 'PFA2'},
            {field:'pfa3', headerText: 'PFA3'},
            {field:'pfa4', headerText: 'PFA4'},
            {field:'fecha', headerText: 'Fecha', sortable:true}
        ],
        datasource: function(callback)
        {
            $.ajax(
            {
                type: 'POST',
                url: 'pasivacion8',
                data: json,
                dataType: 'json',
                context: this,
                success: function(response)
                {
                    callback.call(this, response);
                },
                error: function (textStatus, errorThrown)
                {
                    console.log("No hay conexion");
                    console.log(errorThrown + ' : ' + textStatus);
                }
            });
        },
        selectionMode: 'single',
        rowSelect: function(event, data)
        {
            $('#messages').remove();
            var message = "<div id='messages' title='Detalle'>" +
                "<table class='table table-hover'>" +
                    "<thead>" +
                    "<tr>" +
                        "<th>Nombre</th>" +
                        "<th>Estado</th>" +
                        "<th>Actividad</th>" +
                        "<th>Fecha</th>" +
                    "<tr>" +
                    "</thead>" +
                "</table>" +
                "Fecha: " + data.fecha +
                "</div>";
            $("#t1").before(message);
            $('#messages').puidialog( {
                location: "center top",
                closable: true,
                draggable: true,
                responsive: true
            });
            $('#messages').puidialog("show");
        },
        rowUnselect: function(event, data)
        {
            $('#messages').remove();
        }
    });
    $('#t1').show();
}

$(window).load(function()
{
    estacion = $("#estacion").val();
    //console.log(estacion);
    //refreshTable();
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

function format(data)
{
    return data.fecha.replace(/(\r\n|\n|\r)/gm, "<br>");
}


