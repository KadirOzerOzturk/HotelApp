import java.util.UUID;

public class ManagementManager extends DbConnection {



    int planBinary;
    static String   customerChoice1,name, surname, gender, country;


    static int age,roomnumber,plan;
    public void managerMenu() {

        MainPage mainPage = new MainPage();
        int giris;
        String kontrol = "1";
        System.out.println("Yapmak istediğiniz işlemi giriniz.\n********************************");
        while (kontrol.equals("1")) {
            System.out.println("1-Müşteri kayıt \n2-Personel kayıt\n3-Müşteri çıkışı\n4-Ana Menüye dön\n***************");
            System.out.print("Seçiminiz : ");

            giris = scanner.nextInt();

            if (giris == 1) {
                kontrol = "";
                saveCustomer();
            } else if (giris == 2) {
                kontrol = "";
                saveStuff();
            } else if (giris == 3) {
                kontrol = "";
                customerExit();

            } else if (giris == 4) {
                mainPage.showLoginChoice();
            } else {
                System.out.println("Hatalı giriş yaptınız !!\n****************");
            }


        }
    }

    public void saveStuff(){
        System.out.println("Personel ismi giriniz : ");
        scanner.nextLine();

        String stuffName=scanner.nextLine();
        System.out.println("Personel soyadı giriniz : ");
        String stuffSurname=scanner.nextLine();
        System.out.println("Personel yaşı giriniz : ");
        int stuffAge=scanner.nextInt();
        System.out.println("Personel cinsiyeti giriniz : ");
        String stuffGender=scanner.next();
        System.out.println("Personel departmanını giriniz : ");
        scanner.nextLine();
        String stuffDepartment=scanner.nextLine();
        System.out.println("Personelin kullanıcı adını giriniz : ");
        String stuffUserName=scanner.next();
        System.out.println("Personel şifresini giriniz : ");
        String stuffPassword=scanner.next();
        setStuff(stuffName,stuffSurname,stuffAge,stuffGender,stuffUserName,stuffPassword,stuffDepartment);



    }

    public void saveCustomer() {





        System.out.println("Kaç kişilik oda istiyorsunuz : ");
        int customerChoice=scanner.nextInt();
        showAvailableRooms(customerChoice);
        System.out.println("Hangi odayı istiyorsunuz(oda numarasını girin) : ");
        int room=scanner.nextInt();
        System.out.println("Kaç gece kalacaksınız?");
        int daycount=scanner.nextInt();
        getRooms();
        int spendAmonunt=rooms.get(room).getRoom_price()*daycount; // müşterinin kalacağı geceye göre ne kadar ödeme yapacağı hesaplanıyor
        while (true) {
            System.out.print("Müşteri planı giriniz\n1-)Her sey dahil \n2-)Her sey dahil değil \nSeciminiz: ");
            plan = scanner.nextInt();

            if (plan==1) {
                planBinary = 1;

                break;
            } else if (plan==2) {
                planBinary = 0;

                break;
            } else System.out.println("Hatalı giriş yaptınız !!\n**********************");
        }


        for (int i=0;i<customerChoice;i++) {

            System.out.print((i+1)+" . müşterinin Adını giriniz : ");
            scanner.nextLine();
            name = scanner.nextLine();
            System.out.print((i+1)+" . müşterinin Soyadını giriniz : ");
            surname = scanner.next();
            System.out.print((i+1)+" . müşterinin Yaşını giriniz : ");
            age = scanner.nextInt();
            System.out.print((i+1)+" . müşterinin Cinsiyetini giriniz : ");
            gender = scanner.next();
            System.out.print((i+1)+" . müşterinin Ülkesini giriniz : ");
            country = scanner.next();

            String uniqueID = UUID.randomUUID().toString().substring(0, 8);  // her müşteriye özel bir id veriliyor sisteme girişler bununla yapılıyor
            System.out.println((i+1)+" . müşterinin ID'si : " + uniqueID);


            updateRoomStatus(1,room,spendAmonunt);  // veritabanında odanın müsaitlik durumu ve odaya ödenecek tutar gönderiliyor
            setCustomer(name,surname,age,gender,country,uniqueID,room,planBinary);



        }
            managerMenu();
        }

        // bu fonksiyonda oteldeki boş odalar bulunuyor
        public void showAvailableRooms(int customerChoice){

        while(true){
            rooms.clear();
            getRooms();
        for(int i=0;i<rooms.size();i++){
            if (customerChoice==3)
                customerChoice1="3 kişilik";
            else if (customerChoice==2)
                customerChoice1="2 kişilik";
            else if (customerChoice==1)
                customerChoice1="1 kişilik";

            if(rooms.get(i).getRoom_status()==0){
                if(rooms.get(i).getRoom_option().equalsIgnoreCase(customerChoice1)){
                    System.out.print("Oda Numarası : "+rooms.get(i).getRoom_number()+"  Oda durumu : Müsait"+"  Oda Manzarası : "+rooms.get(i).getRoom_view()+"  Oda Fiyatı : "+rooms.get(i).getRoom_price()+"  Oda Seçeneği : "+rooms.get(i).getRoom_option()+"\n");
                }

            }

        }
        break;
        }
        }
        // müşteri otelden çıkış yapacağı zaman oda için ödenecek tutar ve her şey dahil olup olamama durumuna göre kişinin ödeyeceği tutar gösteriliyor
        public void customerExit(){
            getCustomers();
            getRooms();
            System.out.println("Hangi oda için işlem yapmak istiyorsunuz?");
            int roomnumber=scanner.nextInt();
            for(Customer customer:customers){
                if(customer.getCustomer_roomnumber()==roomnumber&&customer.getCustomer_plan()==0){
                    System.out.println(customer.getCustomer_name()+" harcamaları için ödeyeceği ücret : "+customer.getCustomer_spendamount());

                    updateCustomer(customer.getCustomer_uniqueID());
                }else if (customer.getCustomer_roomnumber()==roomnumber&&customer.getCustomer_plan()==1){
                    System.out.println("Harcamalarınız için herhangi bir ücret ödemeyeceksiniz.");
                }
            }for(Room room:rooms){
                if(room.getRoom_number()==roomnumber){
                    updateRoomStatus(0,roomnumber,0);
                    System.out.println("Oda için ödeyeceğiniz ücret : "+room.getRoom_spendamount());
                }

            }
            System.out.println("Devam etmek için bir tuşa basınız ");
            String choice=scanner.next(); // buraya direkt bitirmemesi için koyduk
            managerMenu();


    }



}
