package com.facultate.laborator2.activity;


import com.facultate.laborator2.models.CaptchaDetails;
import com.facultate.laborator2.models.CircleDetails;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Base64;
import java.util.Random;

public class CaptchaGenerator {

    private static final int WIDTH = 250;
    private static final int HEIGHT = 250;
    private static final int MAX_CIRCLES_COUNT = 9;
    private static int circlesCount;

    private static Color getRandomColor() {
        Random rand = new Random();
        float r = rand.nextFloat();
        float g = rand.nextFloat();
        float b = rand.nextFloat();
        return new Color(r, g, b);
    }

    private static CircleDetails generateRandomCircleDetails() {
        Random rand = new Random();
        int x = rand.nextInt(WIDTH);
        int y = rand.nextInt(HEIGHT);
        int radius = rand.nextInt(20, 30);
        return new CircleDetails(x, y, radius);
    }

    public static CaptchaDetails getCaptcha() throws IOException {
        Random random = new Random();

        circlesCount = random.nextInt(1, MAX_CIRCLES_COUNT);

        // Constructs a BufferedImage of one of the predefined image types.
        BufferedImage bufferedImage = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);

        // Create a graphics which can be used to draw into the buffered image
        Graphics2D g2d = bufferedImage.createGraphics();

        g2d.setColor(Color.black);
        g2d.fillRect(0, 0, WIDTH, HEIGHT);
        g2d.setColor(Color.white);
        g2d.fillRect(5, 5, WIDTH-10, HEIGHT-10);
        for (int i = 0; i < circlesCount; i++) {
            CircleDetails circleDetails = generateRandomCircleDetails();
            g2d.setColor(getRandomColor());
            g2d.fillOval(circleDetails.getCenterX(), circleDetails.getCenterY(), circleDetails.getRadius(), circleDetails.getRadius());
        }

        // Disposes of this graphics context and releases any system resources that it is using.
        g2d.dispose();
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        ImageIO.write(bufferedImage, "png", output);
        return new CaptchaDetails(Base64.getEncoder().encodeToString(output.toByteArray()), circlesCount);
    }

}