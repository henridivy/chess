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
        for (int i = startingPosition.getRow() + 1; i < 9; i++) {
            ChessPosition endingPosition = new ChessPosition(i, c);
            if (board.isOccupied(endingPosition)) {
                ChessPiece nextPiece = board.getPiece(endingPosition);
                // if the piece is an enemy...
                if (nextPiece.getTeamColor() != piece.getTeamColor()) {
                    validMoves.add(new ChessMove(startingPosition, endingPosition, null));
                }
                break;
            }
            validMoves.add(new ChessMove(startingPosition, endingPosition, null));
        }

        // for down
        for (int i = startingPosition.getRow() - 1; i > 0; i--) {
            ChessPosition endingPosition = new ChessPosition(i, c);
            if (board.isOccupied(endingPosition)) {
                ChessPiece nextPiece = board.getPiece(endingPosition);
                // if the piece is an enemy...
                if (nextPiece.getTeamColor() != piece.getTeamColor()) {
                    validMoves.add(new ChessMove(startingPosition, endingPosition, null));
                }
                break;
            }
            validMoves.add(new ChessMove(startingPosition, endingPosition, null));
        }

        // for left
        for (int j = startingPosition.getColumn() - 1; j > 0; j--) {
            ChessPosition endingPosition = new ChessPosition(r, j);
            if (board.isOccupied(endingPosition)) {
                ChessPiece nextPiece = board.getPiece(endingPosition);
                // if the piece is an enemy...
                if (nextPiece.getTeamColor() != piece.getTeamColor()) {
                    validMoves.add(new ChessMove(startingPosition, endingPosition, null));
                }
                break;
            }
            validMoves.add(new ChessMove(startingPosition, endingPosition, null));
        }

        // for right
        for (int j = startingPosition.getColumn() + 1; j < 9; j++) {
            ChessPosition endingPosition = new ChessPosition(r, j);
            if (board.isOccupied(endingPosition)) {
                ChessPiece nextPiece = board.getPiece(endingPosition);
                // if the piece is an enemy...
                if (nextPiece.getTeamColor() != piece.getTeamColor()) {
                    validMoves.add(new ChessMove(startingPosition, endingPosition, null));
                }
                break;
            }
            validMoves.add(new ChessMove(startingPosition, endingPosition, null));
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

//    public void addMoves(List<ChessMove> validMoves, ChessPosition startingPosition, ChessPosition endingPosition) {
//        if (board.isOccupied(endingPosition)) {
//            ChessPiece nextPiece = board.getPiece(endingPosition);
//            // if the piece is a friend...
//            if (nextPiece.getTeamColor() == piece.getTeamColor()) {
//                break;
//            }
//        }
//        validMoves.add(new ChessMove(startingPosition, endingPosition, null));
//    }
}
