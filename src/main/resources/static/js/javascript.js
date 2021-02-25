
//var urlLocal = "http://localhost:8080";
var urlLocal = "https://danoapp.herokuapp.com";


function generarURL(link){
      params = {
         "data": link
      };
      $.ajax({

         url: urlLocal.concat('/makeURL?') + $.param(params),
         contentType:'application/json',
         type: 'GET',
         success: function (data) {
            window.location.href = urlLocal + data;
         },
         error: function (textStatus, jqXHR, errorThrown) {

         }
      }) 

   
}

$( document ).ready(function() {
     

$("#btnEnviar").click(function() {
   var link  = $("#url").val();
   generarURL(link);
   });

   
   $("#btnHome").click(function () {
      window.location.href = urlLocal + "/home";

   });
});