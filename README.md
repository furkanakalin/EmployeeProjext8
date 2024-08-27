Çalışan Kaydetme Projesi
Proje Tanımı
Bu proje, bir şirketin çalışanlarını departmanlara göre kaydetmek ve bu çalışanlar için belirli işlemler gerçekleştirmek amacıyla geliştirilmiştir. Çalışanların maaşları, bulundukları departmanlara göre zamlanabilir ve her bir çalışanın kendine ait benzersiz bir kimlik numarası (ID) vardır.

Özellikler
Departmanlara Göre Zam Yapma: Her departmanın kendine ait bir zam oranı vardır. Çalışanların maaşlarına sadece bu oran üzerinden zam yapılabilir.
Eşsiz Çalışan ID'si: Her çalışanın benzersiz bir ID'si vardır. Bu ID, çalışanın departman kodu, şirketteki çalışan sayısı ve çalışanın adının baş harflerinden oluşur.
Departman Bazlı Çalışan Listeleme: Belirli bir departmandaki çalışanları listeleyebilirsiniz.
Çalışan Bilgilerini Görüntüleme: Çalışanların ID, isim, maaş ve departman bilgilerini konsolda görüntüleyebilirsiniz.
Kullanım
Çalışan Ekleme: Yeni bir çalışan eklerken, departmanı seçilir ve otomatik olarak bir ID atanır.
Zam Yapma: Belirli bir çalışana zam yapmak için çalışan ID'si kullanılır. Zam oranı, çalışanın bulunduğu departmana göre belirlenir.
Çalışan Listeleme: Belirli bir departmandaki tüm çalışanları listeleyebilir ve maaşlarını görüntüleyebilirsiniz.
Proje Gereksinimleri
Java 8 ve üzeri
IntelliJ IDEA veya Eclipse gibi bir Java IDE'si
Nasıl Kurulur?
Bu projeyi yerel makinenize klonlayın:
git clone https://github.com/kullanici-adi/proje-adi.git
Projeyi IDE'nizde açın ve Main sınıfını çalıştırın.
Örnek Kullanım
Calisan calisan1 = new Calisan("Ilker Kula", "Bilişim Teknolojileri Departmanı", 25000);
System.out.println(calisan1);
calisan1.zamYap();
System.out.println(calisan1);

Collaborators
TEAM-8
