<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Location - Whiskey</title>
</head>
<body>

	<!-- //RowID,Distillery,Body,Sweetness,Smoky,Medicinal,Tobacco,Honey,
//Spicy,Winey,Nutty,Malty,Fruity,Floral,Postcode, Latitude, Longitude -->

	<h1>${dram.name}</h1>
	<table>
		<tr>
			<td>
				<ul>
					<li>Body: ${dram.body}</li>
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
				</ul>
			</td>
			<td><iframe width="450" , height="280" , frameborder="0"
					style="border: 0"
					src="https://www.google.com/maps/embed/v1/view?key=AIzaSyBai9RCT_s_yO9KpNpV650lnLk4PpH8JAE
    				 &center=${dram.lat},${dram.longi}&zoom=14&maptype=satellite">
				</iframe></td>
		</tr>
	</table>

</body>
</html>