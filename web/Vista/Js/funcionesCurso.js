/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(function(){
    listarCursos();
    $("#btnAgregarCurso").click(function(){
        if ($("#txtCodigo").val()!=="" && $("#txtNombre").val()!=="" ){
             agregarCurso();
        }else{
            $("#toastMensaje").html("Faltan datos para poder agregar el Curso");
            $('.toast').toast({delay:5000});
            $('.toast').toast('show');
             
        }       
    });    
   
});

/**
 * Hace la petición al servidor mediante ajax
 * para agregar el curso.
 * @returns {undefined}
 */
function agregarCurso(){
    $("#accion").val("Agregar");
    $.ajax({
        url:"../ControllerCurso",
        data:$("#frmCurso").serialize(),
        type:"post",
        dataType:'json',
        cache:false,
        success: function(resultado){
            console.log(resultado);
            if (resultado){            
                $("#mensaje").html("Curso Agregado Correctamente");
                $("#txtCodigo").val("");
                $("#txtNombre").val("");
            }else{
                $("#mensaje").html("Problemas al agregar el Curso");
            }  
        },
        error: function(ex){
            console.log(ex.responseText);
        }
        
    });
}

function listarCursos(){
    var parametros= {       
        accion:"Listar"        
    }; 
    $.ajax({       
        url: '../ControllerCurso',      
        data:parametros,
        type: 'post', 
        dataType: 'json',  
        cache: false,
        success: function (resultado) {
            console.log(resultado); 
            var cursos = resultado;
            $.each(cursos, function (i, curso) {
                $('#cbCurso').append(
                    $('<option>', { 
                        value: curso.idCurso,
                        text : curso.codigo + "-->" + curso.nombre 
                    })
                );
            });
        },
        error: function(ex){
          console.log(ex.responseText);
        }
    });
}