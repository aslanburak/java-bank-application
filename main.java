//Burak Aslan 203608590
package banka;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;
import java.util.Random;
public class Banka {

	public static void main(String[] args) {
		
	System.out.println("***** MERHABA BANKAMIZA HOS GELDINIZ *****\n ");
	System.out.println("Müsteri Numarasi ile  giris yapmak için-> 1\nYeni bir müsteri eklemek icin-> 2  ");
	BankaPersonel b1 = new BankaPersonel(260782788, "Ahmet","Aslan","ahmetaslan@gmail.com", 53034544);//Banka personelini olusturduk
	Scanner veriAl=new Scanner(System.in);
	int giris=veriAl.nextInt();
	
	 switch(giris) {
	 case 1: //bankaya kayıtlı müşteri  kalvyeden 2 girersek müşterinin tüm bilgilerini klavyeden girmiş olmaliyiz
		 System.out.println("Müşteri Numaranızı giriniz: ");
		 int musNo=veriAl.nextInt();
		 if(musNo==203608590) {//1. müşteri numarasi--- KAYITLI MUSTERİ---
			
		 Musteri musteri1=new Musteri(123456789, 203608590, "Burak", "Aslan", "burakaslan@gmail.com", 530448745);// Müşteri eklendi
		 System.out.println(musteri1.toString()); //musterinin bilgilerini bastirdi
		 System.out.println("Hesabına Ne kadar para ile açmak istersin\n(int turunde gir) ?");
	     double bakiye=veriAl.nextDouble();//Açılış ücretini klavyeden girdik
	     VadesizHesap vadesiz=new VadesizHesap("vadesiz",bakiye); // Hesap açılınca otomatikmen vadesiz hesap oluşturulur
		 System.out.println("Maas hesabı->1   Normal hesap-->2 ");
		 int hesapBilgisi=veriAl.nextInt();
		 BankaHesap kayitlihesap=new BankaHesap(10121212,bakiye,hesapBilgisi);//ekli hesap
	     musteri1.hesapEkle(123456789, 203608590, "Burak", "Aslan",kayitlihesap);
	     KrediKarti kredikarti=new KrediKarti(1221211,1000,100,1000);//güncel borç 100 tl
	     
	      kredikarti.krediKartiEkle(202303404,(Math.random())*6000 );//Kart Limiti Random girdik
	      kredikarti.krediKartiEkle(202303405, (Math.random())*6000 );
	      kredikarti.krediKartiEkle(202305505, (Math.random())*6000 );
	      kredikarti.krediKartiEkle(202305506, (Math.random())*6000 );
	      
		 
		 System.out.println("---------------MENU------ ****Bir Secim Yap****");
		 System.out.println("Hesap Eklemek için --- 1");
         System.out.println("Hesap Silmek için --- 2");
         System.out.println("Kredi Karti Eklemek için --- 3");
         System.out.println("Kayitli Kredi Kartini Silmek için --- 4");
         System.out.println("Kredi Karti Limiti 5000 TL altinda olanlarin guncel borcbilgisini goruntulemek icin --- 5");
         System.out.println("Kredi Karti Borcu Odemek için --- 6");
         System.out.println("Para transferi yapmak için --- 7");
         int sayi=veriAl.nextInt();
             switch(sayi) {
             case 1:
            	  BankaHesap hesap2=new BankaHesap(101342423,bakiye,1);//normal hesap açtık
     		      musteri1.hesapEkle(123456789, 203608590, "Burak", "Aslan",hesap2);
     		      break;
             case 2:	 
            	 musteri1.hesapSil(123456789, 203608590, "Burak", "Aslan");
            	 break;
             case 3:
            	 System.out.println("Talep edilen kredi karti limiti gir");
            	 int limit=veriAl.nextInt();
            	 kredikarti.krediKartiEkle(1221211, limit);//1000 tl limit verdik
            	 System.out.println(kredikarti.toString());   
            	 System.out.println("Karti silmek ister misin? 1 Evet 2 Hayir");
            	 int sayi2=veriAl.nextInt();
            	 if(sayi2==1)
            		 kredikarti.krediKartiSil(1221211, 203608590, 100);
            	 if(sayi2==2)
            		 System.out.println("Tamam karti silmedik");
            	 break;
             case 4: 
            	 System.out.println("Kartı silmek için: kart numaranı, müşteri numaranı ve borç bilgini sırayla gir");
            	 kredikarti.krediKartiSil(veriAl.nextInt(), veriAl.nextInt(), veriAl.nextInt());
            	 break;
             case 5:
            	 kredikarti.kartborcu();
                break;
             case 6:
            	System.out.println("Guncel borcunu klavyeden yaz ?");
            	System.out.println("kalan bakiye: "+ vadesiz.krediKartiBorcOdeme(vadesiz.vadesizBakiye, veriAl.nextInt() ))   ; //kalan bakiyeyi yazdirdik
            	break;
             case 7:
            	System.out.println("Para transferi yapacağınız kişinin **IBAN** numarasını yaziniz");
            	long iban=veriAl.nextLong();
            	System.out.println("Transfer edeceginiz **Miktari** giriniz");
            	double trasferucreti=veriAl.nextDouble();
            	System.out.println("Kalan ucret: "+vadesiz.paraTransfer(hesapBilgisi, iban, bakiye, trasferucreti)) ;
            }
             break;
		 }
		 
		 else {
        	 System.out.println("!!!!!!!!!!Musteri bulunamadi lütfen dogru musteri numarasi gir");
        	 break;
         }
	 case 2:
		 System.out.println("*******Musteri tckimlik,  Ad, Soyad,Email,TelNo --Her girilen degerden sonra enter'a basalim--******");
		 Random r2 =new Random();
		 Musteri musteri2= new Musteri(veriAl.nextInt(), (int)((Math.random())*100000), veriAl.next(), veriAl.next(), veriAl.next(), veriAl.nextInt());
		 System.out.println("Hesabına Ne kadar para ile açmak istersin ?");
		 double para=veriAl.nextDouble();
		 VadesizHesap vadesiz=new VadesizHesap("vadesiz", para);
		 System.out.println("Maas hesabı->1   Normal hesap-->2 ");
		 int hesapBilgisi=veriAl.nextInt();
		 BankaHesap kayitlihesap2=new BankaHesap(10121212,para,hesapBilgisi);
		 musteri2.hesapEkle(musteri2.getTcKimlikNo(), musteri2.getMusteriNumarasi(), musteri2.getAd(), musteri2.getSoyad(),kayitlihesap2);
	     KrediKarti kredikarti=new KrediKarti();
	     System.out.println(musteri2.toString());
	     System.out.println("---------------------SECIM YAP---------------------");
	     System.out.println("Hesap Silmek için  1");
         System.out.println("Kredi Karti Eklemek için  2");
         System.out.println("Kayitli Kredi Kartini Silmek için  3");
         System.out.println("Kredi Karti Borcu Odemek için --> 4");
         System.out.println("Para transferi yapmak için --- 5");
         int sayi=veriAl.nextInt();
         switch(sayi) {
         case 1:
         musteri2.hesapSil(musteri2.getTcKimlikNo(), musteri2.getMusteriNumarasi(), musteri2.getAd(), musteri2.getSoyad());
         break;
         case 2:
        	 System.out.println("Talep edilen kredi karti limiti gir");
        	 kredikarti.krediKartiEkle((int)((Math.random())*1000000), veriAl.nextInt());//kredi karti numarasi random girildi, talep edilen kredi karti limiti klavyeden girdik
        	 System.out.println(kredikarti.krediKartlari); //kredi karti bilgilerini bastirdik
        	 System.out.println("Karti silmek ister misin? 1 Evet 2 Hayir");
        	 int sayi2=veriAl.nextInt();
        	 if(sayi2==1)
        		 System.out.println("Kartı silmek için: kart numaranı, müşteri numaranı ve borç bilgini sırayla gir");
        	 kredikarti.krediKartiSil(veriAl.nextInt(), veriAl.nextInt(), veriAl.nextInt());
        	 if(sayi2==2)
        		 System.out.println("Tamam karti silmedik");   	 
    	 break;
         case 3:
        	 System.out.println("Kartı silmek için: kart numaranı, müşteri numaranı ve borç bilgini sırayla gir");
        	 kredikarti.krediKartiSil(veriAl.nextInt(), veriAl.nextInt(), veriAl.nextInt());
        	 break;
         case 4:
        	 System.out.println("Guncel borcunu klavyeden yaz ?");
         	System.out.println("kalan bakiye: "+ vadesiz.krediKartiBorcOdeme(vadesiz.vadesizBakiye, veriAl.nextInt() ))   ; //kalan bakiyeyi yazdirdik
         	break;
         case 5:
        	 System.out.println("Para transferi yapacağınız kişinin **IBAN** numarasını yaziniz");
         	long iban=veriAl.nextLong();
         	System.out.println("Transfer edeceginiz **Miktari** giriniz");
         	 double trasferucreti=veriAl.nextDouble();
         	 System.out.println("Kalan ucret: "+vadesiz.paraTransfer(hesapBilgisi, iban, para, trasferucreti)) ;
          
         }
	 }
	 
	     
	}

}

