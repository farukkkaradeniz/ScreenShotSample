/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package screenshotsample;

import java.net.URL;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.awt.*;
import java.io.*;
import java.util.concurrent.TimeUnit;
import javax.mail.*;

/**
 *
 * @author Faruk-pc
 */
public class ScreenShotSample {

    public static void main(String[] args) throws AWTException, IOException, InterruptedException {
        openWebpage();
        TimeUnit.SECONDS.sleep(5);
        Robot robot = new Robot();
        BufferedImage bi = robot.createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
        ImageIO.write(bi, "jpg", new File("C:\\Users\\Faruk-pc\\Desktop\\imageTest.jpg"));
    }

    public static void openWebpage() {
        Desktop desktop = Desktop.isDesktopSupported() ? Desktop.getDesktop() : null;
        if (desktop != null && desktop.isSupported(Desktop.Action.BROWSE)) {
            try {
                desktop.browse(new URL("http://www.google.com.tr").toURI());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
