import codedraw.*;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int pixelSize = 40,
                rowCount = 10,
                colCount = 16;

        CodeDraw codeDraw = new CodeDraw(pixelSize * colCount, pixelSize * rowCount);
        EventScanner events = codeDraw.getEventScanner();
        boolean isActive = true;
        Pixel[][] pixels = new Pixel[rowCount][colCount];

        codeDraw.clear(Palette.BLACK);

        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                pixels[i][j] = new Pixel(Palette.WHITE, j, i, pixelSize, codeDraw);
            }
        }

        codeDraw.show();

        while (isActive) {
            if (events.hasMouseClickEvent()) {
                MouseClickEvent currentClick = events.nextMouseClickEvent();
                int mouseX = currentClick.getX();
                int mouseY = currentClick.getY();

                int xPosition = mouseX / pixelSize;
                int yPosition = mouseY / pixelSize;

                pixels[yPosition][xPosition].changeColor(Palette.RED);
            }
            else if(events.hasKeyPressEvent()) {
                if(events.nextKeyPressEvent().getChar() == 'q'){
                    isActive = false;
                }
            }
            else {
                events.nextEvent();
            }
        }

        codeDraw.close();

    }
}