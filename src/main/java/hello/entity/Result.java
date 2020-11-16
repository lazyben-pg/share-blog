package hello.entity;

public class Result {
    private final String status;
    private final String msg;
    private final User data;
    private final boolean login;

    private Result(String status, String msg, User data, Boolean login) {
        this.status = status;
        this.msg = msg;
        this.data = data;
        this.login = login;
    }

    public Result(String status, String msg) {
        this(status, msg, null);
    }

    public Result(String status, String msg, User data) {
        this(status, msg, data, false);
    }

    public Result(String status, Boolean login, User data) {
        this(status, null, data, login);
    }

    public Result(String status, Boolean login) {
        this(status, null, null, login);
    }

    public String getMsg() {
        return msg;
    }

    public User getData() {
        return data;
    }

    public boolean isLogin() {
        return login;
    }

    public String getStatus() {
        return status;
    }
}
