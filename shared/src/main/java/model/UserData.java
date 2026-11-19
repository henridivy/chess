package model;

public record UserData(String username,
                       String password,
                       String email) {
//    /**
//     * Returns a new UserData with the updated name.
//     */
//    public UserData rename(String newName) {
//        return new UserData(id, newName, type);
//    }
}
