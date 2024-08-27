package Modeller.Departmanlar;

public class InsanKaynaklariDepartmani implements Departman {

    final String departmanKodu = "IKD";

    // TODO Bu class'da sadece zam oranini belirtmelisiniz
    //      Başka bişeyi değiştirmeye gerek yok.
    final double zamOrani = 0.2;

    @Override
    public double getZamOrani() {
        return zamOrani;
    }

    @Override
    public String getDepartmanKodu() {
        return departmanKodu;
    }
}
