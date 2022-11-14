package homework02.animalShop;

import homework02.animalShop.animal.Animal;
import homework02.animalShop.animal.Cat;
import homework02.animalShop.animal.Dog;
import homework02.animalShop.animal.Pig;
import homework02.animalShop.exception.AnimalNotFoundException;
import homework02.animalShop.exception.InsufficientBalanceException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedList;

public class MyAnimalShop implements AnimalShop{
    double balance=Balance.balance;
    static LinkedList<Animal> animalList=new LinkedList();
    static ArrayList<Customer> customerList=new ArrayList();
    boolean open=true;//是否正在营业

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public LinkedList getAnimalList() {
        return animalList;
    }

    public void setAnimalList(LinkedList animalList) {
        this.animalList = animalList;
    }

    public ArrayList getCustomerList() {
        return customerList;
    }

    public void setCustomerList(ArrayList customerList) {
        this.customerList = customerList;
    }

    public boolean isOpen() {
        return open;
    }

    public void setOpen(boolean open) {
        this.open = open;
    }


    @Override
    public void buyNewAnimal(Animal animal, int num,LocalDate localDate) {
        double totalCost=0;//记录进货总花费
        //查看购买的宠物是什么类型
        if (animal instanceof Dog){
            Dog dog=(Dog)animal;
            totalCost=num*dog.getPrimeCost();
            //看看店铺余额是否充足
            if(balanceEnoughOrNot(totalCost)){
                Balance.expend(totalCost,localDate);
            }
            for (int i = 0; i < num; i++) {
              animalList.add(new Dog());
            }
        }
        if (animal instanceof Cat){
            Cat cat=(Cat)animal;
            totalCost=num*cat.getPrimeCost();
            //看看店铺余额是否充足
            if(balanceEnoughOrNot(totalCost)){
                Balance.expend(totalCost,localDate);
            }
            for (int i = 0; i < num; i++) {
                animalList.add(new Cat());
            }
        }
        if (animal instanceof Pig){
            Pig pig=(Pig) animal;
            totalCost=num*pig.getPrimeCost();
            //看看店铺余额是否充足
            if(balanceEnoughOrNot(totalCost)){
                Balance.expend(totalCost,localDate);
            }
            for (int i = 0; i < num; i++) {
                animalList.add(new Pig());
            }
        }


    }

    @Override
    public void entertainCustomer(Customer customer, Animal animal, int num, LocalDate localDate) {
        customerList.add(customer);
        double totalIncome=0;
        if (animal instanceof Dog){
            animalEnoughOrNot(animal,num);
            Dog dog=(Dog)animal;
            totalIncome=dog.getSellingPrice()*num;
        }
        if (animal instanceof Cat){
            animalEnoughOrNot(animal,num);
            Cat cat=(Cat) animal;
            totalIncome=cat.getSellingPrice()*num;
        }
        if (animal instanceof Pig){
            animalEnoughOrNot(animal,num);
            Pig pig=(Pig) animal;
            totalIncome=pig.getSellingPrice()*num;
        }
        Balance.income(totalIncome,localDate);
    }

    @Override
    public void closeBusiness() {
        System.out.println("！！！！！！！今天歇业了！！！！！！！");
        int todayTotalIncome=0;
        int todayTotalExpend=0;
        //打印当日到店顾客
        System.out.println("============今日到店顾客============");
        for (int i = 0; i < customerList.size(); i++) {
            if(customerList.get(i).getNewDate().isEqual(LocalDate.now())){
                System.out.println(customerList.get(i));
            }
        }
        //打印当日收入清单
        System.out.println("============今日收入清单============");
        for (int i = 0; i < Balance.incomeList.size(); i++) {
            //判断是否是今天的收入
            if (Balance.incomeList.get(i).getLocalDate().isEqual(LocalDate.now())){
                todayTotalIncome+=Balance.incomeList.get(i).getMoney();
                System.out.println("收入——"+Balance.incomeList.get(i));
            }
        }
        //打印当日支出清单
        System.out.println("============今日支出清单============");
        for(int i=0;i<Balance.expendList.size();i++){
            //判断是否是今天的支出
            if(Balance.expendList.get(i).getLocalDate().isEqual(LocalDate.now())){
                todayTotalExpend+=Balance.expendList.get(i).getMoney();
                System.out.println("支出——"+Balance.expendList.get(i));
            }
        }
        //打印店铺今日总营业额
        System.out.println("今日店铺总营业额："+(todayTotalIncome-todayTotalExpend));
    }
    //判断店铺余额是否充足
    public static boolean balanceEnoughOrNot(double totalCost){
        //看看店铺余额够不够
        if(Balance.balance-totalCost>=0){
            System.out.println("余额充足，可以购买");
            return true;
        }else {
            throw new InsufficientBalanceException("店铺余额不足");
        }
    }
    //判断animalList里顾客想买的宠物数量是否充足
    public static boolean animalEnoughOrNot(Animal animal,int num){
        int count=0;//记录animalList里顾客想要买的宠物类型的只数
        for (int i=0;i<animalList.size();i++){
            if(animalList.get(i).getClass().equals(animal.getClass())){
                count++;
            }
        }
        if(count>=num){
            System.out.println("该类型宠物数量充足，可以出售");
            return true;
        }else {
            throw new AnimalNotFoundException("该类型宠物数量不足，无法出售这么多宠物");
        }
    }
}
