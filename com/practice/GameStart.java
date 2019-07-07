package com.practice;

import com.practice.chess.Controller;

/**
 * @author 杨鹏
 */
public class GameStart {

    public static void main(String[] args) {
        Controller controller = new Controller();
        controller.initChess();
        controller.initPanel();
        controller.addBackground();
        controller.start();
    }
}
