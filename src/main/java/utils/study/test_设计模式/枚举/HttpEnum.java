package utils.study.test_设计模式.枚举;

/**
 * @Author kula
 * @create 2021/5/9 上午11:10
 */
public enum HttpEnum {

    HTTP_200(200, "请求成功"),
    HTTP_500(500, "请求失败")


    ;

    private Integer httpCode;
    private String httpMsg;

    HttpEnum(Integer httpCode, String httpMsg){
        System.out.println("HttpEnum初始化");
        this.httpCode = httpCode;
        this.httpMsg = httpMsg;
    }

    public static void main(String[] args) {
        System.out.println(HTTP_200.httpCode);
        System.out.println(HTTP_200.httpMsg);
    }
}
