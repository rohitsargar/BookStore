
package bookstore.helper;


public class helpers {
    
    public static String get10words(String desc){
        String fdesc="";
        
        if(desc.length()>10){
        
        String[] strs=desc.split(" ");
        
        String adddesc="";
        
        for(int i=0;i<=10;i++){
            adddesc=adddesc+" "+strs[i];
        }
        fdesc=(adddesc+" ...");
        
        
        }else
        {
           fdesc=(desc+" ...");
            
        
        }
        
    return fdesc;
    }
    
}
