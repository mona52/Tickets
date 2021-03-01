package ru.netology.domain;

public class NotFoundException extends RuntimeException {
    private String out;
    private String in;

    public String getOut() {
        return out;
    }

    public void setOut(String out) {
        this.out = out;
    }

    public String getIn() {
        return in;
    }

    public void setIn(String in) {
        this.in = in;
    }

    public NotFoundException(String out, String in) {
        this.out = out;
        this.in = in;
    }

    public NotFoundException(String message, String out, String in) {
        super(message);
        this.out = out;
        this.in = in;
    }

    public NotFoundException(String message, Throwable cause, String out, String in) {
        super(message, cause);
        this.out = out;
        this.in = in;
    }

    public NotFoundException(Throwable cause, String out, String in) {
        super(cause);
        this.out = out;
        this.in = in;
    }

    public NotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, String out, String in) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.out = out;
        this.in = in;
    }


}
