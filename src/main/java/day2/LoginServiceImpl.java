package day2;

public class LoginServiceImpl implements LoginServiceInterface{
    public String login(String name, String password) {
        return name + "登录成功!";
    }
}
