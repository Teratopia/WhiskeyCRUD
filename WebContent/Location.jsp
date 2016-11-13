<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="NeatStyle.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Location - Whiskey</title>
</head>
<body>
	<fieldset>

		<!-- //RowID,Distillery,Body,Sweetness,Smoky,Medicinal,Tobacco,Honey,
//Spicy,Winey,Nutty,Malty,Fruity,Floral,Postcode, Latitude, Longitude -->

		<h1 name="name" value="${dram.name}"><em>${dram.name}</em></h1>
		<a href="Browse.jsp"><button>Back to Browse</button></a><a
			href="index.jsp"><button>Back to Home</button></a>
		<table>
			<tr>
				<td>
					<ul><li>Body: ${dram.body}</li>
						<li>Sweetness: ${dram.sweet}</li>
						<li>Smokiness: ${dram.smoke}</li>
						<li>Medicinal: ${dram.medic}</li>
						<li>Tobacco: ${dram.tobac}</li>
						<li>Honey: ${dram.honey}</li>
						<li>Spice: ${dram.spice}</li>
						<li>Winey: ${dram.wine}</li>
						<li>Nutty: ${dram.nut}</li>
						<li>Malty: ${dram.malt}</li>
						<li>Fruity: ${dram.fruit}</li>
						<li>Floral: ${dram.flor}</li>
						<li>&emsp;</li>
					</ul>
				</td><td>&emsp;</td>
				<td><iframe width="340" , height="210" , frameborder="0"
						style="border: 0"
						src="https://www.google.com/maps/embed/v1/place?key=AIzaSyBai9RCT_s_yO9KpNpV650lnLk4PpH8JAE&&q=${dram.name},+UK&zoom=10">
					</iframe></td>
			</tr>
		</table>
		<h3>Add a Contact!</h3>
		<form action="addContact.do" method="GET">
			<input type="hidden" name="name" value="${dram.name}"> <input
				type="text" name="address" value="Address"> <input
				type="text" name="city" value="City"> <input type="text"
				name="state" value="State"><br> <input type="text"
				name="country" value="Country"> <input type="text"
				name="zip" value="Zip Code"> <input type="text" name="phone"
				value="Phone Number"> <input type="text" name="url"
				value="Website URL"> <input type="submit" value="Submit" />
		</form>
	</fieldset>
</body>
</html>