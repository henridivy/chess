package chess;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class KingMovesCalculator extends PieceMovesCalculator {

    public KingMovesCalculator(ChessBoard board, ChessPosition startingPosition) {
        super(board, startingPosition);
    }

    @Override
    public Collection<ChessMove> pieceMoves(ChessBoard board, ChessPosition startingPosition) {
        List<ChessMove> validMoves = new ArrayList<>();

        int r = startingPosition.getRow();
        int c = startingPosition.getColumn();

        List<ChessPosition> endingPositions = List.of(
                new ChessPosition(r-1, c-1),        // left up
                new ChessPosition(r, c-1),               // left middle
                new ChessPosition(r+1, c-1),        // left down
                new ChessPosition(r-1, c),              // middle up
                new ChessPosition(r+1, c),              // middle down
                new ChessPosition(r-1, c+1),        // right up
                new ChessPosition(r, c+1),               // right middle
                new ChessPosition(r+1, c+1)         // right down
        );

        for (ChessPosition endingPosition : endingPositions) {
            // if ending position is on the chessboard
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
        [3,6] [i,j]
        one square all around
        2,5  2,6  2,7
        3,5       3,7
        4,5  4,6  4,7
         */

        return validMoves;
    }
}
