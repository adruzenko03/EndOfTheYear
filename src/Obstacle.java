public class Obstacle {
    int x;
    int y = 0;
    int height;
    int width;
    public static int created = 0;

    public Obstacle(int x, int y, int height, int width) {
        this.x = x;
        this.y = y;
        this.height = height;
        this.width = width;

        ObstacleMade();
    }


    public static void ObstacleMade() {
        created++;
    }

    public void destroy() {
        System.out.println();
    }

}
