import java.util.*;
public class ClassStudents{
  @SuppressWarnings("unchecked")
  public static void main(String args[]){
      HashMap map=new HashMap<String,StringBuilder>();
      Scanner input=new Scanner(System.in);
      int num1=input.nextInt();
      String aban=input.nextLine();
      String[][] a=new String[num1][4];
      for(int i=0;i<num1;i++){
        a[i] =input.nextLine().split(",");
        if(map.get(a[i][0])==null){
        StringBuilder b=new StringBuilder(a[i][0]+":"+a[i][1]+","+a[i][2]+","+a[i][3]);
        map.put((String)(a[i][0]),b);}
        else{map.put((String)(a[i][0]),((StringBuilder) map.get(a[i][0])).append("\n"+a[i][0]+":"+a[i][1]+","+a[i][2]+","+a[i][3]));}
      }
      int num2=input.nextInt();
      aban=input.nextLine();
      for(int i=0;i<num2;i++){
      String k=input.nextLine();
        if(map.get(k)!=null){
        System.out.println(map.get(k));
      }
      else{System.out.println(k+": None");}
    }
    }
  }
    


