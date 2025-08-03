module com.library {
    requires java.base;
    requires org.hibernate.orm.core;
    requires jakarta.persistence;

    exports com.library.domain.book;
    exports com.library.domain.borrow;
    exports com.library.domain.member;
}