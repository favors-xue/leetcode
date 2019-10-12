public class MainClass {
    public static void main(String... args) {
        MovingAverage m = new MovingAverage(5);
        System.out.println(m.next(12009));
        System.out.println(m.next(1965));
        System.out.println(m.next(-940));
        System.out.println(m.next(-8516));
        System.out.println(m.next(-16446));
        System.out.println(m.next(7870));
        System.out.println(m.next(25545));
        System.out.println(m.next(-21028));
        System.out.println(m.next(18430));
        System.out.println(m.next(-23464));

    }
}
