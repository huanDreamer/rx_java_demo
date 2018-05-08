package top.sillyfan.rx.demo5;

public class User {

    private String mame;

    private Integer age;

    public User(String mame, Integer age) {
        this.mame = mame;
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "mame='" + mame + '\'' +
                ", age=" + age +
                '}';
    }

    public String getMame() {
        return mame;
    }

    public void setMame(String mame) {
        this.mame = mame;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
