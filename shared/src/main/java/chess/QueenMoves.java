package chess;

import java.util.ArrayList;
import java.util.List;

public class QueenMoves extends MovesCalculator{

    private final List<ChessMove> validMoves;

    public QueenMoves() {
        this.validMoves = new ArrayList<>();
    }

    @Override
    public List<ChessMove> pieceMoves(ChessBoard board, ChessPosition startPosition, ChessPiece piece) {

        RookMoves rookMoves = new RookMoves();
        BishopMoves bishopMoves = new BishopMoves();

        validMoves.addAll(rookMoves.pieceMoves(board, startPosition, piece));
        validMoves.addAll(bishopMoves.pieceMoves(board, startPosition, piece));

        return validMoves;
    }
}
