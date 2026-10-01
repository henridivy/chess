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

    /**
     * Sets the board to the default starting board
     * (How the game of chess normally starts)
     */

//            |r|n|b|q|k|b|n|r|
//            |p|p|p|p|p|p|p|p|
//            | | | | | | | | |
//            | | | | | | | | |
//            | | | | | | | | |
//            | | | | | | | | |
//            |P|P|P|P|P|P|P|P|
//            |R|N|B|Q|K|B|N|R|

    public void resetBoard() {
        clearBoard();

        String[] pieces = {"rook", "knight", "bishop", "queen", "king", "bishop", "knight", "rook"};
        String[] pawns = {"pawn", "pawn", "pawn", "pawn", "pawn", "pawn", "pawn", "pawn"};

        addPiecesToRow(pieces, ChessGame.TeamColor.WHITE, 1);
        addPiecesToRow(pawns, ChessGame.TeamColor.WHITE, 2);
        addPiecesToRow(pawns, ChessGame.TeamColor.BLACK, 7);
        addPiecesToRow(pieces, ChessGame.TeamColor.BLACK, 8);
    }

    private void clearBoard() {
        for (int r = 1; r <= 8; r++) {
            for (int c = 1; c <= 8; c++) {
                board[r-1][c-1] = null;
            }
        }
    }

    private void addPiecesToRow(String[] pieceTypes, ChessGame.TeamColor color, int row) {
        int col = 1;
        for (var type : pieceTypes) {
            ChessPiece piece = new ChessPiece(color, ChessPiece.PieceType.valueOf(type.toUpperCase()));
            ChessPosition position = new ChessPosition(row, col);
            addPiece(position, piece);
            col++;
        }
    }

    public boolean inBounds(ChessPosition position) {
        int r = position.getRow();
        int c = position.getColumn();

        return (0 < r && r <= board.length) &&
                (0 < c && c <= board[0].length);
    }

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

    @Override
    public String toString() {
        StringBuilder b = new StringBuilder();

        // build top down
        for (int r = 8; r >= 1; r--) {
            b.append("|");
            for (int c = 1; c <= 8; c++) {
                if (board[r-1][c-1] != null) {
                    b.append(board[r-1][c-1].toString());
                } else { b.append(" "); }
                b.append("|");
            }
            b.append("\n");
        }

        return b.toString();
    }
}