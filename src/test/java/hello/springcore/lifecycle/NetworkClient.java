package hello.springcore.lifecycle;

public class NetworkClient /*implements InitializingBean, DisposableBean */{

    private String url;

    public NetworkClient() {
        System.out.println("생성자 호출 url = " + url);
        connect();
        call("초기화 연결 메세지");
    }

    public void setUrl(String url) {
        this.url = url;
    }

    // 서비스 시작시 호출
    public void connect() {
        System.out.println("connection: " + url);
    }

    public void call(String message) {
        System.out.println("call: " + url + " message = " + message);
    }

    // 서비스 종료시 호출
    public void disconnect() {
        System.out.println("close: " + url);
    }

    public void init() {
        // 의존관계 주입후
        System.out.println("NetworkClient.init");
        connect();
        call("초기화 연결 메세지");

    }

    public void close() {
        // 빈이 종료될 때
        System.out.println("NetworkClient.close");
        disconnect();
    }
}
