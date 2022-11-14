package homework02.animalShop.animal;

public class Pig extends Animal {
    static int count;//宠物店剩余猪的数量
    private double primeCost=200;//猪的进货价300
    private double sellingPrice=400;

    public Pig(String name, int age, String gender, double sellingPrice) {
        super(name, age, gender, sellingPrice);
    }
    public Pig(){
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

    @Override
    public String toString() {
        return  "小猪佩奇——"+
                "\t姓名:"+this.getName()+
                "\t年龄:"+this.getAge()+
                "\t性别:"+this.getGender()+
                "\t购买价格:"+this.getSellingPrice();
    }
}
