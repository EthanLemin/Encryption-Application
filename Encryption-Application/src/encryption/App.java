package encryption;

import encryption.controller.*;
import encryption.model.*;
import encryption.view.*;

public class App {

    public static void main(String[] args) {
        IEncryption model = new Encryption();
        View view = new View();
        Controller controller = new Controller(model, view);
        view.setVisible(true);
    }
}
