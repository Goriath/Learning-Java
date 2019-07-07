module kfryc.db {
    requires java.sql;
    requires sqlite.jdbc;
    requires transitive kfryc.common;

    exports kfryc.db;
}