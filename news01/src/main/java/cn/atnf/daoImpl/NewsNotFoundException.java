package cn.atnf.daoImpl;

public class NewsNotFoundException extends Exception {
    public NewsNotFoundException(String s) {
        super("News not found");

    }
}
