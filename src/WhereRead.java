public enum WhereRead {
    HOME("дома"),
    LIBRARY("в библиотеке");

    private String where;

    WhereRead(String where) {
        this.where = where;
    }

    public String getWhere() {
        return where;
    }
}
