package chess;

import java.util.ArrayList;
import java.util.List;

public class PawnMoves extends MovesCalculator{

    private final List<ChessMove> possibleMoves;

    public PawnMoves() {
        this.possibleMoves = new ArrayList<>();
    }

    @Override
    public List<ChessMove> pieceMoves(ChessBoard board, ChessPosition startPosition, ChessPiece piece) {

        int r = startPosition.getRow();
        int c = startPosition.getColumn();

        ChessPosition endPosition;
        ChessMove newMove;

        ChessPosition[] possibleEnds = {
                // black
                new ChessPosition(r - 1, c),          // down one
                new ChessPosition(r - 2, c),          // down two
                new ChessPosition(r - 1, c - 1),    // capture left
                new ChessPosition(r - 1, c + 1),     // capture right

                // WHITE
                new ChessPosition(r + 1, c),          // up one
                new ChessPosition(r + 2, c),          // up two
                new ChessPosition(r + 1, c - 1),    // capture left
                new ChessPosition(r + 1, c + 1)    // capture right
        };

        // ------black pawns------
        if (piece.getTeamColor() == ChessGame.TeamColor.BLACK) {

            // forward one - can move only if empty
            endPosition = possibleEnds[0];
            if (board.inBounds(endPosition)) {
                if (board.isEmpty(endPosition)) {
                    if (endPosition.getRow() == 1) { // if black has reached white's ranks
                        addPromotionPieces(startPosition, endPosition);
                    } else {    // not being promoted
                        newMove = new ChessMove(startPosition, endPosition, null);
                        possibleMoves.add(newMove);
                    }

                    // forward two - initial
                    if (r == 7) { // starts on 7th row
                        endPosition = possibleEnds[1];
                        if (board.isEmpty(endPosition)) {
                            newMove = new ChessMove(startPosition, endPosition, null);
                            possibleMoves.add(newMove);
                        }
                    }
                }
            }

            // capture left
            endPosition = possibleEnds[2];
            if (board.inBounds(endPosition)) {
                if (board.isValidSpot(piece, endPosition) && !board.isEmpty(endPosition)) {  // valid not empty spot = enemy
                    if (endPosition.getRow() == 1) { // if black has reached white's ranks
                        addPromotionPieces(startPosition, endPosition);
                    } else {    // not being promoted
                        newMove = new ChessMove(startPosition, endPosition, null);
                        possibleMoves.add(newMove);
                    }
                }
            }

            // capture right
            endPosition = possibleEnds[3];
            if (board.inBounds(endPosition)) {
                if (board.isValidSpot(piece, endPosition) && !board.isEmpty(endPosition)) {  // valid not empty spot = enemy
                    if (endPosition.getRow() == 1) { // if black has reached white's ranks
                        addPromotionPieces(startPosition, endPosition);
                    } else {    // not being promoted
                        newMove = new ChessMove(startPosition, endPosition, null);
                        possibleMoves.add(newMove);
                    }
                }
            }
        }
        // -------WHITE PAWNS------

        else if (piece.getTeamColor() == ChessGame.TeamColor.WHITE) {

            // forward one - can move only if empty
            endPosition = possibleEnds[4];
            if (board.inBounds(endPosition)) {
                if (board.isEmpty(endPosition)) {
                    if (endPosition.getRow() == 8) { // if white has reached black's ranks
                        addPromotionPieces(startPosition, endPosition);
                    } else {    // not being promoted
                        newMove = new ChessMove(startPosition, endPosition, null);
                        possibleMoves.add(newMove);
                    }

                    // forward two - initial
                    if (r == 2) { // starts on 2nd row
                        endPosition = possibleEnds[5];
                        if (board.isEmpty(endPosition)) {
                            newMove = new ChessMove(startPosition, endPosition, null);
                            possibleMoves.add(newMove);
                        }
                    }
                }
            }

            // capture left
            endPosition = possibleEnds[6];
            if (board.inBounds(endPosition)) {
                if (board.isValidSpot(piece, endPosition) && !board.isEmpty(endPosition)) {  // valid not empty spot = enemy
                    if (endPosition.getRow() == 8) { // if white has reached black's ranks
                        addPromotionPieces(startPosition, endPosition);
                    } else {    // not being promoted
                        newMove = new ChessMove(startPosition, endPosition, null);
                        possibleMoves.add(newMove);
                    }
                }
            }

            // capture right
            endPosition = possibleEnds[7];
            if (board.inBounds(endPosition)) {
                if (board.isValidSpot(piece, endPosition) && !board.isEmpty(endPosition)) {  // valid not empty spot = enemy
                    if (endPosition.getRow() == 8) { // if white has reached black's ranks
                        addPromotionPieces(startPosition, endPosition);
                    } else {    // not being promoted
                        newMove = new ChessMove(startPosition, endPosition, null);
                        possibleMoves.add(newMove);
                    }
                }
            }
        }


        return possibleMoves;
    }

    public void addPromotionPieces(ChessPosition startPosition, ChessPosition endPosition) {
        ChessPiece.PieceType[] promotionTypes = {
                ChessPiece.PieceType.ROOK,
                ChessPiece.PieceType.KNIGHT,
                ChessPiece.PieceType.BISHOP,
                ChessPiece.PieceType.QUEEN
        };

        for (var type : promotionTypes) {
            ChessMove newMove = new ChessMove(startPosition, endPosition, type);
            possibleMoves.add(newMove);
        }
    }
}
