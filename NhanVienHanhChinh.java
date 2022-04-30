
package AssignmentJava1;
import java.util.Scanner;
public class NhanVienHanhChinh{
    public String mnv,ten;
    public double luong;
    public void nhap(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Mã nhân viên:");
        mnv=sc.nextLine();
        System.out.println("Tên: ");
        ten=sc.nextLine();
        System.out.println("Lương: ");
        luong=sc.nextDouble();        
    }
    
    public double thunhap(){
        return luong;
    }
    public double thue(){
        double thue;
        if(thunhap()<=9000){
            thue=0;
        }else if(thunhap()>9000){
            thue=(thunhap()-9000)*0.1;
        }else{
            thue=(thunhap()-15000)*0.12+6000*0.1;
        }
        return thue;
    }
    public void xuat(){
        System.out.println("===================================");
        System.out.println("Mã \tTên \tThuNhập \tThuế");
        System.out.println(mnv+" |\t"+ten+" |\t"+thunhap()+" |\t"+thue());
    }

    
}
