<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Livros de Java, Android, iPhone, Ruby, PHP e muito mais - Casa do C�digo</title>

<c:url value="/resources/css" var="cssPath"></c:url>
<link rel="stylesheet" href="${cssPath }/bootstrap.min.css" />
<link rel="stylesheet" href="${cssPath }/bootstrap-theme.min.css" />

<style type="text/css">
        body{
            padding: 60px 0px;
        }
    </style>

</head>
<body>
	
	<nav class="navbar navbar-inverse">
	  <div class="container">
	    <div class="navbar-header">
	      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
	        <span class="sr-only">Toggle navigation</span>
	        <span class="icon-bar"></span>
	        <span class="icon-bar"></span>
	        <span class="icon-bar"></span>
	      </button>
	      <a class="navbar-brand" href="${s:mvcUrl('HC#index').build() }">Casa do C�digo</a>
	    </div>
	    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
	      <ul class="nav navbar-nav">
	        <li><a href="${s:mvcUrl('PC#listar').build()}">Lista de Produtos</a></li>
	        <li><a href="${s:mvcUrl('PC#form').build()}">Cadastro de Produtos</a></li>
	    </ul>
	    </div><!-- /.navbar-collapse -->
	  </div>
	</nav>
	
	<div class="container">
		<h1>Cadastro de Produtos</h1>
		<form:form action="${s:mvcUrl('PC#gravar').build()}" method="post" commandName="produto" enctype="multipart/form-data">	
			<div class="form-group">			
				<label>T�tulo</label>
				<form:input path="titulo" cssClass="form-control"/>
				<form:errors path="titulo"/>
			</div>
				
			<div class="form-group">
				<label>Descri��o</label>
				<form:textarea path="descricao" cssClass="form-control"/>
				<form:errors path="descricao"/>
			</div>
			
			<div class="form-group">
				<label>P�ginas</label>
				<form:input path="paginas" cssClass="form-control"/>
				<form:errors path="paginas"/>
			</div>
			
			<div class="form-group">
				<label>Data de lan�amento</label>
				<form:input path="dataLancamento" cssClass="form-control"/>
				<form:errors path="dataLancamento"/>	
			</div>
					
			<c:forEach items="${tipos}" var="tipoPreco" varStatus="status">
				<div class="form-group">
					<label>${tipoPreco}</label>
					<form:input path="precos[${status.index}].valor" cssClass="form-control"/>
					<form:hidden path="precos[${status.index}].tipo" value="${tipoPreco}"/>
				</div>
			</c:forEach>
			
			<div class="form-group">
				<label>Sum�rio</label>
				<input name="sumario" type="file" class="form-control"/>
			</div>
			
			<button type="submit" class="btn btn-primary">Cadastrar</button>
		</form:form>
	</div>
</body>
</html>