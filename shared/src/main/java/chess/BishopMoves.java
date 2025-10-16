package chess;

import java.util.ArrayList;
import java.util.List;

public class BishopMoves extends MovesCalculator{

    private final List<ChessMove> possibleMoves;

    public BishopMoves() {
        this.possibleMoves = new ArrayList<>();
    }

    @Override
    public List<ChessMove> pieceMoves(ChessBoard board, ChessPosition startPosition, ChessPiece piece) {

        int r = startPosition.getRow();
        int c = startPosition.getColumn();

        ChessPosition endPosition;
        ChessMove newMove;
        int j;

        // up right
        j = c + 1;
        for (int i = r + 1; i < 9 && j < 9; i++) {
            endPosition = new ChessPosition(i, j);
            if (board.isValidSpot(piece, endPosition)) {
                newMove = new ChessMove(startPosition, endPosition, null);
                possibleMoves.add(newMove);
                j++;
            }
            if (!board.inBounds(endPosition) || !board.isEmpty(endPosition)) {
                break; // has to be in bounds AND empty to keep going further
            }
        }

        // down right
        j = c + 1;
        for (int i = r - 1; i > 0 && j < 9; i--) {
            endPosition = new ChessPosition(i, j);
            if (board.isValidSpot(piece, endPosition)) {
                newMove = new ChessMove(startPosition, endPosition, null);
                possibleMoves.add(newMove);
                j++;
            }
            if (!board.inBounds(endPosition) || !board.isEmpty(endPosition)) {
                break; // has to be in bounds AND empty to keep going further
            }
        }

        // down left
        j = c - 1;
        for (int i = r - 1; i > 0 && j > 0; i--) {
            endPosition = new ChessPosition(i, j);
            if (board.isValidSpot(piece, endPosition)) {
                newMove = new ChessMove(startPosition, endPosition, null);
                possibleMoves.add(newMove);
                j--;
            }
            if (!board.inBounds(endPosition) || !board.isEmpty(endPosition)) {
                break; // has to be in bounds AND empty to keep going further
            }
        }

        // up left
        j = c - 1;
        for (int i = r + 1; i < 9 && j > 0; i++) {
            endPosition = new ChessPosition(i, j);
            if (board.isValidSpot(piece, endPosition)) {
                newMove = new ChessMove(startPosition, endPosition, null);
                possibleMoves.add(newMove);
                j--;
            }
            if (!board.inBounds(endPosition) || !board.isEmpty(endPosition)) {
                break; // has to be in bounds AND empty to keep going further
            }
        }

        return possibleMoves;
    }
}
