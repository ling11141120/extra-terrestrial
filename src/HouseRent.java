/**
 * HouseView.java  显示界面，接受用户的输入调用其他类，完成房屋信息的操作//界面层
 * HouseService.java  响应主类的调用，完成对房屋信息的各种操作crud//业务层
 * House.java类 一个house对象就表示一个房屋信息//实体类
 * 1调用2，2调用3
 */
public class HouseRent {

    //程序入口
    public static void main(String[] args) {

       new HouseView().mainMenu();
        System.out.println("==你退出了房屋出租系统==");
    }
}
