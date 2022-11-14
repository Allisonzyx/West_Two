package homework02.animalShop;

import homework02.animalShop.animal.Cat;
import homework02.animalShop.animal.Dog;
import homework02.animalShop.animal.Pig;

import java.time.LocalDate;

public class Test {
    public static void main(String args[]){
        MyAnimalShop my=new MyAnimalShop();
        //11.1日进货
        my.buyNewAnimal(new Dog(),2,LocalDate.of(2022,11,1));
        my.buyNewAnimal(new Cat(),2,LocalDate.of(2022,11,1));
        my.buyNewAnimal(new Pig(),2,LocalDate.of(2022,11,1));
        //11.1日到店顾客
        Customer jack=new Customer("jack",1, LocalDate.of(2022, 11, 1));
        Customer roy=new Customer("roy",2, LocalDate.of(2022, 11, 1));
        Customer karry=new Customer("karry",3, LocalDate.of(2022, 11, 1));
        //11.1日顾客购买宠物
        my.entertainCustomer(jack,new Dog(),1,LocalDate.of(2022,11,11));
        my.entertainCustomer(roy,new Cat(),1,LocalDate.of(2022,11,11));
        my.entertainCustomer(karry,new Pig(),1,LocalDate.of(2022,11,11));


        //今天进货
        my.buyNewAnimal(new Dog(),2,LocalDate.now());
        my.buyNewAnimal(new Cat(),2,LocalDate.now());
        my.buyNewAnimal(new Pig(),2,LocalDate.now());
        //测试InsufficientBalanceException
        //my.buyNewAnimal(new Pig(),200,LocalDate.now());
        //今天来的顾客
        Customer a=new Customer("a",3, LocalDate.now());
        Customer b=new Customer("b",5, LocalDate.now());
        Customer c=new Customer("c",8, LocalDate.now());
        Customer d=new Customer("d",3, LocalDate.now());
        my.entertainCustomer(a,new Dog(),2,LocalDate.now());
        my.entertainCustomer(b,new Dog(),1,LocalDate.now());
        my.entertainCustomer(c,new Pig(),1,LocalDate.now());
        my.entertainCustomer(d,new Cat(),1,LocalDate.now());
        //测试AnimalNotFoundException
        //my.entertainCustomer(d,new Cat(),100,LocalDate.now());

        //今天歇业
        my.closeBusiness();

    }
}
