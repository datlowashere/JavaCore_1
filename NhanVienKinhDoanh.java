
package AssignmentJava1;
import java.util.Scanner;
public class NhanVienKinhDoanh extends NhanVienHanhChinh{
    private double hoahong;
    private double doanso;
    
    @Override
   public void nhap(){
        super.nhap();
        Scanner sc=new Scanner(System.in);
        System.out.println("Hoa hồng: ");
        hoahong=sc.nextDouble();
        System.out.println("Doanh số: ");
        doanso=sc.nextDouble();
    }
   @Override
   public double thunhap(){
       return luong+((hoahong*doanso)/100);
   }
 
    
    
    
}
