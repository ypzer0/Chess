package com.practice.chess;


import com.practice.entity.BackgroundEntity;
import com.practice.entity.CommonEntity;
import com.practice.entity.RedCheOne;
import com.practice.constant.ChessFramePosition;
import com.practice.entity.SelectedChess;
import com.practice.location.CheRouting;
import com.practice.location.LocationUtil;
import com.practice.location.PieceRouting;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;


/**
 * @author 杨鹏
 */
public class FrameLoader {

    private JFrame frame;

    private JPanel panel;

    private JLabel selectedChessLabel;

    private JLabel selectedIcon = new SelectedChess();

    private PieceRouting pieceRouting = new PieceRouting();

    private LocationUtil locationUtil=new LocationUtil();

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

    public void  testRedChe(){
        RedCheOne redCheOne =new RedCheOne();
        setSelectedListener(redCheOne);
        selectedIcon.setVisible(false);
        panel.add(selectedIcon);
        panel.add(redCheOne);
        panel.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(selectedChessLabel!=null){
                    Integer xLocation = locationUtil.turnMouseXLocation(e.getX());
                    Integer yLocation = locationUtil.turnMouseYLocation(e.getY());
                    if (xLocation==null && yLocation==null){
                        return;
                    }
                    Integer[] location = {xLocation,yLocation};
                    if(!pieceRouting.judgeLegal(location)){
                        return;
                    }
                    selectedIcon.setVisible(false);
                    selectedChessLabel.setLocation(xLocation,yLocation);
                }
                selectedChessLabel=null;
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
    }

    /**
     * 每个棋子都有被选中的公共方法
     * @param entity
     */
    private void setSelectedListener(CommonEntity entity){
        entity.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(entity==null){
                    return;
                }
                Integer xLocation = locationUtil.turnMouseXLocation(entity.getX());
                Integer yLocation = locationUtil.turnMouseYLocation(entity.getY());
                CheRouting cheRouting=new CheRouting(locationUtil);
                List<Integer[]> ruleList = cheRouting.calculateRouting(xLocation, yLocation);
                pieceRouting.setRuleList(ruleList);
                selectedIcon.setLocation(entity.getX(),entity.getY());
                selectedIcon.setVisible(true);
                selectedChessLabel=entity;
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
    }

    public void start(){
        frame.add(panel);
        frame.setVisible(true);
    }

}
