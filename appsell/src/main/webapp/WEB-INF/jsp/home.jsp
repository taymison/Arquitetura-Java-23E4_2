<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
  	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
	<meta charset="utf-8">
	<title>AppSell</title>
</head>
<body>
	<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
	  <div class="container-fluid">
	    <ul class="navbar-nav">
	      <li class="nav-item">
	        <a class="nav-link active" href="/">AppSell</a>
	      </li>
	      <li class="nav-item">
	        <a class="nav-link" href="/seller/list">Sellers</a>
	      </li>
	      <li class="nav-item">
	        <a class="nav-link" href="/product/list">Products</a>
	      </li>
	      <li class="nav-item">
	        <a class="nav-link" href="/hardware/list">Hardwares</a>
	      </li>
	      <li class="nav-item">
	        <a class="nav-link" href="/giftCard/list">Gift Cards</a>
	      </li>
	    </ul>

		  <c:if test="${not empty list}">
			  <form class="d-flex" action="/${type}/search">
				  <input class="form-control me-2" type="text" name="search"
						 placeholder="Search">
				  <button class="btn btn-primary" type="submit">Search</button>
			  </form>
		  </c:if>
	  </div>
	</nav>
	
	<div class="container mt-3">
	
		<span class="badge rounded-pill bg-primary">Seller: ${sellerCount}</span>
	  	<span class="badge rounded-pill bg-secondary">Product: ${productCount}</span>
	  	<span class="badge rounded-pill bg-success">Hardware: ${hardwareCount}</span>
	  	<span class="badge rounded-pill bg-danger">Gift Card: ${giftCardCount}</span>
  	
  		<c:if test="${not empty list}">
			<h2>AppSell</h2>
			<p>Product Selling Management:</p>
			<table class="table">
				<thead class="table-dark">
					<tr>
						<th>${title}</th>
						<th>Actions</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="item" items="${list}">
						<tr>
							<td>${item}</td>
							<td><a href="/${type}/${item.id}/delete">delete</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:if>

		<c:if test="${empty list}">
			<hr>
			<form action="/info/insert" method="post">
				<div class="row">
					<div class="col">
						<input type="text" class="form-control"
							   placeholder="Type the field" name="field">
					</div>
					<div class="col">
						<input type="text" class="form-control"
							   placeholder="Type the description" name="description">
					</div>
					<div class="col">
						<button class="btn btn-primary" type="submit">Save</button>
					</div>
				</div>
			</form>

			<c:if test="${not empty info}">
				<hr>
				<table class="table">
					<thead class="table-dark">
					<tr>
						<th>Info:</th>
					</tr>
					</thead>
					<tbody>
					<c:forEach var="item" items="${info}">
						<tr>
							<td>${item}</td>
						</tr>
					</c:forEach>
					</tbody>
				</table>
			</c:if>
		</c:if>

		<c:if test="${not empty result}">
			<hr>
			<div class="alert alert-success">
				<strong>Success!</strong> ${result}
			</div>
		</c:if>
	</div>
</body>
</html>