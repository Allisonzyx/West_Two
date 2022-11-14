package homework02.animalShop;

import homework02.animalShop.animal.Animal;

import java.time.LocalDate;

public interface AnimalShop {
    //买入动物类型a，买入数量,买入时间
    void buyNewAnimal(Animal animal, int num, LocalDate localDate);

    //接待客户
    //顾客，顾客想买的宠物类型（猪，狗，猫），购买几只，顾客到店时间
    void entertainCustomer(Customer customer,Animal animal,int num ,LocalDate localDate);

    //歇业
    //
    void closeBusiness();
}
