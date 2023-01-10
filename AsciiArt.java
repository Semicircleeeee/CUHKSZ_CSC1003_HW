import java.util.*;
public class AsciiArt
{public static void main(String args[])
{
  Scanner input= new Scanner(System.in);
  int num=input.nextInt();//读取单词个数
  String[] allwords1= new String[7*num];//读取每一行的内容
  String[][] allwords2= new String[num][10];//对每个单词的每个字母分配位置
  int wLength[][]= new int[num][10];//判断每个单词的每个字母有多长以直接读出i
  int cnt1=0;//一号计数器计数每个字母长度以及#个数
  int cnt2=0;//二号计数器计数每个单词字母数以及序数
  int[] cnt3= new int[num];//三号计数器计数每个单词char长度
  int[][] cnt4=new int[num][];//记录每个单词的每个字母#数量
  int[][] cnt5=new int[num][];
  int[][] index=new int[num][10];//记录每个字母的位置
  String abandon=input.nextLine();//去除数字行
  for(int i=0;i<num;i++)
  {abandon=input.nextLine();//抛去空行
    for(int a=0;a<7;a++)
    {
    allwords1[i*7+a]=input.nextLine();//读取每一行的内容
    }
  }
  for(int a = 0;a<num;a++)
  {
    cnt3[a]=allwords1[a*7].toCharArray().length;//寻找每个单词需要遍历的列数
    cnt5[a]=new int[allwords1[a*7].toCharArray().length];
  }
  for(int c=0;c<num;c++)
  {cnt2=0;
    for(int b=0;b<cnt3[c];b++)
    {
      boolean light = true;//指示一整列是否都为空
      for(int a=0;a<7;a++)
      {
        if(allwords1[a+7*c].charAt(b)=='#'){light=false;}//对列遍历
      }
        if(light==true){cnt2++;}//若一列都为空则代表该字母结束
    }
      cnt4[c]=new int[cnt2+1];//初始化数组
  }
  for(int c=0;c<num;c++)
  {cnt1=0;cnt2=0;
    for(int b=0;b<cnt3[c];b++)
    {
      boolean light = true;//指示一整列是否都为空
      for(int a=0;a<7;a++)
      {
        if(allwords1[a+7*c].charAt(b)=='#'){light=false;}//对列遍历
      }
       if(b!=cnt3[c]-1) 
       {
        if(light==true){wLength[c][cnt2]=cnt1;index[c][cnt2]=b;cnt2++;cnt1=0;}//若一列都为空则代表该字母结束
        if(light==false){cnt1++;}//若不为空则该字母长度加一
       }
       else{wLength[c][cnt2]=cnt1;index[c][cnt2]=b;cnt4[c]=new int[cnt2+1];}
    }
  }
  for(int c=0;c<num;c++)
  {cnt1=0;cnt2=0;
    for(int b=0;b<cnt3[c];b++)
    {
      int cnt=0;
      boolean light = true;//指示一整列是否都为空
      for(int a=0;a<7;a++)
      {
        if(allwords1[a+7*c].charAt(b)=='#'){cnt1++;cnt++;light=false;}//对列遍历
      }
      cnt5[c][b]=cnt;
      if(b!=cnt3[c]-1)//若不在最后一列
       {
        if(light==true){cnt4[c][cnt2]=cnt1;cnt2++;cnt1=0;}//若一列都为空则代表该字母结束，记录#数量并进入下一个字母
       }
       else{cnt4[c][cnt2]=cnt1;;}//对最后一列直接计入最后一个字母#个数
    }
  }
  for(int a=0;a<num;a++){
    for(int b=0;b<cnt4[a].length;b++){
      switch(cnt4[a][b]){
        case 24 :allwords2[a][b]="F";break;
        case 33 :allwords2[a][b]="H";break;
        case 18 :allwords2[a][b]="I";break;
        case 22 :allwords2[a][b]="J";break;
        case 29 :allwords2[a][b]="K";break;
        case 37 :allwords2[a][b]="M";break;
        case 34 :allwords2[a][b]="O";break;
        case 31 :allwords2[a][b]="U";break;
        case 32 :if(cnt5[a][index[a][b]-1]==4){allwords2[a][b]="A";}
                 else{allwords2[a][b]="G";}
                 break;
        case 40 :if(wLength[a][b]==9){allwords2[a][b]="B";}
                 else {allwords2[a][b]="W";}
                 break;
        case 26 :if(cnt5[a][index[a][b]-2]==3){allwords2[a][b]="Z";}
                 else {allwords2[a][b]="C";}
                 break;
        case 36 :if(wLength[a][b]==8){allwords2[a][b]="N";}
                 if(wLength[a][b]==9)
                 {
                   if(cnt5[a][index[a][b]-1]==3){allwords2[a][b]="R";}
                   else if(cnt5[a][index[a][b]-4]==3){allwords2[a][b]="Q";}
                   else if(cnt5[a][index[a][b]-4]==2){allwords2[a][b]="D";}
                 }
                 break;
        case 30 :if(wLength[a][b]==9){allwords2[a][b]="P";}
                 else if(cnt5[a][index[a][b]-1]==2){allwords2[a][b]="E";}
                 else if(cnt5[a][index[a][b]-1]==3){allwords2[a][b]="S";}
                 break;
        case 20 :if(cnt5[a][index[a][b]-4]==7){allwords2[a][b]="T";}
                 if(cnt5[a][index[a][b]-4]==1){allwords2[a][b]="L";}
                 if(cnt5[a][index[a][b]-4]==5){allwords2[a][b]="Y";}
                 break;
        case 27 :if(cnt5[a][index[a][b]-1]==2){allwords2[a][b]="X";}
                 else{allwords2[a][b]="V";}
                 break;
      }
    }
  }
  for(int a=0;a<num;a++){
    for(int b=0;b<cnt4[a].length;b++){
      if(b!=cnt4[a].length-1){System.out.print(allwords2[a][b]);}
      else {System.out.println(allwords2[a][b]);}
      }
    }
}
}