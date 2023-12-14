module common {
    requires jakarta.persistence;
    requires spring.data.jpa;
    opens com.layer.common to application;

    exports com.layer.common;

}