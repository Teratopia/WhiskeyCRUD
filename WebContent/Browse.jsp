<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="PubStyle.css">
<title>Browse - Whiskey</title>
</head>
<body>
	<fieldset>
		<h1>Browse</h1>
		<h5>
			<a href="index.jsp"><button>Back to Home</button></a><a href="Add.jsp"><button>Add Whiskey</button></a>
			<form action="tasteSort.do" method="GET">
			
				<input type="submit" value="Browse by Taste" />
				<input type="checkbox" name="checks" value="body">Body
				<input type="checkbox" name="checks" value="sweet">Sweetness
				<input type="checkbox" name="checks" value="smoke">Smokiness
				<input type="checkbox" name="checks" value="medic">Medicinal
				<input type="checkbox" name="checks" value="tobac">Tobacco
				<input type="checkbox" name="checks" value="honey">Honey
				<input type="checkbox" name="checks" value="spice">Spicy
				<input type="checkbox" name="checks" value="wine">Winey
				<input type="checkbox" name="checks" value="nut">Nutty
				<input type="checkbox" name="checks" value="malt">Malty
				<input type="checkbox" name="checks" value="fruit">Fruity
				<input type="checkbox" name="checks" value="flor">Floral </select> 

			</form>
			<form action="sortDrams.do" method="GET">
				<input type="submit" value="Sort by:" />
				<select name="select">
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
				</select> 
			</form>
		</h5>
		<table>
		<c:choose>
			<c:when test="${sortedDrams.size()!=null}">
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
				<th>Taste Score</th>
			</tr>
				</c:when>
				<c:otherwise>
				
				</c:otherwise>
				</c:choose>
			<c:forEach var="dram" items="${sortedDrams}" varStatus="loop">
				<tr>
					<td>
						<form action="Location.do" method="GET">
							<input type="submit" value="${dram.name}" name="dramName">
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
					<td>${tasteDrams.get(loop.index)}</td>
				</tr>
			</c:forEach>
		</table>
	</fieldset>

</body>
</html>

<!-- RowID,Distillery,Body,Sweetness,Smoky,Medicinal,Tobacco,Honey,Spicy,Winey,Nutty,Malty,Fruity,Floral,Postcode, Latitude, Longitude
 -->