//función de inicio Jquery
var primeraFila; //variable global
$(function(){   
    $("#txtFechaNacimiento").datepicker({
        changeMonth: true,
        changeYear: true,
        dateFormat:"yy/mm/dd",       
        maxDate:  "0D"
    });
    //almacenando la primera fila de la tabla
    primeraFila = $("#fila"); 

    /**
     * Acción del evento click del botón
     * llamado btnConsultar
     */
    $("#btnConsultar").click(function(){
        if ($("#txtIdentificacion").val()!==""){
            $("#idAprendiz").val("");
            $("#msjIdentifica").html("");
            consultarAprendiz();
        }else{
            alert("Debe ingresar la identificación del Aprendiz");
            $("#txtIdentificacion").focus();
        }
    });
        
    /*El botón agregar se coloca como tipo submit para hacer las
    validaciones de los controles con html5*/
  
    $("#btnAgregar").click(function(){        
        agregarAprendiz();  
    }); 
    
    
    $("#btnActualizar").click(function(){         
        if ($("#idAprendiz").val()===""){
            alert("Debe primero Consultar un Aprendiz");   
            $("#txtIdentificacion").focus();
        }else{
            actualizarAprendiz();
        } 
    });
    
    /*Primero se abre la ventana modal y a partir de ella se llama
    el método que hace el ajax*/
    $("#btnEliminar").click(function(){        
        if ($("#idAprendiz").val()===""){
           alert("Debe primero hacer una consulta de un Aprendiz");
           $("#txtIdentificacion").focus();
        }else{
            $("#modalEliminar").modal();
        }
    });
    
    //Botón si del Modal de Eliminar Aprendiz
    $("#btnSiModal").click(function(){
        eliminarAprendiz();
    });  
    
    $("#btnListar").click(function(){
        listarAprendices();
    });  
    
    $("#txtIdentificacion").change(function(){
        existeAprendiz();
    });
    
 });
/**
 * Agrega un aprendiz. Envía todo el formulario
 * @returns true o false
 */
function agregarAprendiz(){   
    $("#mensaje").html("");   
    $.ajax({ 
         // la URL para la petición
        url: '../ControllerAprendiz', 
        
        // la información a enviar
        data:$("#frmAprendiz").serialize(),
        
        // el tipo de información que se espera de respuesta
        dataType:'json',
        
        // especifica si será una petición POST o GET
        type: 'post',        
        
        /*Un valor booleano que indica si el navegador 
        *debe almacenar en caché las páginas solicitadas. 
        *El valor predeterminado es verdadero*/
        cache: false,
        
        /* código a ejecutar si la petición es satisfactoria;
         * la respuesta es pasada como argumento a la función */
        success: function (resultado) {
            console.log(resultado);
            if (resultado){
                $("#mensaje").html("Aprendiz Agregado Correctamente"); 
                limpiar();
                listarAprendices();
            }else{
                $("#mensaje").html("Problemas al agregar el aprendiz");
            }     
        },
        /*Código a ejecutar si la petición
         * falla */
        error: function(ex){
          console.log(ex.responseText);
        }
    });
}
/**
 * Método que consulta un aprendiz dada la identificación
 * realiza un llamado mediante Ajax.
 * @returns Objeto Aprendiz en formato Json
 */
function consultarAprendiz(){
    $("#mensaje").html("");
    $("#msj").show();
    var identificacion = $("#txtIdentificacion").val();
    limpiar();
    $("#txtIdentificacion").val(identificacion);
    var parametros = {
        accion:"Consultar",
        identificacion:$("#txtIdentificacion").val()
    };
    $.ajax({       
        url: '../ControllerAprendiz',      
        data:parametros,
        type: 'post', 
        dataType: 'json',  
        cache: false,
        success: function (resultado) {
            console.log(resultado);
            if (resultado!==null){                
                $("#idAprendiz").val(resultado.idAprendiz);
                $("#txtNombres").val(resultado.nombres);
                $("#txtApellidos").val(resultado.apellidos);
                $("#txtCorreo").val(resultado.correo);
                $("#cbGenero").val(resultado.genero);
                $("#txtFechaNacimiento").val(resultado.fechaNacimiento);
                $("#cbCurso").val(resultado.unCurso.idCurso);
            }else{
                $("#mensaje").html("No Existe Aprendiz con esa Identificación");
            }
        },
        error: function(ex){
          console.log(ex.responseText);
        }
    });    
}

