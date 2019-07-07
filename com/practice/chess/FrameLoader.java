package com.practice.chess;


import com.practice.entity.BackgroundEntity;
import com.practice.entity.CommonEntity;
import com.practice.constant.ChessFramePosition;
import com.practice.entity.SelectedChess;
import com.practice.location.PieceRouting;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.util.List;


/**
 * @author 杨鹏
 */
public class FrameLoader {

    protected JFrame frame;

    protected JPanel panel;

    protected CommonEntity selectedChessEntity = new SelectedChess();

    protected JLabel selectedIcon = new SelectedChess();

    protected PieceRouting pieceRouting = new PieceRouting();

    /**
     * 初始化布局
     */
    public FrameLoader(){
        frame=new JFrame();
        frame.setTitle("中国象棋");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(ChessFramePosition.COORDINATE_X,
                ChessFramePosition.COORDINATE_Y,
                ChessFramePosition.WEIGHT,
                ChessFramePosition.HEIGHT);
        panel=new JPanel();
        //设置为空布局
        panel.setLayout(null);
    }

    /**
     * 加载棋子之前调用
     */
    public void addBackground() {
        BackgroundEntity backgroundEntity = new BackgroundEntity();
        panel.add(backgroundEntity);
        panel.setBounds(backgroundEntity.getX(),
                backgroundEntity.getY(),
                backgroundEntity.getWidth(),
                backgroundEntity.getHeight());
    }

    public void start(){
        frame.add(panel);
        frame.setVisible(true);
    }

}
