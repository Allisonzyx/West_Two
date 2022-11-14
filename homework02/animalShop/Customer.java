package homework02.animalShop;

import java.time.LocalDate;

public class Customer {
    private String name;
    private int comeNumber;//顾客来店的次数
    private LocalDate date;//顾客最新到店的日期

    public Customer(String name, int comeNumber, LocalDate newDate) {
        this.name = name;
        this.comeNumber = comeNumber+1;//传入之前顾客已经到店次数，再加上这一次
        this.date = newDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getComeNumber() {
        return comeNumber;
    }

    public void setComeNumber(int comeNumber) {
        this.comeNumber = comeNumber;
    }

    public LocalDate getNewDate() {
        return date;
    }

    public void setNewDate(LocalDate newDate) {
        this.date = newDate;
    }

    @Override
    public String toString() {
        return "顾客姓名：" + name  +
                "\t顾客来店铺次数：" + comeNumber +
                "\t顾客最新到店日期：" + date;
    }
}
