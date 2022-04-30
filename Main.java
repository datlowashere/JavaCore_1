
package AssignmentJava1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Collection;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    ArrayList<NhanVienHanhChinh> ds=new ArrayList<>();
    Scanner sc=new Scanner(System.in);
   public void nhap(){
        String chon1;
        do{
        int n;
        System.out.println("Nhập tổng số lượng nhân viên: ");
        n=sc.nextInt();
        for(int i=0;i<n;i++){
            System.out.println("Nhập nhân viên thứ "+(i+1)+" : ");
            System.out.println("Chọn loại nhân viên:");
            System.out.println("1.Nhân viên hành chính");
            System.out.println("2.Nhân viên kinh doanh");
            System.out.println("3.Trưởng phòng");            
            int loainv=sc.nextInt();
            if(loainv==1){
                System.out.println("Nhân viên hành chính");
                NhanVienHanhChinh nv=new NhanVienHanhChinh();
                nv.nhap();
                ds.add(nv);
            }else if(loainv==2){
                System.out.println("Nhân viên kinh doanh");
                NhanVienHanhChinh nv=new NhanVienKinhDoanh();
                nv.nhap();
                ds.add(nv);
            }else{
                System.out.println("Trưởng phòng");
                NhanVienHanhChinh nv=new TruongPhong();
                nv.nhap();
                ds.add(nv);
            }
        
        }
            System.out.println("Bạn có muốn tiếp tục nhập nhân viên không?(y/n)");
            chon1=sc.nextLine();
            chon1=sc.nextLine();            
            if(chon1.equalsIgnoreCase("n")){
                break;
            }
            
        }while(chon1.equalsIgnoreCase("y"));   
    }
  public  void xuat(){
        String chon2;
        do{
        System.out.println("Danh sách nhân viên");
        for(NhanVienHanhChinh nv:ds){
            nv.xuat();
        }
            System.out.println("Bạn có muốn tiếp tục xuất danh sách nhân viên không?(y/n)");
            chon2=sc.nextLine();
            chon2=sc.nextLine();            
            if(chon2.equalsIgnoreCase("n")){
                break;
            }
            
        }while(chon2.equalsIgnoreCase("y"));
    }
   public void tim(){
        String chon3;
        do{
        System.out.println("Nhập mã nhân viên cần tìm:");
        String x=sc.nextLine();
        x=sc.nextLine();
        boolean check=false;
        for(NhanVienHanhChinh nv:ds){
            if(nv.mnv.contains(x)){
                System.out.println("Tìm thấy");
                nv.xuat();
                check=true;
                break;
            }
        }
        if(check==false){
            System.out.println("Không tồn tại ");
        }
        
            System.out.println("Bạn có muốn tiếp tục tìm không?(y/n)");
            chon3=sc.nextLine();            
            if(chon3.equalsIgnoreCase("n")){
                break;
            }
        
        }while(chon3.equalsIgnoreCase("y"));
    }
   public void xoa(){
        String chon4;
        do{
        System.out.println("Nhập mã nhân viên cần xóa");
        String x=sc.nextLine();
        x=sc.nextLine();
        boolean check=false;
        for(NhanVienHanhChinh nv:ds){
            if(nv.mnv.contains(x)){
                ds.remove(nv);
                check=true;
                System.out.println("Đã xóa");
                System.out.println("Danh sách nhân viên sau khi xóa");
                xuat();                
                break;
            }
        }

        if(check==false){
            System.out.println("Không tồn tại");
        }
        
            System.out.println("Bạn có muốn tiếp tục xóa không?(y/n)");
            chon4=sc.nextLine();            
            if(chon4.equalsIgnoreCase("n")){
                break;
            }
        
        }while(chon4.equalsIgnoreCase("y"));
        
    }
   public void capnhat(){
        String chon5;
        do{
        System.out.println("Nhập mã nhân viên cần cập nhật:");
        String x=sc.nextLine();
        x=sc.nextLine();
        boolean check=false;
        for(NhanVienHanhChinh nv:ds){
            if(nv.mnv.contains(x)){
                nv.nhap();
                check=true;
                System.out.println("Danh sách nhân viên sau khi Cập nhật");
                xuat();                
                break;
            }
        }
        if(check==false){
            System.out.println("Không tồn tại");
        }
        
            System.out.println("Bạn có muốn tiếp tục cập nhật không?(y/n)");
            chon5=sc.nextLine();            
            if(chon5.equalsIgnoreCase("n")){
                break;
            }
        }while(chon5.equalsIgnoreCase("y"));
    }
  public  void timluong(){
        String chon6;
        do{
        double min, max;
        System.out.println("Min luong: ");
        min=sc.nextDouble();
        System.out.println("Max luong: ");
        max=sc.nextDouble();  
        boolean check=false;
        for(NhanVienHanhChinh nv:ds){
            if(min<=nv.thunhap() && nv.thunhap()<=max){
                nv.xuat();
                check=true;
            }
        }
        if(check=false){
            System.out.println("Không có nhân viên nào trong khoảng lương này!");
        }
        
            System.out.println("Bạn có muốn tiếp tục tìm theo khoảng lương không?(y/n)");
            chon6=sc.nextLine();
            chon6=sc.nextLine();            
            if(chon6.equalsIgnoreCase("n")){
                break;
            }
        }while(chon6.equalsIgnoreCase("y"));
    }
    
    Comparator<NhanVienHanhChinh> ssten=new Comparator<NhanVienHanhChinh>() {
        @Override
        public int compare(NhanVienHanhChinh o1, NhanVienHanhChinh o2) {
            return o1.ten.compareTo(o2.ten);
        }
    };
   public void sxT(){
        String chon7;
        do{
        Collections.sort(ds,ssten);
        System.out.println("Danh sách nhân viên");
        for(NhanVienHanhChinh nv:ds){
            nv.xuat();
        }        
        
            System.out.println("Bạn có muốn tiếp tục sắp xếp theo tên không?(y/n)");
            chon7=sc.nextLine();
            chon7=sc.nextLine();            
            if(chon7.equalsIgnoreCase("n")){
                break;
            }
        }while(chon7.equalsIgnoreCase("y"));
    }
    
    
    Comparator<NhanVienHanhChinh> sst=new Comparator<NhanVienHanhChinh>() {
        @Override
        public int compare(NhanVienHanhChinh o1, NhanVienHanhChinh o2) {
            if(o1.thunhap()>o2.thunhap()){
                return 1;
            }else if(o1.thunhap()==o2.thunhap()){
                return 0;
            }else{
                return -1;
            }
        }
    };
    
  public  void sxTT(){
        String chon8;
        do{
        Collections.sort(ds,sst);
        System.out.println("Danh sách nhân viên");
        for(NhanVienHanhChinh nv:ds){
            nv.xuat();
        }
        
            System.out.println("Bạn có muốn tiếp tục sắp xếp theo thu nhập không?(y/n)");
            chon8=sc.nextLine();
            chon8=sc.nextLine();            
            if(chon8.equalsIgnoreCase("n")){
                break;
            }
            
        
        }while(chon8.equalsIgnoreCase("y"));
    }
       
   public void top5(){
        String chon9;
        do{
            Collections.sort(ds,sst);
            Collections.reverse(ds);
            int flag=0;
            for(NhanVienHanhChinh nv:ds){
                nv.xuat();
                flag++;
                if(flag==5){
                    break;
                }
            }
                   
            System.out.println("Bạn có muốn tiếp tục xuất top 5 nhân viên có thu nhập cao nhất  không?(y/n)");
            chon9=sc.nextLine();
            chon9=sc.nextLine();            
            if(chon9.equalsIgnoreCase("n")){
                break;
            }
            
        }while(chon9.equalsIgnoreCase("y"));
    }
   public void menu(){
        int chon;
        do{
        System.out.println("MENU ASSIGNMENT JAVA1");
        System.out.println("|===========================================================|");
        System.out.println("| 1. Nhập danh sách nhân viên");
        System.out.println("| 2. Xuất danh sách");
        System.out.println("| 3. Tìm và hiển thị nhân viên theo mã nhập từ bàn phím");
        System.out.println("| 4. Xóa nhân viên theo mã nhập từ bàn phím");
        System.out.println("| 5. Cập nhật thông tin nhân viên theo mã nhập từ bàn phím");
        System.out.println("| 6. Tìm nhân viên theo khoảng lương nhập từ bàn phím");
        System.out.println("| 7. Sắp xếp nhân viên theo họ và tên");
        System.out.println("| 8. Sắp xếp nhân viên theo thu nhập");
        System.out.println("| 9. Xuất 5 nhân viên có thu nhập cao nhất");
        System.out.println("| 10. Thoát!");
        System.out.println("|============================================================|");
        System.out.println(" Mời chọn chức năng: ");
        chon=sc.nextInt();
        switch(chon){
            case 1:
                System.out.println("Nhập danh sách nhân viên");
                nhap();
                break;
            case 2:
                System.out.println("Xuất danh sách nhân viên");
                xuat();
                break;
            case 3:
                System.out.println("Tìm kiếm nhân viên từ mã nhân viên & hiển thị ");
                tim();
                break;
                 
            case 4:
                System.out.println("Tìm kiếm nhân viên từ mã nhân viên và xóa");
                xoa();
                break;
                
            case 5:
                System.out.println("Cập nhật thông tin nhân viên bằng mã nhân viên");
                capnhat();
                break;
                
            case 6:
                System.out.println("Tìm kiếm nhân viên theo khoảng lương nhập từ bàn phím");
                timluong();
                break;
                
            case 7:
                System.out.println("Sắp xếp nhân viên theo tên");
                sxT();
                break;
                
            case 8:
                System.out.println("Sắp xếp nhân viên theo lương");
                sxTT();
                break;
            case 9:
                System.out.println("Xuất 5 nhân viên có lương cao nhất");
                top5();
                break;
            case 10:
                System.out.println("Thoát!");
                
            
        }
        
        }while(chon!=10);
                
                
        
    }
    public static void main(String[] args) {
        Main ass=new Main();
        ass.menu();
    }
    
}
