package chess;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MovesCalculator {

    private List<ChessMove> validMoves;

    public MovesCalculator() {
        this.validMoves = List.of();
    }

    public List<ChessMove> pieceMoves(ChessBoard board, ChessPosition startPosition, ChessPiece piece) {

        if (piece.getPieceType() == ChessPiece.PieceType.BISHOP) {
            BishopMoves bishopMoves = new BishopMoves();
            validMoves = bishopMoves.pieceMoves(board, startPosition, piece);
        } else if (piece.getPieceType() == ChessPiece.PieceType.ROOK) {
            RookMoves rookMoves = new RookMoves();
            validMoves = rookMoves.pieceMoves(board, startPosition, piece);
        } else if (piece.getPieceType() == ChessPiece.PieceType.QUEEN) {
            QueenMoves queenMoves = new QueenMoves();
            validMoves = queenMoves.pieceMoves(board, startPosition, piece);
        } else if (piece.getPieceType() == ChessPiece.PieceType.KING) {
            KingMoves kingMoves = new KingMoves();
            validMoves = kingMoves.pieceMoves(board, startPosition, piece);
        } else if (piece.getPieceType() == ChessPiece.PieceType.KNIGHT) {
            KnightMoves knightMoves = new KnightMoves();
            validMoves = knightMoves.pieceMoves(board, startPosition, piece);
        } else if (piece.getPieceType() == ChessPiece.PieceType.PAWN) {
            PawnMoves pawnMoves = new PawnMoves();
            validMoves = pawnMoves.pieceMoves(board, startPosition, piece);
        }

        return validMoves;
    }

}
