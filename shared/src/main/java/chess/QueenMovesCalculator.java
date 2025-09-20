package chess;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class QueenMovesCalculator extends PieceMovesCalculator {


    public QueenMovesCalculator(ChessBoard board, ChessPosition startingPosition) { super(board, startingPosition); }

    @Override
    public Collection<ChessMove> pieceMoves(ChessBoard board, ChessPosition startingPosition) {
        List<ChessMove> validMoves = new ArrayList<>();

        BishopMovesCalculator bish_calc = new BishopMovesCalculator(board, startingPosition);
        RookMovesCalculator rook_calc = new RookMovesCalculator(board, startingPosition);

        validMoves.addAll(bish_calc.pieceMoves(board, startingPosition));
        validMoves.addAll(rook_calc.pieceMoves(board, startingPosition));

        return validMoves;
    }
}
