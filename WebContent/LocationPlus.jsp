<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="NeatStyle.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Contact - Whiskey</title>
</head>
<body>
	<fieldset>
		<h1><em>${dram.name}</em></h1>

		<table><tr>
<td>
		<a href="Browse.jsp"><button>Back to Browse</button></a>
</td><td>
		<a href="index.jsp"><button>Back to Home</button></a>
</td><td>
		<form action="update.do" method="GET"><input type="hidden" name="name2" value="${dram.name}">
		<input type="submit" value="Update Whiskey"/>
		</form>
</td><td>
		<form action="delete.do" method="GET"><input type="hidden" name="name2" value="${dram.name}">
		<input type="submit" value="Delete Whiskey"/></form>
</td>
</tr></table>

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
						<li>&emsp;</li>

					</ul>
				</td>
				<td>&emsp;</td>
				<td><iframe width="350" , height="230" , frameborder="0"
						style="border: 0" src="${gUrl}"> </iframe></td>
			</tr>
		</table>

		<h3>Contact:</h3>
		<p>
			Address: ${contact.address}, ${contact.city} ${contact.state}<br>
			${contact.country} ${contact.zip}
		</p>
		<p>Phone: ${contact.phone}</p>
		<p>
			Website: <a href="${contact.url}">${contact.url}</a>
		</p>


	</fieldset>
</body>
</html>