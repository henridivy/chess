package chess;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class RookMovesCalculator extends PieceMovesCalculator {

    public RookMovesCalculator(ChessBoard board, ChessPosition startingPosition) {
        super(board, startingPosition);
    }

    @Override
    public Collection<ChessMove> pieceMoves(ChessBoard board, ChessPosition startingPosition) {
        List<ChessMove> validMoves = new ArrayList<>();

        int r = startingPosition.getRow();
        int c = startingPosition.getColumn();

        // for up
        for (int i = startingPosition.getRow(); i < 8; i++) {
            validMoves.add(new ChessMove(startingPosition, new ChessPosition(i+1, c), null));
        }

        // for down
        for (int i = startingPosition.getRow(); i > 1; i--) {
            validMoves.add(new ChessMove(startingPosition, new ChessPosition(i-1, c), null));
        }

        // for left
        for (int j = startingPosition.getColumn(); j > 1; j--) {
            validMoves.add(new ChessMove(startingPosition, new ChessPosition(r, j-1), null));
        }

        // for right
        for (int j = startingPosition.getColumn(); j < 8; j++) {
            validMoves.add(new ChessMove(startingPosition, new ChessPosition(r, j+1), null));
        }

        /* 2,3 (r,c)
        up - 3,3  4,3  5,3  6,3  7,3  8,3
        left - 2,2  2,1
        down - 1,3
        right - 2,4  2,5  2,6  2,7  2,8
         */

        return validMoves;
//        return super.pieceMoves(board, myPosition);
    }
}
