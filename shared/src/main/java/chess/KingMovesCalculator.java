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

        // left up
        validMoves.add(new ChessMove(startingPosition, new ChessPosition(r-1, c-1), null));
        // left middle
        validMoves.add(new ChessMove(startingPosition, new ChessPosition(r, c-1), null));
        // left down
        validMoves.add(new ChessMove(startingPosition, new ChessPosition(r+1, c-1), null));

        // middle up
        validMoves.add(new ChessMove(startingPosition, new ChessPosition(r-1, c), null));
        // middle down
        validMoves.add(new ChessMove(startingPosition, new ChessPosition(r+1, c), null));

        // right up
        validMoves.add(new ChessMove(startingPosition, new ChessPosition(r-1, c+1), null));
        // right middle
        validMoves.add(new ChessMove(startingPosition, new ChessPosition(r, c+1), null));
        // right down
        validMoves.add(new ChessMove(startingPosition, new ChessPosition(r+1, c+1), null));

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
