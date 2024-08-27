package Modeller.Calisanlar;

import Modeller.Departmanlar.BilisimTeklonojileriDepartmani;
import Modeller.Departmanlar.Departman;
import Modeller.Departmanlar.InsanKaynaklariDepartmani;
import Modeller.Departmanlar.YonetimDepartmani;
import Veritabani.Calisanlar;
import Veritabani.Departmanlar;

import java.util.Scanner;

public class Calisan {

    private String calisanId;
    private String adSoyad;
    private double maas;
    private Departman Departman;
    private String isimKodu = "";

    private static int sayac=257;

    public Calisan(String adSoyad, int maas, String departmanKodu) {
        this.adSoyad = adSoyad;
        this.maas = maas;
        setDepartman(departmanKodu);
        this.setCalisanId();    // constructor çalıştığında, aşağıda tanımlayacağınız bu metod vasıtasıyla tekil bi ID alacak...
                                // Örn: Şirkette 257 calisan var, Bilişim teklonojileri departmaninda Mehmet Ali Bulut kaydedilecek olsun,
                                // Mehmet Ali icin ID 'BTD258MAB' olmalıdır.
        Calisanlar.addACalisan(this);

    }

    // Terminalden girilen calisanin departman koduna göre, gerekli departman set edilmelidir.
    // Çalışan sınıfının Constructor 'ı main'de tanımlı. Program çalıştığında, terminalden gireceğimiz
    // departman kodu, buradaki metod (setDepartman) vasıtasıyla departman listesinin tümünü dolaşıp (foreach)
    // getDepartmanKodu() ile bulunan sonuçlardan biriyle aynı mı? Diye bakıyoruz...
    // Aynıysa, "terminalden girilen çalışanı bu departmana set et" demektir...
    private void setDepartman(String departman) {
        // TODO setDepartman() methodunu doldurunuz

        //  Terminalden girilen calisanin departman koduna göre, gerekli departman set edilmelidir.
        //  Çalışan sınıfının Constructor 'ı main'de tanımlı. Program çalıştığında, terminalden gireceğimiz
        //  departman kodu, buradaki metod (setDepartman) vasıtasıyla departman listesinin tümünü dolaşıp (foreach)
        //  getDepartmanKodu() ile bulunan sonuçlardan biriyle aynı mı? Diye bakıyoruz...
        //  Aynıysa, "terminalden girilen çalışanı bu departmana set et" demektir...
        //  İpucu: Departman listesinin (Veritabani.Departmanlar.DepartmanList) içerisindeki departmanların kodları var,
        //  bu kodlari donguye tutmak ise yarayabilir.


        for (Departman departman1:Departmanlar.getDepartmanList()){
            if (departman1.getDepartmanKodu().equalsIgnoreCase(departman)){
              this.Departman=departman1;
              break;
            }
        }

    }


    private void setCalisanId() {
        // TODO setCalisanId() methodunu doldurunuz
        // Calisanin ID sinin kendisine özel olduğundan bahsetmistik,
        // ID nin nasil kaydedileceği Readme Dosyasi içerisinde yer aliyor.
        String departmankodu=this.Departman.getDepartmanKodu();
        String isimkodu=getCalisanIsimKodu();
        this.calisanId=departmankodu+sayac+isimkodu;
        sayac++;

    }

    private String getCalisanIsimKodu() {
        // TODO getCalisanIsimKOdu() methodunu doldurunuz
        // Calisanin ID sinin sonuna isim kodu eklenmesi için, ismi parçalayan bir method
        // Basit string metodlari ise isinize cok yarayacaktir fakat dinamik olmasina dikkat edelim...
        // Mesela 2 isim bir soyisim girildiğinde hata vermesin.

        String[] isimParcalari = this.adSoyad.split(" ");
        StringBuilder kodu= new StringBuilder();

        // Her bir parçanın ilk harfini alırız
        for (String isim : isimParcalari) {
            kodu.append(isim.charAt(0));

        }

        // Kodun tamamını büyük harfe çeviririz


         return kodu.toString().toUpperCase() ;// TODO burayi unutmayin
    }



    // Calisanin id sini almak icin basit getter method
    public String getCalisanId() {
        return this.calisanId;
    }

    // Calisanin departmanini almak icin basit getter method
    public Departman getDepartman() {
        return this.Departman;
    }



    // Departman adini verebilmek için bir method
    public String getDepartmanAdi( ) {
        String departmanAdi = "";
        // TODO getDepartmanAdi() methodunu doldurunuz
        // İpucu: Departman Kodu YD ise departman adi Yonetim Departmani olarak kaydedilmelidir.
            switch (Departman.getDepartmanKodu()){
                case "YD": departmanAdi="Yonetim Departmani"; break;
                case "IKD": departmanAdi="Insan Kaynaklari Departmani"; break;
                case "BTD": departmanAdi="Bilisim Teknolojileri Departmani"; break;
                default:
                    System.out.println("Bilinmeyen Departman Adi"); break;
            }


        return departmanAdi ;// TODO burayi unutmayin
    }
    public double getMaas() {
        return maas;
    }

    public void setMaas(double maas) {
        this.maas = maas;
    }
    // Calisana zam yapilmasi için gerekli bir method
        public static void zamYap(String calisanId) {
            // TODO zamYap() methodunu doldurunuz
            // İpucu:Calisan ID si kullanilarak yapilmalidir, diğer attributelarin aynilarindan 1 er tane daha olabilirdi.
            boolean varmi = false;
            for (Calisan calisan : Calisanlar.getCalisanList()) {
                // Eğer çalışan ID'si verilen ID ile eşleşiyorsa
                if (calisan.getCalisanId().equalsIgnoreCase(calisanId)) {
                    String departmanKodu = calisan.getDepartman().getDepartmanKodu();
                    double zamOrani = 0;
                    switch (departmanKodu) {
                        case "YD":
                            zamOrani = new YonetimDepartmani().getZamOrani();
                            break;
                        case "IKD":
                            zamOrani = new InsanKaynaklariDepartmani().getZamOrani();
                            break;
                        case "BTD":
                            zamOrani = new BilisimTeklonojileriDepartmani().getZamOrani();
                            break;
                        default:
                            System.out.println("Bilinmeyen Departman Adi");
                            return;

                    }
                    double yeniMaas = calisan.getMaas() * (1 + zamOrani);
                    calisan.setMaas(yeniMaas);

                    System.out.println(calisanId + " Id'li calisan yeni maasi " + yeniMaas);
                    varmi = true;


                }

            }
            if (!varmi) {
                System.out.println("ID bulunmadi");


            }
        }
    // Calisanlari yazdırmak için gerekli bir override
    @Override
    public String toString() {

        // TODO toString() metheodunu doldurunuz
        // İpucu: Detayli anlatim EmployeesRequirements.pdf içerisinde.

        return  "Calisan Id: "+getCalisanId() +", Isim Soyisim: " + adSoyad + ", Maas:" + this.maas + ", Departman: " + getDepartmanAdi() ;// TODO burayi unutmayin




    }
}
