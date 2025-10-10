package chess;

import java.util.ArrayList;
import java.util.List;

public class KingMoves extends MovesCalculator{

    private final List<ChessMove> validMoves;

    public KingMoves() {
        this.validMoves = new ArrayList<>();
    }

    @Override
    public List<ChessMove> pieceMoves(ChessBoard board, ChessPosition startPosition, ChessPiece piece) {

        int r = startPosition.getRow();
        int c = startPosition.getColumn();

        ChessPosition endPosition;
        ChessMove newMove;

        List<ChessPosition> possibleEnds = List.of(
                new ChessPosition(r+1, c-1),    // up left
                new ChessPosition(r+1, c),          // up
                new ChessPosition(r+1, c+1),    // up right
                new ChessPosition(r, c+1),           // right
                new ChessPosition(r-1, c+1),    // down right
                new ChessPosition(r-1, c),          // down
                new ChessPosition(r-1, c-1),    // down left
                new ChessPosition(r, c-1)           // left
        );

        for (var end : possibleEnds) {
            endPosition = end;
            if (board.isValidSpot(piece, endPosition)) {
                newMove = new ChessMove(startPosition, endPosition, null);
                validMoves.add(newMove);
            }
        }

        return validMoves;
    }
}
