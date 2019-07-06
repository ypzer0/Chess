package com.practice.entity;

import com.practice.constant.CommonConstant;
import com.practice.location.PieceRouting;

/**
 * @author 杨鹏
 */
public class ChessRedChe extends CommonEntity {

    public ChessRedChe(){
        this.chessImgPath = CommonConstant.CHESS_IMAGE_PATH+"r_c.png";
        this.coordinateX = CommonConstant.originLocationX;
        this.coordinateY = CommonConstant.originLocationY;
    }
}
