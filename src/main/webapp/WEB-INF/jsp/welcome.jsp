<%@page session="true"%>

<html>
<head>
<title>Profile</title>
<link href="/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<link href="/css/custom.css" rel="stylesheet">
<script src="/js/bootstrap.min.js"></script>
<script src="/js/jquery-1.11.1.min.js"></script>
<script src="/js/custom.js"></script>
<link rel="stylesheet" href="/css/main.css" />
</head>
<body>
	<div id="wrapper" class="animate">
    <nav class="navbar header-top fixed-top navbar-expand-lg  navbar-dark bg-dark">
      <span class="navbar-toggler-icon leftmenutrigger"></span>
      <a class="navbar-brand" href="${pageContext.request.contextPath}/welcome">${name}</a>
      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarText" aria-controls="navbarText"
        aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarText">
        <ul class="navbar-nav animate side-nav">
          <li class="nav-item">
            <a class="nav-link" href="${pageContext.request.contextPath}/welcome">Home
              <span class="sr-only">(current)</span>
            </a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="${pageContext.request.contextPath}/addNewEmployee">Add Data</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="${pageContext.request.contextPath}/getEmployees">Show Data</a>
          </li>
          <!-- <li class="nav-item">
            <a class="nav-link" onclick="document.forms['logoutForm'].submit()">Logout</a>
          </li> -->
        </ul>
        <ul class="navbar-nav ml-md-auto d-md-flex">
          <li class="nav-item">
            <a class="nav-link" href="${pageContext.request.contextPath}/welcome">Home
              <span class="sr-only">(current)</span>
            </a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="${pageContext.request.contextPath}/addNewEmployee">Add Data</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="${pageContext.request.contextPath}/getEmployees">Show Data</a>
          </li>
          <!-- <li class="nav-item">
            <a class="nav-link" onclick="document.forms['logoutForm'].submit()">Logout</a>
          </li> -->
        </ul>
      </div>
    </nav>
    
                <noscript>
		            <h2>Sorry! Your browser doesn't support Javascript</h2>
		        </noscript>
		        <div class="upload-container">
		            <div class="upload-header">
		                <h2>Spring Boot File Upload / Download Rest API</h2>
		            </div>
		            <div class="upload-content">
		                <!-- <div class="single-upload">
		                    <h3>Upload Single File</h3>
		                    <form id="singleUploadForm" name="singleUploadForm">
		                        <input id="singleFileUploadInput" type="file" name="file" class="file-input" required />
		                        <button type="submit" class="primary submit-btn">Submit</button>
		                    </form>
		                    <div class="upload-response">
		                        <div id="singleFileUploadError"></div>
		                        <div id="singleFileUploadSuccess"></div>
		                    </div>
		                </div> -->
		                <div class="multiple-upload">
		                    <h3>Upload Multiple Files</h3>
		                    <form id="multipleUploadForm" name="multipleUploadForm">
		                    	<input name="appartmentId" type="text" placeholder="Appartment Id" id="aprt_id" class="file-input"/>
		                    	<input name="documentType" type="text" placeholder="Document Type" id="doc_type" class="file-input"/>
		                        <input id="multipleFileUploadInput" type="file" name="files" class="file-input" multiple required />
		                        <input name="comments" type="text" placeholder="Comments" id="comment_id" class="file-input"/>
		                        <button type="submit" class="primary submit-btn">Submit</button>
		                    </form>
		                    <div class="upload-response">
		                        <div id="multipleFileUploadError"></div>
		                        <div id="multipleFileUploadSuccess"></div>
		                    </div>
		                </div>
		            </div>
		        </div>
		        <script src="/js/main.js" ></script>
  </div>
  
</body>
</html>



