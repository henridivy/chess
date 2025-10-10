package chess;

import java.util.ArrayList;
import java.util.List;

public class RookMoves extends MovesCalculator{

    private final List<ChessMove> validMoves;

    public RookMoves() {
        this.validMoves = new ArrayList<>();
    }

    @Override
    public List<ChessMove> pieceMoves(ChessBoard board, ChessPosition startPosition, ChessPiece piece) {

        int r = startPosition.getRow();
        int c = startPosition.getColumn();

        ChessPosition endPosition;
        ChessMove newMove;

        // up
        for (int i = r + 1; i < 9; i++) {
            endPosition = new ChessPosition(i, c);
            if (board.isValidSpot(piece, endPosition)) {
                newMove = new ChessMove(startPosition, endPosition, null);
                validMoves.add(newMove);
            }
            if (!board.inBounds(endPosition) || !board.isEmpty(endPosition)) {
                break; // has to be in bounds AND empty to keep going further
            }
        }

        // right
        for (int j = c + 1; j < 9; j++) {
            endPosition = new ChessPosition(r, j);
            if (board.isValidSpot(piece, endPosition)) {
                newMove = new ChessMove(startPosition, endPosition, null);
                validMoves.add(newMove);
            }
            if (!board.inBounds(endPosition) || !board.isEmpty(endPosition)) {
                break; // has to be in bounds AND empty to keep going further
            }
        }

        // down
        for (int i = r - 1; i > 0; i--) {
            endPosition = new ChessPosition(i, c);
            if (board.isValidSpot(piece, endPosition)) {
                newMove = new ChessMove(startPosition, endPosition, null);
                validMoves.add(newMove);
            }
            if (!board.inBounds(endPosition) || !board.isEmpty(endPosition)) {
                break; // has to be in bounds AND empty to keep going further
            }
        }

        // left
        for (int j = c - 1; j > 0; j--) {
            endPosition = new ChessPosition(r, j);
            if (board.isValidSpot(piece, endPosition)) {
                newMove = new ChessMove(startPosition, endPosition, null);
                validMoves.add(newMove);
            }
            if (!board.inBounds(endPosition) || !board.isEmpty(endPosition)) {
                break; // has to be in bounds AND empty to keep going further
            }
        }

        return validMoves;
    }
}
