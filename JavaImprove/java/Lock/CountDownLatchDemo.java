package Lock;


import java.util.concurrent.CountDownLatch;

/**
 *  为什么要有这个类？应用于什么场景？
 *  多线程无法保证线程执行的先后顺序，某些情况下需要一些动作先执行，某些动作后执行，CountDownLatch的作用就是
 *  保证这个过程。
 */
enum CountryEnum{
    One(1,"中国"),
    Two(2,"澳大利亚"),
    Three(3,"美国"),
    Four(4,"俄罗斯"),
    Five(5,"印度");

    private Integer key;
    private String value;

    public Integer getKey() {
        return key;
    }

    public void setKey(Integer key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    CountryEnum(Integer key, String value) {
        this.key = key;
        this.value = value;
    }

    public static String getValue(int key){
        CountryEnum[] values = CountryEnum.values();
        for (CountryEnum value : values) {
            if (value.key==key){
                return value.value;
            }
        }
        return null;
    }
}
public class CountDownLatchDemo {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(5);

        for (int i = 1; i <= 5; i++) {

            new Thread(()->{
                System.out.println("进入到："+Thread.currentThread().getName());
                countDownLatch.countDown();
            },CountryEnum.getValue(i)).start();
        }
        countDownLatch.await();
        System.out.println("回家");
    }
}
