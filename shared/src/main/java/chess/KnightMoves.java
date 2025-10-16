package chess;

import java.util.ArrayList;
import java.util.List;

public class KnightMoves extends MovesCalculator{

    private final List<ChessMove> possibleMoves;

    public KnightMoves() {
        this.possibleMoves = new ArrayList<>();
    }

    @Override
    public List<ChessMove> pieceMoves(ChessBoard board, ChessPosition startPosition, ChessPiece piece) {

        int r = startPosition.getRow();
        int c = startPosition.getColumn();

        ChessPosition endPosition;
        ChessMove newMove;

        List<ChessPosition> possibleEnds = List.of(
                new ChessPosition(r+2, c-1),    // up left
                new ChessPosition(r+2, c+1),    // up right
                new ChessPosition(r+1, c+2),    // right up
                new ChessPosition(r-1, c+2),    // right down
                new ChessPosition(r-2, c+1),    // down right
                new ChessPosition(r-2, c-1),    // down left
                new ChessPosition(r-1, c-2),    // left down
                new ChessPosition(r+1, c-2)     // left up
        );

        for (var end : possibleEnds) {
            endPosition = end;
            if (board.isValidSpot(piece, endPosition)) {
                newMove = new ChessMove(startPosition, endPosition, null);
                possibleMoves.add(newMove);
            }
        }

        return possibleMoves;
    }
}
