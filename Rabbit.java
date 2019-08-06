public class Rabbit extends Animal {


    public Rabbit(Model model, int row, int column) {
        super(model, row, column);
    }

    int decideMove() {
        for (int direction = Model.MIN_DIRECTION; direction <= Model.MAX_DIRECTION ; direction++) {

            if (this.look(direction) == Model.FOX) {
                if (this.canMove(Model.turn(direction, 3))
                        && this.distance((direction + 3) % 8) > 3) {
                    // move to open space, opposite direction towards wall and bushes
                    // ask row and column

                    return Model.turn(direction, 3);
                } else if (this.canMove(Model.turn(direction, 5)) && this.distance((direction + 5) % 8) > 3) {
                    return Model.turn(direction, 5);
                } else if (this.canMove(Model.turn(direction, 2)) && this.distance((direction + 2) % 8) > 3) {
                    return Model.turn(direction, 2);
                } else if (this.canMove(Model.turn(direction, 6)) && this.distance((direction + 6) % 8) > 3) {
                    return Model.turn(direction, 6);
                } else if (this.canMove(Model.turn(direction, 1)) && this.distance((direction + 1) % 8) > 3) {
                    return Model.turn(direction, 1);
                } else if (this.canMove(Model.turn(direction, 7)) && this.distance((direction + 7) % 8) > 3) {
                    return Model.turn(direction, 7);
                } else if (this.canMove(Model.turn(direction, 4)) && this.distance((direction + 4) % 8) > 3) {
                    return Model.turn(direction, 4);
                }
            }


        }
        return Model.STAY;
    }}

