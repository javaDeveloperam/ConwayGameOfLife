 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

 <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 <html>

 <head>
     <link href="/css/conway.css"
        rel="stylesheet">
     <script type="text/javascript" src="/js/conway.js"></script>


 </head>

 <body onload="loadNextGeneration()">
     <form:form id="conwayForm" modelAttribute="ConwayModel" action="/conway" method="POST">
         Width :
         <form:input path="xCordinate" value='${xCordinate}' />
         Height:
         <form:input path="yCordinate" value='${yCordinate}' />
         <input type="button" id="New" value="New" onclick="formGrid()">
         <input type="button" id="NextGen" value="Next generation" onclick="getInitialState()">

         <form:input type="hidden" path="liveCellList" value='${liveCellList}' />
         <div id="gridContainerDiv" class="grid-container">

         </div>
     </form:form>
 </body>

 </html>