class Kisi {
	  private int tcKimlikNo;
	  private String ad;
	  private String soyad;
	  private String email;
	  private int telefonNumarasi;
	  
	  public Kisi(String ad, String soyad, String email, int telefonNumarasi) {
	    this.ad = ad;
	    this.soyad = soyad;
	    this.email = email;
	    this.telefonNumarasi = telefonNumarasi;
	  }
	  
	// get ve set metodları
	  public String getAd() {
	    return ad;
	  }
	  
	  public void setAd(String ad) {
	    this.ad = ad;
	  }
	  
	  public String getSoyad() {
	    return soyad;
	  }
	  
	  public void setSoyad(String soyad) {
	    this.soyad = soyad;
	  }
	  
	  public String getEmail() {
	    return email;
	  }
	  
	  public void setEmail(String email) {
	    this.email = email;
	  }
	  
	  public int getTelefonNumarasi() {
	    return telefonNumarasi;
	  }
	  
	  public void setTelefonNumarasi(int telefonNumarasi) {
	    this.telefonNumarasi = telefonNumarasi;
	  }
	  public int getTcKimlikNo() {
		  return tcKimlikNo;
	  }
	  
	  @Override
	  public String toString() { // toString ile müşteri kişisel bilgileri görüntülenebilecek
		    return "\nKişisel Bilgiler: " +
		           "\n Adı Soyadı: " + ad + " " + soyad +
		           "\n Email: " + email +
		           "\n Telefon Numarasi: " + telefonNumarasi +"\n";
		}
	}

