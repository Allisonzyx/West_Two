package homework02;

public class CheckEmail {
    public static void main(String args[]){
        System.out.println(checkEmail("9090@trtr.com"));
    }

    public static boolean checkEmail(String email){
        boolean flag=email.matches("[A-Za-z0-9].*@[A-Za-z0-9].*\\.com");
        return flag;
    }

}
