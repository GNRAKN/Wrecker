<%@page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="tr">
<head>

<title>Wrecker</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="resources/css/style.css">
</head>

<body data-spy="scroll" data-target=".navbar" data-offset="50">

	<nav class="navbar navbar-inverse navbar-fixed-top">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#myNavbar">
					<span class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="/">Wrecker</a>
			</div>
			<div>
				<div class="collapse navbar-collapse" id="myNavbar">
					<ul class="nav navbar-nav">
						<li><a href="#servisKayit">Servis Kayıt</a></li>
						<li><a href="#isListele">İşler</a></li>
						

					</ul>
				</div>
			</div>
		</div>
	</nav>

	<div id="servisKayit" class="container-fluid">
		<h1>Servis Kayıt</h1>
		<h4>
			<u>Arızalı veya bakım tarihi gelmiş ürünlerin kayıt işlemleri
				buradan yapılmaktadır.</u>
		</h4>
		<p>Servise gelen ürünlerin girişleri buradan yapılmaktadır.
			Müşteri bilgileri de ürünle birlikte alınır ve ilişkilendirilerek
			farklı tablolara kayıt edilirler. Ürünün statüsü belirlenerek
			üzerinde yapılan işlemler belirlenir yada sonraya bırakılır.</p>
		<a href="/kaydetIs" class="btn btn-default" role="button">Git</a>
	</div>


	<div id="isListele" class="container-fluid">
		<h1>İşler</h1>
		<h4>
			<u>Servis kaydı bulunan tüm işleri görüntüleyin.</u>
		</h4>
		<p>Servise gelen tüm işleri kategori ve aktif veya pasif olma
			durumuna göre filtreleyerek görüntüleyebilir ve güncelleyebilirsiniz.</p>
		<a href="/listeleIs" class="btn btn-default" role="button">Git</a>
	</div>
	


</body>
</html>