class BankaPersonel extends Kisi {
    private int personelID;
    ArrayList<Musteri> musteriler = new ArrayList<Musteri>(); 
    
    
    //porsonelID için get set metodları kullanildi
    public int getPersonelID() {
        return personelID;
    }

    public void setPersonelID(int personelID) {
        this.personelID = personelID;
    }
    public ArrayList<Musteri> getMusteriler(){
        for(Musteri musteri : musteriler){
            System.out.println("Ad: "+musteri.getAd() +" Soyad: "+ musteri.getSoyad() +" E-mail: "+ musteri.getEmail()+ " Tel No: "+ musteri.getTelefonNumarasi()+ " Musteri No: "+ musteri.getMusteriNumarasi()+ " Hesaplar: "+ musteri.getHesaplar());
        }
        return musteriler;
    }
    public BankaPersonel(int tcKimlikNo, String ad, String soyad, String email, int telefonNumarasi) {
        super(ad, soyad, email, telefonNumarasi);  //super() metodu ile personel bilgilerini ata sınıfa yolladık**
        
    }


    public String toString() {
        return "\nBanka Personeli: " + "\n ID: " + personelID + "\n Ad: " + getAd() + "\n Soyad: " + getSoyad();
    }
}

class Musteri extends Kisi {
    private int musteriNumarasi;
     ArrayList<BankaHesap> hesaplar;
     ArrayList<KrediKarti> krediKartlari;
     
     
     // musteri numarası için get set metodu 
     
