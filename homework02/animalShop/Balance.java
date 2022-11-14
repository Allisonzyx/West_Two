package homework02.animalShop;

import homework02.animalShop.exception.InsufficientBalanceException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

//专门管理钱的一个类
public class Balance {
    public static double balance=5000;//店铺资金,初始化5000
    static ArrayList<Money> incomeList=new ArrayList<Money>();//收入清单
    static ArrayList<Money> expendList=new ArrayList<Money>();

    LocalDate date;//这一笔收支进行的具体事件
    double money;//这一笔收支的数目

    //收入，卖出宠物
    public static void income(double money, LocalDate date){
        balance+=money;
        incomeList.add(new Money(money,date));
    }
    //支出，进货
    public static boolean expend(double money,LocalDate date){
        //计算余额是否足够用于购买宠物（进货）
        if(balance-money>0){
            balance-=money;
            System.out.println("进货成功");
            expendList.add(new Money(money,date));
            return true;
        }else{
            throw new InsufficientBalanceException("进货失败，余额不足");
        }

    }


}
//这个类代表每一笔收支，记录收支的数额/收支的时间
class Money{
    private double money;
    private LocalDate localDate;

    public Money(double money, LocalDate localDate) {
        this.money = money;
        this.localDate = localDate;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }

    @Override
    public String toString() {
        return "金额：" + money +
                "\t日期" + localDate;
    }
}
