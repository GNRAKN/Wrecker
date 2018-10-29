<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<html>
<head>
<title>Ürün Ekle</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="resources/css/bootstrap.min.css">
<!-- <script src="resources/js/bootstrap.min.js"></script> -->
<script src="resources/js/status.js"></script>



</head>
<body onload="showMe();">

	<div class="container">
		<h2>Wrecker</h2>
		<p>İş kayıt formu</p>



		<form:form id="IsKayitFormu" action="/kaydetIs" method="post"
			modelAttribute="is">


			<form:hidden path="is_id" value="${is.is_id}" />
			<form:hidden path="urun.urun_id" value="${is.urun.urun_id}" />

			<div class="form-group">
				<form:label for="urun_adi" path="urun.urun_adi">Ürün Adı:</form:label>
				<form:input type="text" class="form-control" id="urun_adi"
					path="urun.urun_adi" />
			</div>

			<div class="form-group">

				<form:label for="kategori" path="urun.kategori.kategori_id">Kategori:</form:label>

				<form:select path="urun.kategori.kategori_id" id="kategori_id"
					name="kategori_id">
					<option selected value="0">-- kategori seçiniz --</option>

					<c:if test="${is.urun.kategori.kategori_id!=0}">
						<option selected value="${is.urun.kategori.kategori_id}">${is.urun.kategori.kategori_adi}</option>
					</c:if>
					<c:forEach items="${kategoriler}" var="kategori">
						<option value="${kategori.kategori_id}">${kategori.kategori_adi}</option>
					</c:forEach>
				</form:select>
			</div>


			<div class="form-group">
				<form:label for="urunDetay" path="urun.urun_detay">Ürün Detay:</form:label>
				<form:input type="text" class="form-control" id="urunDetay"
					path="urun.urun_detay" />
			</div>




			<div class="form-group">
				<form:label for="musteri_adi" path="urun.musteri.musteri_adi">Müşteri Adı:</form:label>
				<form:input type="text" class="form-control" id="musteri_adi"
					path="urun.musteri.musteri_adi" />
			</div>

			<div class="form-group">
				<form:label for="musteri_soyadi" path="urun.musteri.musteri_soyadi">Müşteri Soyadı:</form:label>
				<form:input type="text" class="form-control" id="musteri_soyadi"
					path="urun.musteri.musteri_soyadi" />
			</div>


			<div class="form-group">
				<form:label for="musteri_telefon"
					path="urun.musteri.musteri_telefon">Müşteri Telefon:</form:label>
				<form:input type="text" class="form-control" id="musteri_telefon"
					path="urun.musteri.musteri_telefon" />
			</div>

			<div class="form-group">
				<form:label for="musteri_adres" path="urun.musteri.musteri_adres">Müşteri Adres:</form:label>
				<form:textarea rows="3" type="text" class="form-control"
					id="musteri_adres" path="urun.musteri.musteri_adres" />
			</div>


			<div class="form-group">
				<form:label for="isStatu" path="is_statu">İş Statüsü:</form:label>
				<form:select path="is_statu" id="statusKey" onchange="showMe();"
					class="form-group">

					 <c:forEach items="${status}" var="s" varStatus="status2">
					
						<c:choose>
						<c:when test="${status2.index==0}"> 
							<form:option selected="true" value="${s.key}">${s.value}</form:option>
							
						</c:when>
						<c:otherwise>
							<form:option selected="false" value="${s.key}">${s.value}</form:option>
						</c:otherwise>
						</c:choose>
					
					</c:forEach> 

				
				</form:select>
			</div>



			<div class="form-group" id="islemDiv">


				
				<c:if test='${not empty islemler}'>
					<c:forEach items="${islemler}" var="map">
						<c:set var="keyString" value="${map.key}"></c:set>
						<c:set var="status" value="false"></c:set>
						<c:forEach items="${is.islem}" var="yapilanIslem">
							<c:choose>
								<c:when test='${yapilanIslem.islem_id==keyString}'>
									<c:set var="status" value="true"></c:set>
								</c:when>
								<c:otherwise>
									<c:set var="status" value="false"></c:set>
								</c:otherwise>
							</c:choose>
						</c:forEach>
						<c:choose>
						
							<c:when test="${status == 'true'}">
								<label>${map.value}</label>
								<input checked type="checkbox" value="${keyString}" id="islm_id"
									name="islm_id" />
							</c:when>
							<c:otherwise>
								<label>${map.value}</label>
								<input type="checkbox" value="${keyString}" id="islm_id"
									name="islm_id" />
							</c:otherwise>

						</c:choose>


					</c:forEach>

				</c:if>
				

				<div class="form-group">
					<form:label for="isDetay" path="is_detay">Servis Detay:</form:label>
					<form:input type="text" class="form-control" id="isDetay"
						path="is_detay" />
				</div>
			</div>

			<button type="submit" class="btn btn-primary btn-block">Kaydet</button>
			<a href="/" class="btn btn-warning btn-block" role="button">İptal</a>
		</form:form>




	</div>


</body>




</html>
