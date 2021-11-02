package utils.study.反编译;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * @Author kula
 * @create 2021/9/17 下午1:48
 */
public class T_002 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("/Users/kula/idea_workspace/每特教育第九期/src/main/java/utils/study/idea反编译/teacher.txt"));
        System.out.println(br.readLine());
    }
}
