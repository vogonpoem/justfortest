package fileoperation;

import java.io.*;
import java.util.*;

public class Txt2String 
{
	public static void main(String[] args) {
        /*String path1 = "D:\\1公干\\1剧本评估\\剧本素材\\阿凡达.txt";//测试
        String path2 = "D:\\1公干\\1剧本评估\\剧本素材\\0.txt";
		System.out.println(path1);
        try {
			WriteStringToFile(path2,ReadStringFromTxt(path1));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
    }
	public static String ReadStringFromTxt(String path) throws UnsupportedEncodingException{
		File file = new File(path);
        StringBuilder result = new StringBuilder();
        try{
            BufferedReader br = new BufferedReader(new FileReader(file));//构造一个BufferedReader类来读取文件
            String s = null;
            result.append(path);
            while((s = br.readLine())!=null){//使用readLine方法，一次读一行
                result.append(System.lineSeparator()+s);
            }
            br.close();    
        }catch(Exception e){
            e.printStackTrace();
        }
        //String fin=result.toString();
        String fin = new String(result.toString().getBytes("UTF-8"),"UTF-8");
        return fin;
    }
	 public static void WriteStringToFile(String filePath,String content) {
	        try {
	            File file = new File(filePath);
	            PrintStream ps = new PrintStream( new FileOutputStream( file ) );
	            ps.append(content);// 添加字符串
	            ps.close();
	        } 
	        catch (FileNotFoundException e) {	            
	            e.printStackTrace();
	        }
	    }
	}
