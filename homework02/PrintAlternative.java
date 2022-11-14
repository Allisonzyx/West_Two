package homework02;

import java.util.concurrent.locks.LockSupport;

public class PrintAlternative {
    static Thread t1=null;
    static Thread t2=null;
    public static void main(String args[]){
        int[] arr1={1,3,5,7,9};
        int[] arr2={2,4,6,8,10};
        t1=new Thread( ()->{
            for (int num:arr1) {
                System.out.println(num);//先自己打印
                LockSupport.unpark(t2);//叫醒线程t2
                LockSupport.park();//阻塞线程自己，t1
            }
        });
        t2=new Thread( ()->{
            for (int num:arr2) {
                LockSupport.park();//先阻塞线程自己，t2，等t1叫醒
                System.out.println(num);
                LockSupport.unpark(t1);//叫醒线程t1

            }
        });
        t1.start();
        t2.start();


    }
}
