package com.practice.chess;


import com.practice.entity.BackgroundEntity;
import com.practice.entity.ChessRedChe;
import com.practice.constant.ChessFramePosition;
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
        JLabel label = backgroundEntity.getLabel();
        panel.add(label);
        panel.setBounds(backgroundEntity.getCoordinateX(),
                backgroundEntity.getCoordinateY(),
                backgroundEntity.getImgWeight(),
                backgroundEntity.getImgHeight());
        frame.add(panel);
    }

    public void  testRedChe(){
        ChessRedChe chessRedChe = new ChessRedChe();
        JLabel redCheLabel =chessRedChe.getLabel();
        setSelectedListener(redCheLabel);
        panel.add(redCheLabel);
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
     * @param label
     */
    private void setSelectedListener(JLabel label){
        label.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(label==null){
                    return;
                }
                Integer xLocation = locationUtil.turnMouseXLocation(label.getX());
                Integer yLocation = locationUtil.turnMouseYLocation(label.getY());
                CheRouting cheRouting=new CheRouting(locationUtil);
                List<Integer[]> ruleList = cheRouting.calculateRouting(xLocation, yLocation);
                pieceRouting.setRuleList(ruleList);
                selectedChessLabel=label;
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
        frame.setVisible(true);
    }

}
