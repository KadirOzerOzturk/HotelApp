public class Waiters extends StuffManager {

    public void menu() {


        int giris;
        boolean control = true;

        System.out.println("Yapmak istediğiniz işlemi giriniz.\n********************************");
        while (control) {
            System.out.println("1-Sipariş ekle \n2-Çıkış Yap\n***************");
            System.out.print("Seçiminiz : ");

            giris = scanner.nextInt();

            if (giris == 1) {
                control = false;
                addOrder();
                menu();
            } else if (giris == 2) {
                control = false;
                updateTime("checkout",Login.stuff_username); // personelin çıkış yaptığı saati kaydediyoruz

                MainPage.showLoginChoice();
            } else {
                System.out.println("Hatalı giriş yaptınız !!\n****************");
            }


        }

    }

    // burda ise restorant bölümünde garsonun aldığı siparişleri veritabanına aktarıyoruz
    public void addOrder(){

        CustomerManager customerManager=new CustomerManager();
        customerManager.foodDisplaying();
        getFoods();

        while (true){
            int orderCount,orderTableNumber;
            String customerID;
            String secim;
            System.out.print("Lütfen seçmek istediğiniz ürünün numarasını giriniz: ");
            int yemeksecim = scanner.nextInt();
            System.out.print("Masa numarasını giriniz : ");
            orderTableNumber=scanner.nextInt();
            System.out.println("Müşteri ID sini giriniz : ");
            customerID=scanner.next();
            System.out.print("Lütfen kaç porsiyon istediğniz giriniz: ");
            orderCount = scanner.nextInt();
            System.out.print("Devam etmek istiyorsanız 'E' tuşlayın bitirmek için herhangi bir tuşa basın : ");
            secim=scanner.next();
            orderAddingForWaiters(yemeksecim , orderTableNumber, orderCount,customerID);
            if (!secim.equalsIgnoreCase("e")){
                break;
            }
        }




    }





}
