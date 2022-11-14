package homework02.animalShop.animal;

import javax.smartcardio.Card;

public class Cat extends Animal {
    static int count;//宠物店剩余猫的数量
    private double primeCost=100;//猫的进货价100
    private double sellingPrice=200;

    public Cat(String name, int age, String gender, double sellingPrice) {
        super(name, age, gender, sellingPrice);
    }
    public Cat(){
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
        return  "快乐星猫"+
                "\t姓名:"+this.getName()+
                "\t年龄:"+this.getAge()+
                "\t性别:"+this.getGender()+
                "\t购买价格:"+this.getSellingPrice();
    }
}
