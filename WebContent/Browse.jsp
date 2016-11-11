<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Browse - Whiskey</title>
</head>
<body>
	<fieldset>
			<h3>Browse</h3>
			<h5>
		<a href="index.jsp"><button>Home</button></a>
		<form action="sortDrams.do" method="GET">
				Browse by: <select name="select">
					<option value="name">Name</option>
					<option value="body">Body</option>
					<option value="sweet">Sweetness</option>
					<option value="smoke">Smoke</option>
					<option value="medic">Medicinal</option>
					<option value="tobac">Tobacco</option>
					<option value="honey">Honey</option>
					<option value="spice">Spicey</option>
					<option value="wine">Winey</option>
					<option value="nut">Nutty</option>
					<option value="malt">Malty</option>
					<option value="fruit">Fruity</option>
					<option value="flor">Floral</option>
				</select> <input type="submit" value="Sort" />
		</form>
			</h5>
		<table>
			<tr>
				<th>Name</th>
				<th>Body</th>
				<th>Sweetness</th>
				<th>Smokiness</th>
				<th>Medicinal</th>
				<th>Tobacco</th>
				<th>Honey</th>
				<th>Spicey</th>
				<th>Winey</th>
				<th>Nutty</th>
				<th>Malty</th>
				<th>Fruity</th>
				<th>Floral</th>
			</tr>
			<tr>
				<c:forEach var="dram" items="${sortedDrams}">
					<td>
					<form action = "Location.do" method = "GET">
					<input type = "submit" value ="${dram.name}" name = "dramName">
					</form>
					</td>
					<td>${dram.body}</td>
					<td>${dram.sweet}</td>
					<td>${dram.smoke}</td>
					<td>${dram.medic}</td>
					<td>${dram.tobac}</td>
					<td>${dram.honey}</td>
					<td>${dram.spice}</td>
					<td>${dram.wine}</td>
					<td>${dram.nut}</td>
					<td>${dram.malt}</td>
					<td>${dram.fruit}</td>
					<td>${dram.flor}</td>
			</tr>
			</c:forEach>
		</table>
	</fieldset>

</body>
</html>

<!-- RowID,Distillery,Body,Sweetness,Smoky,Medicinal,Tobacco,Honey,Spicy,Winey,Nutty,Malty,Fruity,Floral,Postcode, Latitude, Longitude
 -->