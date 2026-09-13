package chess;

import java.util.Arrays;
import java.util.Objects;

/**
 * A chessboard that can hold and rearrange chess pieces.
 * <p>
 * Note: You can add to this class, but you may not alter
 * signature of the existing methods.
 */
public class ChessBoard {

    private final ChessPiece[][] board;

    public ChessBoard() {
        board = new ChessPiece[8][8];
    }

    /**
     * Adds a chess piece to the chessboard
     *
     * @param position where to add the piece to
     * @param piece    the piece to add
     */
    public void addPiece(ChessPosition position, ChessPiece piece) {
        board[position.getRow() - 1][position.getColumn() - 1] = piece;
    }

    /**
     * Gets a chess piece on the chessboard
     *
     * @param position The position to get the piece from
     * @return Either the piece at the position, or null if no piece is at that
     * position
     */
    public ChessPiece getPiece(ChessPosition position) {
        return board[position.getRow() - 1][position.getColumn() - 1];
    }

    private void removePiece(ChessPosition position) {

    }

    /**
     * Sets the board to the default starting board
     * (How the game of chess normally starts)
     */
    public void resetBoard(){
        throw new RuntimeException();
    }
//    public void resetBoard() {
//
//        ChessPiece.PieceType.values()[] = {}
//        int[][] occupiedRows = {{1, 2}, {8, 7}};
//
//        for (int i = 1; i <= 2; i++) {  // loops twice
//            var color = ChessGame.TeamColor.values()[i];
//
//        }
//
//        for (var color : ChessGame.TeamColor.values()) {
//
//        }
//
//        for (var row : occupiedRows) {
//            // set WHITE
//                // set special pieces
//
//            // set BLACK
//        }
//    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ChessBoard that = (ChessBoard) o;
        return Objects.deepEquals(board, that.board);
    }

    @Override
    public int hashCode() {
        return Arrays.deepHashCode(board);
    }
}
