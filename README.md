# LCWaikiki Test Otomasyon Bootcamp Bitirme Projesi

## Giriş
LCWTest, bir e-ticaret platformunun temel işlevlerini otomatikleştirmek ve manuel test çabalarını en aza indirmek için tasarlanmış Selenium tabanlı bir test otomasyon projesidir.

## Teknolojiler ve Araçlar
- **Programlama Dili:** Java
- **Test Framework:** TestNG
- **Otomasyon Framework:** Selenium WebDriver
- **Raporlama Araçları:** ExtentReports, Allure
- **Mimari:** Page Object Model (POM)

## Proje Yapısı
Proje modüler bir yapıya sahiptir ve şu paketlere ayrılmıştır:

### 1. Tests Paketi
Test senaryolarını içerir:
- **BaseTest:** setUp Testlerin başlamasından önce çalışır driver ayarlarını yapar. tearDown Testlerin tamamlanmasından sonra çalışır, WebDriver oturumunu sonlandırır ve assert sonuçlarını raporlar.
- **loginTest():** Geçerli kullanıcı bilgileriyle giriş işlevini doğrular.
- **HeaderTest:** Çocuk ve Bebek üst-alt menüsündeki kategorilerden Mont ve Kaban Content'indeki ürünleri listeler.
- **ProductDetailTest:** Sepetteki ürünün Renk-Fiyat-Adet-Ad bilgilerini alır ve ürünleri favorilere ekler.
- **ProductTest:** Filtreleme ve sıralama işlevlerini test eder.
- **Basket:** Sepetteki ürünlerin Renk-Fiyat-Adet-Ad bilgilerini alır ve ürün bilgisi ile karışılaştırır daha sonra ürünleri favorilere ekler.
- **LCWTest:** Test senaryosunun tamamının gerçekleştiği test class'ıdır.

### 2. Pages Paketi
Sayfa bazlı sınıfları içerir:
- **BasePage:** Diğer page'lerin driver ayarlarını kalıtım aldığı sınıftır.
- **LoginPage:** Giriş işlemleri için yöntemler içerir. Örneğin: Giriş butonuna tıklama, email ve şifre bilgilerine girme submit etme.
- **HeaderPage:** Menü işlemleri için yöntemler içerir. Örneğin: Üst menü ve alt menü kategorilerinden seçilenlere hove işlemi yapma, Content'e click işlemi.
- **ProductPage:** Ürün işlemleri için yöntemler içerir. Örneğin: Renk-Size filtreleme işlemi, X.'ci ürünü seçme işlemi.
- **BasketPage:** Sepet işlemleri için yöntemler içerir. Örneğin: Ürünü favoriye ekleme, ürün bilgisini alma ve karşılaştırma işlemi.
- **ProductDetailPage:** Ürün sayfası işlemleri için yöntemler içerir. Örneğin: Stoktaki bedenin seçimi, Ürünü sepete ekleme ve ürün bilgilerini alma işlemi.
  
### 3. Utils Paketi
Yardımcı fonksiyonları ve raporlama işlemlerini içerir:
- **ExtentReports:** Ayrıntılı ve görsel test raporları oluşturur.
- **Log4j** Uygulama içi loglama işlemleri için kullanıldı.

## Test Senaryosu ve Detayları

### 1. Giriş Testi
- Geçerli e-posta ve şifre ile kullanıcı girişini doğrular.
- Giriş sonrası URL ile beklenen URL'yi karşılaştırarak doğrulama yapar.

### 2. Menü Gezinme Testi
- Çocuk ve Bebek kategorisinden alt menülere geçiş işlemlerini doğrular.
- "Mont ve Kaban" gibi content'lere başarılı yönlendirmeyi kontrol eder.

### 3. Ürün Filtreleme ve Seçim
- Yaş grubu veya renk gibi kriterlere göre ürün filtrelemeyi test eder.
- En çok satanlar kategorisinden ürün seçimi yapar.

### 4. Sepet Kontrolü ve Favoriler
- Sepete eklenen ürünlerin adı, fiyatı, rengini ve adedini doğrular.
- Ürünleri favorilere ekler ve veri tutarlılığını kontrol eder.

## Öne Çıkan Özellikler
- **Page Object Model (POM):** Test senaryolarının okunabilirliğini ve sürdürülebilirliğini artırır.
- **Ayrıntılı Raporlama:** ExtentReports her test adımı hakkında kapsamlı bilgiler sunar.
- **Yüksek Modülerlik:** Test senaryoları ve sayfa nesneleri ayrı sınıflarda tutulur, böylece yeniden kullanılabilir ve bakımı kolaydır.
- **Dinamik Test Senaryoları:** Testler, çeşitli kullanıcı senaryolarını dinamik olarak temsil eder.

## Testleri Çalıştırma
1. Depoyu klonlayın.
2. Projeyi tercih ettiğiniz IDE'ye (ör. IntelliJ, Eclipse) aktarın.
3. `pom.xml` dosyasındaki gerekli bağımlılıkları yapılandırın.
4. İstediğiniz test sınıflarını TestNG kullanarak çalıştırın.
5. Oluşturulan ExtentReports veya Allure panellerinde ayrıntılı raporları görüntüleyin.

---

Projemi incelediğiniz için teşekkür ederim.
## REK ##
