import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class App {

    /// Fields

    /// Constructor 

    /// Method
    /**
     * 앱 실행시 최초 호출하는 클래스 로더 메소드
     * 사용자에게 입력 받은 클래스의 생성을 담당한다.
     */
    public static void classLoader() throws Exception{

        // 처리할 데이터 객체 선언
        Map<Integer,Class<?>> classMap = new HashMap<Integer,Class<?>>();

        // 패키지 주소 설정
        String packageName = "level1";
        String packageNameSlashed = "./" + packageName.replace(".", "/");
        URL packageDirURL = Thread.currentThread().getContextClassLoader().getResource(packageNameSlashed);
        
        // 주소 설정한 경로에서 파일 얻어오기 위한 경로 세팅
        String directoryString = packageDirURL.getFile();
        
        // 경로에서 읽어 파일로 처리
        File directory = new File(directoryString);
        // 클래스 매핑 처리를 위한 클래스 번호 변수
        int classNo = 1;
        // 경로가 있을 경우에 처리한다
        if(directory.exists()){
            // 디렉토리의 파일 리스트를 String[]로 받는다
            String[] files = directory.list();
            // 파일 수 만큼 처리한다.
            for(String fileName : files){
                // 확장자 삭제
                fileName = fileName.substring(0, fileName.length() - 6); 
                // 클래스 로딩
                Class<?> clas = Class.forName(packageName + "." + fileName); 
                // 실행할 파일을 보여주기 위한 클래스 번호와 파일이름                
                System.out.println( classNo + ". " + fileName );
                // 매핑 처리할 데이터맵에 데이터 넣기
                classMap.put(classNo, clas);
                classNo++;
            }
        }

        // 실행 할 파일을 입력 받는다
        System.out.print("실행 할 파일을 선택 하세요 : ");
        Scanner scan = new Scanner(System.in);

        // 입력 받은 클래스의 Default Constructor를 생성한다.
        classMap.get(scan.nextInt()).getDeclaredConstructor().newInstance();

    }
    public static void main(String[] args) throws Exception {
        
        classLoader();
    }
}
