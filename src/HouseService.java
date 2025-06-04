/**
 * HouseView.java  显示界面，接受用户的输入调用其他类，完成房屋信息的操作//界面层
 * HouseService.java  响应主类的调用，完成对房屋信息的各种操作crud//业务层
 * House.java类 一个house对象就表示一个房屋信息//实体类
 * 1调用2，2调用3
 */
public class HouseService {

    private House[] houses;
    private int houseNums=1;
    private  int idCount=1;

    public HouseService(int size){
        houses=new House[size];
        houses[0]=new House(1,"jing","121","sd",2000,"没有");
    }

    //find
    public House findId(int findId){
        for (int i = 0; i < houseNums; i++) {
            if (findId==houses[i].getId()){
                return houses[i];
            }
        }return null;
    }
  //删除房屋信息
    public boolean del(int delId){
        int index=-1;
        for (int i = 0; i < houseNums; i++) {
            if (delId==houses[i].getId()){
                index=i;
            }
        }
        if (index==-1){
            return false;
        }
        for (int i = index; i <houseNums-1 ; i++) {
            houses[i]=houses[i+1];
        }
        houses[houseNums-1]=null;
        houseNums--;
        return true;
    }
//添加房屋信息
    public boolean add(House newHouse){
        if (houseNums>=houses.length){
            System.out.println("数组已满，不能添加");
            return false;
        }
        houses[houseNums]=newHouse;
        houseNums++;
        idCount++;
        newHouse.setId(idCount);
        return true;
    }
    public House[] list(){
        return houses;
    }
}
