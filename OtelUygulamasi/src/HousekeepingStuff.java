public class HousekeepingStuff extends StuffManager{
    public void menu() {


        int giris;
        boolean control = true;

        System.out.println("Yapmak istediğiniz işlemi giriniz.\n********************************");
        while (control) {
            System.out.println("1-İstekleri görüntüle \n2-Çıkış Yap\n***************");
            System.out.print("Seçiminiz : ");

            giris = scanner.nextInt();

            if (giris == 1) {   // gelen housekeeping isteklerini görüntüleyen fonksiyona yönlendiriliyor
                control = false;
                showRequest();
                menu();
            } else if (giris == 2) {

                control = false;
                updateTime("checkout",Login.stuff_username);
                MainPage.showLoginChoice();
            } else {
                System.out.println("Hatalı giriş yaptınız !!\n****************");
            }
        }

    }
    // gelen housekeeping isteklerini personele gösteriyor
    public void showRequest(){
    while (true){
            housekeepingRequest.clear();
            getHousekeepingRequest();



        for(Housekeeping housekeeping:housekeepingRequest){
            if(housekeeping.getHousekeeping_status()==0) {
                System.out.println("Hizmet Id: " + housekeeping.getId() + " Hizmet Oda Numarası: " + housekeeping.getHousekeeping_roomnumber() + " Hizmet istenilen Zamanı: " + housekeeping.getHousekeeping_time());

            }}

            System.out.println("1-İstekleri güncelle \n2-Çıkış yap");
            System.out.print("Seçiminiz : ");
            int choice = scanner.nextInt();
            //Bu for da tekrar kontrol etmek istediğimizde sorun çıkardığı için ekledik
        for(Housekeeping housekeeping:housekeepingRequest){
            if ((choice == 1)&&housekeeping.getHousekeeping_status()==0) {
                updateRequest();
                menu();
            }
            if (choice==2) {
                menu();
            }
            if(choice!=1&&choice!=2){
                System.out.println("\n Hatalı tuşlama !!!\n");
            }

    }}

    }
    // gelen isteğin durumunu güncelliyor
    public void updateRequest(){
        System.out.println("************************************************");
        System.out.println("Destek numarasını giriniz:");

        int choice=scanner.nextInt();
        updateHousekeepingStatus(1,choice);

    }




}
