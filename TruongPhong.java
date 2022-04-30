
package AssignmentJava1;
import java.util.Scanner;
public class TruongPhong extends NhanVienHanhChinh {
    private double luongtn;
    
   
    @Override
    public void nhap(){
        super.nhap();
        Scanner sc=new Scanner(System.in);
        System.out.println("Lương trách nhiệm: ");
        luongtn=sc.nextDouble();
        
    }
    @Override
    public double thunhap(){
        return luong+luongtn;
    }


    
}
