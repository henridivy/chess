package chess;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class PawnMovesCalculator extends PieceMovesCalculator {

    public PawnMovesCalculator(ChessBoard board, ChessPosition startingPosition, boolean pawnInitial) {
        super(board, startingPosition);
    }

    @Override
    public Collection<ChessMove> pieceMoves(ChessBoard board, ChessPosition startingPosition) {
        List<ChessMove> validMoves = new ArrayList<>();

        int r = startingPosition.getRow();
        int c = startingPosition.getColumn();

        // move forward one square
        validMoves.add(new ChessMove(startingPosition, new ChessPosition(r + 1, c), null));

        // if initial move, can also more forward two squares
        if (pawnInitial) {
            validMoves.add(new ChessMove(startingPosition, new ChessPosition(r + 2, c), null));
        }

        return validMoves;
    }
}
