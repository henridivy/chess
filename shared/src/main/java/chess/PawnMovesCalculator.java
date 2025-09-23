package chess;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class PawnMovesCalculator extends PieceMovesCalculator {

    ChessGame.TeamColor pawnColor;

    public PawnMovesCalculator(ChessBoard board, ChessPosition startingPosition, ChessGame.TeamColor pawnColor) {
        super(board, startingPosition);
        this.pawnColor = pawnColor;
    }

    @Override
    public Collection<ChessMove> pieceMoves(ChessBoard board, ChessPosition startingPosition) {
        List<ChessMove> validMoves = new ArrayList<>();

        int r = startingPosition.getRow();
        int c = startingPosition.getColumn();

        List<ChessPosition> endingPositions;

        // white pawns start on row 2, and are moving up (+1 or 2)
        if (pawnColor == ChessGame.TeamColor.WHITE) {

            boolean isInitial = (r == 2);      // if this will be pawn's first move, initial is true, else it's false

            endingPositions = List.of(
                    new ChessPosition(r + 1, c - 1),    // left (capture)
                    new ChessPosition(r + 1, c + 1),    // right (capture)
                    new ChessPosition(r + 1, c),             // up
                    new ChessPosition(r + 2, c)             // up up
            );

//           boolean isValidMove = evaluateValidMove(endingPositions);

            for (ChessPosition endingPosition : endingPositions) {
                boolean isValidMove = false;
                // if it's in bounds...
                if (endingPosition.inBounds()) {
                    // if it's moving straight up...
                    if (endingPosition.getColumn() == c) {
                        // if there's no piece in the way...
                        if (!board.isOccupied(endingPosition)) {
                            isValidMove = true;
                        }
                        // if it's moving diagonally...
                    } else {
                        // if there's a piece in the way...
                        if (board.isOccupied(endingPosition)) {
                            ChessPiece nextPiece = board.getPiece(endingPosition);
                            // if the piece is an enemy...
                            if (nextPiece.getTeamColor() != piece.getTeamColor()) {
                                isValidMove = true;
                            }
                        }
                    }
                    // if it's an initial move...
                    if (endingPosition.getRow() == r + 2) {
                        if (!isInitial || board.isOccupied(new ChessPosition(r + 1, c))) {
                            isValidMove = false;
                        }
                    }
                }
                if (isValidMove) {
                    // if it's reached the opponent's back rank...
                    if (endingPosition.getRow() == 8) {
                        addPromotionMoves(validMoves, startingPosition, endingPosition);
                    // if not...
                    } else {
                        ChessMove newMove = new ChessMove(startingPosition, endingPosition, null);
                        validMoves.add(newMove);
                    }
                }
            }
        }

        // black pawns start on row 7, and are moving down (-1 or 2)
        if (pawnColor == ChessGame.TeamColor.BLACK) {

            boolean isInitial = (r == 7);      // if this will be pawn's first move, initial is true, else it's false

            endingPositions = List.of(
                    new ChessPosition(r - 1, c - 1),    // left (capture)
                    new ChessPosition(r - 1, c + 1),    // right (capture)
                    new ChessPosition(r - 1, c),             // down
                    new ChessPosition(r - 2, c)             // down down
            );

            for (ChessPosition endingPosition : endingPositions) {
                boolean isValidMove = false;
                // if it's in bounds...
                if (endingPosition.inBounds()) {
                    // if it's moving straight up...
                    if (endingPosition.getColumn() == c) {
                        // if there's no piece in the way...
                        if (!board.isOccupied(endingPosition)) {
                            isValidMove = true;
                        }
                    // if it's moving diagonally...
                    } else {
                        // if there's a piece in the way...
                        if (board.isOccupied(endingPosition)) {
                            ChessPiece nextPiece = board.getPiece(endingPosition);
                            // if the piece is an enemy...
                            if (nextPiece.getTeamColor() != piece.getTeamColor()) {
                                isValidMove = true;
                            }
                        }
                    }
                    // if it's an initial move...
                    if (endingPosition.getRow() == r - 2) {
                        if (!isInitial || board.isOccupied(new ChessPosition(r - 1, c))) {
                            isValidMove = false;
                        }
                    }
                }
                if (isValidMove) {
                    // if it's reached the opponent's back rank...
                    if (endingPosition.getRow() == 1) {
                        addPromotionMoves(validMoves, startingPosition, endingPosition);
                    // if not...
                    } else {
                        ChessMove newMove = new ChessMove(startingPosition, endingPosition, null);
                        validMoves.add(newMove);
                    }
                }
            }
        }

        return validMoves;
    }

    public void addPromotionMoves(List<ChessMove> validMoves, ChessPosition startingPosition, ChessPosition endingPosition) {
        List<ChessPiece.PieceType> promotionTypes = List.of(
                ChessPiece.PieceType.BISHOP,
                ChessPiece.PieceType.ROOK,
                ChessPiece.PieceType.KNIGHT,
                ChessPiece.PieceType.QUEEN
        );

        for (ChessPiece.PieceType promotionType : promotionTypes) {
            ChessMove newMove = new ChessMove(startingPosition, endingPosition, promotionType);
            validMoves.add(newMove);
        }
    }
}
