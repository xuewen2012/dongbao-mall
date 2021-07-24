package com.xuewen.dongbao.portal.web.code;

import com.sun.xml.internal.messaging.saaj.util.ByteOutputStream;
import lombok.Data;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageOutputStream;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Random;

@Data
public class ImageCode {

    private String code = "";
    private ByteArrayInputStream image;
    private int width = 400;
    private int height = 100;

    public static ImageCode getInstance() throws Exception {
        return new ImageCode();
    }

    private ImageCode() {
        BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_BGR);
        Graphics graphics = bufferedImage.getGraphics();

        graphics.setColor(new Color(17, 147, 37));
        graphics.fillRect(0, 0, width, height);

        graphics.setFont(new Font("宋体", Font.PLAIN, 30));
        Random random = new Random();
        for (int i = 0; i < 6; i++) {
            String s = String.valueOf(random.nextInt(10));
            code += s;

            graphics.setColor(new Color(135, 152, 37));
            graphics.drawString(s, (width/6)*i, 40);
        }

        //收笔
        graphics.dispose();

        ByteArrayInputStream inputStream = null;
        ByteOutputStream outputStream = new ByteOutputStream();

        //赋值给bygArrayInputStream
        try {
            ImageOutputStream imageOutputStream = ImageIO.createImageOutputStream(outputStream);
            ImageIO.write(bufferedImage, "jpeg", imageOutputStream);

            inputStream = new ByteArrayInputStream(outputStream.toByteArray());

        } catch (Exception e) {
            e.printStackTrace();
        }
        this.image = inputStream;
    }

}
