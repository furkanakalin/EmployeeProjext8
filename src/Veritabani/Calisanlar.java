package Veritabani;

import Modeller.Calisanlar.Calisan;
import java.util.ArrayList;
import java.util.Iterator;

public class Calisanlar {


    // Buradaki calisanList static cünkü proje calismaya basladiği anda oluşması lazım.
    // Bunu bir veritabani gibi görebiliriz. Calisanlarimizin hepsi bu liste icerisinde yer alacak.
    private static ArrayList<Calisan> calisanList = new ArrayList<>();

    // // Tüm çalışanları almak için
    public static ArrayList<Calisan> getCalisanList() {
        return calisanList;
    }


    public static void addACalisan(Calisan calisan) {

        // TODO Bir çalışan eklemek için gerekli method. addACalisan() methodunu doldurunuz
        calisanList.add(calisan);

    }


    public static void deleteACalisanWithId(String calisanId) {
        boolean varmi=false;
        // TODO Bir çalışan silmek için gerekli method. deleteACalisanWithId() methodunu doldurunuz
        // Silinecek çalışanı bulmak için listeyi dolaşıyoruz
       for (Calisan id: calisanList){
           if (id.getCalisanId().equalsIgnoreCase(calisanId)){
               calisanList.remove(id);
               System.out.println(calisanId + " ID'li çalışan listeden silindi.");
               varmi=true;
               break;
           }


       }
        if (!varmi){
            System.out.println(" Belirtilen ID'ye sahip çalışan bulunamadı.");
        }



//
//        Iterator<Calisan> iterator = calisanList.iterator();
//        while (iterator.hasNext()) {
//            Calisan calisan = iterator.next();
//            if (calisan.getCalisanId().equalsIgnoreCase(calisanId)) {
//                iterator.remove(); // Eşleşen çalışan bulunduğunda listeden çıkarılır
//                System.out.println(calisanId + " ID'li çalışan listeden silindi.");
//                return;
//            }
//        }
        // Eğer belirtilen ID'ye sahip bir çalışan bulunamazsa


    }


    public static void printDepartmandakiCalisanlar(String departmanKodu) {

        // TODO  Departman kodu verilerek, konsola sadece o departmanda calisanlari yazdirmak için
        //       printDepartmandakiCalisanlar() methodunu doldurunuz

        boolean bulunma = false;
        for (Calisan calisan : calisanList) {
            if (calisan.getDepartman().getDepartmanKodu().equalsIgnoreCase(departmanKodu)) {
                System.out.println(calisan);
                bulunma = true;
            }
        }
        // Eğer belirtilen departmanda çalışan bulunamazsa
        if (!bulunma) {
            System.out.println("Belirtilen departmanda çalışan bulunamadı.");
        }



    }


    public static void printCalisanlar() {

        // TODO  Calisanlari konsola yazdirmak için printCalisanlar() methodunu doldurun
        if (calisanList.isEmpty()) {
            System.out.println("Listede hiç çalışan bulunmamaktadır.");
        } else {
            for (Calisan calisan : calisanList) {
                System.out.println(calisan);
            }



    }
}}
