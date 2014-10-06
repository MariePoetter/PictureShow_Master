 <%
 if(!(session == null || session.getAttribute("loggedin")==null|| ((Boolean) session.getAttribute("loggedin"))==false )){

  %>
<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">

    <title>MixMaPix_Gallery</title>
    <meta name="description" content="">
    <meta name="author" content="">
    <meta name="viewport" content="width=device-width">
    <link rel="stylesheet" href="css/Verzeichnis.css">

    <!--[if lt IE 9]>
        <script src="//html5shiv.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->
  </head>
  <body>

    <div class="container">
      <header>
        <h1><a href="./">Gallery</a></h1>
      </header>
        Willkommen <%= session.getAttribute("userID").toString()%>
      <div id="main" role="main">

        <div id="albums">
          <!-- <h1>Albums</h1> -->
          <ul>
            <li><a href="img/NewYork/">
              <img src="img/NewYork/02.jpg" class="album_thumb" alt="New York" title="New York" width="300px" height="300px"/></a>
              <span class="album_title">New York</span>
            </li>
			<li><a href="img/Stadt/">
              <img src="img/Stadt/04.jpg" class="album_thumb" alt="Stadt" title="Stadt" width="300px" height="300px" /></a>
               <span class="album_title">Stadt</span>
            </li>
		
            
          </ul>
        </div>



      </div>

      <footer>
        <p>      </footer>
    </div>
<%}
else{
out.println("Sie haben keinen Zugriff!!!1111einseinseinself!");
}%>
  </body>
</html>