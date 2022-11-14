package homework02.animalShop.animal;

public abstract class Animal {
    private String name;
    private int age;
    private String gender;
    private double sellingPrice;  //售货价
    private  double primeCost;  //进货价

    public Animal(String name, int age, String gender, double sellingPrice) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.sellingPrice = sellingPrice;
    }
    //无参构造器，默认进货的宠物未命名，1岁，性别未知（由顾客购买后自行命名）
    public Animal(){
        name="未命名";
        age=1;
        gender="未知";

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public double getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(double sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    @Override
    public abstract String toString() ;
}
