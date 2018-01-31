public class MyMap {

    private static int[][] arrayNoWalls = {
            {3, 1},
            {3, 2},
            {3, 3},
            {3, 4},
            {3, 4},
            {3, 4},
            {3, 4},
            {3, 4},
            {3, 4},
            {3, 4},
            {3, 4},
            {3, 4},
            {3, 4},
            {3, 4},
            {3, 1},
            {3, 2},
            {3, 3},
            {3, 4},
            {3, 4},
            {3, 4},
            {3, 4},
            {3, 4},
            {3, 4},
            {3, 4},
            {3, 4},
            {3, 4},
            {3, 4},
            {3, 4},
    };

    public MyMap() {
    }

    public static String getNoWalls() {
        String debugTekst = "";
        for (int i = 0; i < 4; i++) {
            debugTekst = debugTekst + arrayNoWalls[i][0] + "," + arrayNoWalls[i][1] + "\n";

        }

        return debugTekst;
    }


    public static int[][] getArrayNoWalls() {
        return arrayNoWalls;
    }

    public static void setArrayNoWalls(int[][] arrayNoWalls) {
        MyMap.arrayNoWalls = arrayNoWalls;
    }

    public static void main(String[] args) {
        System.out.println(MyMap.getNoWalls());
    }
}





