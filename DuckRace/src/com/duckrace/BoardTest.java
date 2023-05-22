package com.duckrace;

class BoardTest {
    public static void main(String[] args) {
        // create new board which initializes its fields causing the file to get read
        Board board = new Board();
        board.dumpStudentIdMap();

        // update the board a few times, with the needed ID of winner  and PRIZE that winner chose
        board.update(3,Reward.PRIZES);
        board.update(3,Reward.DEBIT_CARD);
        board.show();
    }
}