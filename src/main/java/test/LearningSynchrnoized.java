package test;

import org.openjdk.jol.info.ClassLayout;

/**
 * @Author: Zebiao
 * @Created Time: 2020-04-19 12:12
 * @Description :
 */
public class LearningSynchrnoized {
    public static void main(String[] args) {
        Object o = new Object();
//        User user = new User(1,"a",new User.UserInfo());
//        System.out.println(ClassLayout.parseInstance(user).toPrintable());
        System.out.println(ClassLayout.parseInstance(o).toPrintable());

        synchronized (o) {
            System.out.println(ClassLayout.parseInstance(o).toPrintable());
        }
    }

    /**
     * @param str1
     * @param str2
     */
    public void add(String str1, String str2) {
        StringBuffer sb = new StringBuffer();
        sb.append(str1).append(str2);
    }

    /**
     * 锁粗化
     *
     * @param str
     * @return
     */
    public String test(String str) {
        int i = 0;
        StringBuffer sb = new StringBuffer();
        while (i < 100) {
            sb.append(str);
            i++;
        }
        return sb.toString();
    }

    static class User {
        public User(int i) {
            this.i = i;
        }

        int i;
        String t;
        UserInfo userInfo;

        public User(int i, String t) {
            this.i = i;
            this.t = t;
        }

        public User(int i, String t, UserInfo userInfo) {
            this.i = i;
            this.t = t;
            this.userInfo = userInfo;
        }

        public int getI() {
            return i;
        }

        public void setI(int i) {
            this.i = i;
        }

        static class UserInfo {
            String name;
        }
    }



}
