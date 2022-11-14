package homework02.animalShop.animal;

public class Dog extends Animal {
    static int count;//宠物店剩余狗的数量
    private double primeCost=100;//狗的进货价100
    private double sellingPrice=200;
    boolean isVaccineInjected;

    public Dog(String name, int age, String gender, double sellingPrice) {
        super(name, age, gender, sellingPrice);
    }
    public Dog(){
        super();
    }
    public double getPrimeCost() {
        return primeCost;
    }
    public void setPrimeCost(double primeCost){
        this.primeCost=primeCost;
    }
    public double getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(double sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public boolean isVaccineInjected() {
        return isVaccineInjected;
    }

    public void setVaccineInjected(boolean vaccineInjected) {
        isVaccineInjected = vaccineInjected;
    }

    @Override
    public String toString() {
        return  "修勾修狗"+
                "\t姓名:"+this.getName()+
                "\t年龄:"+this.getAge()+
                "\t性别:"+this.getGender()+
                "\t购买价格:"+this.getSellingPrice();
    }
}
