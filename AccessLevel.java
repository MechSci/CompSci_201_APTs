public class AccessLevel {
    public static String canAccess(int[] rights, int minPermission) {
        String accessList = "";
        for (int i : rights) {
            if(i >= minPermission){
                accessList += "A";
            }
            else{
                accessList += "D";
            }
        }
        return accessList;
    }
}
