import java.lang.reflect.Array;
import java.util.ArrayList;

public class TechnicalStuff extends StuffManager{

    public void menu() {


        int giris;
        boolean control = true;

        System.out.println("Yapmak istediğiniz işlemi giriniz.\n********************************");
        while (control) {
            System.out.println("1-Destek mesajlarını görüntüle \n2-Çıkış Yap\n***************");
            System.out.print("Seçiminiz : ");

            giris = scanner.nextInt();

            if (giris == 1) {       // müşterinin odasındaki bildirdiği  problemleri görüntülüyoruz
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

    // müşterinin odasındaki bildirdiği  problemleri görüntülüyoruz
    public void showRequest(){
        while (true){
            technicalSupportMessages.clear();
            getRequest();

            for(TechnicalSupports technicalSupports:technicalSupportMessages){
                if(technicalSupports.getTechnical_status()==0) {
                    System.out.println("Hizmet Id: " + technicalSupports.getTechnical_id() + " Hizmet Oda Numarası: " + technicalSupports.getTechnical_roomnumber() + " Hizmet istenilen Zamanı: " + technicalSupports.getTechnical_time());

                }}

            System.out.println("1-İstekleri güncelle \n2-Çıkış yap");
            System.out.print("Seçiminiz : ");
            int choice = scanner.nextInt();
            //Bu for da tekrar kontrol etmek istediğimizde sorun çıkardığı için ekledik
            for(TechnicalSupports technicalSupports:technicalSupportMessages){
                if ((choice == 1)&&technicalSupports.getTechnical_status()==0) {
                    updateRequest();
                    menu();
                }
                if (choice==2) {
                    menu();
                }
                if(choice!=1&&choice!=2){
                    System.out.println("\n Hatalı tuşlama !!!\n");
                }

            }


    }}
    // problemin çözüldükten sonra durumunu güncelliyoruz
    public void updateRequest(){
        System.out.println("************************************************");
        System.out.println("Destek numarasını giriniz:");

        int choice=scanner.nextInt();
        updateOrderOrSupport("technicalsupport","technical_status",choice,1);

    }
}
