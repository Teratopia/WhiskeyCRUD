<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add - Whiskey</title>
</head>
<body>
<fieldset>
<h3>Add a Whiskey:</h3>
<form action = "newDram.do" method = "POST">
	<table>
		<tr><td>Name:</td><td><input name = "name"></td></tr>
		<tr><td>Body:</td><td><select name="body">
				<option value="0">0</option>
				<option value="1">1</option>
				<option value="2">2</option>
				<option value="3">3</option>
				<option value="4">4</option>
				<option value="5">5</option>
		</select></td></tr>
		<tr><td>Sweetness:</td><td><select name="sweet">
				<option value="0">0</option>
				<option value="1">1</option>
				<option value="2">2</option>
				<option value="3">3</option>
				<option value="4">4</option>
				<option value="5">5</option>
		</select></td></tr>
		<tr><td>Smokey:</td><td><select name="smoke">
				<option value="0">0</option>
				<option value="1">1</option>
				<option value="2">2</option>
				<option value="3">3</option>
				<option value="4">4</option>
				<option value="5">5</option>
		</select></td></tr>
		<tr><td>Medicinal:</td><td><select name="medic">
				<option value="0">0</option>
				<option value="1">1</option>
				<option value="2">2</option>
				<option value="3">3</option>
				<option value="4">4</option>
				<option value="5">5</option>
		</select></td></tr>
		<tr><td>Tobacco:</td><td><select name="tobac">
				<option value="0">0</option>
				<option value="1">1</option>
				<option value="2">2</option>
				<option value="3">3</option>
				<option value="4">4</option>
				<option value="5">5</option>
		</select></td></tr>
		<tr><td>Honey:</td><td><select name="honey">
				<option value="0">0</option>
				<option value="1">1</option>
				<option value="2">2</option>
				<option value="3">3</option>
				<option value="4">4</option>
				<option value="5">5</option>
		</select></td></tr>
		<tr><td>Spicey:</td><td><select name="spice">
				<option value="0">0</option>
				<option value="1">1</option>
				<option value="2">2</option>
				<option value="3">3</option>
				<option value="4">4</option>
				<option value="5">5</option>
		</select></td></tr>
		<tr><td>Winey:</td><td><select name="wine">
				<option value="0">0</option>
				<option value="1">1</option>
				<option value="2">2</option>
				<option value="3">3</option>
				<option value="4">4</option>
				<option value="5">5</option>
		</select></td></tr>
		<tr><td>Nutty:</td><td><select name="nut">
				<option value="0">0</option>
				<option value="1">1</option>
				<option value="2">2</option>
				<option value="3">3</option>
				<option value="4">4</option>
				<option value="5">5</option>
		</select></td></tr>
		<tr><td>Malty:</td><td><select name="malt">
				<option value="0">0</option>
				<option value="1">1</option>
				<option value="2">2</option>
				<option value="3">3</option>
				<option value="4">4</option>
				<option value="5">5</option>
		</select></td></tr>
		<tr><td>Fruity:</td><td><select name="fruit">
				<option value="0">0</option>
				<option value="1">1</option>
				<option value="2">2</option>
				<option value="3">3</option>
				<option value="4">4</option>
				<option value="5">5</option>
		</select></td></tr>
		<tr><td>Floral:</td><td><select name="flor">
				<option value="0">0</option>
				<option value="1">1</option>
				<option value="2">2</option>
				<option value="3">3</option>
				<option value="4">4</option>
				<option value="5">5</option>
		</select></td></tr>
		<!-- if time, replace with address -->
		<tr><td><input type = "submit" value = "Add Whiskey"></td>
		<td><a href="index.jsp"><button>Back</button></a></td></tr>
	</table>
</form>
</fieldset>
</body>
</html> 

<!-- RowID,Distillery,Body,Sweetness,Smoky,Medicinal,Tobacco,Honey,Spicy,Winey,Nutty,Malty,Fruity,Floral,Postcode, Latitude, Longitude
 -->