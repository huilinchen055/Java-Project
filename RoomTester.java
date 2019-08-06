public class RoomTester {
    public static void main(String[] args) {
        Room p = new Room (10);
        System.out.println(p);
        p.addOneToRoom();
        System.out.println(p.getNumber());
        System.out.println(p.getTotal());
        p.removeOneFromRoom();
        System.out.println(p.getNumber());
        System.out.println(p.getTotal());
    }
}
