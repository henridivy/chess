package chess;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class KnightMoves extends MovesCalculator {

    public KnightMoves(ChessBoard board, ChessPosition startingPosition) {
        super(board, startingPosition);
    }

    @Override
    public Collection<ChessMove> pieceMoves(ChessBoard board, ChessPosition startingPosition) {
        List<ChessMove> validMoves = new ArrayList<>();

        int r = startingPosition.getRow();
        int c = startingPosition.getColumn();

        List<ChessPosition> endingPositions = List.of(
                new ChessPosition(r+2, c-1),    // up
                new ChessPosition(r+2, c+1),
                new ChessPosition(r+1, c-2),    // left
                new ChessPosition(r-1, c-2),
                new ChessPosition(r-2, c-1),    // down
                new ChessPosition(r-2, c+1),
                new ChessPosition(r+1, c+2),    // right
                new ChessPosition(r-1, c+2)
        );

        for (ChessPosition endingPosition : endingPositions) {
            // if ending position is on the chessboard...
            if (endingPosition.inBounds()) {
                // if there's a piece in the way...
                if (board.isOccupied(endingPosition)) {
                    ChessPiece nextPiece = board.getPiece(endingPosition);
                    // if the piece is an enemy...
                    if (nextPiece.getTeamColor() != piece.getTeamColor()) {
                        ChessMove newMove = new ChessMove(startingPosition, endingPosition, null);
                        validMoves.add(newMove);
                    }
                    // if there's no piece in the way...
                } else {
                    ChessMove newMove = new ChessMove(startingPosition, endingPosition, null);
                    validMoves.add(newMove);
                }
            }
        }

        /*
        [5,5] [i,j]
        7,4  7,6  up
        6,3  4,3  left
        3,4  3,6  down
        6,7  4,7  right
         */

        return validMoves;
    }
}
