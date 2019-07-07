package com.practice.chess;

import com.practice.entity.RedCheOne;

import javax.swing.JPanel;

/**
 * 加载棋子对象
 * @author 杨鹏
 */
public class ChessLoader {
    public ChessLoader(JPanel panel){
        panel.add(new RedCheOne());
    }
}
