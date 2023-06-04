package ecs.components;

public class BoxBounds extends Component<BoxBounds> {

    public BoxBounds() {
        super("BoxBounds");
    }

    @Override
    public void update(double deltaTime) {
        System.out.println("We are inside BoxBounds");
    }
}