     public int getMusteriNumarasi() {
         return musteriNumarasi;
     }
     
     public void setMusteriNumarasi(int musteriNumarasi) {
         this.musteriNumarasi = musteriNumarasi;
     }
     public ArrayList<BankaHesap> getHesaplar(){
         return hesaplar;
     }

    public Musteri(int tcKimlikNo, int musteriNumarasi, String ad, String soyad, String email, int telefonNumarasi) {
        super(ad, soyad, email, telefonNumarasi); //Super metodu ile üst sınıfın constructırına bu değerleri yollar
        this.musteriNumarasi = musteriNumarasi;
        hesaplar = new ArrayList<>(); 
        krediKartlari = new ArrayList<>();
    }

    public void hesapEkle(int tcKimlikNo, int musteriNumarasi, String ad, String soyad,BankaHesap hesap) { //hesapTuru ekledim
       
    	Scanner veriAl=new Scanner(System.in);
        switch(hesap.hesapTuru) {
            case "vadeli":
            	if(hesap.hesapBilgisi==1) { 
                hesap = new VadeliHesap(hesap.hesapTuru, hesap.toplamBakiye, 0.2f);//maaş hesabı seçilirse faiz oranı %20 işletilecek
                System.out.println(hesap.hesapTuru +" Hesap olusturuldu.\n");
                System.out.println("Faiz orani %20 belirlendi");
                System.out.println(hesap.toString());
                
            	}
            	else if (hesap.hesapBilgisi==2) {//Normal hesap seçilirse faiz oranı %10 işletilecek
            		hesap = new VadeliHesap(hesap.hesapTuru, hesap.toplamBakiye, 0.1f);
            		System.out.println("Faiz orani %10 belirlendi");
                    System.out.println(hesap.toString());
                    
            	}
            	else {
            		System.out.println("Hesap bilgini yanlis girdiniz tekrar girirniz");
            	}
                
                break;
            case "vadesiz":
                hesap = new VadesizHesap(hesap.hesapTuru, hesap.toplamBakiye);
                System.out.println(hesap.hesapTuru +" Hesap olusturuldu.\n");
                System.out.println(hesap.toString());
;                
                break;
            case "yatirim":
                YatirimHesap hesap1 = new YatirimHesap(hesap.hesapTuru, hesap.toplamBakiye,"nakit", 18);
                System.out.println(hesap.hesapTuru +" Hesap olusturuldu.\n");
                System.out.println(hesap1.toString());
                System.out.println("\n\n******Para eklemek için 1\n******Para bozmak için 2\n");
                
                int giris=veriAl.nextInt();
                if(giris==1) {
                System.out.println("Yatirilacak dolar miktarini giriniz(int turunde)");
                System.out.println("Para yatirildi\n Hesapta suan "+ hesap1.paraEkle(veriAl.nextInt(), "$", 18.0f)+" TL para var\n\n");//YatirimHesap sınıfındaki paraEkle metodu çağırıldı.
                }
                else if  (giris==2) {
                	System.out.println("Bozdurulacak dolar miktarini giriniz");
                	System.out.println("Para pozduruldu\n Hesapta suan hesapta dolar bazında  "+ hesap1.paraBoz(veriAl.nextInt(), "$", 18.0f)+" TL para var\n\n"); //YatirimHesap sınıfındaki paraBoz metodu çağırıldı
                }
              
                break;
            default:
                System.out.println("Geçersiz hesap türü");
        }
        if(hesap != null) {
            hesaplar.add(hesap);
            
        }
    }

