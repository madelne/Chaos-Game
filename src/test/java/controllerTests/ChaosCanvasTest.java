package controllerTests;

import controller.ChaosCanvas;
import controller.ChaosGame;
import model.Vector2D;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Vector;

import static org.junit.jupiter.api.Assertions.*;

class ChaosCanvasTest {
    private final Vector2D minCoords = new Vector2D(0, 0);
    private final Vector2D maxCoords = new Vector2D(99, 99);
    private final ChaosCanvas chaosCanvas = new ChaosCanvas(100, 100, minCoords, maxCoords);


    @Test
    void getPixel() {
    }

    @Test
    void putPixel() {
        Assertions.assertEquals(0,chaosCanvas.getPixel(new Vector2D(50,49)));
        Assertions.assertEquals(0,chaosCanvas.getPixel(new Vector2D(49,50)));
        Assertions.assertEquals(1, chaosCanvas.getPixel(new Vector2D(50, 50)));
    }

    @Test
    void getCanvasArray() {

        for (int i = 0; i < chaosCanvas.getCanvasArray().length; i++) {
            Assertions.assertEquals(100, chaosCanvas.getCanvasArray()[i].length);
        }
        Assertions.assertEquals(100, chaosCanvas.getCanvasArray().length);
    }

    @Test
    void clearCanvas() {
        chaosCanvas.putPixel(new Vector2D(50, 50));
        chaosCanvas.putPixel(new Vector2D(0, 0));
        chaosCanvas.putPixel(new Vector2D(99, 99));
        chaosCanvas.clearCanvas();
        for (int i = 0; i < chaosCanvas.getCanvasArray().length; i++) {
            for (int j = 0; j < chaosCanvas.getCanvasArray()[i].length; j++) {
                Assertions.assertEquals(0, chaosCanvas.getCanvasArray()[i][j]);
            }
        }
    }

    @Test
    void getMinCoords() {
        Assertions.assertEquals(0, chaosCanvas.getMinCoords().getX0());
        Assertions.assertEquals(0, chaosCanvas.getMinCoords().getX1());

    }

    @Test
    void getMaxCoords() {
        Assertions.assertEquals(99, chaosCanvas.getMaxCoords().getX0());
        Assertions.assertEquals(99, chaosCanvas.getMaxCoords().getX1());
    }
}