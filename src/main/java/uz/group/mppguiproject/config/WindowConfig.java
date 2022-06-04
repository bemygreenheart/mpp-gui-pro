package uz.group.mppguiproject.config;

import java.awt.*;

final public class WindowConfig {
    private WindowConfig(){
        throw new AssertionError("This class should not be initialized");
    }

    public static final int WIDTH = 1000;
    public static final int HEIGHT = 600;

    public static final int SGAP = 5;
    public static final int MGAP = 30;
    public static final int LGAP = 50;

    public static final int HEADER = 30;

    public static void centerFrameOnDesktop(Component f) {
        final int SHIFT_AMOUNT = 0;
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        int height = toolkit.getScreenSize().height;
        int width = toolkit.getScreenSize().width;
        int frameHeight = f.getSize().height;
        int frameWidth = f.getSize().width;
        f.setLocation(((width - frameWidth) / 2) - SHIFT_AMOUNT, (height - frameHeight) / 3);
    }
}
