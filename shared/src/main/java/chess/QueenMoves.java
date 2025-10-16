package chess;

import java.util.ArrayList;
import java.util.List;

public class QueenMoves extends MovesCalculator{

    private final List<ChessMove> possibleMoves;

    public QueenMoves() {
        this.possibleMoves = new ArrayList<>();
    }

    @Override
    public List<ChessMove> pieceMoves(ChessBoard board, ChessPosition startPosition, ChessPiece piece) {

        RookMoves rookMoves = new RookMoves();
        BishopMoves bishopMoves = new BishopMoves();

        possibleMoves.addAll(rookMoves.pieceMoves(board, startPosition, piece));
        possibleMoves.addAll(bishopMoves.pieceMoves(board, startPosition, piece));

        return possibleMoves;
    }
}
