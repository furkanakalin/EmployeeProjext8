package Modeller.Departmanlar;

public class YonetimDepartmani implements Departman {

    final String departmanKodu = "YD";

    // TODO Bu class'da sadece zam oranini belirtmelisiniz
    //      Başka bişeyi değiştirmeye gerek yok.
    final double zamOrani = 0.3;

    @Override
    public double getZamOrani() {
        return zamOrani;
    }

    @Override
    public String getDepartmanKodu() {
        return departmanKodu;
    }
}
