package client.scenes;

import com.google.inject.Inject;

public class BlueCtrl {
    private PrimaryCtrl pc;

    @Inject
    public BlueCtrl(PrimaryCtrl p) {
        this.pc = p;
    }

    public void click() {
        System.out.println("You clicked in the blue scene!");
        pc.showRed();
    }
}
