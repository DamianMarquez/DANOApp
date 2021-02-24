
//var urlLocal = "http://localhost:8080";

var urlLocal = "https://danoapp.herokuapp.com";


$( document ).ready(function() {
     

$("#btnEnviar").click(function() {

   var link  = $("#url").val();

   if (link.includes("www.youtube.com")){
      var temporal = link.split("v=");
      var id2 = temporal[1].split("&")[0];
      window.location.href = urlLocal + "/video?data=" + id2;   
   }else{
      if (link.includes("https://open.spotify.com/album")) {         
         var temporal = link.split("?");         
         var id2 = temporal[0].split("album")[1].split("/")[1];
         window.location.href = urlLocal + "/spAlbum?data=" + id2;
      }else{
         if (link.includes("https://open.spotify.com/track")) {            
            var temporal = link.split("?");            
            var id2 = temporal[0].split("track")[1].split("/")[1];
            window.location.href = urlLocal + "/spSong?data=" + id2;
         }else{
            if (link.includes("https://open.spotify.com/show")) {              
            var temporal = link.split("?");            
            var id2 = temporal[0].split("show")[1].split("/")[1];            
            window.location.href = urlLocal + "/spShow?data=" + id2;            
            }else{
               if (link.includes("https://open.spotify.com/episode")) {
                  var temporal = link.split("?");
                  var id2 = temporal[0].split("episode")[1].split("/")[1];
                  window.location.href = urlLocal + "/spShowEpisode?data=" + id2;            
               }else{
                  window.location.href = urlLocal + "/web?data=" + link;
               }
            }
         }
         
      }
   }
      
   });

   $("#btnHome").click(function () {
      window.location.href = urlLocal + "/home";

   });
});