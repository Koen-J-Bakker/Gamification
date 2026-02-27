package client.scenes;
import com.google.inject.Inject;

public class RedCtrl {
    private PrimaryCtrl pc;

    @Inject
    public RedCtrl(PrimaryCtrl p) {
        this.pc = p;
    }

    public void click() {
        System.out.println("You clicked in the red scene!");
        pc.showBlue();
    }
}
