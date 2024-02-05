public abstract class Robot extends Player {
    private final double maxHeighJump;
    private final double maxDistance;
    private int status;
    static int counter;

    public Robot(String name, double maxHeighJump, double maxDistance) {
        super(name, maxHeighJump, maxDistance);
        this.maxHeighJump = maxHeighJump;
        this.maxDistance = maxDistance;
        counter++;
    }

    @Override
    void run() {
        System.out.println(super.name + " принял участие в гонке!");
        status = 1;
    }

    @Override
    void runThrough(double distance) {
        if (status != 0) {
            if (distance <= maxDistance) {
                System.out.println(super.name + " преодолел препятствие в " + distance + " метров!");

            } else {
                System.out.println(super.name + " выбывает из гонки!");
                status = 0;
            }
        }
    }
}

