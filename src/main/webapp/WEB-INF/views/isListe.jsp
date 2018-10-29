<%@page import="com.gunerakin.controller.MainController"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>
<head>



<title>İş Listesi</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="resources/js/siklariGoster.js"></script>


</head>
<body>

	<div class="container myrow-container">
		<div class="panel panel-warning">
			<div class="panel-heading">
				<h3 class="panel-title">
					<div align="left">
						<b>İş Listele</b>
					</div>
					<div align="right">
						<a href="kaydetIs">İş ekle</a>


					</div>
				</h3>
			</div>
			<div class="panel-body">
				<form class="form-inline" action="listeleIs" method="post">


					<div class="form-group">
						<select class="form-control" id="statu" name="statu">
							<option value="">-- Statü seçiniz --</option>

							<c:forEach items="${status}" var="s">
								<option value="${s.key}">${s.value}</option>
							</c:forEach>


						</select>
					</div>

					<button type="submit" class="btn btn-default">Filtrele</button>
				</form>




				<c:if test="${empty isler}">
					<c:out value="Kayıt yok"></c:out>
				</c:if>
				<c:if test="${not empty isler}">




					<table class="table table-hover table-bordered">
						<thead style="background-color: #F2F5A9;">
							<tr>
								<th>Ürün</th>
								<th>Açıklama</th>
								<th>Statü</th>
								<th>Kategori</th>
								<th>Detay</th>
								<th>Düzenle</th>
								<th>Sil</th>

							</tr>
						</thead>
						<tbody>
							<c:forEach items="${isler}" var="i" varStatus="e">
								<tr>
									<c:set value="${i.is_statu}" var="key" />
									<th><c:out value="${i.urun.urun_adi}" /></th>
									<th><c:out value="${i.is_detay}" /></th>
									<th><c:out value="${status[key]}" /></th>
									<th><c:out value="${i.urun.kategori.kategori_adi}" /></th>
									<th><button data-toggle="modal"
											data-target="#myModal${e.index}">Detay Göster</button></th>




									<th><a href="guncelleIs?is_id=<c:out value='${i.is_id}'/>">Düzenle</a></th>
									<th><a href="silIs?is_id=<c:out value='${i.is_id}'/>">Sil</a></th>


								</tr>

								<div class="modal" id="myModal${e.index}" role="dialog">
									<div class="modal-dialog">


										<div class="modal-content">
											<div class="modal-header">
												<button type="button" class="close" data-dismiss="modal">&times;</button>
												<h4 class="modal-title">${i.urun.urun_adi}</h4>
											</div>
											<div class="modal-body">
												<p>Durum : ${status[i.is_statu]}</p>
												<p>Kayıt Tarihi : ${i.kayit_tarihi}</p>
												<p>
													Yapılan İşlemler :
													<c:forEach items="${i.islem}" var="isl">
												-${isl.islem_adi}  
												</c:forEach>
												</p>
												<p>İşlem Detay : : ${i.is_detay}</p>
												<hr>
												<p>Ürün Detay : ${i.urun.urun_detay}</p>
												<p>Müşteri Adı : ${i.urun.musteri.musteri_adi}</p>
												<p>Müşteri Soyadı : ${i.urun.musteri.musteri_soyadi}</p>
												<p>Telefon : ${i.urun.musteri.musteri_telefon}</p>
												<p>Adres : ${i.urun.musteri.musteri_adres}</p>





											</div>
											<div class="modal-footer">
												<button type="button" class="btn btn-default"
													data-dismiss="modal">Kapat</button>
												
											</div>
										</div>

									</div>
								</div>

							</c:forEach>
						</tbody>
					</table>



				</c:if>




			</div>
		</div>
	</div>


</body>
</html>
