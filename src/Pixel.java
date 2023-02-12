import codedraw.CodeDraw;

import java.awt.*;

public class Pixel {
    private Color color;
    private CodeDraw canvas;
    private int xIndex;
    private int yIndex;
    private int width;
    private int indent = 4;

    public Pixel(Color color, int xIndex, int yIndex, int width, CodeDraw canvas) {
        this.canvas = canvas;
        this.xIndex = xIndex;
        this.yIndex = yIndex;
        this.color = color;
        this.width = width;

        draw();
    }

    public void changeColor(Color newColor) {
        color = newColor;
        draw();
        canvas.show();
    }

    private void draw() {
        canvas.setColor(color);
        canvas.fillSquare(xIndex * width + indent/2,
                yIndex * width + indent/2,
                width - indent);
    }
}