    public void hesapSil(int tcKimlikNo, int musteriNumarasi, String ad, String soyad) {
    	for (int i = 0; i < hesaplar.size(); i++) {
    	    BankaHesap hesap = hesaplar.get(i);
    	     
    	        if (hesap.toplamBakiye > 0) { //toplam bakiye sorgusu yapıldı
    	            System.out.println("Lütfen öncelikle hesap bakiyenizi başka bir hesaba aktarınız.");
    	            return;
    	        } else {
    	            hesaplar.remove(i);
    	            System.out.println("Hesap silindi.");
    	            return;
    	        }
    	    
    	}
    	System.out.println("Hesap bulunamadı.");
    }

    @Override
    public String toString() {
        return "{musteriNumarasi=" + musteriNumarasi +
                ", krediKartlari=" + krediKartlari +
                "}\n " + super.toString(); //müşterinin kişisel bilgilerini de bastı
    }
}


class Krediler {
    private int krediID;
    double krediMiktari;
    double taksitMiktar;

    public Krediler(int krediID, int musteriNumarasi, double krediMiktari) {
    	this.krediID = krediID;
        // burada müşteri numarası ve bakiye bilgilerini kullanarak yıllık kazancı hesaplayabilirsiniz
        double yillikKazanc = hesaplaYillikKazanc(musteriNumarasi);
        // yıllık kazancın %50'si kadar kredi miktarı hesaplanır
        this.krediMiktari = Math.min(yillikKazanc * 0.5, krediMiktari);
        this.taksitMiktar = this.krediMiktari / 12.0; // kredinin aylık taksit miktarı hesaplanır
           
    }
    
    private double hesaplaYillikKazanc(int musteriNumarasi) {
		// TODO Auto-generated method stub
		return 0;
	}

	//krediID set ve get metodları
    public void setKrediID(int krediID) {
        this.krediID = krediID;
    }
    
    public int getKrediID() {
        return this.krediID;
    }
    
   

    public void kampanya(KrediKarti limit) {
        
    }
    
    @Override
    public String toString() {
        return "Kredi bilgileri: " +
                "\n kredilD: " + krediID +
                "\n krediMiktari: " + krediMiktari +
                "\n taksitMiktar: " + taksitMiktar;
    }
}

class KrediKarti {  //KREDİ KARTI
    private int kartNumarasi;
    double limit;
    double guncelBorc;
    double kullanilabilirLimit; //Bunu kendim ekledim çünkü KrediKartı constructorı kullanılabilirLimit parametresini alıyor
    ArrayList<KrediKarti> krediKartlari = new ArrayList<>(); //Biz ekledik, kredi karti nesnelerini tutuyor
    
    public void kartborcu() {//kendimiz bu metodu ekledik, kredi kartı limiti 5000 tl altı olan kartların güncel borç bilgisini döndürüyor.
    	
   	 for (KrediKarti kart : krediKartlari) {
            if (kart.limit < 5000) {
                System.out.println("Kart " + kart.getKartNumarasi() + " güncel borcu: " + kart.guncelBorc+" TL");
            }
   	 }
   	 }
    public ArrayList<KrediKarti> getKrediKartlari(){
    	
    	return krediKartlari;
    }
    public KrediKarti() {
    	
    }
    public KrediKarti(int kartNumarasi, double limit, double guncelBorc, double kullanilabilirLimit) {
        this.kartNumarasi = kartNumarasi;
        this.limit = limit;
        this.guncelBorc = guncelBorc;
        this.kullanilabilirLimit = kullanilabilirLimit;
    }
    public ArrayList<KrediKarti> getKredikartlari(){
    	return krediKartlari;
    }
    //kartNumarasi set get metodları
    public int getKartNumarasi() {
        return kartNumarasi;
    }

