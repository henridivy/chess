package chess;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MovesCalculator {

    private List<ChessMove> possibleMoves;

    public MovesCalculator() {
        this.possibleMoves = List.of();
    }

    public List<ChessMove> pieceMoves(ChessBoard board, ChessPosition startPosition, ChessPiece piece) {

        if (piece.getPieceType() == ChessPiece.PieceType.BISHOP) {
            BishopMoves bishopMoves = new BishopMoves();
            possibleMoves = bishopMoves.pieceMoves(board, startPosition, piece);
        } else if (piece.getPieceType() == ChessPiece.PieceType.ROOK) {
            RookMoves rookMoves = new RookMoves();
            possibleMoves = rookMoves.pieceMoves(board, startPosition, piece);
        } else if (piece.getPieceType() == ChessPiece.PieceType.QUEEN) {
            QueenMoves queenMoves = new QueenMoves();
            possibleMoves = queenMoves.pieceMoves(board, startPosition, piece);
        } else if (piece.getPieceType() == ChessPiece.PieceType.KING) {
            KingMoves kingMoves = new KingMoves();
            possibleMoves = kingMoves.pieceMoves(board, startPosition, piece);
        } else if (piece.getPieceType() == ChessPiece.PieceType.KNIGHT) {
            KnightMoves knightMoves = new KnightMoves();
            possibleMoves = knightMoves.pieceMoves(board, startPosition, piece);
        } else if (piece.getPieceType() == ChessPiece.PieceType.PAWN) {
            PawnMoves pawnMoves = new PawnMoves();
            possibleMoves = pawnMoves.pieceMoves(board, startPosition, piece);
        }

        return possibleMoves;
    }

}
