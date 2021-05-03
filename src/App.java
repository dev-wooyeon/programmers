import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class App {

    /// Fields

    /// Constructor 

    /// Method
    /**
     * 
     * @param packageName d
     * @param className
     */
    public static void classLoader(String packageName, String getClassName) throws Exception{

        // String packageName = "level1";
        String packageNameSlashed = "./" + packageName.replace(".", "/");
        System.out.println(packageNameSlashed);
        URL packageDirURL = Thread.currentThread().getContextClassLoader().getResource(packageNameSlashed);

        String directoryString = packageDirURL.getFile();

        List<Class<?>> classList = new ArrayList<Class<?>>();
        File directory = new File(directoryString);
        if(directory.exists()){
            String[] files = directory.list();
            for(String fileName : files){
                fileName = fileName.substring(0, fileName.length() - 6); // 확장자 삭제
                Class<?> c = Class.forName(packageName + "." + fileName); // Dynamic Loading
                classList.add(c); // List<Class> list 에 넣는다
            }
        }

        String target = packageName + "." + getClassName;
        for(Class<?> className : classList){
            if(target.equals(className.getName())){
                className.getDeclaredConstructor().newInstance();
            }
        }

    }
    public static void main(String[] args) throws Exception {
        
        // package, class명을 전달하여 클래스 생성하는 메소드 호출
        classLoader("level1","Ponketmon");

    }
}
