import javassist.*;

import java.util.ArrayList;

public class OOMTest {

    // -XX:MaxMetaspaceSize=64m -Xms20m -Xmx20m -Xss128k
    static ClassPool cp = ClassPool.getDefault();
    public static void main(String[] args)  {
//        heapOOMTest();
//        stackOOMTest();
//        main(new String[]{"1"});
        metaSpaceOOM();
    }
    static void metaSpaceOOM(){
        for (int i = 0 ;; i++){
            try {
                Class c = cp.makeClass("JDBCTest" + i ).toClass();
            } catch (CannotCompileException e) {
                System.out.println(e.getCause());
            }
        }
    }

    static void heapOOMTest(){
        ArrayList<Object> list = new ArrayList<>();
        for (;;){
            byte[] b = new byte[1024*1024] ;
            list.add(b);
        }

    }

    static void stackOOMTest(){
        stackOOMTest();
    }

}