    public void setKartNumarasi(int kartNumarasi) {
        this.kartNumarasi = kartNumarasi;
    }

    
    public void krediKartiEkle(int kartNumarasi, double limit) {
    	Random a=new Random();
        KrediKarti yeniKart = new KrediKarti(kartNumarasi, limit, (Math.random())*1000,limit);
		krediKartlari.add(yeniKart);
        
    }
    
    public void krediKartiSil(int kartNumarasi, double limit, double guncelBorc) {
        for (int i = 0; i < krediKartlari.size(); i++) {
            KrediKarti krediKarti = krediKartlari.get(i);
            if (krediKarti.kartNumarasi == kartNumarasi) {//kart numarası uyuşup uyuşmadığı test ediliyor
                if (krediKarti.guncelBorc == 0.0) {// güncel borç 0 ise kart silinir
                    krediKartlari.remove(i);
                    System.out.println("Kredi kartı başarıyla silindi.");
                } else {
                    System.out.println("Lütfen öncelikle borç ödemesi yapınız."); //Kart borcu varda önce kart borcunu öde uyarısı verilir
                }
                break;
            }
        }
    }
    
    
    public double kullanilabilirLimit(int kartNumarasi, double guncelBorc) {
    	kullanilabilirLimit = limit - guncelBorc;
        return kullanilabilirLimit;
    }
    
    public String toString() {
        return "kartNumarasi: " + kartNumarasi +
        		"\n limit: " + limit +
        		"\n guncelBorc: " + guncelBorc +
        		"\n kullanilabilirLimit: " + kullanilabilirLimit + "\n";
    }
}

 class BankaHesap {
    long iban;
    Date hesapAcilisTarih;
    double toplamBakiye;
    int hesapBilgisi; // 1: maaş hesabı, 2: normal hesap
    double islemMiktar;
    static String hesapTuru;
    
    BankaHesap(){
    
    }
    
    public BankaHesap(long iban, double toplamBakiye, int hesapBilgisi) {
        this.iban = iban;
        this.toplamBakiye = toplamBakiye;
        this.hesapBilgisi = hesapBilgisi;
        
       System.out.println("Hesap Turunu giriniz.\nkucuk harflerle"); //banka hesabı açılışında hesap türü istenilmekte
        Scanner a= new Scanner(System.in);
        this.hesapTuru=a.next();
        
    }
    
    
    
    public void hesapGoruntuleme(int musteriNumarasi, String ad, String soyad, long iban, double toplamBakiye, String hesapBilgisi) {
        System.out.println("Müşteri Numarasi: " + musteriNumarasi);
        System.out.println("Ad: " + ad);
        System.out.println("Soyad: " + soyad);
        System.out.println("Iban: " + iban);
        System.out.println("Toplam Bakiye: " + toplamBakiye);
        System.out.println("Hesap Bilgisi: " + hesapBilgisi);
    }
    
    
    @Override
    public String toString() {
        return "Banka Hesap Bilgileri: " +
                "Hesap Acilis Tarihi: " + hesapAcilisTarih+
                "\niban: " + iban +
                "\ntoplamBakiye: " + toplamBakiye +
                "\n hesapBilgisi: " + hesapBilgisi +
                "\n islemMiktar: " + islemMiktar +
                "\n hesapTuru: " + hesapTuru ;
    }
}


class VadeliHesap extends BankaHesap { //VADELİ HESAP
    String hesapTuru;
    double vadeliBakiye;
    float faizOrani;

    public VadeliHesap(String hesapTuru, double vadeliBakiye, float faizOrani) {
    	
        this.hesapTuru = hesapTuru;
        this.vadeliBakiye = vadeliBakiye;
        this.faizOrani = faizOrani;
        
    }

    @Override
    public String toString() {
        return "VadeliHesap: " +
                "\n hesapTuru: " + hesapTuru +
                "\n vadeliBakiye: " + vadeliBakiye +
                "\n faizOrani: " + faizOrani;
    }
}


class VadesizHesap extends BankaHesap { //VADESİZ HESAP
    String hesapTuru;
    double vadesizBakiye;

