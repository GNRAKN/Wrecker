package com.gunerakin.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import javax.inject.Inject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.gunerakin.model.Is;
import com.gunerakin.model.Islem;
import com.gunerakin.model.Kategori;
import com.gunerakin.repository.service.IsService;
import com.gunerakin.repository.service.IslemService;
import com.gunerakin.repository.service.KategoriService;


/**
 * @author gunerakin
 * @since  24/10/2018
 */


@Controller
public class MainController {

	@Inject
	IslemService islemService;

	@Inject
	KategoriService kategoriService;

	@Inject
	IsService isService;

	List<Is> isList = null;
	
	
	/**
    * createStatus : Birden fazla yerde aynı iş yapılacağından kod tekrarı olmasın diye metot olarak yazıldı.
    * @return status Hashmap yapısında veri döndürür. 
    */

	public HashMap<String, String> createStatus() {

		HashMap<String, String> status = new HashMap<String, String>();
		status.put("1", "Beklemede");
		status.put("2", "İşlem Yapıldı");
		return status;

	}

	
	/**
	    * IslemlistToHashMap : Birden fazla yerde aynı iş yapılacağından kod tekrarı olmasın diye metot olarak yazıldı.
	    * @return islemler Hashmap yapısında veri döndürür. 
	    */
	public HashMap<Integer, String> IslemlistToHashMap() {
		HashMap<Integer, String> islemler = new HashMap<Integer, String>();
		for (Islem islem : islemService.readAllIslem()) {
			islemler.put(islem.getIslem_id(), islem.getIslem_adi());
		}
		return islemler;
	}

	
	/**
	    * yeniIs : /kaydetIs tıklandıgında ekrana gelecekleri burada model nesnesini kullanarak ön yüze gönderiyoruz.
	    * @return ModelAndView
	    */
	@RequestMapping(value = "/kaydetIs", method = RequestMethod.GET)
	public ModelAndView yeniIs(@ModelAttribute Is is) {

		return new ModelAndView("isForm", "islemler", IslemlistToHashMap())
				.addObject("kategoriler", kategoriService.readAllKategori()).addObject("status", createStatus());

	}

	
	/**
	    * kaydetIs : /kaydetIs ön yüzde post metodu calistirildiginda bu metot calisir.Verileri alır ve isler.
	    * @return String ile listeleme sayfasina yönlendirme yapiliyor.
	    */
	@RequestMapping(value = "/kaydetIs", method = RequestMethod.POST)
	public String kaydetIs(@ModelAttribute Is is, @RequestParam(value = "urun.kategori.kategori_id") int kategori_id,
			@RequestParam("islm_id") List<Integer> islm_id) {

			is.getUrun().getKategori().setKategori_id(kategori_id);
		

		
		is.setKayit_tarihi(new Date());

		// Verileri sabit tablolarla n-n ilişki olan senaryolarda , sabit tablolar ön
		// yüzden path ile alınmaz. Parametre ile id alınır. Controllerda set edilir. Bu
		// sekilde yapılmazsa veritabanında bu tabloya fazladan veri eklenir.

		List<Islem> islemList = new ArrayList<Islem>(); // Cascade olmadığı zaman islemi önce flush etmemizi isteyecek.
														// Bu nedenle İs sınıfında islem List tipinde oldugu için önce
														// List<Islem> olusturp dolduruyoruz. Daha sonra bu listeyi Is
														// içerisine set ediyoruz.// new islemini iceride yapmamız
														// lazım.Cunku her defasında farklı referans
		// olusturup oyle kaydetmesi lazim listeye ki veritabanına da o sayıda islem
		// eklesin.

		Optional<List<Integer>> kriterOpt = Optional.ofNullable(islm_id);

		kriterOpt.ifPresent(opt -> {
			Islem islem;
			for (int islem2 : islm_id) {
				islem = new Islem();
				islem.setIslem_id(islem2);
				islemList.add(islem);
			}
			is.setIslem(islemList);
		});

		if (is.getIs_id() != 0) {

			isService.updateIs(is);
		} else {

			isService.createIs(is);
		}

		return "redirect:listeleIs";
	}

	@RequestMapping(value = "/listeleIs", method = RequestMethod.GET)
	public ModelAndView listeleIs() {

		return new ModelAndView("isListe", "isler", isService.readAllIs()).addObject("status", createStatus());
	}

	@RequestMapping(value = "/listeleIs", method = RequestMethod.POST)
	public ModelAndView listeleIs(@RequestParam String statu) {

		Optional<String> kriterOpt = Optional.ofNullable(statu);

		kriterOpt.ifPresent(opt -> {

			isList = isService.readIsByStatu(opt);

		});

		return new ModelAndView("isListe", "isler", isList).addObject("status", createStatus());
	}

	@RequestMapping(value = "/guncelleIs", method = RequestMethod.GET)
	public ModelAndView guncelleIs(@ModelAttribute Is is, @RequestParam int is_id) {
		List<Kategori> kategoriler = kategoriService.readAllKategori();
		is = isService.readIsById(is_id);
		
		kategoriler.remove(is.getUrun().getKategori().getKategori_id()-1); // Kategoriler id degerlerine gore sirali
																			// olarak tutulduklarından List
		// içerisine de sıralı gelirler.Bu
		// nedenle List içerisindeki indisi id

		return new ModelAndView("isForm", "kategoriler", kategoriler).addObject("is", is)
				.addObject("status", createStatus()).addObject("islemler", IslemlistToHashMap());

	}

	@RequestMapping(value = "/silIs", method = RequestMethod.GET)
	public String silIs(@RequestParam int is_id) {
		Is is = new Is();
		is.setIs_id(is_id);

		isService.deleteIs(is);

		return "redirect:listeleIs";

	}
}
