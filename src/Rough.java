import java.util.Date;
import java.util.Random;

public class Rough {
    public static void main(String[] args) {
        System.out.println(Rough.generateRandomNo());
        System.out.println(Rough.getcurrentDate());

        }

    public static int generateRandomNo()
    {
        Random r=new Random();
        //from 0 to 9999
        int no=r.nextInt(10000);
        if (no>999)
            return no;
        else if (no<999 && no>100)
            return no*10;
        else if (no<100 && no>9)
            return no*100;
        else if (no<10 && no>0)
            return no*1000;
        else
            return 1356;
    }


    public static Date getcurrentDate()
    {
        long millis=System.currentTimeMillis();
        return new java.sql.Date(millis);
    }
}


