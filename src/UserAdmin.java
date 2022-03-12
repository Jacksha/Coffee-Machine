import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class UserAdmin {
    private static String username;
    private static String password;
    static String fileName;
    Scanner statusScan;

    // Constructor
    public UserAdmin(String fileName) {
        this.fileName = fileName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        UserAdmin.password = password;
    }

    // initialize credentials
    void initStatus() {
        try {
            statusScan = new Scanner(new FileReader("./doc/" + fileName));
            statusScan.nextLine();
            statusScan.nextLine();
            statusScan.useDelimiter("; |\n");
            String strHolder = statusScan.next();
            this.username = strHolder;
            strHolder = statusScan.next();
            this.password = strHolder;
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }
    }

    // check credentials
    boolean chckCred(String user, String pass) {
        if (this.username.equals(user) && this.password.equals(pass)) {
            return true;
        } else {
            return false;
        }
    }
}
