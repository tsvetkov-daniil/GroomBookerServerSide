package tsvetkov.daniil;

public class Parent extends GrandParent{
    {
        System.out.println("parent dynamic");
    }
    static {
        System.out.println("parent static");
    }

    public Parent()
    {
        System.out.println("Parent constructor");
        j = 4;
    }
}
