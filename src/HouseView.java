/**
 * HouseView.java  显示界面，接受用户的输入调用其他类，完成房屋信息的操作//界面层
 * HouseService.java  响应主类的调用，完成对房屋信息的各种操作crud//业务层
 * House.java类 一个house对象就表示一个房屋信息//实体类
 * 1调用2，2调用3
 */
public class HouseView {
    private boolean loop=true;
    private char key=' ';
    private HouseService houseService=new HouseService(10);//数组的大小为十

    public void updateHouse() {
        System.out.println("=========修改房屋信息=========");
        System.out.println("=========选择修改房屋编号=========");
        int updateId = Utility.readInt();
        if (updateId == -1) {
            System.out.println("=========你放弃了修改房屋信息=========");
            return;
        }

        House house = houseService.findId(updateId);
        if (house == null) {
            System.out.println("=========修改房屋信息不存在=========");
            return;
        }
        System.out.println("姓名(" + house.getName() + "):");
        String name = Utility.readString(8, "");
        if (!"".equals(name)) {
            house.setName(name);
        }
        System.out.println("电话(" + house.getPhone() + "):");
        String phone = Utility.readString(12, "");
        if (!"".equals(phone)) {
            house.setPhone(phone);
        }
        System.out.println("地址(" + house.getAddress() + "):");
        String address = Utility.readString(18, "");
        if (!"".equals(address)) {
            house.setAddress(address);
        }
        System.out.println("租金(" + house.getRent() + "):");
        int rend = Utility.readInt(-1);
        if (rend != -1) {
            house.setRent(rend);
        }
        System.out.println("状态(" + house.getState() + "):");
        String state = Utility.readString(3, "");
        if (!"".equals(state)) {
            house.setState(state);
        }
        System.out.println("======修改房屋信息成功==========");
    }


    //查找房屋信息

    public void findHouse(){
        System.out.println("=========查找房屋信息=========");
        System.out.println("=========请输入查找房屋的id=========");
        int findId = Utility.readInt();
        House id = houseService.findId(findId);
        if (id!=null){
            System.out.println(id);
        }else {
            System.out.println("=========房屋不存在=========");
        }
    }


    //退出
    public void exit(){
        char c = Utility.readConfirmSelection();
        if (c=='Y'){
            loop=false;
        }

    }
 //删除
    public  void delHouse(){
        System.out.println("=========删除房屋=========");
        System.out.println("====选择删除房屋的编号======");
        int delId=Utility.readInt();
        if (delId==-1){
            System.out.println("======放弃删除房屋===========");
            return;
        }
         char choice=Utility.readConfirmSelection();
        if (choice=='Y'){
            if (houseService.del(delId)){
                System.out.println("======删除房屋成功===========");
            }
            else {
                System.out.println("======房屋编号不存在===========");
            }
        }
    }
    //添加
    public void addHouse(){
        System.out.println("======添加房屋===========");
        System.out.println("姓名");
        String name=Utility.readString(8);
        System.out.println("电话");
        String phone=Utility.readString(12);
        System.out.println("地址");
        String address=Utility.readString(16);
        System.out.println("月租");
        int rent=Utility.readInt();
        System.out.println("状态");
        String state=Utility.readString(3);
        House newHouse = new House(0, name, phone, address, rent, state);
        if (houseService.add(newHouse)){
            System.out.println("添加房屋成功");
        }else {
            System.out.println("添加房屋失败");
        }
    }
    public void listHouse(){
        System.out.println("======房屋列表===========");
        System.out.println("编号\t\tt房主\t\t电话\t\t地址\t\t月租\t\t状态(未出租/以出租)");
        House[] houses = houseService.list();
        for (int i = 0; i < houses.length; i++) {
            if (houses[i]==null){
                break;
            }
            System.out.println(houses[i]);
        }
        System.out.println("======房屋列表显示完毕===========");
    }
    public void mainMenu(){
        do{
            System.out.println("=======房屋出租系统===========");
            System.out.println("\t\t\t1新增房源\t\t");
            System.out.println("\t\t\t2查找房源");
            System.out.println("\t\t\t3删除房源");
            System.out.println("\t\t\t4修改房源");
            System.out.println("\t\t\t5房源信息");
            System.out.println("\t\t\t6 退 出 ");
            System.out.println("\t\t请输入你的选择\t\t");
            key=Utility.readChar();
            switch (key){
                case '1':
                    addHouse();
                    break;
                case '2':
                   findHouse();
                    break;
                case '3':
                    delHouse();
                    break;
                case '4':
                   updateHouse();
                    break;
                case '5':
                    listHouse();
                    break;
                case '6':
                    exit();
                    break;
            }
        }while (loop);
    }
}
