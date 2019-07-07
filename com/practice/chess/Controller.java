package com.practice.chess;

import com.practice.constant.CommonConstant;
import com.practice.entity.ChessChe;
import com.practice.location.LocationUtil;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

/**
 * 加载棋子对象
 * @author 杨鹏
 */
public class Controller extends FrameLoader{

    /**
     * 棋盘,用于记录存活的棋子
     * 格式:{红方或黑方的代号,棋子种类代号,棋子x坐标,棋子y坐标}
     */
    protected List<Integer[]> checkerboard = new ArrayList<>();

    public void initChess(){
        ChessChe redCheOne = new ChessChe(CommonConstant.CHESS_IMAGE_PATH+"r_c.png",
                            CommonConstant.originLocationX,
                CommonConstant.originLocationY + CommonConstant.CELL*9);
        ChessChe redCheTwo = new ChessChe(CommonConstant.CHESS_IMAGE_PATH+"r_c.png",
                CommonConstant.originLocationX + CommonConstant.CELL*8,
                CommonConstant.originLocationY + CommonConstant.CELL*9);
        ChessChe blackCheOne = new ChessChe(CommonConstant.CHESS_IMAGE_PATH+"b_c.png",
                CommonConstant.originLocationX,
                CommonConstant.originLocationY);
        ChessChe blackCheTwo = new ChessChe(CommonConstant.CHESS_IMAGE_PATH+"b_c.png",
                CommonConstant.originLocationX + CommonConstant.CELL*8,
                CommonConstant.originLocationY);
        this.setCheListener(redCheOne);
        this.setCheListener(redCheTwo);
        this.setCheListener(blackCheOne);
        this.setCheListener(blackCheTwo);
        Integer[] redCheOneArray = {CommonConstant.COLOR_RED,CommonConstant.CHESS_CHE,
                redCheOne.getX(),redCheOne.getY()};
        checkerboard.add(redCheOneArray);
        Integer[] redCheTwoArray = {CommonConstant.COLOR_RED,CommonConstant.CHESS_CHE,
                redCheTwo.getX(),redCheTwo.getY()};
        checkerboard.add(redCheTwoArray);
        Integer[] blackCheOneArray = {CommonConstant.COLOR_BLACK,CommonConstant.CHESS_CHE,
                blackCheOne.getX(),blackCheOne.getY()};
        checkerboard.add(blackCheOneArray);
        Integer[] blackCheTwoArray = {CommonConstant.COLOR_BLACK,CommonConstant.CHESS_CHE,
                blackCheTwo.getX(),blackCheTwo.getY()};
        checkerboard.add(blackCheTwoArray);
        panel.add(redCheOne);
        panel.add(redCheTwo);
        panel.add(blackCheOne);
        panel.add(blackCheTwo);
    }

    public void  initPanel(){
        selectedIcon.setVisible(false);
        panel.add(selectedIcon);
        panel.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(selectedChessEntity!=null){
                    LocationUtil locationUtil = new LocationUtil();
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
                    //移动选中棋子的位置
                    selectedChessEntity.setLocation(xLocation,yLocation);

                }
                selectedChessEntity=null;
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
     * 设置车被选中的事件
     * @param chessChe
     */
    public void setCheListener(ChessChe chessChe){
        chessChe.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(chessChe==null){
                    return;
                }
                LocationUtil locationUtil=new LocationUtil();
                Integer xLocation = locationUtil.turnMouseXLocation(chessChe.getX());
                Integer yLocation = locationUtil.turnMouseYLocation(chessChe.getY());
                //计算的落点放入pieceRouting
                chessChe.calculateRouting(xLocation,yLocation,pieceRouting);
                selectedIcon.setLocation(chessChe.getX(),chessChe.getY());
                selectedIcon.setVisible(true);
                selectedChessEntity = chessChe;
                selectedChessEntity.setSelectedArray(chessChe.getInfoArray());
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

}
