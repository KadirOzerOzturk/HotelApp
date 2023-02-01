

public class StuffManager extends DbConnection {

    // giriş yapan personelin departmanına göre classına yönlendirme yapıyoruz
    public void stuffRedirect(int index){
        getStuff();

        KitchenStuff kitchenStuff=new KitchenStuff();
        Waiters waiters=new Waiters();
        TechnicalStuff technicalStuff=new TechnicalStuff();
        HousekeepingStuff housekeepingStuff=new HousekeepingStuff();
        String department=stuffs.get(index).getStuff_department();
        if(department.equalsIgnoreCase("kitchen")){
            getOrders();
            kitchenStuff.menu();
        }
        else if (department.equalsIgnoreCase("waiter")) {
            waiters.menu();
        }
        else if (department.equalsIgnoreCase("technician")) {
              technicalStuff.menu();
        } else if (department.equalsIgnoreCase("housekeeping")) {
            housekeepingStuff.menu();
        }

    }



}