    public VadesizHesap(String hesapTuru, double vadesizBakiye) {
        
        this.hesapTuru = hesapTuru;
        this.vadesizBakiye = vadesizBakiye;
    }

    public double paraTransfer(int hesapBilgisi, long iban, double vadesizBakiye, double trasferucreti) {//hesapBilgisi parametresi ekledik
        if (hesapBilgisi==1) {//maaş hesabı seçilirse işlem ücreti yok
        	System.out.println("Transfer islemi gerceklestirildi...");
            return vadesizBakiye - trasferucreti;
        } else if (hesapBilgisi==2) {// normal hesap seçilirse 8 TL işlem ücreti alınacak
            double kesinti = 8.0;
            double yeniBakiye = vadesizBakiye - trasferucreti - kesinti;
            System.out.println("Transfer islemi gerceklestirildi...");
            System.out.println("Normal hesaptan dolayı 8 TL islem ucreti alinmistir");
            return yeniBakiye;
        } else {
            System.out.println("Geçersiz hesap bilgisi!");
            return vadesizBakiye;
        }
    }

    public double krediKartiBorcOdeme(double vadesizBakiye, double guncelBorc) {
    	double odemeMiktari = Math.min(vadesizBakiye, guncelBorc); // bankadan bulunan para borçtan düşük olup olmadığını kontrol ettik
        vadesizBakiye -= odemeMiktari; //ödenecek miktarı vadesiz bakiyeden çıkardık
        if(vadesizBakiye==0)
        System.out.println("Yetersiz Bakiye");
        
     
        return vadesizBakiye; //kalan borcu gönderdik
    }

    public double krediOdeme(int krediID, Krediler krediMiktari, Krediler taksitMiktari) {
        double odemeMiktari = taksitMiktari.taksitMiktar; // ödeme miktarı, taksitMiktari nesnesinden alınır
        double kalanMiktar = krediMiktari.krediMiktari - odemeMiktari; // kredinin kalan miktarı hesaplanır
        vadesizBakiye -= odemeMiktari; // ödeme miktarı vadesiz hesaptan düşülür
       
		krediMiktari.krediMiktari=kalanMiktar; // kredi miktarı güncellenir
        return kalanMiktar; // kalan kredi miktarı döndürülür
    }

    @Override
    public String toString() {
        return "Hesap Türü: " + hesapTuru + ", Vadesiz Bakiye: " + vadesizBakiye;
    }
}

class YatirimHesap extends BankaHesap {  //YATIRIM HESABI
     String hesapTuru;
    int yatirimBakiye;
    String yatirimTuru;
    float kur;
    
    public YatirimHesap(String hesapTuru, double yatirimBakiye, String yatirimTuru, float kur) {
        this.hesapTuru = hesapTuru;
        this.yatirimBakiye = (int)yatirimBakiye; //double olarak aldık int türüne cast ettik
        this.yatirimTuru = yatirimTuru;
        this.kur = kur;
    }
    
    public double paraEkle(int miktar, String yatirimTuru, float kur) {
        double eklenecekMiktar = miktar * kur; // miktarı kur ile çarptık
        this.yatirimBakiye += eklenecekMiktar;
        return this.yatirimBakiye;
    }
    
    public double paraBoz(int miktar, String yatirimTuru, float kur) {
        double bozulacakMiktar = miktar * kur;
        if (this.yatirimBakiye < bozulacakMiktar) { // bozdurulacak para güncel bakiyeden düşük olabilir
            System.out.println("Yeterli bakiye yok!");
            return 0;
        } else {
            this.yatirimBakiye -= bozulacakMiktar;
            return this.yatirimBakiye;
        }
    }
    
    @Override
    public String toString() {
        return "\nYatirimHesap: " +
                "\n hesapTuru: " + hesapTuru +
                "\n yatirimBakiye: " + yatirimBakiye +
                "\n yatirimTuru: " + yatirimTuru +
                "\n kur: " + kur;
    }
}