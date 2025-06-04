/**
 * HouseView.java  显示界面，接受用户的输入调用其他类，完成房屋信息的操作//界面层
 * HouseService.java  响应主类的调用，完成对房屋信息的各种操作crud//业务层
 * House.java类 一个house对象就表示一个房屋信息//实体类
 * 1调用2，2调用3
 */
public class House {

    private int id;
    private  String name;
    private  String phone;
    private  String address;
    private  int    rent;
    private  String state;

    public House(int id, String name, String phone, String address, int rent, String state) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.rent = rent;
        this.state = state;
    }

    @Override
    public String toString() {
        return id +
                "\t" +name +
                "\t" + phone +
                "\t" + address +
                "\t" + rent +
                "\t" + state;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getRent() {
        return rent;
    }

    public void setRent(int rent) {
        this.rent = rent;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
