package tsvetkov.daniil;

public class GrandParent {
    protected Integer j = 4;


    {
        System.out.println("GrantParent Dynamic");
    }

    static {
        System.out.println("GrandParent static");
    }

    public GrandParent() {
        System.out.println("GrandParent constructor");
    }
}
