package tsvetkov.daniil;

public class Child extends Parent{
    {
        System.out.println("child dynamic");
    }
    static {
        System.out.println("child static");
    }

    public Child()
    {
        System.out.println("child constructor");
    }
}
