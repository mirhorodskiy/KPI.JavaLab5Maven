package view;

import static view.ViewConstant.NO_SUCH_FLOWERS;

public class ShopView {

    public void printMessage(String message) {
        System.out.print(message);
    }

    public void printMessageAndResultList(String message, String value) {
        System.out.println(message);
        if (value.length() != 0) {
            System.out.println(value);
        } else {
            System.out.println(NO_SUCH_FLOWERS);
        }
    }
}
