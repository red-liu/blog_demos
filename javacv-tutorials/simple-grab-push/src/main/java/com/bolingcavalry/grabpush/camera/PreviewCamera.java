package com.bolingcavalry.grabpush.camera;

import lombok.extern.slf4j.Slf4j;
import org.bytedeco.javacv.CanvasFrame;
import org.bytedeco.javacv.Frame;
import javax.swing.*;

@Slf4j
public class PreviewCamera extends AbstractCameraApplication {

    /**
     * 本机窗口
     */
    protected CanvasFrame previewCanvas;

    public PreviewCamera(double frameRate, int cameraImageWidth, int cameraImageHeight) {
        super(frameRate, cameraImageWidth, cameraImageHeight);
    }

    @Override
    protected void initOutput() {
        previewCanvas = new CanvasFrame("摄像头预览", CanvasFrame.getDefaultGamma() / grabber.getGamma());
        previewCanvas.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        previewCanvas.setAlwaysOnTop(true);
    }

    @Override
    protected void output(Frame frame) {
        // 预览窗口上显示当前帧
        previewCanvas.showImage(frame);
    }

    @Override
    protected void releaseOutputResource() throws Exception {
        if (null!= previewCanvas) {
            previewCanvas.dispose();
        }
    }

    public static void main(String[] args) {
        new PreviewCamera(30.0, 1280,720).action(1000);
    }
}