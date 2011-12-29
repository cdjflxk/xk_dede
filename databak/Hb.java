package a;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;



/**
 * DOC Administrator  class global comment. Detailled comment
 * <br/>
 *
 * $Id: talend.epf 55206 2011-02-15 17:32:14Z mhirt $
 *
 */
public class Hb {

    private static Connection conn = null;
    private static Statement  stm = null;
    private static int templateId = 164;
    
    
    public static void main(String[] args) {

	
	 try {
	     
	     Class.forName("com.mysql.jdbc.Driver");
	     conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dedecm?user=admin&password=admin");
	     stm = conn.createStatement();
	     
	     BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream("E:/a.txt")));
	         String str;
	         StringBuffer total = new StringBuffer();
	             while ((str = in.readLine()) != null) {
	        	 total.append(str);
	             }
	             handleItem(total);
	             in.close();
	         } catch (IOException e) {
	             e.printStackTrace();
	         } catch (ClassNotFoundException e) {
		    e.printStackTrace();
		} catch (SQLException e) {
		    e.printStackTrace();
		}
		

		try {
		    stm.close();
		    conn.close();
		} catch (SQLException e) {
		    e.printStackTrace();
		}

    }

    /**
     * DOC Administrator Comment method "handleItem".
     * @param total
     */
    private static void handleItem(StringBuffer total) {
	String totalStr = total.toString();
	String[] templateArr = totalStr.split("模版名称:")[1].split("编号:");
	String templateName = templateArr[0];
	
	String[] codeArr = templateArr[1].split("地址:");
	String code = codeArr[0];
	
	String[] urlArr = codeArr[1].split("图片:");
	String url = urlArr[0];
	
	String image = urlArr[1];
	
	buildTemplate(templateName.split("河南"),code.split("河南"),url.split("河南"),image.split("河南"));
	
    }

    /**
     * DOC Administrator Comment method "buildTemplate".
     * @param split
     * @param split2
     * @param split3
     * @param split4
     */
    private static void buildTemplate(String[] templateName, String[] code,
	    String[] url, String[] image) {
	if(templateName.length == code.length &&  code.length == url.length && code.length == image.length ){
	    for(int i=0;i<templateName.length;i++){
		
		String sql1 = "INSERT INTO `dede_archives` (`id`,`typeid`,`channel`,`title`,`voteid`) VALUES" + 
				"('"+templateId+"', '"+14+"', '"+17+"', '"+templateName[i]+"', '1');";
		
		String sql2 = "INSERT INTO `dede_template` (`aid`,`typeid`,`zn_name`, `code`, `demo_url`, `imager`, `second_categroy`) VALUES" + 
		"('"+templateId+"', '"+14+"','"+templateName[i]+"', '"+code[i]+"', '"+url[i]+"', '"+image[i]+"','"+templateName[i]+"');";
		
		templateId++;
		try {
		    System.out.println(sql1);
		    System.out.println(sql2);
		    stm.execute(sql1);
		    stm.execute(sql2);
		} catch (SQLException e) {
		    e.printStackTrace();
		}
	    }
	}else{
	    System.out.println("error");
	}
	
	
    }
}
