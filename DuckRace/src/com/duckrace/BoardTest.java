package com.duckrace;

class BoardTest {
    public static void main(String[] args) {
        Board board = new Board();
        board.dumpStudentIdMap();


        board.update(3,Reward.PRIZES);
        board.update(3,Reward.DEBIT_CARD);
        board.show();
    }
}