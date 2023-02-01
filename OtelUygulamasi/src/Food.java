public class Food {

    // bu classın tek görevi oluşturacak nesnenin tipini belirlemek
    private int food_id,food_price,food_calories;
    private String food_name,food_category;

    public Food(int food_id, String food_name,int food_calories,int food_price,String food_category ) {
        this.food_id = food_id;
        this.food_name = food_name;
        this.food_price = food_price;
        this.food_calories = food_calories;
        this.food_category = food_category;
    }

    public int getFood_id() {
        return food_id;
    }

    public void setFood_id(int food_id) {
        this.food_id = food_id;
    }

    public int getFood_price() {
        return food_price;
    }

    public void setFood_price(int food_price) {
        this.food_price = food_price;
    }

    public int getFood_calories() {
        return food_calories;
    }

    public void setFood_calories(int food_calories) {
        this.food_calories = food_calories;
    }

    public String getFood_category() {
        return food_category;
    }

    public void setFood_category(String food_category) {
        this.food_category = food_category;
    }

    public String getFood_name() {
        return food_name;
    }

    public void setFood_name(String food_name) {
        this.food_name = food_name;
    }

}
