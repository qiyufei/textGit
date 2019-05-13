import javafx.scene.input.DataFormat;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main {
    public static void main(String args[]){
        //System.out.println("Hello World");
        //System.out.println("Hello NowCoder");

        //运算符demoOperation

        //字符串，操作最多的
        //demoString();

        //控制流
        //demoControlFlow

        //容器、数据结构:
        //demoList();  //ArrayList   LinkedList
        //demoHashMapTable();  //HashMap  Hashtable是线程安全的
        //demoSet();

        //异常处理，必须处理非运行时异常
        //demoException();

        //面向对象：封装、继承、多态
        //面向接口编程，相关东西包装在一起

        //随机数和时间
        demoFuntion();
    }

    public static void demoFuntion() {
        //随机数，应用：牛客网的头像
        Random random = new Random();
        print(1, random.nextInt(1000)); //0到1000以内取一个随机数，每次运行产生的数都不一样
        print(2, random.nextFloat()); //也可以随机一个float，默认是0到1之间
        //伪随机，通过一个函数生成的；如果设置种子是固定的，那么每次运行随机产生的数都是一样的;如果不指定种子，那么种子是与当前时间相关的
        random.setSeed(1);
        print(3, random.nextInt(1000));

        List<Integer> array = Arrays.asList(new Integer[]{1, 2, 3, 4, 5, 6});
        Collections.shuffle(array); //数组随机打乱
        print(4, array);

        //时间相关函数
        Date date = new Date();
        print(5, date);  //返回有格式的当前时间，星期 月  日  小时：分钟：秒 中央标准时间  年
        print(6, date.getTime());  //返回的是从1970年到现在的毫秒数，用来比较时间先后

        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); //注意！！！！是date！！！
        print(7, df.format(date));
        DateFormat df2 = new SimpleDateFormat("yyyy/MM/dd HH--mm:ss"); //可以变换格式，yyyy等都是固定的
        print(8, df2.format(date));

        print(9, UUID.randomUUID()); //随机产生字符串

        //Math是一个类，里面方法都是静态方法，import后直接就可以调用方法
        print(10, Math.log(10));    //取对数
        print(11, Math.min(2, 4));  //两个参数，取最小值
        print(12, Math.ceil(2.2));  //向上取整
        print(13, Math.floor(2.2));  //向下取整
    }

    public static void demoException() {
        try {
            int k = 3;
            //k = k/0; //除以0，触发异常

            if (k == 3) {  //例如如果这个数据不能等于3，就可以在k=3时主动抛出异常
                throw new Exception("我故意的");
            }

            //业务异常，可以自己定义异常类，然后抛往上层，抛出去，可以一直不处理，就一直抛，一层一层抛


        } catch (Exception e) {
            print(2, e.getMessage()); //注意，是e.getMessage
            //或者
            //e.printStackTrace();
        } finally {   //一般做数据清理，句柄关闭等，为了垃圾回收，释放资源。有没有发生异常都会执行finally
            print(3, "finally");
        }
    }

    public static void demoSet() {  //集合，元素不可重复
        Set<String> strSet = new HashSet<>(); //哈希实现的Set，Tree实现的Set可以sort；Tree还可以实现treeMap
        for (int i = 0; i < 3; i++) {
            strSet.add(String.valueOf(i)); //add() contains() size() remove() containsAll(另一个集合)
            strSet.add(String.valueOf(i)); //多次放还是只有一个，因为set是不重复的
        }
        print(1, strSet);

        strSet.remove(String.valueOf(1)); //remove方法,删除一个元素
        print(2, strSet);
        print(3, strSet.contains(String.valueOf(1)));  //contains判断是否包含一个元素
        print(4, strSet.isEmpty());
        print(5, strSet.size());

        strSet.addAll(Arrays.asList(new String[]{"a", "b", "C"}));//注意Arrays.asList,将数组转换为List；addAll，把参数集合添加到Set中
        print(6, strSet);

        //遍历
        for (String value : strSet) {
            print(7, value);
        }
    }

    public static void demoHashMapTable() {
        Map<String, String> map = new HashMap<>();
        for (int i = 0; i < 4; i++) {
            map.put(String.valueOf(i), String.valueOf(i * i)); //注意put方法
        }
        print(1, map); //注意Map重写的toString方法，是{ key1 = value1,key2=value2 ,...,keyn = valuen}

        //遍历
        for (Map.Entry<String, String> entry : map.entrySet()) {  //注意：Map.Entry<>和map.entrySet()
            print(2, entry.getKey() + " --> " + entry.getValue()); //方法entry.getKey() entry.getValue()
        }

        //Map的一些方法
        print(3, map.keySet());  //key的集合
        print(4, map.values());  //walues的列表，可以有重复值，不是一个集合
        print(5, map.get("3")); //得到key是“3”对应的value
        print(6, map.containsKey("A")); //判断KeySet中是否有“A”
        map.replace("3", "27");//替换的是这个key对应的value值
        print(7, map.get("3"));
        print(7, map.values());


    }

    public static void demoList() {
        List<String> strList = new ArrayList<>(10);
        for (int i = 0; i < 4; i++) {
            strList.add(String.valueOf(i * i));  //方法String.valueOf（），把里面的数据类型转换成字符串
        }
        String strTmp = strList.toString(); //注意容器ArrayList也重写toString方法,就是打印成数组的形式
        print(1, strTmp);

        List<String> strListB = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            strListB.add(String.valueOf(i));
        }

        strList.addAll(strListB);  //方法addAll（）,把参数列表的所有元素追加到strList的尾部
        print(2, strList);
        strList.remove(0);//把列表索引为0的对象删除
        print(3, strList);
        strList.remove("1");   //删除第一个“1”对象
        print(4, strList);

        print(5, strList.get(1));  //返回索引为1的对象

        Collections.reverse(strList);//颠倒列表
        Collections.sort(strList);   //排序列表
        print(6, strList);
        Collections.sort(strList, new Comparator<String>() {  //可以自己写一个针对这个容器的比较对象E的方法
            @Override                                          //比如容器内装的是Student对象，给学生排序时，先比较分数，再比较学号，等等
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);   //和正常排序是相反的
            }
        });
        print(7, strList);

        //遍历ArrayList
        for (String obj : strList) {
            print(9, obj);
        }
        for (int i = 0; i < strList.size(); i++) {
            print(10, strList.get(i));
        }
        // 数组也是一种list，基础的元素
        int[] array = new int[]{1, 2, 3};
        print(10, array[1]);
    }

    public static void demoControlFlow() {
        int a = 4;
        int target = (a == 2 ? 1 : 3); //三目运算符，
        print(1, target);
        //if(){}else if(){}else

        String grade = "B";
        switch (grade) {
            case "A":
                print(2, ">90");
                break;   //没有break的话就会一个一个的走下去，直到碰到break，走了多条分支
            case "B":
                print(3, "60-90");
                break;
            case "C":
                print(4, "<60");
                break;
            default:
                print(5, "未知");
                break;
        }

        //for(){}     循环
        //continue  本次循环结束，执行下一次循环
        //break   整个循环结束

        //while循环
    }

    public static void demoString() {
        String str = "hello world"; //不可变对象
        //看官方文档，构造函数，方法等，常用的
        print(1, str.indexOf('e')); //方法indexOf,返回这个字符的索引，不存在的话返回-1
        print(2, str.charAt(1)); //方法charAt，返回字符串索引是1的字符
        print(3, str.codePointAt(2));//返回索引为2的字符的ascii码,
        print(4, str.compareToIgnoreCase("Hello World")); //忽略大小写比较
        print(5, str.compareTo("aello world")); //str大于后面的，结果大于0，h是第八个，a是第一个，差为7
        print(6, str.compareTo("zello world")); //str小于后面的，结果小于0，所有的大写字母ascii码大于所有的小写字母

        //以下所有方法，都不改变str，（不改变这个引用所指的对象），而是返回一个新的对象的
        print(7, str.contains("hello")); //是否包含，返回true或false
        print(8, str.concat("!!!")); //在str后面追加！！！
        print(9, str.toUpperCase());  //转换成大写字母
        print(10, str.endsWith("world"));  //是否以world结尾，返回true或false
        print(11, str.startsWith("hell")); //是否以hell开头，返回true或false
        print(12, str.replace('o', 'e')); //将所有的o替换成e
        print(13, str.replaceAll("o|l", "a")); //将所有的正则表达式匹配的字符串替换成replacement
        print(14, str.replaceAll("hello", "hi"));  //参数是一个正则表达式regex

        StringBuilder sb = new StringBuilder();//线程不安全的可变字符串，单线程使用
        StringBuffer sbf = new StringBuffer();//线程安全的可变字符串
        sb.append("x ");  //字符串
        sb.append(1.2);    //浮点数
        sb.append('a');    //字符
        sb.append(true);   //boolean
        print(15, sb.toString());  //打印 x 1.2atrue，不产生新的字符串，直接在sb上改变
    }

    public static void print(int index, Object obj) {
        System.out.println(String.format("{%d}, %s", index, obj.toString()));
    }
}
