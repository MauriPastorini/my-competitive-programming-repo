package leetcodeproblems;

import java.util.ArrayList;
import java.util.List;

public class KeysAndRooms {

    public void test() {
        List<List<Integer>> rooms = new ArrayList<>();
        List<Integer> room1 = new ArrayList<>();
        room1.add(1);
        room1.add(3);
        List<Integer> room2 = new ArrayList<>();
        room2.add(3);
        room2.add(0);
        room2.add(1);
        List<Integer> room3 = new ArrayList<>();
        room3.add(2);
        List<Integer> room4 = new ArrayList<>();
        room4.add(0);
        rooms.add(room1);
        rooms.add(room2);
        rooms.add(room3);
        rooms.add(room4);
        System.out.println(canVisitAllRooms(rooms));
    }

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        if (rooms == null || rooms.size() == 0) {
            return true;
        }
        boolean[] roomsVisited = new boolean[rooms.size()];
        roomsVisited[0] = true;
        visitRoom(0, rooms, roomsVisited);
        for (boolean b : roomsVisited) {
            if (!b) {
                return false;
            }
        }
        return true;
    }

    private void visitRoom(int i, List<List<Integer>> rooms, boolean[] roomsVisited) {
        if (i != 0 && roomsVisited[i]) {
            return;
        }
        roomsVisited[i] = true;
        for (Integer integer : rooms.get(i)) {
            visitRoom(integer, rooms, roomsVisited);
        }
    }
}
