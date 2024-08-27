package Modeller.Departmanlar;

public class BilisimTeklonojileriDepartmani implements Departman {

    final String departmanKodu = "BTD";

    // TODO Bu class'da sadece zam oranini belirtmelisiniz
    //      Başka bişeyi değiştirmeye gerek yok.
    final double zamOrani = 0.25;


    @Override
    public double getZamOrani() {
        return zamOrani;
    }

    @Override
    public String getDepartmanKodu() {
        return departmanKodu;
    }
}
