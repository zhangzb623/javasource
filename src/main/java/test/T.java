package test;

/**
 * 反汇编实验，看synchronized最底层
 */
public class T {
    static volatile int i = 0;
    public static void n() {
        i = 1;
    }
    public static synchronized void m() {
    }
    public static void main(String[] args) {
        for (int i = 0; i < 1000000; i++) {
            m();
            n();
        }
    }
}