/**
 * Método que actualiza un aprendiz de acuerdo al
 * id del Aprendiz. Se envía los datos mediante Ajax.
 * @returns true o false
 */
function actualizarAprendiz(){
    
    $("#accion").val("Actualizar");   
    $.ajax({       
        url: '../ControllerAprendiz',      
        data:$("#frmAprendiz").serialize(),
        dataType:'json',
        type: 'post',                     
        cache: false,
        success: function (resultado) {
            console.log(resultado);
            if (resultado){                
                listarAprendices();
                $("#mensaje").html("Aprendiz Actualizado Correctamente");
            }else{
                $("#mensaje").html("Problemas al actualizar el aprendiz");
            }  
        },
        error: function(ex){
          console.log(ex.responseText);
        }  
    });
}

/**
 * Método que limpia las cajas de texto
 * @returns
 */

function eliminarAprendiz(){
    var parametros={
        idAprendiz:$("#idAprendiz").val(),
        accion:"Eliminar"        
    }; 
    $.ajax({       
        url: '../ControllerAprendiz',      
        data:parametros,
        type: 'post', 
        dataType: 'json',  
        cache: false,
        success: function (resultado) {
            console.log(resultado);
            if (resultado!==null){               
                limpiar();
                listarAprendices();
                 $("#mensaje").html("Aprendiz Eliminadio Correctamente");
            }else{
                $("#mensaje").html("No se pudo eliminar el Aprendiz");
            }
        },
        error: function(ex){
          console.log(ex.responseText);
        }
    });
}

/**
 * Obtener listado de aprendices mediante
 * ajax.
 * @returns lista de aprendices objeto Json
 */
function listarAprendices(){    
    $("#tblAprendices").show();
    $("#mensaje").html("");
    //eliminar los datos de la tabla    
    $(".otraFila").remove();
    //agregar la primera fila vacía
    $("#tblAprendices tbody").append(primeraFila);
    var parametros= {       
        accion:"Listar"      
    }; 
    $.ajax({       
        url: '../ControllerAprendiz',      
        data:parametros,
        type: 'post', 
        dataType: 'json',  
        cache: false,
        success: function (resultado) {
            console.log(resultado); 
            var aprendices = resultado;
            $.each(aprendices, function (i, aprendiz) {
                $("#aIdentifica").html(aprendiz.aprIdentificacion);
                $("#aNombres").html(aprendiz.aprNombres);
                $("#aApellidos").html(aprendiz.aprApellidos);
                $("#aCorreo").html(aprendiz.aprCorreo);
                $("#aGenero").html(aprendiz.aprGenero);            
                $("#aFechaNacimiento").html(aprendiz.aprFechaNacimiento);   
                $("#tblAprendices tbody").append($("#fila").clone(true).attr("class","otraFila"));
            });
            $("#tblAprendices tbody tr").first().remove(); 
          //  $("#tblAprendices").DataTable();
        },
        error: function(ex){
          console.log(ex.responseText);
        }
    });
}

function existeAprendiz(){
    $("#mensaje").html("");
    var parametros={
        accion:"Existe",
        identificacion: $("#txtIdentificacion").val()
    };      
  
    $.ajax({       
        url: '../ControllerAprendiz',      
        data:parametros,
        type: 'get', 
        dataType: 'json',  
        cache: false,
        success: function (resultado) {
            console.log(resultado);
            if (resultado!==null){
                var nombreAprendiz = resultado.nombres + " " + resultado.apellidos;
              $("#msjIdentifica").html("Ya existe aprendiz con la identificación: \n \n\
                su nombre es: " + nombreAprendiz);
            }else{
                $("#msjIdentifica").html("");
            }
        },
        error: function(ex){
          console.log(ex.responseText);
        }
    });  
}


/**
 * Método que limpia las cajas de texto
 * @returns {undefined}
 */
function limpiar(){ 
    $("#txtIdentificacion").val("");
    $("#txtNombres").val("");
    $("#txtApellidos").val("");
    $("#txtCorreo").val("");    
    $("#txtFechaNacimiento").val(""); 
}



