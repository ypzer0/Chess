package com.practice;

import com.practice.chess.FrameLoader;

import javax.swing.JFrame;

/**
 * @author 杨鹏
 */
public class GameStart {

    public static void main(String[] args) {
        FrameLoader frameLoader = new FrameLoader();
        frameLoader.testRedChe();
        frameLoader.addBackground();
        frameLoader.start();
    }
}
